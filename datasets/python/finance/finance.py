'''
Hello student. Thank you for downloading a CORGIS library. However, you do not need to open this library. Instead you should use the following:

    import finance
    
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
        
            'get_finances': {
                "type": "FunctionType", 
                "name": 'get_finances',
                "returns": 
		{"type": "ListType", "subtype": 
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Year'}, {"type": "LiteralStr", "value": 'State'}, {"type": "LiteralStr", "value": 'Details'}, {"type": "LiteralStr", "value": 'Totals'}], "values": [
				{"type": "NumType"}, 
				{"type": "StrType"}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Transportation'}, {"type": "LiteralStr", "value": 'Correction'}, {"type": "LiteralStr", "value": 'Employment'}, {"type": "LiteralStr", "value": 'Insurance Trust'}, {"type": "LiteralStr", "value": 'Financial Aid'}, {"type": "LiteralStr", "value": 'Natural Resources'}, {"type": "LiteralStr", "value": 'Public Welfare'}, {"type": "LiteralStr", "value": 'Intergovernmental'}, {"type": "LiteralStr", "value": 'Waste'}, {"type": "LiteralStr", "value": 'Education'}, {"type": "LiteralStr", "value": 'Welfare'}, {"type": "LiteralStr", "value": 'Health'}, {"type": "LiteralStr", "value": 'Utilities'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Transit Subsidy Intergovernmental'}, {"type": "LiteralStr", "value": 'Transit Subsidy Total Expenditure'}, {"type": "LiteralStr", "value": 'Water Transport'}, {"type": "LiteralStr", "value": 'Airports'}, {"type": "LiteralStr", "value": 'Parking'}, {"type": "LiteralStr", "value": 'Highways'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Water Transport Intergovernmental'}, {"type": "LiteralStr", "value": 'Water Transport Total Expenditure'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Airports Intergovernmental'}, {"type": "LiteralStr", "value": 'Airports Total Expenditure'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Parking Intergovernmental'}, {"type": "LiteralStr", "value": 'Parking Total'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Regular Highways Total Expenditure'}, {"type": "LiteralStr", "value": 'Highways Total Expenditure'}, {"type": "LiteralStr", "value": 'Toll Highways Total Expenditure'}, {"type": "LiteralStr", "value": 'Highways Construction Total'}, {"type": "LiteralStr", "value": 'Highways Intergovernmental'}, {"type": "LiteralStr", "value": 'Regular Highways Intergovernmental'}, {"type": "LiteralStr", "value": 'Highways Direct'}, {"type": "LiteralStr", "value": 'Highways Land and Equipment'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Correction Total'}, {"type": "LiteralStr", "value": 'Correction NEC Intergovernmental'}, {"type": "LiteralStr", "value": 'Correction Intergovernmental'}, {"type": "LiteralStr", "value": 'Correction NEC Total'}, {"type": "LiteralStr", "value": 'Correction Institutions Total'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Employee Retirement Total Expenditure'}, {"type": "LiteralStr", "value": 'Unemployment Comp Total Cash and Securities'}, {"type": "LiteralStr", "value": 'Employment Security Administration Intergovernmental'}, {"type": "LiteralStr", "value": 'Unemployment Comp Total Expenditure'}, {"type": "LiteralStr", "value": 'Employment Security Administration Expenditure Total'}, {"type": "LiteralStr", "value": 'Employee Retirement Total Cash and Securities'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Insurance Trust Federal Agency Securities'}, {"type": "LiteralStr", "value": 'Insurance Trust Cash and Deposits'}, {"type": "LiteralStr", "value": 'Insurance Trust Federal Securities'}, {"type": "LiteralStr", "value": 'Insurance Trust Securities Total'}, {"type": "LiteralStr", "value": 'Insurance Trust Other Securities'}, {"type": "LiteralStr", "value": 'Insurance Trust Cash and Securities'}, {"type": "LiteralStr", "value": 'Insurance Trust'}, {"type": "LiteralStr", "value": 'Insurance Trust Total Expenditure'}, {"type": "LiteralStr", "value": 'Insurance Trust State and Local Securities Total'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Beginning Long Term Debt Total Outstanding'}, {"type": "LiteralStr", "value": 'Assistance and Subsidies'}, {"type": "LiteralStr", "value": 'Categorical Assistance Total Expenditure'}, {"type": "LiteralStr", "value": 'Bond Fund Total'}, {"type": "LiteralStr", "value": 'Borrowing Total'}, {"type": "LiteralStr", "value": 'Categorical Assistance Intergovernmental'}, {"type": "LiteralStr", "value": 'Cash and Securities Total'}, {"type": "LiteralStr", "value": 'Cash Assistance Intergovernmental'}, {"type": "LiteralStr", "value": 'Federal Agency Securities Total'}, {"type": "LiteralStr", "value": 'Securities Total'}, {"type": "LiteralStr", "value": 'Cash Assistance Total Expenditure'}, {"type": "LiteralStr", "value": 'Sinking Fund Total'}, {"type": "LiteralStr", "value": 'Cash and Deposits Total'}], "values": [
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
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Natural Resources Equipment and Land'}, {"type": "LiteralStr", "value": 'Natural Resources Total'}, {"type": "LiteralStr", "value": 'Natural Resources Direct'}, {"type": "LiteralStr", "value": 'Natural Resources Construction'}, {"type": "LiteralStr", "value": 'Forestry'}, {"type": "LiteralStr", "value": 'Natural Resources NEC Total Expenditure'}, {"type": "LiteralStr", "value": 'Parks'}, {"type": "LiteralStr", "value": 'Fish and Game'}, {"type": "LiteralStr", "value": 'Agriculture'}, {"type": "LiteralStr", "value": 'Natural Resources Intergovernmental'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Forestry Intergovernmental'}, {"type": "LiteralStr", "value": 'Forestry Total Expenditure'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "NumType"}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Parks Total Expenditure'}, {"type": "LiteralStr", "value": 'Parks Intergovernmental'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Fish and Game Total Expenditure'}, {"type": "LiteralStr", "value": 'Fish and Game Intergovernmental'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Federal Agriculture Farm Income Intergovernmental'}, {"type": "LiteralStr", "value": 'Federal Farm Credit Total'}, {"type": "LiteralStr", "value": 'Agriculture Intergovernmental'}, {"type": "LiteralStr", "value": 'Federal Agriculture Farm Income Total'}, {"type": "LiteralStr", "value": 'Agriculture Total Expenditure'}, {"type": "LiteralStr", "value": 'Federal Farm Credit Intergovernmental'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Public Welfare Other Current Operation'}, {"type": "LiteralStr", "value": 'Public Welfare Total Expenditure'}, {"type": "LiteralStr", "value": 'Public Welfare Intergovernmental'}, {"type": "LiteralStr", "value": 'Public Welfare Assistance and Subsidies'}, {"type": "LiteralStr", "value": 'Public Welfare Equipment and Land'}, {"type": "LiteralStr", "value": 'Public Welfare Construction'}, {"type": "LiteralStr", "value": 'Public Welfare Direct Expenditure'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Intergovernmental Expenditure'}, {"type": "LiteralStr", "value": 'Intergovernmental to Federal'}, {"type": "LiteralStr", "value": 'Intergovernmental to Counties'}, {"type": "LiteralStr", "value": 'Intergovernmental to Townships'}, {"type": "LiteralStr", "value": 'Intergovernmental to Municipalities'}, {"type": "LiteralStr", "value": 'Intergovernmental to Combined and Unallocable'}, {"type": "LiteralStr", "value": 'Intergovernmental to School Districts'}, {"type": "LiteralStr", "value": 'Intergovernmental to Local'}, {"type": "LiteralStr", "value": 'Intergovernmental to State'}, {"type": "LiteralStr", "value": 'Intergovernmental to Special Districts'}], "values": [
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
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Solid Waste Management Total Expenditure'}, {"type": "LiteralStr", "value": 'Sewerage Total Expenditure'}, {"type": "LiteralStr", "value": 'Sewerage Intergovernmental'}, {"type": "LiteralStr", "value": 'Solid Waste Management Intergovernmental'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Higher Education-NEC Intergovernmental'}, {"type": "LiteralStr", "value": 'Education Total'}, {"type": "LiteralStr", "value": 'Edcation Assistance and Subsidies'}, {"type": "LiteralStr", "value": 'Elementary Secondary Intergovernmental'}, {"type": "LiteralStr", "value": 'Higher Education-Auxilliary Total Expenditure'}, {"type": "LiteralStr", "value": 'Education Other Current Operation'}, {"type": "LiteralStr", "value": 'Education Construction'}, {"type": "LiteralStr", "value": 'Education Equipment'}, {"type": "LiteralStr", "value": 'Higher Education-NEC Total Expenditure'}, {"type": "LiteralStr", "value": 'Education-NEC Expenditure Total'}, {"type": "LiteralStr", "value": 'Elementary Secondary Total Expenditure'}, {"type": "LiteralStr", "value": 'Education Intergovernmental'}, {"type": "LiteralStr", "value": 'Education-NEC Intergovernmental'}, {"type": "LiteralStr", "value": 'Education Equipment and Land'}], "values": [
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
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Welfare NEC Intergovernmental'}, {"type": "LiteralStr", "value": 'Welfare Vendor Payments Total'}, {"type": "LiteralStr", "value": 'Welfare Institution Total Expenditure'}, {"type": "LiteralStr", "value": 'Welfare NEC Total Expenditure'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Health Intergovernmental'}, {"type": "LiteralStr", "value": 'Hospitals'}, {"type": "LiteralStr", "value": 'Health Total Expenditure'}], "values": [
						{"type": "NumType"}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Hospitals Total Expenditure'}, {"type": "LiteralStr", "value": 'Hospital-Other Intergovernmental'}, {"type": "LiteralStr", "value": 'Hospitals Total Current'}, {"type": "LiteralStr", "value": 'Hospital-Other Total Expenditure'}, {"type": "LiteralStr", "value": 'Own Hospitals Total Expenditure'}, {"type": "LiteralStr", "value": 'Hospitals Total Intergovernmental'}, {"type": "LiteralStr", "value": 'Hospitals Total Construction'}, {"type": "LiteralStr", "value": 'Hospitals Total Equipment and land'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Water Utility Total Expenditure'}, {"type": "LiteralStr", "value": 'Utilities Current Operation'}, {"type": "LiteralStr", "value": 'Utilities Equipment and Land'}, {"type": "LiteralStr", "value": 'Transit Utility Total Expenditure'}, {"type": "LiteralStr", "value": 'Electric Utility Total Expenditure'}, {"type": "LiteralStr", "value": 'Utilities Total Expenditure'}, {"type": "LiteralStr", "value": 'Gas Utility Total Expenditure'}, {"type": "LiteralStr", "value": 'Utilities Construction'}, {"type": "LiteralStr", "value": 'Utilities Interest Total'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Equipment and land'}, {"type": "LiteralStr", "value": 'Tax'}, {"type": "LiteralStr", "value": 'Federal intergovernmental'}, {"type": "LiteralStr", "value": 'Expenditure'}, {"type": "LiteralStr", "value": 'Revenue'}, {"type": "LiteralStr", "value": "Worker's comp revenue"}, {"type": "LiteralStr", "value": 'License tax'}, {"type": "LiteralStr", "value": 'Sales tax'}, {"type": "LiteralStr", "value": 'Employee retirement revenue'}, {"type": "LiteralStr", "value": 'Charges'}, {"type": "LiteralStr", "value": 'Selective sales tax'}, {"type": "LiteralStr", "value": 'General revenue'}, {"type": "LiteralStr", "value": 'Other insurance trust revenue'}, {"type": "LiteralStr", "value": 'Utility revenue'}, {"type": "LiteralStr", "value": 'Miscellaneous'}, {"type": "LiteralStr", "value": 'State intergovernmental'}, {"type": "LiteralStr", "value": 'Local intergovernmental'}, {"type": "LiteralStr", "value": 'Miscellaneous commercial activity'}, {"type": "LiteralStr", "value": 'General expenditure'}, {"type": "LiteralStr", "value": 'Capital outlay'}, {"type": "LiteralStr", "value": 'Insurance trust  revenue'}, {"type": "LiteralStr", "value": 'Intergovernmental'}, {"type": "LiteralStr", "value": 'Unemployment comp revenue'}, {"type": "LiteralStr", "value": 'Construction'}], "values": [
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
					{"type": "NumType"}]}]}},
            }
        
        }
    }

class _Constants(object):
    '''
    Global singleton object to hide some of the constants; some IDEs reveal internal module details very aggressively, and there's no other way to hide stuff.
    '''
    _HEADER = {'User-Agent': 
              'CORGIS Finance library for educational purposes'}
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
                                          "finance.db")
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



def get_finances(test=False):
    """
    Returns financial data about all the states.
    
    """
    if _Constants._TEST or test:
        rows = _Constants._DATABASE.execute("SELECT data FROM finance LIMIT {hardware}".format(
            hardware=_Constants._HARDWARE))
        data = [r[0] for r in rows]
        data = [_Auxiliary._byteify(_json.loads(r)) for r in data]
        
        return _Auxiliary._byteify(data)
        
    else:
        rows = _Constants._DATABASE.execute("SELECT data FROM finance".format(
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
    print("Production get_finances")
    start_time = _default_timer()
    result = get_finances()
    
    print("{} entries found.".format(len(result)))
    _pprint(_Auxiliary._guess_schema(result))
    
    print("Time taken: {}".format(_default_timer() - start_time))
    # Test test
    print("Test get_finances")
    start_time = _default_timer()
    result = get_finances(test=True)
    
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