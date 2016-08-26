'''
    Data taken from
        http://authorearnings.com/report/the-50k-report/
        Direct Link: http://authorearnings.com/wp-content/uploads/2014/02/Amazon-US-Kindle-bestsellers-anon-snapshot-20140207-v8.xlsx
    Converted to CSV in Excel
        publishers.csv
    Generates
        publishers.json
'''

from collections import Counter
from pprint import pprint
import json

genres = Counter()
publishers = Counter()
data = []
with open("publishers.csv") as inp:
    inp.readline()
    for line in inp:
        (sold_by, publisher, sales_rank, sale_price, total_reviews, rating, 
            indie, small, amazon, big_five, single_author,
            nonfiction, genre_fiction, fiction, children, comics, foreign_language,
            daily_units_sold, daily_gross_sales, daily_amazon_revenue, daily_publisher_revenue, daily_author_revenue
        ) = line.strip().split("\t")
        data.append({
            'statistics': {
                "sales rank": int(sales_rank),
                "sale price": float(sale_price),
                "total reviews": int(total_reviews),
                "average rating": float(rating),
            },
            "sold by": sold_by,
            "publisher": {
                'name': publisher,
                'type': "indie" if indie
                        else "small/medium" if small
                        else "amazon" if amazon
                        else "big five" if big_five
                        else "single author"
            },
            "genre": "nonfiction" if nonfiction
                else "genre fiction" if genre_fiction
                else "fiction" if fiction
                else "children" if children
                else "comics" if comics
                else "foreign language",
            "daily": {
                "units sold": int(daily_units_sold), 
                "gross sales": float(daily_gross_sales), 
                "amazon revenue": float(daily_amazon_revenue), 
                "publisher revenue": float(daily_publisher_revenue),
                "author revenue": float(daily_author_revenue)
            }
        })
        genres[sold_by] += 1
        publishers[publisher] += 1

pprint(dict(genres))
pprint(dict(publishers))
pprint(data[0])

json.dump(data, open("publishers.json", "w"))