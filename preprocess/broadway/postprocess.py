import json
from pprint import pprint
import wikipedia
from tqdm import tqdm

with open('broadway_old.json') as original_file:
    broadway_data = json.load(original_file)
    
def parse_int(astr):
    try:
        return int(astr)
    except ValueError:
        return 1
        
'''
{u'attendance': 6475,
 u'capital': 0.89,
 u'date': u'04/05/2015',
 u'gross': 617753,
 u'performances': 8,
 u'previews': 0,
 u'show': u"A GENTLEMAN'S GUI
 u'theatre': u'Walter Kerr'}
'''
    
ERRORS = set()
TRIED = set()
for row in tqdm(broadway_data):
    row['Date'] = {
        'Month': parse_int(row['date'][:2]),
        'Day': parse_int(row['date'][3:5]),
        'Year': parse_int(row['date'][6:]),
        'Full': row['date']
    }
    row['Statistics'] = {
        'Attendance': row['attendance'],
        'Capital': row['capital'],
        'Gross': row['gross'],
        'Performances': row['performances'],
        'Previews': row['previews']
    }
    row['Show'] = row['show']
    row['Theatre'] = row['theatre']
    for original_key in ['attendance', 'capital', 'gross', 'performances', 'previews', 'show', 'theatre']:
        del row[original_key]
    if row['Show'] not in TRIED:
        TRIED.add(row['Show'])
        try:
            wikipedia.page(row['Show'])
        except wikipedia.exceptions.PageError:
            ERRORS.add(row['Show'])
        except wikipedia.exceptions.DisambiguationError:
            ERRORS.add(row['Show'])
pprint(ERRORS)

with open('broadway.json','w') as new_file:
    json.dump(broadway_data, new_file)
