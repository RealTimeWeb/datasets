from setuptools import setup
import os.path

setup(
    name='Retail Services',
    version='1',
    py_modules=['retail_services'],
    data_files=[('', [
        "./retail_services.db"
    ])]
)

