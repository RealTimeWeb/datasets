from setuptools import setup
import os.path

setup(
    name='County Crime',
    version='1',
    py_modules=['county_crime'],
    data_files=[('', [
        "./county_crime.db"
    ])]
)

