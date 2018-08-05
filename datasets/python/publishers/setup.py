from setuptools import setup
import os.path

setup(
    name='Publishers',
    version='1',
    py_modules=['publishers'],
    data_files=[('', [
        "./publishers.db"
    ])]
)

