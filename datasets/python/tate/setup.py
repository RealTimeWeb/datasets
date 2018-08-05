from setuptools import setup
import os.path

setup(
    name='Tate',
    version='1',
    py_modules=['tate'],
    data_files=[('', [
        "./tate.db"
    ])]
)

