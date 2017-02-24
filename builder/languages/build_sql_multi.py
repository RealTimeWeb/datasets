from __future__ import print_function
import json
import sys, os
from pprint import pprint
from textwrap import wrap
from collections import OrderedDict
import sqlite3
import re

from jinja2 import Environment, FileSystemLoader
import jinja2_highlight

from auxiliary import (camel_case_caps, camel_case,
                       snake_case, kebab_case, flat_case,
                       to_dict, copy_file, lod_to_dol,
                       shortest_unique_strings, first_items,
                       convert_example_value, wrap_quotes)

base_directory = os.path.dirname(os.path.realpath(__file__))
sql_templates = os.path.join(base_directory, 'sql/')
templates = os.path.join(base_directory, 'templates/')

env = Environment(extensions=['jinja2_highlight.HighlightExtension'], 
                  loader=FileSystemLoader([sql_templates, templates]))
                  
env.filters['camel_case_caps'] = camel_case_caps
env.filters['camel_case'] = camel_case
env.filters['snake_case'] = snake_case
env.filters['kebab_case'] = kebab_case
env.filters['flat_case'] = flat_case

conversion_mapping = { ("string", "integer") : "Integer.parseInt",
                       ("string", "float") : "Double.parseDouble",
                       ("string", "long") : "Long.parseLong",
                       ("string", "string") : "",
                       ("string", "boolean") : "Boolean.parseBoolean",
                       ("integer", "string") : "Integer.toString",
                       ("long", "string") : "Long.toString",
                       ("float", "string") : "Double.toString",
                       ("boolean", "string") : "Boolean.toString"}
                       
json_conversion = { "int" : "(Integer)",
                    "integer" : "(Integer)",
                    "float" : "(Double)",
                    "boolean" : "(Boolean)",
                    "bool" : "(Boolean)",
                    "string": "(String)",
                    "str": "(String)",
                    "unicode": "(String)",
                    "NoneType": "(String)",
                    "long" : "(Long)"}
                     
sql_type_names = { "string" : "text",
                    "str": "text",
                    "NoneType": "text",
                    "unicode": "text",
                    "integer" : "integer",
                    "int" : "integer",
                    "float" : "real",
                    "boolean" : "integer",
                    "bool" : "integer",
                    "long": "integer"} # Yeah, okay, SQLITE is bad with big numbers. But won't a Real be more confusing?

def convert_url_parameters(url):
    return re.sub("<.*?>","{}",url)

def is_builtin(type):
    return type in sql_type_names.keys()

def collect_url_parameters(url):
    return map(str, re.findall("<(.*?)>", url))
    
def is_list(type):
    return type.endswith("]") and type.startswith('list[')

def strip_list(type):
    return type[5:-1]

def make_array(object_map, type):
    if type in object_map and not object_map[type]:
        return "Array"
    else:
        return ""
        
def enforce_json_array(root, post):
    if post == "" or post.startswith("["):
        return root + "Array()"
    else:
        return root + "()"
        
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
    
def to_sql_type_or_id(v):
    if v.__class__.__name__ in sql_type_names:
        return sql_type_names[v.__class__.__name__]
    else: 
        return 'integer'
    
def to_sql_variable(source):
    was_list = is_list(source)
    if was_list:
        source = strip_list(source) #chomp out the "list(" and ")"
    converted_type= sql_type_names.get(source, None)
    if converted_type is None: # need to convert to custom class
        converted_type = snake_case(source)
    if was_list: # if it's a list, apply it to each element
        return "list_of_{}".format(converted_type)
    else: # otherwise just return it normally
        return "a_{}".format(converted_type)
        
def to_sql_name(astr):
    return astr.replace('.', '_').replace("[", "__").replace("]", "__").replace(" ", "_").replace("#", "_").replace("/", "_").replace("-", "_")
    
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

def sluggify(astr):
    return astr.replace('.', '-').replace("[", "__").replace("]", "__").replace(" ", "-").replace("#", "_").replace("/", "_").replace("'", "_")

env.filters['sluggify'] = sluggify
env.filters['tojson'] = json.dumps
env.filters['to_sql_name'] = to_sql_name
env.filters['wrap_quotes'] = wrap_quotes
env.filters['to_human_readable_type'] = to_human_readable_type
env.filters['convert_example_value'] = convert_example_value
env.filters['to_sql_variable'] = to_sql_variable
env.filters['convert_url_parameters'] = convert_url_parameters
#env.filters['collect_url_parameters'] = collect_url_parameters
env.filters['is_builtin'] = is_builtin
env.filters['is_list'] = is_list
env.filters['strip_list'] = strip_list
env.filters['convert_to_string'] = convert_to_string
env.filters['requests_verb'] = requests_verb
env.filters['make_array'] = make_array
env.filters['enforce_json_array'] = enforce_json_array

def json_path(path, data):
    entries = path.split(".")
    for entry in entries:
        if entry.startswith("["):
            entry = int(entry[1:-1])
        data = data[entry]
    return data

def build_metafiles(model):
    name = model['metadata']['name']
    root = 'sql/{name}/'.format(name=name)
    descriptions = []
    return {
            root+'index.html' : env.get_template('sql_main.html').render(standalone=True, descriptions=descriptions, **model),
            root+name+'.html' : env.get_template('sql_main.html').render(standalone=False, descriptions=descriptions, **model)
            }
                
def build_database(model):
    name = snake_case(model['metadata']['name'])
    new_file = name+'.db'
    if os.path.exists(new_file):
        os.remove(new_file)
    database_file = sqlite3.connect(new_file)
    return new_file, database_file

class JsonToSql(object):
    def __init__(self, structures, data, parent_name, indexes=None):
        self.values= {}
        self.headers = {}
        self.last_id = {}
        self.structures = structures
        '''
        for index in local["indexes"]:
            index_name = index["name"]
            index_path = index["jsonpath"]
            indexed_value = [json_path(index_path, element) for element in data_list]
            indexes.append(indexed_value)
            index_titles += ", {} text".format(index_name)
        '''
        self.walk(data, parent_name)
        
    def walk(self, chunk, parent_name, from_list=False):
        if isinstance(chunk, dict):
            return self.walk_dict(chunk, parent_name, from_list)
        elif isinstance(chunk, list):
            return self.walk_list(chunk, parent_name, from_list)
        else:
            return self.walk_atom(chunk, parent_name, from_list)
    def new_table(self, name, headers):
        self.values[name] = []
        self.headers[name] = headers
        self.last_id[name] = 0
    def walk_dict(self, data, parent, from_list):
        row_data = [(key, to_sql_type_or_id(v))
                    for key, v in
                    data.items()]
        if "id" not in data.keys():
            row_data.append( ("id", "integer") )
        row_data = sorted(row_data, key=lambda x: x[0])
        if parent not in self.headers:
            self.new_table(parent, row_data)
        new_row = []
        for key, key_type in row_data:
            if key in data:
                new_row.append(self.walk(data[key], key, False))
            else:
                new_row.append(self.last_id[parent])
        self.values[parent].append(new_row)
        self.last_id[parent] += 1
        return self.last_id[parent]-1
    def walk_list(self, data, parent, from_list):
        for row in data:
            if isinstance(data, dict):
                self.walk(row, parent, from_list=True)
            else:
                #: TODO: make this work
                r = self.walk(row, parent, from_list=True)
                row_data = [('id', 'integer'), 
                            (parent, to_sql_type_or_id(r))]
                if parent not in self.headers:
                    self.new_table(parent, row_data)
                self.values[parent].append([self.last_id[parent], r])
                self.last_id[parent] += 1
        return self.last_id[parent]-1
    def walk_atom(self, data, parent, from_list):
        return data

def build_locals(model, database_file, sql_path):
    locals = model["locals"]
    structures = model['structures']
    moves = {}
    tables = {}
    for local in locals:
        name = local["name"]
        file = local["file"]
        row = local["row"]
        type = local["type"]
        with open(file, "r") as local_file, open(sql_path, 'w') as sql_file:
            if type == "json":
                data = json.load(local_file)
                sqlized_data = JsonToSql(structures, data, row)
                values, headers = sqlized_data.values, sqlized_data.headers
                for header_name, header in headers.items():
                    header = ", ".join("{name} {type}".format(name=to_sql_name(n), type=t) for n,t in header)
                    sql_file.write("CREATE TABLE {name} ({header})\n".format(
                        name=to_sql_name(header_name), header=header
                    ))
                for table_name, value in values.items():
                    for row in value:
                        sql_file.write("INSERT INTO {name} VALUES ({row})\n".format(
                            name=to_sql_name(table_name), row=", ".join(map(json.dumps, row))
                        ))
                    sql_file.write("\n")
                '''
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
                '''
                
def copy_file(filename):
    with open(filename, 'rb') as input:
        return input.read()

def build_sql(model, fast):
    name = snake_case(model['metadata']['name'])
    new_folder = 'sql/' + name + '/'
    
    files = {}
    
    icon_file = model['metadata']['icon']
    
    if os.path.exists(icon_file):
        with open(icon_file, 'rb') as icon_data:
            files[new_folder+name+'.png'] = icon_data.read()
    else:
        model["metadata"]["icon"] = False
    
    files.update(build_metafiles(model))
    
    if not fast:
        new_file, database_file = build_database(model)
        sql_file = name+".sql"
        build_locals(model, database_file, sql_file)
        database_file.close()
        moves = {new_file: new_folder, sql_file: new_folder}
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
        files = build_sql(to_dict(new_package))
        from build import build_dir
        build_dir(files, sys.argv[2])
    else:
        for error in errors:
            print("Error!", error)
