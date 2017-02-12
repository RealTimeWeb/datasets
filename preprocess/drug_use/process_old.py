'''
Data retrieved from:
    http://datafiles.samhsa.gov/info/browse-studies-nid3454
    For each URL in [National Survey on Drug Use and Health (NSDUH)]
        Visit [Datasets in this Study]
        Download Stata data
'''
import os, sys
import pandas as pd
import numpy as np
import json
from tqdm import tqdm
from pprint import pprint
from collections import Counter
import matplotlib.pyplot as plt

paths = sorted(os.listdir('./'))
def check_columns():
    all_columns = Counter()
    for path in paths:
        if path.endswith('.dta'):
            #print(path[6:])
            df = pd.read_stata(path, chunksize=10, convert_categoricals=False)
            first = next(df)
            new_columns = set(first.columns)
            for c in new_columns:
                all_columns[c.upper()] += 1
    pprint((sorted(all_columns.items(), key=lambda x : -x[1])))
#check_columns()

def do_something():
    all = []
    xs = []
    for path in tqdm(paths):
        if path.endswith('.dta'):
            #print(path[6:10])
            year = path[6:10]
            xs.append(int(year))
            df = pd.read_stata(path, convert_categoricals=False) 
            df.columns = [x.upper() for x in df.columns]
            if 'IRSEX' not in df.columns:
                print(year)
            if 'CIGMON' in df.columns:
                vs = df['CIGMON'].mean()
            else:
                vs = -1
            #vs = len(df.columns)
            all.append(vs)
    print(len(xs))
    plt.plot(xs, all)
    plt.show()
    
df = pd.read_stata('NSDUH-2002-DS0001-data-stata.dta', chunksize=10, convert_categoricals=False)
df = next(df)
pprint(sorted(list(df.columns)))