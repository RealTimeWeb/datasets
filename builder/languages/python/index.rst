.. {{ metadata.name | flat_case }} documentation master file, created by
   sphinx-quickstart on Tue Jul 23 13:06:29 2013.
   You can adapt this file completely to your liking, but it should at least
   contain the root `toctree` directive.

Welcome to {{ metadata.name | flat_case }}'s documentation!
============================{{ "=" * metadata.name | flat_case | length }}

{{ metadata.description }}

>>> import {{ metadata.name | flat_case }}

After importing, you are now ready to start using it!

{% for function in functions %}
>>> {{ metadata.name | flat_case }}.{{ function.name | snake_case }}(...)
< ... >

{% endfor %}

Methods
-------

{% for function in functions %}
.. autofunction:: {{ metadata.name | flat_case }}.{{ function.name | snake_case }}
{% endfor %}

Working Offline
---------------

If you are having internet problems, or simply want to run your program faster, you can work offline.

>>> import {{ metadata.name | flat_case }}
>>> {{ metadata.name | flat_case }}.disconnect()

You can now make any call that is locally available. Not every call is possible, but the library will tell you if that value is not available.

>>> {{ metadata.name | flat_case }}.{{ functions[0].name | snake_case }}()
{{ metadata.name | flat_case }}.{{ metadata.name | camel_case_caps }}Exception: Not available offline.

Contents:

.. toctree::
   :maxdepth: 2
   
Functions
---------

{% for function in functions %}
.. autofunction:: {{ metadata.name | flat_case }}.{{ function.name | snake_case }}
{% endfor %}

.. autofunction:: {{ metadata.name | flat_case }}.connect

.. autofunction:: {{ metadata.name | flat_case }}.disconnect
   
Data Classes
------------

{% for object in objects %}
.. autoclass:: {{ metadata.name | flat_case }}.{{ object.name | camel_case_caps }}
    :members:
    :special-members: __init__
{% endfor %}

Advanced Usage
--------------

If you're a student, you probably shouldn't look too closely at the following. This is meant for the instructor.

Exceptions
^^^^^^^^^^

.. autoexception:: {{ metadata.name | flat_case }}.{{ metadata.name | camel_case_caps }}Exception

Populating the cache
^^^^^^^^^^^^^^^^^^^^

Say you want to add to the cache

>>> {{ metadata.name | flat_case }}._start_editing()
>>> stock = {{ metadata.name | flat_case }}.function()
>>> {{ metadata.name | flat_case }}._save_cache()

Now the file "cache.json" file will have an entry for this function and argument, and
you can use that as an input to the function when disconnected.

You can also create a different cache file by passing a filename to the
_save_cache() method, and use that cache by passing its name to the
disconnect() method.

For example, this will populate a file called "special.json", which will contain
stock information for google

>>> {{ metadata.name | flat_case }}._start_editing()
>>> stock = {{ metadata.name | flat_case }}.function()
>>> {{ metadata.name | flat_case }}._save_cache("special.json")

To use that cached file, specify the json file name when you call disconnect():

>>> {{ metadata.name | flat_case }}.disconnect("special.json")

Finally, you can put multiple entries into the cache for a given input, simulating multiple calls. These items will be appended. If the cache runs out, it will start returning empty reports.

>>> {{ metadata.name | flat_case }}.connect()
>>> {{ metadata.name | flat_case }}._start_editing()
>>> {{ metadata.name | flat_case }}.function(...)
>>> {{ metadata.name | flat_case }}.function(...)
>>> {{ metadata.name | flat_case }}._save_cache()
>>> {{ metadata.name | flat_case }}.disconnect()
>>> {{ metadata.name | flat_case }}.function(...)
{ ... }
>>> {{ metadata.name | flat_case }}.function(...)
{ ... }


Indices and tables
==================

* :ref:`genindex`
* :ref:`modindex`
* :ref:`search`

