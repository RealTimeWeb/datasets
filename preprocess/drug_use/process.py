'''
2002 and 2009 need to be converted from % to estimates
    https://www.census.gov/data/datasets/time-series/demo/popest/intercensal-2000-2010-state.html
    Intercensal Estimates of the Resident Population by Single Year of Age and Sex for States and the United States: April 1, 2000 to July 1, 2010 
    Strip out all where (age!=999, sex!=0) and keep columns (NAME, 2002, 2009)
'''

import re
import os, sys
import pandas as pd
import numpy as np
import json
from tqdm import tqdm
from pprint import pprint
from collections import Counter
import matplotlib.pyplot as plt

pop_map_table = pd.read_csv('population.tsv', sep='\t')
bins = [0,12, 18, 26, 100]
labels= ['<12', '12-17', '18-25', '26+']
frames = []
frames_minors = []
keys = []
for s, g in pop_map_table.groupby(['State']):
    # Regular divisions
    cuts = g.groupby(pd.cut(g['Age'], bins=bins, labels=labels)).sum()
    del cuts['Age']
    cuts = cuts.iloc[1:,:]
    cuts = cuts.T
    frames.append(cuts)
    # Minors
    minors = g.groupby(pd.cut(g['Age'], bins=[0,12,21, 100], labels=['<12', '12-20', '20+'])).sum()
    del minors['Age']
    minors = minors.iloc[1:2,:].T
    frames_minors.append(minors)
    # And keep track of key
    keys.append(s)
pop_map_table = pd.concat(frames, keys=keys)
pop_map_table_minors = pd.concat(frames_minors, keys=keys)
#print(pop_map_table)
#pop_map_table.groupby(['Name']).transform('sum')

#pop_map_table = pd.melt(pop_map_table, id_vars=['State'], var_name='Year', value_name='Population')
#print(pop_map_table.columns)
pop_map_table.columns = labels[1:]
pop_map_table = pop_map_table.reset_index()
pop_map_table.columns = ['State', 'Year'] + [l+' Pop' for l in labels[1:]]
pop_map_table['Year'] = pop_map_table['Year'].astype(int)

pop_map_table_minors.columns = ['12-20 Pop']
pop_map_table_minors = pop_map_table_minors.reset_index()
pop_map_table_minors.columns = ['State', 'Year', '12-20 Pop']
pop_map_table_minors['Year'] = pop_map_table_minors['Year'].astype(int)

df = pd.read_csv('drug_use_intermediate.csv', index_col=0)
# Fix the non-numerics
non_decimal = re.compile(r'[^\d.]+')
numerics = '12-17,12-20,18-25,26+,Binge 12-20'.split(',')
df[numerics] = df[numerics].applymap(lambda x: x if not type(x)==str else non_decimal.sub('', x))
df[numerics] = df[numerics].astype('float64')
df['Year'] = df["Year"].astype(int)

# add in populations
df = df.merge(pop_map_table, 
              left_on=['Year', 'State'],
              right_on=['Year', 'State'])
df = df.merge(pop_map_table_minors, 
              left_on=['Year', 'State'],
              right_on=['Year', 'State'])
# Adjust everything to be rates

for n in numerics:
    original_values = df.ix[~df.Year.isin([2002, 2009]), n]
    if n == 'Binge 12-20':
        name = '12-20 Pop'
    else:
        name = n+' Pop'
    populations = df.ix[~df.Year.isin([2002, 2009]), name]
    df.ix[~df.Year.isin([2002, 2009]), n] =  (1000*original_values) / populations*100
df = df.sort_values(by=['Table', 'Year', 'State'])
#print(df[df['State']=="California"][df['Table']=='Illicit Drug Use Past Month'].sort_values(by=['Table','Year'])[['Table', 'Year', '12-17', '18-25', '26+', '26+ Pop']])
#plt.plot(df['Year'], df['12-17'])
#plt.show()
#print(df['Year'].unique())
#2002 2009 2011 2013 2014
frames = []
for (table, state), g in list(df.groupby(['Table', 'State'])):
    new = pd.DataFrame({'Year': [2003, 2004, 2005, 2006, 2007, 2008, 2010, 2012],
                        'State': state,
                        'Table': table})
    combined = pd.concat((g, new))
    combined = combined.sort_values(by=['Year'])
    combined = combined.set_index(['Year'])
    combined = combined.interpolate(method='index')
    combined = combined.reset_index()
    frames.append(combined)
all = pd.concat(frames)

def extract(g, name):
    return {
        '12-17': g[g['Table'] == name]['12-17'].iloc[0],
        '18-25': g[g['Table'] == name]['18-25'].iloc[0],
        '26+': g[g['Table'] == name]['26+'].iloc[0]
    }
def extract_some(g, name):
    print(name, g[g['Table'] == name])
    print(len(g[g['Table'] == name]['18-25']))
    print(len(g[g['Table'] == name]['26+']))
    return {
        '18-25': g[g['Table'] == name]['18-25'].iloc[0],
        '26+': g[g['Table'] == name]['26+'].iloc[0]
    }

data = []
for (year, state), g in all.groupby(['Year', 'State']):
    row = {
        'Year': int(year),
        'State': state,
        'Population': {
            '12-17': int(g[g['Table'] == 'Marijuana Use Past Year']['12-17 Pop'].iloc[0]),
            '18-25': int(g[g['Table'] == 'Marijuana Use Past Year']['18-25 Pop'].iloc[0]),
            '12-20': int(g[g['Table'] == 'Marijuana Use Past Year']['12-20 Pop'].iloc[0]),
            '26+': int(g[g['Table'] == 'Marijuana Use Past Year']['26+ Pop'].iloc[0])
        },
        'Totals': {},
        'Rates': {
            'Marijuana': {
                'Used Past Year': extract(g, 'Marijuana Use Past Year'),
                'Used Past Month': extract(g, 'Marijuana Use Past Month'),
                'Perceptions of Risk': extract(g, 'Perceptions of Monthly Marijuana Risk'),
                'New Users': extract(g, 'Average Annual Marijuana Initiates')
            },
            'Illicit Drugs': {
                'Cocaine Used Past Year': extract(g, 'Cocaine Use Past Year'),
                'Used Past Month': extract(g, 'Illicit Drug Use Past Month'),
                'All Except Marijuana Used Past Month': extract(g, 'Non-Marijuana Illicit Drug Use Past Month'),
                'Abuse Past Month': extract(g, 'Illicit Drug Use Past Month'),
                'Dependence Past Year': extract(g, 'Illicit Drug Dependence Past Year'),
                'Need Treatment Past Year': extract(g, 'Need Treatment Illicit Drug Use Past Year'),
            },
            'Pain Relievers Abuse Past Year': extract(g, 'Pain Relievers Abuse Past Year'),
            'Alcohol': {
                'Need Treatment Past Year': extract(g, 'Need Treatment Alcohol Use Past Year'),
                'Use Past Month': extract(g, 'Alcohol Use Past Month'),
                'Binge Past Month': extract(g, 'Binge Alcohol Use Past Month'),
                'Perceptions of Risk': extract(g, 'Perceptions of Weekly 5+ Alcohol Risk Risk'),
                'In Minors': {
                    'Use': g[g['Table'] == 'Alcohol/Binge Use in Minors']['12-20'].iloc[0],
                    'Abuse': g[g['Table'] == 'Alcohol/Binge Use in Minors']['Binge 12-20'].iloc[0]
                },
                'Abuse Past Year': extract(g, 'Alcohol Abuse Past Year'),
                'Dependence Past Year': extract(g, 'Alcohol Dependence Past Year'),
            },
            'Tobacco': {
                'Use Past Month': extract(g, 'Tobacco Use Past Month'),
                'Cigarette Past Month': extract(g, 'Cigarette Use Past Month'),
                'Perceptions of Risk': extract(g, 'Perceptions of Daily Smoking Risk'),
            },
            # Mental Illness data does not extend far enough back
            #'Mental Illness': {
            #    'Serious MI Past Year': extract_some(g, 'Serious Mental Illness Past Year'),
            #    'Any MI Past Year': extract_some(g, 'Any Mental Illness Past Year'),
            #    'Suicidal Thoughts Past Year': extract_some(g, 'Serious Suicidal Thoughts Past Year'),
            #    'Depressive Episode Past Year': extract_some(g, 'Depressive Episode Past Year'),
            #}
        }
    }
    for cat, cat_data in row['Rates'].items():
        row['Totals'][cat] = {}
        if cat == 'Pain Relievers Abuse Past Year':
            for age_group, age_data in cat_data.items():
                population = row['Population'][age_group]
                row['Rates'][cat][age_group] = round(float(age_data), 2)
                row['Totals'][cat][age_group] = int(age_data * population / 1000)
            continue
        for subcat, subcat_data in cat_data.items():
            row['Totals'][cat][subcat] = {}
            for age_group, age_data in subcat_data.items():
                if subcat == 'In Minors':
                    population = row['Population']['12-20']
                else:
                    population = row['Population'][age_group]
                row['Rates'][cat][subcat][age_group] = round(float(age_data), 2)
                row['Totals'][cat][subcat][age_group] = int(age_data * population / 1000)
    data.append(row)
    
with open('drug_use.json', 'w') as out:
    json.dump(data, out, indent=2)