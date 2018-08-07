from setuptools import setup
import os.path

setup(
    name='Construction Permits',
    version='1',
    py_modules=['construction_permits'],
    data_files=[('', [
        "./construction_permits.db"
    ])]
)

