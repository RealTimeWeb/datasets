import sys as _sys
import os as _os
import json as _json
import sqlite3 as _sql
import difflib as _difflib

class _Constants(object):
    _HEADER = {'User-Agent': 
              'CORGIS Weather library for educational purposes'}
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
    
_Constants._DATABASE_NAME = "weather.db"
if not _os.access(_Constants._DATABASE_NAME, _os.F_OK):
    raise DatasetException("Error! Could not find a \"{0}\" file. Make sure that there is a \"{0}\" in the same directory as \"{1}.py\"! Spelling is very important here.".format(_Constants._DATABASE_NAME, __name__))
elif not _os.access(_Constants._DATABASE_NAME, _os.R_OK):
    raise DatasetException("Error! Could not read the \"{0}\" file. Make sure that it readable by changing its permissions. You may need to get help from your instructor.".format(_Constants._DATABASE_NAME, __name__))

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
            


    @staticmethod
    def _iteritems(_dict):
        """
        Internal method to factor-out Py2-to-3 differences in dictionary item
            iterator methods

        :param dict _dict: the dictionary to parse
        :returns: the iterable dictionary
        """
        return _dict.items() if _Constants._PYTHON_3 else _dict.iteritems()

    @staticmethod
    def _urlencode(query, params):
        """
        Internal method to combine the url and params into a single url string.

        :param str query: the base url to query
        :param dict params: the parameters to send to the url
        :returns: a *str* of the full url
        """
        return query + '?' + '&'.join(key+'='+_quote_plus(str(value))
                                      for key, value in _Auxiliary._iteritems(params))

    @staticmethod
    def _get(url):
        """
        Internal method to convert a URL into it's response (a *str*).

        :param str url: the url to request a response from
        :returns: the *str* response
        """
        if _Constants._PYTHON_3:
            req = _request.Request(url, headers=_Constants._HEADER)
            response = _request.urlopen(req)
            return response.read().decode('utf-8')
        else:
            req = _urllib2.Request(url, headers=_Constants._HEADER)
            response = _urllib2.urlopen(req)
            return response.read()

################################################################################
# Cache
################################################################################

class _Cache(object):
    GEOCODE_ERRORS = {"REQUEST_DENIED": "The given address was denied.",
				  "ZERO_RESULTS": "The given address could not be found.",
				  "OVER_QUERY_LIMIT": "The geocoding service has been used too many times today.",
				  "INVALID_REQUEST": "The given address was invalid.",
				  "UNKNOWN_ERROR": "A temporary error occurred; please try again.",
				  "UNAVAILABLE": "The given address is not available offline."}

    def __init__(self):
        self._cache = {}
        self._cache_count = {}
        self._editable = False
        self._connected = True
        self._pattern = 'repeat'
        
    def get(self, indexed_query, full_query):
        '''
        Get any data available for this query if online, else get the offline
        '''
        return _Auxiliary._get(full_query) if self._connected else self.lookup(indexed_query)
    
    def start_editing(self, pattern="repeat"):
        """
        Start adding seen entries to the cache. So, every time that you make a request,
        it will be saved to the cache. You must :ref:`_save_cache` to save the
        newly edited cache to disk, though!
        """
        self._editable = True
        self._pattern = pattern

    def stop_editing(self):
        """
        Stop adding seen entries to the cache.
        """
        self._editable = False

    def add_to_cache(self, key, value):
        """
        Internal method to add a new key-value to the local cache.
        :param str key: The new url to add to the cache
        :param str value: The HTTP response for this key.
        :returns: void
        """
        if key in self._cache:
            self._cache[key].append(value)
        else:
            self._cache[key] = [self._pattern, value]
            self._cache[key] = 0

    def clear_key(self, key):
        """
        Internal method to remove a key from the local cache.
        :param str key: The url to remove from the cache
        """
        if key in self._cache:
            del self._cache[key]

    def save_cache(self, filename="cache.json"):
        """
        Internal method to save the cache in memory to a file, so that it can be used later.

        :param str filename: the location to store this at.
        """
        with open(filename, 'w') as f:
            _json.dump({"data": self._cache, "metadata": ""}, f)

    def lookup(self, key):
        """
        Internal method that looks up a key in the local cache.

        :param key: Get the value based on the key from the cache.
        :type key: string
        :returns: void
        """
        if key not in self._cache:
            return ""
        if self._cache_counter[key] >= len(self._cache[key][1:]):
            if self._cache[key][0] == "empty":
                return ""
            elif self._cache[key][0] == "repeat" and self._cache[key][1:]:
                return self._cache[key][-1]
            elif self._cache[key][0] == "repeat":
                return ""
            else:
                self._cache_counter[key] = 1
        else:
            self._cache_counter[key] += 1
        if self._cache[key]:
            return self._cache[key][self._cache_counter[key]]
        else:
            return ""
            
    def is_connected(self):
        return self._connected
            
    def connect(self):
        """
        Connect to the online data source in order to get up-to-date information.

        :returns: void
        """
        self._connected = True


    def disconnect(self, filename="./cache.json"):
        """
        Connect to the local cache, so no internet connection is required.

        :returns: void
        """
        try:
            with open(filename, 'r') as f:
                raw_data = _json.load(f)
                self._cache = _recursively_convert_unicode_to_str(raw_data)['data']
        except (OSError, IOError) as e:
            raise Weather(
                "The cache file '{}' was not found.".format(filename))
        for key in self._cache.keys():
            self._cache_counter[key] = 0
        self._connected = False
        
    def _geocode_intepret(self, response):
        if response == "":
            if self._connected:
                raise DatasetException("Nothing was returned from the server.")
            else:
                raise DatasetException("The given city was not in the cache.")
        try:
            geocode_data = _Auxiliary._byteify(_json.loads(response))
        except ValueError:
            raise DatasetException("The response from the Server was invalid. Perhaps the internet is down?")
        status = geocode_data.get('status', 'INVALID_RETURN')
        if status == 'OK':
            try:
                results = geocode_data['results']
                if results:
                    location = results[0]['geometry']['location']
                    latitude = location['lat']
                    longitude = location['lng']
                else:
                    raise DatasetException("The address could not be found; check that it's valid on Google Maps.")
            except KeyError:
                raise DatasetException("The response from the Geocode server was invalid. Perhaps this wasn't a valid address?")
            return latitude, longitude
        else:
            raise DatasetException(self.GEOCODE_ERRORS.get(status, "Unknown error occurred: "+status))
        
    def geocode(self, address):
        address = ",".join([p.strip() for p in address.lower().split(",")])
        arguments = dict([("address", address), ("sensor", "true")])
        key = _Auxiliary._urlencode("http://maps.googleapis.com/maps/api/geocode/json", arguments)
        try:
            result = self.get(key, key)
        except _HTTPError as e:
            raise DatasetException("Could not connect. Check your internet connection.")
        # Store to the cache if necessary
        try:
            if self._connected and self._editable:
                self.add_to_cache(full_query, result)
            return self._geocode_intepret(result)
        except ValueError:
            raise DatasetException("Internal Error.")
        
_CACHE = _Cache()
_start_editing = _CACHE.start_editing
_stop_editing = _CACHE.stop_editing
_save_cache = _CACHE.stop_editing
connect = _CACHE.connect
disconnect = _CACHE.disconnect



################################################################################
# Domain Objects
################################################################################
    

    

def _forecastgov_request(lat, lon, fcsttype="json"):
    """
    Connects to an online data source and retrieves information from http://forecast.weather.gov/MapClick.php
    
    :param lat: The latitude
    :type lat: float
    :param lon: The longitude
    :type lon: float
    :param fcsttype: A hidden parameter that controls the result format.
    :type fcsttype: string
    :returns: str
    """
    baseurl = "http://forecast.weather.gov/MapClick.php"
    
    # Build up the query
    full_query = _Auxiliary._urlencode(baseurl, {
                                       'lat': lat,
                                       'lon': lon,
                                       'FcstType': fcsttype})
    
    # Retrieve the data, either cached or online
    try:
        result = _CACHE.get(full_query, full_query)
    except _HTTPError as e:
        raise DatasetException("Could not connect. Check your internet connection.")
    
    # Make sure the result is not empty
    if not result:
        raise DatasetException("There were no results.")
        
    # Store to the cache if necessary
    try:
        if _CACHE._connected and _CACHE._editable:
            _CACHE.add_to_cache(full_query, result)
        return result
    except ValueError:
        raise DatasetException("Internal Error.")



################################################################################
# Interfaces
################################################################################



def get_report(city):
    """
    Gets a report on the current weather, forecast, and more detailed information about the location.
    
    :param city: The name of the city you want to get information about.
    :type city: str
    """
    
    if False:
        # If there was a Test version of this method, it would go here. But alas.
        pass
    else:
        lat,  lon = _CACHE.geocode(city)
        r = _forecastgov_request(lat, lon)
        r = _Auxiliary._byteify(_json.loads(r))
        
        return r
        

def get_temperature(city):
    """
    
    
    :param city: The name of the city you want to get information about.
    :type city: str
    """
    
    if False:
        # If there was a Test version of this method, it would go here. But alas.
        pass
    else:
        lat,  lon = _CACHE.geocode(city)
        r = _forecastgov_request(lat, lon)
        r = _Auxiliary._byteify(_json.loads(r))['data']['temperature'][0]
        
        r = _Auxiliary._parse_type(r, int)
        
        return r
        

################################################################################
# Internalized testing code
################################################################################

def _test_interfaces():
    from pprint import pprint as _pprint
    from timeit import default_timer as _default_timer
    # Production test
    print("Production get_report")
    start_time = _default_timer()
    result = get_report("Blacksburg, VA")
    
    _pprint(result)
    
    print("Time taken: {}".format(_default_timer() - start_time))
    
    # Production test
    print("Production get_temperature")
    start_time = _default_timer()
    result = get_temperature("Blacksburg, VA")
    
    _pprint(result)
    
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