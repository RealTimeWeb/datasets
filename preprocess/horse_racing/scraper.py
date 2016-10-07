import requests
from pprint import pprint
import bs4
import json
import time
import string

REPRESENTATIVE_DATES = ('2011-05-03', '2012-05-03', '2013-05-03', '2014-05-03')

MONTHS = {'jan': '01', 'feb': '02',
          'mar': '03', 'apr': '04',
          'may': '05', 'jun': '06',
          'jul': '07', 'aug': '08',
          'sep': '09', 'oct': '10',
          'nov': '11', 'dec': '12'}
          
def _parse_int(value, default=None):
    """
    Attempt to cast *value* into an integer, returning *default* if it fails.
    """
    if value is None:
        return default
    try:
        return int(value)
    except ValueError:
        print "Couldn't cast value to `int`."
        return default

def _parse_float(value, default=None):
    """
    Attempt to cast *value* into a float, returning *default* if it fails.
    """
    if value is None:
        return default
    try:
        return float(value)
    except ValueError:
        print "Couldn't cast value to `float`."
        return default
          
def get_page(url):
    response = requests.get(url).content
    return bs4.BeautifulSoup(response)
    
def dedollar(value):
    if not value:
        return None
    try:
        return float(value[1:])
    except ValueError:
        print value
        raise

RACE_DATA = {}
for DATE in REPRESENTATIVE_DATES:
    # We gotta get all the dates
    soup = get_page("http://www.churchilldowns.com/racing-wagering/toteboard/{}/{}".format(DATE, 1))
    
    year = DATE[:4]
    this_years_dates = soup.select('.day-nav a[href^="/racing-wagering/toteboard/"]')
    this_years_dates = [a.text.split(',')[1].strip() for a in this_years_dates]
    
    for SUB_DATE in this_years_dates:
        # We gotta get all the races
        month, day = SUB_DATE.split(' ')
        month = MONTHS[month.lower()]
        day = day.zfill(2)
        RACE_DATE = '-'.join((year, month, day))
        
        # Redundant grab of first page to learn the races, could cache this but
        #   who cares, dev time is expensive compared to GET requests :)
        soup = get_page("http://www.churchilldowns.com/racing-wagering/toteboard/{}/{}".format(RACE_DATE, 1))
        total_pages = len(soup.select('.race-nav a[href^="/racing-wagering/toteboard/"]'))
        
        RACE_DATA[RACE_DATE] = {}
        for RACE in xrange(1, 1+total_pages):
            # Now we can look at each race and page individually
            soup = get_page("http://www.churchilldowns.com/racing-wagering/toteboard/{}/{}".format(RACE_DATE, RACE))
            
            tables = [[td.text for td in tr.select('td')] for tr in soup.select(".result-data tr")]
            if not tables:
                print "Unable to get data for", RACE_DATE, RACE
                continue
            first, second, third = tables[1:4]
            bets = tables[5:8]
            
            extra = soup.select('.also-ran ul')
            if len(extra) >= 1:
                also_rans = [li.text.strip().split('-') for li in extra[0].select('li')]
                also_rans = map(lambda x: map(string.strip, x), also_rans)
                also_rans = filter(lambda x: len(x) == 2, also_rans)
                also_rans = [{'gate': _parse_int(g), 'name': n.replace(",", "")} for g,n in also_rans]
            else:
                also_rans = []
            if len(extra) >= 2:
                scratcheds = [li.text.strip() for li in extra[1].select('li')]
            else:
                scratcheds = []
            
            RACE_DATA[RACE_DATE][RACE] = {
                    'first': {'gate': _parse_int(first[0]), 'name': first[1], 'win': dedollar(first[2]),
                              'place': dedollar(first[3]), 'show': dedollar(first[4])},
                    'second':{'gate': _parse_int(second[0]), 'name': second[1],
                              'place': dedollar(second[3]), 'show': dedollar(second[4])},
                    'third': {'gate': _parse_int(third[0]), 'name': third[1], 'show': dedollar(third[4])},
                    'also-rans': also_rans,
                    'scratched': scratcheds,
                    'exacta': None,
                    'superfecta': None,
                    'trifecta': None,
                    'daily_double': None
                }
            for bet in bets:
                name, numbers, paid = bet
                name = name.strip().lower().replace(' ', '_')
                RACE_DATA[RACE_DATE][RACE][name] ={ 'numbers': numbers, 'paid': dedollar(paid)}
            print RACE_DATA[RACE_DATE][RACE]
            print "Loaded Race:", RACE_DATE, RACE, len(bets)
                
json.dump(RACE_DATA, open("race_data.json","w"))