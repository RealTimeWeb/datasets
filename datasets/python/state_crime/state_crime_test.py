# -*- coding: utf-8 -*-
"""
Created on Tue Oct 25 15:44:56 2016

@author: acbart
"""

import state_crime
import matplotlib.pyplot as plt

reports = state_crime.get_all_crimes(test=False)

years =[]
burglary_rates = []
for report in reports:
    if report['State'] == 'New York':
        years.append(report['Year'])
        burglary_rates.append(report['Data']['Rates']['Violent']['Murder'])
    
plt.plot(years, burglary_rates)
plt.show()
