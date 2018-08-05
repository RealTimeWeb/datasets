from setuptools import setup
import os.path

setup(
    name='Medal of Honor',
    version='1',
    py_modules=['medal_of_honor'],
    data_files=[('', [
        "./medal_of_honor.db"
    ])]
)

