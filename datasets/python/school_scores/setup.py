from setuptools import setup
import os.path

setup(
    name='School Scores',
    version='1',
    py_modules=['school_scores'],
    data_files=[('', [
        "./school_scores.db"
    ])]
)

