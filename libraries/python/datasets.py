'''
This library is used to access CORGIS datasets.

If you are a student, you do not need to learn about this dataset.
'''

from types import ModuleType
import sys, os
import inspect

FILE_FORMATS = ['.sql', '.corgis']
DEV = True
DEV_DIRECTORIES = [r'C:\Users\acbart\Projects\datasets\datasets']

class DatasetException(Exception):
    pass
    
def is_readable_file(file_path, file_name):
    full_path = file_path + "/" + file_name
    try:
        if not os.path.exists(file_path):
            return False
        elif not os.path.isfile(full_path):
            return False
        elif not os.access(full_path, os.R_OK):
            return False
        else:
            return True
    except IOError as ex:
        #print "I/O error({0}): {1}".format(ex.errno, ex.strerror)
        return False
    except Error as ex:
        #print "Error({0}): {1}".format(ex.errno, ex.strerror)
        return False
    return False

class DatasetInstance(object):
    """
    This makes a special dataset object
    """
    
    def __init__(self):
        self.module = self.__class__.__name__
        self._connection_file = self._load_dataset()
        
    def _access_dataset(self, method):
        def _command(**kwargs):
            return "Hello World"
        return _command
        
    def _load_dataset(self):
        '''
        Finds and loads a dataset
        '''
        for FILE_FORMAT in FILE_FORMATS:
            name = self.module+FILE_FORMAT
            # Check the current working directory
            if is_readable_file('.', name):
                return os.path.abspath(name)
            # Check the original caller's working directory
            top_of_stack = inspect.stack()[-1]
            _, path, _, _, _, _ = top_of_stack
            if is_readable_file(path, name):
                return os.path.join(path, name)
            if DEV:
                for DIRECTORY in DEV_DIRECTORIES:
                    if is_readable_file(DIRECTORY, name):
                        return os.path.join(DIRECTORY, name)
        raise DatasetException('The Dataset "{0}" was not found. Make sure that there is a "{0}.sql" file in the current directory.'.format(self.module))
        
    def __getattr__(self, name):
        return self._access_dataset(name)

custom_modules = {}
class module(ModuleType):
            
    def __getattr__(self, name):
        # if we have already loaded the module, return it
        if name in custom_modules:
            return custom_modules[name]
        
        
        # otherwise create an instance of it now
        c = type(name, (DatasetInstance,), dict())
        custom_modules[name] = c()
        return custom_modules[name]

old_module = sys.modules['datasets']
new_module = sys.modules['datasets'] = module('datasets')
new_module.__dict__.update({
    '__file__' : __file__,
    '__package__' : 'datasets',
    #'__path__' : __path__,
    '__doc__' : __doc__
})

import sqlite3

conn = sqlite3.connect('example.db')