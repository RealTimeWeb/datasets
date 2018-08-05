from setuptools import setup
import os.path

setup(
    name='Real Estate',
    version='1',
    py_modules=['real_estate'],
    data_files=[('', [
        "./real_estate.db"
    ])]
)

