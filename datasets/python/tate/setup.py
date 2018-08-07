from setuptools import setup
import os.path

data_files=[('tate', [os.path.join(os.path.dirname(__file__), './tate.db')])]


setup(
    name='tate',
    version='0.1.1',
    py_modules=['tate'],
    #package_files={'tate': ['./tate.db']},
    #include_package_data=True,
    data_files=[('', ['./tate.db'])]
)
