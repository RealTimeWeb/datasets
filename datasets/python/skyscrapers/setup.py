from setuptools import setup
import os.path

setup(
    name='Skyscrapers',
    version='1',
    py_modules=['skyscrapers'],
    data_files=[('', [
        "./skyscrapers.db"
    ])]
)

