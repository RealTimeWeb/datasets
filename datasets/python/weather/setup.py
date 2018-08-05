from setuptools import setup
import os.path

setup(
    name='Weather',
    version='3',
    py_modules=['weather'],
    data_files=[('', [
        "./weather.db"
    ])]
)

