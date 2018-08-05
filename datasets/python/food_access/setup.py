from setuptools import setup
import os.path

setup(
    name='Food Access',
    version='1',
    py_modules=['food_access'],
    data_files=[('', [
        "./food_access.db"
    ])]
)

