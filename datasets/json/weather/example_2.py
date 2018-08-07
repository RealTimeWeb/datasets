# -*- coding: utf-8 -*-
"""
Created on Wed Apr  4 12:11:27 2018

@author: acbart
"""

import json

with open("weather.json") as weather_file:
    weather_data = json.load(weather_file)
    
total_rainfall = 0
for report in weather_data:
    total_rainfall += report['Data']['Precipitation']
    
print(total_rainfall)