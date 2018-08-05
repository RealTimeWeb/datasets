from setuptools import setup
import os.path

setup(
    name='Graduates',
    version='1',
    py_modules=['graduates'],
    data_files=[('', [
        "./graduates.db"
    ])]
)

