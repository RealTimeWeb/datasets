'''
This script comes first. It takes a very long time to process, since it is collecting information from Gutenberg, creating an index, and then also applying very complex specialized metrics to the books' text.

generates:
    book_ids.json
    classics.json
'''

from gutenberg.acquire import load_etext
from gutenberg.cleanup import strip_headers
from process_rdf import readmetadata
from tqdm import tqdm
import json
import sys
from textstat.textstat import textstat
from textblob import TextBlob
import re
import types
import unicodedata

def clean(a_string):
    return str(unicodedata.normalize("NFKD", a_string.strip()).encode('ascii', 'ignore'))

def monkey_patched(self, text):
    ignoreCount = 0
    sentences = re.split(r' *[\.\?!][\'"\)\]]* *', text)
    for sentence in sentences:
        if self.lexicon_count(sentence) <= 2:
            ignoreCount = ignoreCount + 1
    if text.strip() and len(sentences) - ignoreCount == 0:
        return 1
    return len(sentences) - ignoreCount

textstat.sentence_count = types.MethodType(monkey_patched, textstat)

def get_special_metrics(text):
    blob = TextBlob(text)
    main = {
        'statistics': {
            'syllables': textstat.syllable_count(text),
            'words': textstat.lexicon_count(text),
            'characters': textstat.char_count(text),
            'polysyllables': textstat.polysyllabcount(text), 
            'average letter per word': textstat.avg_letter_per_word(text),
            'average sentence length': textstat.avg_sentence_length(text),
            'average sentence per word': textstat.avg_sentence_per_word(text),
            'sentences': textstat.sentence_count(text)
        },
        'difficulty': {
            'flesch reading ease': textstat.flesch_reading_ease(text),
            'smog index': textstat.smog_index(text),
            'flesch kincaid grade': textstat.flesch_kincaid_grade(text),
            'coleman liau index': textstat.coleman_liau_index(text),
            #'automated readability index': textstat.automated_readability_index(text),
            #'dale chall readability score': textstat.dale_chall_readability_score(text),
            #'difficult words': textstat.difficult_words(text),
            #'linsear write formula': textstat.linsear_write_formula(text),
            'gunning fog': textstat.gunning_fog(text)
        },
        'sentiments': {
            'polarity': blob.sentiment.polarity,
            'subjectivity': blob.sentiment.subjectivity
        }
    }
    
    return main

print("Loading index")
md = readmetadata()

print("Loading Book IDs")
completed = set()
with open('book_ids.json') as input:
    book_ids = json.load(input)

print("Processing books")
data = []
rank = 1
for book_id in tqdm(book_ids[:5]):
    if book_id in completed: continue
    bibrec = md[book_id]
    has_text = True
    try:
        text = strip_headers(load_etext(book_id)).strip()
        main_info = get_special_metrics(text)
    except ValueError:
        continue
    data.append({
        'metrics': main_info,
        'author': {
            'name': bibrec['author'],
            'birth': bibrec['authoryearofbirth'],
            'death': bibrec['authoryearofdeath'],
        },
        'book': {
            'type': bibrec['type'],
            'title': bibrec['title'],
            'languages': bibrec['language'],
            'congress classifications': list(bibrec['LCC']),
            'subjects': list(bibrec['subjects'])
        },
        'metadata': {
            'rank': rank,
            'id': bibrec['id'],
            'downloads': bibrec['downloads'],
            'url': 'https://www.gutenberg.org/ebooks/{}'.format(bibrec['id']),
            'formats': {
                'total': len(bibrec['formats']),
                'types': list(bibrec['formats'].keys())
            }
        }
    })
    completed.add(book_id)
    rank += 1
    
print("Completed {} books.".format(len(data)))
with open('classics.json', 'w') as output:
    json.dump(data, output)

#text = strip_headers(load_etext(1342)).strip()
#print(text)  # prints 'MOBY DICK; OR THE WHALE\n\nBy Herman Melville ...'