from jinja2 import Environment, FileSystemLoader
import os
import json
import matplotlib

base_directory = os.path.dirname(os.path.realpath(__file__))

templates = base_directory
env = Environment(loader=FileSystemLoader(templates))
skip_list = ['twitter', 'gutenberg', 'weather', 'airports', 'johnsongrass', 'kepler', 'businesses']

folders = [folder
           for folder in os.listdir(base_directory+'/') 
           if os.path.isdir(os.path.join(base_directory, folder) )
              and os.path.isfile(os.path.join(base_directory, folder, folder+'.json'))
              and folder not in skip_list]
               
reports = [json.load(open(os.path.join(base_directory, folder, folder+'.json')))
            for folder in folders]
            
with open(os.path.join(base_directory, 'index.tex'), 'w') as output:
    output.write(env.get_template('latex_template.tex').render(reports=reports))

import matplotlib.pyplot as plt
import pandas as pd

data_types = pd.DataFrame([s['atomics'] for r in reports for s in r.values()])
data_types['lists'] = [s['lists']['count'] for r in reports for s in r.values()]
data_types['objects'] = [s['dicts']['count'] for r in reports for s in r.values()]
data_types = data_types[['booleans', 'floats', 'ints', 'strings', 'lists', 'objects']]
data_types.columns = ['Bool', 'Float', 'Integer', 'String', 'Lists', 'Objects']
data_types = data_types.apply(lambda c: c / c.sum() * 100, axis=1)
ax = data_types.plot.box(vert=False, figsize=(2.5,2.5))
ax.set_xlabel('Percentage of Total Types')
ax.set_ylabel('Types')

shapes = pd.DataFrame([{'Heights': s['heights'],
                        'Average Branching Factor': s['dicts']['average branching factor'],
                        'Number of Fields': s['atomics']['count'],
                        'Rows (1000s)': s['length']/1000,
                        'Size (MB)': s['size']/1000/1000,
}
 for r in reports for s in r.values()])

for r in reports:
    for s in r.values():
        if 'levels' not in s['dicts']:
            print(r)

levels = pd.DataFrame([{l: v for l,v in 
                        s['dicts']['levels'].items()
                        if v <= 50}
   for r in reports for s in r.values()])
levels = levels.reindex_axis(reversed(sorted(levels.columns)), axis=1)

levelIQR = pd.DataFrame(columns=levels.columns)
for c in levels.columns:
    levelIQR[c] = [levels[c].quantile(0.75) - levels[c].quantile(0.25) ]
levels.median()
levelIQR.T
levels.count()

sax = shapes.plot.box(subplots=True, vert=False, layout=(5, 1), 
                      sharex=False, figsize=(5,3))
fig = matplotlib.pyplot.gcf()
#fig.set_size_inches(2.5, .5)
fig.subplots_adjust(hspace=.9)

levels.plot.box(vert=False, showfliers=False)

'''
shapes = pd.DataFrame([s['heights'] for r in reports for s in r.values()])
shapes = shapes.plot.box(vert=False, figsize=(2.5, .3), yticks=[])
shapes.set_ylabel('Heights', rotation=0, labelpad=37)

shapes = pd.DataFrame([s['dicts']['average branching factor'] for r in reports for s in r.values()])
shapes = shapes.plot.box(vert=False, figsize=(2.5, .3), yticks=[])
shapes.set_ylabel('ABF', rotation=0, labelpad=46)

shapes = pd.DataFrame([s['atomics']['count'] for r in reports for s in r.values()])
shapes = shapes.plot.box(vert=False, figsize=(2.5, .3), yticks=[])
shapes.set_ylabel('Fields', rotation=0, labelpad=40)
'''
