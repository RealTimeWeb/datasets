from __future__ import print_function
import json
import os
from jinja2 import Environment, FileSystemLoader
from auxiliary import flat_case

base_directory = os.path.dirname(os.path.realpath(__file__))
templates = os.path.join(base_directory, 'templates/')
index_environment = Environment(loader=FileSystemLoader(templates))
index_environment.filters['flat_case'] = flat_case
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
