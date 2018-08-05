from setuptools import setup
import os.path

setup(
    name='Hydropower',
    version='1',
    py_modules=['hydropower'],
    data_files=[('', [
        "./hydropower.db"
    ])]
)

