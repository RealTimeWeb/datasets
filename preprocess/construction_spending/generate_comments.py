TIME = {
    'annual': "The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction).",
    'current': "The current data is the information for this month/year, not adjusted for seasonal variation."
}

CLASSIFICATIONS = {
    'private': "The private data represents projects undertaken by citizens, as opposed to the government.",
    'combined': "The combined data represents both privately and publicly funded projects.",
    'public': "The public data represents projects undertaken by the government, as opposed to private citizens."
}

CATEGORIES = {
    'amusement and recreation': "Amusement and recreation includes theme and amusement parks, sports, fitness, performance/meeting center, social centers, parks, camps, movie theaters, studios, and a host of other locations.",
    'commercial': "Commercial includes buildings and structures used by the retail, wholesale and selected service industries.",
    'communication': "Communication includes telephone, television, and radio, distribution and maintenance buildings and structures.",
    'conservation and development': "Conservation and development includes facilities constructed for dams/leevees, breakwaters/jettys, dredging, irrigation, mine reclamation, fish hatcheries and wetlands.",
    'educational': "Education includes preschool, primary, secondary, higher education, nursing schools, cosmetology and beauty schools, trade schools, military training facilities, schools for the handicapped, and modeling schools.",
    'health care': "Health Care includes hospitals, medical buildings, and special care.",
    'highway and street': "Highway and Street includes pavement, lighting, retaining walls, tunnels, bridges, tolls/weighs, maintenance buildings, and rest facilities.",
    'lodging': "Lodging includes hotels, motels, resort lodging, tourist courts and cabins, and similar facilities.",
    'manufacturing': "Manufacturing includes a wide variety of structures, including wood industries, paper industries, food/beverage/tobacco, textiles, printing, plastic, chemical, and much more.",
    'nonresidential': "A categorization including all of the other categories except total and residential.",
    'office': "Offices include financial, corporate, television, radio, and even manufacturing site offices.",
    'power': "Power includes electric, gas, and oil, and also includes distribution structures.",
    'public safety': "Public Safety includes correctional centers, police offices, fire and rescue.",
    'religious': "Religious includes houses of worship such as churches, chapels, mosques, and their auxiliary buildings.",
    'residential': "Residential Buildings are houses, townhouses, apartments, etc. for single families, multi-families, and improvements to existing properties.",
    'sewage and waste disposal': "This section includes sewage, dry waste, and waste water plants and line/pump stations.",
    'total construction': "This section is the total of all the other categories, and by extension the total of the residential and non-residential categories.",
    'transportation': "Transportation involves all the facilities related to air, land, and water travel.",
    'water supply': "Water Supply construction involves plants, wells, lines, pump stations, resevoirs, and tanks/towers."
}

with open('comments.txt', 'w') as output:
    for t, t_desc in TIME.items():
        for cl, cl_desc in CLASSIFICATIONS.items():
            for ca, ca_desc in CATEGORIES.items():
                key = 'construction_spending.[0].{}.{}.{}'.format(t, cl, ca)
                description = "{} {} {} All units are reported in millions of dollars.".format(ca_desc, t_desc, cl_desc)
                output.write('    "{key}": {description}\n'.format(key=key, description=description))