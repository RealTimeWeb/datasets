from setuptools import setup
import os.path

setup(
    name='Construction Spending',
    version='1',
    py_modules=['construction_spending'],
    data_files=[('', [
        "./construction_spending.db"
    ])]
)

