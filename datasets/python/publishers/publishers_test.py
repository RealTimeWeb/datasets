# -*- coding: utf-8 -*-
"""
Created on Fri Dec  2 12:29:17 2016

@author: acbart
"""

import publishers
import matplotlib.pyplot as plt

books = publishers.get_books()
daily_units_sold= []
for book in books:
    daily_units_sold.append(book['daily average']['units sold'])
    
plt.plot(daily_units_sold)
plt.xlabel("Days")
plt.ylabel("Books sold")
plt.title("Daily Books Sold")
plt.show()