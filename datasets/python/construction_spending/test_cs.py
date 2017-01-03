#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Nov 15 14:14:16 2016

@author: brianmetcalfe
"""

import matplotlib.pyplot as plt
import construction_spending


list_of_spending = construction_spending.get_spending()
spending = []
year_list = []
for annual_spending in list_of_spending:
        spending.append (annual_spending['annual']['combined']['total construction'])
        year_list.append (annual_spending['time']['index'])
plt.plot(year_list,spending)
plt.xlabel("Years")
plt.ylabel("Annual Spening")
plt.title("Annual Contruction Spending Over Time")
plt.show()
