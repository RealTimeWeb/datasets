# -*- coding: utf-8 -*-
"""
Created on Mon Nov  2 22:33:47 2015

@author: acbart
"""

import json

data = json.load(open('school_data.json'))

for state, s in data.items():
    s["attendance"] = {
        "average minutes": s["attendance"]["average_school_year_minutes"],
        "average student rate": s["attendance"]["average_student_attendance_rate"],
        "average teacher rate": s["attendance"]["average_teacher_attendance_rate"]
    }
    e = s['enrollment']
    s['enrollment'] = {
        'schools': e['total number of schools'],
        'staff': e['total staff'],
        'teachers': e['total teachers'],
        'student teacher ratio': e['pupil/teacher ratio'],
        'students': {
            'race': {
                'native american': e['total students- amer ind/ak native'],
                'asian': e['total students- asian/pacific islander'],
                'black': e['total students- black'],
                'hispanic': e['total students- hispanic'],
                'biracial': e['total students- two or more races'],
                'white': e['total students- white']
            },
            'gender': {
                'female': e['total, all grades- female'],
                'male': e['total, all grades- male']
            },
            'year': [
                e['prekindergarten students'],
                e['kindergarten students'],
                e['first grade students'],
                e['second grade students'],
                e['third grade students'],
                e['fourth grade students'],
                e['fifth grade students'],
                e['sixth grade students'],
                e['seventh grade students'],
                e['eighth grade students'],
                e['ninth grade students'],
                e['tenth grade students'],
                e['eleventh grade students'],
                e['twelfth grade students']
            ],
            'all': e['total students'],
            'other': {
                'free lunch eligible': e['free lunch eligible'],
                'lep/ell students': e['lep/ell students'],
                'reduced-price lunch eligible': e['reduced-price lunch eligible'],
                'individualized education program': e['individualized education program'],
                'ungraded students': e['ungraded students']
            }
        }
    }
    f = s['funding']
    s['funding'] = {
        'revenue': f['total revenues'],
        'expenditures': f['total expenditures for education']
    }
    g = s['score']
    s['score'] = {
        'math':[
            {"grade": 4, "scale score": g['scale score, grade 4 math']},
            {"grade": 8, "scale score": g['scale score, grade 8 math']}
        ],
        'reading':[
            {"grade": 4, "scale score": g['scale score, grade 4 reading']},
            {"grade": 8, "scale score": g['scale score, grade 8 reading']}
        ],
        'science':[
            {"grade": 4, "scale score": g['scale score, grade 4 science']},
            {"grade": 8, "scale score": g['scale score, grade 8 science']}
        ],
        'writing':[
            {"grade": 4, "scale score": g['scale score, grade 4 writing']},
            {"grade": 8, "scale score": g['scale score, grade 8 writing']}
        ],
    }

data = [{"data": v, "state": k} for k, v in sorted(data.items())]

json.dump(data, open("school.json", "w"))