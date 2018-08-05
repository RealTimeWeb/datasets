from setuptools import setup
import os.path

setup(
    name='{{ metadata.name }}',
    version='{{ metadata.version }}',
    py_modules=['{{ metadata.name | snake_case }}'],
    data_files=[('', [
        "./{{ metadata.name|snake_case }}.db"
    ])]
)


