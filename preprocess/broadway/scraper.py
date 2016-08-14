# -*- coding: utf-8 -*-
"""
Created on Tue Apr 07 21:20:15 2015

@author: acbart
"""

from bs4 import BeautifulSoup
import requests
import json

def clean_number(a_val):
    return int(a_val.replace(',', '').replace('$', '').replace('%', ''))

def force_number(a_val):
    try:
        return int(a_val)
    except (ValueError) as e:
        try:
            return float(a_val)
        except ValueError as e:
            return str(a_val.encode('utf-8'))

url = 'http://www.broadwayleague.com/index.php?url_identifier=nyc-grosses-11&page-no={0}'
headers = ["date", "show", "theatre", "previews", "performances", "gross", "attendance", "capital"]
result = []
for page in xrange(1, 818):
    page_content = requests.get(url.format(page)).content
    soup = BeautifulSoup(page_content)
    db_table = soup.find('table', attrs={'id': 'database'})
    for row in db_table.find_all('tr')[1:]:
        row = [val.text.strip() for val in row.find_all('td')]
        date, show, theatre, previews, performances, gross, attendance, capital, more = row
        print date
        previews = clean_number(previews)
        performances = clean_number(performances)
        gross = clean_number(gross)
        attendance = clean_number(attendance)
        capital = clean_number(capital)/100.0
        row = date, show, theatre, previews, performances, gross, attendance, capital
        result.append(dict(zip(headers, row)))
    print page, page/818.0
json.dump(result, open('broadway2.json', 'w'))