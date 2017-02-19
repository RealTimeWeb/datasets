Welcome to the CORGIS Datasets project!

Contributing a New Dataset
==========================

The CORGIS project is always excited to welcome new datasets!

Rules and Guidelines
--------------------

Committment to values

Politeness, respect

Some datasets may deal with subject matter of a sensitive nature (e.g., the Slavery dataset, Immigration dataset). Their data might be offensive to one or more groups. Although the goal of the CORGIS project is not to be provocative, a good dataset should not be rejected because it could potentially be offensive to some group. Regardless of whether this is because the terminology or values of the dataset are inherently offensive or because they are subjectively offensive, the project takes the views that learning environments should be able to provide controversial material (particularly in higher education settings). Some allowances must be made for good taste, of course.

At all times, developers must make their best effort to ensure that datasets reflect reality and provide an accurate abstraction of the world they are representing.

Preparing the Data File
-----------------------

Currently, the CORGIS project expects all datasets to be a JSON file where the data is stored as a List of Dictionaries. Each of those dictionaries can have any heirarchy of dictionaries, primitives, and lists.

Primitives can be one of integers, floats, strings, or booleans.

Percentages should be stored as (100\*decimal). That is, if the original ratio is 1/2, then the number should be stored as the integer 50, rather than the decimal value .5. The major argument is that floating point values lose precision and integers are aesthetically easier to read and friendlier to students. However, in all cases, the field should be documented for clarity.

We recommend against using Null values, since beginners struggle to deal with varying levels of nothingness. Most of our datasets impute missing data, often by using an average value or with obvious incorrect numbers (-1). Any such imputation should be clearly documented in the Spec file.

We recommend 2-4 of nested dictionaries below the main list. Too little and the dataset is too simple to traverse; too much and students will be overwhelmed by the data.

We generally discourage lists below the main list. Although nested lists can be useful for teaching nested loops, they are not particularly applicable for the Visualizer. If you do include a nested list, ensure that most instances are non-empty so that students can readily identify the list's subtype. We favor lists of primitives over lists of complex structures.

We demand that every instance in the main list is of the exact same type. This should be treated recursively for all structures within. That is, if the first element has a key named "Address" that is an integer, all subsequent elements must have a key named "Address" that is a String. Common mistakes are to use Null instead of 0, or to have numeric values inconsistently encoded as strings.

A suitable icon should be found to represent the dataset. This icon should be appropriately licensed and sourced in the Spec file.

The .corgis Spec File
---------------------

In addition to preparing a dataset file, you must also prepare a Spec file. These have the extension of ".corgis" but are really simple YAML files. Extended documentation can be found in `model_format.yaml` and examples can be found in `specs/`.

At a high-level, you should contribute four sections:

* Metadata: yada
* Locals: yada
* Interfaces: yada
* Comments: yada

Choosing an Icon
----------------

Icons must be open-source and have appropriate copyright.

Language Build
--------------

When the JSON and CORGIS files are ready, the dataset can be compiled for one or more targets. We particularly appreciate libraries that are suitable for every major CORGIS output target.


Understand the Build Process
============================

1. A ".corgis" specification file is parsed and compiled
2. The compiled spec and dataset are passed to an individual language target
3. A source code template is filled out using Jinja2
