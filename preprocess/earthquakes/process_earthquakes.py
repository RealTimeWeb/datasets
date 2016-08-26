# Walkthrough the earthquakes data and dump it into a .json file
# 6-3-16

import earthquakes
import json

earthquakes = earthquakes.get_all()

with open('earthquakes.json', mode='w') as output:
    json.dump(earthquakes, output)