# -*- coding: utf-8 -*-
"""
Created on Tue Oct  4 16:42:18 2016

@author: acbart
"""

import weather
import matplotlib.pyplot as plt

data = weather.get_weather()
new = []

for city in data:
    if city['Station']['Location'] == "Blacksburg, VA":
        new.append(city['Data']['Precipitation'])
print(len(data))
        
plt.hist(new)
plt.title("Precipitation in Blacksburg over the Summer")
plt.xlabel("Rainfall (inches)")
plt.ylabel("Number of days")
plt.show()

print(len(weather.get_weather(test=True)))
print(len(weather.get_weather(test=False)))