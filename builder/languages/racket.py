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
templates = 'templates/racket/'
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

racket_conversions = {"float": "number->string",
                      "long": "number->string",
                      "integer": "number->string",
                      "boolean": "boolean->string"}
                  
racket_types = {"string": "string",
                "float": "number",
                "long": "number",
                "integer": "number",
                "void": "void",
                "boolean": "boolean"}

def parse_json_path(path):
    elements = []
    for keys in path.split("."):
        while keys:
            left, sep, keys = keys.partition("[")
            val, sep, keys = keys.partition("]")
            if left:
                elements.append("'{}".format(left))
            if val:
                elements.append(int(val))
    result = "jdata"
    if elements:
        for item in elements:
            if isinstance(item, str):
                result = "(hash-ref {} {})".format(result, item)
            else:
                result = "(list-ref {} {})".format(result, item)
    return result

def convert_url_parameters(url):
    return re.sub("<.*?>","~s",url.replace("~", "~~"))

def is_builtin(type):
    return type in racket_conversions.keys()

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
                    
def convert_to_racket_type(source_type):
    was_list = is_list(source_type)
    if was_list:
        source_type = strip_list(source_type) #chomp out the "list(" and ")"
    target_type = java_type_names.get(source_type, camel_case_caps(source_type))
    if was_list: # if it's a list, apply it to each element
        return "ArrayList<{}>".format(target_type)
    else: # otherwise just return it normally
        return target_type
        
def convert_to_string(source, type):
    if type in racket_conversions:
        return "({} {})".format(racket_conversions[type], source)
    else:
        return source

#env.filters['to_java_type'] = convert_to_java_type
env.filters['convert_url_parameters'] = convert_url_parameters
#env.filters['collect_url_parameters'] = collect_url_parameters
env.filters['is_builtin'] = is_builtin
env.filters['is_list'] = is_list
env.filters['strip_list'] = strip_list
env.filters['parse_json_path'] = parse_json_path
env.filters['convert_to_string'] = convert_to_string
#env.filters['create_json_conversion'] = create_json_conversion
#env.filters['create_xml_conversion'] = create_xml_conversion
#env.filters['convert_builtin'] = convert_builtin

def build_documentation(model):
    name = model['metadata']['name']
    return {'racket/'+kebab_case(name) + '.scrbl' :
                env.get_template('main.scrbl', globals=model).render()}
    
def build_main(model):
    name = model['metadata']['name']
    return {'racket/'+kebab_case(name) + '.rkt' :
                env.get_template('main.rkt', globals=model).render()}

def build_racket(model):
    files = {'racket/sticky-web.rkt' : copy_file(templates+'sticky-web.rkt')}
    files.update(build_documentation(model))
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
        files = build_racket(to_dict(new_package))
        from build import build_dir
        build_dir(files, sys.argv[2])
    else:
        for error in errors:
            print "Error!", error
