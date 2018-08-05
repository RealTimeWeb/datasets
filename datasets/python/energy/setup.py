from setuptools import setup
import os.path

setup(
    name='Energy',
    version='1',
    py_modules=['energy'],
    data_files=[('', [
        "./energy.db"
    ])]
)

