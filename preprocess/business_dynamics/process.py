'''
You will need a JSON file in this directory named 'census_keys.json' with your Census API key.
The JSON should be a dictionary with a key named 'key'. You can get a free API key from:
http://api.census.gov/data/key_signup.html

This product uses the Census Bureau Data API but is not endorsed or certified by the Census Bureau.
'''

import requests
import json
import requests_cache
import pandas as pd
import numpy as np
from pprint import pprint
from fips import lookup_states

requests_cache.install_cache('census_data')

with open('census_keys.json') as census_keys:
    census_key = json.load(census_keys).get('key', 'NO KEY AVAILABLE')

root = 'http://api.census.gov/data/bds/firms?get={keys}&for=state:*&year2={year}&key={key}'

YEARS = range(1977, 2014)
KEYS = ['denom', 'emp', 'estabs', 'estabs_entry', 'estabs_entry_rate',
        'estabs_exit', 'estabs_exit_rate', 'firmdeath_emp','firmdeath_estabs',
        'firmdeath_firms', 'firms', 'job_creation', 
        'job_creation_births', 'job_creation_continuers', 'job_creation_rate',
        'job_creation_rate_births', 'job_destruction', 'job_destruction_continuer',
        'job_destruction_deaths', 'job_destruction_rate', 'job_destruction_rate_deat',
        'net_job_creation', 'net_job_creation_rate', 'reallocation_rate']
keys_str = ','.join(KEYS)
types = [int, int, int, int, float,
         int, float, int, int,
         int, int, int,
         int, int, float,
         float, int, int,
         int, float, float,
         int, float, float,
         int, str]

result = []
for year in YEARS:
    url = root.format(keys=keys_str, year=year, 
                      key=census_key)
    json_data = requests.get(url).json()
    header = json_data[0]
    states = json_data[1:]
    for state in states:
        r = {h: lookup_states[s] if h == 'state' else t(s)
             for h, s, t in zip(header, state, types)}
        i = {
            'Year': r['year2'],
            'State': r['state'],
            'Data': {
                'Number of Firms': r['firms'],
                'DHS Denominator': r['denom'],
                'Job Creation': {
                    'Births': r['job_creation_births'],
                    'Count': r['job_creation'],
                    'Continuers': r['job_creation_continuers'],
                    'Rate': r['job_creation_rate'],
                    'Rate/Births': r['job_creation_rate_births']
                },
                'Job Destruction': {
                    'Deaths': r['job_destruction_deaths'],
                    'Count': r['job_destruction'],
                    'Continuers': r['job_destruction_continuer'],
                    'Rate': r['job_destruction_rate'],
                    'Rate/Deaths': r['job_destruction_rate_deat']
                },
                'Establishments': {
                    'Physical Locations': r['estabs'],
                    'Entered': r['estabs_entry'],
                    'Entered Rate': r['estabs_entry_rate'],
                    'Exited': r['estabs_exit'],
                    'Exited Rate': r['estabs_exit_rate']
                },
                'Firm Exits': {
                    'Count': r['firmdeath_firms'],
                    'Job Destruction': r['firmdeath_emp'],
                    'Establishment Exit': r['firmdeath_estabs']
                },
                'Calculated': {
                    'Net Job Creation': r['net_job_creation'],
                    'Net Job Creation Rate': r['net_job_creation_rate'],
                    'Reallocation Rate': r['reallocation_rate']
                }
                #'denom'
            }
        }
        result.append(i)

with open('business_dynamics.json', 'w') as out:
    json.dump(result, out)

#print(url)
#data = requests.get(url).json()
#df = pd.DataFrame(data[1:], columns=data[0])
'''
    Category
        Attribute
    Year
    State
'''