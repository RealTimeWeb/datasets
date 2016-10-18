'''
http://scdb.wustl.edu/data.php
'''


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

def rebuild_date(day, month, year):
    return '{month}/{day}/{year}'.format(month=month, day=day, year=year)

previous = None
def parse_date(a_date):
    global previous
    if a_date.strip():
        month, day, year = map(int, a_date.split("/"))
        previous= {
            'month': month,
            'day': day,
            'year': year,
            'full': a_date
        }
        return previous
    else:
        return previous
        
decision_types = {
    '1': 'court opinion',
    '2': 'per curiam',
    '4': 'decrees',
    '5': 'equally divided vote',
    '6': 'oral per curiam',
    '7': 'court judgement',
    '8': 'seriatim'
}

unconstitutional = {
    '1': 'no unconstitutionality',
    '2': 'act of congress',
    '3': 'state/territorial',
    '4': 'municipal/local'
}

months = {
    'January': 1,
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
    'December': 12,
}

directions = {
    '1': 'conservative',
    '2': 'liberal',
    '3': 'unspecifiable',
    '': 'unknown'
}

winning_party = {
    '0': 'no favorable disposition for petitioning party',
    '1': 'favorable disposition for petitioning party',
    '2': 'unclear'
}


def clean(a_string):
    return ' '.join(str(unicodedata.normalize("NFKD", a_string.strip()).encode('ascii', 'ignore')).strip().split())

with csvx.OrderedDictReader('raw.csv') as csv_in:
    rows = list(csv_in)
    
def get_lookup(filename):
    with csvx.OrderedDictReader(filename) as csv_in:
        result = {item['id']: dict(item) for item in csv_in}
        for value in result.values():
            value['id'] = int(value['id'])
        return result
        
jurisdiction = get_lookup('jurisdiction.csv')
entities = get_lookup('respondent.csv')
admin_actions = get_lookup('agency.csv')
origins = get_lookup('origins.csv')
reasons = get_lookup('reasons.csv')
dispositions = get_lookup('dispositions.csv')
authority = get_lookup('authority.csv')
case_disposition = get_lookup('case_disposition.csv')
issues = get_lookup('issues.csv')
types = get_lookup('types.csv')
issue_area = get_lookup('issue_area.csv')
majority_opinion = get_lookup('majority_opinion.csv')
states = {k: v['name'] for k,v in get_lookup('states.csv').items()}


with csvx.OrderedDictReader('natural_courts.tsv') as csv_in:
    natural_courts = {item['id']: dict(item) for item in csv_in}
    for value in natural_courts.values():
        value['period'] = int(value['period'])
        value['id'] = int(value['id'])
        value['end'] = {
            'full': rebuild_date(value['end-day'], value['end-month'], value['end-year']),
            'day': int(value.pop('end-day')),
            'month': months[value.pop('end-month')],
            'year': int(value.pop('end-year')),
        }
        value['start'] = {
            'full': rebuild_date(value['start-day'], value['start-month'], value['start-year']),
            'day': int(value.pop('start-day')),
            'month': months[value.pop('start-month')],
            'year': int(value.pop('start-year'))
        }
    
def force_int(num, val=-1):
    try:
        return int(num)
    except ValueError:
        return val

records = []
for row in tqdm(rows):
    record = {
        "id": {
            "case": row['caseId'],
            "docket": row['docketId'],
            "case issues": row['caseIssuesId'],
            "vote": row['voteId'],
        },
        "citation": {
            'us': row["usCite"],
            'sct': row["sctCite"],
            'led': row["ledCite"],
            'lexis': row["lexisCite"]
        },
        "arguments": {
            "date argued": parse_date(row["dateArgument"]),
            "date reargued": parse_date(row["dateRearg"]),
            "petitioner": dict(entities[row['petitioner']]),
            "respondent": dict(entities[row['respondent']])
        },
        "name": row["caseName"],
        "docket": force_int(filter(lambda x: x.isdigit(), row["docket"])),
        "natural court": natural_courts[row['naturalCourt']],
        "3 judge dc?": row['threeJudgeFdc'] == "1",
        
        "lower court": {
            "disagreement?": row['lcDisagreement'] == "1",
            "disposition": dispositions.get(row["lcDisposition"],  {'disposition': 'unknown', 'id': -1})['disposition'],
            "direction": directions.get(row["lcDispositionDirection"], 'unknown'),
            "reasons": reasons.get(row["certReason"], {'id': -1, 'reason': 'unknown'})["reason"],
        },
        
        "decision": {
            'admin action': admin_actions.get(row.get('adminAction', -1), {'id': -1, 'agency': 'unknown'}),
            "date": parse_date(row["dateDecision"]),
            'term': force_int(row['term']),
            "type": decision_types[row['decisionType']],
            'unconstitutional': unconstitutional[row['declarationUncon']],
            'jurisdiction': jurisdiction[row['jurisdiction']]['manner'],
            "case": {
                "disposition": case_disposition.get(row["caseDisposition"], {'disposition': 'unknown', 'id': -1})['disposition'],
                "unusual": row["caseDispositionUnusual"] == "1"
            },
            'direction': directions[row['decisionDirection']],
            'dissent agrees': row["decisionDirectionDissent"] == "1",
            "winning party": winning_party[row['partyWinning']],
            "precedent altered?": row["precedentAlteration"] == "1",
            "authority 1": authority.get(row["authorityDecision1"], {'authority': '', 'id': -1})['authority'],
            "authority 2": authority.get(row["authorityDecision2"], {'authority': '', 'id': -1})['authority'],
        },
        'laws': types.get(row["lawType"], {'id': -1, 'type': "unknown"}),
        "issue": issues.get(row['issue'], {"id": -1, "text": "unknown"}),
        "voting": {
            "unclear": row["voteUnclear"] == "1",
            "split on second": row["splitVote"] == "2",
            "majority writer": majority_opinion.get(row["majOpinWriter"], {'id': -1, 'long name': 'unknown', 'name': 'unknown'}),
            "majority assigner": majority_opinion.get(row["majOpinAssigner"], {'id': -1, 'long name': 'unknown', 'name': 'unknown'}),
            "majority": force_int(row["majVotes"], 0),
            "minority": force_int(row["minVotes"], 0)
        },
        "origin": origins.get(row["caseOrigin"], {"id": -1, "name": "unknown"}),
        "source": origins.get(row["caseSource"], {"id": -1, "name": "unknown"})
    }
    record['arguments']['petitioner']["state"]= states.get(row['petitionerState'], "")
    record['arguments']['respondent']["state"]= states.get(row['respondentState'], "")
    record['decision']['admin action']["state"]= states.get(row['adminActionState'], "")
    record['origin']["state"]= states.get(row['caseOriginState'], "")
    record['source']["state"]= states.get(row['caseSourceState'], "")
    record['issue']['area'] = issue_area.get(row['issueArea'], {"area": "unknown"})["area"]
    records.append(record)


with open('supreme_court.json', 'w') as output:
    json.dump(records, output)