'''
Hello student. Thank you for downloading a CORGIS library. However, you do not need to open this library. Instead you should use the following:

    import retail_services
    
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
        
            'get_report': {
                "type": "FunctionType", 
                "name": 'get_report',
                "returns": 
		{"type": "ListType", "subtype": 
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'data'}, {"type": "LiteralStr", "value": 'time'}], "values": [
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'sales'}, {"type": "LiteralStr", "value": 'ratio'}, {"type": "LiteralStr", "value": 'inventories'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'electronic shopping and mail-order houses'}, {"type": "LiteralStr", "value": 'grocery stores'}, {"type": "LiteralStr", "value": 'furniture, home furn, electronics, and appliance stores'}, {"type": "LiteralStr", "value": 'book stores'}, {"type": "LiteralStr", "value": 'household appliance stores'}, {"type": "LiteralStr", "value": 'non-leased department stores'}, {"type": "LiteralStr", "value": 'furniture stores'}, {"type": "LiteralStr", "value": 'retail trade and food services, ex auto'}, {"type": "LiteralStr", "value": 'sporting goods, hobby, book, and music stores'}, {"type": "LiteralStr", "value": 'building materials and garden supplies dealers'}, {"type": "LiteralStr", "value": 'non-discount department stores'}, {"type": "LiteralStr", "value": 'supermarkets and other grocery (except convenience) stores'}, {"type": "LiteralStr", "value": 'food and beverage stores'}, {"type": "LiteralStr", "value": "women's clothing stores"}, {"type": "LiteralStr", "value": 'electronics and appliance stores'}, {"type": "LiteralStr", "value": 'office supplies, stationery, and gift stores'}, {"type": "LiteralStr", "value": 'retail trade and food services'}, {"type": "LiteralStr", "value": 'sporting goods stores'}, {"type": "LiteralStr", "value": 'paint and wallpaper stores'}, {"type": "LiteralStr", "value": 'fuel dealers'}, {"type": "LiteralStr", "value": 'hardware stores'}, {"type": "LiteralStr", "value": 'gasoline stations'}, {"type": "LiteralStr", "value": 'miscellaneous store retailers'}, {"type": "LiteralStr", "value": 'other general merchandise stores'}, {"type": "LiteralStr", "value": 'auto and other motor vehicles'}, {"type": "LiteralStr", "value": 'hobby, toy, and game stores'}, {"type": "LiteralStr", "value": 'warehouse clubs and superstores'}, {"type": "LiteralStr", "value": 'computer and software stores'}, {"type": "LiteralStr", "value": 'family clothing stores'}, {"type": "LiteralStr", "value": 'all other merchandise stores'}, {"type": "LiteralStr", "value": 'all other home furnishings stores'}, {"type": "LiteralStr", "value": 'general merchandise stores'}, {"type": "LiteralStr", "value": 'automobile dealers'}, {"type": "LiteralStr", "value": 'discount department stores'}, {"type": "LiteralStr", "value": 'building supplies dealers'}, {"type": "LiteralStr", "value": "men's clothing stores"}, {"type": "LiteralStr", "value": 'pharmacies and drug stores'}, {"type": "LiteralStr", "value": 'gift, novelty, and souvenir stores'}, {"type": "LiteralStr", "value": 'limited service eating places'}, {"type": "LiteralStr", "value": 'food services and drinking places'}, {"type": "LiteralStr", "value": 'all department stores'}, {"type": "LiteralStr", "value": 'clothing stores'}, {"type": "LiteralStr", "value": 'retail trade'}, {"type": "LiteralStr", "value": 'retail trade, ex auto'}, {"type": "LiteralStr", "value": 'shoe stores'}, {"type": "LiteralStr", "value": 'new car dealers'}, {"type": "LiteralStr", "value": 'drinking places'}, {"type": "LiteralStr", "value": 'radio, TV, and electronics stores'}, {"type": "LiteralStr", "value": 'office supplies and stationery stores'}, {"type": "LiteralStr", "value": 'jewelry stores'}, {"type": "LiteralStr", "value": 'used merchandise stores'}, {"type": "LiteralStr", "value": 'floor covering stores'}, {"type": "LiteralStr", "value": 'gafo'}, {"type": "LiteralStr", "value": 'used car dealers'}, {"type": "LiteralStr", "value": 'home furnishings stores'}, {"type": "LiteralStr", "value": 'other clothing stores'}, {"type": "LiteralStr", "value": 'appliances and other electronics stores'}, {"type": "LiteralStr", "value": 'health and personal care stores'}, {"type": "LiteralStr", "value": 'full service restaurants'}, {"type": "LiteralStr", "value": 'motor vehicle and parts dealers'}, {"type": "LiteralStr", "value": 'beer, wine, and liquor stores'}, {"type": "LiteralStr", "value": 'furniture and home furnishings stores'}, {"type": "LiteralStr", "value": 'nonstore retailers'}, {"type": "LiteralStr", "value": 'automotive parts and tire stores'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'electronic shopping and mail-order houses'}, {"type": "LiteralStr", "value": 'grocery stores'}, {"type": "LiteralStr", "value": 'furniture, home furn, electronics, and appliance stores'}, {"type": "LiteralStr", "value": 'book stores'}, {"type": "LiteralStr", "value": 'household appliance stores'}, {"type": "LiteralStr", "value": 'non-leased department stores'}, {"type": "LiteralStr", "value": 'furniture stores'}, {"type": "LiteralStr", "value": 'retail trade and food services, ex auto'}, {"type": "LiteralStr", "value": 'sporting goods, hobby, book, and music stores'}, {"type": "LiteralStr", "value": 'building materials and garden supplies dealers'}, {"type": "LiteralStr", "value": 'non-discount department stores'}, {"type": "LiteralStr", "value": 'supermarkets and other grocery (except convenience) stores'}, {"type": "LiteralStr", "value": 'food and beverage stores'}, {"type": "LiteralStr", "value": "women's clothing stores"}, {"type": "LiteralStr", "value": 'electronics and appliance stores'}, {"type": "LiteralStr", "value": 'office supplies, stationery, and gift stores'}, {"type": "LiteralStr", "value": 'retail trade and food services'}, {"type": "LiteralStr", "value": 'sporting goods stores'}, {"type": "LiteralStr", "value": 'paint and wallpaper stores'}, {"type": "LiteralStr", "value": 'fuel dealers'}, {"type": "LiteralStr", "value": 'hardware stores'}, {"type": "LiteralStr", "value": 'gasoline stations'}, {"type": "LiteralStr", "value": 'miscellaneous store retailers'}, {"type": "LiteralStr", "value": 'other general merchandise stores'}, {"type": "LiteralStr", "value": 'auto and other motor vehicles'}, {"type": "LiteralStr", "value": 'hobby, toy, and game stores'}, {"type": "LiteralStr", "value": 'warehouse clubs and superstores'}, {"type": "LiteralStr", "value": 'computer and software stores'}, {"type": "LiteralStr", "value": 'family clothing stores'}, {"type": "LiteralStr", "value": 'all other merchandise stores'}, {"type": "LiteralStr", "value": 'all other home furnishings stores'}, {"type": "LiteralStr", "value": 'general merchandise stores'}, {"type": "LiteralStr", "value": 'automobile dealers'}, {"type": "LiteralStr", "value": 'discount department stores'}, {"type": "LiteralStr", "value": 'building supplies dealers'}, {"type": "LiteralStr", "value": "men's clothing stores"}, {"type": "LiteralStr", "value": 'pharmacies and drug stores'}, {"type": "LiteralStr", "value": 'gift, novelty, and souvenir stores'}, {"type": "LiteralStr", "value": 'limited service eating places'}, {"type": "LiteralStr", "value": 'food services and drinking places'}, {"type": "LiteralStr", "value": 'all department stores'}, {"type": "LiteralStr", "value": 'clothing stores'}, {"type": "LiteralStr", "value": 'retail trade'}, {"type": "LiteralStr", "value": 'retail trade, ex auto'}, {"type": "LiteralStr", "value": 'shoe stores'}, {"type": "LiteralStr", "value": 'new car dealers'}, {"type": "LiteralStr", "value": 'drinking places'}, {"type": "LiteralStr", "value": 'radio, TV, and electronics stores'}, {"type": "LiteralStr", "value": 'office supplies and stationery stores'}, {"type": "LiteralStr", "value": 'jewelry stores'}, {"type": "LiteralStr", "value": 'used merchandise stores'}, {"type": "LiteralStr", "value": 'floor covering stores'}, {"type": "LiteralStr", "value": 'gafo'}, {"type": "LiteralStr", "value": 'used car dealers'}, {"type": "LiteralStr", "value": 'home furnishings stores'}, {"type": "LiteralStr", "value": 'other clothing stores'}, {"type": "LiteralStr", "value": 'appliances and other electronics stores'}, {"type": "LiteralStr", "value": 'health and personal care stores'}, {"type": "LiteralStr", "value": 'full service restaurants'}, {"type": "LiteralStr", "value": 'motor vehicle and parts dealers'}, {"type": "LiteralStr", "value": 'beer, wine, and liquor stores'}, {"type": "LiteralStr", "value": 'furniture and home furnishings stores'}, {"type": "LiteralStr", "value": 'nonstore retailers'}, {"type": "LiteralStr", "value": 'automotive parts and tire stores'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'electronic shopping and mail-order houses'}, {"type": "LiteralStr", "value": 'grocery stores'}, {"type": "LiteralStr", "value": 'furniture, home furn, electronics, and appliance stores'}, {"type": "LiteralStr", "value": 'book stores'}, {"type": "LiteralStr", "value": 'household appliance stores'}, {"type": "LiteralStr", "value": 'non-leased department stores'}, {"type": "LiteralStr", "value": 'furniture stores'}, {"type": "LiteralStr", "value": 'retail trade and food services, ex auto'}, {"type": "LiteralStr", "value": 'sporting goods, hobby, book, and music stores'}, {"type": "LiteralStr", "value": 'building materials and garden supplies dealers'}, {"type": "LiteralStr", "value": 'non-discount department stores'}, {"type": "LiteralStr", "value": 'supermarkets and other grocery (except convenience) stores'}, {"type": "LiteralStr", "value": 'food and beverage stores'}, {"type": "LiteralStr", "value": "women's clothing stores"}, {"type": "LiteralStr", "value": 'electronics and appliance stores'}, {"type": "LiteralStr", "value": 'office supplies, stationery, and gift stores'}, {"type": "LiteralStr", "value": 'retail trade and food services'}, {"type": "LiteralStr", "value": 'sporting goods stores'}, {"type": "LiteralStr", "value": 'paint and wallpaper stores'}, {"type": "LiteralStr", "value": 'fuel dealers'}, {"type": "LiteralStr", "value": 'hardware stores'}, {"type": "LiteralStr", "value": 'gasoline stations'}, {"type": "LiteralStr", "value": 'miscellaneous store retailers'}, {"type": "LiteralStr", "value": 'other general merchandise stores'}, {"type": "LiteralStr", "value": 'auto and other motor vehicles'}, {"type": "LiteralStr", "value": 'hobby, toy, and game stores'}, {"type": "LiteralStr", "value": 'warehouse clubs and superstores'}, {"type": "LiteralStr", "value": 'computer and software stores'}, {"type": "LiteralStr", "value": 'family clothing stores'}, {"type": "LiteralStr", "value": 'all other merchandise stores'}, {"type": "LiteralStr", "value": 'all other home furnishings stores'}, {"type": "LiteralStr", "value": 'general merchandise stores'}, {"type": "LiteralStr", "value": 'automobile dealers'}, {"type": "LiteralStr", "value": 'discount department stores'}, {"type": "LiteralStr", "value": 'building supplies dealers'}, {"type": "LiteralStr", "value": "men's clothing stores"}, {"type": "LiteralStr", "value": 'pharmacies and drug stores'}, {"type": "LiteralStr", "value": 'gift, novelty, and souvenir stores'}, {"type": "LiteralStr", "value": 'limited service eating places'}, {"type": "LiteralStr", "value": 'food services and drinking places'}, {"type": "LiteralStr", "value": 'all department stores'}, {"type": "LiteralStr", "value": 'clothing stores'}, {"type": "LiteralStr", "value": 'retail trade'}, {"type": "LiteralStr", "value": 'retail trade, ex auto'}, {"type": "LiteralStr", "value": 'shoe stores'}, {"type": "LiteralStr", "value": 'new car dealers'}, {"type": "LiteralStr", "value": 'drinking places'}, {"type": "LiteralStr", "value": 'radio, TV, and electronics stores'}, {"type": "LiteralStr", "value": 'office supplies and stationery stores'}, {"type": "LiteralStr", "value": 'jewelry stores'}, {"type": "LiteralStr", "value": 'used merchandise stores'}, {"type": "LiteralStr", "value": 'floor covering stores'}, {"type": "LiteralStr", "value": 'gafo'}, {"type": "LiteralStr", "value": 'used car dealers'}, {"type": "LiteralStr", "value": 'home furnishings stores'}, {"type": "LiteralStr", "value": 'other clothing stores'}, {"type": "LiteralStr", "value": 'appliances and other electronics stores'}, {"type": "LiteralStr", "value": 'health and personal care stores'}, {"type": "LiteralStr", "value": 'full service restaurants'}, {"type": "LiteralStr", "value": 'motor vehicle and parts dealers'}, {"type": "LiteralStr", "value": 'beer, wine, and liquor stores'}, {"type": "LiteralStr", "value": 'furniture and home furnishings stores'}, {"type": "LiteralStr", "value": 'nonstore retailers'}, {"type": "LiteralStr", "value": 'automotive parts and tire stores'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'month'}, {"type": "LiteralStr", "value": 'period'}, {"type": "LiteralStr", "value": 'year'}, {"type": "LiteralStr", "value": 'index'}, {"type": "LiteralStr", "value": 'month name'}], "values": [
					{"type": "NumType"}, 
					{"type": "StrType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "StrType"}]}]}},
            }
        
        }
    }

class _Constants(object):
    '''
    Global singleton object to hide some of the constants; some IDEs reveal internal module details very aggressively, and there's no other way to hide stuff.
    '''
    _HEADER = {'User-Agent': 
              'CORGIS Retail Services library for educational purposes'}
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
                                          "retail_services.db")
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



def get_report(test=False):
    """
    Returns sales, inventory, and ratio data for every month.
    
    """
    if _Constants._TEST or test:
        rows = _Constants._DATABASE.execute("SELECT data FROM retail_services LIMIT {hardware}".format(
            hardware=_Constants._HARDWARE))
        data = [r[0] for r in rows]
        data = [_Auxiliary._byteify(_json.loads(r)) for r in data]
        
        return _Auxiliary._byteify(data)
        
    else:
        rows = _Constants._DATABASE.execute("SELECT data FROM retail_services".format(
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
    print("Production get_report")
    start_time = _default_timer()
    result = get_report()
    
    print("{} entries found.".format(len(result)))
    _pprint(_Auxiliary._guess_schema(result))
    
    print("Time taken: {}".format(_default_timer() - start_time))
    # Test test
    print("Test get_report")
    start_time = _default_timer()
    result = get_report(test=True)
    
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