from setuptools import setup
import os.path

setup(
    name='Slavery',
    version='1',
    py_modules=['slavery'],
    data_files=[('', [
        "./slavery.db"
    ])]
)

