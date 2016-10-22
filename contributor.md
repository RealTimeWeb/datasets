Welcome to the CORGIS Datasets project!

Understand the Build Process
============================

1. A ".corgis" specification file is parsed and compiled
2. The compiled spec and dataset are passed to an individual language target
3. A source code template is filled out using Jinja2

Preparing a Dataset
-------------------

Currently, the CORGIS project expects all datasets to be a JSON file where the data is stored as a List of Dictionaries. Each of those dictionaries can have any heirarchy of dictionaries, primitives, and lists.

Primitives can be one of integers, floats, strings, or booleans.

We recommend against using Null values, since beginners struggle to deal with varying levels of nothingness. Most of our datasets impute missing data, often by using an average value or with obvious incorrect numbers (-1). Any such imputation should be clearly documented in the Spec file.

We recommend 2-4 of nested dictionaries below the main list. Too little and the dataset is too simple to traverse; too much and students will be overwhelmed by the data.

We generally discourage lists below the main list. Although nested lists can be useful for teaching nested loops, they are not particularly applicable for the Visualizer. If you do include a nested list, ensure that most instances are non-empty so that students can readily identify the list's subtype. We favor lists of primitives over lists of complex structures.

We demand that every instance in the main list is of the exact same type. This should be treated recursively for all structures within. That is, if the first element has a key named "Address" that is an integer, all subsequent elements must have a key named "Address" that is a String. Common mistakes are to use Null instead of 0, or to have numeric values inconsistently encoded as strings.

.corgis Spec File
-----------------

In addition to preparing a dataset file, 

The major 

Language Build
--------------

