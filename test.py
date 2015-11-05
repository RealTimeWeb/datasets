import subprocess
import os
from timeit import default_timer

root = 'datasets/python/'
datasets = os.listdir(root)

start_time = default_timer()

os.chdir(root)
total_datasets = 0
for dataset in datasets:
    python_file = dataset+'.py'
    html_file = dataset+'.html'
    os.chdir(dataset)
    subprocess.call(["python", python_file, "-t"])
    subprocess.call([r"C:\Users\acbart\Anaconda3\python.exe", python_file, "-t"])
    os.chdir('..')
    total_datasets += 1
print("Total datasets: {}".format(total_datasets))
print("Time taken: {}".format(default_timer() - start_time))