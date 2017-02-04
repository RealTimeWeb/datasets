from jinja2 import Environment, FileSystemLoader
import os
import json
import matplotlib
from sklearn import preprocessing


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

plt.style.use('ggplot')

data_types = pd.DataFrame([s['atomics'] for r in reports for s in r.values()])
data_types['lists'] = [s['lists']['count'] for r in reports for s in r.values()]
data_types['objects'] = [s['dicts']['count'] for r in reports for s in r.values()]
data_types = data_types[['booleans', 'floats', 'ints', 'strings', 'lists', 'objects']]
data_types.columns = ['Bool', 'Float', 'Integer', 'String', 'Lists', 'Objects']
#data_types = data_types.apply(lambda c: c / c.sum() * 100, axis=1)
ax = data_types.plot.box(vert=False, figsize=(2.5,2.5))
ax.set_xlabel('Percentage of Total Types')
ax.set_ylabel('Types')
plt.show()

min_max_scaler = preprocessing.MinMaxScaler()

dt_stds = pd.DataFrame(columns=[])
dt_stds["Number"] = min_max_scaler.fit_transform(data_types['Integer']+data_types['Float'])
dt_stds["Text"] = min_max_scaler.fit_transform(data_types['String'])
dt_stds = dt_stds[dt_stds < .4]
plt.scatter(dt_stds['Text'], dt_stds['Number'])
plt.xlabel("Percentage of Texts")
plt.ylabel("Percentage of Numbers")
plt.show()

shapes = pd.DataFrame([{'Heights': s['heights'],
                        'Average Branching Factor': s['dicts']['average branching factor'],
                        'Number of Fields': s['atomics']['count'],
                        'Rows (1000s)': s['length']/1000,
                        'Size (MB)': s['size']/1000/1000,
                        'Indexes': sum(s.get('indexes', []))
}
 for r in reports for s in r.values()])

for r in reports:
    for s in r.values():
        if 'levels' not in s['dicts']:
            print(r)

levels = pd.DataFrame([{l: v for l,v in 
                        s['dicts']['levels'].items()}
   for r in reports for s in r.values()])
levels = levels.reindex_axis(reversed(sorted(levels.columns)), axis=1)

f, axarr = plt.subplots(2, 2, figsize=(9, 6))
shapes["Heights"].value_counts(sort=False).plot.bar(rot=False, ax=axarr[0, 0])
axarr[0, 0].set_xlabel("Heights")
axarr[0, 0].set_ylabel("Number of Datasets")
axarr[0, 0].set_title("Distribution of Datasets' Heights")
axarr[1, 0].set_title("TESTING")
plt.tight_layout()

'''
levelIQR = pd.DataFrame(columns=levels.columns)
for c in levels.columns:
    levelIQR[c] = [levels[c].quantile(0.75) - levels[c].quantile(0.25) ]
levels.median()
levelIQR.T
levels.count()
levels.T.count().plot.box()
levels.count()[::-1].diff().abs().shift(-1).fillna(2)
jx = levels.count()[::-1].diff().abs().shift(-1).fillna(2).tolist()
jz = [p for i, x in enumerate(jx) for p in [i]*int(x)]
pd.Series(jz).plot.box()
plt.show()
'''

sax = shapes.plot.box(subplots=True, vert=False, layout=(6, 1), 
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
