'''
Hello student. Thank you for downloading a CORGIS library. However, you do not need to open this library. Instead you should use the following:

    import education
    
If you opened the file because you are curious how this library works, then well done! We hope that you find it a useful learning experience. However, you should know that this code is meant to solve somewhat esoteric pedagogical problems, so it is often not best practices. 
'''

import sys as _sys
import os as _os
import json as _json
import sqlite3 as _sql
import difflib as _difflib

def _tifa_definitions():
    return {"type": "ModuleType",
        "fields": {
            'get': {
                "type": "FunctionType",
                "name": 'get',
                "returns": {
                    "type": "ListType", 
                    "empty": False, 
                    "subtype": {"type": "NumType"}
                }
            },
        
            'get_all_states': {
                "type": "FunctionType", 
                "name": 'get_all_states',
                "returns": 
		{"type": "ListType", "subtype": 
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'data'}, {"type": "LiteralStr", "value": 'state'}], "values": [
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'attendance'}, {"type": "LiteralStr", "value": 'enrollment'}, {"type": "LiteralStr", "value": 'location'}, {"type": "LiteralStr", "value": 'score'}, {"type": "LiteralStr", "value": 'funding'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'average student rate'}, {"type": "LiteralStr", "value": 'average minutes'}, {"type": "LiteralStr", "value": 'average teacher rate'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'staff'}, {"type": "LiteralStr", "value": 'teachers'}, {"type": "LiteralStr", "value": 'students'}, {"type": "LiteralStr", "value": 'schools'}, {"type": "LiteralStr", "value": 'student teacher ratio'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'race'}, {"type": "LiteralStr", "value": 'other'}, {"type": "LiteralStr", "value": 'year'}, {"type": "LiteralStr", "value": 'all'}, {"type": "LiteralStr", "value": 'gender'}], "values": [
							{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'asian'}, {"type": "LiteralStr", "value": 'native american'}, {"type": "LiteralStr", "value": 'biracial'}, {"type": "LiteralStr", "value": 'hispanic'}, {"type": "LiteralStr", "value": 'black'}, {"type": "LiteralStr", "value": 'white'}], "values": [
								{"type": "NumType"}, 
								{"type": "NumType"}, 
								{"type": "NumType"}, 
								{"type": "NumType"}, 
								{"type": "NumType"}, 
								{"type": "NumType"}]}, 
							{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'individualized education program'}, {"type": "LiteralStr", "value": 'free lunch eligible'}, {"type": "LiteralStr", "value": 'lep/ell students'}, {"type": "LiteralStr", "value": 'ungraded students'}, {"type": "LiteralStr", "value": 'reduced-price lunch eligible'}], "values": [
								{"type": "NumType"}, 
								{"type": "NumType"}, 
								{"type": "NumType"}, 
								{"type": "StrType"}, 
								{"type": "NumType"}]}, 
							{"type": "ListType", "subtype": 
								{"type": "NumType"}}, 
							{"type": "NumType"}, 
							{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'male'}, {"type": "LiteralStr", "value": 'female'}], "values": [
								{"type": "NumType"}, 
								{"type": "NumType"}]}]}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'latitude'}, {"type": "LiteralStr", "value": 'longitude'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'math'}, {"type": "LiteralStr", "value": 'writing'}, {"type": "LiteralStr", "value": 'science'}, {"type": "LiteralStr", "value": 'reading'}], "values": [
						{"type": "ListType", "subtype": 
							{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'scale score'}, {"type": "LiteralStr", "value": 'grade'}], "values": [
								{"type": "NumType"}, 
								{"type": "NumType"}]}}, 
						{"type": "ListType", "subtype": 
							{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'scale score'}, {"type": "LiteralStr", "value": 'grade'}], "values": [
								{"type": "NumType"}, 
								{"type": "NumType"}]}}, 
						{"type": "ListType", "subtype": 
							{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'scale score'}, {"type": "LiteralStr", "value": 'grade'}], "values": [
								{"type": "NumType"}, 
								{"type": "NumType"}]}}, 
						{"type": "ListType", "subtype": 
							{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'scale score'}, {"type": "LiteralStr", "value": 'grade'}], "values": [
								{"type": "NumType"}, 
								{"type": "NumType"}]}}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'revenue'}, {"type": "LiteralStr", "value": 'expenditures'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}, 
				{"type": "StrType"}]}},
            }
        
        }
    }

class _Constants(object):
    '''
    Global singleton object to hide some of the constants; some IDEs reveal internal module details very aggressively, and there's no other way to hide stuff.
    '''
    _HEADER = {'User-Agent': 
              'CORGIS Education library for educational purposes'}
    _PYTHON_3 = _sys.version_info >= (3, 0)
    _TEST = False
    _HARDWARE = 1000

if _Constants._PYTHON_3:
    import urllib.request as _request
    from urllib.parse import quote_plus as _quote_plus
    from urllib.error import HTTPError as _HTTPError
else:
    import urllib2 as _urllib2
    from urllib import quote_plus as _quote_plus
    from urllib2 import HTTPError as _HTTPError

class DatasetException(Exception):
    ''' Thrown when there is an error loading the dataset for some reason.'''
    pass
    
_Constants._DATABASE_NAME = _os.path.join(_os.path.dirname(__file__),
                                          "education.db")
if not _os.access(_Constants._DATABASE_NAME, _os.F_OK):
    raise DatasetException("Error! Could not find a \"{0}\" file. Make sure that there is a \"{0}\" in the same directory as \"{1}.py\"! Spelling is very important here.".format(_Constants._DATABASE_NAME, __name__))
elif not _os.access(_Constants._DATABASE_NAME, _os.R_OK):
    raise DatasetException("Error! Could not read the \"{0}\" file. Make sure that it readable by changing its permissions. You may need to get help from your instructor.".format(_Constants._DATABASE_NAME, __name__))
elif not _os.access(_Constants._DATABASE_NAME, _os.W_OK):
    # Previously, this generated an error - but that's not important, really.
    #_sys.stderr.write('The local cache (\" \") will not be updated. Make sure that it is writable by changing its permissions. You may need to get help from your instructor.\n'.format(_Constants._DATABASE_NAME))
    #_sys.stderr.flush()
    pass

_Constants._DATABASE = _sql.connect(_Constants._DATABASE_NAME)

class _Auxiliary(object):
    @staticmethod
    def _parse_type(value, type_func):
        """
        Attempt to cast *value* into *type_func*, returning *default* if it fails.
        """
        default = type_func(0)
        if value is None:
            return default
        try:
            return type_func(value)
        except ValueError:
            return default
    
    @staticmethod    
    def _byteify(input):
        """
        Force the given input to only use `str` instead of `bytes` or `unicode`.
        This works even if the input is a dict, list,
        """
        if isinstance(input, dict):
            return {_Auxiliary._byteify(key): _Auxiliary._byteify(value) for key, value in input.items()}
        elif isinstance(input, list):
            return [_Auxiliary._byteify(element) for element in input]
        elif _Constants._PYTHON_3 and isinstance(input, str):
            return str(input.encode('ascii', 'replace').decode('ascii'))
        elif not _Constants._PYTHON_3 and isinstance(input, unicode):
            return str(input.encode('ascii', 'replace').decode('ascii'))
        else:
            return input
    
    @staticmethod    
    def _guess_schema(input):
        if isinstance(input, dict):
            return {str(key.encode('ascii', 'replace').decode('ascii')): 
                    _Auxiliary._guess_schema(value) for key, value in input.items()}
        elif isinstance(input, list):
            return [_Auxiliary._guess_schema(input[0])] if input else []
        else:
            return type(input)
            


################################################################################
# Domain Objects
################################################################################
    

    


################################################################################
# Interfaces
################################################################################



def get_all_states():
    """
    Returns all of the data for every state into a list.
    
    """
    if False:
        # If there was a Test version of this method, it would go here. But alas.
        pass
    else:
        rows = _Constants._DATABASE.execute("SELECT data FROM school".format(
            hardware=_Constants._HARDWARE))
        data = [r[0] for r in rows]
        data = [_Auxiliary._byteify(_json.loads(r)) for r in data]
        
        return _Auxiliary._byteify(data)
        

################################################################################
# Internalized testing code
################################################################################

def _test_interfaces():
    from pprint import pprint as _pprint
    from timeit import default_timer as _default_timer
    # Production test
    print("Production get_all_states")
    start_time = _default_timer()
    result = get_all_states()
    
    print("{} entries found.".format(len(result)))
    _pprint(_Auxiliary._guess_schema(result))
    
    print("Time taken: {}".format(_default_timer() - start_time))
    

if __name__ == '__main__':
    from optparse import OptionParser as _OptionParser
    _parser = _OptionParser()
    _parser.add_option("-t", "--test", action="store_true",
                      default=False,
                      help="Execute the interfaces to test them.")
    (_options, _args) = _parser.parse_args()
    
    if _options.test:
        _test_interfaces()