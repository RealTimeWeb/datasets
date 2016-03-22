import sys as _sys
import os as _os
import json as _json
import sqlite3 as _sql
import difflib as _difflib

class _Constants(object):
    _HEADER = {'User-Agent': 
              'CORGIS Businesses library for educational purposes'}
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
    
_Constants._DATABASE_NAME = "businesses.db"
if not _os.access(_Constants._DATABASE_NAME, _os.F_OK):
    raise DatasetException("Error! Could not find a \"{0}\" file. Make sure that there is a \"{0}\" in the same directory as \"{1}.py\"! Spelling is very important here.".format(_Constants._DATABASE_NAME, __name__))
elif not _os.access(_Constants._DATABASE_NAME, _os.R_OK):
    raise DatasetException("Error! Could not read the \"{0}\" file. Make sure that it readable by changing its permissions. You may need to get help from your instructor.".format(_Constants._DATABASE_NAME, __name__))
elif not _os.access(_Constants._DATABASE_NAME, _os.W_OK):
    _sys.stderr.write('The local cache (\" \") will not be updated. Make sure that it is writable by changing its permissions. You may need to get help from your instructor.\n'.format(_Constants._DATABASE_NAME))
    _sys.stderr.flush()

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



def get_businesses_by_city(city, test=True):
    """
    Returns all the businesses in the given city.
    
    :param city: The name of the city.
    :type city: Str
    """
    
    # Match it against recommend values
    potentials = [r[0].lower() for r in _Constants._DATABASE.execute("SELECT DISTINCT city FROM businesses").fetchall()]
    if city.lower() not in potentials:
        best_guesses = _difflib.get_close_matches(city, potentials)
        if best_guesses:
            raise DatasetException("Error, the given identifier could not be found. Perhaps you meant one of:\n\t{}".format('\n\t'.join(map('"{}"'.format, best_guesses))))
        else:
            raise DatasetException("Error, the given identifier could not be found. Please check to make sure you have the right spelling.")
    if _Constants._TEST or test:
        rows = _Constants._DATABASE.execute("SELECT data FROM businesses WHERE city=? COLLATE NOCASE LIMIT {hardware}".format(
            hardware=_Constants._HARDWARE),
            (city, ))
        data = [r[0] for r in rows]
        data = [_Auxiliary._byteify(_json.loads(r)) for r in data]
        
        return _Auxiliary._byteify(data)
        
    else:
        rows = _Constants._DATABASE.execute("SELECT data FROM businesses WHERE city=? COLLATE NOCASE".format(
            hardware=_Constants._HARDWARE),
            (city, ))
        data = [r[0] for r in rows]
        data = [_Auxiliary._byteify(_json.loads(r)) for r in data]
        
        return _Auxiliary._byteify(data)
        

def get_business_by_name(name, test=True):
    """
    Returns all the businesses with the given name (matches fuzzily, so 'subway' would match 'Subway' and 'The subway').
    
    :param name: The name of the business. It can be part of the name instead of the entire name.
    :type name: Str
    """
    
    if _Constants._TEST or test:
        rows = _Constants._DATABASE.execute("SELECT data FROM businesses WHERE name LIKE ('%' || ? || '%') COLLATE NOCASE LIMIT {hardware}".format(
            hardware=_Constants._HARDWARE),
            (name, ))
        data = [r[0] for r in rows]
        data = [_Auxiliary._byteify(_json.loads(r)) for r in data]
        
        return _Auxiliary._byteify(data)
        
    else:
        rows = _Constants._DATABASE.execute("SELECT data FROM businesses WHERE name LIKE ('%' || ? || '%') COLLATE NOCASE".format(
            hardware=_Constants._HARDWARE),
            (name, ))
        data = [r[0] for r in rows]
        data = [_Auxiliary._byteify(_json.loads(r)) for r in data]
        
        return _Auxiliary._byteify(data)
        

def get_all_businesses(test=True):
    """
    Returns all the businesses in the database.
    
    """
    if _Constants._TEST or test:
        rows = _Constants._DATABASE.execute("SELECT data FROM businesses LIMIT {hardware}".format(
            hardware=_Constants._HARDWARE))
        data = [r[0] for r in rows]
        data = [_Auxiliary._byteify(_json.loads(r)) for r in data]
        
        return _Auxiliary._byteify(data)
        
    else:
        rows = _Constants._DATABASE.execute("SELECT data FROM businesses".format(
            hardware=_Constants._HARDWARE))
        data = [r[0] for r in rows]
        data = [_Auxiliary._byteify(_json.loads(r)) for r in data]
        
        return _Auxiliary._byteify(data)
        

def get_user_by_id(user_id):
    """
    Returns the information for a given user by their ID
    
    :param user_id: A unique user id, given by the reviews of a business.
    :type user_id: Str
    """
    
    if False:
        # If there was a Test version of this method, it would go here. But alas.
        pass
    else:
        rows = _Constants._DATABASE.execute("SELECT data FROM users WHERE uid=? LIMIT 1".format(
            hardware=_Constants._HARDWARE),
            (user_id, ))
        data = [r[0] for r in rows]
        data = [_Auxiliary._byteify(_json.loads(r)) for r in data]
        
        data = data[0]
        
        return _Auxiliary._byteify(data)
        

def get_users(test=True):
    """
    Returns all of the users in the database.
    
    """
    if _Constants._TEST or test:
        rows = _Constants._DATABASE.execute("SELECT data FROM users LIMIT {hardware}".format(
            hardware=_Constants._HARDWARE))
        data = [r[0] for r in rows]
        data = [_Auxiliary._byteify(_json.loads(r)) for r in data]
        
        return _Auxiliary._byteify(data)
        
    else:
        rows = _Constants._DATABASE.execute("SELECT data FROM users".format(
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
    print("Production get_businesses_by_city")
    start_time = _default_timer()
    result = get_businesses_by_city('blacksburg', test=False)
    
    print("{} entries found.".format(len(result)))
    _pprint(_Auxiliary._guess_schema(result))
    
    print("Time taken: {}".format(_default_timer() - start_time))
    # Test test
    print("Test get_businesses_by_city")
    start_time = _default_timer()
    result = get_businesses_by_city('blacksburg')
    
    print("{} entries found.".format(len(result)))
    _pprint(_Auxiliary._guess_schema(result))
    
    print("Time taken: {}".format(_default_timer() - start_time))
    
    # Production test
    print("Production get_business_by_name")
    start_time = _default_timer()
    result = get_business_by_name('subway', test=False)
    
    print("{} entries found.".format(len(result)))
    _pprint(_Auxiliary._guess_schema(result))
    
    print("Time taken: {}".format(_default_timer() - start_time))
    # Test test
    print("Test get_business_by_name")
    start_time = _default_timer()
    result = get_business_by_name('subway')
    
    print("{} entries found.".format(len(result)))
    _pprint(_Auxiliary._guess_schema(result))
    
    print("Time taken: {}".format(_default_timer() - start_time))
    
    # Production test
    print("Production get_all_businesses")
    start_time = _default_timer()
    result = get_all_businesses(test=False)
    
    print("{} entries found.".format(len(result)))
    _pprint(_Auxiliary._guess_schema(result))
    
    print("Time taken: {}".format(_default_timer() - start_time))
    # Test test
    print("Test get_all_businesses")
    start_time = _default_timer()
    result = get_all_businesses()
    
    print("{} entries found.".format(len(result)))
    _pprint(_Auxiliary._guess_schema(result))
    
    print("Time taken: {}".format(_default_timer() - start_time))
    
    # Production test
    print("Production get_user_by_id")
    start_time = _default_timer()
    result = get_user_by_id('UqNSytSc3hiYfKVCGwvLCg')
    
    _pprint(result)
    
    print("Time taken: {}".format(_default_timer() - start_time))
    
    # Production test
    print("Production get_users")
    start_time = _default_timer()
    result = get_users(test=False)
    
    print("{} entries found.".format(len(result)))
    _pprint(_Auxiliary._guess_schema(result))
    
    print("Time taken: {}".format(_default_timer() - start_time))
    # Test test
    print("Test get_users")
    start_time = _default_timer()
    result = get_users()
    
    print("{} entries found.".format(len(result)))
    _pprint(_Auxiliary._guess_schema(result))
    
    print("Time taken: {}".format(_default_timer() - start_time))
    

if __name__ == '__main__':
    from optparse import OptionParser as _OptionParser
    _parser = _OptionParser()
    _parser.add_option("-t", "--test", action="store_true",
                      default=False,
                      help="Execute the interfaces to test them.")
    _parser.add_option("-r", "--reset", action="store_true",
                      default=False,
                      help="Reset the cache")
    (_options, _args) = _parser.parse_args()
    
    if _options.test:
        _test_interfaces()

    if _options.reset:
        _modify_self()