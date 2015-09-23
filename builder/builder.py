import sqlite3
import os

VERSION_INFORMATION = dict(version=1, builder='Python', author='acbart', datetime='9/23/2015')

def new(name, directory):
    filename = os.path.join(directory, name+".sql")
    # Delete any existing files
    if os.path.exists:
        print("File already exists, deleting!")
        os.remove(filename)
    connection = sqlite3.connect(filename)
    cursor = connection.cursor()
    
    # All CORGIS datasets have a version table
    cursor.execute('''CREATE TABLE version
                         (version integer, builder text, author text, datetime text)''')
    cursor.execute('''INSERT INTO version
                         (version, builder, author, datetime)
                         VALUES (?, ?, ?, ?) ''',
                         (VERSION_INFORMATION['version'],
                         VERSION_INFORMATION['builder'],
                         VERSION_INFORMATION['author'],
                         VERSION_INFORMATION['datetime']))
    connection.commit()
    # And a list of commands
    
def view(name, directory):
    filename = os.path.join(directory, name+".sql")
    connection = sqlite3.connect(filename)
    cursor = connection.cursor()
    
    # Initiliaze the return object
    result = {}
    
    # Get the version information
    cursor.execute('''SELECT version, builder, author, datetime FROM version''')
    version, builder, author, datetime = cursor.fetchone()
    result['version'] = dict(version=version, 
                             builder=builder, 
                             author=author, 
                             datetime=datetime)
    
    # And return
    return result