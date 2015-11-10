# -*- coding: utf-8 -*-
"""
Created on Thu Oct  8 12:28:26 2015

@author: acbart
"""

import broadway


k = broadway.get_shows()

j = list(set([t['date'] for t in k]))