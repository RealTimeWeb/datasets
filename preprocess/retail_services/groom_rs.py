import os
import json
import sys
import csvx
from tqdm import tqdm
from groomer import *

def fix_index(datasets, row):
    row['cat_idx'] = row['cat_idx']
    
NAME_MAP = {
    "department stores (excl. l.d.)": "non-leased department stores",
    "department stores (excl. discount department stores)": "non-discount department stores",
    "automotive parts, acc., and tire stores": "automotive parts and tire stores",
    "building mat. and garden equip. and supplies dealers": "building materials and garden supplies dealers",
    "radio, t.v., and other elect. stores": "radio, TV, and electronics stores",
    "department stores (incl. l.d.)": "all department stores",
    "all other gen. merchandise stores": "all other merchandise stores", 
    "clothing and clothing access. stores": "clothing stores", 
    "appl., tv, and other elect. stores": "appliances and other electronics stores", 
    "discount dept. stores": "discount department stores",
    "building mat. and supplies dealers": "building supplies dealers"
}

def make_index(data, key):
    return {d[key]: d for d in data}
def load_csv(filename, key):
    with csvx.OrderedDictReader(filename) as csv_in:
        return make_index(csv_in, key)
def blanks(keys):
    return {k: 0 for k in keys}
def clean_category(category):
    category = category.lower().split(":")[1].strip()
    if category in NAME_MAP:
        category = NAME_MAP[category]
    return category
months = {
    'Jan': 1, 'Feb': 2, 'Mar': 3, 'Apr': 4, 'May': 5,
    'Jun': 6, 'Jul': 7, 'Aug': 8, 'Sep': 9, 'Oct': 10,
    'Nov': 11, 'Dec': 12
}

categories = load_csv('categories.csv', 'cat_idx')
category_keys = [clean_category(c['cat_desc'])
                 for c in categories.values()]
time_periods = load_csv('time_periods.csv', 'per_idx')
data_types = load_csv('data_types.csv', 'dt_idx')
remap_dt = {'Sales - Monthly': "sales",
            "Inventories - Monthly": "inventories",
            "Inventories/Sales Ratio": "ratio"}
data_type_keys = [remap_dt.get(d['dt_desc'], '') for d in data_types.values()]

data = {}
with csvx.OrderedDictReader('data.csv') as csv_in:
    for row in tqdm(csv_in):
        if row["is_adj"] != "0": continue
        period = time_periods.get(row['per_idx'])['per_name']
        if period not in data:
            month, year = period[:3], period[3:]
            data[period] = {
                'time': {'month': months[month], 
                         'month name': month,
                         'year': int(year), 
                         'index': int(row['per_idx']),
                         'period': period},
                'data': {'sales': blanks(category_keys), 
                         'inventories': blanks(category_keys), 
                         'ratio': blanks(category_keys)}
            }
        if row['dt_idx'] in ('4', '5', '6'):
            continue
        if row['et_idx'] != '0': continue
        data_type = remap_dt[data_types[row['dt_idx']]['dt_desc']]
        category = clean_category(categories[row['cat_idx']]['cat_desc'])
        if row["val"] == "(S)":
            value = 0
        elif data_type != 'ratio': 
            value = int(float(row['val']))
        else:
            value = float(row['val'])
        data[period]['data'][data_type][category] = value
data = sorted(data.values(), key=lambda x: x['time']['index'])
json.dump(data, open('retail_services.json', 'w'), indent=2)

from collections import Counter
checker = Counter()
for period in data:
    print(type(period))
    for data_type in period['data']:
        for category, value in period['data'][data_type].items():
            if value > 0:
                checker[ (data_type, category) ] += 1
pprint(dict(checker))
