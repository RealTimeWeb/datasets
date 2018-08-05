'''
Hello student. Thank you for downloading a CORGIS library. However, you do not need to open this library. Instead you should use the following:

    import {{ metadata.name|snake_case }}
    
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
                },
        {% for tifa_definition in tifa_definitions %}
            '{{ tifa_definition[0] | snake_case }}': {
                "type": "FunctionType", 
                "name": '{{ tifa_definition[0] | snake_case }}',
                "returns": {{ tifa_definition[1] }},
            }
        {% endfor %}
        }
    }

class _Constants(object):
    '''
    Global singleton object to hide some of the constants; some IDEs reveal internal module details very aggressively, and there's no other way to hide stuff.
    '''
    _HEADER = {'User-Agent': 
              'CORGIS {{ metadata.name|title }} library for educational purposes'}
    _PYTHON_3 = _sys.version_info >= (3, 0)
    _TEST = False
    _HARDWARE = {{ metadata.hardware }}

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
                                          "{{ metadata.name|snake_case }}.db")
if not _os.access(_Constants._DATABASE_NAME, _os.F_OK):
    raise DatasetException("Error! Could not find a \"{0}\" file. Make sure that there is a \"{0}\" in the same directory as \"{1}.py\"! Spelling is very important here.".format(_Constants._DATABASE_NAME, __name__))
elif not _os.access(_Constants._DATABASE_NAME, _os.R_OK):
    raise DatasetException("Error! Could not read the \"{0}\" file. Make sure that it readable by changing its permissions. You may need to get help from your instructor.".format(_Constants._DATABASE_NAME, __name__))
{% if locals -%}
elif not _os.access(_Constants._DATABASE_NAME, _os.W_OK):
    _sys.stderr.write('The local cache (\" \") will not be updated. Make sure that it is writable by changing its permissions. You may need to get help from your instructor.\n'.format(_Constants._DATABASE_NAME))
    _sys.stderr.flush()
{% endif %}
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
            
{% if https %}

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
            raise {{ metadata.name|camel_case_caps }}(
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

{% endif %}

################################################################################
# Domain Objects
################################################################################
    
{% for object in objects %}
class {{ object.name | camel_case_caps }}(object):
    """
    {{ object.description }}
    """
    def __init__(self{% for field in object.fields %}, {{ field.name | snake_case }}{% endfor %}):
        """
        Creates a new {{ object.name | camel_case_caps }}.
        
        :param self: This object
        :type self: {{ object.name | camel_case_caps }}
        {% for field in object.fields -%}
        :param {{ field.name | snake_case }}: {{ field.description }}
        :type {{ field.name | snake_case }}: {{ field.type | to_python_type}}
        {% endfor -%}
        :returns: {{ object.name | camel_case_caps }}
        """
        {% for field in object.fields -%}
        self.{{ field.name | snake_case }} = {{ field.name | snake_case }}
        {% endfor %}
        
    def __unicode__(self):
        return """ <> """.format()

    def __repr__(self):
        if _Constants._PYTHON_3:
            return self.__unicode__().encode('utf-8')
        else:
            return self.__unicode__()

    def __str__(self):
        if _Constants._PYTHON_3:
            return self.__unicode__().encode('utf-8')
        else:
            return self.__unicode__()

    def _to_dict(self):
        '''
        Creates a dictionary based representation of this class
        '''
        return dict({%- for field in object.fields -%}
                        {%- if not field.type | is_list -%}
                            {{ field.name | snake_case }}=self.{{ field.name | snake_case }}
                            {%- if not field.type | is_builtin -%}
                                ._to_dict()
                            {%- endif -%}
                        {%- elif field.type | is_builtin -%}
                            {{ field.name | snake_case }}=self.{{ field.name | snake_case }}
                        {%- else -%}
                            {{ field.name | snake_case }}=map({{ field.type | camel_case_caps|strip_list }}._to_dict, self.{{ field.name | snake_case }})
                        {%- endif -%}
                        {%- if not loop.last -%}
                            ,
                        {% endif %}
                    {%- endfor %})
        
    @staticmethod
    def _from_json(json_data):
        """
        Creates a {{ object.name | camel_case_caps }} from json data.
        
        :param json_data: The raw json data to parse
        :type json_data: dict
        :returns: {{ object.name | camel_case_caps }}
        """
        return {{ object.name | camel_case_caps }}({% for field in object.fields -%}
                            {%- if field.type | is_builtin -%}
                                {{ field.path | parse_json_path| convert_builtin(field.type)}}
                            {%- elif field.type | is_list -%}
                                map({{ field.type | strip_list | camel_case_caps }}._from_json, {{ field.path | parse_json_path}})
                            {%- else -%}
                                {{ field.type | camel_case_caps }}._from_json({{ field.path | parse_json_path}})
                            {%- endif -%}
                            {% if not loop.last %},
                        {% endif %}{%- endfor %})
{% endfor %}
    
{% for http in https %}
def _{{ http.name | snake_case }}_request({% for arg in http.args %}{{arg.name | snake_case }}{% if arg.default %}={{ arg.default }}{% endif %}{% if not loop.last %}, {% endif %}{% endfor %}):
    """
    Connects to an online data source and retrieves information from {{ http.url }}
    
    {% for arg in http.args -%}
    :param {{arg.name | snake_case }}: {{ arg.description }}
    :type {{arg.name | snake_case }}: {{ arg.type }}
    {% endfor -%}
    :returns: str
    """
    baseurl = "{{ http.url | convert_url_parameters }}"{% if http.url_inputs %}.format({% for input in http.url_inputs %}{{ input.name | snake_case}}{% if not loop.last %},{% endif%}{% endfor %}){% endif %}
    
    # Build up the query
    full_query = _Auxiliary._urlencode(baseurl, {
                                       {%- for arg in http.args %}
                                       '{{arg.internal_name }}': {{arg.name| snake_case }}
                                       {%- if not loop.last %},{% endif -%}
                                       {%- endfor %}})
    
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

{% endfor %}

################################################################################
# Interfaces
################################################################################

{% for interface in interfaces %}

def {{ interface.name | snake_case }}({% for arg in interface.args %}{{arg.name| snake_case }}{% if not loop.last %}, {% endif %}{% endfor %}{% if interface.test %}{% if interface.args %}, {% endif %}test=False{% endif %}):
    """
    {{ interface.description }}
    
    {% for arg in interface.args -%}
    :param {{arg.name | snake_case }}: {{ arg.description }}
    :type {{arg.name | snake_case }}: {{ arg.type | to_python_type }}
    {% endfor -%}
    """
    {% for arg in interface.args -%}
    {% if arg.type in ("int", "float") %}
    if not isinstance({{arg.name|snake_case}}, {{ arg.type| to_python_type}}):
        raise DatasetException("Error, the parameter {{ arg.name|snake_case}} must be of type {{ arg.type|to_python_type}}")
    {% endif %}
    {% if arg.matches -%}
    # Match it against recommend values
    {% if arg.type in ("int", "float") %}
    potentials = {{arg.name|snake_case}}
    {% else %}
    potentials = [r[0].lower() for r in _Constants._DATABASE.execute("{{ arg.matches }}").fetchall()]
    if {{arg.name|snake_case}}.lower() not in potentials:
        best_guesses = _difflib.get_close_matches({{arg.name|snake_case}}, potentials)
        if best_guesses:
            raise DatasetException("Error, the given identifier could not be found. Perhaps you meant one of:\n\t{}".format('\n\t'.join(map('"{}"'.format, best_guesses))))
        else:
            raise DatasetException("Error, the given identifier could not be found. Please check to make sure you have the right spelling.")
    {% endif -%}
    {% endif -%}
    {% endfor -%}
    {% if interface.test -%}
    if _Constants._TEST or test:
        {% if interface.test.type == "SQL" -%}
        rows = _Constants._DATABASE.execute("{{ interface.test.sql }}".format(
            hardware=_Constants._HARDWARE){% if interface.args %},
            ({% for arg in interface.args %}{{arg.name| snake_case }}, {% endfor %}){% endif %})
        data = [r[0] for r in rows]
        {% if interface.test.post -%}
        data = [{{ interface.test.post|parse_bark }} for r in data]
        {% endif -%}
        {% if not interface.returns.startswith("list[") %}
        data = data[0]
        {% endif %}
        return _Auxiliary._byteify(data)
        {% endif %}
    {% else -%}
    if False:
        # If there was a Test version of this method, it would go here. But alas.
        pass
    {% endif -%}
    else:
        {% if interface.production.pre -%}
        {{ (interface.production.pre|parse_bark).lstrip() }}
        {% endif -%}
        {% if interface.production.type == "SQL" -%}
        rows = _Constants._DATABASE.execute("{{ interface.production.sql }}".format(
            hardware=_Constants._HARDWARE){% if interface.args %},
            ({% for arg in interface.args %}{{arg.name| snake_case }}, {% endfor %}){% endif %})
        data = [r[0] for r in rows]
        {% if interface.production.post -%}
        data = [{{ interface.production.post|parse_bark }} for r in data]
        {% if not interface.returns.startswith("list[") %}
        data = data[0]
        {% endif %}
        {% endif -%}
        return _Auxiliary._byteify(data)
        {% elif interface.production.type == "HTTP" -%}
        {% set http = lookup_https[interface.production.http] -%}
        r = _{{ interface.production.http | snake_case }}_request({% if http.args|selectattr('visible') %}{% for arg in http.args|selectattr('visible') %}{{arg.name| snake_case }}{% if not loop.last %}, {% endif %}{% endfor %}{% endif %})
        {% if interface.production.post -%}
        r = {{ interface.production.post|parse_bark }}
        {% endif -%}
        {% if interface.returns|is_builtin %}
        r = {{ 'r'|convert_builtin(interface.returns) }}
        {% endif %}
        return r
        {% endif -%}
        
{% endfor %}

################################################################################
# Internalized testing code
################################################################################

def _test_interfaces():
    from pprint import pprint as _pprint
    from timeit import default_timer as _default_timer
    {%- for interface in interfaces %}
    # Production test
    print("Production {{ interface.name | snake_case }}")
    start_time = _default_timer()
    result = {{ interface.name | snake_case }}({% for arg in interface.args %}{{arg.default|tojson|safe }}{% if not loop.last %}, {%endif %}{% endfor %})
    {% if interface.returns.startswith("list[") %}
    print("{} entries found.".format(len(result)))
    _pprint(_Auxiliary._guess_schema(result))
    {% else %}
    _pprint(result)
    {% endif %}
    print("Time taken: {}".format(_default_timer() - start_time))
    {% if interface.test -%}
    # Test test
    print("Test {{ interface.name | snake_case }}")
    start_time = _default_timer()
    result = {{ interface.name | snake_case }}({% for arg in interface.args %}{{arg.default|tojson|safe }}{% if not loop.last %}, {%endif %}{% endfor %}{% if interface.args %}, {% endif %}test=True)
    {% if interface.returns.startswith("list[") %}
    print("{} entries found.".format(len(result)))
    _pprint(_Auxiliary._guess_schema(result))
    {% else %}
    _pprint(result)
    {% endif %}
    print("Time taken: {}".format(_default_timer() - start_time))
    {% endif -%}
    {%- endfor %}

if __name__ == '__main__':
    from optparse import OptionParser as _OptionParser
    _parser = _OptionParser()
    _parser.add_option("-t", "--test", action="store_true",
                      default=False,
                      help="Execute the interfaces to test them.")
    (_options, _args) = _parser.parse_args()
    
    if _options.test:
        _test_interfaces()
