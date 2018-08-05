from setuptools import setup
import os.path

setup(
    name='Injuries',
    version='1',
    py_modules=['injuries'],
    data_files=[('', [
        "./injuries.db"
    ])]
)

