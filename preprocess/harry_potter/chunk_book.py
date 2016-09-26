from textblob import TextBlob
import sys
import os
import nltk.data

#BOOK_NAME = sys.argv[1]
BOOK_NAME = 'book-1-ss.txt'

def chunks(l, n):
    """Yield successive n-sized chunks from l."""
    for i in range(0, len(l), n):
        yield l[i:i + n]
        
tokenizer = nltk.data.load('tokenizers/punkt/english.pickle')

with open(BOOK_NAME, 'r') as book_file:
    book = book_file.read()
book = ' '.join(book.split("\n"))
sentences = tokenizer.tokenize(book)

chunked_sentences = chunks(sentences, 90)

if not os.path.exists('chunked_sentences'):
    os.makedirs('chunked_sentences')
    
for index, chunk in enumerate(chunked_sentences):
    chunk = map(str, chunk)
    joined_chunk = '\n'.join(chunk)
    with open('chunked_sentences/part_{0:0>2}.txt'.format(index), 'w') as chunk_file:
        chunk_file.write(joined_chunk)