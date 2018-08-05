from setuptools import setup
import os.path

setup(
    name='State Fragility',
    version='1',
    py_modules=['state_fragility'],
    data_files=[('', [
        "./state_fragility.db"
    ])]
)

