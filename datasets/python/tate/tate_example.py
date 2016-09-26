# -*- coding: utf-8 -*-
"""
Created on Mon Sep 19 10:41:42 2016

@author: acbart
"""

import tate
import matplotlib.pyplot as plt

data = tate.get_artwork(test=True)

males = []
females = []

for piece in data:
    gender = piece['artist']['gender']
    if gender == 'Male':
        males.append(1)
    elif gender == 'Female':
        females.append(1)
x_labels = ['Male', 'Female']
x_values = [len(males), len(females)]
x_positions = range(len(x_labels))

plt.xticks(x_positions, x_labels)        
plt.bar(x_positions, x_values, align='center')