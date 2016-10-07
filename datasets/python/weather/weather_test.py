# -*- coding: utf-8 -*-
"""
Created on Tue Oct  4 16:42:18 2016

@author: acbart
"""

import weather
import matplotlib.pyplot as plt

data = weather.get_weather(test=False)
new = []

for city in data:
    if city['Station']['Location'] == "Blacksburg, VA":
        new.append(city['Data']['Precipitation'])
        
plt.hist(new)
plt.show()