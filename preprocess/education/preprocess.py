'''
PDF files were batch downloaded from 
    https://research.collegeboard.org/programs/sat/data/archived/cb-seniors-2015
Iterate through the years, and choose "College-bound Senior" when the second menu is available
Store all PDF files in pdfs/
'''

import json
import subprocess
import os
from states import state_map
import re


def extract_state(filename):
    # remove the PDF extension
    filename = filename[:-4]
    # Normalize the filenames by case and separator
    filename = filename.lower().replace('_', ' ').replace("-", ' ')
    state_name = None
    for potential_name in state_map.values():
        if filename.startswith(potential_name) or filename.endswith(potential_name):
            state_name = potential_name
            break
    else:
        for potential_name in state_map.keys():
            if filename.startswith(potential_name) or filename.endswith(potential_name):
                state_name = state_map[potential_name]
                break
    return state_name
    

time_pattern = re.compile(r'(?:20)?(\d\d)')
def extract_year(filename):
    # if a 4 digit number starting with a 20
    # else the first two numbers
    time_groups = time_pattern.search(filename)
    year = time_groups.group(1)
    return year


pdf_files = os.listdir('pdfs/')
for filename in pdf_files:
    state = extract_state(filename)
    year = extract_year(filename)
    if state is not None:
        input_name =  'pdfs/'+filename
        output_name = 'csvs/{state}_{year}.csv'.format(state=state, year=year)
        command = ["java", "-jar", "./tabula-0.9.1-jar-with-dependencies.jar", 
                    input_name, "-i", "-u", "-p", "all", "-g", 
                    "-o", output_name]
        subprocess.call(command)