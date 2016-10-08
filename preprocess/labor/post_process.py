import json
from pprint import pprint

with open('labor_old.json') as original_file:
    labor_data = json.load(original_file)
    
seen = set()
def parse_int(astr):
    seen.add(astr)
    try:
        return int(astr)
    except ValueError:
        return 2009
    
for row in labor_data:
    row['Year'] = parse_int(row['Year'])

with open('labor.json','w') as new_file:
    json.dump(labor_data, new_file)

pprint(list(sorted(seen)))