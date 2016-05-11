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
