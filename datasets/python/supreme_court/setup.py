from setuptools import setup
import os.path

setup(
    name='Supreme Court',
    version='1',
    py_modules=['supreme_court'],
    data_files=[('', [
        "./supreme_court.db"
    ])]
)

