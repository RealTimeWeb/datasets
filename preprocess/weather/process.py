'''

Data is National Weather Service's QCLCD
https://www.ncdc.noaa.gov/orders/qclcd/


'''

import os
import urllib
import urllib.request
import zipfile
import json
import pandas as pd
from pprint import pprint
try:
    import tqdm
except ImportError:
    tqdm = list
    
STATE_LOOKUP = {
    'Alabama': "AL",
    'Alaska': "AK",
    'Arizona': "AZ",
    'Arkansas': "AR",
    'California': "CA",
    'Colorado': "CO",
    'Connecticut': "CT",
    'Delaware': "DE",
    'District of Columbia': "DC",
    'Florida': "FL",
    'Georgia': "GA",
    'Hawaii': "HI",
    'Idaho': "ID",
    'Illinois': "IL",
    'Indiana': "IN",
    'Iowa': "IA",
    'Kansas': "KS",
    'Kentucky': "KY",
    'Louisiana': "LA",
    'Maine': "ME",
    'Maryland': "MD",
    'Massachusetts': "MA",
    'Michigan': "MI",
    'Minnesota': "MN",
    'Mississippi': "MS",
    'Missouri': "MO",
    'Montana': "MT",
    'Nebraska': "NE",
    'Nevada': "NV",
    'New Hampshire': "NH",
    'New Jersey': "NJ",
    'New Mexico': "NM",
    'New York': "NY",
    'North Carolina': "NC",
    'North Dakota': "ND",
    'Ohio': "OH",
    'Oklahoma': "OK",
    'Oregon': "OR",
    'Pennsylvania': "PA",
    'Rhode Island': "RI",
    'Puerto Rico': "PR",
    'South Carolina': "SC",
    'South Dakota': "SD",
    'Tennessee': "TN",
    'Texas': "TX",
    'Utah': "UT",
    'Vermont': "VT",
    'Virginia': "VA",
    'Washington': "WA",
    'West Virginia': "WV",
    'Wisconsin': "WI",
    'Wyoming': "WY"
}
CODE_LOOKUP = {v:k for k,v in STATE_LOOKUP.items()}

def get_file(files, ending):
    for file in files:
        if file.endswith(ending+'.txt'):
            return file

def process_station(data):
    df = pd.read_table(data, sep='|').dropna()
    cities = df.Name.str.title()
    states = df.State.map(CODE_LOOKUP)
    state_codes = df.State
    wbans = df.WBAN
    locations = cities + ', ' + state_codes
    codes = df.CallSign
    result = []
    seen = set()
    seen_wbans = []
    mapper = {}
    for co, s, l, ci, w, sc in zip(codes, states, locations, cities, wbans, state_codes):
        if sc in ('AS', 'MH', 'VI', 'GU', 'MP', 'FM', 'PW'):
            continue
        if l in seen:
            continue
        seen.add(l)
        seen_wbans.append(w)
        full = {'City': ci,
             'Code': co,
             'Location': l,
             'State': s}
        result.append(full)
        mapper[w] = full
    return result, seen_wbans, mapper
def process_daily(data):
    df = pd.read_table(data, sep=',')
    #print(df.columns)
    #print(pd.to_numeric(df.Tmax.replace({'M': None})).mean())
    #print(pd.to_numeric(df.PrecipTotal.replace({'M': None, "  T": 0})).max())
    return df

years = range(2016, 2017)

def round_to_2(x):
    return int(round(x*100, 2))/100
def round_to_1(x):
    return int(round(x*100, 1))/100

def add_key_from_df(df, dest, *keys, mapper=lambda x:x):
    for (wban, date), v in df.iteritems():
        date = date
        index = (wban, date)
        if index not in dest:
            dest[index] = {}
        x = dest[index]
        for key in keys[:-1]:
            if key not in x:
                x[key] = {}
            x = x[key]
        x[keys[-1]] = mapper(v)
        
weather_map = {line.split(":")[0]: line.split(":")[1].strip() 
               for line in '''FG: Fog
FG+: Heavy Fog
TS: Thunder
PL: Ice Pellets
GR: Hail
GL: Glaze
DU: Dust
HZ: Haze
BLSN: Blowing Snow
FC: Tornado
WIND: Damaging Wind
BLPY: Blowing Spray
BR: Mist
DZ: Drizzle
FZDZ: Freezing Drizzle
RA: Rain
FZRA: Freezing Rain
SN: Snow
UP: Unknown
MIFG: Ground Fog
FU: Smoke
SQ: Squalls
GS: Small Hail
VA: Volcanish Ash
SH: Rain
DS: Dust Storm
FZFG: Freezing Fog'''.split("\n")}
def fix_weather_labels(code_string):
    return list(sorted(set([weather_map[code] if code in weather_map
                            else weather_map[code[-2:]]
                            for code in code_string.split()])))
## Download zip files
data= {}
station_map = {}
for year in years:
    for month in range(1, 13):
        filename = 'QCLCD{year}{month:02d}.zip'.format(year=year, month=month)
        path = 'raw/'+filename
        if not os.path.exists(path):
            url = 'https://www.ncdc.noaa.gov/orders/qclcd/'+filename
            print(url)
            urllib.request.urlretrieve(url, path)
        with zipfile.ZipFile(path) as qlcd_zip:
            files = qlcd_zip.namelist()
            print(files)
            with qlcd_zip.open(get_file(files, 'station')) as station_file:
                stations, codes, sm = process_station(station_file)
            with qlcd_zip.open(get_file(files, 'daily')) as station_file:
                daily = process_daily(station_file)
            station_map.update(sm)
            missing_values = {"M": None, '  T': 0, '-': -1, 'err': None}
            daily['YMD'] = pd.to_datetime(daily['YearMonthDay'], format='%Y%m%d')
            daily['Tmax'] = pd.to_numeric(daily['Tmax'].replace(missing_values))
            daily['Tmin'] = pd.to_numeric(daily['Tmin'].replace(missing_values))
            daily['Tavg'] = pd.to_numeric(daily['Tavg'].replace(missing_values))
            daily['StnPressure'] = pd.to_numeric(daily['StnPressure'].replace(missing_values))
            daily['PrecipTotal'] = pd.to_numeric(daily['PrecipTotal'].replace(missing_values))
            daily['ResultSpeed'] = pd.to_numeric(daily['ResultSpeed'].replace(missing_values))
            daily['ResultDir'] = pd.to_numeric(daily['ResultDir'].replace(missing_values))
            wbans = daily[daily.WBAN.isin(codes)].groupby('WBAN')
            datas = {}
            group_mean = lambda w, key: w.apply(lambda d: d.set_index('YMD').resample("W")[key].mean()).stack()
            group_sum = lambda w, key: w.apply(lambda d: d.set_index('YMD').resample("W")[key].sum()).stack()
            
            add_key_from_df(group_mean(wbans, 'Tmax'), data, 'Data', 'Temperature', 'Maximum', mapper=int)
            add_key_from_df(group_mean(wbans, 'Tmin'), data, 'Data', 'Temperature', 'Minimum', mapper=int)
            add_key_from_df(group_mean(wbans, 'Tavg'), data, 'Data', 'Temperature', 'Average', mapper=int)
            # Other viable values:
            #   Depart: Departure from normal 
            #   Sunrise
            #   Sunset
            # Precipitation
            add_key_from_df(group_sum(wbans, 'PrecipTotal'), data, 'Data', 'Precipitation', mapper=round_to_2)
            # Pressure
            #add_key_from_df(group_mean(wbans, 'StnPressure'), data, 'Data', 'Pressure', mapper=round_to_2)
            # Wind
            add_key_from_df(group_mean(wbans, 'ResultSpeed'), data, 'Data', 'Wind', 'Speed', mapper=round_to_1)
            add_key_from_df(group_mean(wbans, 'ResultDir'), data, 'Data', 'Wind', 'Direction', mapper=int)
            # CodeSum
            #codesums = wbans.apply(lambda d: d.set_index('YMD').resample("W")['CodeSum'].apply(lambda x: x.str.cat(sep=' '))).stack()
            #add_key_from_df(codesums, data, 'Conditions', mapper=fix_weather_labels)
            #print(codesums)
    break
def ensure_value(dictionary, value, *path):
    for key in path[:-1]:
        if key not in dictionary:
            dictionary[key] = {}
        dictionary = dictionary[key]
    if path[-1] not in dictionary:
        dictionary[path[-1]] = value
kill_list = []
for (wban, date), values in data.items():
    if wban not in station_map:
        kill_list.append((wban, date))
        continue
    values['Station'] = station_map[wban]
    ensure_value(values, 0.0, 'Data', 'Precipitation')
    ensure_value(values, 60, 'Data', 'Temperature', 'Minimum')
    ensure_value(values, 60, 'Data', 'Temperature', 'Maximum')
    ensure_value(values, 60, 'Data', 'Temperature', 'Average')
    #ensure_value(values, 30.0, 'Data', 'Pressure')
    ensure_value(values, 0.0, 'Data', 'Wind', 'Speed')
    ensure_value(values, 0, 'Data', 'Wind', 'Direction')
    #ensure_value(values, [], 'Conditions')
    values['Date'] = {
        'Week of': date.day, 'Month': date.month, 'Year': date.year,
        'Full': date.strftime('%Y-%m-%d')
    }
pprint(list(set([w for w, d in kill_list])))
while kill_list:
    del data[kill_list.pop()]
# Copy over roanoke into blacksburg
values = list(data.values())
for value in values:
    if value['Station']['State'] == 'Virginia' and value['Station']['City'] == 'Roanoke':
        clone = {**value}
        clone['Station'] = {
            'City': 'Blacksburg', 'Code': 'BCB',
            'Location': 'Blacksburg, VA', 'State': 'VA'
        }
        values.append(clone)
    if value['Station']['State'] == 'Delaware' and value['Station']['City'] == 'Wilmington':
        clone = {**value}
        clone['Station'] = {
            'City': 'Newark', 'Code': 'NWK',
            'Location': 'Newark, DE', 'State': 'DE'
        }
        values.append(clone)

        
#pprint(list(data.values()))
def sorter(row):
    if isinstance(row['Station']['City'], float):
        pprint(row)
    if isinstance(row['Station']['State'], float):
        pprint(row)
    return row['Date']['Full'], row['Station']['State'], row['Station']['City']
with open('weather.json', 'w') as out:
    json.dump(sorted(values, key=sorter), out)
    
{'Data': {'Precipitation': 0.19,
          'Temperature': {'Avg Temp': 34.0, 'Max Temp': 40.0, 'Min Temp': 27.0},
          'Wind': {'Avg Wind': 8.0, 'High Gust': 31.0, 'High Wind': 22.0}},
 'Date': {'Day': 10, 'Full': '04-10-2016', 'Month': 4, 'Year': 2016},
 'Station': {'City': 'Mount Holly/Philadelphia',
             'Code': 'ABE',
             'Location': 'Mount Holly/Philadelphia, NJ',
             'State': 'New Jersey'},
 'Weather Conditions': ['RAIN', 'SNOW', 'FOG']}
 
#6119 with all
#5806 without pressure
#5020 without conditions