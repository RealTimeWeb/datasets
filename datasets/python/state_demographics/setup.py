from setuptools import setup
import os.path

setup(
    name='State Demographics',
    version='1',
    py_modules=['state_demographics'],
    data_files=[('', [
        "./state_demographics.db"
    ])]
)

