from setuptools import setup
import os.path

setup(
    name='Election',
    version='1',
    py_modules=['election'],
    data_files=[('', [
        "./election.db"
    ])]
)

