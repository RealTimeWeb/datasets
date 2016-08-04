'''
This is a post-processing script that should be run AFTER download_book.py. It does a number of shenanigans to clean up the data created there.

requires:
    completed/
        This is a folder of all the computed metrics for the books
    raw.json

generates:
    classics-2.json

'''


import csvx
import json
import os
import sys
from urllib import quote_plus
from tqdm import tqdm
import requests
from bs4 import BeautifulSoup
import time
import isbnlib
from pprint import pprint
from gutenberg.acquire import load_etext
from gutenberg.cleanup import strip_headers
from process_rdf import readmetadata
import unicodedata

month_lookup = {
    'January': 1,
    'Jan': 1,
    'February': 2,
    'March': 3,
    'April': 4,
    'May': 5,
    'June': 6,
    'July': 7,
    'August': 8,
    'September': 9,
    'October': 10,
    'November': 11,
    'December': 12
}

lookup_dates = {
1661: 'October 14, 1892',
2600: 'January 1, 1870',
30360: 'January 1, 1888',
972: 'January 1, 1911',
1524: 'January 1, 1603',
2264: 'January 1, 1623',
2265: 'January 1, 1603',
2383: 'January 1, 1475',
1321: 'January 1, 1922',
580: 'January 1, 1837',
2267: 'January 1, 1622',
3178: 'January 1, 1873',
1129: 'January 1, 1623',
2242: 'January 1, 1600',
1120: 'January 1, 1623',
1513: 'January 1, 1597',
1: 'July 4, 1776',
1128: 'January 1, 1608',
1107: 'January 1, 1590',
2243: 'January 1, 1623',
674: 'January 1, 1517',
445: 'January 1, 1895',
1653: 'January 1, 1422',
2488: 'January 1, 1870',
2153: 'January 1, 1848',
2407: 'September 29, 1774'
}

def clean(a_string):
    return str(unicodedata.normalize("NFKD", a_string.strip()).encode('ascii', 'ignore'))

def combine_jsons():
    data = []
    filenames = os.listdir('completed/')
    for filename in tqdm(filenames):
        path = 'completed/'+filename
        with open(path) as input:
            record = json.load(input)
            data.append(record)
    data = sorted(data, key = lambda b: -b['metadata']['downloads'])
    for index, row in enumerate(data, 1):
        row['metadata']['rank'] = index
    with open('raw.json', 'w') as output:
        json.dump(data, output, indent=2)
        
#combine_jsons()

def download_isbn():
    with open('raw.json') as input:
        data = json.load(input)
    '''
    print("Loading index")
    md = readmetadata()
    for record in data:
        id = record['metadata']['id']
        metadata = md[id]
        pprint(metadata)
        sys.exit(0)
        title = record['book']['title']
        isbn = isbnlib.isbn_from_words(title)
        metadata = isbnlib.meta(isbn)
        pprint(metadata)
        extracted_title = ''
        print title, extracted_title, isbn
        time.sleep(1)'''
    url = 'http://www.librarything.com/api/thingTitle/'
    for record in data:
        title = record['book']['title']
        final_url = url+quote_plus(title)
        content = requests.get(final_url).content
        soup = BeautifulSoup(content)
        extracted_title = soup.idlist.title.string
        isbn = soup.idlist.find("isbn").string
        metadata = isbnlib.meta(isbn)
        pprint(metadata)
        #print title, extracted_title, min(isbns)
        time.sleep(1)
        
#download_isbn()

def extract_date(full):
    full = full.strip()
    if "," in full:
        month_day, year = full.split(',')
        if " " in month_day.strip():
            month, day = month_day.strip().split(" ")
        else:
            month, day = month_day, "1"
    elif full.count(" ") == 2:
        day, month, year = full.split(" ")
    elif " " in full:
        month, year = full.split(" ")
        day = "1"
    else:
        month, day = "January", "1"
        year = full
    month = month.strip()
    year = year.strip()
    day = day.strip()
    try:
        month, day, year = month, int(day), int(year)
    except ValueError:
        sys.exit(0)
    return month, day, year
        
def check_text():
    with open('raw.json') as inputfile:
        data = json.load(inputfile)
    for record in tqdm(data):
        id = record['metadata']['id']
        title = clean(record['book']['title'])
        text = load_etext(id)
        if id in lookup_dates:
            release_date = lookup_dates[id]
        else:
            for line in text.split("\n"):
                if line.startswith('Release Date:'):
                    release_date = line.replace('Release Date:', '').split('[')[0]
                    break
            else:
                print id, title
        record['book']['author'] = record['author']
        author_name = record['book']['author']['name']
        if record['book']['author']['birth'] is None:
            record['book']['author']['birth'] = 0
        if record['book']['author']['death'] is None:
            record['book']['author']['death'] = 0
        record['book']['author']['name'] = clean(author_name) if author_name else "Unknown"
        del record['author']
        month, day, year = extract_date(release_date)
        release_date = release_date.strip()
        record['book']['publication'] = {
            'full': release_date  if month != 'Jan' else release_date.replace('Jan', 'January'),
            'year': year,
            'month name': month if month != 'Jan' else 'January',
            'month': month_lookup[month],
            'day': day
        }
        record['bibliography'] = record['book']
        del record['book']
        record['metrics'] = record['statistics']
        del record['statistics']
    with open('classics-2.json', 'w') as output:
        json.dump(data, output, indent=2)
       
check_text()