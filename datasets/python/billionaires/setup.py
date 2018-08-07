from setuptools import setup
import os.path

setup(
    name='Billionaires',
    version='1',
    py_modules=['billionaires'],
    data_files=[('', [
        "./billionaires.db"
    ])]
)

