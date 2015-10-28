from validate import validate_spec
from auxiliary import clean_json
import re
import sys
from itertools import chain
                       
def flatten_list(a_type):
    if a_type.endswith("[]"):
        return flatten_list(a_type[:-2])
    else:
        return a_type
        
def de_identifier(name):
    name = name.replace("_", " ").replace("-", " ")
    result = []
    for word in name.split(" "):
        if word and word[0].upper() == word[0]:
            word = word[0].lower() + word[1:]
        result.append(word)
    return " ".join(result)
        
class Metadata(object): pass
class Enum(object): pass
class Package(object): pass
class Object(object): pass
class Field(object): pass
class Function(object): pass
class Input(object): pass

def compile_metadata(data):
    metadata = Metadata()
    metadata.name = de_identifier(data["name"])
    metadata.author = data.get("author", "Anonymous")
    metadata.contact = data.get("contact", "")
    metadata.version = data.get("version", 1.0)
    metadata.description = data.get("description", "")
    metadata.comment = data.get("comment", "")
    return metadata
    
def compile_enum(name, data):
    enum = Enum()
    enum.name = de_identifier(name)
    enum.values = de_identifier(data)
    return enum
    
def compile_field(name, data):
    field = Field()
    field.name = de_identifier(name)
    field.type = de_identifier(data["type"])
    field.path = data["path"]
    if "order" in data:
        field.order = data["order"]
    else:
        field.order = None
    field.description = data.get("description", "")
    field.comment = data.get("comment", "")
    return field
    
def compile_object(name, data):
    obj = Object()
    obj.name = de_identifier(name)
    obj.description = data.get("description", "")
    obj.comment = data.get("comment", "")
    obj.format = data.get("format", "json").lower()
    obj.fields = [compile_field(*data) for data in data["fields"].iteritems()]
    # We arbitrarily assume no one tries to make 1000 fields
    obj.fields.sort(key=lambda field : field.order if field.order is not None else 1000)
    if obj.fields:
        # Technically should be an error to have a class with no fields
        obj.is_map = not bool(obj.fields[0].path.startswith("["))
    else:
        obj.is_map = True
    obj.dependencies = set([flatten_list(field.type)
                                for field in obj.fields 
                                    if flatten_list(obj.name) != flatten_list(field.type)])
    return obj
    
def compile_input(name, data):
    input = Input()
    input.name = de_identifier(name)
    input.type = de_identifier(data["type"])
    input.path = data["path"]
    input.description = data.get("description", "")
    input.comment = data.get("comment", "")
    input.indexed = data.get("indexed", True)
    input.hidden = data.get("hidden", False)
    input.default = data.get("default", None)
    if "order" in data:
        input.order = data["order"]
    else:
        input.order = None
    return input
    
def compile_function(name, data):
    function = Function()
    function.name = de_identifier(name)
    function.url = data["url"]
    url_input_names = map(str, re.findall("<(.*?)>", function.url))
    function.verb = data["verb"].lower()
    function.format = data.get("format", "json").lower()
    function.output = de_identifier(data["output"])
    function.description = data.get("description", "")
    function.comment = data.get("comment", "")
    function.post = data.get("post", "")
    function.authentication = data.get("authentication", None)
    if "inputs" in data:
        inputs = [compile_input(*data) for data in data["inputs"].iteritems()]
    else:
        inputs = []
    inputs.sort(key=lambda input : input.order if input.order is not None else 1000)
    # Ensure the url arguments are in the proper order - None indicates missing argument!
    function.visible_inputs = [input for input in inputs if not input.hidden]
    function.indexed_inputs = [input for input in inputs if input.indexed]
    function.url_inputs = [next((i for i in inputs if i.path == input), None) for input in url_input_names]
    function.payload_inputs = [input for input in inputs if input.path not in url_input_names]
    function.dependencies = set([flatten_list(input.type) for input in inputs] + [flatten_list(function.output)])
    return function

def compile_spec(spec):
    package = Package()
    package.metadata = compile_metadata(spec["metadata"])
    if "enums" in spec:
        package.enums = [compile_enum(*data) for data in spec["enums"].iteritems()]
    else:
        package.enums = []
    if "objects" in spec:
        package.objects = [compile_object(*data) for data in spec["objects"].iteritems()]
    else:
        package.objects = []
    package.functions = [compile_function(*data) for data in spec["functions"].iteritems()]
    package.formats_required = set(function.format for function in package.functions)
    package.object_is_map = {obj.name : obj.is_map for obj in package.objects}
    #package.dependencies = chain(*[function.dependencies for function in package.functions],
    #                             *[obj.dependencies for obj in package.objects])
    return package
    
if __name__ == "__main__":
    import json
    input = clean_json(json.load(open(sys.argv[1],'r')))
    new_package = compile_spec(input)

