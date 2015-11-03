import sys as _sys
import os as _os
import json as _json
import sqlite3 as _sql
import difflib as _difflib

_HEADER = {'User-Agent': 
          'CORGIS {{ metadata.name|title }} library for educational purposes'}
_PYTHON_3 = _sys.version_info >= (3, 0)
_TEST = False
_HARDWARE = 1000

if _PYTHON_3:
    import urllib.request as _request
    from urllib.parse import quote_plus as _quote_plus
else:
    import urllib2 as _urllib2
    from urllib import quote_plus as _quote_plus
    
_DATABASE_NAME = "{{ metadata.name|flat_case }}.db"
if _os.path.isfile(_DATABASE_NAME):
    _DATABASE = _sql.connect(_DATABASE_NAME)
else:
    raise DatasetException("Error! Could not find the \"{}\" file. Make sure that it is in the same directory as {}.py!".format(_DATABASE_NAME, __name__))

################################################################################
# Auxilary
################################################################################

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
        
def _byteify(input):
    """
    Force the given input to only use `str` instead of `bytes` or `unicode`.
    This works even if the input is a dict, list,
    """
    if isinstance(input, dict):
        return {_byteify(key): _byteify(value) for key, value in input.items()}
    elif isinstance(input, list):
        return [_byteify(element) for element in input]
    elif _PYTHON_3 and isinstance(input, str):
        return str(input.encode('ascii', 'replace').decode('ascii'))
    elif not _PYTHON_3 and isinstance(input, unicode):
        return str(input.encode('ascii', 'replace').decode('ascii'))
    else:
        return input
        
{% if http %}

def _iteritems(_dict):
    """
    Internal method to factor-out Py2-to-3 differences in dictionary item
        iterator methods

    :param dict _dict: the dictionary to parse
    :returns: the iterable dictionary
    """
    return _dict.items() if _PYTHON_3 else _dict.iteritems()


def _urlencode(query, params):
    """
    Internal method to combine the url and params into a single url string.

    :param str query: the base url to query
    :param dict params: the parameters to send to the url
    :returns: a *str* of the full url
    """
    return query + '?' + '&'.join(key+'='+_quote_plus(str(value))
                                  for key, value in _iteritems(params))


def _get(url):
    """
    Internal method to convert a URL into it's response (a *str*).

    :param str url: the url to request a response from
    :returns: the *str* response
    """
    if _PYTHON_3:
        req = _request.Request(url, headers=_HEADER)
        response = _request.urlopen(req)
        return response.read().decode('utf-8')
    else:
        req = _urllib2.Request(url, headers=_HEADER)
        response = _urllib2.urlopen(req)
        return response.read()

################################################################################
# Cache
################################################################################

class _Cache(object):
    def __init__(self):
        self._cache = {}
        self._cache_count = {}
        self._editable = False
        self._connected = False
        self._pattern = 'repeat'
        
    def get(self, indexed_query, full_query):
        '''
        Get any data available for this query if online, else get the offline
        '''
        return _get(full_query) if self._connected else self._lookup(indexed_queryquery)
    
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
        
_CACHE = _Cache()
_start_editing = _CACHE.start_editing
_stop_editing = _CACHE.stop_editing
_save_cache = _CACHE.stop_editing
connect = _CACHE.connect
disconnect = _CACHE.disconnect

{% endif %}
        
################################################################################
# Exceptions
################################################################################


class DatasetException(Exception):
    ''' Thrown when there is an error loading the dataset for some reason.'''
    pass

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
        if _PYTHON_3:
            return self.__unicode__().encode('utf-8')
        else:
            return self.__unicode__()

    def __str__(self):
        if _PYTHON_3:
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
def _{{ http.name | snake_case }}_request({% for input in http.visible_inputs %}{{input.name| snake_case }}{% if not loop.last %}, {% endif %}{% endfor %}):
    """
    Used to build the request string used by :func:`{{ http.name | snake_case }}`.
    
    {% for input in http.visible_inputs -%}
    :param {{input.name | snake_case }}: {{ input.description }}
    :type {{input.name | snake_case }}: {{ input.type | to_python_type }}
    {% endfor -%}
    :returns: str
    """
    baseurl = "{{ http.url | convert_url_parameters }}".format({% for input in http.url_inputs %}{{ input.name | snake_case}}{% if not loop.last %},{% endif%}{% endfor %})
    indexed_query = _urlencode(baseurl, { {%- for input in http.visible_inputs -%}
                    '{{input.path }}': {{input.name| snake_case }}
                    {%- if not loop.last %}, 
                                         {% endif -%}
                  {%- endfor %} })
    full_query = _urlencode(baseurl, { {%- for input in http.payload_inputs -%}
                    '{{input.path }}': {% if input.hidden %}"{{input.default }}"{% else %}{{input.name| snake_case }}{% endif %}
                    {%- if not loop.last %}, 
                                      {% endif -%}
                  {%- endfor %} })
    try:
        result = _CACHE.get(indexed_query, full_query)
    except HTTPError as e:
        raise {{ metadata.name|camel_case_caps }}Exception("Could not connect.")
    
    if not result:
        raise {{ metadata.name|camel_case_caps }}Exception("There were no results.")
        
    try:
        if _CACHE._connected and _CACHE._editable:
            _CACHE.add_to_cache(indexed_query, result)
        return _recursively_convert_unicode_to_str(_json.loads(result))
    except ValueError:
        raise {{ metadata.name|camel_case_caps }}Exception("Internal Error.")

def {{ http.name | snake_case }}({% for input in http.visible_inputs %}{{input.name| snake_case }}{% if not loop.last %}, {% endif %}{% endfor %}):
    """
    {{ http.description }}
    
    {% for input in http.visible_inputs -%}
    :param {{input.name | snake_case }}: {{ input.description }}
    :type {{input.name | snake_case }}: {{ input.type | to_python_type }}
    {% endfor -%}
    
    :returns: {{ http.output | to_python_type }}
    """
    result = _{{ http.name | snake_case }}_request({% for input in http.visible_inputs %}{{input.name| snake_case }}{% if not loop.last %}, {% endif %}{% endfor %})
    {% if http.output | is_builtin -%}
    return result{{ http.post | parse_json_path("") }}
    {% elif http.output | is_list -%}
    result_list = map({{ http.output | strip_list | to_python_type }}._from_json, result{{ http.post | parse_json_path("")}})
    #return result_list
    return [item._to_dict() for item in result_list]
    {% else -%}
    class_result = {{ http.output | to_python_type }}._from_json(result{{ http.post | parse_json_path("") }})
    # return class_result
    return class_result._to_dict()
    {% endif %}
{% endfor %}

################################################################################
# Interfaces
################################################################################

{% for interface in interfaces %}

def {{ interface.name | snake_case }}({% for arg in interface.args %}{{arg.name| snake_case }}{% if not loop.last %}, {% endif %}{% endfor %}{% if interface.test %}{% if interface.args %}, {% endif %}test=True{% endif %}):
    """
    {{ interface.description }}
    
    {% for arg in interface.args -%}
    :param {{arg.name | snake_case }}: {{ arg.description }}
    :type {{arg.name | snake_case }}: {{ arg.type | to_python_type }}
    {% endfor -%}
    """
    {% for arg in interface.args -%}
    {% if arg.matches -%}
    # Match it against recommend values
    potentials = [r[0].lower() for r in _DATABASE.execute("{{ arg.matches }}").fetchall()]
    if {{arg.name|snake_case}}.lower() not in potentials:
        best_guesses = _difflib.get_close_matches({{arg.name|snake_case}}, potentials)
        if best_guesses:
            raise DatasetException("Error, the given identifier could not be found. Perhaps you meant one of:\n\t{}".format('\n\t'.join(map('"{}"'.format, best_guesses))))
        else:
            raise DatasetException("Error, the given identifier could not be found. Please check to make sure you have the right spelling.")
    {% endif %}
    {% endfor %}
    {% if interface.test %}
    if _TEST or test:
        {% if interface.test.type == "SQL" -%}
        rows = _DATABASE.execute("{{ interface.test.sql }}".format(
            hardware=_HARDWARE){% if interface.args %},
            ({% for arg in interface.args %}{{arg.name| snake_case }}, {% endfor %}){% endif %})
        data = [r[0] for r in rows]
        {% if interface.test.post -%}
        data = [{{ interface.test.post|parse_bark }} for r in data]
        {% endif -%}
        {% if not interface.returns.startswith("list[") %}
        data = data[0]
        {% endif %}
        return _byteify(data)
        {% endif -%}
    {% else %}
    if False:
        # If there was a Test version of this method, it would go here. But alas.
        pass
    {% endif %}
    else:
        {% if interface.production.type == "SQL" -%}
        rows = _DATABASE.execute("{{ interface.production.sql }}".format(
            hardware=_HARDWARE){% if interface.args %},
            ({% for arg in interface.args %}{{arg.name| snake_case }}, {% endfor %}){% endif %})
        data = [r[0] for r in rows]
        {% if interface.production.post -%}
        data = [{{ interface.production.post|parse_bark }} for r in data]
        {% if not interface.returns.startswith("list[") %}
        data = data[0]
        {% endif %}
        {% endif -%}
        return _byteify(data)
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
    result = {{ interface.name | snake_case }}({% for arg in interface.args %}{{arg.default }}{% if not loop.last %}, {%endif %}{% endfor %}{% if interface.args %}, {% endif %}{% if interface.test %}test=False{% endif %})
    {% if interface.returns.startswith("list[") %}
    print("{} entries found.".format(len(result)))
    _pprint(result[0])
    {% else %}
    _pprint(result)
    {% endif %}
    print("Time taken: {}".format(_default_timer() - start_time))
    {% if interface.test -%}
    # Test test
    print("Test {{ interface.name | snake_case }}")
    start_time = _default_timer()
    result = {{ interface.name | snake_case }}({% for arg in interface.args %}{{arg.default }}{% if not loop.last %}, {%endif %}{% endfor %})
    {% if interface.returns.startswith("list[") %}
    print("{} entries found.".format(len(result)))
    _pprint(result[0])
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
    _parser.add_option("-r", "--reset", action="store_true",
                      default=False,
                      help="Reset the cache")
    (_options, _args) = _parser.parse_args()
    
    if _options.test:
        _test_interfaces()

    if _options.reset:
        _modify_self()