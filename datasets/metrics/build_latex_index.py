from jinja2 import Environment, FileSystemLoader
import os
import json

base_directory = os.path.dirname(os.path.realpath(__file__))

templates = base_directory
env = Environment(loader=FileSystemLoader(templates))
skip_list = ['baseball', 'nfl', 'soccer', 'twitter', 'gutenberg', 'weather', 'airports', 'johnsongrass', 'kepler', 'businesses']

folders = [folder
           for folder in os.listdir(base_directory+'/') 
           if os.path.isdir(os.path.join(base_directory, folder) )
              and os.path.isfile(os.path.join(base_directory, folder, folder+'.json'))
              and folder not in skip_list]
               
reports = [json.load(open(os.path.join(base_directory, folder, folder+'.json')))
            for folder in folders]
            
with open(os.path.join(base_directory, 'index.tex'), 'w') as output:
    output.write(env.get_template('latex_template.tex').render(reports=reports))
