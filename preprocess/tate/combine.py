'''
Requires:
    artist_data.csv
        https://github.com/tategallery/collection/blob/master/artist_data.csv
    artwork_data.csv
        https://github.com/tategallery/collection/blob/master/artwork_data.csv
Generates:
    tate.json
'''


from pprint import pprint
import json
from collections import defaultdict, Counter
import re
import csv
non_decimal = re.compile(r'[^\d.]+')
import unidecode

def _clean(input): return unidecode.unidecode(input)

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
with open("artwork_data.csv") as csv_file:
    csv_file = csv.reader(csv_file, delimiter=',')
    headers = next(csv_file, None) # Skip headers
    for line in csv_file:
        (id,accession_number,artist,artistRole,artistId,title,dateText,medium,creditLine,year,acquisitionYear,dimensions, width,height,depth,units,inscription,thumbnailCopyright,thumbnailUrl,url) = line
        if artistId not in artists:
            skipped += 1
            continue
        aid,aname,agender,adates,ayearOfBirth,ayearOfDeath,aplaceOfBirth,aplaceOfDeath,aurl = artists[artistId]
        data[artist] = {
            'artist': {
                'name': artist,
                'role': artistRole,
                'gender': agender,
                'birth': {
                    'year': _parse_type(ayearOfBirth, int),
                    'location': aplaceOfBirth
                },
                'death': {
                    'year': _parse_type(ayearOfDeath, int),
                    'location': aplaceOfDeath
                }
                #'id': artistId
            },
            'metadata': {
                #'date': '' if "date not known" == dateText else dateText,
                'credit': creditLine,
                'creation year': _parse_type(year, int),
                'acquisition date': _parse_type(acquisitionYear, int)
                #'id': id,
                #'accession number': accession_number,
            },
            'data': {
                'title': title,
                'medium': medium,
                'url': url,
                'thumbnail': thumbnailUrl
            },
            'dimensions': {
                'width': _parse_type(width, float),
                'height': _parse_type(height, float),
                'depth': _parse_type(depth, float),
                'units': units
            }
        }
print "Skipped", skipped
data = [v for k, v in sorted(data.items())]
pprint(data[0])
json.dump(data, open("tate.json", "w"))