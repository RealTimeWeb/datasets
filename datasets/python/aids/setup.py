from setuptools import setup
import os.path

setup(
    name='Aids',
    version='1',
    py_modules=['aids'],
    data_files=[('', [
        "./aids.db"
    ])]
)

