# -*- coding: utf-8 -*-
"""
Created on Mon May  1 22:51:35 2017

@author: acbart
"""

import matplotlib.pyplot as plt
import drugs
list_of_report = drugs.get_reports()
alcohol_list =[]

for a_report in list_of_report :
    alcohol_list.append(a_report["Rates"]["Alcohol"]["Use Past Month"])
plt.hist(alcohol_list, label = 'Alcohol')
plt.title("Distribution of Alcohol Users")
plt.ylabel("Number")
plt.xlabel("Alcohol Users")
plt.legend()
plt.show()