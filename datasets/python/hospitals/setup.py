from setuptools import setup
import os.path

setup(
    name='Hospitals',
    version='1',
    py_modules=['hospitals'],
    data_files=[('', [
        "./hospitals.db"
    ])]
)

