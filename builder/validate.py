'''

name: validate.py
author: acbart
version: 2

The motivation behind a custom validator (as opposed to Rx or Voluptuous) is that
 we want to be able to collect warnings and errors without early termination.
 When debugging a long spec, it's likely that there will be multiple errors, and
 we don't want to have to crash on just the first one.

'''

from itertools import chain
from auxiliary import clean_json
import re
import sys

readable_types = {str : "String",
                  int : "Integer",
                  float : "Float",
                  list : "List",
                  dict : "Dictionary"}
             
### Error and warning messages

class SpecValidator(object):
    
    def __init__(self, specification):
        self.specification = specification
        self.warnings = []
        self.errors = []
    
    def warning(self, message):
        self.warnings.append(message)
        
    def error(self, message):
        self.errors.append(message)
    
    def run(self):
        validate_spec(self.specification)
        return warnings, errors

    @staticmethod
    def keyword_not_found(key_name, additional=""):
        additional = " "+additional if additional else additional
        return "Expected keyword {} not found.{}".format(key_name, additional)
    
    def type_error(key_name, expected_type, got_type):
        self.error("Type Error for {}; expected {}, but got {}.".format(key_name, 
                                                                    readable_types.get(expected_type, expected_type), 
                                                                    readable_types.get(got_type, got_type)))
    
    def require_field(self, name, location, owner, test_type=None):
        if name in owner:
            if isinstance(test_type, set):
                typecheck = owner[name] in test_type
            else:
                typecheck = test_type is None or isinstance(owner[name], test_type)
            if not typecheck:
                self.type_error(location, test_type, type(owner[name]))
        else: 
            self.error(self.keyword_not_found(location))
        
    def recommend_field(self, name, location, owner, test_type=None, not_found=""):
        if name in owner:
            if isinstance(test_type, set):
                typecheck = owner[name] in test_type
            else:
                typecheck = test_type is None or isinstance(owner[name], test_type)
            if not typecheck:
                self.type_error(location, test_type, type(owner[name]))
        else: 
            self.warning(self.keyword_not_found(location, not_found))
            
    def typecheck_field(self, name, location, owner, test_type):
        if name in owner:
            if isinstance(test_type, set):
                typecheck = owner[name] in test_type
            else:
                typecheck = test_type is None or isinstance(owner[name], test_type)
            if not typecheck:
                self.type_error(location, test_type, type(owner[name]))
        
    ### Validations

    def validate_list(self, location, name, data, validate_element): 
        if name in data:
            if isinstance(data[name], dict):
                for element_name, element_data in data[name].iteritems():
                    self.validate_element(element_name, element_data, location)
            else:
                self.type_error(location, dict, type(spec[name]))
                
    def validate_metadata(self, metadata):
        '''version: 1
        name: Music
        builder: Python
        author: Austin Cory Bart <acbart@vt.edu>
        datetime: 9/23/2015
        tags: music, songs, artists, creativity, media
        description:
            overview: >
                The Music library is all about some interesting music data.\n
                This is multiple lines long.
            users: >
                This is some additional information that users would be interested in having. Like maybe they didn't realize it.
            developers: >
                This is some information that developers would be interested in. Like maybe an oddity in the structure.
            citation: This is some citation data. It is meant to be embeddable.
        appendix:
          - name: Extra guide
            file: notes.txt'''
        self.require_field("name", "metadata.name", metadata, str)
        self.recommend_field("author", "metadata.author", metadata, str)
        self.recommend_field("contact", "metadata.contact", metadata, str)
        self.recommend_field("version", "metadata.version", metadata, not_found="Assuming version is 1.0.")
        self.recommend_field("description", "metadata.description", metadata, str, not_found="There will be no top-level documentation!")
        self.typecheck_field("comment", "metadata.comment", metadata, str)
            
    def validate_enum(self, name, data, location):
        if isinstance(data, list):
            for index, enum_element in enumerate(data):
                if not isinstance(enum_element, str):
                    self.type_error("enums.{}[{}]".format(name, index), str, type(enum_element))
        else:
            self.type_error("enums.{}".format(name), list, type(data))

    def validate_enums(self, spec):
        self.validate_list("enums", "enums", spec, self.validate_enum, warning, error)
        
    def validate_field(self, name, data, location):
        location = "{}.{}".format(location, name)
        if isinstance(data, dict):
            self.require_field("type", "{}.type".format(location), data, str)
            self.require_field("path", "{}.path".format(location), data, str)
            self.recommend_field("description", "{}.description".format(location), 
                            data, str, not_found="There will be no documentation for {}!".format(location))
            self.typecheck_field("comment", "{}.comment".format(location), data, str)
        else:
            self.type_error(location, dict, type(data))
        
    def validate_object(self, name, data, location):
        location = "{}.{}".format(location, name)
        if isinstance(data, dict):
            self.recommend_field("description", 
                            "objects.{}.description".format(name),
                            data, str, not_found="There will be no documentation for {}!".format(name))
            self.recommend_field("format", "{}.format".format(location), data, set(("json", "xml", "html", "csv", "text")), not_found="Assuming json.")
            self.typecheck_field("comment", "{}.comment".format(location), data, str)
            if "fields" in data:
                if data["fields"]:
                    self.validate_list("objects.{}.fields".format(name), "fields", data, self.validate_field)
                else:
                    self.error("Expected at least one field for objects.{}.fields".format(name))
            else: 
                self.error(self.keyword_not_found("objects.{}.fields".format(name)))
        else:
            self.type_error("objects.{}".format(name), dict, type(data)))
        
    def validate_objects(self, spec):
        self.validate_list("objects", "objects", spec, self.validate_object)
        
    def validate_input(self, name, data, location):
        location = "{}.{}".format(location, name)
        if isinstance(data, dict):
            self.require_field("path", "{}.path".format(location), data, str)
            self.require_field("type", "{}.type".format(location), data, str)
            self.typecheck_field("comment", "{}.comment".format(location), data, str)
            self.recommend_field("description", 
                            "functions.{}.description".format(location),
                            data, str, not_found="There will be no documentation for {}!".format(name))
            self.recommend_field("indexed", "{}.indexed".format(location), 
                            data, bool,
                            not_found = "{}.indexed will default to true.".format(name))
            self.recommend_field("hidden", "{}.hidden".format(location), 
                            data, bool,
                            not_found = "{}.hidden will default to false.".format(name))
        else:
            self.type_error(location, dict, type(data)))
        
    def validate_function(self, name, data, location):
        location = "{}.{}".format(location, name)
        if isinstance(data, dict):
            self.require_field("url", "{}.url".format(location), data, str)
            self.require_field("verb", "{}.verb".format(location), data, set(("get", "post", "delete", "put")))
            self.recommend_field("format", "{}.format".format(location), data, set(("json", "xml", "html", "csv", "text")), not_found="Assuming json.")
            self.require_field("output", "{}.output".format(location), data, str)
            self.recommend_field(
                            "description", 
                            "{}.description".format(name),
                            data, str, not_found="There will be no documentation for {}!".format(name))
            self.typecheck_field("comment", "{}.comment".format(location), data, str)
            if "inputs" in data:
                self.validate_list("{}.inputs".format(location), "inputs", data, self.validate_input)
                # Ensure that every url has the requsite paths!
                if "url" in data:
                    url_input_names = set(map(str, re.findall("<(.*?)>", data["url"])))
                    given_input_names = set([input['path'] for input in data["inputs"].values() if 'path' in input])
                    if not url_input_names.issubset(given_input_names):
                        self.error("Expected full list of url parameters {} for {}, given only {}.".format(list(url_input_names), location, list(given_input_names)))
                    
        else:
            self.type_error(location, dict, type(data))

    def validate_functions(self, spec):
        self.validate_list("functions", "functions", spec, validate_function)
        
    def validate_spec(self, spec):
        # Metadata
        if "metadata" in spec:
            self.validate_metadata(spec["metadata"])
        else:
            self.error(self.keyword_not_found("metadata"))
            
        if "objects" in spec:
            self.validate_objects(spec["objects"])
        else:
            self.error(self.keyword_not_found("objects"))
        self.validate_enums(spec)
        if "functions" in spec["functions"]:
            self.validate_functions(spec)
        else:
            self.error(self.keyword_not_found("functions"))
    
if __name__ == "__main__":
    import json
    input = clean_json(json.load(open(sys.argv[1],'r')))
    warnings, errors = validate_spec(input)
    for warning in warnings:
        print "Warning!", warning
    for error in errors:
        print "Error!", error
        
