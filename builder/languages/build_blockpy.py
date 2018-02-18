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
xrange = range
from collections import OrderedDict, defaultdict
from auxiliary import (camel_case_caps, camel_case,
                       snake_case, kebab_case, flat_case,
                       to_dict, copy_file, lod_to_dol,
                       shortest_unique_strings, first_items,
                       convert_example_value, wrap_quotes)
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
    
def get_base_type(type):
    if type.startswith('list'):
        return 'list'
    else:
        return type
        
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
        
def sluggify(astr):
    return astr.replace('.', '-').replace("[", "__").replace("]", "__").replace(" ", "-").replace("#", "_").replace("/", "_").replace("'", "_")
    
EXTENDED_TYPE_INFO = {
    'dict': '<span data-toggle="tooltip" title="Dictionary">dict</span>',
    'unicode': '<span data-toggle="tooltip" title="String (text)">str</span>',
    'list': '<span data-toggle="tooltip" title="List">list</span>',
    'str': '<span data-toggle="tooltip" title="String (text)">str</span>',
    'int': '<span data-toggle="tooltip" title="Integer (whole number)">int</span>',
    'float': '<span data-toggle="tooltip" title="Float (decimal number)">float</span>',
    'long': '<span data-toggle="tooltip" title="Long (a very big whole number)">long</span>',
    'NoneType': '<span data-toggle="tooltip" title="None (nothing, not zero or an empty list, just nothing)">None</span>',
    'bool': '<span data-toggle="tooltip" title="Boolean (True or False)">bool</span>',
}
def to_human_readable_type(a_value):
    if isinstance(a_value, int):
        return '<code>int</code> (Integer number)'
    elif isinstance(a_value, float):
        return '<code>float</code> (Decimal number)'
    elif isinstance(a_value, (str, unicode)):
        return '<code>str</code> (Text)'
    elif isinstance(a_value, bool):
        return '<code>bool</code> (True/False)'
    elif isinstance(a_value, long):
        return '<code>long</code> (Big numbers)'
    else:
        return '<code>'+str(type(a_value))+'</code>'

env.filters['tojson'] = json.dumps
env.filters['to_python_variable'] = to_python_variable
#env.filters['collect_url_parameters'] = collect_url_parameters
env.filters['is_list'] = is_list
env.filters['strip_list'] = strip_list
env.filters['parse_json_path'] = parse_json_path
env.filters['parse_bark'] = parse_bark
env.filters['unique'] = set
env.filters['sluggify'] = sluggify
env.filters['to_human_readable_type'] = to_human_readable_type
env.filters['convert_example_value'] = convert_example_value
env.filters['wrap_quotes'] = wrap_quotes

def json_path(path, data):
    entries = path.split(".")
    for entry in entries:
        if entry.startswith("["):
            entry = int(entry[1:-1])
        data = data[entry]
    return data

def build_metafiles(model, key_names, indexes, full_key_descriptions, tifa_definitions):
    name = snake_case(model['metadata']['name'])
    root = 'blockpy/' + name + '/'
    return {
            root+'index.html' : env.get_template('blockpy_main.html').render(key_names=key_names, indexes=indexes, full_key_descriptions=full_key_descriptions, standalone=True, **model),
            root+name+'.html' : env.get_template('blockpy_main.html').render(key_names=key_names, indexes=indexes, full_key_descriptions=full_key_descriptions, standalone=False, **model),
            root + name + '_skulpt.js' : env.get_template('skulpt.js').render(key_names=key_names, indexes=indexes, **model),
            root + name + '_blockly.js' : env.get_template('blockly.js').render(key_names=key_names, indexes=indexes,  tifa_definitions=tifa_definitions, **model)
            }
            
class TifaDefinition(object):
    def __init__(self, data):
        self.result = "Tifa.defineSupplier("
        self.indent = 1
        self.result += self.walk(data)
        self.result += ")"
    def walk(self, chunk):
        self.indent += 1
        start = "\n" + "\t"*self.indent
        if isinstance(chunk, dict):
            start+= self.walk_dict(chunk)
        elif isinstance(chunk, list):
            start+= self.walk_list(chunk)
        else:
            start+= self.walk_atomic(chunk)
        self.indent -= 1
        return start
    def convert_literal(self, a_literal):
        if isinstance(a_literal, (float, int)):
            return '{{"type": "Num", "value": {!r}}}'.format(a_literal)
        elif isinstance(a_literal, (str, unicode)):
            return '{{"type": "Str", "value": {!r}}}'.format(a_literal)
        elif isinstance(a_literal, bool):
            return '{{"type": "Bool", "value": {!r}}}'.format(a_literal)
    
    def walk_dict(self, a_dict):
        complete = 'Tifa._DICT_LITERAL_TYPE('
        items = list(a_dict.items())
        literals = ', '.join([self.convert_literal(l) for l, value in items])
        values = ', '.join([self.walk(value) for key, value in items])
        complete += '[{literals}], '.format(literals=literals)
        complete += '[{values}]'.format(values=values)
        complete += ')'
        return complete
    
    def walk_list(self, a_list):
        complete = 'Tifa._LIST_OF_TYPE('
        complete += self.walk(a_list[0])
        complete += ')'
        return complete
    
    def walk_atomic(self, an_atomic):
        if isinstance(an_atomic, (float, int)):
            return 'Tifa._NUM_TYPE()'
        elif isinstance(an_atomic, (str, unicode)):
            return 'Tifa._STR_TYPE()'
        elif isinstance(an_atomic, bool):
            return 'Tifa._BOOL_TYPE()'

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
        
def remove_outliers(lodol, actually_keep=True):
    bad_indexes = set()
    bad_keys = set()
    DEVIATIONS = 4
    MAX_LENGTH = 10000
    
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
            
    total_indexes = len(lodol[0]['data'])
    reduced_indexes = total_indexes - len(bad_indexes)
    print("Bad indexes:", len(bad_indexes), "/", total_indexes)
    '''
    I have a list of numbers Z from 0 to N
    I have a list of J numbers (where J < N) randomly distributed throughout Z
    I wish to remove K numbers from Z, without drawing from any number in J
    '''
    if reduced_indexes > MAX_LENGTH:
        stride = int(total_indexes / MAX_LENGTH)
        for an_index in range(0, total_indexes, stride):
            keep_index = random.randint(0, stride-1)
            for offset in xrange(0, stride):
                if keep_index != offset:
                    bad_indexes.add(min(total_indexes, an_index+offset))
    if actually_keep:
        bad_indexes = set()
        bad_keys = set()
    print("Trimmed indexes:", len(bad_indexes), "/", total_indexes)
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

def build_locals(model, js_path):
    locals = model["locals"]
    metadata_name = snake_case(model['metadata']['name'])
    model['visualized_datasets'] = {}
    for local in locals:
        name = local["name"]
        file = local["file"]
        row_type = local["type"]
        row = local["row"]
        # Complete Dataset
        complete_path = snake_case(model['metadata']['name']) + "_complete.js"
        with open(file, "r") as local_file, open(complete_path, 'w') as output_file:
            output_file.write("_IMPORTED_COMPLETE_DATASETS['{}'] = Sk.ffi.remapToPy(".format(metadata_name))
            if row_type == "json":
                data_list = json.load(local_file)
                json.dump(data_list, output_file, indent=2)
                output_file.write(");");
        # Linearized Dataset
        json_path = snake_case(model['metadata']['name']) + "_dataset.js"
        with open(file, "r") as local_file, open(json_path, 'w') as output_file:
            output_file.write("_IMPORTED_DATASETS['{}'] = ".format(metadata_name))
            if row_type == "json":
                data_list = json.load(local_file)
                data = [JsonLeafNodes(name+'.[0]', item).result for item in data_list]
                data = lod_to_dol(data)
                remove_outliers(data, actually_keep=model['metadata']['outliers'])
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
                full_key_descriptions = [
                    {'name': row['name'], 
                     'short': key_name_map[row['name']],
                     'type': row['type'],
                     'comment': row.get('comment', ''),
                     'example': row['data'][0]}
                    for row in data]
                indexes = {key_name_map[row['name']]: row for row in data if row['index']}
                for index_data in indexes.values():
                    index_data['data'] = [str(val) for val in index_data['data']]
                data = {key_name_map[row['name']]: row for row in data}
                json.dump(data, output_file, indent=2)
                #model['visualized_datasets'][name] = data.keys()
            print("File sizes:", "{}mb".format(os.stat(json_path).st_size / 1024 / 1024))
        yield json_path, complete_path, short_key_names, indexes, full_key_descriptions, data_list

def build_blockpy(model, fast):
    name = snake_case(model['metadata']['name'])
    new_folder = 'blockpy/' + name + '/'
    
    files = {}
    
    icon_file = model['metadata']['icon']
    
    if os.path.exists(icon_file):
        with open(icon_file, 'rb') as icon_data:
            files[new_folder+name+'.png'] = icon_data.read()
    else:
        model["metadata"]["icon"] = False
    
    results = list(build_locals(model, new_folder))
    moves = {f: new_folder
             for s in results
             for f in s[:2]}
    key_names = [k for s in results for k in s[2]]
    indexes = {k:v for s in results for k, v in s[3].items()}
    full_key_descriptions = [i[4] for i in results]
    
    tifa_definitions = []
    for interface, s in zip(model['interfaces'], results): 
        tifa_definitions.append(
            (interface['name'], TifaDefinition(s[5]).result)
        )
        
    files.update(build_metafiles(model, key_names, indexes, full_key_descriptions, tifa_definitions))
    
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
