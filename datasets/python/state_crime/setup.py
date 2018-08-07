from setuptools import setup
import os.path

setup(
    name='State Crime',
    version='1',
    py_modules=['state_crime'],
    data_files=[('', [
        "./state_crime.db"
    ])]
)

