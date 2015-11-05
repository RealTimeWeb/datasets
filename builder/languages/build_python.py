import json
import sys, os
from pprint import pprint
from itertools import tee, izip
from urlparse import urlparse
from urllib import quote_plus, urlencode
from textwrap import wrap
from collections import OrderedDict
from auxiliary import to_dict, camel_case_caps, camel_case
from auxiliary import snake_case, kebab_case, flat_case, copy_file
import sqlite3
import re
from jinja2 import Environment, FileSystemLoader
import jinja2_highlight
templates = 'languages/python/'
env = Environment(extensions=['jinja2_highlight.HighlightExtension'], loader=FileSystemLoader(templates))
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
                "boolean": "bool",
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
    return type.endswith("]") and type.startswith('list[')

def strip_list(type):
    return type[5:-1]

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
        return '_parse_type({}, {})'.format(python_types[type], data)

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
        
def parse_bark(commands):
    commands = commands.split("|")
    result = "r"
    for command in commands:
        components = re.findall(r"(.*?)\((.*)\)", command)
        if not components:
            raise Exception("Invalid jsonpath")
        command_name = components[0][0]
        args = components[0][1].split(",")
        if command_name == "json":
            result = "_json.loads({})".format(result)
        elif command_name == "jsonpath":
            result = parse_json_path(args[0], result)
    return result
    
def to_python_variable(source):
    was_list = is_list(source)
    if was_list:
        source = strip_list(source) #chomp out the "list(" and ")"
    converted_type= python_types.get(source, None)
    if converted_type is None: # need to convert to custom class
        converted_type = snake_case(source)
    if was_list: # if it's a list, apply it to each element
        return "list_of_{}".format(converted_type)
    else: # otherwise just return it normally
        return "a_{}".format(converted_type)

env.filters['to_python_type'] = convert_to_python_type
env.filters['to_python_variable'] = to_python_variable
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
env.filters['parse_bark'] = parse_bark

def json_path(path, data):
    entries = path.split(".")
    for entry in entries:
        if entry.startswith("["):
            entry = int(entry[1:-1])
        data = data[entry]
    return data

def build_metafiles(model):
    name = model['metadata']['name']
    return {
            'python/' + flat_case(name) + '/' + flat_case(name) + '.html' : env.get_template('main.html').render(**model),
            'python/' + flat_case(name) + '/' + flat_case(name) + '_preview.html' : env.get_template('preview.html').render(**model)
            }
    
def build_main(model):
    name = model['metadata']['name']
    return {'python/' + flat_case(name) + '/' + flat_case(name) + '.py' :
                env.get_template('main.py').render(**model)}
                
def build_database(model):
    name = flat_case(model['metadata']['name'])
    new_file = name+'.db'
    if os.path.exists(new_file):
        os.remove(new_file)
    database_file = sqlite3.connect(new_file)
    return new_file, database_file

def build_locals(model, database_file):
    locals = model["locals"]
    moves = {}
    
    for local in locals:
        name = local["name"]
        file = local["file"]
        type = local["type"]
        with open(file, "r") as local_file:
            if type == "json":
                data_list = json.load(local_file)
                json_list = [json.dumps(element) for element in data_list]
                indexes = []
                index_titles = ""
                for index in local["indexes"]:
                    index_name = index["name"]
                    index_path = index["jsonpath"]
                    indexed_value = [json_path(index_path, element) for element in data_list]
                    indexes.append(indexed_value)
                    index_titles += ", {} text".format(index_name)
                
                header = "{}(data{})".format(name, index_titles)
                blanks = "?" + (", ?" * len(indexes))
                database_file.execute('CREATE TABLE '+header)
                if local["indexes"]:
                    the_list = zip(json_list, zip(*indexes))
                else:
                    the_list = zip(json_list, [tuple() for x in json_list])
                for row, indices in the_list:
                    database_file.execute("INSERT INTO {} VALUES ({})".format(name, blanks),
                                          (row,)+indices)
                database_file.commit()
            elif type == "csv":
                pass

def build_python(model):
    new_file, database_file = build_database(model)
    
    files = {}
    files.update(build_metafiles(model))
    files.update(build_main(model))
    
    build_locals(model, database_file)
    
    database_file.close()
    moves = {new_file: 'python/' + flat_case(model['metadata']['name']) + '/'}
    for appendix in model['metadata']['appendix']:
        moves[appendix['file']] = 'python/' + flat_case(model['metadata']['name']) + '/'
    
    return files, moves
    
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
