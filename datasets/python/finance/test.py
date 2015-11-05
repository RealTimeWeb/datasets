# -*- coding: utf-8 -*-
"""
Created on Sun Nov  1 16:14:41 2015

@author: acbart
"""

import finance

import matplotlib.pyplot as plt

data = finance.get_finances("Delaware")

k = []
y= []
for year in data:
    k.append(year["totals"]["tax"])
    y.append(year["totals"]["revenue"])

plt.scatter(y, k)
#plt.plot(finance.get_finances("United States")["Totals"]["Tax"])

plt.show()