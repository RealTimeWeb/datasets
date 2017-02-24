import subprocess
import os
from timeit import default_timer
import sys
import sqlite3

TEST_DATABASE = 'tests/_temp.db'
root = 'datasets/sql/'
datasets = os.listdir(root)

start_time = default_timer()

if len(sys.argv) >= 2:
    if sys.argv[1] != 'all':
        datasets = [sys.argv[1]]

total_datasets = 0
for dataset in datasets:
    if not os.path.isdir(root+dataset):
        continue
    sql_file = root+dataset+'/'+dataset+'.sql'
    with open(sql_file) as inp:
        sql_script = inp.read()
    if os.path.exists(TEST_DATABASE):
        os.remove(TEST_DATABASE)
    con = sqlite3.connect(TEST_DATABASE, isolation_level='IMMEDIATE ')
    con.executescript(sql_script)
    os.remove(TEST_DATABASE)
    
    total_datasets += 1
    print "\n"
print("Total datasets: {}".format(total_datasets))
print("Time taken: {}".format(default_timer() - start_time))