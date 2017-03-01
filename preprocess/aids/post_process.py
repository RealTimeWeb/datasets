import json
from pprint import pprint

with open('aids_old.json', 'r') as inp:
    data = json.load(inp)
    
data.sort(key = lambda r: (r['Year'], r['Country']))

with open('aids.json', 'w') as out:
    json.dump(data, out)