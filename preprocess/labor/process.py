# -*- coding: utf-8 -*-
"""
Created on Thu Apr 16 10:33:13 2015

@author: acbart
"""

from collections import defaultdict
import json
import sys
from pprint import pprint

def _parse_int(v):
    try:
        return int(v)
    except ValueError:
        return -1
        
'''        	LNS11000003
Civilian Labor Force Level	White
LFS	Civilian labor force
Type	Number in thousands
Age	16 years and over
Race	White'''


mapper = defaultdict(lambda: defaultdict(defaultdict))
GOOD_KEYS = set(['Age', "LFS", "Race", "Type", "Sex"])
with open('labor_race_tags.txt') as infile:
    lines = infile.read().split("\n")
    data = {}
    for line in lines:
        tag, val = line.split('\t')
        if tag == "ID":
            id = val
            data[id] = {}
        elif tag in GOOD_KEYS:
            data[id][tag] = val

for key, datums in data.items():
    if 'Sex' in GOOD_KEYS.difference(datums.keys()):
        datums['Sex'] = 'All'
    if 'and over' not in datums['Age']:
        continue
    mapper[datums['LFS']][datums['Race']][datums['Sex']] = key

for k1, v1 in mapper.items():
    print k1
    for k2, v2 in v1.items():
        print '\t', k2
        for k3, v3 in v2.items():
            print '\t'*2, k3, v3

DATA = defaultdict(lambda: defaultdict(defaultdict))
YEARS = defaultdict(lambda: defaultdict(lambda: defaultdict(defaultdict)))
with open('labor_race.csv') as infile:
    lines = [line.split(',') for line in infile]
    header = lines[0][:-9]
    rows = lines[1:]
    data = {r[0]: [_parse_int(v.strip()) 
                    for v in r[1:]][:-9] 
            for r in rows}
    for variable, v1 in mapper.items():
        for race, v2 in v1.items():
            for gender, v3 in v2.items():
                if data[v3][0] == -1:
                    continue
                DATA[variable][race][gender] = data[v3]
                YEARS[v3][variable][race][gender] = data[v3]
                
            #if len(value) == 3:
                #rows = data[race[1]]
                #if rows[0] != -1:
                    #DATA[key][race[0]] = data[race[1]]
#pprint(YEARS)
json.dump(DATA, open('race_labor.json', 'wb'))