from setuptools import setup
import os.path

setup(
    name='Broadway',
    version='1',
    py_modules=['broadway'],
    data_files=[('', [
        "./broadway.db"
    ])]
)

