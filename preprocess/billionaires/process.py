import json
import csvx
import os, sys
from tqdm import tqdm
from bs4 import BeautifulSoup
from pprint import pprint
import unicodedata
from collections import Counter
import string
import time

def parse_float(a_string):
    try:
        return float(a_string)
    except ValueError:
        return float(0)
def parse_int(a_string):
    try:
        return int(round(float(a_string)))
    except ValueError:
        return 0
def classify_inheritance(a_type):
    return {
        '0': "not inherited",
        "Fifth generation or longer": "5th generation or longer",
        "Fourth generation": "4th generation",
        "inherited from father": "father",
        "spouse or widow": "spouse/widow",
        "Third generation": "3rd generation"
    }[a_type]
        
records = []
with csvx.OrderedDictReader('billionaires.csv') as csv_in:
    rows = csv_in
    for row in tqdm(rows):
        records.append({
            "year": parse_int(row["year"]),
            "name": row["name"],
            "rank": parse_int(row["rank"]),
            "location": {
                "citizenship": row["citizenship"],
                "country code": row["countrycode"],
                "region": row["region"],
                "gdp": parse_float(row["gdpcurrentus"])
            },
            "company": {
                "sector": row["sector"],
                "name": row["company"],
                "type": row["companytype"],
                "relationship": row["relationshiptocompany"],
                "founded": parse_int(row["foundingdate"])
            },
            "wealth": {
                "worth in billions": parse_float(row["networthusbillion"]),
                "type": row["typeofwealth"],
                "how": {
                    "industry": row["industry"],
                    "category": row["IndustryAggregates"],
                    "from emerging": row["north"]=="1",
                    "was political": row["politicalconnection"]=="1",
                    "was founder": row["founder"]=="1",
                    "inherited": classify_inheritance(row["generationofinheritance"])
                }
            },
            "demographics": {
                "gender": row["gender"],
                "age": parse_int(row["age"])
            }
        })

        
records = sorted(records,
                 key= lambda r: r["rank"])

with open('billionaires.json', 'w') as output:
    json.dump(records, output)