"""
Created on Tue Apr 07 21:20:15 2015

@author: acbart

generates:
    cached/
    broadway.json   

This is the actual scraper to run.
"""

from bs4 import BeautifulSoup
import requests
import json
import os
import sys
from tqdm import tqdm

def parse_int(astr):
    try:
        return int(astr)
    except ValueError:
        return 1

def clean_number(a_val):
    a_val = a_val.replace(',', '').replace('$', '').replace('%', '')
    if a_val == "":
        return 0
    else:
        return int(a_val)

def force_number(a_val):
    try:
        return int(a_val)
    except (ValueError) as e:
        try:
            return float(a_val)
        except ValueError as e:
            return str(a_val.encode('utf-8'))

url = 'https://www.broadwayleague.com/research/grosses-broadway-nyc/'
top_row = ["Week End", "Show", "Type", "Theatre", "# Prev", "# Perf", "Grosses", "Ignore", "GG%GP", "Attend", "Ignore", "% Cap"]
headers = {'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36', 'referer': 'https://www.broadwayleague.com/research/grosses-broadway-nyc/'}

cached = os.listdir('cached')

cookie = {'csrftoken' : 'AtFKULfpqNcBNj39CoTD5nbYDNaDivgr'}

result = []
caps = []
skipped = 0
first_year = None
for year in tqdm(xrange(1984, 2017)):
    filename = '{year}.html'.format(year=year)
    full_path = os.path.join('cached', filename)
    if filename in cached:
        with open(full_path) as cached_file:
            page_content = cached_file.read()
    else:
        page_content = requests.post(url, data={
            'start_week_date': '01/01/{year}'.format(year=year),
            'end_week_date': '12/31/{year}'.format(year=year),
            'show': '',
            'category': '',
            'theatre': '',
            'csrfmiddlewaretoken': 'AtFKULfpqNcBNj39CoTD5nbYDNaDivgr'
        }, headers=headers, cookies=cookie).content
        with open(full_path, 'w') as cached_file:
            cached_file.write(page_content)
    
    soup = BeautifulSoup(page_content, 'html.parser')
    db_table = soup.find('table', attrs={'class': 'shows'})
    rows = list(db_table.tbody.find_all('tr', recursive=False))
    for row in rows[1:]:
        row = [val.text.strip() for val in row.findAll('td', recursive=False)]
        data = dict(zip(top_row, row))
        if clean_number(data['% Cap']) == 0:
            skipped += 1
            continue
        elif first_year is None:
            first_year = data['Week End']
        result.append({
            'Date': {
                'Month': clean_number(data['Week End'][:2]),
                'Day': clean_number(data['Week End'][3:5]),
                'Year': clean_number(data['Week End'][6:]),
                'Full': data['Week End']
            },
            'Show': {
                'Name': data['Show'].title(),
                'Type': data['Type'],
                'Theatre': data['Theatre']
            },
            'Statistics': {
                'Performances': clean_number(data['# Perf']),
                'Gross': clean_number(data['Grosses']),
                'Gross Potential': clean_number(data['GG%GP']),
                'Attendance': clean_number(data['Attend']),
                'Capacity': clean_number(data['% Cap']),
            }
        })
        '''
          <td>0</td>
          <td>8</td>
          <td>$449,815</td>
          <td class="inactive">$247,958</td>
          <td>0%</td>
          <td>12,885</td>
          <td class="inactive">7,718</td>
          <td>0%</td>
        ["# Prev", "# Perf", "Grosses", "Ignore", "GG%GP", "Attend", "Ignore", "% Cap"]
        date, show, theatre, previews, performances, gross, attendance, capital, more = row
        previews = clean_number(previews)
        performances = clean_number(performances)
        gross = clean_number(gross)
        attendance = clean_number(attendance)
        capital = clean_number(capital)/100.0
        row = date, show, theatre, previews, performances, gross, attendance, capital
        result.append(dict(zip(headers, row)))
        '''
result = list(sorted(result, key=lambda r: (r['Date']['Year'], r['Date']['Month'], r['Date']['Day'], r['Show']['Name'])))
json.dump(result, open('broadway.json', 'w'))


'''
start_week_date:08/12/1984
end_week_date:08/09/1987
show:
category:
theatre:
csrfmiddlewaretoken:AtFKULfpqNcBNj39CoTD5nbYDNaDivgr
'''