from setuptools import setup
import os.path

setup(
    name='Airlines',
    version='1',
    py_modules=['airlines'],
    data_files=[('', [
        "./airlines.db"
    ])]
)

