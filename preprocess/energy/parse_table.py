from collections import defaultdict
from unidecode import unidecode
import lxml.html

'''
http://stackoverflow.com/questions/9978445/parsing-a-table-with-rowspan-and-colspan
'''

def table_to_list(html):
    doc = lxml.html.document_fromstring(html)
    tables = []
    for table_el in doc.xpath('//table'):
        tables.append(list(iter_2d_dict(table_to_2d_dict(table_el))))
    return tables


def table_to_2d_dict(table):
    result = defaultdict(lambda : defaultdict(str))
    for row_i, row in enumerate(table.xpath('./tr')):
        for col_i, col in enumerate(row.xpath('./td|./th')):
            colspan = int(col.get('colspan', 1))
            rowspan = int(col.get('rowspan', 1))
            col_data = unidecode(col.text_content()).strip()
            while row_i in result and col_i in result[row_i]:
                col_i += 1
            for i in range(row_i, row_i + rowspan):
                for j in range(col_i, col_i + colspan):
                    result[i][j] = col_data
    return result


def iter_2d_dict(dct):
    for i, row in sorted(dct.items()):
        cols = []
        for j, col in sorted(row.items()):
            cols.append(col)
        yield cols