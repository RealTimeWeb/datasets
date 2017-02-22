import pandas as pd
import json
from collections import Counter
from tqdm import tqdm
from pprint import pprint
import math
from educ_codes import educ_codes,group_mapper,major_groups

'''
Data files downloaded from
    https://ncsesdata.nsf.gov/datadownload/
    Use the "Survey of College Graduates" files
Extract out all of the XPT files and rename to "{Year}.xpt"
'''

YEARS = [1993, 1995, 1997, 1999, 2001, 2003, 2006, 2008, 2010, 2013, 2015]

def count_keys():
    codebook = {}
    with open('labels.tsv') as inp:
        for line in inp:
            code, length, format, start, end, type, label = line.strip().split("\t")
            codebook[code] = (type, label)
    format_book = {}
    with open('formats.tsv') as inp:
        for line in inp:
            code, actual_format = line.strip().split("\t")
            format_book[code] = actual_format

    counts = {}
    for year in tqdm(YEARS):
        filename = '{year}.xpt'.format(year=year)
        df = pd.read_sas(filename)
        for c in df.columns:
            if c not in counts:
                counts[c] = []
            counts[c].append(year)
    for k, v in sorted(counts.items(), key=lambda r: len(r[1])):
        print(k, len(v), format_book.get(k, ''), v, *codebook.get(k, ('', '')))
#count_keys()

def r(a_val):
    return int(round(a_val))
    
def nonan(a_val):
    if math.isnan(a_val):
        print("NAN")
        return 0
    return a_val
        
def get_column(df, *columns):
    for c in columns:
        if c in df:
            return c
    df[c]
    # raise keyerror
        
def build():
    all_results = []
    for year in tqdm(YEARS): #YEARS:
        filename = '{year}.xpt'.format(year=year)
        #df = next(pd.read_sas(filename, encoding='ascii', chunksize=100))
        df = pd.read_sas(filename, encoding='ascii')
        bamed = get_column(df, "BAMEDP", "NBAMEDP", "NBAMED")
        df = df[df[bamed] < '990009']
        df[bamed] = df[bamed].map(educ_codes).map(group_mapper)
        full_total = df[bamed].count()
        
        c_wt = get_column(df, 'WTSURVY', 'WEIGHT')
        remaining_majors = set(major_groups.keys())
        
        for major_id, g in df.groupby(bamed):
            result = {'Year': year, 
                      'Education': {
                        'Major': major_id,
                      }
                     }
            remaining_majors.remove(major_id)
            
            result['Demographics'] = {
                'Total': r(g[c_wt].sum()),
                'Gender': {
                    'Males': r(g[g['GENDER'] == 'M'][c_wt].sum()),
                    'Females': r(g[g['GENDER'] == 'F'][c_wt].sum())
                }
            }
            
            c_salary = get_column(df, "SALARP", "SALARY")
            salaries = g[(g[c_salary] != 9999998.0) & (g[c_salary] != 999998.0)][c_salary].dropna()
            stdev = round(float(salaries.std()), 2)
            result['Salaries'] = {
                'Mean': nonan(round(float(salaries.mean()), 2)),
                'Median': nonan(round(float(salaries.median()), 2)),
                'Quantity': nonan(int(salaries.count())),
                'Standard Deviation': nonan(stdev),
                'Highest': nonan(round(float(salaries.max()), 2)),
                'Lowest': nonan(round(float(salaries.min()), 2))
            }
            
            c_race = get_column(df, 'RACETHP', 'RACETHMP', 'RACETHM')
            if c_race == 'RACETHP':
                whites = g[g[c_race] == '2'][c_wt].sum()
                asians = g[g[c_race] == '4'][c_wt].sum()
                minority = g[g[c_race] == '7'][c_wt].sum()
            elif c_race == 'RACETHMP':
                whites = g[g[c_race] == '5'][c_wt].sum()
                asians = g[g[c_race] == '1'][c_wt].sum()
                minority = g[g[c_race] == '7'][c_wt].sum()
            elif c_race == 'RACETHM':
                whites = g[g[c_race] == '5'][c_wt].sum()
                asians = g[g[c_race] == '1'][c_wt].sum()
                minority = g[g[c_race].isin(['2', '3','4','6','7'])][c_wt].sum()
            result['Demographics']['Ethnicity']= {
                'Whites': r(whites),
                'Asians': r(asians),
                'Minorities': r(minority)
            }
            
            result['Education']['Degrees'] = {
                'Bachelors': g[g['DGRDG'] == '1'][c_wt].sum(),
                'Masters': g[g['DGRDG'] == '2'][c_wt].sum(),
                'Doctorates': g[g['DGRDG'] == '3'][c_wt].sum(),
                'Professionals': g[g['DGRDG'] == '4'][c_wt].sum()
            }
            for deg_type, v in result['Education']['Degrees'].items():
                result['Education']['Degrees'][deg_type] = r(v)
            
            result['Employment'] = {}
            result['Employment']['Work Activity']= {
                'Accounting/Finance/Contracts': g[g['WAACC'] == 'Y'][c_wt].sum(),
                'Applied Research': g[g['WAAPRSH'] == 'Y'][c_wt].sum(),
                'Basic Research': g[g['WABRSH'] == 'Y'][c_wt].sum(),
                'Computer Applications': g[g['WACOM'] == 'Y'][c_wt].sum(),
                'Development': g[g['WADEV'] == 'Y'][c_wt].sum(),
                'Design': g[g['WADSN'] == 'Y'][c_wt].sum(),
                'Human Resources': g[g['WAEMRL'] == 'Y'][c_wt].sum(),
                'Managing/Supervising People/Projects': g[g['WAMGMT'] == 'Y'][c_wt].sum(),
                'Other': g[g['WAOT'] == 'Y'][c_wt].sum(),
                'Productions/Operations/Maintenance': g[g['WAPROD'] == 'Y'][c_wt].sum(),
                'Qualitity/Productivity Management': g[g['WAQM'] == 'Y'][c_wt].sum(),
                'Sales, Purchasing, Marketing': g[g['WASALE'] == 'Y'][c_wt].sum(),
                'Professional Service': g[g['WASVC'] == 'Y'][c_wt].sum(),
                'Teaching': g[g['WATEA'] == 'Y'][c_wt].sum(),
            }
            
            result['Employment']['Status'] = {
                'Employed': g[g['LFSTAT'] == '1'][c_wt].sum(),
                'Unemployed': g[g['LFSTAT'] == '2'][c_wt].sum(),
                'Not in Labor Force': g[g['LFSTAT'] == '3'][c_wt].sum()
            }
            
            c_emptype = get_column(df, 'EMSECPB', 'EMSECSM')
            if c_emptype == 'EMSECPB':
                result['Employment']['Employer Type'] = {
                    'Educational Institution': g[g[c_emptype].isin(['1', '2'])][c_wt].sum(),
                    'Government': g[g[c_emptype] == '3'][c_wt].sum(),
                    'Business/Industry': g[g[c_emptype] == '4'][c_wt].sum()
                }
            else:
                result['Employment']['Employer Type'] = {
                    'Educational Institution': g[g[c_emptype] == '1'][c_wt].sum(),
                    'Government': g[g[c_emptype] == '2'][c_wt].sum(),
                    'Business/Industry': g[g[c_emptype] == '3'][c_wt].sum()
                }
                
            result['Employment']['Reason for Not Working'] = {
                'Family': g[g['NWFAM'] == 'Y'][c_wt].sum(),
                'Layoff': g[g['NWLAY'] == 'Y'][c_wt].sum(),
                'No need/want': g[g['NWNOND'] == 'Y'][c_wt].sum(),
                'No Job Available': g[g['NWOCNA'] == 'Y'][c_wt].sum(),
                'Student': g[g['NWSTU'] == 'Y'][c_wt].sum(),
            }
            
            result['Employment']['Reason Working Outside Field'] = {
                'Career Change': g[g['NRCHG'] == 'Y'][c_wt].sum(),
                'Working Conditions': g[g['NRCON'] == 'Y'][c_wt].sum(),
                'Family-related': g[g['NRFAM'] == 'Y'][c_wt].sum(),
                'Job Location': g[g['NRLOC'] == 'Y'][c_wt].sum(),
                'No Job Available': g[g['NROCNA'] == 'Y'][c_wt].sum(),
                'Other': g[g['NROT'] == 'Y'][c_wt].sum(),
                'Pay/Promotion': g[g['NRPAY'] == 'Y'][c_wt].sum(),
            }
            
            for subcat, subcat_vs in result['Employment'].items():
                for cat, cat_v in subcat_vs.items():
                    result['Employment'][subcat][cat] = r(cat_v)
            all_results.append(result)
        for major in remaining_majors:
            all_results.append({
                'Year': year,
                'Education': {
                    'Major': major,
                    'Degrees': {
                        'Bachelors': 0,
                        'Doctorates': 0,
                        'Masters': 0,
                        'Professionals': 0
                    }
                },
                'Salaries': {
                    'Mean': 0,
                    'Median': 0,
                    'Quantity': 0,
                    'Standard Deviation': 0,
                    'Highest': 0,
                    'Lowest': 0
                },
                'Demographics': {
                    'Total': 0,
                    'Gender': { 'Females': 0, 'Males': 0 },
                    'Ethnicity': {'Asians': 0, 'Minorities': 0, 'Whites': 0}
                },
                'Employment': {
                    'Employer Type': {
                        'Business/Industry': 0,
                        'Educational Institution': 0,
                        'Government': 0
                    },
                   'Reason Working Outside Field': {'Career Change': 0,
                                                    'Family-related': 0,
                                                    'Job Location': 0,
                                                    'No Job Available': 0,
                                                    'Other': 0,
                                                    'Pay/Promotion': 0,
                                                    'Working Conditions': 0},
                   'Reason for Not Working': {'Family': 0,
                                              'Layoff': 0,
                                              'No Job Available': 0,
                                              'No need/want': 0,
                                              'Student': 0},
                   'Status': {'Employed': 0,
                              'Not in Labor Force': 0,
                              'Unemployed': 0},
                   'Work Activity': {'Accounting/Finance/Contracts': 0,
                                     'Applied Research': 0,
                                     'Basic Research': 0,
                                     'Computer Applications': 0,
                                     'Design': 0,
                                     'Development': 0,
                                     'Human Resources': 0,
                                     'Managing/Supervising People/Projects': 0,
                                     'Other': 0,
                                     'Productions/Operations/Maintenance': 0,
                                     'Professional Service': 0,
                                     'Qualitity/Productivity Management': 0,
                                     'Sales, Purchasing, Marketing': 0,
                                     'Teaching': 0}
                }
            })
            
            #print(major_id, employed, unemployed, not_in_labor_force)
            #if major_id not in counts:
            #    counts[major_id] = []
            #counts[major_id].append("{}/{}".format(year, total))
            #print(salaries.mean(), salaries.median(), salaries.max(), salaries.min())
    #for k, v in sorted(counts.items(), key=lambda r: (len(r[1]), r[0])):
    #    print(len(v), k, v)
        #print(df.head())
    with open('graduates.json', 'w') as out:
        json.dump(all_results, out, indent=2)
build()

'''
Major - BAMEDP or NBAMEDP or NBAMED
Survey Year
Number of Total number of people with this major in this year
Gender
    
Salary (SALARY)
    SALARP if available, otherwise SALARY
    
    Median
        Male
        Female
        Total
    Mean
        Male
        Female
        Total
    Min
        Male
        Female
        Total
    Max
        Male
        Female
        Total
Employment LFSTAT
    Number employed
        Male
        Females
        Total
    Unemployed
        Male
        Females
        Total
        
ethnicity
    RACETHP or RACETHM
    asian
    hispanic
    black
    american indian
    hawaiian
    

Highest Degree types DGRDG

Work Activity
    WAACC - Accounting/Finance/Contracts
    WAAPRSH - Applied Research
    WABRSH - Basic Research
    WACOM - computer applications
    WADEV - development
    WADSN - design
    WAEMRL - human resources
    WAMGMT - managing or supervising people/project
    WAOT - other
    WAPROD - productions/operations/maintenance
    WAQM - qualitity/productivity management
    WASALE - sales, purchasing, marketting
    WASVC - professional services
    WATEA - teaching

Employer sector
    EMSECPB or EMSECSM
    Summary codes
Reasons for not working
    NWFAM - family
    NWLAY - layoff
    NWNOND - no need/want
    NWOCNA - no job available
    NWSTU - student
    
Outside working
    NRCHG 11 $YESNO [1993, 1995, 1997, 1999, 2001, 2003, 2006, 2008, 2010, 2013, 2015] Character OUTSIDE_FIELD_CAREER_CHANGE
    NRCON 11 $YESNO [1993, 1995, 1997, 1999, 2001, 2003, 2006, 2008, 2010, 2013, 2015] Character OUTSIDE_FIELD_WORKING_COND
    NRFAM 11 $YESNO [1993, 1995, 1997, 1999, 2001, 2003, 2006, 2008, 2010, 2013, 2015] Character OUTSIDE_FIELD_FAMILY
    NRLOC 11 $YESNO [1993, 1995, 1997, 1999, 2001, 2003, 2006, 2008, 2010, 2013, 2015] Character OUTSIDE_FIELD_LOCATION
    NROCNA 11 $YESNO [1993, 1995, 1997, 1999, 2001, 2003, 2006, 2008, 2010, 2013, 2015] Character OUTSIDE_FIELD_NO_JOB_AVAIL
    NROT 11 $YESNO [1993, 1995, 1997, 1999, 2001, 2003, 2006, 2008, 2010, 2013, 2015] Character OUTSIDE_FIELD_OTHER
    NRPAY 11 $YESNO [1993, 1995, 1997, 1999, 2001, 2003, 2006, 2008, 2010, 2013, 2015] Character OUTSIDE_FIELD_PAY_PROMOTION
    NRREA 11 $OUTFLD [1993, 1995, 1997, 1999, 2001, 2003, 2006, 2008, 2010, 2013, 2015] Character OUTSIDE_FIELD_MOST_IMPORT
    

Education (mother)
Education (father)
Children
    Yes CHUN12
    No 
citizen
    CTZUSIN
    Yes/no
    
Unused because of lack of time consistency
------------------------------------------
#Married
#    MARSTA
#Hours per week worked
# Satisfaction
    # SATADV - Opportunities for advancement
    # SATBEN - job benefits
    # SATCHAL - intellectual challenge
    # SATIND - degree of independence
    # SATLOC - job location
    # SATRESP - level of responsibility
    # SATSAL - job salary
    # SATSEC - job security
    # SATSOC - contribution to society
#Borrowed
#    UGLOANR - amount borrowed
#    UGOWER - amount still owed

#Employer size
#Employer type

#job satisfaction
    #JOBSATIS
# Disabilities
    # Cognition
    # Hearing
    # Lifting
    # Seeing
    # Walking
    # None
# WKSLYR - number of weeks worked per year if less than 52 weeks WKSYR
# WKSWK - weeks per year bassi

    
#NWILL - illness (not 2006, 2008)
#NWOT - other
#NWRET - retired

'''
