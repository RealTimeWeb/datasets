import json
import csv
import os
import re
import sys
from pprint import pprint
from tqdm import tqdm
from collections import Counter
from states import reverse_map
from corrected import corrected

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
    
def parse_range(line):
    line = clean_data(line)
    return {
        'Verbal': {
            'Males': line[0] if len(line) > 0 else 0,
            'Females': line[1] if len(line) > 1 else 0,
            'Total': line[2] if len(line) > 2 else 0
        },
        'Math': {
            'Males': line[6] if len(line) > 6 else 0,
            'Females': line[7] if len(line) > 7 else 0,
            'Total': line[8] if len(line) > 8 else 0
        },
    }
def parse_alt_range(line):
    line = clean_data(line)
    return {
        'Verbal': {
            'Males': line[0] if len(line) > 0 else 0,
            'Females': line[1] if len(line) > 1 else 0,
            'Total': line[2] if len(line) > 2 else 0
        },
        'Math': {
            'Males': line[3] if len(line) > 3 else 0,
            'Females': line[4] if len(line) > 4 else 0,
            'Total': line[5] if len(line) > 5 else 0
        },
    }
def combine_range(*dicts):
    return {
        'Verbal': {
            'Males': sum(d['Verbal']['Males'] for d in dicts),
            'Females': sum(d['Verbal']['Females'] for d in dicts),
            'Total': sum(d['Verbal']['Total'] for d in dicts)
        },
        'Math': {
            'Males': sum(d['Math']['Males'] for d in dicts),
            'Females': sum(d['Math']['Females'] for d in dicts),
            'Total': sum(d['Math']['Total'] for d in dicts)
        },
    }
    
def clean_data(list_of_numbers, converter=parse_int):
    return [converter(i)
            for l in list_of_numbers[1:]
            for i in l.split() ]

all_data = []
for path, lines in ones.items():
    state, year = path[5:-4].split("_")
    code_name = reverse_map[state]
    data = {
        'Year': '20'+year,
        'State': {
            'Name': state.title(),
            'Code': code_name.upper()
        }
    }
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
    # 05 Ranges
    line_iter = iter(lines)
    grade_point_average = seek(line_iter, "TABLE 6")
    grade_point_average = seek(line_iter, "Ranges")
    data["Score Ranges"] = {
        "Between 700 to 800": combine_range(parse_range(next(line_iter)), parse_range(next(line_iter))),
        "Between 600 to 700": combine_range(parse_range(next(line_iter)), parse_range(next(line_iter))),
        "Between 500 to 600": combine_range(parse_range(next(line_iter)), parse_range(next(line_iter))),
        "Between 400 to 500": combine_range(parse_range(next(line_iter)), parse_range(next(line_iter))),
        "Between 300 to 400": combine_range(parse_range(next(line_iter)), parse_range(next(line_iter))),
        "Between 200 to 300": combine_range(parse_range(next(line_iter)), parse_range(next(line_iter))),
    }
    # Gender
    totals = clean_data(next(line_iter))
    means = clean_data(next(line_iter))
    data["Gender"] = {
        "Male": {
            "Verbal": means[0],
            "Math": means[3],
            "Test-takers": totals[0]
        },
        "Female": {
            "Verbal": means[1],
            "Math": means[4],
            "Test-takers": totals[1]
        }
    }
    data["Total"] = {
        "Verbal": means[2],
        "Math": means[5],
        "Test-takers": totals[2]
    }
    #total_number_of_students = clean_data(next(line_iter))
    #data["Gender"]["Male"]["Test-takers"] = total_number_of_students[0]
    #data["Gender"]["Female"]["Test-takers"] = total_number_of_students[1]
    #data["Total"]["Test-takers"] = total_number_of_students[2]
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
    all_data.append(data)
    
for path, lines in sixes.items():
    state, year = path[5:-4].split("_")
    code_name = reverse_map[state]
    data = {
        'Year': '20'+year,
        'State': {
            'Name': state.title(),
            'Code': code_name.upper()
        }
    }
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
    # Gender
    line_iter = iter(lines)
    try:
        row = seek(line_iter, 'Male')
        male = clean_data(row)
        female = clean_data(next(line_iter))
        data["Gender"] = {
            "Male": {
                "Verbal": male[1],
                "Math": male[3],
                "Test-takers": male[0]
            },
            "Female": {
                "Verbal": female[1],
                "Math": female[3],
                "Test-takers": female[0]
            }
        }
        data["Total"] = {
            "Verbal": avg((data["Gender"]["Female"]["Verbal"], data["Gender"]["Male"]["Verbal"])),
            "Math": avg((data["Gender"]["Female"]["Math"], data["Gender"]["Male"]["Math"])),
            "Test-takers": data["Gender"]["Female"]["Test-takers"] + data["Gender"]["Male"]["Test-takers"]
        }
    except Exception as e:
        #print(e)
        data["Gender"] = corrected[(year, state)]["Gender"]
        data["Total"] = corrected[(year, state)]["Total"]
        print state, year
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
    # 05 Ranges
    line_iter = iter(lines)
    grade_point_average = seek(line_iter, "Score Range")
    data["Score Ranges"] = {
        "Between 700 to 800": combine_range(parse_alt_range(next(line_iter)), parse_alt_range(next(line_iter))),
        "Between 600 to 700": combine_range(parse_alt_range(next(line_iter)), parse_alt_range(next(line_iter))),
        "Between 500 to 600": combine_range(parse_alt_range(next(line_iter)), parse_alt_range(next(line_iter))),
        "Between 400 to 500": combine_range(parse_alt_range(next(line_iter)), parse_alt_range(next(line_iter))),
        "Between 300 to 400": combine_range(parse_alt_range(next(line_iter)), parse_alt_range(next(line_iter))),
        "Between 200 to 300": combine_range(parse_alt_range(next(line_iter)), parse_alt_range(next(line_iter))),
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
    all_data.append(data)
    
for path, lines in tens.items():
    state, year = path[5:-4].split("_")
    code_name = reverse_map[state]
    data = {
        'Year': '20'+year,
        'State': {
            'Name': state.title(),
            'Code': code_name.upper()
        }
    }
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
    # 05 Ranges
    line_iter = iter(lines)
    grade_point_average = seek(line_iter, "Score Range")
    data["Score Ranges"] = {
        "Between 700 to 800": parse_alt_range(next(line_iter)),
        "Between 600 to 700": parse_alt_range(next(line_iter)),
        "Between 500 to 600": parse_alt_range(next(line_iter)),
        "Between 400 to 500": parse_alt_range(next(line_iter)),
        "Between 300 to 400": parse_alt_range(next(line_iter)),
        "Between 200 to 300": parse_alt_range(next(line_iter))
    }
    # Gender
    line_iter = iter(lines)
    try:
        row = seek(line_iter, 'Male')
        male = clean_data(row)
        female = clean_data(next(line_iter))
        data["Gender"] = {
            "Male": {
                "Verbal": male[1],
                "Math": male[3],
                "Test-takers": male[0]
            },
            "Female": {
                "Verbal": female[1],
                "Math": female[3],
                "Test-takers": female[0]
            }
        }
        data["Total"] = {
            "Verbal": avg((data["Gender"]["Female"]["Verbal"], data["Gender"]["Male"]["Verbal"])),
            "Math": avg((data["Gender"]["Female"]["Math"], data["Gender"]["Male"]["Math"])),
            "Test-takers": data["Gender"]["Female"]["Test-takers"] + data["Gender"]["Male"]["Test-takers"]
        }
        print(data["Gender"]["Female"]["Verbal"])
    except Exception as e:
        #print(e)
        data["Gender"] = corrected[(year, state)]["Gender"]
        data["Total"] = corrected[(year, state)]["Total"]
        print state, year
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
    all_data.append(data)

all_data = list(sorted(all_data, key= lambda r: (r['Year'], r['State']['Name'])))
with open('school_scores.json', 'w') as output:
    json.dump(all_data, output, indent=2)