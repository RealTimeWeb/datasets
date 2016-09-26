import subprocess
import os
from timeit import default_timer
import sys

root = 'datasets/racket/'
datasets = os.listdir(root)

start_time = default_timer()

if len(sys.argv) >= 2:
    if sys.argv[1] != 'all':
        datasets = [sys.argv[1]]

os.chdir(root)
total_datasets = 0
for dataset in datasets:
    if not os.path.isdir(dataset):
        continue
    rkt_file = dataset+'.rkt'
    os.chdir(dataset)
    subprocess.call(["racket", "-t", rkt_file, "-m"])
    os.chdir('..')
    total_datasets += 1
    print "\n"
print("Total datasets: {}".format(total_datasets))
print("Time taken: {}".format(default_timer() - start_time))