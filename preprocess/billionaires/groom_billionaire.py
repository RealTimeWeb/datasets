import sys
from groomer import *

def booleanate(record):
    how = record['wealth']['how']
    record['wealth']["worth in billions"] = float(record['wealth']["worth in billions"])
    how['was political'] = bool(how['was political'])
    how['was founder'] = bool(how['was founder'])
    how['inherited'] = bool(how['inherited'])
    how['from emerging'] = bool(how['from emerging'])
    record['rank'] = int(record['rank'])
    record['year'] = int(record['year'])
    try:
        record['demographics']['age'] = int(record['demographics']['age'])
    except ValueError:
        record['demographics']['age'] = 0
    try:
        record['company']['founded'] = int(record['company']['founded'])
    except ValueError:
        record['company']['founded'] = 0
    try:
        record['location']['gdp'] = float(record['location']['gdp'])
    except ValueError:
        record['location']['gdp'] = float(0)
    return record

pipeline = Pipeline()
pipeline.add_steps(
    LoadCSV('billionaires.csv', header=True),
    ToJSON('csv_map.json'),
    MapFunction(booleanate)
)
pipeline.complete().to_file('billionaires.json')