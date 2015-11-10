# -*- coding: utf-8 -*-
"""
Created on Mon Apr 20 13:09:34 2015

@author: acbart
"""

from pprint import pprint
import twitter

twitter.connect()

twitter.connect('e0gtVH5Jr4cX9OtS9jNbijiUn',
                'NGIeGI4CiekJggGhzif05EPHnJnwbJnePsWKqpznImoFfKcY49',
                '342536207-dbt2eFduh9wiOprmKXsNTo7x5TM3vp7c6UeRaDxd',
                'JEZr4VKRFmOySkJoa11x5LNv8IgBA141KlNkzK0LoKoEX')

corgi_tweets = twitter.search("#corgis")

data = [tweet['retweets'] for tweet in corgi_tweets]
pprint(corgi_tweets)