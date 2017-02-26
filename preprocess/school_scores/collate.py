import sys
import csv
from collections import defaultdict
import json
import time

import geocode
geocode.connect()

categories = ('score', 'attendance', 'enrollment', 'funding')

STATE_DATA = defaultdict(dict)
for category in categories:
    filename = 'state_{}.csv'.format(category)
    with open(filename, 'r') as input:
        csv_input = csv.DictReader(input)
        for line in csv_input:
            state = line['State'].lower()
            for key, value in line.items():
                del line[key]
                line[key.lower().strip()] = value
            del line['state']
            STATE_DATA[state][category] = line
del STATE_DATA['u.s. (average)*']
del STATE_DATA['grand total']
del STATE_DATA['bureau of indian education']

for state, values in STATE_DATA.items():
    for category, values in values.items():
        for id, value in values.items():
            if value.strip().endswith('%'):
                value = value.strip()[:-1]
            if value.strip().startswith('$'):
                value = value.strip()[1:].replace(',', '')
            try:
                value = int(value)
            except ValueError:
                try:
                    value = float(value)
                except ValueError:
                    pass
            if value < 0:
                value = None
            values[id] = value
    location = geocode.code(state)
    print state, location
    STATE_DATA[state]['location'] = location
    time.sleep(2)

json.dump(STATE_DATA, open("school_data.json", "w"))