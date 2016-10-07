import json
from pprint import pprint

with open('cancer_old.json') as original_file:
    cancer_data = json.load(original_file)
    
seen = set()
def parse_int(astr):
    seen.add(astr)
    try:
        return int(astr)
    except ValueError:
        return 2009
    
for row in cancer_data:
    row['Year'] = parse_int(row['Year'])

with open('cancer.json','w') as new_file:
    json.dump(cancer_data, new_file)

pprint(list(sorted(seen)))