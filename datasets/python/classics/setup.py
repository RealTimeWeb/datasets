from setuptools import setup
import os.path

setup(
    name='Classics',
    version='1',
    py_modules=['classics'],
    data_files=[('', [
        "./classics.db"
    ])]
)

