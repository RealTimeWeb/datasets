# -*- coding: utf-8 -*-
"""
Created on Mon May 16 13:20:28 2016

@author: acbart
"""

import skyscrapers

json_data = skyscrapers.get_skyscrapers()

heights = [building['statistics']['height'] for building in json_data]

wrongHeights = list(set([type(height) for height in heights]))