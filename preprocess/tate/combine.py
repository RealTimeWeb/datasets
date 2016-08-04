from pprint import pprint
import json
from collections import defaultdict, Counter
import string
import re
import csv
non_decimal = re.compile(r'[^\d.]+')
import unidecode
import unicodedata

role_map = {'artist': 'artist', 
            'after': 'manner of', 
            'attributed to': 'attributed to', 
            'manner of': 'manner of', 
            'pupil of': 'manner of', 
            'formerly attributed to': 'manner of', 
            'and other artists': 'manner of', 
            'prints after': 'manner of', 
            'pseudo': 'manner of', 
            'studio of': 'manner of', 
            'imitator of': 'manner of', 
            'school of': 'manner of', 
            'and a pupil': 'manner of', 
            'and assistants': 'manner of', 
            'follower of': 'manner of', 
            'and studio': 'manner of', 
            'circle of': 'manner of', 
            'doubtfully attributed to': 'manner of', 
            'style of': 'manner of'}

def _clean(a_string):
    return unicodedata.normalize("NFKD", a_string.decode('ascii', 'ignore')).encode('ascii', 'ignore')
    #return str(unicodedata.normalize("NFKD", a_string.strip()).encode('ascii', 'ignore'))

def _parse_type(value, type_func):
    """
    Attempt to cast *value* into *type_func*, returning *default* if it fails.
    """
    default = type_func(0)
    if value is None:
        return default
    try:
        return type_func(value)
    except ValueError:
        return default

artists = {}
with open("artist_data.csv") as csv_file:
    csv_file = csv.reader(csv_file, delimiter=',')
    headers = next(csv_file, None) # Skip headers
    for line in csv_file:
        aid,aname,agender,adates,ayearOfBirth,ayearOfDeath,aplaceOfBirth,aplaceOfDeath,aurl = line
        artists[aid] = line

data = {}
skipped = 0
exclude = set(string.punctuation)
ROLES = Counter()
with open("artwork_data.csv") as csv_file:
    csv_file = csv.reader(csv_file, delimiter=',')
    headers = next(csv_file, None) # Skip headers
    for line in csv_file:
        (id,accession_number,artist,artistRole,artistId,title,dateText,medium,creditLine,year,acquisitionYear,dimensions, width,height,depth,units,inscription,thumbnailCopyright,thumbnailUrl,url) = line
        if artistId not in artists:
            skipped += 1
            continue
        aid,aname,agender,adates,ayearOfBirth,ayearOfDeath,aplaceOfBirth,aplaceOfDeath,aurl = artists[artistId]
        
        m = ''.join(ch for ch in _clean(units) if ch not in exclude)
        for mm in m.split():
            ROLES[mm.lower()] += 1
        data[artist] = {
            'artist': {
                'name': _clean(artist),
                'role': role_map[_clean(artistRole)],
                'gender': _clean(agender),
                'birth': {
                    'year': _parse_type(ayearOfBirth, int),
                    'location': _clean(aplaceOfBirth)
                },
                'death': {
                    'year': _parse_type(ayearOfDeath, int),
                    'location': _clean(aplaceOfDeath)
                }
                #'id': artistId
            },
            'metadata': {
                #'date': '' if "date not known" == dateText else dateText,
                'credit': _clean(creditLine),
                'creation year': _parse_type(year, int),
                'creation decade': _parse_type(year, int) / 10 * 10,
                'acquisition date': _parse_type(acquisitionYear, int)
                #'id': id,
                #'accession number': accession_number,
            },
            'data': {
                'title': _clean(title),
                'medium': _clean(medium),
                'url': url,
                'thumbnail': thumbnailUrl
            },
            'dimensions': {
                'width': _parse_type(width, float),
                'height': _parse_type(height, float),
                'depth': _parse_type(depth, float)
            }
        }
print "Skipped", skipped
data = [v for k, v in sorted(data.items())]
pprint(data[0])
json.dump(data, open("tate.json", "w"))

with open('mediums.json', 'w') as output:
    json.dump(dict(sorted([r for r in ROLES.items() if r[1] >= 1])), output, indent=4)