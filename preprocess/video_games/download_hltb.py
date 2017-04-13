'''
    Download CSV file at https://researchportal.port.ac.uk/portal/en/datasets/video-games-dataset(d4fe28cd-1e44-4d2f-9db6-85b347bf761e).html
    
    Rename to "games.csv"
'''

import requests
import requests_cache
import pandas as pd
import bs4
import json
from difflib import SequenceMatcher
from unidecode import unidecode
from pprint import pprint
from tqdm import tqdm

requests_cache.install_cache('hltb.db', allowable_methods=('GET', 'POST'))

manual_corrections = {
    "Lumines: Puzzle Fusion": "Lumines",
    "Metal Gear Ac!d": "Metal Gear Acid",
    'Metal Gear Ac!d 2': 'Metal Gear Acid 2',
    "Mr. DRILLER: Drill Spirits": "Mr. Driller Drill Spirits",
    "Armored Core Formula Front - Extreme Battle": "Armored Core: Formula Front Extreme Battle",
    "Brain Age\xfd: More Training in Minutes a Day!": "Brain Age 2: More Training in Minutes a Day!",
    "SOCOM U.S. Navy SEALs - Fireteam Bravo": "SOCOM: U.S. Navy SEALs Fireteam Bravo",
    "Peter Jackson's King Kong: The Official Game of...": "Peter Jackson's King Kong",
    "Star Wars: Episode III - Revenge of the Sith": "Star Wars Episode III Revenge of the Sith",
    'The Chronicles of Narnia: The Lion, the Witch a...': 'The Chronicles of Narnia: The Lion, the Witch and the Wardrobe',
    'Mega Man Battle Network 5: Double Team DS': 'Mega Man Battle Network 5',
    'Viva Pi\xa4ata': 'Viva Pinata',
    'F.E.A.R.: First Encounter Assault Recon': 'FEAR',
    'The Lord of the Rings: The Battle for Middle Ea...': 'The Lord of the Rings: The Battle for Middle-earth',
    'Final Fantasy XI Online': 'Final Fantasy XI',
    'Project Sylpheed: Arc of Deception': 'Project Sylpheed',
    '007: From Russia with Love': 'From Russia with Love',
    "Ultimate Ghosts 'N' Goblins": "Ultimate Ghosts 'n Goblins",
    'Mega Man Star Force 2: Zerker X Ninja': 'Mega Man Star Force 2',
    'Pok\x82mon: Platinum Version': 'Pokemon Platinum',
    'Guilty Gear XX ? Core': 'Guilty Gear XX Accent Core',
    'Lara Croft Tomb Raider: Legend': 'Tomb raider legend',
    'Ben 10: Protector of the Earth': 'Ben 10: Protector of Earth',
    'Mega Man Star Force: Dragon': 'Mega Man Star Force',
    'Unreal Tournament III': 'Unreal Tournament 3',
    "Disney Pirates of the Caribbean: At World's End": "Pirates of the Caribbean: At World's End",
    'Silent Hill: 0rigins': 'Silent Hill: Origins',
    'BWii: Battalion Wars 2': 'Battalion Wars 2',
    'Godzilla Unleashed: Double Smash': 'Godzilla Unleashed',
    '?kami': 'Okami',
    'Jak & Daxter: The Lost Frontier': 'Jak and Daxter: The Lost Frontier',
    'Watchmen: The End is Nigh: Parts 1 and 2': 'Watchmen: The End Is Nigh - Complete'
}
skip_list = {
    'Ping Pals', 'Namco Museum Battle Collection',
    'NBA Street Showdown', 'Midway Arcade Treasures: Extended Play',
    'World Championship Poker 2 featuring Howard Led...',
    'FIFA Soccer 06', 'FIFA Soccer 07',
    'FIFA World Cup: Germany 2006',
    'World Tour Soccer', 'Snood 2: On Vacation',
    'Frantix', 'The Hustle: Detroit Streets',
    'Smart Bomb', 'Elf Bowling 1&2',
    'Rainbow Islands Revolution', 'Kao Challengers', 'Disney/Pixar Cars',
    'MX vs. ATV: On the Edge', 'GT Pro Series',
    'Brain Boost: Beta Wave',
    'Brain Boost: Gamma Wave',
    'World Series of Poker: Tournament of Champions',
    'Tamagotchi Connexion: Corner Shop',
    'FIFA World Cup: Germany 2006',
    'NBA Ballers: Rebound',
    'World Series of Poker: Tournament of Champions',
    "Charlotte's Web",
    'Finding Nemo: Escape to the Big Blue',
    'MLB', 
    'Trace Memory',
    'NBA',
    'Freedom Wings',
    'Dawn of Discovery'
}

def parse_time(a_time):
    if a_time.strip() == '--':
        return 0
    if '-' in a_time:
        first, second = a_time.split('-')
        first, second = parse_time(first), parse_time(second)
        return (first+second)/2
    a_time = a_time.replace('\xbd', '.5')
    if 'Mins' in a_time:
        a_time = a_time.replace('Mins', '')
        a_time = float(a_time.strip())/60
        return a_time
    elif 'Hours' in a_time:
        a_time = a_time.replace('Hours', '')
        a_time = float(a_time.strip())
        return a_time
    else:
        raise Exception(a_time)
def parse_hm(a_time):
    a_time = a_time.strip()
    if a_time == '--':
        return 0.0
    elif ' ' in a_time:
        hh, mm = a_time.split(' ')
        hh, mm = hh[:-1], mm[:-1]
        return float(hh) + float(mm)/60
    elif 'h' in a_time:
        return float(a_time[:-1])
    elif 'm' in a_time:
        return float(a_time[:-1])/60
def parse_poll(a_poll):
    a_poll = a_poll.strip()
    if 'K' in a_poll:
        return int(float(a_poll[:-1]) * 1000)
    else:
        return int(a_poll)
def reverse_one_hot(row, columns, transform=None):
    if transform is None:
        transform = lambda x: x
    for c in columns:
        if row[c] == 1:
            return transform(c)
def get_true_columns(row, columns, transform=None):
    if transform is None:
        transform = lambda x: x
    return [transform(c) for c in columns if row[c] == 1]

DEFAULT_TIMES = {
    'Polled': 0,
    'Average': 0,
    'Median': 0,
    'Rushed': 0,
    'Leisure': 0
}
GAME_TIME_COLUMNS = ['Average', 'Median', 'Rushed', 'Leisure']
PUBLISHER_COLUMNS = '2K	Acclaim	Activision	Atari	Capcom	Disney	Eidos	EA	Infograme	Konami	Microsoft	Midway	Namco	Nintendo	Rockstar	Sony	Sega	THQ	SquareEnix	Ubisoft'.split()

df = pd.read_csv('games.csv', encoding = 'latin1')

df = df[~df['Title'].isin(skip_list)]
result = []
for index, data in tqdm(df.iterrows()):
    name = data['Title']
    original_name = name
    
    if name.endswith('...'):
        name = name.rsplit(' ', maxsplit=1)[0]
    
    if name in manual_corrections:
        name = manual_corrections[name]
    name = (name.replace(':', '')
                .replace(' - ', ' '))
    name = (name.replace('\xa4', 'n')
                .replace('\x82', 'e')
                .replace('\x8b', 'i')
                .replace('\x81', 'u')
                )
    
    SEARCH_URL = 'https://howlongtobeat.com/search_main.php?page=1'
    search_results = requests.post(SEARCH_URL, data={
        'queryString': name,
        't': 'games',
        'sorthead': 'popular',
        'sortd':'Normal Order'
    }).content

    soup = bs4.BeautifulSoup(search_results, 'lxml')
    
    top_anchor = soup.find('a')
    if top_anchor is None:
        #print("MISSING:", original_name.encode('utf-8'), "||", name.encode('utf-8'))
        continue
    title, url = top_anchor['title'], top_anchor['href']
    match = SequenceMatcher(None, name, title).ratio()
    if match < .5:
        #print("MISMATCH?", name, "||", title)
        pass
    full_url = 'https://howlongtobeat.com/' + url
    game_page = requests.get(full_url).content
    soup = bs4.BeautifulSoup(game_page, 'lxml')
    game_table = soup.select('h3.back_blue + div table.game_main_table tbody tr')
    game_times = {'Main Story': DEFAULT_TIMES.copy(),
                  'Main + Extras': DEFAULT_TIMES.copy(),
                  'Completionists': DEFAULT_TIMES.copy(),
                  'All PlayStyles': DEFAULT_TIMES.copy()}
    for row in game_table:
        tds = [td.text for td in row.select("td")]
        PlayStyle = tds[0]
        game_times[PlayStyle]['Polled'] = parse_poll(tds[1])
        for name, value in zip(GAME_TIME_COLUMNS, tds[2:]):
            game_times[PlayStyle][name] = parse_hm(value)
    if 1 in (data['Accessory'], data['LtdEdition']):
        continue
    result.append({
        'Length': game_times,
        
        'Release': {
            'Year': int(data['YearReleased']),
            'Console': data['Console'],
            'Re-release?': bool(data['Re-release']),
            'Rating': reverse_one_hot(data, ['RatingE','RatingT','RatingM'], lambda x: x[-1]),
        },
        'Title': unidecode(data['Title']),
        
        'Metadata': {
            'Publishers': get_true_columns(data, PUBLISHER_COLUMNS),
            'Genres': [x.strip() 
                       for x in data['Genre'].split(",")],
            'Licensed?': bool(data['Licensed']),
            'Sequel?': bool(data['Sequel']),
        },
        
        'Metrics': {
            'Sales': float(data['US Sales (millions)']),
            'Used Price': float(data['Usedprice']),
            'Review Score': int(data['Review Score']),
        },
        
        'Features': {
            'Max Players': int(data['MaxPlayers']),
            'Online?': bool(data['Online']),
            'Handheld?': bool(data['Handheld']),
            'Multiplatform?': bool(data['Multiplatform']),
        }

    })
with open('video_games.json', 'w') as out:
    json.dump(result, out, indent=2)