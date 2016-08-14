from __future__ import print_function
import json
import sys, os
from pprint import pprint
import subprocess
try:
    from itertools import izip
except ImportError:
    izip = zip
from textwrap import wrap
from auxiliary import to_dict, camel_case_caps, camel_case
from auxiliary import snake_case, kebab_case, flat_case, copy_file
import sqlite3
import re
from jinja2 import Environment, FileSystemLoader
import jinja2_highlight
base_directory = os.path.dirname(os.path.realpath(__file__))
templates = os.path.join(base_directory, 'java/')
env = Environment(extensions=['jinja2_highlight.HighlightExtension'], loader=FileSystemLoader(templates))
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
                     
java_type_names = { "string" : "String",
                    "str": "String",
                    "NoneType": "String",
                    "unicode": "String",
                    "integer" : "Integer",
                    "int" : "Integer",
                    "float" : "Double",
                    "boolean" : "Boolean",
                    "bool" : "Boolean",
                    "long": "Long"}

gson_conversions = { "string" : "getAsString",
                     "integer" : "getAsInt",
                     "float" : "getAsDouble",
                     "boolean" : "getAsBoolean",
                     "long" : "getAsLong"}

def parse_json_path(path, result="json_data"):
    elements = []
    for keys in path.split("."):
        while keys:
            left, sep, keys = keys.partition("[")
            val, sep, keys = keys.partition("]")
            if left:
                elements.append('"{}"'.format(left))
            if val:
                elements.append(int(val))
    if elements:
        for item in elements[:-1]:
            if isinstance(item, str):
                result = '((JSONObject) {}.get({}))'.format(result, item)
            else:
                result = '((JSONArray) {}.get({}))'.format(result, item)
        result = '{}.get({})'.format(result, elements[-1])
    return result
    
def parse_json_path_all(path, result="raw"):
    elements = []
    for keys in path.split("."):
        while keys:
            left, sep, keys = keys.partition("[")
            val, sep, keys = keys.partition("]")
            if left:
                elements.append('"{}"'.format(left))
            if val:
                elements.append(int(val))
    if elements:
        for item in elements:
            if isinstance(item, str):
                result = '((JSONObject) {}).get({})'.format(result, item)
            else:
                result = '((JSONArray {}).get({})'.format(result, item)
    return result

def convert_url_parameters(url):
    return re.sub("<.*?>","{}",url)

def is_builtin(type):
    return type in java_type_names.keys()

def collect_url_parameters(url):
    return map(str, re.findall("<(.*?)>", url))
    
def is_list(type):
    return type.endswith("]") and type.startswith('list[')

def strip_list(type):
    return type[5:-1]

def create_json_conversion(data, type, key):
    was_list = False
    if is_list(type):
        was_list = True
        type = strip_list(type)
    # Because simplejson is weird and Java is type heavy
    if type in ('int', 'integer'):
        return "new Integer(((Long){}).intValue())".format(data)
    elif type in json_conversion:
        return "{}{}".format(json_conversion[type], data)
    elif was_list:
        return "new {}((JSONArray){})".format(convert_to_java_type(type, key), data)
    else:
        return "new {}((JSONObject){})".format(convert_to_java_type(type, key), data)
        

def convert_builtin(data, type):
    if type == "string":
        return data
    else:
        return '_Auxiliary._parse_type({}, {})'.format(data, java_types[type])

def create_xml_conversion(data, type):
    if is_list(type):
        type = strip_list(type)
    if type in xml_conversions:
        return "{}"
    else:
        return xml_conversion[type]
        
def to_java_type_for_queries(source_type, source_name=None, something=None):
    r = convert_to_java_type(source_type, source_name=None, something=None)
    if r == 'Integer':
        return 'Int'
    else:
        return r
                    
def convert_to_java_type(source_type, source_name=None, something=None):
    if source_name is None:
        source_name = source_type
    was_list = is_list(source_type)
    if was_list:
        source_type = strip_list(source_type) #chomp out the "list(" and ")"
        if is_list(source_name):
            source_name = strip_list(source_name)
        #print(source_type, source_name)
    source_name = clean_invalid_characters(source_name)
    target_type = java_type_names.get(source_type, camel_case_caps(source_name))
    if was_list: # if it's a list, apply it to each element
        return "ArrayList<{}>".format(target_type)
    else: # otherwise just return it normally
        return target_type
        
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
        
def parse_bark(commands):
    commands = commands.split("|")
    result = "raw_result"
    for command in commands:
        components = re.findall(r"(.*?)\((.*)\)", command)
        if not components:
            raise Exception("Invalid jsonpath")
        command_name = components[0][0]
        args = components[0][1].split(",")
        if command_name == "json":
            result = "(JSONObject)this.parser.parse({})".format(result)
        elif command_name == "jsonpath":
            result = parse_json_path(args[0], result)
        elif command_name == "geocode":
            result = "{}, {} = _CACHE.geocode({})".format(args[1], args[2], args[0])
    return result
    
def to_java_variable(source):
    was_list = is_list(source)
    if was_list:
        source = strip_list(source) #chomp out the "list(" and ")"
    converted_type= java_type_names.get(source, None)
    if converted_type is None: # need to convert to custom class
        converted_type = snake_case(source)
    if was_list: # if it's a list, apply it to each element
        return "list_of_{}".format(converted_type)
    else: # otherwise just return it normally
        return "a_{}".format(converted_type)
        
def clean_invalid_characters(astr):
    return astr.replace("'", '').replace('.', " ").replace('"', '').replace('#', 'number').replace('-', ' ').replace('?', '').replace('1', 'one').replace('2', 'two').replace('3', 'three').replace('4', 'four').replace('5', 'five').replace('6', 'six').replace('7', 'seven').replace('8', 'eight').replace('9', 'nine').replace('0', 'zero').replace('/', ' ')
        
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

env.filters['tojson'] = json.dumps
env.filters['sluggify'] = sluggify
env.filters['wrap_quotes'] = wrap_quotes
env.filters['to_human_readable_type'] = to_human_readable_type
env.filters['convert_example_value'] = convert_example_value
env.filters['to_java_type'] = convert_to_java_type
env.filters['to_java_type_for_queries'] = to_java_type_for_queries
env.filters['to_java_variable'] = to_java_variable
env.filters['convert_url_parameters'] = convert_url_parameters
#env.filters['collect_url_parameters'] = collect_url_parameters
env.filters['is_builtin'] = is_builtin
env.filters['is_list'] = is_list
env.filters['strip_list'] = strip_list
env.filters['parse_json_path'] = parse_json_path
env.filters['parse_json_path_all'] = parse_json_path_all
env.filters['convert_to_string'] = convert_to_string
env.filters['requests_verb'] = requests_verb
env.filters['create_json_conversion'] = create_json_conversion
env.filters['create_xml_conversion'] = create_xml_conversion
env.filters['convert_builtin'] = convert_builtin
env.filters['parse_bark'] = parse_bark
env.filters['make_array'] = make_array
env.filters['enforce_json_array'] = enforce_json_array
env.filters['clean_invalid_characters'] = clean_invalid_characters

def json_path(path, data):
    entries = path.split(".")[2:]
    for entry in entries:
        if entry.startswith("["):
            entry = int(entry[1:-1])
        data = data[entry]
    return data

def build_metafiles(model):
    name = model['metadata']['name']
    root = 'java/{name}/'.format(name=flat_case(name))
    return {root+'.classpath': env.get_template('.classpath').render(**model),
            root+'.project':   env.get_template('.project').render(**model),
            root+'build.xml':  env.get_template('build.xml').render(**model)}
    
def build_main(model):
    name = model['metadata']['name']
    root = 'java/{name}/src/corgis/{name}/'.format(name=flat_case(name))
    return {root + camel_case_caps(name) + 'Library.java' :
                env.get_template('main.java').render(**model)}
                
def build_classes(model):
    name = model['metadata']['name']
    root = 'java/{name}/src/corgis/{name}/domain/'.format(name=flat_case(name))
    files = {}
    template = env.get_template('domain.java')
    for structure_name, structure in model['structures'].items():
        for path, data in structure['dictionaries'].items():
            filename = root + camel_case_caps(clean_invalid_characters(data['name'])) + '.java'
            files[filename] = template.render(dictionary=data, **model)
    return files
                
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
                
def copy_file(filename):
    with open(filename, 'rb') as input:
        return input.read()
        
def post_build(model, files, moves, target):
    print("Building jar")
    
    name = flat_case(model['metadata']['name'])
    path = os.path.join(target, 'java', name)
    
    backup_location = os.getcwd()
    os.chdir(path)

    subprocess.call(["ant"], shell=True)
    
    os.chdir(backup_location)
    return None

def build_java(model, fast):
    name = flat_case(model['metadata']['name'])
    root = 'java/{name}/src/corgis/{name}/'.format(name=flat_case(name))
    new_folder = 'java/' + name + '/'
    
    files = {new_folder+'/libs/sqlite-jdbc-3.8.11.2.jar' :  copy_file(templates+'libs/sqlite-jdbc-3.8.11.2.jar'),
             new_folder+'/libs/json-simple-1.1.1.jar' :  copy_file(templates+'libs/json-simple-1.1.1.jar')}
    
    icon_file = model['metadata']['icon']
    
    if os.path.exists(icon_file):
        with open(icon_file, 'rb') as icon_data:
            files[new_folder+name+'.png'] = icon_data.read()
    else:
        model["metadata"]["icon"] = False
    
    files.update(build_metafiles(model))
    files.update(build_main(model))
    files.update(build_classes(model))
    
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
        files = build_java(to_dict(new_package))
        from build import build_dir
        build_dir(files, sys.argv[2])
    else:
        for error in errors:
            print("Error!", error)
