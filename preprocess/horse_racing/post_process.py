import json


with open('horseracing_2.json', 'r') as processed_data:
    data = json.load(processed_data)
    
race_remaps = {
    '1': "first",
    '2': "second",
    '3': "third",
    '4': "fourth",
    '5': "fifth",
    '6': "sixth",
    '7': "seventh",
    "8": "eighth",
    "9": "ninth",
    "10": "tenth"
}

place_remaps = {
    "first": "first place",
    "second": "second place",
    "third": "third place",
}

for race in data:
    race['date'] = {
        'year': race['year'][:4],
        'month': race['year'][5:7],
        'day': race['year'][8:],
        'full': race['year']
    }
    del race['year']
    for old_key, new_key in race_remaps.items():
        if old_key in race['data']:
            race['data'][new_key] = race['data'][old_key]
            del race['data'][old_key]
            for old_place, new_place in place_remaps.items():
                race['data'][new_key][new_place] = race['data'][new_key][old_place]
                del race['data'][new_key][old_place]
            race['data'][new_key]['daily double'] = race['data'][new_key]['daily_double']
            del race['data'][new_key]['daily_double']
    race['races'] = race['data']
    del race['data']

with open('horse_racing.json', 'w') as post_data_file:
    json.dump(data, post_data_file)