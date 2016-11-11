# Extending CORGIS

At a high-level, the CORGIS build process works as follows:

1. The Builder processes arguments
1. Compile the .corgis file into a Package object.
2. Pass the Package object to a Target Builder
    1. The Target Builder will fill out a template to generate a library
    2. The Target Builder will organize the associated dataset as needed
    3. The Target Builder will create any supporting documentation as needed.
3. Indexes for the library and language are updated.
    
## Builder

    builder/builder.py
    
Builder.py is the main point of entry for the CORGIS compilation process.

## Compiler

    builder/compiler.py

## Builders

Target Builders are the component that transforms a compiled specification file into actual libraries.

# Adding a new Dataset

The most common extension to CORGIS is a new dataset. Fortunately, this is relatively straightforward.

1. Create a new JSON data set. It must be a list of objects at the top level.
2. Create a specification file.
3. Run the Builder in each target language.

# Adding a new Target Builder

A less common task is to add a new output format for CORGIS. Typically, this will be for a new language or for a new file format. However, it could also be used to create a new version of an existing language.

## Create the new Target Builder file

In the `builder/` directory, you should create a new Python script named "builder_{name}.py" where {name} is replaced with the slugged name of your new output type. For example, when we added a new Target Builder for the BlockPy project, we created "builder_blockpy.py".

## Add an entry for the Target Builder in the main Builder

In the `builder/builder.py` file, import the target builder and add a new if-branch to dispatch to its build function.

    from languages.build_blockpy import build_blockpy
    
    # ...

    elif language_target == "blockpy":
        files, moves = build_blockpy(compiled_dict)
        
## Add your build function to your Target Builder

In your new `builder/builder_{name}.py` file, you must create a new method named `build_{name}`. This method should consume two parameters:

* model: A dictionary containing all the data from the spec, as a very complex object. The full representation of this dataset is given in "model_format.yaml". This will be used to fill out the format.
* fast: A boolean value that indicates the user does not want to update the dataset, simply any supporting documentations (with the expectation that this would be considerably faster, for most datasets).
    
This method must return two dictionaries (as a two-tuple):
    
* files: A dictionary mapping new filenames to the contents of that file. This is typically used for source files, supplementary files, and accompanying documentation. So, for example, the following would create a simple "Hello World" python program and some documentation:

    {"src/hello_world.py": "print('Hello World')", "docs/readme.txt": "Call hello_world.py to get started."}
    
* moves: A dictionary mapping source filenames (generated in the current working directory by the Target Builder) to the destination of those files in the eventual dataset folder. Instead of keeping things in memory, this allows generated datasets to be transferred via the operating system. So, for example, the following would move a database file:

    {"dataset.db": "data/"}
    
A prototypical build function is as follows:

    def build_blockpy(model, fast):
        name = snake_case(model['metadata']['name'])
        new_folder = 'blockpy/' + name + '/'
        
        # Create the resulting files dictionary
        files = {}
        
        # Copy over the icon, if it exists
        icon_file = model['metadata']['icon']
        if os.path.exists(icon_file):
            with open(icon_file, 'rb') as icon_data:
                files[new_folder+name+'.png'] = icon_data.read()
        else:
            model["metadata"]["icon"] = False
        
        # Actually build the files based on the spec elsewhere
        files.update(build_main(model))
        files.update(build_classes(model))
        files.update(build_metafiles(model))
        
        if fast:
            moves = {}
        else:
            # Build the database file (.db)
            new_file, database_file = build_database(model)
            # And fill it out with the data from the local datasets
            build_locals(model, database_file)
            # Open a door, close a door.
            database_file.close()
            # And then add the file to the dictionary of moving files.
            moves = {new_file: new_folder}
        
        return files, moves
        
The snake_case function is available from `builder/auxiliary.py`, along with a host of other functions to sluggify names. The other methods (build_main, build_classes, build_metafiles, build_database, and build_locals) are specific to this Target Builder. Not every target builder will need all of these, and some might require more. Checking over the different Target Builders will give you a sense of what they do.

## Using Jinja2 templates

Almost every Target Builder takes advantage of the Jinja2 templating system to create source files. Each target builder has an associated template folder full of files ready to be filled out with information from the model.

Most of the Target Builders will have something like the following:

    from jinja2 import Environment, FileSystemLoader
    import jinja2_highlight
    base_directory = os.path.dirname(os.path.realpath(__file__))
    # Rename java -> your target builder name
    language_templates = os.path.join(base_directory, 'java/')
    generic_templates = os.path.join(base_directory, 'templates/')
    env = Environment(extensions=['jinja2_highlight.HighlightExtension'], 
                      loader=FileSystemLoader([generic_templates, language_templates]))
                      
New filters can be added to this Jinja2 environment:

    env.filters['snake_case'] = snake_case
    
And then that Jinja2 environment can be used to fill out a template:

    def build_main(model):
        name = model['metadata']['name']
        root = 'java/{name}/src/corgis/{name}/'.format(name=snake_case(name))
        return {root + camel_case_caps(name) + 'Library.java' :
                    env.get_template('main.java').render(**model),
                'another_example.java': 
                    env.get_template('example.java').render(**model)}
                    
If you check the 'main.java' template, then you will see code like the following:

    package corgis.{{ metadata.name | snake_case }};
    import java.util.HashMap;
    import corgis.{{ metadata.name | snake_case }}.domain.*;

    public class {{ metadata.name | camel_case_caps }}Library {
        {% if metadata.comment %}
        // {{ metadata.comment }}
        {% endif -%}
        private String databasePath;
        
        //...
    }

This is typical Jinja2 syntax. Using Jinja2, not only can you use information from the model, but you can apply functions to manipulate that data and use control flow (e.g., conditional branches, loops). More information on the Jinja2 system can be found in their `documentation <http://jinja.pocoo.org/docs/dev/templates/>`_ . It is also worth browsing the various fields available in `model_format.yaml` and the examples in the `builder/languages/` directory.

## Building a database

The actual data file(s) will be available through the ``locals'' field in the model. For most of the languages, this JSON file will be loaded into a SQLite database. For the raw data target builders, it will typically be converted into a different format (CSV, SQL) or dumped directly (JSON). There are many possibilities here, depending on what you are trying to do.

    def build_database(model):
        name = snake_case(model['metadata']['name'])
        new_file = name+'.db'
        if os.path.exists(new_file):
            os.remove(new_file)
        database_file = sqlite3.connect(new_file)
        return new_file, database_file

    def build_locals(model, database_file):
        locals = model["locals"]
        moves = {}
        
        for local in locals:
            name = local["name"]
            file = local["file"]
            type = local["type"]
            with open(file, "r") as local_file:
                if type == "json":
                    data_file = json.load(local_file)
                    # ... do something with the data file
                    # All I can really say is it'll be a list of dictionaries!
        
## Add a new Index category

In the `builder/languages/build_index.py` file, add a new entry in the CATEGORIES dictionary for your target output.

    CATEGORIES = {
    
        # ...
        
        'blockpy': 'other'
        
        # ...
        
    }
    
The choices are "language", "raw", or "other".