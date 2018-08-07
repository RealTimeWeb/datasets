from setuptools import setup
import os.path

setup(
    name='Global Development',
    version='1',
    py_modules=['global_development'],
    data_files=[('', [
        "./global_development.db"
    ])]
)

