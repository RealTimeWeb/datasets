import json
from watson_developer_cloud import ToneAnalyzerV3
from tqdm import tqdm
import os

with open('credentials.json', 'r') as credentials_file:
    credentials = json.load(credentials_file)

tone_analyzer = ToneAnalyzerV3(
   username=credentials['username'],
   password=credentials['password'],
   version='2016-05-19 ')

CHUNK_FOLDER = 'chunked_sentences/'
RESULT_FOLDER = 'analyzed_sentences/'

if not os.path.exists(RESULT_FOLDER):
    os.makedirs(RESULT_FOLDER)
    
for chunk_filename in tqdm(os.listdir(CHUNK_FOLDER)):
    chunk_filename = os.path.splitext(chunk_filename)[0]
    base_name = '/'.join([CHUNK_FOLDER, chunk_filename+'.txt'])
    result_name = '/'.join([RESULT_FOLDER, chunk_filename+'.json'])
    with open(base_name, 'r') as book_file, open(result_name, 'w') as analysis_file:
        book = book_file.read()
        analysis = tone_analyzer.tone(text=book)
        json.dump(analysis, analysis_file, indent=2)