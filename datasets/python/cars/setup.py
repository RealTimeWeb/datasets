from setuptools import setup
import os.path

setup(
    name='Cars',
    version='1',
    py_modules=['cars'],
    data_files=[('', [
        "./cars.db"
    ])]
)

