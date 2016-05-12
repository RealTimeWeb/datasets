from __future__ import print_function
import json
import sys, os
from pprint import pprint
from itertools import tee
try:
    from itertools import izip
except ImportError:
    izip = zip
from collections import OrderedDict, defaultdict
from auxiliary import to_dict, camel_case_caps, camel_case
from auxiliary import snake_case, kebab_case, flat_case
import sqlite3
import re
from jinja2 import Environment, FileSystemLoader
import jinja2_highlight
base_directory = os.path.dirname(os.path.realpath(__file__))
templates = os.path.join(base_directory, 'explorer/')
env = Environment(extensions=['jinja2_highlight.HighlightExtension'], loader=FileSystemLoader(templates))
env.filters['camel_case_caps'] = camel_case_caps
env.filters['camel_case'] = camel_case
env.filters['snake_case'] = snake_case
env.filters['kebab_case'] = kebab_case
env.filters['flat_case'] = flat_case

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

def is_list(type):
    return type.endswith("]") and type.startswith('list[')

def strip_list(type):
    return type[5:-1]
        
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
            result = "_Auxiliary._byteify(_json.loads({}))".format(result)
        elif command_name == "jsonpath":
            result = parse_json_path(args[0], result)
        elif command_name == "geocode":
            result = "{}, {} = _CACHE.geocode({})".format(args[1], args[2], args[0])
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

env.filters['tojson'] = json.dumps
env.filters['to_python_variable'] = to_python_variable
#env.filters['collect_url_parameters'] = collect_url_parameters
env.filters['is_list'] = is_list
env.filters['strip_list'] = strip_list
env.filters['parse_json_path'] = parse_json_path
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
            'explorer/' + flat_case(name) + '/' + flat_case(name) + '.html' : env.get_template('main.html').render(**model),
            'explorer/' + flat_case(name) + '/' + flat_case(name) + '_preview.html' : env.get_template('preview.html').render(**model)
            }

class JsonLeafNodes(object):    
    def __init__(self, name, data):
        self.result = {}
        self.path = []
        self.name = name
        self.walk(data, name)
    
    @property
    def json_path(self):
        return ".".join([self.name]+self.path)
        
    def type_check(self, value):
        return value.__class__.__name__
        
    def walk(self, chunk, parent_name):
        if isinstance(chunk, dict):
            self.walk_dict(chunk, parent_name)
        elif isinstance(chunk, list):
            self.walk_list(chunk, parent_name)
        else:
            self.walk_atomic(chunk, parent_name)
        return self
        
    def walk_dict(self, a_dict, parent_name):
        for key, value in a_dict.items():
            self.path.append(key)
            self.walk(value, key)
            self.path.pop()
    def walk_list(self, a_list, parent_name):
        if not a_list:
            return
        self.path.append("[0]")
        first = a_list[0]
        self.walk(first, parent_name)
        self.path.pop()
    def walk_atomic(self, an_atomic, parent_name):
        if (isinstance(an_atomic, int) or 
            isinstance(an_atomic, float)):
            self.result[self.json_path] = an_atomic
            
def lod_to_dol(LD):
    return [{'name': k, 'data': v} for k,v in zip(LD[0],zip(*[d.values() for d in LD]))]

def build_locals(model, js_path):
    locals = model["locals"]
    model['visualized_datasets'] = {}
    
    for local in locals:
        name = local["name"]
        file = local["file"]
        type = local["type"]
        row = local["row"]
        json_path = name + ".js"
        with open(file, "r") as local_file, open(json_path, 'w') as output_file:
            output_file.write(name+" = ")
            if type == "json":
                data_list = json.load(local_file)
                data = [JsonLeafNodes(row, item).result for item in data_list]
                data = lod_to_dol(data)
                json.dump(data, output_file, indent=2)
                #model['visualized_datasets'][name] = data.keys()
        yield json_path

def build_explorer(model, fast):
    name = flat_case(model['metadata']['name'])
    new_folder = 'explorer/' + name + '/'
    
    files = {}
    
    icon_file = model['metadata']['icon']
    
    if os.path.exists(icon_file):
        with open(icon_file, 'rb') as icon_data:
            files[new_folder+name+'.png'] = icon_data.read()
    else:
        model["metadata"]["icon"] = False
    
    if not fast:
        moves = {f: new_folder for f in build_locals(model, new_folder)}
    else:
        moves = {}
        
    files.update(build_metafiles(model))
    
    return files, moves
    
if __name__ == "__main__":
    from auxiliary import clean_json
    input = clean_json(json.load(open(sys.argv[1],'r')))
    from validate import validate_spec
    warnings, errors = validate_spec(input)
    for warning in warnings:
        print("Warning!", warning)
    if not errors:
        from compile import compile_spec
        new_package = compile_spec(input)
        files = build_explorer(to_dict(new_package))
        from build import build_dir
        build_dir(files, sys.argv[2])
    else:
        for error in errors:
            print("Error!", error)
