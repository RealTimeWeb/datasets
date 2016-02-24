import argparse
import yaml
import glob
import csv
import shutil
import json
import sys, os
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
        
class JSONDataset(Dataset):
    def __init__(self, data):
        self.data = data
        
    def iterator(self):
        for element in self.data:
            yield element
            
    def to_file(self, filename):
        with open(filename, 'w') as output:
            json.dump(_byteify(list(self.data)), output)
    
        
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
        
class MapFunction(object):
    '''
    Manipulates individual elements according to a rule.
    '''
    def __init__(self, rule):
        self.rule = rule
        
    def apply(self, data):
        return JSONDataset(self.rule(element) for element in data.iterator())
            
        
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