def copy_file(filename):
    with open(filename, 'rb') as input:
        return input.read()

def clean_json(input):
    if isinstance(input, dict):
        return {clean_json(key.lower()): clean_json(value) for key, value in input.iteritems()}
    elif isinstance(input, list):
        return [clean_json(element) for element in input]
    elif isinstance(input, unicode):
        return input.encode('utf-8')
    else:
        return input
        
def to_dict(obj, classkey=None):
    if isinstance(obj, dict):
        for k in obj.keys():
            obj[k] = to_dict(obj[k], classkey)
        return obj
    elif hasattr(obj, "__iter__"):
        return [to_dict(v, classkey) for v in obj]
    elif hasattr(obj, "__dict__"):
        data = dict([(key, to_dict(value, classkey)) 
            for key, value in obj.__dict__.iteritems() 
            if not callable(value) and not key.startswith('_')])
        if classkey is not None and hasattr(obj, "__class__"):
            data[classkey] = obj.__class__.__name__
        return data
    else:
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
