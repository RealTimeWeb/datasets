from setuptools import setup
import os.path

setup(
    name='County Demographics',
    version='1',
    py_modules=['county_demographics'],
    data_files=[('', [
        "./county_demographics.db"
    ])]
)

