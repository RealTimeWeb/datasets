from setuptools import setup
import os.path

setup(
    name='Labor',
    version='1',
    py_modules=['labor'],
    data_files=[('', [
        "./labor.db"
    ])]
)

