from setuptools import setup
import os.path

setup(
    name='Food',
    version='1',
    py_modules=['food'],
    data_files=[('', [
        "./food.db"
    ])]
)

