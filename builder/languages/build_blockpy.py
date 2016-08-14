from __future__ import print_function
import json
import sys, os
from pprint import pprint
from itertools import tee
try:
    from itertools import izip
except ImportError:
    izip = zip
try:
    unicode
except NameError:
    unicode = str
from collections import OrderedDict, defaultdict
from auxiliary import to_dict, camel_case_caps, camel_case
from auxiliary import snake_case, kebab_case, flat_case
import sqlite3
import re
from jinja2 import Environment, FileSystemLoader
import jinja2_highlight
import random
import statistics
random.seed(133)
base_directory = os.path.dirname(os.path.realpath(__file__))
blockpy_templates = os.path.join(base_directory, 'blockpy/')
templates = os.path.join(base_directory, 'templates/')
env = Environment(extensions=['jinja2_highlight.HighlightExtension'], loader=FileSystemLoader([templates, blockpy_templates]))
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
env.filters['unique'] = set

def json_path(path, data):
    entries = path.split(".")
    for entry in entries:
        if entry.startswith("["):
            entry = int(entry[1:-1])
        data = data[entry]
    return data

def build_metafiles(model, key_names, indexes):
    name = model['metadata']['name']
    return {
            'blockpy/' + flat_case(name) + '/' + flat_case(name) + '_skulpt.js' : env.get_template('skulpt.js').render(key_names=key_names, indexes=indexes, **model),
            'blockpy/' + flat_case(name) + '/' + flat_case(name) + '_blockly.js' : env.get_template('blockly.js').render(key_names=key_names, indexes=indexes,  **model)
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
        return        
        if not a_list:
            return
        self.path.append("[0]")
        first = a_list[0]
        self.walk(first, parent_name)
        self.path.pop()
    def walk_atomic(self, an_atomic, parent_name):
        if isinstance(an_atomic, (float, int, str, unicode)):
            self.result[self.json_path] = an_atomic
            
def lod_to_dol(LD):
    dictionaires = {}
    for row in LD:
        for key, value in row.items():
            if key in dictionaires:
                dictionaires[key].append(value)
            else:
                dictionaires[key] = [value]
    return [{'name': k, 'data': v} for k,v in dictionaires.items()]

def sample_down(dol):
    for data in dol:
        data['data'] = random.sample(data['data'], min(len(data['data']), 1000))
        
def remove_outliers(lodol):
    bad_indexes = set()
    bad_keys = set()
    DEVIATIONS = 4
    
    for data in lodol:
        #print(data['name'])
        #print([e for e in data['data'] if isinstance(e, (str, unicode))])
        if isinstance(data['data'][0], (int, float)):
            mean = statistics.mean(data['data'])
            std = statistics.stdev(data['data'])
            evils = 0
            for index, value in enumerate(data['data']):
                if mean - DEVIATIONS*std > value or value > mean + DEVIATIONS*std:
                    bad_keys.add(data['name'])
                    bad_indexes.add(index)
                    evils += 1
            print(data['name'], mean-4*std, mean+4*std, evils)
    
    print("Bad indexes:", len(bad_indexes), "/", len(lodol[0]['data']))
    print("Contributing keys:", ', '.join(bad_keys))
    for data in lodol:
        data['data'] = [v for i, v in enumerate(data['data']) if i not in bad_indexes]
        inter = data['name'].split('.', 2)[2]
        if '.' in inter:
            category, name = inter.rsplit('.', 1)
        else:
            category, name = inter, inter
        category = category.replace('.', ' ')
        data['pretty'] = category.title() + ": "+name.title()
        if isinstance(data['data'][0], (float, int)):
            data['type'] = 'number'
        else:
            data['type'] = 'text'
    lodol.sort(key= lambda e: e['pretty'])

def first_items(a_list_of_tuples):
    return [item[0] for item in a_list_of_tuples]

def shortest_unique_strings(los):
    splits = [l.split('.') for l in los]
    lengths = [ (l[-1], l[:-1]) for l in splits]
    while len(first_items(lengths)) != len(set(first_items(lengths))):
        for this_index, (this, this_rest) in enumerate(lengths):
            for other_index, (other, other_rest) in enumerate(lengths):
                if this == other and this_index != other_index:
                    if len(this_rest) >= len(other_rest):
                        lengths[this_index] = ( this_rest[-1] + '.' + this , this_rest[:-1] )
                    if len(this_rest) <= len(other_rest):
                        lengths[other_index] = ( other_rest[-1] + '.' + other , other_rest[:-1] )
    return first_items(lengths)

def build_locals(model, js_path):
    locals = model["locals"]
    model['visualized_datasets'] = {}
    for local in locals:
        name = local["name"]
        file = local["file"]
        row_type = local["type"]
        row = local["row"]
        json_path = name + "_dataset.js"
        with open(file, "r") as local_file, open(json_path, 'w') as output_file:
            output_file.write("_IMPORTED_DATASETS['{}'] = ".format(name))
            if row_type == "json":
                data_list = json.load(local_file)
                data = [JsonLeafNodes(name+'.[0]', item).result for item in data_list]                
                data = lod_to_dol(data)
                remove_outliers(data)
                for row in data:
                    if row['name'] in model['structures_comments']:
                        row['comment'] = model['structures_comments'][row['name']]
                    is_index = row['name'] in [i['jsonpath'] for i in local['indexes']]
                    row['index'] = is_index
                    if is_index:
                        print("Index:", row["name"])
                key_names = [row['name'] for row in data]
                short_key_names = shortest_unique_strings(key_names)
                key_name_map = dict(zip(key_names, short_key_names))
                indexes = {key_name_map[row['name']]: row for row in data if row['index']}
                for index_data in indexes.values():
                    index_data['data'] = [str(val) for val in index_data['data']]
                data = {key_name_map[row['name']]: row for row in data}
                #sample_down(data)
                json.dump(data, output_file, indent=2)
                #model['visualized_datasets'][name] = data.keys()
        yield json_path, short_key_names, indexes

def build_blockpy(model, fast):
    name = flat_case(model['metadata']['name'])
    new_folder = 'blockpy/' + name + '/'
    
    files = {}
    
    icon_file = model['metadata']['icon']
    
    if os.path.exists(icon_file):
        with open(icon_file, 'rb') as icon_data:
            files[new_folder+name+'.png'] = icon_data.read()
    else:
        model["metadata"]["icon"] = False
    
    results = list(build_locals(model, new_folder))
    moves = {f: new_folder for f in first_items(results)}
    key_names = [k for s in results for k in s[1]]
    indexes = {k:v for s in results for k, v in s[2].items()}
        
    files.update(build_metafiles(model, key_names, indexes))
    
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
        files = build_blockpy(to_dict(new_package))
        from build import build_dir
        build_dir(files, sys.argv[2])
    else:
        for error in errors:
            print("Error!", error)
