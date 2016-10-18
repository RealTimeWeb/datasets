import json
import csv
import os
import sys

for csv_path in os.listdir('csvs/'):
    csv_path = 'csvs/'+csv_path
    with open(csv_path, 'r') as csv_file:
        csv_reader = csv.reader(csv_file)
        lines = []
        for line in csv_reader:
            if line[0] == "":
                print("")
            print(line)
    sys.exit(0)