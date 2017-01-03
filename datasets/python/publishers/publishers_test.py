# -*- coding: utf-8 -*-
"""
Created on Fri Dec  2 12:29:17 2016

@author: acbart
"""

import publishers
from collections import Counter

lp = publishers.get_books()
s= []
for p in lp:
    s.append(p['genre'])