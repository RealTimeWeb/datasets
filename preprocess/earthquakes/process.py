import earthquakes
import json
from datetime import datetime

earthquakes.connect()

reports = earthquakes.get_report('month', 'all')
new_reports = []

for quake in reports['earthquakes']:
    dt = datetime.fromtimestamp(quake['time']/1000)
    if quake['location_description'].split(',')[-1] == ' CA':
        state = 'California'
    elif quake['location_description'].split(',')[-1] == ' MX':
        state = 'Mexico'
    elif quake['location_description'].split(',')[-1] == ' NV':
        state = 'Nevada'
    else:
        state = quake['location_description'].split(',')[-1].strip()
    
    if quake['magnitude'] > 0:
        new_reports.append({
            'location': {
                'state': state,
                'full': quake['location_description'],
                'latitude': quake['location']['latitude'],
                'longitude': quake['location']['longitude'],
                'depth': quake['location']['depth'],
                'distance': quake['distance']
            },
            'id': quake['id'],
            'time': {
                'epoch': quake['time'],
                'month': dt.month,
                'day': dt.day,
                'year': dt.year,
                'hour': dt.hour,
                'minute': dt.minute,
                'second': dt.second,
                'full': dt.strftime('%Y-%m-%d %H:%M:%S')
            },
            'impact': {
                'significance': quake['significance'],
                'gap': quake['gap'],
                'magnitude': quake['magnitude']
            }
        })

with open('earthquakes.json', 'w') as output:
    json.dump(new_reports, output)