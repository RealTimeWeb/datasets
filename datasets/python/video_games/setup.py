from setuptools import setup
import os.path

setup(
    name='Video Games',
    version='1',
    py_modules=['video_games'],
    data_files=[('', [
        "./video_games.db"
    ])]
)

