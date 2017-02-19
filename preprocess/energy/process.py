import pandas as pd
import json
import states
from tqdm import tqdm

df = pd.read_csv('Complete_SEDS.csv')


codes = df['MSN'].unique()
sources = [c[:2] for c in codes]
uses = [c[2:4] for c in codes]
purposes = [c[4] for c in codes]
#print(list(sorted(set(sources))))
#print(list(sorted(set(uses))))
#print(list(sorted(set(purposes))))
#print(df['MSN'].str[:2].value_counts())

#states = df['StateCode'].value_counts()
#print(len(states))

sources = {
    'CL': 'Coal',
    #'EL': 'Electricity',
    'NG': 'Natural Gas',
    'NU': 'Nuclear',
    #'PA': 'Petroleum',
    #'WD': 'Wood',
    #'WW': 'Biomass Waste',
    'DF': 'Distillate Fuel Oil',
    'LG': 'Liquefied Petroleum Gases',
    #'RF': 'Residual Fuel Oil',
    #'ES': 'Electricity Sales',
    #'MG': 'Motor Gasoline',
    'KS': 'Kerosene',
    #'PC': 'Petroleum Coke',
    #'LU': 'Lubricants',
    #'PE': 'Primary Energy',
    #'AR': 'Asphalt and Road Oil',
    'PO': 'Other Petroleum Products',
    #'JF': 'Jet Fuel',
    #'AV': 'Aviation Gasoline',
    'WY': 'Wind',
    'HY': 'Hydropower',
    'SO': 'Solar',
    'WD': 'Wood',
    'GE': 'Geothermal'
}

sectors = {
    'Consumption': {
        'Transportation': 'ACB',
        'Commercial': 'CCB',
        'Electric Power': 'EIB',
        'Industrial': 'ICB',
        'Residential': 'RCB',
        'Refinery': 'RFB'
    },
    'Price': {
        'Transportation': 'ACD',
        'Commercial': 'CCD',
        'Electric Power': 'EID',
        'Industrial': 'ICD'
    },
    'Production': {
        'Production': 'PRB',
        #'Marketed Production': 'MPB'
    },
    'Expenditure': {
        'Transportation': 'ACV',
        'Commercial': 'CCV',
        'Electric Power': 'EIV',
        'Industrial': 'ICV',
        'Residential': 'RCV'
    }
}

skip_tags = []
for major, major_group in tqdm(sectors.items()):
    for minor, minor_code in major_group.items():
        for source_code, source_name in sources.items():
            full_code = source_code+minor_code
            if df[df['MSN'] == full_code]['Data'].sum() == 0:
                skip_tags.append(full_code)
print(skip_tags)

df.set_index(['MSN', 'StateCode', 'Year'], inplace=True)
del df['Data_Status']
print(df.head())

def build_data_file():
    results = []
    for year in tqdm(range(1960, 2015)):
        for state_name, state_code in states.full_to_code.items():
            row = {
                'Year': year,
                'State': state_name
            }
            for major, major_group in sectors.items():
                for minor, minor_code in major_group.items():
                    for source_code, source_name in sources.items():
                        full_code = source_code+minor_code
                        if full_code in skip_tags:
                            continue
                        id = (full_code, state_code, year)
                        try:
                            value = df.loc[id, 'Data']
                        except KeyError:
                            value = 0
                        if major not in row:
                            row[major] = {}
                        if minor not in row[major]:
                            row[major][minor] = {}
                        row[major][minor][source_name] = value
            row['Production'] = row['Production']['Production']
            results.append(row)
    with open('energy.json', 'w') as out:
        json.dump(results, out)
        
