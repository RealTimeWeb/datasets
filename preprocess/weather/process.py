'''

Data is National Weather Service's QCLCD
https://www.ncdc.noaa.gov/orders/qclcd/


'''

import os
import urllib
import urllib.request
import zipfile
import pandas
try:
    import tqdm
except ImportError:
    tqdm = list

def get_file(files, ending):
    for file in files:
        if file.endswith(ending+'.txt'):
            return file

def process_station(data):
    df = pandas.read_table(data, sep='|')
    print(df)

years = range(2016, 2017)

## Download zip files
for year in years:
    for month in range(1, 13):
        filename = 'QCLCD{year}{month:02d}.zip'.format(year=year, month=month)
        path = 'raw/'+filename
        if not os.path.exists(path):
            url = 'https://www.ncdc.noaa.gov/orders/qclcd/'+filename
            print(url)
            urllib.request.urlretrieve(url, path)
        with zipfile.ZipFile(path) as qlcd_zip:
            files = qlcd_zip.namelist()
            with qlcd_zip.open(get_file(files, 'station')) as station_file:
                print(process_station(station_file))
                
        break
    break