from setuptools import setup
import os.path

setup(
    name='Education',
    version='1',
    py_modules=['education'],
    data_files=[('', [
        "./education.db"
    ])]
)

