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
                       convert_example_value, wrap_quotes,
                       kill_unicode)

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
    astr = astr.replace('.', '_').replace("[", "__").replace("]", "__").replace(" ", "_").replace("#", "_").replace("/", "_").replace("-", "_")
    if astr == 'key':
        astr = 'key_'
    return astr
    
def to_sql_value(a_value):
    if isinstance(a_value, (unicode, str)):
        return "'"+a_value.replace("'", "''")+"'"
    elif isinstance(a_value, bool):
        return "TRUE" if a_value else "FALSE"
    else:
        return str(a_value)
    
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

def build_metafiles(model, descriptions):
    name = snake_case(model['metadata']['name'])
    root = 'sql/{name}/'.format(name=name)
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
                header = ", ".join("{name} {type}".format(name=to_sql_name(s), 
                                                          type=to_sql_type_or_id(v))
                                   for s,v in data[0].items())
                header_name = to_sql_name(name)
                sql_file.write("CREATE TABLE {name} ({header});\n".format(
                    name=header_name, header=header
                ))
                for short, long in key_name_map.items():
                    if long in [i['jsonpath'] for i in local['indexes']]:
                        sql_file.write("CREATE INDEX {idx} ON {table} ({field});\n".format(
                                       idx=to_sql_name(short)+'_idx',
                                       table=header_name,
                                       field=to_sql_name(short)))
                full_key_descriptions = [
                    {'name': short, 
                     'short': short,
                     'type': value,
                     'comment': comment_map.get(short),
                     'example': value}
                    for short, value in data[0].items()]
                    
                for row in data:
                    sql_file.write("INSERT INTO {name} VALUES ({row});\n".format(
                        name=header_name, row=", ".join(map(to_sql_value, row.values()))
                    ))
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
                yield full_key_descriptions
                
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
    
    
    if not fast:
        new_file, database_file = build_database(model)
        sql_file = name+".sql"
        descriptions = build_locals(model, database_file, sql_file)
        database_file.close()
        moves = {new_file: new_folder, sql_file: new_folder}
        for appendix in model['metadata']['appendix']:
            moves[appendix['file']] = new_folder
    else:
        moves = {}
        
    files.update(build_metafiles(model, list(descriptions)))
    
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
