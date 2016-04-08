from jinja2 import Environment, FileSystemLoader
import os

base_directory = os.path.dirname(os.path.realpath(__file__))

templates = base_directory
env = Environment(loader=FileSystemLoader(templates))
skip_list = ['baseball', 'nfl', 'soccer', 'twitter', 'gutenberg', 'weather', 'airports', 'johnsongrass']

folders = [folder
           for folder in os.listdir(base_directory+'/') 
           if os.path.isdir(os.path.join(base_directory, folder) )
              and os.path.isfile(os.path.join(base_directory, folder, folder+'_preview.html'))
              and folder not in skip_list]
               
previews = [open(os.path.join(base_directory, folder, folder+'_preview.html')).read()
            for folder in folders]
            
with open(os.path.join(base_directory, 'index.html'), 'w') as output:
    output.write(env.get_template('template.html').render(previews=previews))
    
module_white_list_file = r'C:\Users\acbart\Projects\blockpy\server\controllers\ast_finder\module_white_list.py'
other_modules = ['weather', 'books', 'earthquakes', 'stocks', 'crime']
complete_list = set(folders + skip_list + other_modules)

with open(module_white_list_file, 'w') as output:
    output.write('''MODULE_WHITE_LIST = [
    {}
]
'''.format(',\n\t'.join(["'{}'".format(module) for module in complete_list])))