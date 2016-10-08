import json


with open('medalofhonor-old.json') as input:
    data = json.load(input)
    
months = {
    'January': 1,
    'February': 2,
    'March': 3,
    'April': 4,
    'May': 5,
    'June': 6,
    'July': 7,
    'August': 8,
    'September': 9,
    'October': 10,
    'November': 11,
    'December': 12,
}
    
def force_int(num):
    try:
        return int(num)
    except TypeError:
        return -1
    except ValueError:
        return -1
        
def parse_locdate(record):
    if ',' in record['Place / Date']:
        try:
            year, month, day = record['Place / Date'].rsplit(",", 1)[1].strip().split(" ")
            year, day = int(year), int(day)
            month = months[month]
            return [year, month, day]
        except KeyError:
            return [int(record['Place / Date'][-4:]), -1, -1]
        except (IndexError, ValueError) as e:
            return [-1, -1, -1]
    else:
        return [-1, -1, -1]
        
def parse_birth(record):
    if ',' in record['Born']:
        date, location = record['Born'].split(",", 1)
        try:
            year, month, day =  date.split(" ")
            year, day = int(year), int(day)
            month = months[month]
            return [year, month, day, location]
        except:
            return [-1, -1, -1, record['Born']]
    else:
        try:
            return [-1, -1, int(record['Born']), ""]
        except ValueError:
            return [-1, -1, -1, record['Born']]
        
from pprint import pprint
[parse_locdate(record) for record in data]
    
new_data = [
    {
        'name': record['name'].title(),
        'death': record['Departed'] == 'Yes',
        'awarded': {
            'date': {
                'year': parse_locdate(record)[2],
                'month': parse_locdate(record)[1],
                'day': parse_locdate(record)[0],
                'full': '{}-{}-{}'.format(parse_locdate(record)[2], parse_locdate(record)[1], parse_locdate(record)[0])
            },
            'location': {
                'latitude': force_int(record['location'].get('latitude', 0)),
                'longitude': force_int(record['location'].get('longitude', 0)),
                'name': record['location'].get('name', 'Unknown'),
            },
            'General Order number': force_int(record['G.O. Number']),
            'citation': record['citation'],
            'issued': record['Date of Issue'],
            'accredited to': record['Accredited To']
        },
        'birth': {
            'date': {
                'year': parse_birth(record)[2],
                'month': parse_birth(record)[1],
                'day': parse_birth(record)[0],
            },
            'location name': parse_birth(record)[3]
        },
        'military record': {
            'rank': record['Rank'],
            'division': record['Division'],
            'organization': record['Organization'],
            'company': record['Company'],
            'entered service at': record['Entered Service At']
        },
        'metadata': {
            'link': record['link']
        }
    } for record in data]
new_data = list(sorted(new_data, key=lambda r: r['awarded']['issued']))
    
with open('medal_of_honor.json', 'w') as output:
    json.dump(new_data, output)
