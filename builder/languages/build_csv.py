from __future__ import print_function
import json
import csv
import sys, os
from pprint import pprint
from itertools import tee
try:
    from itertools import izip
except ImportError:
    izip = zip
from textwrap import wrap
from collections import OrderedDict
from auxiliary import (camel_case_caps, camel_case,
                       snake_case, kebab_case, flat_case,
                       to_dict, copy_file, lod_to_dol,
                       shortest_unique_strings, first_items,
                       convert_example_value, wrap_quotes,
                       kill_unicode)
import sqlite3
import re
from jinja2 import Environment, FileSystemLoader
import jinja2_highlight

base_directory = os.path.dirname(os.path.realpath(__file__))
csv_templates = os.path.join(base_directory, 'csv/')
templates = os.path.join(base_directory, 'templates/')

env = Environment(extensions=['jinja2_highlight.HighlightExtension'], 
                  loader=FileSystemLoader([csv_templates, templates]))
                  
env.filters['camel_case_caps'] = camel_case_caps
env.filters['camel_case'] = camel_case
env.filters['snake_case'] = snake_case
env.filters['kebab_case'] = kebab_case
env.filters['flat_case'] = flat_case

ordinals = ["first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", 
            "tenth", "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth", "sixteenth",
            "seventeenth", "eighteenth", "nineteenth", "twentieith", "twenty-first"]
            
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

def flatten_json(data, delim="_"):
    result = {}
    def recursive_walk(key, value):
        if isinstance(value, dict):
            for inner_key, inner_value in value.items():
                recursive_walk(key+delim+inner_key, inner_value)
        elif isinstance(value, list):
            # TODO: Handle case where inner lists are not constant sized. 
            for ordinal, element in zip(ordinals, value):
                recursive_walk(key+delim+ordinal, element)
        else:
            result[key] = value
    recursive_walk("", data)
    return {k[1:] : v for k, v in result.items()}
    
def _byteify(input):
    """
    Force the given input to only use `str` instead of `bytes` or `unicode`.
    This works even if the input is a dict, list,
    """
    if isinstance(input, dict):
        return {_byteify(key): _byteify(value) for key, value in input.items()}
    elif isinstance(input, list):
        return [_byteify(element) for element in input]
    elif isinstance(input, unicode):
        return str(input.encode('ascii', 'replace').decode('ascii'))
    else:
        return input
    
def json_path(path, data):
    entries = path.split(".")
    for entry in entries:
        if entry.startswith("["):
            entry = int(entry[1:-1])
        data = data[entry]
    return data
    
def to_human_readable_type(a_value):
    if isinstance(a_value, (int, long)):
        return '<code>Integer number</code>'
    elif isinstance(a_value, float):
        return '<code>Real number</code>'
    elif isinstance(a_value, (str, unicode)):
        return '<code>String</code>'
    elif isinstance(a_value, bool):
        return '<code>Boolean (1/0)</code>'
    else:
        return '<code>'+str(type(a_value))+'</code>'
        
def sluggify(astr):
    return astr.replace('.', '-').replace("[", "__").replace("]", "__").replace(" ", "-").replace("#", "_").replace("/", "_").replace("'", "_")
        
env.filters['sluggify'] = sluggify
env.filters['to_human_readable_type'] = to_human_readable_type
env.filters['convert_example_value'] = convert_example_value
env.filters['wrap_quotes'] = wrap_quotes
    
def _guess_schema(input):
    if isinstance(input, dict):
        return {str(key.encode('ascii', 'replace').decode('ascii')): 
                _guess_schema(value) for key, value in input.items()}
    elif isinstance(input, list):
        return [_guess_schema(input[0])] if input else []
    else:
        return type(input)

def build_metafiles(model, descriptions):
    name = snake_case(model['metadata']['name'])
    root = 'csv/{name}/'.format(name=name)
    return {
            root+'index.html' : env.get_template('csv_main.html').render(standalone=True, descriptions=descriptions, **model),
            root+name+'.html' : env.get_template('csv_main.html').render(standalone=False, descriptions=descriptions, **model)
            }
                
def build_database(model):
    name = snake_case(model['metadata']['name'])
    new_file = name+'.csv'
    if os.path.exists(new_file):
        os.remove(new_file)
    with open(new_file, 'w') as output:
        pass
    return new_file
    
def write_list_of_dictionaries(filename, data):
    if os.path.exists(filename):
        os.remove(filename)
    with open(filename, 'wb') as output_file:
        dict_writer = csv.DictWriter(output_file, data[0].keys())
        dict_writer.writeheader()
        dict_writer.writerows(data)

def build_locals(model):
    locals = model["locals"]
    hardware = model['metadata']['hardware']
    module_name = snake_case(model['metadata']['name'])    
    moves = {}
    
    for local in locals:
        name = snake_case(local["name"])
        file = local["file"]
        row_type = local["type"]
        json_path = snake_case(model['metadata']['name']) + "_dataset.js"
        new_file = name+'.csv'
        new_small_file = name+'_small.csv'
        row_type = local["type"]
        keys = set()
        with open(file, "r") as local_file:
            if row_type == "json":
                data_list = json.load(local_file)
                data = [JsonLeafNodes(name+'.[0]', item).result for item in data_list]
                data_long_names = data
                key_names = set([key for row in data for key in row.keys()])
                short_key_names = shortest_unique_strings(key_names)
                key_name_map = dict(zip(short_key_names, key_names))
                comment_map = {short: model['structures_comments'].get(long, '')
                               for short, long in key_name_map.items()}
                data = [OrderedDict(sorted([(short, kill_unicode(row.get(long, '')))
                                            for short, long in key_name_map.items()]))
                        for row in data]
                full_key_descriptions = [
                    {'name': short, 
                     'short': short,
                     'type': value,
                     'comment': comment_map.get(short),
                     'example': value}
                    for short, value in data[0].items()]
                
                #json_list = [OrderedDict(sorted(flatten_json(_byteify(element), '_').items()))
                #             for element in data_list]
                write_list_of_dictionaries(new_file, data)
                moves[new_file] = 'csv/'+module_name+'/'
                write_list_of_dictionaries(new_small_file, data[:hardware])
                moves[new_small_file] = 'csv/'+module_name+'/'
            elif row_type == "csv":
                pass
        yield moves, full_key_descriptions
        

def build_csv(model):
    files = {}
    moves = {}
    descriptions = []
    
    for local_file_name, fkd in build_locals(model):
        moves.update(local_file_name)
        descriptions.append(fkd)
        
    for appendix in model['metadata']['appendix']:
        moves[appendix['file']] = 'csv/' + snake_case(model['metadata']['name']) + '/'
        
    files.update(build_metafiles(model, descriptions))
        
    icon_file = model['metadata']['icon']
    name = snake_case(model['metadata']['name'])
    new_folder = 'csv/' + name + '/'
    if os.path.exists(icon_file):
        with open(icon_file, 'rb') as icon_data:
            files[new_folder+name+'.png'] = icon_data.read()
    else:
        model["metadata"]["icon"] = False
    
    return files, moves
