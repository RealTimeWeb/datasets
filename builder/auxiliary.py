import collections
try:
  # Python 2.7+
  basestring
except NameError:
  # Python 3.3+
  basestring = str 
try:
    unicode
except NameError:
    unicode = str

def copy_file(filename):
    with open(filename, 'rb') as input:
        return input.read()

def clean_json(input):
    if isinstance(input, dict):
        return {clean_json(key.lower()): clean_json(value) for key, value in input.items()}
    elif isinstance(input, list):
        return [clean_json(element) for element in input]
    elif isinstance(input, unicode):
        return input.encode('utf-8')
    else:
        return input
        
def to_dict(obj, classkey=None):
    if isinstance(obj, basestring):
        return obj 
    elif isinstance(obj, dict):
        return dict((key, to_dict(val)) for key, val in obj.items())
    elif isinstance(obj, collections.Iterable):
        return [to_dict(val) for val in obj]
    elif hasattr(obj, '__dict__'):
        return to_dict(vars(obj))
    elif hasattr(obj, '__slots__'):
        return to_dict(dict((name, getattr(obj, name)) for name in getattr(obj, '__slots__')))
    return obj

        
def snake_case(string):
    return string.replace(" ", "_").lower()
    
def camel_case_caps(string):
    return ''.join(x for x in string.title() if not x.isspace())
    
def camel_case(string):
    s = camel_case_caps(string)
    return s[0].lower() + s[1:] if s else ""

def flat_case(string):
    return string.replace(" ", "").replace("_", "").lower()

def kebab_case(string):
    return string.replace(" ", "-").replace("_", "-").lower()

            
def lod_to_dol(LD):
    dictionaires = {}
    for row in LD:
        for key, value in row.items():
            if key in dictionaires:
                dictionaires[key].append(value)
            else:
                dictionaires[key] = [value]
    return [{'name': k, 'data': v} for k,v in dictionaires.items()]

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

def kill_unicode(value):
    if isinstance(value, unicode):
        return value.encode('ascii', 'ignore')
    return value
    
def sluggify(astr):
    return astr.replace('.', '-').replace("[", "__").replace("]", "__").replace(" ", "-").replace("#", "_").replace("/", "_").replace("'", "_")