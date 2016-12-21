# Change the keys of a dataset
    # Replace "OLD KEY" in line 11 with the old key
    # Replace "NEW KEY" in line 11 with the desired key
    # Open the desired dataset in line 17
    # Write to the desired file name in line 20

import json

def change_key(obj):
    for key in obj.keys():
        new_key = key.replace("OLD KEY","NEW KEY")
        if new_key != key:
            obj[new_key] = obj[key]
            del obj[key]
    return obj
    
with open('OLD_FILE.json') as data_file:
    data = json.load(data_file, object_hook=change_key)
    
with open('NEW_FILE.json', mode='w') as data_file:
    json.dump(data, data_file)