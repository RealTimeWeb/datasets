'''
The headers for the four files don't really line up.

We may want to just go with Vietname and perform some kind of
aggregation. There's over a gig of data there. That's too
much for the dataset.
'''

import pandas as pd
from collections import Counter
from pprint import pprint

datasets = ['wwi.csv', 'wwii.csv', 'vietnam.csv', 'korean.csv'][2:3]

counts = Counter()
for dataset in datasets:
    print(dataset)
    df_iter = pd.read_csv(dataset, iterator=True, chunksize=1000, encoding='latin_1')
    df = next(df_iter)
    for c in df.columns:
        counts[c]+= 1
        print(df[c].value_counts(dropna=False))
    #print(df.columns)
    
#pprint(sorted(counts.items(), key=lambda r: r[1]))