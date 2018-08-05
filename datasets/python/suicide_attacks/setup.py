from setuptools import setup
import os.path

setup(
    name='Suicide Attacks',
    version='1',
    py_modules=['suicide_attacks'],
    data_files=[('', [
        "./suicide_attacks.db"
    ])]
)

