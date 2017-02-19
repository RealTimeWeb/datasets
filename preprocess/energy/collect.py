import os
import json
from bs4 import BeautifulSoup
import requests
import requests_cache
from pprint import pprint
import pandas as pd
from unidecode import unidecode
from tqdm import tqdm
from parse_table import table_to_list

import states

requests_cache.install_cache('url_cache')

def extract_table(html):
    soup = BeautifulSoup(html,'lxml')
    table = soup.find("table", attrs={"class":"basic_table"})
    
    if table is None:
        return table
    return table

    '''# The first tr contains the field names.
    datasets = []
    for row in table.find_all("tr"):
        dataset = list((td.get_text().strip(), 
                        td.attrs.get('colspan', 1),
                        td.attrs.get('rowspan', 1)) 
                       for td in row.find_all("td"))
        datasets.append(dataset)'''
    return datasets
    
def convert_fields(values):
    result = []
    for value in values:
        value = value[0]
        value = value.replace(',', '').strip()
        if not value:
            value = None
        elif value == '(s)':
            value = 0
        else:
            try:
                if '.' in value:
                    value = float(value)
                else:
                    value = int(value)
            except:
                value = None
                #print(unidecode(value))
        result.append(value)
    if not result or not isinstance(result[0], int):
        result = None
    return result
    
def decode_headers(table):
    tables = table_to_list(table)
    result = []
    for table in tables:
        found_years = False
        result_rows = []
        had_year = False
        for row in table:
            if row[0].lower() == 'year':
                had_year = True
            if row[0] in [str(x) for x in range(1960, 2015)]:
                result_rows.append(row)
                if not found_years:
                    found_years = True
            else:
                if not found_years:
                    result_rows.append(row)
        if had_year:
            result.append(result_rows)
    return result
indicators = {
    #-----Consumption
    'Consumption': 
        ('sep_use/total/use_tot_{state}', ('','')),
    'Residential Use': 
        ('sep_use/res/use_res_{state}', ('', '')),
    'Commercial Use': 
        ('sep_use/com/use_com_{state}', ('', '')),
    'Industrial Use': 
        ('sep_use/ind/use_ind_{state}', ('', '')),
    'Transportation Use': 
        ('sep_use/tra/use_tra_{state}', ('', '')),
    #-----Price (only goes back to 1970)
    'Price': 
        ('sep_prices/total/pr_tot_{state}', ('', '')),
    'Residential Price': 
        ('sep_prices/res/pr_res_{state}', ('', '')),
    'Commercial Price': 
        ('sep_prices/com/pr_com_{state}', ('', '')),
    'Industrial Price': 
        ('sep_prices/ind/pr_ind_{state}', ('', '')),
    'Transportation Price': 
        ('sep_prices/tra/pr_tra_{state}', ('', '')),
}

URL = 'http://www.eia.gov/state/seds/data.php?incfile=/state/seds/{indicator}{extra}.html'
XLS_URL = 'http://www.eia.gov/state/seds/sep_prod/xls/PT2_{state}.xlsx'

for full_ind, (code_ind, columns) in tqdm(indicators.items()):
    for full_state, code_state in states.full_to_code.items():
        for x in ['', 'a', 'cb']:
            end_url = URL.format(indicator=code_ind.format(state=code_state),
                                 extra=x)
            html = requests.get(end_url).content
            table = extract_table(html)
            if table is not None:
                break
        else:
            print("Could not find", full_state, full_ind)
        #print(code_state, full_ind, len(table), max([len(t) for t in table if t[0] ]))
        headers = decode_headers(html)
        print(list(set([len(t) for t in headers[0]])))
        #print(headers)
        #break
    #break
        #converted_table = [convert_fields(t) for t in table]
        #converted_table = [t for t in converted_table
        #                   if t is not None
        #                   and t[0] in range(1960, 2015)]
        #print(list(set([len(t) for t in converted_table])))
        #print(len(pd.DataFrame(converted_table).columns))
for full_state, code_state in states.full_to_code.items():
    prod_url = XLS_URL.format(state=code_state)
    prod = pd.read_excel(prod_url)
    prod.columns = ['Year', 'Coal', 'X', 'Natural Gas', 'Y', 'Crude Oil', 'Z',
                    'Nuclear', 'XX', 'Biofuels', 'YY', 'Other Renewable', 'ZZ',
                    'Total Renewable', 'XXX', 'Total', 'YYY']
    prod  = prod[['Year', 'Coal', 'Natural Gas', 'Crude Oil',
                    'Nuclear', 'Biofuels', 'Other Renewable',
                    'Total Renewable', 'Total']]
    #print(prod)
