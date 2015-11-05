from __future__ import print_function

__version__ = '3'

import sys
from pprint import pprint
import difflib
import shelve
try:
    import simplejson as json
except ImportError:
    import json
import time
    
PYTHON_3 = sys.version_info >= (3, 0)
HEADER = { 'User-Agent' : 'CORGIS Gutenberg library for educational purposes' }

if PYTHON_3:
    from urllib.error import HTTPError
    import urllib.request as request
    from urllib.parse import quote_plus
else:
    from urllib2 import HTTPError
    import urllib2
    from urllib import quote_plus
        
################################################################################
# Exceptions
################################################################################
class GutenbergException(Exception):
    pass
    
################################################################################
# Domain Data
################################################################################

    
################################################################################
# Cache
################################################################################
try:
    with open('cache.json', 'r') as c:
        _CACHE = json.load(c)
except IOError:
    _CACHE= {}
def _cache_load(title):
    return _CACHE.get(title.lower(), None)
def _cache_add(title, value):
    _CACHE[title.lower()] = value
    with open('cache.json', 'w') as c:
        json.dump(_CACHE, c)
    
################################################################################
# Domain Functions
################################################################################

def get_book(title):
    '''
    Returns the closest book with the given title.
    
    :param str title: The name of the book you want to find
    :returns: a dictionary representing the book
    '''
    # Hopefully they know the exact name
    title = title.lower()
    TITLE_INDEX = [f.lower() for f in BOOK_METADATA.keys()]
    if title not in TITLE_INDEX:
        # Or something close to it
        potentials = difflib.get_close_matches(title, TITLE_INDEX, cutoff=.6)
        if potentials:
            raise GutenbergException("Error, the given identifier could not be found. Perhaps you meant one of:\n\t{}".format('\n\t'.join(map('"{}"'.format, potentials))))
        else:
            raise GutenbergException("Error, the given identifier could not be found. Please check to make sure you have the right spelling.")
    cache_hit = _cache_load(title)
    if cache_hit is not None:
        return cache_hit
    else:
        copy = dict(BOOK_METADATA[title])
        copy['text'] = _get_text(copy['url'])
        if copy['text'].strip().startswith('<!DOCTYPE html PUBLIC'):
            raise GutenbergException("Looks like you're using the web service too much. Slow down. Before you can keep using the service, go to {} and pass their captcha.".format(BOOK_METADATA[title]['url']))
        time.sleep(1)
    _cache_add(title, copy)
    return copy
                


def _get_text(url):
    """
    Retrieves the actual text of the book, given a url.
    
    :returns str: The text of the book
    """
    try:
        result = _get(url)
    except HTTPError as e:
        raise GutenbergException("Internet error ({}): {}".format(e.code, e.reason))
    return result

################################################################################
# Auxilary
################################################################################

def _urlencode(query, params):
    """
    Internal method to combine the url and params into a single url string.

    :param str query: the base url to query
    :param dict params: the parameters to send to the url
    :returns: a *str* of the full url
    """
    return query + '?' + '&'.join(key+'='+quote_plus(str(value))
                                  for key, value in _iteritems(params))

def _parse_int(value, default=0):
    """
    Attempt to cast *value* into an integer, returning *default* if it fails.
    """
    if value is None:
        return default
    try:
        return int(value)
    except ValueError:
        return default

def _parse_float(value, default=0.0):
    """
    Attempt to cast *value* into a float, returning *default* if it fails.
    """
    if value is None:
        return default
    try:
        return float(value)
    except ValueError:
        return default

def _parse_boolean(value, default=False):
    """
    Attempt to cast *value* into a bool, returning *default* if it fails.
    """
    if value is None:
        return default
    try:
        return bool(value)
    except ValueError:
        return default
        
def _get(url):
    """
    Convert a URL into it's response (a *str*).
    """
    print("internet connection")
    if PYTHON_3:
        req = request.Request(url, headers=HEADER)
        response = request.urlopen(req)
        return str(response.read().decode('utf-8').encode('ascii', 'replace'))
    else:
        req = urllib2.Request(url, headers=HEADER)
        response = urllib2.urlopen(req)
        return response.read().encode('ascii', 'replace')
        
def _iteritems(_dict):
    """
    Internal method to factor-out Py2-to-3 differences in dictionary item
        iterator methods

    :param dict _dict: the dictionary to parse
    :returns: the iterable dictionary
    """
    if PYTHON_3:
        return _dict.items()
    else:
        return _dict.iteritems()
        
def _recursively_convert_unicode_to_str(input):
    """
    Force the given input to only use `str` instead of `bytes` or `unicode`.
    This works even if the input is a dict, list, 
    """
    if isinstance(input, dict):
        return {_recursively_convert_unicode_to_str(key): _recursively_convert_unicode_to_str(value) for key, value in input.items()}
    elif isinstance(input, list):
        return [_recursively_convert_unicode_to_str(element) for element in input]
    elif PYTHON_3 and isinstance(input, str):
        return str(input.encode('ascii', 'replace').decode('ascii'))
    elif not PYTHON_3 and isinstance(input, unicode):
        return str(input.encode('ascii', 'replace').decode('ascii'))
    else:
        return input

def _from_json(data):
    """
    Convert the given string data into a JSON dict/list/primitive, ensuring that
    `str` are used instead of bytes.
    """
    return _recursively_convert_unicode_to_str(json.loads(data))
    

    
################################################################################
# Main
################################################################################
    
def connect():
    pass
 
try:
    BOOK_METADATA = {k.lower(): v for k,v in json.load(open('indexed_books.json')).items()}
except (OSError, IOError):
    raise GutenbergException("Error! Could not find the \"index.db\" file. Make sure that it is in the same directory as gutenberg.py!")
    
#BOOK_METADATA = {}
#try:
#    BOOK_METADATA = _recursively_convert_unicode_to_str(json.load(open("indexed_books.json")))
#except (OSError, IOError):
#    raise GutenbergException("Error! Could not find the \"indexed_books.json\" file. Make sure that it is in the same directory as gutenberg.py!")
    
if __name__ == '__main__':
    print("Current cache")
    for title in sorted(_CACHE.keys()):
        print("\t", title)
    print("Adding")
    for title in  ['Leaves of Grass']:
        book = get_book(title)
        book['text'] = book['text'][:100]
        print("\t",title)