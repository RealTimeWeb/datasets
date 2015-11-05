from jinja2 import Environment, FileSystemLoader
import os
templates = './'
env = Environment(loader=FileSystemLoader(templates))

previews = [open(os.path.join(folder, folder+'_preview.html')).read()
            for folder in os.listdir('.') 
            if os.path.isdir(folder) and os.path.isfile(os.path.join(folder, folder+'_preview.html'))]
            
with open('index.html', 'w') as output:
    output.write(env.get_template('template.html').render(previews=previews))