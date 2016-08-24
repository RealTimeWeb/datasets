from __future__ import print_function

import json
import sys, os
from pprint import pprint
from itertools import tee
try:
    from itertools import izip
except ImportError:
    izip = zip
from textwrap import wrap
from collections import OrderedDict
from auxiliary import to_dict, camel_case_caps, camel_case
from auxiliary import snake_case, kebab_case, flat_case, copy_file
import sqlite3
import re
from jinja2 import Environment, FileSystemLoader
import jinja2_highlight
base_directory = os.path.dirname(os.path.realpath(__file__))
racket_templates = os.path.join(base_directory, 'racket/')
templates = os.path.join(base_directory, 'templates/')
env = Environment(extensions=['jinja2_highlight.HighlightExtension'], loader=FileSystemLoader([templates, racket_templates]))
env.filters['camel_case_caps'] = camel_case_caps
env.filters['camel_case'] = camel_case
env.filters['snake_case'] = snake_case
env.filters['kebab_case'] = kebab_case
env.filters['flat_case'] = flat_case
env.filters['tojson'] = json.dumps

conversion_mapping = { ("string", "integer") : "",
                       ("string", "float") : "",
                       ("string", "string") : "",
                       ("string", "boolean") : "",
                       ("string", "long") : "",
                       ("long", "string") : "str",
                       ("boolean", "string") : "str",
                       ("integer", "string") : "str",
                       ("float", "string") : "str"}
                       
racket_conversions = {"float": "number->string",
                      "long": "number->string",
                      "integer": "number->string",
                      "boolean": "boolean->string"}
                  
racket_types = {"str": "string",
                "unicode": "string",
                "float": "number",
                "NoneType": "number", # Datasets with this are bad
                "long": "number",
                "int": "number",
                "void": "void",
                "bool": "boolean"}

def parse_json_path(path, result="json_data"):
    elements = []
    for keys in path.split("."):
        while keys:
            left, sep, keys = keys.partition("[")
            val, sep, keys = keys.partition("]")
            if left:
                elements.append('(string->symbol "{}")'.format(left))
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
    return re.sub("<.*?>","{}",url)

def is_builtin(type):
    return type in racket_types.keys()

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
        return '_Auxiliary._parse_type({}, {})'.format(data, racket_types[type])

def create_xml_conversion(data, type):
    if is_list(type):
        type = strip_list(type)
    if type in xml_conversions:
        return "{}"
    else:
        return xml_conversion[type]
                    
def convert_to_racket_type(source):
    was_list = is_list(source)
    if was_list:
        source = strip_list(source) #chomp out the "list(" and ")"
    converted_type= racket_types.get(source, None)
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
    result = "result"
    for command in commands:
        components = re.findall(r"(.*?)\((.*)\)", command)
        if not components:
            raise Exception("Invalid jsonpath")
        command_name = components[0][0]
        args = components[0][1].split(",")
        if command_name == "json":
            result = "(map string->jsexpr {})".format(result)
        elif command_name == "jsonpath":
            result = parse_json_path(args[0], result)
        elif command_name == "geocode":
            result = "{}, {} = _CACHE.geocode({})".format(args[1], args[2], args[0])
    return result
    
def to_racket_variable(source):
    was_list = is_list(source)
    if was_list:
        source = strip_list(source) #chomp out the "list(" and ")"
    converted_type= racket_types.get(source, None)
    if converted_type is None: # need to convert to custom class
        converted_type = snake_case(source)
    if was_list: # if it's a list, apply it to each element
        return "list_of_{}".format(converted_type)
    else: # otherwise just return it normally
        return "a_{}".format(converted_type)
        
def sluggify(astr):
    return astr.replace('.', '-').replace("[", "__").replace("]", "__").replace(" ", "-").replace("#", "_").replace("/", "_")
    
EXTENDED_TYPE_INFO = {
    'dict': '<span data-toggle="tooltip" title="Dictionary">dict</span>',
    'unicode': '<span data-toggle="tooltip" title="String (text)">str</span>',
    'list': '<span data-toggle="tooltip" title="List">list</span>',
    'str': '<span data-toggle="tooltip" title="String (text)">str</span>',
    'int': '<span data-toggle="tooltip" title="Integer (whole number)">int</span>',
    'float': '<span data-toggle="tooltip" title="Float (decimal number)">float</span>',
    'long': '<span data-toggle="tooltip" title="Long (a very big whole number)">long</span>',
    'bool': '<span data-toggle="tooltip" title="Boolean (True or False)">bool</span>',
}
def to_human_readable_type(atype):
    return EXTENDED_TYPE_INFO[atype]
    
EXPAND = "<span class='glyphicon glyphicon-new-window' aria-hidden='true'></span>"
def convert_example_value(data, possible_path=""):
    if isinstance(data, dict):
        return "<a class='dialog-opener' id='{possible_path}'>{{ {E} }}</a>".format(possible_path=possible_path, E=EXPAND)
    elif isinstance(data, list):
        return "<a class='dialog-opener' id='{possible_path}'>[ {E} ]</a>".format(possible_path=possible_path, E=EXPAND)
    elif isinstance(data, str) or isinstance(data, unicode):
        return "<code>{data}</code>".format(data=wrap_quotes(data))
    else:
        return "<code>{data}</code>".format(data=data)
        
def wrap_quotes(data):
    if '"' not in data:
        pretty = '"{data}"'.format(data=data)
    elif "'" not in data:
        pretty = "'{data}'".format(data=data)
    else:
        pretty = '"{data}"'.format(data=data.replace('"', '\"'))
    return pretty

env.filters['sluggify'] = sluggify
env.filters['wrap_quotes'] = wrap_quotes
env.filters['to_human_readable_type'] = to_human_readable_type
env.filters['convert_example_value'] = convert_example_value
env.filters['to_racket_type'] = convert_to_racket_type
env.filters['to_racket_variable'] = to_racket_variable
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
    entries = path.split(".")[2:]
    for entry in entries:
        if entry.startswith("["):
            entry = int(entry[1:-1])
        data = data[entry]
    return data

def build_metafiles(model):
    name = snake_case(model['metadata']['name'])
    root = 'racket/'+name+'/'
    return {
            root + name + '.scrbl' : env.get_template('main.scrbl').render(**model),
            root+'index.html' : env.get_template('racket_main.html').render(standalone=True, **model),
            root+name+'.html' : env.get_template('racket_main.html').render(standalone=False, **model)
            }
    
def build_main(model):
    name = model['metadata']['name']
    return {'racket/' + snake_case(name) + '/' + snake_case(name) + '.rkt' :
                env.get_template('main.rkt').render(**model)}
                
def build_database(model):
    name = snake_case(model['metadata']['name'])
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

def build_racket(model, fast):
    name = snake_case(model['metadata']['name'])
    new_folder = 'racket/' + name + '/'
    
    files = {}
    
    icon_file = model['metadata']['icon']
    
    if os.path.exists(icon_file):
        with open(icon_file, 'rb') as icon_data:
            files[new_folder+name+'.png'] = icon_data.read()
    else:
        model["metadata"]["icon"] = False
    
    files.update(build_metafiles(model))
    files.update(build_main(model))
    
    if not fast:
        new_file, database_file = build_database(model)
        build_locals(model, database_file)
        
        database_file.close()
        moves = {new_file: new_folder}
        for appendix in model['metadata']['appendix']:
            moves[appendix['file']] = new_folder
    else:
        moves = {}
    
    return files, moves
    
if __name__ == "__main__":
    import json
    from auxiliary import clean_json
    input = clean_json(json.load(open(sys.argv[1],'r')))
    from validate import validate_spec
    warnings, errors = validate_spec(input)
    for warning in warnings:
        print("Warning!", warning)
    if not errors:
        from compile import compile_spec
        new_package = compile_spec(input)
        files = build_racket(to_dict(new_package))
        from build import build_dir
        build_dir(files, sys.argv[2])
    else:
        for error in errors:
            print("Error!", error)
