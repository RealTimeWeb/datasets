import json
import sys
from pprint import pprint

DEFINITIONS = set()
UNFINISHED = []

def deep_type(data, optional_type=""):
    if isinstance(data, dict):
        return optional_type
    elif isinstance(data, list):
        if not data:
            UNFINISHED.append(data)
            return 'Still Unknown'
        if isinstance(data[0], dict):
            label = " ".join(data[0].keys())
        else:
            label = deep_type(data[0])
        return 'List[{}]'.format(label)
    elif isinstance(data, unicode):
        return 'str'
    else:
        return data.__class__.__name__
        
def guess_schema(key, input):
    if isinstance(input, dict):
        DEFINITIONS.add(
            tuple(
                [key, tuple([(k, deep_type(v, k)) for k,v in input.items()])]
            )
        )
        return {str(key.encode('ascii', 'replace').decode('ascii')): 
                guess_schema(key, value) for key, value in input.items()}
    elif isinstance(input, list):
        if not input:
            UNFINISHED.append(key)
            return 'list'
        if isinstance(input[0], dict):
            label = " ".join(input[0].keys())
        else:
            label = str(len(input))
        return [guess_schema(label, input[0])] if input else []
    else:
        return deep_type(input)

if __name__ == '__main__':
    pprint(guess_schema(sys.argv[1].split('.')[-2], json.load(open(sys.argv[1]))))
    '''
    print "structures:"
    for label, fields in DEFINITIONS:
        print "  - name:", label
        print "    fields:"
        for name, type in fields:
            print '      - name:', name
            print '        type:', type
    '''
    #pprint(DEFINITIONS)