import json
from pprint import pprint

STATE_LOOKUP = {
    'Alabama': "AL",
    'Alaska': "AK",
    'Arizona': "AZ",
    'Arkansas': "AR",
    'California': "CA",
    'Colorado': "CO",
    'Connecticut': "CT",
    'Delaware': "DE",
    'Florida': "FL",
    'Georgia': "GA",
    'Idaho': "ID",
    'Illinois': "IL",
    'Indiana': "IN",
    'Iowa': "IA",
    'Kansas': "KS",
    'Kentucky': "KY",
    'Louisiana': "LA",
    'Maine': "ME",
    'Massachusetts': "MD",
    'Michigan': "MI",
    'Minnesota': "MN",
    'Mississippi': "MS",
    'Missouri': "MO",
    'Montana': "MT",
    'Nebraska': "NE",
    'Nevada': "NV",
    'New Hampshire': "NH",
    'New Jersey': "NJ",
    'New Mexico': "NM",
    'New York': "NY",
    'North Carolina': "NC",
    'North Dakota': "ND",
    'Ohio': "OH",
    'Oklahoma': "OK",
    'Oregon': "OR",
    'Pennsylvania': "PA",
    'Puerto Rico': "PR",
    'South Carolina': "SC",
    'South Dakota': "SD",
    'Tennessee': "TN",
    'Texas': "TX",
    'Utah': "UT",
    'Vermont': "VT",
    'Virginia': "VA",
    'Washington': "WA",
    'West Virginia': "WV",
    'Wisconsin': "WI",
    'Wyoming': "WY"
}

with open('weather_old.json') as original_file:
    weather_data = json.load(original_file)
    
def parse_int(astr):
    try:
        return int(astr)
    except ValueError:
        return 1
    
STATES = set()
CODE_LOCATION = {}
KILL_STATIONS = set()
for row in weather_data:
    location = row['City'] + ', ' + STATE_LOOKUP.get(row["Station's State"], '??')
    if location not in CODE_LOCATION:
        CODE_LOCATION[location] = row['Station']
    if CODE_LOCATION[location] != row['Station']:
        KILL_STATIONS.add(row['Station'])
    row['Date'] = {
        'Month': parse_int(row['Date'][:2]),
        'Day': parse_int(row['Date'][3:5]),
        'Year': parse_int(row['Date'][6:]),
        'Full': row['Date']
    }
    if row["Station's State"] not in STATE_LOOKUP:
        STATES.add(row["Station's State"])
    row['Station'] = {
        'City': row['City'],
        "State": row["Station's State"],
        'Code': row['Station'],
        "Location": location
    }
    del row['City']
    del row["Station's State"]

weather_data = [row for row in reversed(weather_data) if row['Station']['Code'] not in KILL_STATIONS]

with open('weather.json','w') as new_file:
    json.dump(weather_data, new_file)
