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
from auxiliary import to_dict, camel_case_caps, camel_case
from auxiliary import snake_case, kebab_case, flat_case, copy_file
import sqlite3
import re
from jinja2 import Environment, FileSystemLoader
import jinja2_highlight

templates = 'languages/csv/'
env = Environment(extensions=['jinja2_highlight.HighlightExtension'], loader=FileSystemLoader(templates))
env.filters['camel_case_caps'] = camel_case_caps
env.filters['camel_case'] = camel_case
env.filters['snake_case'] = snake_case
env.filters['kebab_case'] = kebab_case
env.filters['flat_case'] = flat_case

ordinals = ["first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", 
            "tenth", "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth", "sixteenth",
            "seventeenth", "eighteenth", "nineteenth", "twentieith", "twenty-first"]

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
    
def _guess_schema(input):
    if isinstance(input, dict):
        return {str(key.encode('ascii', 'replace').decode('ascii')): 
                _guess_schema(value) for key, value in input.items()}
    elif isinstance(input, list):
        return [_guess_schema(input[0])] if input else []
    else:
        return type(input)

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
    module_name = flat_case(model['metadata']['name'])    
    moves = {}
    
    for local in locals:
        name = flat_case(local["name"])
        new_file = name+'.csv'
        new_small_file = name+'_small.csv'
        file = local["file"]
        type = local["type"]
        with open(file, "r") as local_file:
            if type == "json":
                data_list = json.load(local_file)
                json_list = [OrderedDict(sorted(flatten_json(_byteify(element), '_').items()))
                             for element in data_list]
                write_list_of_dictionaries(new_file, json_list)
                moves[new_file] = 'csv/'+module_name+'/'
                write_list_of_dictionaries(new_small_file, json_list[:hardware])
                moves[new_small_file] = 'csv/'+module_name+'/'
            elif type == "csv":
                pass
    return moves
        

def build_csv(model):
    files = {}
    #files.update(build_metafiles(model))
    
    moves = {}
    moves.update(build_locals(model))
    for appendix in model['metadata']['appendix']:
        moves[appendix['file']] = 'csv/' + flat_case(model['metadata']['name']) + '/'
    
    return files, moves