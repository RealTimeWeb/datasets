from setuptools import setup
import os.path

setup(
    name='Earthquakes',
    version='1',
    py_modules=['earthquakes'],
    data_files=[('', [
        "./earthquakes.db"
    ])]
)

