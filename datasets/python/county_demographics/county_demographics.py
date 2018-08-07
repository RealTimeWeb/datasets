'''
Hello student. Thank you for downloading a CORGIS library. However, you do not need to open this library. Instead you should use the following:

    import county_demographics
    
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
        
            'get_all_counties': {
                "type": "FunctionType", 
                "name": 'get_all_counties',
                "returns": 
		{"type": "ListType", "subtype": 
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Population'}, {"type": "LiteralStr", "value": 'Education'}, {"type": "LiteralStr", "value": 'Employment'}, {"type": "LiteralStr", "value": 'County'}, {"type": "LiteralStr", "value": 'Income'}, {"type": "LiteralStr", "value": 'Age'}, {"type": "LiteralStr", "value": 'Sales'}, {"type": "LiteralStr", "value": 'Ethnicities'}, {"type": "LiteralStr", "value": 'Housing'}, {"type": "LiteralStr", "value": 'State'}, {"type": "LiteralStr", "value": 'Miscellaneous'}], "values": [
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Population per Square Mile'}, {"type": "LiteralStr", "value": 'Population Percent Change'}, {"type": "LiteralStr", "value": '2014 Population'}, {"type": "LiteralStr", "value": '2010 Population'}], "values": [
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": "Bachelor's Degree or Higher"}, {"type": "LiteralStr", "value": 'High School or Higher'}], "values": [
					{"type": "NumType"}, 
					{"type": "NumType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Private Non-farm Establishments'}, {"type": "LiteralStr", "value": 'Private Non-farm Employment Percent Change'}, {"type": "LiteralStr", "value": 'Nonemployer Establishments'}, {"type": "LiteralStr", "value": 'Private Non-farm Employment'}, {"type": "LiteralStr", "value": 'Firms'}], "values": [
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Total'}, {"type": "LiteralStr", "value": 'Hispanic-Owned'}, {"type": "LiteralStr", "value": 'Native Hawaiian and Other Pacific Islander-Owned'}, {"type": "LiteralStr", "value": 'Black-Owned'}, {"type": "LiteralStr", "value": 'Women-Owned'}, {"type": "LiteralStr", "value": 'Asian-Owned'}, {"type": "LiteralStr", "value": 'American Indian-Owned'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}, 
				{"type": "StrType"}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Median Houseold Income'}, {"type": "LiteralStr", "value": 'Per Capita Income'}, {"type": "LiteralStr", "value": 'Persons Below Poverty Level'}], "values": [
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Percent Under 5 Years'}, {"type": "LiteralStr", "value": 'Percent Under 18 Years'}, {"type": "LiteralStr", "value": 'Percent 65 and Older'}], "values": [
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Retail Sales'}, {"type": "LiteralStr", "value": 'Merchant Wholesaler Sales'}, {"type": "LiteralStr", "value": 'Accommodation and Food Services Sales'}, {"type": "LiteralStr", "value": 'Retail Sales per Capita'}], "values": [
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'American Indian and Alaska Native Alone'}, {"type": "LiteralStr", "value": 'White Alone'}, {"type": "LiteralStr", "value": 'Native Hawaiian and Other Pacific Islander Alone'}, {"type": "LiteralStr", "value": 'Asian Alone'}, {"type": "LiteralStr", "value": 'Hispanic or Latino'}, {"type": "LiteralStr", "value": 'White Alone, not Hispanic or Latino'}, {"type": "LiteralStr", "value": 'Two or More Races'}, {"type": "LiteralStr", "value": 'Black Alone'}], "values": [
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Median Value of Owner-Occupied Units'}, {"type": "LiteralStr", "value": 'Households'}, {"type": "LiteralStr", "value": 'Persons per Household'}, {"type": "LiteralStr", "value": 'Homeownership Rate'}, {"type": "LiteralStr", "value": 'Housing Units'}, {"type": "LiteralStr", "value": 'Units in Multi-Unit Structures'}], "values": [
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}]}, 
				{"type": "StrType"}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Living in Same House +1 Years'}, {"type": "LiteralStr", "value": 'Manufacturers Shipments'}, {"type": "LiteralStr", "value": 'Mean Travel Time to Work'}, {"type": "LiteralStr", "value": 'Percent Female'}, {"type": "LiteralStr", "value": 'Language Other than English at Home'}, {"type": "LiteralStr", "value": 'Building Permits'}, {"type": "LiteralStr", "value": 'Land Area'}, {"type": "LiteralStr", "value": 'Foreign Born'}, {"type": "LiteralStr", "value": 'Veterans'}], "values": [
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}]}]}},
            }
        
        }
    }

class _Constants(object):
    '''
    Global singleton object to hide some of the constants; some IDEs reveal internal module details very aggressively, and there's no other way to hide stuff.
    '''
    _HEADER = {'User-Agent': 
              'CORGIS County Demographics library for educational purposes'}
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
                                          "county_demographics.db")
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



def get_all_counties(test=False):
    """
    Returns the report for each county from the dataset.
    
    """
    if _Constants._TEST or test:
        rows = _Constants._DATABASE.execute("SELECT data FROM county_demographics LIMIT {hardware}".format(
            hardware=_Constants._HARDWARE))
        data = [r[0] for r in rows]
        data = [_Auxiliary._byteify(_json.loads(r)) for r in data]
        
        return _Auxiliary._byteify(data)
        
    else:
        rows = _Constants._DATABASE.execute("SELECT data FROM county_demographics".format(
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
    print("Production get_all_counties")
    start_time = _default_timer()
    result = get_all_counties()
    
    print("{} entries found.".format(len(result)))
    _pprint(_Auxiliary._guess_schema(result))
    
    print("Time taken: {}".format(_default_timer() - start_time))
    # Test test
    print("Test get_all_counties")
    start_time = _default_timer()
    result = get_all_counties(test=True)
    
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