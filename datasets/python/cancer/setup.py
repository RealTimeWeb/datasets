from setuptools import setup
import os.path

setup(
    name='Cancer',
    version='1',
    py_modules=['cancer'],
    data_files=[('', [
        "./cancer.db"
    ])]
)

