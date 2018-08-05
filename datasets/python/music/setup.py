from setuptools import setup
import os.path

setup(
    name='Music',
    version='1',
    py_modules=['music'],
    data_files=[('', [
        "./music.db"
    ])]
)

