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
        
uniques = set()
    
for row in cancer_data:
    row['Year'] = parse_int(row['Year'])
    d = row['Data']
    uniques.add((row['Year'], d['Event Type'], d['Race'], d['Sex']))

with open('cancer.json','w') as new_file:
    json.dump(cancer_data, new_file)

pprint(cancer_data[0])
print(len(cancer_data))

pprint(uniques)