import json
import os
from tqdm import tqdm

ANALYSIS_FOLDER = 'analyzed_sentences/'

analyzed_files = sorted(os.listdir(ANALYSIS_FOLDER))

data = []
for file_name in tqdm(analyzed_files):
    analysis_path = '/'.join([ANALYSIS_FOLDER, file_name])
    with open(analysis_path, 'r') as analysis_file:
        analysis = json.load(analysis_file)
    tonal = analysis["sentences_tone"]
    for s in tonal:
        sentence = s["text"]
        sentence_data = {'text': sentence}
        for category in s["tone_categories"]:
            cat_id = category["category_id"]
            sentence_data[cat_id] = {}
            for tone in category["tones"]:
                name = tone["tone_name"]
                score = tone["score"]
                sentence_data[cat_id][name] = score
        data.append(sentence_data)
with open('analysis.json', 'w') as result_file:
    json.dump(data, result_file, indent=2)
with open('sentences.txt', 'w') as sentences_file:
    for s in data:
        sentences_file.write(s['text'].replace('\n', ' ')+'\n')