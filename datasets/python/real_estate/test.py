# -*- coding: utf-8 -*-
"""
Created on Tue Nov 15 15:12:48 2016

@author: acbart
"""

import matplotlib
import matplotlib.pyplot as plt
import real_estate
list_of_building = real_estate.get_buildings()

owned_VA = 0
leased_VA = 0
owned_PA = 0
leased_PA = 0
owned_MD = 0
leased_MD = 0
owned_buildings = []
leased_buildings = []
for report in list_of_building:
    if report["location"]["address"]["state"] == "VA":
        if report["data"]["owned or leased"] == "OWNED":
            owned_VA = owned_VA + 1
            leased_VA = leased_VA + 1
    elif report["location"]["address"]["state"] == "PA":
        if report["data"]["owned or leased"] == "OWNED":
            owned_PA = owned_PA + 1
            leased_VA = leased_VA + 1
    elif report["location"]["address"]["state"] == "MD":
        if report["data"]["owned or leased"] == "OWNED":
            owned_MD = owned_MD + 1
            leased_MD = leased_MD + 1
            
owned_buildings = [owned_VA, owned_PA, owned_MD]
leased_buildings = [leased_VA, leased_PA, leased_MD]

labels = ["Virginia", "Pennsylvania", "Maryland"]
xcoords = range(len(labels))
plt.bar(xcoords, owned_buildings, tick_label= labels, align='center')
plt.title("Buildings Owned or Leased in Mid-Atlantic States")
plt.xlabel("States")
plt.ylabel("Number owned or leased")
plt.legend()
plt.show()    