'''

name: validate.py
author: acbart
version: 2

The motivation behind a custom validator (as opposed to Rx or Voluptuous) is that
 we want to be able to collect warnings and errors without early termination.
 When debugging a long spec, it's likely that there will be multiple errors, and
 we don't want to have to crash on just the first one.

'''

from auxiliary import clean_json
from collections import namedtuple
import re
import sys

readable_types = {str : "String",
                  int : "Integer",
                  float : "Float",
                  list : "List",
                  dict : "Dictionary"}
             
### Error and warning messages

class PrintableObject(object):
    def __init__(self, **items):
        for key, value in items.items():
            setattr(self, key, value)

    def __repr__(self):
        args = ", ".join(["{}={}".format(k,v) for k,v in vars(self).items()])
        return self.__class__.__name__ + "("+args+")"

class Package(PrintableObject): pass
class Metadata(PrintableObject): pass
class Interface(PrintableObject): pass
class HTTP(PrintableObject): pass
class Local(PrintableObject): pass
class Object(PrintableObject): pass
class Field(PrintableObject): pass
class Function(PrintableObject): pass
class Input(PrintableObject): pass
class Implementation(PrintableObject): pass

def de_identifier(name):
    name = name.replace("_", " ").replace("-", " ")
    result = []
    for word in name.split(" "):
        if word and word[0].upper() == word[0]:
            word = word[0].lower() + word[1:]
        result.append(word)
    return " ".join(result)

class Compiler(object):
    
    def __init__(self, specification):
        self.specification = specification
        self.warnings = []
        self.errors = []
        self.package = None
        
    def run(self):
        self.walk_spec(self.specification)
        return self.package, self.warnings, self.errors
        
    # Warnings and errors
    
    def warning(self, message):
        self.warnings.append(message)
        
    def error(self, message):
        self.errors.append(message)

    def not_found_warning(self, key_name, additional=""):
        additional = " "+additional if additional else additional
        self.warning("Expected keyword {} not found.{}".format(key_name, additional))
        
    def not_found_error(self, key_name, additional=""):
        additional = " "+additional if additional else additional
        self.error("Expected keyword {} not found.{}".format(key_name, additional))
    
    def type_error(self, key_name, expected_type, got_type):
        self.error("Type Error for {}; expected {}, but got {}.".format(key_name, 
                                                                    readable_types.get(expected_type, expected_type), 
                                                                    readable_types.get(got_type, got_type)))
    
    def require_field(self, location, owner, error_value, test_type=None):
        name = location.split(".")[-1]
        if name in owner:
            if isinstance(test_type, set):
                typecheck = owner[name] in test_type
            else:
                typecheck = test_type is None or isinstance(owner[name], test_type)
            if not typecheck:
                self.type_error(location, test_type, type(owner[name]))
                return error_value
            return owner[name]
        else: 
            self.not_found_error(location)
            return error_value
        
    def recommend_field(self, location, owner, default_value, test_type=None, not_found=""):
        name = location.split(".")[-1]
        if name in owner:
            if isinstance(test_type, set):
                typecheck = owner[name] in test_type
            else:
                typecheck = test_type is None or isinstance(owner[name], test_type)
            if not typecheck:
                self.type_error(location, test_type, type(owner[name]))
                return default_value
            return owner[name]
        else: 
            self.not_found_warning(location, not_found)
            return default_value
            
    def typecheck_field(self, location, owner, default_value, test_type):
        name = location.split(".")[-1]
        if name in owner:
            if isinstance(test_type, set):
                typecheck = owner[name] in test_type
            else:
                typecheck = test_type is None or isinstance(owner[name], test_type)
            if not typecheck:
                self.type_error(location, test_type, type(owner[name]))
            else:
                return owner[name]
        return default_value
        
    ### Validations

    def walk_list(self, location, name, data, walk_element): 
        if name in data:
            if isinstance(data[name], dict):
                for element_name, element_data in data[name].iteritems():
                    yield walk_element(element_name, element_data, location)
            else:
                self.type_error(location, dict, type(spec[name]))
                
    def walk_metadata(self, raw):
        metadata = Metadata()
        metadata.name = self.require_field("metadata.name", raw, "Untitled", str)
        metadata.author = self.recommend_field("metadata.author", raw, '', str)
        metadata.datetime = self.typecheck_field("metadata.datetime", raw, '', str)
        metadata.version = self.recommend_field("metadata.version", raw, 1, int, "Assuming version is 1.")
        # TODO: Handle descriptions
        metadata.description = self.recommend_field("metadata.description", raw, {}, dict, "There will be no top-level documentation!")
        # TODO: Handle appendix
        metadata.tags = self.recommend_field("metadata.tags", raw, [], list)
        return metadata
            
    def walk_enum(self, name, data, location):
        if isinstance(data, list):
            for index, enum_element in enumerate(data):
                if not isinstance(enum_element, str):
                    self.type_error("enums.{}[{}]".format(name, index), str, type(enum_element))
        else:
            self.type_error("enums.{}".format(name), list, type(data))

    def walk_enums(self, spec):
        self.walk_list("enums", "enums", spec, self.walk_enum)
        
    def walk_field(self, name, data, location):
        location = "{}.{}".format(location, name)
        if isinstance(data, dict):
            self.require_field("type", "{}.type".format(location), data, str)
            self.require_field("path", "{}.path".format(location), data, str)
            self.recommend_field("description", "{}.description".format(location), 
                            data, str, not_found="There will be no documentation for {}!".format(location))
            self.typecheck_field("comment", "{}.comment".format(location), data, str)
        else:
            self.type_error(location, dict, type(data))
        
    def walk_object(self, name, data, location):
        location = "{}.{}".format(location, name)
        if isinstance(data, dict):
            self.recommend_field("description", 
                            "objects.{}.description".format(name),
                            data, str, not_found="There will be no documentation for {}!".format(name))
            self.recommend_field("format", "{}.format".format(location), data, set(("json", "xml", "html", "csv", "text")), not_found="Assuming json.")
            self.typecheck_field("comment", "{}.comment".format(location), data, str)
            if "fields" in data:
                if data["fields"]:
                    self.walk_list("objects.{}.fields".format(name), "fields", data, self.walk_field)
                else:
                    self.error("Expected at least one field for objects.{}.fields".format(name))
            else: 
                self.not_found_error("objects.{}.fields".format(name))
        else:
            self.type_error("objects.{}".format(name), dict, type(data))
        
    def walk_objects(self, spec):
        self.walk_list("objects", "objects", spec, self.walk_object)
        
    def walk_input(self, name, data, location):
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
            self.type_error(location, dict, type(data))
            
    def walk_implementation(self, name, data, location):
        implementation = Implementation()
        location = "{}.{}".format(location, name)
        
        return 
        
    def walk_interface(self, name, data, location):
        interface = Interface()
        location = "{}.{}".format(location, name)
        '''- name: get songs
    returns: list
    test:
        sql: SELECT data FROM music LIMIT {hardware}
    production:
        sql: SELECT data FROM music
  - name: get song by name
    args:
      - name: title
        type: string
    returns: dict
    production:
        sql: SELECT data FROM music WHERE index={title} LIMIT 1'''
        if isinstance(data, dict):
            self.require_field("name", "{}.name".format(location), data, str)
            interface.name = de_identifier(data.get("name", ""))
            
            self.require_field("returns", "{}.returns".format(location), data, str)
            interface.returns = de_identifier(data.get("returns", ""))
            
            self.require_field("production", "{}.production".format(location), data, str)
            interface.production = de_identifier(data.get("returns", ""))
            
        else:
            self.type_error(location, dict, type(data))
        return interface
        '''
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
                self.walk_list("{}.inputs".format(location), "inputs", data, self.walk_input)
                # Ensure that every url has the requsite paths!
                if "url" in data:
                    url_input_names = set(map(str, re.findall("<(.*?)>", data["url"])))
                    given_input_names = set([input['path'] for input in data["inputs"].values() if 'path' in input])
                    if not url_input_names.issubset(given_input_names):
                        self.error("Expected full list of url parameters {} for {}, given only {}.".format(list(url_input_names), location, list(given_input_names)))
                    
        else:
            self.type_error(location, dict, type(data))
        return interface'''

    def walk_interfaces(self, spec):
        return self.walk_list("functions", "functions", spec, self.walk_interface)
        
    def walk_spec(self, spec):
        self.package = Package()
        # Metadata
        if "metadata" in spec:
            self.package.metadata = self.walk_metadata(spec["metadata"])
        else:
            self.not_found_error("metadata")
        
        # Interfaces
        if "interfaces" in spec:
            self.package.interfaces = self.walk_interfaces(spec["interfaces"])
        else:
            self.not_found_error("interfaces")
