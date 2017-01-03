import json
import csvx
import os, sys
from tqdm import tqdm
from bs4 import BeautifulSoup
from pprint import pprint
import unicodedata
from collections import Counter
import string
import time


MAJOR_AIRPORTS= "ATL BWI BOS CLT MDW ORD DFW DEN DTW FLL IAH LAS LAX MIA MSP JFK LGA EWR MCO PHL PHX PDX SLC SAN SFO SEA TPA DCA IAD".split()

def clean(a_string):
    return ' '.join(str(unicodedata.normalize("NFKD", a_string.strip()).encode('ascii', 'ignore')).strip().split())
    
month_name = ["Unknown",
          "January",
          "Febuary",
          "March",
          "April",
          "May",
          "June",
          "July",
          "August",
          "September",
          "October",
          "November",
          "December"]
    
def parse_int(a_string):
    try:
        return int(round(float(a_string)))
    except ValueError:
        return -1

with csvx.OrderedDictReader('medium.csv') as csv_in:
    rows = csv_in
    
    '''
    arr_flights	307
    arr_del15	56
    carrier_ct	14.68
     weather_ct	10.79
    nas_ct	19.09
    security_ct	1.48
    late_aircraft_ct	9.96
    arr_cancelled	1
    arr_diverted	1
     arr_delay	2530
     carrier_delay	510
    weather_delay	621
    nas_delay	676
    security_delay	25
    late_aircraft_delay	698

    '''
    records = {}
    for row in tqdm(rows):
        if row['airport'] not in MAJOR_AIRPORTS: continue
        id = (int(row['year']), int(row[' month']), row['airport'])
        if id not in records:
            records[id] = {
                'Time': {
                    'Year': int(row['year']),
                    'Month': int(row[' month']),
                    'Month Name': month_name[int(row[' month'])],
                    'Label': "{}/{}".format(str(row['year']).zfill(2),
                                            str(row[' month']).zfill(2))
                },
                'Airport': {
                    'Code': row['airport'],
                    'Name': row['airport_name']
                },
                'Statistics': {                
                    'Carriers': {
                        "Total": 0,
                        "Names": []
                    },
                    'Flights': {
                        'Total': 0,
                        'Cancelled': 0,
                        'Diverted': 0,
                        'Delayed': 0,
                        'On Time': 0
                    }, 
                    '# of Delays': {
                        'Carrier': 0,
                        'Weather': 0,
                        'National Aviation System': 0,
                        'Security': 0,
                        'Late Aircraft': 0
                    },
                    'Minutes Delayed': {
                        'Carrier': 0,
                        'Weather': 0,
                        'National Aviation System': 0,
                        'Security': 0,
                        'Late Aircraft': 0,
                        'Total': 0
                    }
                }
            }
        new_data = records[id]
        new_data['Statistics']['Carriers']["Total"] += 1
        new_data['Statistics']['Carriers']["Names"].append(row['carrier_name'])
        new_data['Statistics']['Flights']["Total"] += parse_int(row['arr_flights'])
        new_data['Statistics']['Flights']["Cancelled"] += parse_int(row['arr_cancelled'])
        new_data['Statistics']['Flights']["Diverted"] += parse_int(row['arr_diverted'])
        new_data['Statistics']['Flights']["Delayed"] += parse_int(row['arr_del15'])
        new_data['Statistics']['Flights']["On Time"] += (parse_int(row['arr_flights'])
                                        - parse_int(row['arr_cancelled'])
                                        - parse_int(row['arr_diverted'])
                                        - parse_int(row['arr_del15']))
        new_data['Statistics']['# of Delays']["Carrier"] += parse_int(row['carrier_ct'])
        new_data['Statistics']['# of Delays']["Weather"] += parse_int(row[' weather_ct'])
        new_data['Statistics']['# of Delays']["National Aviation System"] += parse_int(row['nas_ct'])
        new_data['Statistics']['# of Delays']["Security"] += parse_int(row['security_ct'])
        new_data['Statistics']['# of Delays']["Late Aircraft"] += parse_int(row['late_aircraft_ct'])
        new_data['Statistics']['Minutes Delayed']["Carrier"] += parse_int(row[' carrier_delay'])
        new_data['Statistics']['Minutes Delayed']["Weather"] += parse_int(row['weather_delay'])
        new_data['Statistics']['Minutes Delayed']["National Aviation System"] += parse_int(row['nas_delay'])
        new_data['Statistics']['Minutes Delayed']["Security"] += parse_int(row['security_delay'])
        new_data['Statistics']['Minutes Delayed']["Late Aircraft"] += parse_int(row['late_aircraft_delay'])
        new_data['Statistics']['Minutes Delayed']["Total"] += parse_int(row[' arr_delay'])
    
records = sorted(records.values(),
                 key= lambda r: (r["Time"]["Label"], r["Airport"]["Code"]))

with open('airlines.json', 'w') as output:
    json.dump(records, output)