import json
from pprint import pprint
from collections import defaultdict, Counter

with open('music_old.json') as original_file:
    music_data = json.load(original_file)
    
class JsonTree(object):
    def __init__(self, data, parent_name):
        self.path = []
        self.name = parent_name
        self.result = defaultdict(list)
        self.walk(data, parent_name)
        
    @property
    def json_path(self):
        return ".".join([self.name]+self.path)
        
    def walk(self, chunk, parent_name):
        if isinstance(chunk, dict):
            self.walk_dict(chunk, parent_name)
        elif isinstance(chunk, list):
            self.walk_list(chunk, parent_name)
        else:
            self.walk_atomic(chunk, parent_name)
        return self
        
    def walk_dict(self, a_dict, parent_name):
        for key, value in a_dict.items():
            self.path.append(key)
            self.walk(value, key)
            self.path.pop()
    def walk_list(self, a_list, parent_name):
        self.path.append("[]")
        for value in a_list:
            self.walk(value, parent_name)
        self.path.pop()
    def walk_atomic(self, an_atomic, parent_name):
        self.result[self.json_path].append(an_atomic)
        if an_atomic is None:
            print("Found one")
    
def parse_int(astr):
    try:
        return int(astr)
    except ValueError:
        return 1
 
#JsonTree(music_data, 'top')
pprint(music_data[0])
l_types = Counter()
for song in music_data:
    if song['artist']['hotttnesss'] is None:
        song['artist']['hotttnesss'] = -1
    if song['song']['hotttnesss'] is None:
        song['song']['hotttnesss'] = -1
    if song['artist']['longitude'] is None:
        song['artist']['longitude'] = 0
    if song['artist']['latitude'] is None:
        song['artist']['latitude'] = 0
    if song['artist']['familiarity'] is None:
        song['artist']['familiarity'] = 0
    if song['artist']['similar'] is None:
        song['artist']['similar'] = 0
    l_types[type(song['artist']['latitude'])] += 1
pprint(l_types.items())
    
with open('music.json','w') as new_file:
    json.dump(music_data, new_file)
