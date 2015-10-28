import json
import sys
from itertools import tee, izip
from urlparse import urlparse
from urllib import quote_plus, urlencode
from textwrap import wrap
from collections import OrderedDict
from auxiliary import to_dict, camel_case_caps, camel_case
from auxiliary import snake_case, kebab_case, flat_case
import re
from jinja2 import Environment, FileSystemLoader
templates = 'templates/java/'
env = Environment(loader=FileSystemLoader(templates))
env.filters['camel_case_caps'] = camel_case_caps
env.filters['camel_case'] = camel_case
env.filters['snake_case'] = snake_case
env.filters['kebab_case'] = kebab_case
env.filters['flat_case'] = flat_case

def pairwise(iterable):
    "s -> (s0,s1), (s1,s2), (s2, s3), ..."
    a, b = tee(iterable)
    next(b, None)
    return izip(a, b)

conversion_mapping = { ("string", "integer") : "Integer.parseInt",
                       ("string", "float") : "Double.parseDouble",
                       ("string", "long") : "Long.parseLong",
                       ("string", "string") : "",
                       ("string", "boolean") : "Boolean.parseBoolean",
                       ("integer", "string") : "Integer.toString",
                       ("long", "string") : "Long.toString",
                       ("float", "string") : "Double.toString",
                       ("boolean", "string") : "Boolean.toString"}
                       
json_conversion = { "integer" : "Integer.parseInt",
                     "float" : "Double.parseDouble",
                     "boolean" : "Boolean.parseBoolean",
                     "long" : "Long.parseLong"}
xml_conversion = { "integer" : "XPathConstants.NUMBER",
                   "float" : "XPathConstants.NUMBER",
                   "boolean" : "XPathConstants.BOOLEAN",
                   "long" : "XPathConstants.NUMBER",
                   "string" : "XPathConstants.STRING"}
                     
java_type_names = { "string" : "String",
                    "integer" : "Integer",
                    "float" : "Double",
                    "boolean" : "Boolean",
                    "long": "Long"}

gson_conversions = { "string" : "getAsString",
                     "integer" : "getAsInt",
                     "float" : "getAsDouble",
                     "boolean" : "getAsBoolean",
                     "long" : "getAsLong"}

def parse_json_path(path, result="raw"):
    elements = []
    for keys in path.split("."):
        while keys:
            left, sep, keys = keys.partition("[")
            val, sep, keys = keys.partition("]")
            if left:
                elements.append('"{}"'.format(left))
            if val:
                elements.append(int(val))
    if elements:
        for item in elements[:-1]:
            if isinstance(item, str):
                result = '((Map<String, Object>) {}.get({}))'.format(result, item)
            else:
                result = '((List<Object>) {}.get({}))'.format(result, item)
        result = '{}.get({})'.format(result, elements[-1])
    return result
    
def parse_json_path_all(path, result="raw"):
    elements = []
    for keys in path.split("."):
        while keys:
            left, sep, keys = keys.partition("[")
            val, sep, keys = keys.partition("]")
            if left:
                elements.append('"{}"'.format(left))
            if val:
                elements.append(int(val))
    if elements:
        for item in elements:
            if isinstance(item, str):
                result = '((Map<String, Object>) {}).get({})'.format(result, item)
            else:
                result = '((ArrayList<Object>) {}).get({})'.format(result, item)
    return result

def convert_url_parameters(url):
    return re.sub("<.*?>","%s",url)

def is_builtin(type):
    return type in java_type_names.keys()

def collect_url_parameters(url):
    return map(str, re.findall("<(.*?)>", url))
    
def is_list(type):
    return type.endswith("[]")

def strip_list(type):
    return type[:-2]

def create_json_conversion(data, type, is_map=True):
    if is_list(type):
        type = strip_list(type)
    if type in json_conversion:
        return "{}({}.toString())".format(json_conversion[type], data)
    elif type == "string":
        return "{}.toString()".format(data)
    elif is_map:
        return "new {}((Map<String, Object>){})".format(camel_case_caps(type), data)
    else:
        return "new {}((List<Object>){})".format(camel_case_caps(type), data)

def convert_builtin(type):
    if type == "string":
        return ""
    else:
        return json_conversion[type]

def create_xml_conversion(data, type):
    if is_list(type):
        type = strip_list(type)
    if type in xml_conversions:
        return "{}"
    else:
        return xml_conversion[type]
                    
def convert_to_java_type(source_type):
    was_list = is_list(source_type)
    if was_list:
        source_type = strip_list(source_type) #chomp out the "list(" and ")"
    target_type = java_type_names.get(source_type, camel_case_caps(source_type))
    if was_list: # if it's a list, apply it to each element
        return "ArrayList<{}>".format(target_type)
    else: # otherwise just return it normally
        return target_type
    
def make_array(object_map, type):
    if type in object_map and not object_map[type]:
        return "Array"
    else:
        return ""
        
def enforce_json_array(root, post):
    if post == "" or post.startswith("["):
        return root + "Array()"
    else:
        return root + "()"
    

env.filters['to_java_type'] = convert_to_java_type
env.filters['convert_url_parameters'] = convert_url_parameters
env.filters['collect_url_parameters'] = collect_url_parameters
env.filters['is_builtin'] = is_builtin
env.filters['is_list'] = is_list
env.filters['strip_list'] = strip_list
env.filters['parse_json_path'] = parse_json_path
env.filters['parse_json_path_all'] = parse_json_path_all
env.filters['create_json_conversion'] = create_json_conversion
env.filters['create_xml_conversion'] = create_xml_conversion
env.filters['convert_builtin'] = convert_builtin
env.filters['make_array'] = make_array
env.filters['enforce_json_array'] = enforce_json_array

def build_metafiles(model):
    return {'java/.classpath': env.get_template('.classpath',globals=model).render(),
            'java/.project': env.get_template('.project',globals=model).render(),
            'java/build.xml': env.get_template('build.xml', globals=model).render()}
    
def build_main(model):
    name = model['metadata']['name']
    root = 'java/src/realtimeweb/' + flat_case(name) + '/'
    return {root + camel_case_caps(name) + '.java' :
                env.get_template('main.java', globals=model).render()}

def build_classes(model):
    name = model['metadata']['name']
    root = 'java/src/realtimeweb/' + flat_case(name) + '/domain/'
    files = {}
    template = env.get_template('domain.java', globals={'object_is_map' : model["object_is_map"], 'metadata': model['metadata']})
    for object in model['objects']:
        filename = root + camel_case_caps(object['name']) + '.java'
        files[filename] = template.render(object=object)
    return files
                
def copy_file(filename):
    with open(filename, 'rb') as input:
        return input.read()

def build_java(model):
    files = {'java/libs/StickyWeb-doc-2.5.jar' : copy_file(templates+'libs/StickyWeb-doc-2.5.jar')}
    files.update(build_metafiles(model))
    files.update(build_main(model))
    files.update(build_classes(model))
    return files
    
if __name__ == "__main__":
    import json
    from auxiliary import clean_json
    input = clean_json(json.load(open(sys.argv[1],'r')))
    from validate import validate_spec
    warnings, errors = validate_spec(input)
    for warning in warnings:
        print "Warning!", warning
    if not errors:
        from compile import compile_spec
        new_package = compile_spec(input)
        files = build_java(to_dict(new_package))
        from build import build_dir
        build_dir(files, sys.argv[2])
    else:
        for error in errors:
            print "Error!", error
