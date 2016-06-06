# Walkthrough the suicide attacks data
# 5-18-16

import json
from pprint import pprint

with open('suicide_attacks.json') as data_file:
    suicideattacks_data = json.load(data_file)

pprint(suicideattacks_data[0])