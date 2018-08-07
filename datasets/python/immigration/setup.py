from setuptools import setup
import os.path

setup(
    name='Immigration',
    version='3',
    py_modules=['immigration'],
    data_files=[('', [
        "./immigration.db"
    ])]
)

