from setuptools import setup
import os.path

#data_files=[('tate', [os.path.join(os.path.dirname(__file__), './tate.db')])]


setup(
    name='Tate',
    version='1',
    py_modules=['tate'],
    data_files=[('', [
        "./tate.db"
    ])]
)

