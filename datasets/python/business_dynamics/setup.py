from setuptools import setup
import os.path

setup(
    name='Business Dynamics',
    version='1',
    py_modules=['business_dynamics'],
    data_files=[('', [
        "./business_dynamics.db"
    ])]
)

