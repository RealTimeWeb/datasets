from setuptools import setup
import os.path

setup(
    name='Finance',
    version='1',
    py_modules=['finance'],
    data_files=[('', [
        "./finance.db"
    ])]
)

