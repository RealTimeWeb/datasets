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
visualizer_templates = os.path.join(base_directory, 'visualizer/')
templates = os.path.join(base_directory, 'templates/')
env = Environment(extensions=['jinja2_highlight.HighlightExtension'], loader=FileSystemLoader([templates, visualizer_templates]))
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
            'visualizer/' + snake_case(name) + '/' + snake_case(name) + '.html' : env.get_template('main.html').render(standalone=False, **model),
            'visualizer/' + snake_case(name) + '/index.html' : env.get_template('main.html').render(standalone=True, **model)
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
            #print(data['name'], mean-4*std, mean+4*std, evils)
    
    print("Bad indexes:", len(bad_indexes), "/", len(lodol[0]['data']))
    #print("Contributing keys:", ', '.join(bad_keys))
    for data in lodol:
        data['data'] = [v for i, v in enumerate(data['data']) if i not in bad_indexes]
        inter = data['name'].split('.', 2)[2]
        if '.' in inter:
            category, name = inter.rsplit('.', 1)
        else:
            category, name = inter, inter
        category = category.replace('.', ' ')
        data['pretty'] = category.title() + ": "+name.title()
        print(data['pretty'])
        if isinstance(data['data'][0], (float, int)):
            data['type'] = 'number'
        else:
            data['type'] = 'text'
    lodol.sort(key= lambda e: e['pretty'])


def build_locals(model, js_path):
    locals = model["locals"]
    model['visualized_datasets'] = {}
    print("")
    for local in locals:
        name = snake_case(local["name"])
        file = local["file"]
        row_type = local["type"]
        row = local["row"]
        json_path = name + ".js"
        json_bar_path = name + "_bar.js"
        with open(file, "r") as local_file, open(json_path, 'w') as output_file, open(json_bar_path, 'w') as output_bar_file:
            output_file.write(name+" = ")
            output_bar_file.write(name+"_bar = ")
            if row_type == "json":
                data_list = json.load(local_file)
                data = [JsonLeafNodes(name+'.[0]', item).result for item in data_list]
                data = lod_to_dol(data)
                bar_data = []
                remove_outliers(data)
                for row in data:
                    if row['name'] in model['structures_comments']:
                        row['comment'] = model['structures_comments'][row['name']]
                    is_index = row['name'] in [i['jsonpath'] for i in local['indexes']]
                    row['index'] = is_index
                dol = {d['name']: d['data'] for d in data}
                lod = [dict(zip(dol, t)) for t in zip(*dol.values())]
                
                for index in local['indexes']:
                    index_path = index['jsonpath']
                    indexed_values = {}
                    aggregated_values = {}
                    for chunk in lod:
                        if index_path in chunk:
                            category = str(chunk[index_path])
                        else:
                            category = ""
                        if category not in indexed_values:
                            indexed_values[category] = {}
                        for key, value in chunk.items():
                            if not isinstance(value, (int, float)):
                                continue
                            if key not in indexed_values[category]:
                                indexed_values[category][key] = []
                            indexed_values[category][key].append(value)
                            
                    for category, items in indexed_values.items():
                        category = str(category)
                        for key, values in items.items():
                            if key not in aggregated_values:
                                aggregated_values[key] = {}
                            aggregated_values[key][category.replace(',', '')] = {
                                'count': len(values),
                                'sum': sum(values),                                
                                'average': statistics.mean(values)
                            }
                    inter = index_path.split('.', 2)[2]
                    if '.' in inter:
                        category, name = inter.rsplit('.', 1)
                    else:
                        category, name = inter, inter
                    category = category.replace('.', ' ')
                    
                    bar_data.append({
                        'data': aggregated_values,
                        'name': index_path,
                        'indexes': [k.replace(',', '') for k in indexed_values.keys()],
                        'best_indexes': [k.replace(',', '') for k, v in sorted([(k, v['count']) 
                                            for k, v in aggregated_values.values()[0].items()], key=lambda i: -i[1])[:10]],
                        'pretty': category.title() + ": "+name.title()
                    })
                #sample_down(data)
                json.dump(data, output_file, indent=2)
                json.dump(bar_data, output_bar_file, indent=2)
                #model['visualized_datasets'][name] = data.keys()
        yield json_path
        yield json_bar_path

def build_visualizer(model, fast):
    name = snake_case(model['metadata']['name'])
    new_folder = 'visualizer/' + name + '/'
    
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
        files = build_visualizer(to_dict(new_package))
        from build import build_dir
        build_dir(files, sys.argv[2])
    else:
        for error in errors:
            print("Error!", error)
