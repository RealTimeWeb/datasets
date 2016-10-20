'''
    Author: 
    Day 18 Classwork - Problem #3

    We want to answer the following question:
        What is the distribution of rainfall?

    In order to answer this question, show a histogram of the "Precipitation"
    of the recorded weather reports.
'''

import matplotlib.pyplot as plt
import weather

weather_reports = weather.get_weather(test=False)

precips = []
for report in weather_reports:
    precips.append(report['Data']['Temperature']['Min Temp'])

plt.hist(precips)
plt.show()