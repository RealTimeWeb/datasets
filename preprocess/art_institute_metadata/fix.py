import os
import sys
import json
from pprint import pprint
from collections import Counter
import re

"""
[{'Artist Info': {'Artist': 'str',
                  'Continent': 'str',
                  'Country': 'str',
                  'Nationality': 'str',
                  'Years Living': 'str'},
  'Description': {'Classification': 'str',
                  'Dated': 'str',
                  'Dimension': 'str',
                  'Medium': 'str',
                  'Short Description': 'str',
                  'Signed': 'str',
                  'Style': 'str'},
  'Institute Info': {'Credit Line': 'str',
                     'Department': 'str',
                     'Inscription': 'str',
                     'Provenance': 'str',
                     'Rights Type': 'str',
                     'Room': 'str',
                     'Text': 'str'},
  'Title': 'str'}]
"""

with open('art_institute_metadata_old.json') as inp:
    data = json.load(inp)
    


uniques = Counter()
for row in data:
    
    uniques[row['Artist Info']['Years Living']] += 1
    #print()
pprint(dict(uniques.items()))
    

#with open('art_institute_metadata.json') as inp:
    #json.dump(data, inp)