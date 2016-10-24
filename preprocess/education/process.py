import json
import csv
import os
import re
import sys
from pprint import pprint
from tqdm import tqdm
from collections import Counter

def parse_int(val):
    try:
        return int(val.replace(',', ''))
    except ValueError:
        return 0
def parse_float(val):
    try:
        return float(val.replace(',', ''))
    except ValueError:
        return 0.0

def seek(iterator, key, position=0):
    while True:
        try:
            line = next(iterator)
        except StopIteration:
            break
        if position < len(line):
            if re.match(key, line[position]):
                return line
    raise Exception("Key not found in seek! '{}'".format(key))

ones = {}
sixes = {}
tens = {}
paths = os.listdir('csvs/')
for csv_path in tqdm(paths):
    csv_path = 'csvs/'+csv_path
    with open(csv_path, 'r') as csv_file:
        csv_reader = csv.reader(csv_file)
        lines = [line for line in csv_reader]
        if len(lines[0]) == 1:
            ones[csv_path] = lines
        elif len(lines[0]) == 6:
            sixes[csv_path] = lines
        else:
            tens[csv_path] = lines
    
def avg(a_list):
    l = list(a_list)
    return int(round(sum(l) / len(l)))
    
def parse_one_family_income(line):
    line = clean_data(line)
    return {
        'Test-takers': line[0] if len(line) > 0 else 0,
        'Verbal': line[4] if len(line) > 4 else 0,
        'Math': line[6] if len(line) > 6 else 0
    }
def parse_clean_family_income(line):
    line = clean_data(line)
    return {
        'Test-takers': line[0] if len(line) > 0 else 0,
        'Verbal': line[2] if len(line) > 2 else 0,
        'Math': line[4] if len(line) > 4 else 0
    }
def combine_family_income(*dicts):
    return {
        'Test-takers': sum(d['Test-takers'] for d in dicts),
        'Math': avg(d['Math'] for d in dicts),
        'Verbal': avg(d['Verbal'] for d in dicts),
    }
    
def parse_gpa(line):
    line = clean_data(line)
    return {
        'Test-takers': line[0] if len(line) > 0 else 0,
        'Verbal': line[4] if len(line) > 4 else 0,
        'Math': line[5] if len(line) > 5 else 0
    }
    
def parse_academics(line):
    line = clean_data(line, converter=parse_float)
    return {
        'Average Years': line[2] if len(line) > 2 else 0,
        'Average GPA': line[5] if len(line) > 5 else 0
    }
    
def clean_data(list_of_numbers, converter=parse_int):
    return [converter(i)
            for l in list_of_numbers[1:]
            for i in l.split() ]

all_data = []
for path, lines in ones.items():
    state, year = path[5:-4].split("_")
    print(state, year)
    data = {}
    # 05 High School Grade Point Average
    line_iter = iter(lines)
    grade_point_average = seek(line_iter, "High School Grade Point Average")
    data["GPA"] = {
        "A plus": parse_gpa(next(line_iter)),
        "A": parse_gpa(next(line_iter)),
        "A minus": parse_gpa(next(line_iter)),
        "B": parse_gpa(next(line_iter)),
        "C": parse_gpa(next(line_iter)),
        "D or lower": parse_gpa(next(line_iter)),
        "No response": parse_gpa(next(line_iter)),
    }
    # 05 Academic Subject
    line_iter = iter(lines)
    grade_point_average = seek(line_iter, "Academic Subject")
    data["Academic Subjects"] = {
        "Arts/Music": parse_academics(next(line_iter)),
        "English": parse_academics(next(line_iter)),
        "Foreign Languages": parse_academics(next(line_iter)),
        "Mathematics": parse_academics(next(line_iter)),
        "Natural Sciences": parse_academics(next(line_iter)),
        "Social Sciences/History": parse_academics(next(line_iter)),
    }
    # 05 Family Income
    line_iter = iter(lines)
    family_income = seek(line_iter, "Family Income")
    data["Family Income"] = {
        "Less than 20k": combine_family_income(parse_one_family_income(next(line_iter)), 
                                                   parse_one_family_income(next(line_iter))),
        "Between 20-40k": combine_family_income(parse_one_family_income(next(line_iter)), 
                                                   parse_one_family_income(next(line_iter))),
        "Between 40-60k": combine_family_income(parse_one_family_income(next(line_iter)), 
                                                   parse_one_family_income(next(line_iter))),
        "Between 60-80k":combine_family_income(parse_one_family_income(next(line_iter)), 
                                                   parse_one_family_income(next(line_iter))),
        "Between 80-100k": parse_one_family_income(next(line_iter)),
        "More than 100k": parse_one_family_income(next(line_iter))
    }
    
for path, lines in sixes.items():
    state, year = path[5:-4].split("_")
    print(state, year)
    data = {}
    # 05 High School Grade Point Average
    line_iter = iter(lines)
    grade_point_average = seek(line_iter, "Table 1\d: High School Grade Point Average")
    next(line_iter)
    next(line_iter)
    data["GPA"] = {
        "A plus": parse_gpa(next(line_iter)),
        "A": parse_gpa(next(line_iter)),
        "A minus": parse_gpa(next(line_iter)),
        "B": parse_gpa(next(line_iter)),
        "C": parse_gpa(next(line_iter)),
        "D or lower": parse_gpa(next(line_iter)),
        "No response": parse_gpa(next(line_iter)),
    }
    # 05 Academic Subject
    line_iter = iter(lines)
    grade_point_average = seek(line_iter, "Table 1\d: Average Years of Study in Six Academic Subjects")
    next(line_iter)
    next(line_iter)
    data["Academic Subjects"] = {
        "Arts/Music": parse_academics(next(line_iter)),
        "English": parse_academics(next(line_iter)),
        "Foreign Languages": parse_academics(next(line_iter)),
        "Mathematics": parse_academics(next(line_iter)),
        "Natural Sciences": parse_academics(next(line_iter)),
        "Social Sciences/History": parse_academics(next(line_iter)),
    }
    # 06 Family Income
    line_iter = iter(lines)
    family_income = seek(line_iter, "Family Income")
    data["Family Income"] = {
        "Less than 20k": combine_family_income(parse_clean_family_income(next(line_iter)), 
                                                   parse_clean_family_income(next(line_iter))),
        "Between 20-40k": combine_family_income(parse_clean_family_income(next(line_iter)), 
                                                   parse_clean_family_income(next(line_iter))),
        "Between 40-60k": combine_family_income(parse_clean_family_income(next(line_iter)), 
                                                   parse_clean_family_income(next(line_iter))),
        "Between 60-80k":combine_family_income(parse_clean_family_income(next(line_iter)), 
                                                   parse_clean_family_income(next(line_iter))),
        "Between 80-100k": parse_clean_family_income(next(line_iter)),
        "More than 100k": parse_clean_family_income(next(line_iter))
    }
    
for path, lines in tens.items():
    state, year = path[5:-4].split("_")
    print(state, year)
    data = {}
    # 05 High School Grade Point Average
    line_iter = iter(lines)
    grade_point_average = seek(line_iter, "Table 1\d: High School Grade Point Average")
    next(line_iter)
    next(line_iter)
    data["GPA"] = {
        "A plus": parse_gpa(next(line_iter)),
        "A": parse_gpa(next(line_iter)),
        "A minus": parse_gpa(next(line_iter)),
        "B": parse_gpa(next(line_iter)),
        "C": parse_gpa(next(line_iter)),
        "D or lower": parse_gpa(next(line_iter)),
        "No response": parse_gpa(next(line_iter)),
    }
    # 05 Academic Subject
    line_iter = iter(lines)
    grade_point_average = seek(line_iter, "Table 1\d: Average Years of Study in Six Academic Subjects")
    next(line_iter)
    next(line_iter)
    data["Academic Subjects"] = {
        "Arts/Music": parse_academics(next(line_iter)),
        "English": parse_academics(next(line_iter)),
        "Foreign Languages": parse_academics(next(line_iter)),
        "Mathematics": parse_academics(next(line_iter)),
        "Natural Sciences": parse_academics(next(line_iter)),
        "Social Sciences/History": parse_academics(next(line_iter)),
    }
    # 10 Family Income
    line_iter = iter(lines)
    family_income = seek(line_iter, "Family Income")
    data["Family Income"] = {
        "Less than 20k": parse_clean_family_income(next(line_iter)),
        "Between 20-40k": parse_clean_family_income(next(line_iter)),
        "Between 40-60k": parse_clean_family_income(next(line_iter)),
        "Between 60-80k": parse_clean_family_income(next(line_iter)),
        "Between 80-100k": parse_clean_family_income(next(line_iter)),
        "More than 100k": combine_family_income(parse_clean_family_income(next(line_iter)),
                                                parse_clean_family_income(next(line_iter)),
                                                parse_clean_family_income(next(line_iter)),
                                                parse_clean_family_income(next(line_iter)),
                                                parse_clean_family_income(next(line_iter)))
    }