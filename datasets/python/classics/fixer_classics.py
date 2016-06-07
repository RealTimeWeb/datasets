# Adjusts the Classics dataset to change the book field to bibiliography
# 5-18-16

import json
from pprint import pprint

with open('classics.json') as data_file:
    classics_data = json.load(data_file)
    
# pprint(classics_data[0])

# Need access to original dataset.  Just need to change one word in the original
    # process_classics.py file