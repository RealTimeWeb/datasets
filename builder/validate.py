from itertools import chain
from auxiliary import clean_json
import re
import sys
# validate spec

readable_types = {str : "String",
                  int : "Integer",
                  float : "Float",
                  list : "List",
                  dict : "Dictionary"}
             
### Error and warning messages

def keyword_not_found(key_name, additional=""):
    additional = " "+additional if additional else additional
    return "Expected keyword {} not found.{}".format(key_name, additional)
        
def type_error(key_name, expected_type, got_type):
    return "Type Error for {}; expected {}, but got {}.".format(key_name, 
                                                                readable_types.get(expected_type, expected_type), 
                                                                readable_types.get(got_type, got_type))

def require_field(warning, error, name, location, owner, test_type=None):
    if name in owner:
        if isinstance(test_type, set):
            typecheck = owner[name] in test_type
        else:
            typecheck = test_type is None or isinstance(owner[name], test_type)
        if not typecheck:
            error(type_error(location, test_type, type(owner[name])))
    else: 
        error(keyword_not_found(location))
    
def recommend_field(warning, error, name, location, owner, test_type=None, not_found=""):
    if name in owner:
        if isinstance(test_type, set):
            typecheck = owner[name] in test_type
        else:
            typecheck = test_type is None or isinstance(owner[name], test_type)
        if not typecheck:
            error(type_error(location, test_type, type(owner[name])))
    else: 
        warning(keyword_not_found(location, not_found))
        
def typecheck_field(warning, error, name, location, owner, test_type):
    if name in owner:
        if isinstance(test_type, set):
            typecheck = owner[name] in test_type
        else:
            typecheck = test_type is None or isinstance(owner[name], test_type)
        if not typecheck:
            error(type_error(location, test_type, type(owner[name])))
    
### Validations

def validate_list(location, name, data, validate_element, warning, error): 
    if name in data:
        if isinstance(data[name], dict):
            for element_name, element_data in data[name].iteritems():
                validate_element(element_name, element_data, warning, error, location)
        else:
            error(type_error(location, dict, type(spec[name])))
            
def validate_metadata(spec, warning, error):
    if "metadata" in spec:
        metadata = spec["metadata"]
        require_field(warning, error, "name", "metadata.name", metadata, str)
        recommend_field(warning, error, "author", "metadata.author", metadata, str)
        recommend_field(warning, error, "contact", "metadata.contact", metadata, str)
        recommend_field(warning, error, "version", "metadata.version", metadata, not_found="Assuming version is 1.0.")
        recommend_field(warning, error, "description", "metadata.description", metadata, str, not_found="There will be no top-level documentation!")
        typecheck_field(warning, error, "comment", "metadata.comment", metadata, str)
    else:
        error(keyword_not_found("metadata"))
        
def validate_enum(name, data, warning, error, location):
    if isinstance(data, list):
        for index, enum_element in enumerate(data):
            if not isinstance(enum_element, str):
                error(type_error("enums.{}[{}]".format(name, index), str, type(enum_element)))
    else:
        error(type_error("enums.{}".format(name), list, type(data)))

def validate_enums(spec, warning, error):
    validate_list("enums", "enums", spec, validate_enum, warning, error)
    
def validate_field(name, data, warning, error, location):
    location = "{}.{}".format(location, name)
    if isinstance(data, dict):
        require_field(warning, error, "type", "{}.type".format(location), data, str)
        require_field(warning, error, "path", "{}.path".format(location), data, str)
        recommend_field(warning, error, "description", "{}.description".format(location), 
                        data, str, not_found="There will be no documentation for {}!".format(location))
        typecheck_field(warning, error, "comment", "{}.comment".format(location), data, str)
    else:
        error(type_error(location, dict, type(data)))
    
def validate_object(name, data, warning, error, location):
    location = "{}.{}".format(location, name)
    if isinstance(data, dict):
        recommend_field(warning, error, 
                        "description", 
                        "objects.{}.description".format(name),
                        data, str, not_found="There will be no documentation for {}!".format(name))
        recommend_field(warning, error, "format", "{}.format".format(location), data, set(("json", "xml", "html", "csv", "text")), not_found="Assuming json.")
        typecheck_field(warning, error, "comment", "{}.comment".format(location), data, str)
        if "fields" in data:
            if data["fields"]:
                validate_list("objects.{}.fields".format(name), "fields", data, validate_field, warning, error)
            else:
                error("Expected at least one field for objects.{}.fields".format(name))
        else: 
            error(keyword_not_found("objects.{}.fields".format(name)))
    else:
        error(type_error("objects.{}".format(name), dict, type(data))) 
    
def validate_objects(spec, warning, error):
    validate_list("objects", "objects", spec, validate_object, warning, error)
    
def validate_input(name, data, warning, error, location):
    location = "{}.{}".format(location, name)
    if isinstance(data, dict):
        require_field(warning, error, "path", "{}.path".format(location), data, str)
        require_field(warning, error, "type", "{}.type".format(location), data, str)
        typecheck_field(warning, error, "comment", "{}.comment".format(location), data, str)
        recommend_field(warning, error, 
                        "description", 
                        "functions.{}.description".format(location),
                        data, str, not_found="There will be no documentation for {}!".format(name))
        recommend_field(warning, error, "indexed", "{}.indexed".format(location), 
                        data, bool,
                        not_found = "{}.indexed will default to true.".format(name))
        recommend_field(warning, error, "hidden", "{}.hidden".format(location), 
                        data, bool,
                        not_found = "{}.hidden will default to false.".format(name))
    else:
        error(type_error(location, dict, type(data))) 
    
def validate_function(name, data, warning, error, location):
    location = "{}.{}".format(location, name)
    if isinstance(data, dict):
        require_field(warning, error, "url", "{}.url".format(location), data, str)
        require_field(warning, error, "verb", "{}.verb".format(location), data, set(("get", "post", "delete", "put")))
        recommend_field(warning, error, "format", "{}.format".format(location), data, set(("json", "xml", "html", "csv", "text")), not_found="Assuming json.")
        require_field(warning, error, "output", "{}.output".format(location), data, str)
        #recommend_field(warning, error, "loop", "{}.loop".format(location), 
        #                data, set(("repeat", "restart", "empty")),
        #                not_found = "{}.loop will default to repeat.".format(name))
        recommend_field(warning, error, 
                        "description", 
                        "{}.description".format(name),
                        data, str, not_found="There will be no documentation for {}!".format(name))
        typecheck_field(warning, error, "comment", "{}.comment".format(location), data, str)
        if "inputs" in data:
            validate_list("{}.inputs".format(location), "inputs", data, validate_input, warning, error)
            # Ensure that every url has the requsite paths!
            if "url" in data:
                url_input_names = set(map(str, re.findall("<(.*?)>", data["url"])))
                given_input_names = set([input['path'] for input in data["inputs"].values() if 'path' in input])
                if not url_input_names.issubset(given_input_names):
                    error("Expected full list of url parameters {} for {}, given only {}.".format(list(url_input_names), location, list(given_input_names)))
                
    else:
        error(type_error(location, dict, type(data))) 

def validate_functions(spec, warning, error):
    validate_list("functions", "functions", spec, validate_function, warning, error)
    
def validate_spec(spec):
    """
    Returns a list of warnings and a list of errors
    """
    # Abuse state to hold warnings and errors in lists accessed simply
    warnings, errors = [], []
    def add_warning(message): warnings.append(message)
    def add_error(message): errors.append(message)
    
    if "metadata" in spec:
        validate_metadata(spec, add_warning, add_error)
    else:
        add_error(keyword_not_found("metadata"))
    if "objects" in spec:
        validate_objects(spec, add_warning, add_error)
    else:
        add_error(keyword_not_found("objects"))
    validate_enums(spec, add_warning, add_error)
    if "functions" in spec:
        validate_functions(spec, add_warning, add_error)
    else:
        add_error(keyword_not_found("functions"))
    return warnings, errors
    
if __name__ == "__main__":
    import json
    input = clean_json(json.load(open(sys.argv[1],'r')))
    warnings, errors = validate_spec(input)
    for warning in warnings:
        print "Warning!", warning
    for error in errors:
        print "Error!", error
        
