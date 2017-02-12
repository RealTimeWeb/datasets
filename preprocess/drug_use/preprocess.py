'''
Data retrieved from:
    Tables extracted from raw HTML:
        https://www.samhsa.gov/data/sites/default/files/NSDUHStateEst2011-2012/CountTabs/Web/NSDUHsaeCountTabs2012.htm
        https://www.samhsa.gov/data/sites/default/files/NSDUHStateEst2010-2011_v2/279/ChangeTabs/NSDUHsaeChangeTabs2011.htm
        https://www.samhsa.gov/data/sites/default/files/NSDUHStateEst2009-2010/TrendTabs/NSDUHsaeTrendTabs2010.htm#EqA86
    
    Tables extracted from XLS files:
        https://www.samhsa.gov/data/reports-by-geography?tid=624&map=1
        (Individual files)
        https://www.samhsa.gov/data/sites/default/files/NSDUHsaeTotals2013/NSDUHsaeTotals2013.xlsx
        https://www.samhsa.gov/data/sites/default/files/NSDUHsaeTotals2014.xlsx
        https://www.samhsa.gov/data/sites/default/files/NSDUHsaeExcelTabs2015.xlsx
'''
import os, sys
import pandas as pd
import numpy as np
import json
from tqdm import tqdm
from pprint import pprint
from collections import Counter
import matplotlib.pyplot as plt

tsv_files = ['2011-2012.tsv', '2009-2010 and 2010-2011.tsv', '2002-2003 and 2009-2010.tsv']
def separate_tsv_files():
    for path in tsv_files:
        chunk = []
        i = 0
        with open(path) as inp:
            for line in inp:
                if not line.strip():
                    with open('seps/{i}_{f}'.format(i=i, f=path), 'w') as out:
                        for c in chunk:
                            out.write(c)
                    chunk = []
                    i += 1
                else:
                    chunk.append(line)
            else:
                with open('seps/{i}_{f}'.format(i=i, f=path), 'w') as out:
                    for c in chunk:
                        out.write(c)

full_data = pd.DataFrame(columns={'State', 'Year', 'Table', '12-17', '18-25', '26+', '12-20', 'Binge 12-20'})
    
named_columns = []
with open('named_columns.txt') as inp:
    for line in inp:
        named_columns.append(line.strip())

for year, xlsx_file in [('2013', '2013_short.xlsx'), ('2014', '2014_short.xlsx')]:
    for sheet_id, table_name in enumerate(named_columns):
        df = pd.read_excel(xlsx_file, sheetname=sheet_id)
        if sheet_id == 11:
            keeps = ["State",
                     "Alcohol Use\nin Past Month\nEstimate",
                     "Binge Alcohol Use\nin Past Month\nEstimate"]
            df = df[keeps]
            df = df.rename(columns={"Alcohol Use\nin Past Month\nEstimate": '12-20', 
                                    "Binge Alcohol Use\nin Past Month\nEstimate": 'Binge 12-20'})
        else:
            keep_columns = [potential
                            for potential in 
                                ['State', '12-17\nEstimate', '18-25\nEstimate', '26 or Older\nEstimate']
                            if potential in df.columns]
            df = df[keep_columns]
            df = df.rename(columns={'12-17\nEstimate': '12-17',
                                    '18-25\nEstimate': '18-25',
                                    '26 or Older\nEstimate': '26+'})
            #if not keep_columns:
                #print(sheet_id, table_name)
        df = df.iloc[5:,]
        df['Year'] = int(year)
        df['Table'] = table_name
        #print(df.head())
        full_data = full_data.append(df)

short_files = zip(['2011','2009','2002'], tsv_files)
for name, tsv_file in short_files:
    for i, table_name in zip(range(0, 27), named_columns):
        path = 'seps/{i}_{f}'.format(i=i, f=tsv_file)
        if not os.path.exists(path):
            continue
        df = pd.read_csv(path, sep='\t', dtype=str)
        if name == '2011':
            if (bool([x for x in df.columns if '12-17' in x])):
                df.columns = ['State', 'G1', 'G2', '12-17', 'G3', '18-25', 'G4', '26+', 'G5', 'G6', 'G7']
                df = df[['State', '12-17', '18-25', '26+']]
            elif df.columns[0].startswith('Table 12'):
                df.columns = ['State', '12-20', 'G1', 'Binge 12-20', 'G2', 'G4', 'G5', 'G6', 'G7', 'G8', 'G9']
                df = df[['State', '12-20', 'Binge 12-20']]
            else:
                df.columns = ['State', 'G1', 'G2', '18-25', 'G4', '26+', 'G5', 'G6', 'G7', 'G8', 'G9']
                df = df[['State', '18-25', '26+']]
        elif name == '2009':
            if (bool([x for x in df.columns if '12-17' in x])):
                df.columns = ['State', 'G1', 'G2', 'G2P', '12-17', 'G3', 'G3P', '18-25', 'G4', 'G4P', '26+', 'G5', 'G6']
                df = df[['State', '12-17', '18-25', '26+']]
            elif df.columns[0].startswith('Table 12'):
                df.columns = ['State', '12-20', 'G1', 'G1P', 'Binge 12-20', 'G2', 'G4', 'G5', 'G6', 'G7', 'G8', 'G9', 'G10']
                df = df[['State', '12-20', 'Binge 12-20']]
            else:
                df.columns = ['State', 'G1', 'G2', 'G2P', '18-25', 'G4', 'G4P', '26+', 'G5', 'G6', 'G7', 'G8', 'G9']
                df = df[['State', '18-25', '26+']]
        elif name == '2002':
            if (bool([x for x in df.columns if '12-17' in x])):
                df.columns = ['State', 'G1', 'G2', 'G2P', '12-17', 'G3', 'G3P', '18-25', 'G4', 'G4P', '26+', 'G5', 'G6']
                df = df[['State', '12-17', '18-25', '26+']]
            elif df.columns[0].startswith('Table 12'):
                df.columns = ['State', '12-20', 'G1', 'G1P', 'Binge 12-20', 'G2', 'G4', 'G5', 'G6', 'G7', 'G8', 'G9', 'G10']
                df = df[['State', '12-20', 'Binge 12-20']]
        df = df.iloc[5:,]
        df['Year'] = int(name)
        df['Table'] = table_name
        full_data = full_data.append(df)
#print(full_data)
full_data.to_csv('drug_use_intermediate.csv')