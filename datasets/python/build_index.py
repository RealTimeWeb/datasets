from jinja2 import Environment, FileSystemLoader
import os

base_directory = os.path.dirname(os.path.realpath(__file__))

templates = base_directory
env = Environment(loader=FileSystemLoader(templates))
skip_list = ['baseball', 'nfl', 'soccer', 'twitter', 'gutenberg', 'weather']

previews = [open(os.path.join(base_directory, folder, folder+'_preview.html')).read()
            for folder in os.listdir(base_directory+'/') 
            if os.path.isdir(os.path.join(base_directory, folder) )
               and os.path.isfile(os.path.join(base_directory, folder, folder+'_preview.html'))
               and folder not in skip_list
               ]
            
with open(os.path.join(base_directory, 'index.html'), 'w') as output:
    output.write(env.get_template('template.html').render(previews=previews))