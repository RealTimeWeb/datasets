import json
import sys
from itertools import tee, izip
from urlparse import urlparse
from urllib import quote_plus, urlencode
from textwrap import wrap
from collections import OrderedDict
from auxiliary import to_dict, camel_case_caps, camel_case
from auxiliary import snake_case, kebab_case, flat_case, copy_file
import re
from jinja2 import Environment, FileSystemLoader
templates = 'templates/python/'
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

conversion_mapping = { ("string", "integer") : "",
                       ("string", "float") : "",
                       ("string", "string") : "",
                       ("string", "boolean") : "",
                       ("string", "long") : "",
                       ("long", "string") : "str",
                       ("boolean", "string") : "str",
                       ("integer", "string") : "str",
                       ("float", "string") : "str"}
                  
python_types = {"string": "str",
                "float": "float",
                "integer": "int",
                "void": "void",
                "boolean": "boolean",
                "long": "int"}

def parse_json_path(path, result="json_data"):
    elements = []
    for keys in path.split("."):
        while keys:
            left, sep, keys = keys.partition("[")
            val, sep, keys = keys.partition("]")
            if left:
                elements.append(left)
            if val:
                elements.append(int(val))
    if elements:
        for item in elements:
            if isinstance(item, str):
                result = "{}['{}']".format(result, item)
            else:
                result = "{}[{}]".format(result, item)
    return result

def convert_url_parameters(url):
    return re.sub("<.*?>","{}",url)

def is_builtin(type):
    return type in python_types.keys()

def collect_url_parameters(url):
    return map(str, re.findall("<(.*?)>", url))
    
def is_list(type):
    return type.endswith("[]")

def strip_list(type):
    return type[:-2]

def create_json_conversion(data, type):
    if is_list(type):
        type = strip_list(type)
    if type in json_conversion:
        return "{}({}.toString())".format(json_conversion[type], data)
    elif type == "string":
        return "{}.toString()".format(data)
    else:
        return "new {}((Map<String, Object>){})".format(camel_case_caps(type), data)

def convert_builtin(data, type):
    if type == "string":
        return data
    else:
        return '_parse_{}({})'.format(python_types[type], data)

def create_xml_conversion(data, type):
    if is_list(type):
        type = strip_list(type)
    if type in xml_conversions:
        return "{}"
    else:
        return xml_conversion[type]
                    
def convert_to_python_type(source):
    was_list = is_list(source)
    if was_list:
        source = strip_list(source) #chomp out the "list(" and ")"
    converted_type= python_types.get(source, None)
    if converted_type is None: # need to convert to custom class
        converted_type = camel_case_caps(source)
    if was_list: # if it's a list, apply it to each element
        return "list of {}".format(converted_type)
    else: # otherwise just return it normally
        return converted_type
        
def convert_to_string(source, type):
    if type in racket_conversions:
        return "({} {})".format(racket_conversions[type], source)
    else:
        return source

def requests_verb(verb):
    if verb == "get":
        return "params"
    elif verb == "post":
        return "data"
    else:
        return "data"

env.filters['to_python_type'] = convert_to_python_type
env.filters['convert_url_parameters'] = convert_url_parameters
#env.filters['collect_url_parameters'] = collect_url_parameters
env.filters['is_builtin'] = is_builtin
env.filters['is_list'] = is_list
env.filters['strip_list'] = strip_list
env.filters['parse_json_path'] = parse_json_path
env.filters['convert_to_string'] = convert_to_string
env.filters['requests_verb'] = requests_verb
#env.filters['create_json_conversion'] = create_json_conversion
#env.filters['create_xml_conversion'] = create_xml_conversion
env.filters['convert_builtin'] = convert_builtin

def build_metafiles(model):
    return {'python/docs/conf.py': env.get_template('conf.py',globals=model).render(),
            'python/docs/index.rst': env.get_template('index.rst',globals=model).render(),
            'python/docs/make.bat': env.get_template('make.bat').render(),
            'python/docs/__init__.py': env.get_template('__init__.py', globals=model).render(),
            'python/tests/__init__.py': env.get_template('__init__.py', globals=model).render(),
            'python/tests/test.py': env.get_template('test.py', globals=model).render()}
    
def build_main(model):
    name = model['metadata']['name']
    return {'python/' + flat_case(name) + '/' + flat_case(name) + '.py' :
                env.get_template('main.py', globals=model).render(),
            'python/' + flat_case(name) + '/__init__.py' :
                env.get_template('__init__.py', globals=model).render()}

def build_python(model):
    files = {}
    files.update(build_metafiles(model))
    files.update(build_main(model))
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
        files = build_python(to_dict(new_package))
        from build import build_dir
        build_dir(files, sys.argv[2])
    else:
        for error in errors:
            print "Error!", error
