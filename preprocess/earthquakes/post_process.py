import json
from pprint import pprint


with open('earthquakes_old.json') as original_file:
    earthquakes_data = json.load(original_file)

earthquakes_data = [row for row in reversed(earthquakes_data)]

with open('earthquakes.json','w') as new_file:
    json.dump(earthquakes_data, new_file)
