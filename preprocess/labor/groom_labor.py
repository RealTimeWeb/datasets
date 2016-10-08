import os
from collections import defaultdict
from pprint import pprint
import json

GOOD_KEYS = set(['Age', "LFS", "Race", "Type", "Sex"])
def process_header(header):
    sex = 'All'
    if 'Sex' not in GOOD_KEYS.difference(header.keys()):
        sex = header['Sex']
    if 'and over' not in header['Age']:
        return False, False, False, False
    return header['Labor force status'], header['Race'], sex, header['Type of data']

PERIODS = {}
CHECKS = defaultdict(lambda: 0)
with open('labor.txt') as raw_data:
    mode = 'data'
    headers = []
    header = None
    data = None
    for line in raw_data:
        if line.lower().startswith('series id'):
            if mode == 'data':
                mode = 'header'
                if data is not None:
                    print(len(data))
                header = {}
                data = []
                continue
            elif mode == 'header':
                if header is not None:
                    pprint(header)
                    headers.append(header)
                mode = 'data'
                continue
        elif mode == 'header':
            if ':' in line:
                key, value = line.split(':', 1)
                key, value = key.strip(), value.strip()
                header[key] = value
        elif mode == 'data' and line.strip():
            series, year, month, value = line.split(',')
            time_period = year + month
            month = int(month[1:])
            year = int(year)
            value = float(value)
            if year < 1972 or year == 2016: continue #Insufficient data outside of these years
            lfs, race, sex, data_type = process_header(header)
            if lfs is False: continue
            CHECKS[(lfs, race, sex)] += 1
            if time_period not in PERIODS:
                PERIODS[time_period] = {'year': year, 'month': month, 
                                        'data': defaultdict(lambda: defaultdict(defaultdict))}
            PERIODS[time_period]['data'][lfs][race][sex] = {
                'value': value,
                'units': data_type
            }
for time_period, period in PERIODS.items():
    period = period['data']
    if 'Asian' not in period['Civilian labor force']:
        period['Civilian labor force']['Asian']['All'] = 0
        CHECKS['Civilian labor force', 'Asian', 'All'] += 1
        period['Civilian labor force participation rate']['Asian']['All'] = 0
        CHECKS['Civilian labor force participation rate', 'Asian', 'All'] += 1
        period['Civilian noninstitutional population']['Asian']['All'] = 0
        CHECKS['Civilian noninstitutional population', 'Asian', 'All'] += 1
        period['Employed']['Asian']['All'] = 0
        CHECKS['Employed', 'Asian', 'All'] += 1
        period['Employment-population ratio']['Asian']['All'] = 0
        CHECKS['Employment-population ratio', 'Asian', 'All'] += 1
        period['Not in labor force']['Asian']['All'] = 0
        CHECKS['Not in labor force', 'Asian', 'All'] += 1
        period['Unemployed']['Asian']['All'] = 0
        CHECKS['Unemployed', 'Asian', 'All'] += 1
        period['Unemployment rate']['Asian']['All'] = 0
        CHECKS['Unemployment rate', 'Asian', 'All'] += 1
    if 'White' not in period['Not in labor force']:
        period['Not in labor force']['White']['All'] = 0
        CHECKS['Not in labor force', 'White', 'All'] += 1
PERIODS = [P[1] for P in sorted(PERIODS.items())]
pprint(dict(CHECKS).values())
#pprint(PERIODS)
json.dump(PERIODS, open('labor_old.json', 'wb'))