# -*- coding: utf-8 -*-
"""
Created on Sat Sep 24 15:54:18 2016

@author: acbart
"""

import json
import matplotlib.pyplot as plt
import numpy
import pandas as pd
from sklearn import preprocessing

with open('analysis.json') as analysis_file:
    analysis = json.load(analysis_file)    
    
WINDOW_SIZE = 1000
def get_list(analysis, cat, subcat):
    result = [s[cat][subcat]
             if cat in s else 0
             for s in analysis]
    result = pd.rolling_mean(pd.Series(result), window=WINDOW_SIZE, center=True, min_periods=0)
    result = result.fillna(0)
    min_max_scaler = preprocessing.MinMaxScaler()
    result = min_max_scaler.fit_transform(result)
    return result

plt.plot(get_list(analysis, "emotion_tone", "Joy"), label='Joy')
plt.plot(get_list(analysis, "emotion_tone", "Fear"), label='Fear')
plt.plot(get_list(analysis, "emotion_tone", "Anger"), label='Anger')
plt.plot(get_list(analysis, "emotion_tone", "Sadness"), label='Sadness')
plt.plot(get_list(analysis, "emotion_tone", "Disgust"), label='Disgust')
plt.legend(bbox_to_anchor=(1.01, 1), loc=2, borderaxespad=0.)
plt.xlabel("Sentence #")
plt.ylabel("Tone Score")
plt.title("Tone over the Course of the Book")
#plt.plot([s["emotion_tone"]["Disgust"] 
#         if "language_tone" in s else 0
#         for s in analysis])
 
plt.show()
    