# -*- coding: utf-8 -*-
"""
Created on Sat May  6 11:20:26 2017

@author: acbart
"""

import food
import matplotlib.pyplot as plt
from scipy.stats import pearsonr

list_of_report = food.get_reports()

cals = [f['Data']['Kilocalories'] for f in list_of_report]
fats = [f['Data']['Fat']['Saturated Fat'] for f in list_of_report]

plt.scatter(cals, fats, alpha=.1, label="$\\rho=.61$")
plt.xlabel("Calories")
plt.ylabel("Saturated Fats")
plt.legend(markerscale=0, loc=(.1,.6))
plt.title("Relationship between Calories and Saturated Fats")
plt.show()

print(pearsonr(cals, fats))