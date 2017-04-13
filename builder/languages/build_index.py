from __future__ import print_function
import json
import os
from jinja2 import Environment, FileSystemLoader
from auxiliary import flat_case, snake_case
import yaml

FILE_NOT_FOUND_ERROR = getattr(__builtins__,'FileNotFoundError', IOError)

base_directory = os.path.dirname(os.path.realpath(__file__))
templates = os.path.join(base_directory, 'templates/')
index_environment = Environment(loader=FileSystemLoader(templates))
index_environment.filters['flat_case'] = flat_case
index_environment.filters['snake_case'] = snake_case
index_environment.filters['tojson'] = json.dumps

def write_jinja(template_file, new_filename, **kwargs):
    data = (index_environment.get_template(template_file)
                             .render(**kwargs))
    with open(new_filename, 'w') as output:
        output.write(data)

INDEX_NAME = 'index.json'
CATEGORIES = {
    'python': 'language',
    'java': 'language',
    'racket': 'language',
    'sql': 'raw',
    'csv': 'raw',
    'json': 'raw',
    'visualizer': 'other',
    'blockpy': 'other',
    'metrics': 'other'
}


def add_to_index(target, language, spec):
    INDEX_PATH = os.path.join(target, INDEX_NAME)
    with open(INDEX_PATH, 'r') as index_file:
        index = json.load(index_file)
    # Add new language section if necessary
    if language not in index:
        index[language] = {'category': CATEGORIES[language],
                           'datasets': {}}
    # Add spec section
    name = spec.metadata.name
    new_entry = {
        'name': name,
        'icon': spec.metadata.icon,
        'short': spec.metadata.description.get('short', ''),
        'overview': spec.metadata.description.get('overview', ''),
        'hide': spec.metadata.hide,
        'tags': spec.metadata.tags
    }
    index[language]['datasets'][name] = new_entry
    # Save updated index
    with open(INDEX_PATH, 'w') as index_file:
        json.dump(index, index_file)


def rebuild_index(target):
    # Get the index data
    INDEX_PATH = os.path.join(target, INDEX_NAME)
    with open(INDEX_PATH, 'r') as index_file:
        index = json.load(index_file)
    # Create the language index
    LANGUAGE_INDEX_PATH = os.path.join(target, 'index.html')
    LANGUAGE_INDEX_PATH_EMBED = os.path.join(target, 'libraries.html')
    write_jinja('main_index.html', LANGUAGE_INDEX_PATH, index=index, standalone=True)
    write_jinja('main_index.html', LANGUAGE_INDEX_PATH_EMBED, index=index, standalone=False)
    # Create each individual language index
    for language, language_data in index.items():
        SPEC_INDEX_PATH = os.path.join(target, language, 'index.html')
        SPEC_INDEX_PATH_EMBED = os.path.join(target, language, language+'.html')
        write_jinja('spec_index.html', SPEC_INDEX_PATH, specs=language_data['datasets'], language=language, standalone=True)
        write_jinja('spec_index.html', SPEC_INDEX_PATH_EMBED, specs=language_data['datasets'], language=language, standalone=False)
        
def list_folders(target):
    for name in os.listdir(target):
        full_path = os.path.join(target, name)
        if os.path.isdir(full_path):
            yield full_path, name
            
def parse_spec_metadata(spec_file_path):
    with open(spec_file_path, 'r') as specification_file:
        return yaml.load(specification_file)

def reconstruct_index(target, specs):
    index = {}
    bad_outputs = set()
    # Walk through languages
    for category, category_type in CATEGORIES.items():
        index[category] = {
            'category': category_type,
            'datasets': {}
        }
        path = os.path.join(target, category)
        if not os.path.exists(path): continue
        for library_path, library_name in list_folders(path):
            try:
                spec_path = os.path.join(specs, library_name+'.corgis')
                metadata = parse_spec_metadata(spec_path)['metadata']
            except FILE_NOT_FOUND_ERROR:
                bad_outputs.add( (category, library_name) )
                continue
            index[category]['datasets'][metadata['name']] = {
                'name': metadata['name'],
                'icon': library_name+'.png',
                'short': metadata['description'].get('short', ''),
                'hide': metadata.get('hide', ''),
                'overview': metadata['description'].get('overview', ''),
                'tags': metadata['tags']
            }
    if bad_outputs:
        for category, library_name in sorted(bad_outputs):
            print("Spec file could not be found for {}/{}".format(category, library_name))
    else:
        INDEX_PATH = os.path.join(target, INDEX_NAME)
        with open(INDEX_PATH, 'w') as index_file:
            index = json.dump(index, index_file)