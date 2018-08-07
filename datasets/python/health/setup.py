from setuptools import setup
import os.path

setup(
    name='Health',
    version='1',
    py_modules=['health'],
    data_files=[('', [
        "./health.db"
    ])]
)

