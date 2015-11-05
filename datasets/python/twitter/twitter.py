################################################################################
# Imports and Constants
################################################################################

# Identify Python version
import sys
PYTHON_3 = sys.version_info >= (3, 0)

# URL Libraries
if PYTHON_3:
    import urllib.request as request
    from urllib.parse import quote, quote_plus, urlunparse, urlparse, unquote
    from urllib.error import HTTPError
    unicode = type(None)
else:
    import urllib2 as request
    from urllib import quote, quote_plus, unquote
    from urllib2 import HTTPError
    from urlparse import urlunparse, urlparse

# Try to get json loaded; might require external package!
try:
    import simplejson as json
except ImportError:
    import json

# Various OAuth stuff    
import cgi
from time import time
from random import randint
import hmac
import binascii

# Embed your own keys for simplicity
CONSUMER_KEY        = "your key goes here"
CONSUMER_SECRET     = "your key goes here"
ACCESS_TOKEN        = "your key goes here"
ACCESS_TOKEN_SECRET = "your key goes here"
# Remove these lines; we just do this for our own simplicity
try:
    with open('twitter/secrets.txt', 'r') as secrets:
        CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN, ACCESS_TOKEN_SECRET = [l.strip() for l in secrets.readlines()]
except IOError:
    try:
        with open('secrets.txt', 'r') as secrets:
            CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN, ACCESS_TOKEN_SECRET = [l.strip() for l in secrets.readlines()]
    except IOError:
        pass

################################################################################
# Auxilary
################################################################################

def urlencode(query, params):
    """
    Correctly convert the given query and parameters into a full query+query
    string, ensuring the order of the params.
    """
    # apparently contrary to the HTTP RFCs, spaces in arguments must be encoded as
    # %20 rather than '+' when constructing an OAuth signature (and therefore
    # also in the request itself.)
    # Taken from sixohsix/twitter (https://github.com/sixohsix/twitter/)
    return query + '?' + "&".join(key+'='+quote_plus(str(value)) 
                                  for key, value in params).replace("+", "%20")
                                  

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
    headers = {'Content-Type' :'application/x-www-form-urlencoded',
               'User-Agent' : 'CORGIS Twitter library for educational purposes'}
    req = request.Request(url, headers=headers)
    response = request.urlopen(req)
    if PYTHON_3:
        return response.read().decode('utf-8')
    else:
        return response.read()
        
def _build_oauth_url(url, parameters):
    # via post body
    # -> some protected resources
    consumer = OAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET)
    token = OAuthToken(ACCESS_TOKEN, ACCESS_TOKEN_SECRET)
    oauth_request = OAuthRequest.from_consumer_and_token(consumer, token=token, http_method='GET', http_url=url, parameters=parameters)
    oauth_request.sign_request(OAuthSignatureMethod_HMAC_SHA1(), consumer, token)
    return oauth_request.to_url()
                
def _recursively_convert_unicode_to_str(input):
    """
    Force the given input to only use `str` instead of `bytes` or `unicode`.
    This works even if the input is a dict, list, 
    """
    if isinstance(input, dict):
        return {_recursively_convert_unicode_to_str(key): _recursively_convert_unicode_to_str(value) for key, value in input.items()}
    elif isinstance(input, list):
        return [_recursively_convert_unicode_to_str(element) for element in input]
    elif not PYTHON_3 and isinstance(input, unicode):
        return input.encode('ascii', 'replace')
    elif PYTHON_3 and isinstance(input, str):
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
# Cache
################################################################################

_CACHE = {}
_CACHE_COUNTER = {}
_EDITABLE = False
_CONNECTED = True
_PATTERN = "empty"
def _start_editing(pattern=_PATTERN):
    """
    Start adding seen entries to the cache. So, every time that you make a request,
    it will be saved to the cache. You must :ref:`_save_cache` to save the
    newly edited cache to disk, though!
    """
    global _EDITABLE, _PATTERN
    _EDITABLE = True
    _PATTERN = pattern
def _stop_editing():
    """
    Stop adding seen entries to the cache.
    """
    global _EDITABLE
    _EDITABLE = False
def connect(consumer_key=None, consumer_secret=None, access_token=None, access_token_secret=None):
    """
    Connect to the online data source in order to get up-to-date information.
    :returns: void
    """
    global _CONNECTED, CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN, ACCESS_TOKEN_SECRET
    _CONNECTED = True
    if consumer_key is not None:
        CONSUMER_KEY        = consumer_key
    if consumer_secret is not None:    
        CONSUMER_SECRET     = consumer_secret
    if access_token is not None:    
        ACCESS_TOKEN     = access_token
    if access_token_secret is not None:    
        ACCESS_TOKEN_SECRET     = access_token_secret
def disconnect(filename="twitter.json"):
    """
    Connect to the local cache, so no internet connection is required.
    :returns: void
    """
    global _CONNECTED, _CACHE
    try:
        with open(filename, 'r') as f:
            _CACHE = _recursively_convert_unicode_to_str(json.load(f))['data']
    except FileNotFoundError:
        raise USGSException("""The cache file '{0}' was not found, and I cannot disconnect without one. If you have not been given a twitter.json file, then you can create a new one:
    >>> from earthquakes import earthquakes
    >>> earthquakes.connect()
    >>> earthquakes._start_editing()
    ...
    >>> earthquakes.get_report()
    ...
    >>> earthquakes._save_cache('{0}')
""".format(filename))
    for key in _CACHE.keys():
        _CACHE_COUNTER[key] = 0
    _CONNECTED = False
def _lookup(key):
    """
    Internal method that looks up a key in the local cache.
    :param key: Get the value based on the key from the cache.
    :type key: string
    :returns: void
    """
    if key not in _CACHE:
        return None
    if _CACHE_COUNTER[key] >= len(_CACHE[key][1:]):
        if _CACHE[key][0] == "empty":
            return ""
        elif _CACHE[key][0] == "repeat" and _CACHE[key][1:]:
            return _CACHE[key][-1]
        elif _CACHE[key][0] == "repeat":
            return ""
        else:
            _CACHE_COUNTER[key] = 1
    else:
        _CACHE_COUNTER[key] += 1
    if _CACHE[key]:
        return _CACHE[key][_CACHE_COUNTER[key]]
    else:
        return ""
def _add_to_cache(key, value):
    """
    Internal method to add a new key-value to the local cache.
    :param str key: The new url to add to the cache
    :param str value: The HTTP response for this key.
    :returns: void
    """
    if key in _CACHE:
        _CACHE[key].append(value)
    else:
        _CACHE[key] = [_PATTERN, value]
        _CACHE_COUNTER[key] = 0
        
def _clear_key(key):
    """
    Internal method to remove a key from the local cache.
    :param str key: The url to remove from the cache
    """
    if key in _CACHE:
        del _CACHE[key]
        
def _save_cache(filename="twitter.json"):
    """
    Internal method to save the cache in memory to a file, so that it can be used later.
    
    :param str filename: the location to store this at.
    """
    with open(filename, 'w') as f:
        json.dump({"data": _CACHE, "metadata": ""}, f)
        
################################################################################
# Exceptions
################################################################################
class TwitterException(Exception):
    pass
class AuthenticationException(Exception):
    pass

        
################################################################################
# Domain Objects
################################################################################
    
class Coordinate(object):
    """
    The longitude and latitude where the tweet originated.
    """
    def __init__(self, longitude, latitude):
        """
        Creates a new Coordinate
        
        :param longitude: The longitude (West-North) component.
        :type longitude: float
        :param latitude: The latitude (South-North) component.
        :type latitude: float
        :returns: Coordinate
        """
        self.longitude = longitude
        self.latitude = latitude
        
    def __unicode__(self):
        return '<Coordinate {0:.3f}, {1:.3f}>'.format(self.longitude, self.latitude)
    
    def __repr__(self):
        if PYTHON_3:
            return '<Coordinate {0:.3f}, {1:.3f}>'.format(self.longitude, self.latitude)
        else:
            return unicode(self).encode('utf-8')
    
    def __str__(self):
        if PYTHON_3:
            return '<Coordinate {0:.3f}, {1:.3f}>'.format(self.longitude, self.latitude)
        else:
            return unicode(self).encode('utf-8')
            
    def _to_dict(self):
        return {'latitude' : self.latitude,
                'longitude': self.longitude}
    
    @staticmethod
    def _from_json(json_data):
        """
        Creates a Coordinate from json data.
        
        :param json_data: The raw json data to parse
        :type json_data: dict
        :returns: Coordinate
        """
        if json_data == None:
            return Coordinate(None, None)
        elif 'type' in json_data and json_data['type'] == 'Point':
            return Coordinate(_parse_float(json_data['coordinates'][0]),
                              _parse_float(json_data['coordinates'][1]))
        elif len(json_data) >= 2:
            return Coordinate(_parse_float(json_data[0]),
                              _parse_float(json_data[1]))
        else:
            raise TwitterException("The given coordinate information was incomplete.")
            
            
class User(object):
    """
    A Twitter user (A twit?)
    """
    def __init__(self, id, name, screen_name, description, location, followers, friends, created, favorites, tweets, verified):
        """
        Creates a new User
        
        :param int id: A unique ID number for this user.
        :param str name: The human-readable name for this user (e.g., "Austin Cory Bart")
        :param str screen_name: The short, internal name for the user (e.g., "acbart")
        :param str description: A user-provided description of this person.
        :param str location: A user-provided location for this person.
        :param str created: A human-readable string that indicates when the account was created.
        :param int followers: The number of people following this person.
        :param int friends: The number of people this person has friended (is following).
        :param int favorites: The number of tweets this person has favorited.
        :param int tweets: The number of tweets this user has made.
        :param bool verified: Whether or not this person has been verified.
        """
        self.id = id
        self.name = name
        self.screen_name = screen_name
        self.description = description
        self.location = location
        self.followers = followers
        self.friends = friends
        self.created = created
        self.favorites = favorites
        self.tweets = tweets
        self.verified = verified
        
    def __unicode__(self):
        return '<User {}>'.format(self.screen_name)
    
    def __repr__(self):
        if PYTHON_3:
            return '<User {}>'.format(self.screen_name)
        else:
            return unicode(self).encode('utf-8')
    
    def __str__(self):
        if PYTHON_3:
            return '<User {}>'.format(self.screen_name)
        else:
            return unicode(self).encode('utf-8')
    
    @staticmethod
    def _from_json(json_data):
        """
        Creates a Tweet from json data.
        
        :param json_data: The raw json data to parse
        :type json_data: dict
        :returns: Report
        """
        return User(json_data.get('id', ""),
                    json_data.get('name', ""),
                    json_data.get('screen_name', ""),
                    json_data.get('description', ""),
                    json_data.get('location', ""),
                    _parse_int(json_data.get('followers_count', ""), 0),
                    _parse_int(json_data.get('friends_count', ""), 0),
                    json_data.get('created_at', ""),
                    _parse_int(json_data.get('favourites_count', "0"), 0),
                    _parse_int(json_data.get('statuses_count', "0"), 0),
                    _parse_boolean(json_data.get('verified', False), False))
    
    def _to_dict(self):
        return {"id": self.id,
                "name": self.name,
                "screen_name": self.screen_name,
                "description": self.description,
                "location": self.location,
                "followers": self.followers,
                "friends": self.friends,
                "created": self.created,
                "favorites": self.favorites,
                "tweets": self.tweets,
                "verified": self.verified}

class Tweet(object):
    """
    A Tweet from Twitter.
    """
    def __init__(self, id, text, user, coordinates, created, favorited, retweets):
        """
        Creates a new Tweet
        
        :param int id: A unique ID number for this user.
        :param str text: The text of this tweet.
        :param User user: The User that made this tweet.
        :param Coordinate coordinates: The latitude and longitude that this tweet was made from.
        :param str created: A human-readable string that indicates when the account was created.
        :param int favorited: The number of times this post has been favorited.
        :param int retweets: The number of times this post has been retweeted.
        :returns: Tweet
        """
        self.id = id
        self.text = text
        self.user = user
        self.coordinates = coordinates
        self.created = created
        self.favorited = favorited
        self.retweets = retweets
        
    def _short_text(self):
        return self.text if len(self.text) < 30 else self.text[:27]+'...'
        
    short_text = property(_short_text)
        
    def __unicode__(self):
        return '<Tweet "{}" by {}>'.format(self.short_text, self.user.screen_name)
    
    def __repr__(self):
        if PYTHON_3:
            return '<Tweet "{}" by {}>'.format(self.short_text, self.user.screen_name)
        else:
            return unicode(self).encode('utf-8')
    
    def __str__(self):
        if PYTHON_3:
            return '<Tweet "{}" by {}>'.format(self.short_text, self.user.screen_name)
        else:
            return unicode(self).encode('utf-8')
    
    @staticmethod
    def _from_json(json_data):
        """
        Creates a Report from json data.
        
        :param json_data: The raw json data to parse
        :type json_data: dict
        :returns: Report
        """
        if 'user' in json_data:
            user = User._from_json(json_data['user'])
        else:
            user = User._from_json({})
        if 'coordinates' in json_data:
            coordinates = Coordinate._from_json(json_data['coordinates'])
        else:
            coordinates = None
        return Tweet(json_data.get('id', ""),
                     json_data.get('text', ""),
                     user,
                     coordinates,
                     json_data.get('created_at', ""),
                     _parse_int(json_data.get('favorite_count', "0"), 0),
                     _parse_int(json_data.get('retweet_count', "0"), 0))
     
    def _to_dict(self):
        """
        Creates a dictionary representation of this Tweet.
        
        :returns: Dict
        """
        return {"id" : self.id,
                "text": self.text, 
                "user": self.user._to_dict(),
                "coordinates": self.coordinates._to_dict(), 
                "created": self.created, 
                "favorited": self.favorited, 
                "retweets": self.retweets}

################################################################################
# Service Methods
################################################################################
    
def _get_search_request(terms, geocode):
    """
    Used to build the request string used by :func:`search`.
    
    :param str terms: The string that will be used to search wtih.
    """
    parameters = [('q', terms)]
    if geocode is not None:
        parameters.append(('geocode', geocode))
    return _build_oauth_url('https://api.twitter.com/1.1/search/tweets.json',
                            parameters)
                            
def _get_search_string(terms, geocode=None):
    """
    Like :func:`search` except returns the raw data instead.
    
    :param str terms: The string that will be used to search wtih.
    :returns: str
    """
    key = _get_search_request(terms, geocode)
    result = _get(key) if _CONNECTED else _lookup(key)
    if _CONNECTED and _EDITABLE:
        _add_to_cache(key, result)
    return result
    
def search_location(terms, latitude, longitude, radius='1mi'):
    if not isinstance(terms, str):
        raise TwitterException("Terms must be a string!")
    try:
        result = _get_search_string(terms, '{},{},{}'.format(latitude, longitude, radius))
    except HTTPError as e:
        raise TwitterException("Internet error ({}): {}".format(e.code, e.reason))
    if result == "":
        return []
    elif result:
        try:
            json_result = _from_json(result)
        except ValueError:
            raise TwitterException("The response from the server didn't make any sense.")
        return list(map(Tweet._to_dict, map(Tweet._from_json, json_result['statuses'])))
    else:
        if _CONNECTED:
            raise TwitterException("No response from the server.")
        else:
            raise TwitterException('No data was in the cache for these terms: "{}".'.format(terms))
    
def search(terms):
    """
    Returns a list of Tweets that were found with the given search terms.
    
===========================  ============================================================================
Query                        Description
===========================  ============================================================================
watching now                 containing both "watching" and "now". This is the default operator.
"happy hour"                 containing the exact phrase "happy hour".
love OR hate                 containing either "love" or "hate" (or both).
beer -root                   containing "beer" but not "root".
#haiku                       containing the hashtag "haiku".
from:alexiskold              sent from person "alexiskold".
to:techcrunch                sent to person "techcrunch".
@mashable                    referencing person "mashable".
superhero since:2010-12-27   containing "superhero" and sent since date "2010-12-27" (year-month-day).
ftw until:2010-12-27         containing "ftw" and sent before the date "2010-12-27".
movie -scary :)              containing "movie", but not "scary", and with a positive attitude.
flight :(                    containing "flight" and with a negative attitude.
traffic ?                    containing "traffic" and asking a question.
hilarious filter:links       containing "hilarious" and linking to URL.
news source:twitterfeed      containing "news" and entered via TwitterFeed
===========================  ============================================================================
    
    :param str terms: The string that will be used to search with.
    :returns: List of Tweets
    """
    if not isinstance(terms, str):
        raise TwitterException("Terms must be a string!")
    try:
        result = _get_search_string(terms)
    except HTTPError as e:
        raise TwitterException("Internet error ({}): {}".format(e.code, e.reason))
    if result == "":
        return []
    elif result:
        try:
            json_result = _from_json(result)
        except ValueError:
            raise TwitterException("The response from the server didn't make any sense.")
        return list(map(Tweet._to_dict, map(Tweet._from_json, json_result['statuses'])))
    else:
        if _CONNECTED:
            raise TwitterException("No response from the server.")
        else:
            raise TwitterException('No data was in the cache for these terms: "{}".'.format(terms))
    
################################################################################
# OAuth Madness
################################################################################
# Everything below is ripped out of the Leah Culver's oauth library
# I've done my best to trim it, but it's still pretty heavy. I don't recommend
# diving into it unless you MUST.
    
"""
The MIT License

Copyright (c) 2007 Leah Culver

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
"""

class OAuthError(RuntimeError):
    """Generic exception class."""
    def __init__(self, message='OAuth error occured.'):
        self.message = message

def _escape(s):
    """Escape a URL including any /."""
    return quote(s, safe='~')

def _utf8_str(s):
    """Convert unicode to utf-8."""
    if isinstance(s, unicode):
        return s.encode("utf-8")
    else:
        return str(s)

def _generate_timestamp():
    """Get seconds since epoch (UTC)."""
    return int(time())

def _generate_nonce(length=8):
    """Generate pseudorandom number."""
    return ''.join([str(randint(0, 9)) for i in range(length)])

def _generate_verifier(length=8):
    """Generate pseudorandom number."""
    return ''.join([str(randint(0, 9)) for i in range(length)])


class OAuthConsumer(object):
    """Consumer of OAuth authentication.

    OAuthConsumer is a data type that represents the identity of the Consumer
    via its shared secret with the Service Provider.
    """
    def __init__(self, key, secret):
        self.key = key
        self.secret = secret


class OAuthToken(object):
    """OAuthToken is a data type that represents an End User via either an access
    or request token.
    
    key -- the token
    secret -- the token secret

    """
    key = None
    secret = None
    callback = None
    callback_confirmed = None
    verifier = None

    def __init__(self, key, secret):
        self.key = key
        self.secret = secret

    def set_verifier(self, verifier=None):
        if verifier is not None:
            self.verifier = verifier
        else:
            self.verifier = _generate_verifier()

    def to_string(self):
        data = {
            'oauth_token': self.key,
            'oauth_token_secret': self.secret,
        }
        if self.callback_confirmed is not None:
            data['oauth_callback_confirmed'] = self.callback_confirmed
        return urlencode(data)
 
    def from_string(s):
        """ Returns a token from something like:
        oauth_token_secret=xxx&oauth_token=xxx
        """
        params = cgi.parse_qs(s, keep_blank_values=False)
        key = params['oauth_token'][0]
        secret = params['oauth_token_secret'][0]
        token = OAuthToken(key, secret)
        try:
            token.callback_confirmed = params['oauth_callback_confirmed'][0]
        except KeyError:
            pass # 1.0, no callback confirmed.
        return token
    from_string = staticmethod(from_string)

    def __str__(self):
        return self.to_string()


class OAuthRequest(object):
    """OAuthRequest represents the request and can be serialized.

    OAuth parameters:
        - oauth_consumer_key 
        - oauth_token
        - oauth_signature_method
        - oauth_signature 
        - oauth_timestamp 
        - oauth_nonce
        - oauth_version
        - oauth_verifier
        ... any additional parameters, as defined by the Service Provider.
    """
    parameters = None # OAuth parameters.
    http_method = 'GET'
    http_url = None
    version = '1.0'

    def __init__(self, http_method='GET', http_url=None, parameters=None):
        self.http_method = http_method
        self.http_url = http_url
        self.parameters = parameters or {}

    def set_parameter(self, parameter, value):
        self.parameters[parameter] = value

    def get_parameter(self, parameter):
        try:
            return self.parameters[parameter]
        except:
            raise OAuthError('Parameter not found: %s' % parameter)

    def _get_timestamp_nonce(self):
        return self.get_parameter('oauth_timestamp'), self.get_parameter(
            'oauth_nonce')

    def get_nonoauth_parameters(self):
        """Get any non-OAuth parameters."""
        parameters = {}
        for k, v in self.parameters.items():
            # Ignore oauth parameters.
            if k.find('oauth_') < 0:
                parameters[k] = v
        return parameters

    def to_header(self, realm=''):
        """Serialize as a header for an HTTPAuth request."""
        auth_header = 'OAuth realm="%s"' % realm
        # Add the oauth parameters.
        if self.parameters:
            for k, v in self.parameters.items():
                if k[:6] == 'oauth_':
                    auth_header += ', %s="%s"' % (k, _escape(str(v)))
        return {'Authorization': auth_header}

    def to_postdata(self):
        """Serialize as post data for a POST request."""
        return '&'.join(['%s=%s' % (_escape(str(k)), _escape(str(v))) \
            for k, v in sorted(self.parameters.items())])

    def to_url(self):
        """Serialize as a URL for a GET request."""
        return '%s?%s' % (self.get_normalized_http_url(), self.to_postdata())

    def get_normalized_parameters(self):
        """Return a string that contains the parameters that must be signed."""
        params = self.parameters
        try:
            # Exclude the signature if it exists.
            del params['oauth_signature']
        except:
            pass
        # Escape key values before sorting.
        key_values = [(_escape(_utf8_str(k)), _escape(_utf8_str(v))) \
            for k,v in params.items()]
        # Sort lexicographically, first after key, then after value.
        key_values.sort()
        # Combine key value pairs into a string.
        return '&'.join(['%s=%s' % (k, v) for k, v in key_values])

    def get_normalized_http_method(self):
        """Uppercases the http method."""
        return self.http_method.upper()

    def get_normalized_http_url(self):
        """Parses the URL and rebuilds it to be scheme://host/path."""
        parts = urlparse(self.http_url)
        scheme, netloc, path = parts[:3]
        # Exclude default port numbers.
        if scheme == 'http' and netloc[-3:] == ':80':
            netloc = netloc[:-3]
        elif scheme == 'https' and netloc[-4:] == ':443':
            netloc = netloc[:-4]
        return '%s://%s%s' % (scheme, netloc, path)

    def sign_request(self, signature_method, consumer, token):
        """Set the signature parameter to the result of build_signature."""
        # Set the signature method.
        self.set_parameter('oauth_signature_method',
            signature_method.get_name())
        # Set the signature.
        self.set_parameter('oauth_signature',
            self.build_signature(signature_method, consumer, token))

    def build_signature(self, signature_method, consumer, token):
        """Calls the build signature method within the signature method."""
        return signature_method.build_signature(self, consumer, token)

    def from_request(http_method, http_url, headers=None, parameters=None,
            query_string=None):
        """Combines multiple parameter sources."""
        if parameters is None:
            parameters = {}

        # Headers
        if headers and 'Authorization' in headers:
            auth_header = headers['Authorization']
            # Check that the authorization header is OAuth.
            if auth_header[:6] == 'OAuth ':
                auth_header = auth_header[6:]
                try:
                    # Get the parameters from the header.
                    header_params = OAuthRequest._split_header(auth_header)
                    parameters.update(header_params)
                except:
                    raise OAuthError('Unable to parse OAuth parameters from '
                        'Authorization header.')

        # GET or POST query string.
        if query_string:
            query_params = OAuthRequest._split_url_string(query_string)
            parameters.update(query_params)

        # URL parameters.
        param_str = urlparse(http_url)[4] # query
        url_params = OAuthRequest._split_url_string(param_str)
        parameters.update(url_params)

        if parameters:
            return OAuthRequest(http_method, http_url, parameters)

        return None
    from_request = staticmethod(from_request)

    def from_consumer_and_token(oauth_consumer, token=None,
            callback=None, verifier=None, http_method='GET',
            http_url=None, parameters=None):
        if not parameters:
            parameters = {}

        defaults = {
            'oauth_consumer_key': oauth_consumer.key,
            'oauth_timestamp': _generate_timestamp(),
            'oauth_nonce': _generate_nonce(),
            'oauth_version': OAuthRequest.version,
        }

        defaults.update(parameters)
        parameters = defaults

        if token:
            parameters['oauth_token'] = token.key
            if token.callback:
                parameters['oauth_callback'] = token.callback
            # 1.0a support for verifier.
            if verifier:
                parameters['oauth_verifier'] = verifier
        elif callback:
            # 1.0a support for callback in the request token request.
            parameters['oauth_callback'] = callback

        return OAuthRequest(http_method, http_url, parameters)
    from_consumer_and_token = staticmethod(from_consumer_and_token)

    def from_token_and_callback(token, callback=None, http_method='GET',
            http_url=None, parameters=None):
        if not parameters:
            parameters = {}

        parameters['oauth_token'] = token.key

        if callback:
            parameters['oauth_callback'] = callback

        return OAuthRequest(http_method, http_url, parameters)
    from_token_and_callback = staticmethod(from_token_and_callback)

    def _split_header(header):
        """Turn Authorization: header into parameters."""
        params = {}
        parts = header.split(',')
        for param in parts:
            # Ignore realm parameter.
            if param.find('realm') > -1:
                continue
            # Remove whitespace.
            param = param.strip()
            # Split key-value.
            param_parts = param.split('=', 1)
            # Remove quotes and unescape the value.
            params[param_parts[0]] = unquote(param_parts[1].strip('\"'))
        return params
    _split_header = staticmethod(_split_header)

    def _split_url_string(param_str):
        """Turn URL string into parameters."""
        parameters = cgi.parse_qs(param_str, keep_blank_values=False)
        for k, v in parameters.items():
            parameters[k] = unquote(v[0])
        return parameters
    _split_url_string = staticmethod(_split_url_string)

class OAuthSignatureMethod(object):
    """A strategy class that implements a signature method."""
    def get_name(self):
        """-> str."""
        raise NotImplementedError

    def build_signature_base_string(self, oauth_request, oauth_consumer, oauth_token):
        """-> str key, str raw."""
        raise NotImplementedError

    def build_signature(self, oauth_request, oauth_consumer, oauth_token):
        """-> str."""
        raise NotImplementedError

    def check_signature(self, oauth_request, consumer, token, signature):
        built = self.build_signature(oauth_request, consumer, token)
        return built == signature


class OAuthSignatureMethod_HMAC_SHA1(OAuthSignatureMethod):

    def get_name(self):
        return 'HMAC-SHA1'
        
    def build_signature_base_string(self, oauth_request, consumer, token):
        sig = (
            _escape(oauth_request.get_normalized_http_method()),
            _escape(oauth_request.get_normalized_http_url()),
            _escape(oauth_request.get_normalized_parameters()),
        )

        key = '%s&' % _escape(consumer.secret)
        if token:
            key += _escape(token.secret)
        raw = '&'.join(sig)
        return key, raw

    def build_signature(self, oauth_request, consumer, token):
        """Builds the base signature string."""
        key, raw = self.build_signature_base_string(oauth_request, consumer,
            token)

        # HMAC object.
        if PYTHON_3:
            key = key.encode('utf-8')
            raw = raw.encode('utf-8')
        try:
            import hashlib # 2.5
            hashed = hmac.new(key, raw, hashlib.sha1)
        except:
            import sha # Deprecated
            hashed = hmac.new(key, raw, sha)

        # Calculate the digest base 64.
        return binascii.b2a_base64(hashed.digest())[:-1].decode('utf-8')


class OAuthSignatureMethod_PLAINTEXT(OAuthSignatureMethod):

    def get_name(self):
        return 'PLAINTEXT'

    def build_signature_base_string(self, oauth_request, consumer, token):
        """Concatenates the consumer key and secret."""
        sig = '%s&' % _escape(consumer.secret)
        if token:
            sig = sig + _escape(token.secret)
        return sig, sig

    def build_signature(self, oauth_request, consumer, token):
        key, raw = self.build_signature_base_string(oauth_request, consumer,
            token)
        return key
        
################################################################################
# End of OAuth
################################################################################