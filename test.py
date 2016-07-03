import subprocess
import os
from timeit import default_timer
import sys

root = 'datasets/python/'
datasets = os.listdir(root)

skip_list = ['baseball', 'nfl', 'soccer', 'twitter', 'gutenberg', 'weather', 'airports', 'johnsongrass']

start_time = default_timer()

if len(sys.argv) >= 2:
    if sys.argv[1] != 'all':
        datasets = [sys.argv[1]]

os.chdir(root)
total_datasets = 0
for dataset in datasets:
    if dataset in skip_list:
        continue
    if not os.path.isdir(dataset):
        continue
    python_file = dataset+'.py'
    html_file = dataset+'.html'
    os.chdir(dataset)
    subprocess.call(["python", python_file, "-t"])
    subprocess.call([r"C:\Users\acbart\Anaconda3\python.exe", python_file, "-t"])
    os.chdir('..')
    total_datasets += 1
    print "\n"
print("Total datasets: {}".format(total_datasets))
print("Time taken: {}".format(default_timer() - start_time))