import argparse
import yaml
import glob
import csv
import shutil
import json
import sys, os
import requests
import xlrd
from tempfile import NamedTemporaryFile
from collections import OrderedDict
from pprint import pprint


_PYTHON_3 = sys.version_info >= (3, 0)
def _byteify(input):
    """
    Force the given input to only use `str` instead of `bytes` or `unicode`.
    This works even if the input is a dict, list,
    """
    if isinstance(input, dict):
        return {_byteify(key): _byteify(value) for key, value in input.items()}
    elif isinstance(input, list):
        return [_byteify(element) for element in input]
    elif _PYTHON_3 and isinstance(input, str):
        return str(input.encode('ascii', 'replace').decode('ascii'))
    elif not _PYTHON_3 and isinstance(input, unicode):
        return str(input.encode('ascii', 'replace').decode('ascii'))
    else:
        return input

class Dataset(object):        
    def __str__(self):
        extra_str = ", ".join("{}={}".format(*i) for i in sorted(vars(self).iteritems()))
        return "({}: {})".format(self.__class__.__name__, extra_str)
        
    def iterator(self):
        return []
        
class XLSDataset(Dataset):
    def __init__(self, location, sheet, 
                 header_start_row=None, header_end_row=None,
                 header_start_column=None, header_end_column=None,
                 data_start_row=None, data_end_row=None,
                 data_start_column=None, data_end_column=None):
        self.location = location
        self.sheet = sheet
        self.header_start_row = header_start_row
        self.header_end_row = header_end_row
        self.header_start_column = header_start_column
        self.header_end_column = header_end_column
        self.data_start_row=data_start_row
        self.data_end_row=data_end_row
        self.data_start_column=data_start_column
        self.data_end_column=data_end_column
        
    def grab_content(self, rows, start_row, end_row, start_col, end_col):
        header = {}
        row_mode = 'STARTING'
        start_row_index = 0
        col_mode = 'STARTING'
        start_column_index = 0
        for index, row in enumerate(rows):
            if row_mode == 'STARTING' and start_row(index, row):
                row_mode = 'GRABBING'
                start_row_index = index
            if row_mode == 'GRABBING':
                for col_index, col in enumerate(row):
                    if col_mode == 'STARTING' and start_col(col_index, col):
                        col_mode = 'GRABBING'
                        start_column_index = col_index
                    if col_mode == 'GRABBING':
                        if col_index in header:
                            header[col_index].append(col)
                        else:
                            header[col_index] = [col]
                        if end_col(col_index, start_column_index, row):
                            break
                col_mode = 'STARTING'
                if end_row(index, start_row_index, row):
                    break
        return map(lambda x: x[1], sorted(header.items(), key=lambda x: x[0]))
    
    def _reload_header(self, rows):
        return self.grab_content(rows, self.header_start_row, self.header_end_row,
                          self.header_start_column, self.header_end_column)
    def _reload_body(self, rows):
        return self.grab_content(rows, self.data_start_row, self.data_end_row,
                          self.data_start_column, self.data_end_column)
        
    def iterator(self):
        workbook = xlrd.open_workbook(self.location)
        if isinstance(self.sheet, int):
            sheet = workbook.sheet_by_index(self.sheet)
        else:
            sheet = workbook.sheet_by_name(self.sheet)
        rows = [map(str, sheet.row_values(line)) for line in xrange(sheet.nrows)]
        self._header = self._reload_header(rows)
        yield self._header
        for row in self._reload_body(rows):
            yield row
            #yield OrderedDict(zip(self._header, row))
        
class JSONDataset(Dataset):
    def __init__(self, data):
        self.data = data
        
    def iterator(self):
        for element in self.data:
            yield element
            
    def to_file(self, filename):
        with open(filename, 'w') as output:
            json.dump(_byteify(list(self.data)), output)
            

    
class FileList(Dataset):
    def __init__(self, file_list):
        self.file_list = file_list
        
    def iterator(self):
        for element in self.file_list:
            yield element
        
class CSVReaderDataset(Dataset):
    def __init__(self, location, delimiter, quotechar, header):
        # Initialization of attributes
        self.location = location
        self.header = header
        self.delimiter = delimiter
        self.quotechar = quotechar
        self.header_data = self._analyze_header()
    
    def _analyze_header(self):
        reader = self._reload_reader()
        if self.header is True:
            header = next(reader)
        elif self.header is False:
            header = range(len(next(reader)))
        else:
            header = self.header
        return header
        
    def _reload_reader(self):
        return csv.reader(open(self.location, 'r'),
                          delimiter=self.delimiter,
                          quotechar=self.quotechar)
        
    def iterator(self):
        reader = self._reload_reader()
        if self.header is True:
            _ = next(reader)
        for line in reader:
            yield OrderedDict(zip(self.header_data, line))

class Step(object):
    def __init__(self):
        pass
    def apply(self, data):
        return data
        
def download_file(url, destination_folder, replace=False):
    local_filename = destination_folder+url.split('/')[-1]
    if os.path.exists(local_filename) and not replace:
        return local_filename
    r = requests.get(url, stream=True)
    with open(local_filename, 'wb') as f:
        for chunk in r.iter_content(chunk_size=1024): 
            if chunk:
                f.write(chunk)
    return local_filename
        
class Download(object):
    def __init__(self, target, destination, replace=False):
        if isinstance(target, str):
            self.targets = [target]
        else:
            self.targets = target
        self.destination = destination
        self.replace = replace
        
    def apply(self, data):
        return FileList([download_file(target, self.destination, self.replace)
                         for target in self.targets])
        
class LoadCSV(object):
    '''
    Loads in a CSV file and returns an iterator over that file.
    
    :param header: If this parameter is False, no header is present in the file and you will have to refer to columns with a numerical index. If it is True, then the header is inferred from the first line. If this parameter is a list of strings, that list of strings will be used as the header.
    :type header: Boolean, or list of strings
    '''
    def __init__(self, location, delimiter=',', quotechar='"', header=False):
        self.location = location
        self.delimiter = delimiter
        self.quotechar = quotechar
        self.header = header
        
    def apply(self, data):
        return CSVReaderDataset(self.location, self.delimiter, self.quotechar, self.header)
        
class LoadCSVs(object):
    '''
    Loads in a CSV file and returns an iterator over that file.
    
    :param header: If this parameter is False, no header is present in the file and you will have to refer to columns with a numerical index. If it is True, then the header is inferred from the first line. If this parameter is a list of strings, that list of strings will be used as the header.
    :type header: Boolean, or list of strings
    '''
    def __init__(self, delimiter=',', quotechar='"', header=False):
        self.delimiter = delimiter
        self.quotechar = quotechar
        self.header = header
        
    def apply(self, data):
        print "HEY WHAT"
        for location in data.iterator():
            print(location)
            yield CSVReaderDataset(location, self.delimiter, self.quotechar, self.header)
        
class MapFunction(object):
    '''
    Manipulates individual elements according to a rule.
    '''
    def __init__(self, rule):
        self.rule = rule
        
    def apply(self, data):
        return JSONDataset(self.rule(element) for element in data.iterator())
class FilterFunction(object):
    '''
    Manipulates individual elements according to a rule.
    '''
    def __init__(self, rule):
        self.rule = rule
        
    def apply(self, data):
        if isinstance(data, FileList):
            return FileList(list(element for element in data.iterator() if self.rule(element)))
        else:
            return JSONDataset(element for element in data.iterator() if self.rule(element))
class Slice(object):
    '''
    Manipulates individual elements according to a rule.
    '''
    def __init__(self, start=0, end=-1, stride=1):
        self.start = start
        self.end = end
        
    def apply(self, data):
        for item in itertools.islice(data.iterator(), self.start, self.end, self.stride):
            yield item
        
        
class OverList(Step):
    def __init__(self, step_function):
        self.step_function = step_function
    def apply(self, data):
        for item in data:
            yield self.step_function.apply(item)
    
class Print(object):
    def apply(self, data):
        for item in data.iterator():
            pprint(item)
                
class DumpXLS(object):
    def __init__(self, replace=False):
        self.replace = replace
    def apply(self, data):
        files = []
        for excel_file in data.iterator():
            #print excel_file
            workbook = xlrd.open_workbook(excel_file)
            all_worksheets = workbook.sheet_names()
            base = excel_file.rsplit('.', 1)[0]
            for worksheet_name in all_worksheets:
                worksheet = workbook.sheet_by_name(worksheet_name)
                output_filename = base+worksheet_name+'.csv'
                if os.path.exists(output_filename) and not self.replace:
                    files.append(output_filename)
                your_csv_file = open(output_filename, 'wb')
                wr = csv.writer(your_csv_file, quoting=csv.QUOTE_ALL)
                for rownum in xrange(worksheet.nrows):
                    wr.writerow([unicode(entry).encode("utf-8") for entry in worksheet.row_values(rownum)])
                your_csv_file.close()
                files.append(output_filename)
        return FileList(files)
        
class Save(object):
    '''
    Saves the current result to a data file.
    '''
    def __init__(self, location):
        self.location = location
        
    def apply(self, data):
        with open(self.location, 'w') as output:
            if self.location[-5:] == '.json':
                json.dump(_byteify(data), output)
            else:
                output.write(data)
        
class SampleRows(Step):
    def __init__(self, max_rows=None):
        self.max_rows = max_rows
    def apply(self, data):
        
        return data
        
class UniqueRows(Step):
    def apply(self, data):
        pass
        
class SkipRows(Step):
    pass
    
class PreviewColumn(Step):
    pass

class PreviewRow(Step):
    pass
        
class ToJSON(Step):
    def __init__(self, rules, **special_interpolations_rules):
        if isinstance(rules, str):
            with open(rules) as input_file:
                self.rules = _byteify(json.load(input_file))
        else:
            self.rules = rules
        self.special_interpolation_rules = special_interpolations_rules
        self.special_interpolations = {}
        
    def process_rules(self, subrule, data_lookup):
        result = {}
        for key, value in subrule.iteritems():
            if isinstance(value, dict):
                result[key] = self.process_rules(value, data_lookup)
            elif isinstance(value, str) or isinstance(value, unicode):
                result[key] = data_lookup[value]
            elif isinstance(value, list):
                result[key] = []
                for element in value:
                    result[key].append(self.process_rules(element, data_lookup))
            elif isinstance(value, tuple):
                value, transform_function = value
                transformed_value = data_lookup[value]
                result[key] = transform_function(transformed_value)
            else:
                raise Exception("Unknown rule type? {}".format(type(value)))
        return result
        
    def update_special_rules(self):
        for id, special_rule in self.special_interpolation_rules.iteritems():
            self.special_interpolations[id] = special_rule(self.special_interpolations['index'])
        
    def apply(self, data):
        return JSONDataset([self.process_rules(self.rules, line) for line in data.iterator()])
        
class Pipeline(object):
    def __init__(self):
        self.steps = []
        
    def add_step(self, new_step):
        self.steps.append(new_step)
    
    def add_steps(self, *new_steps):
        self.steps.extend(new_steps)
        
    def complete(self):
        result = None
        for step in self.steps:
            result = step.apply(result)
        return result
    
    def run(self):
        result = None
        for index, step in enumerate(self.steps):
            yield ('step', index, step.__class__.__name__, result)
            result = step.apply(result)
        yield ('result', index+1, 'completed', result)
        
def remove_comma(a_string):
    return int(a_string.replace(',', ''))
        
'''
pipeline = Pipeline()
pipeline.add_steps(
    LoadCSV('sampled.csv', delimiter='\t', header=True),
    SampleRows(max_rows=10000),
    ToJSON(
        {
            'description': {
                'group': 'GROUP_DESC',
                'commodity': 'COMMODITY_DESC',
                'class': 'CLASS_DESC',
                'short name': 'SHORT_DESC',
                'unit': 'UNIT_DESC',
                'statistics': 'STATISTICCAT_DESC',
                'utility': 'UTIL_PRACTICE_DESC',
                'production': 'PRODN_PRACTICE_DESC',
                'sector': 'SECTOR_DESC'
            },
            'location': {
                'state': 'STATE_NAME',
                'state code': 'STATE_ALPHA',
                'country': 'COUNTRY_NAME',
                'year': ('YEAR', int)
            },
            'value': ('VALUE', remove_comma)
        }
    ),
    UniqueRows()
)
'''

if __name__ == '__main__':
    for execution, index, label, result in pipeline.run():
        if execution == 'step':
            print label
        else:
            print "Result:"
            pprint(result)