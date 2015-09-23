from __future__ import print_function
'''
This is the Python version of the Builder. It is distinct from the web-based interface.
'''

import argparse


def parse_extra (parser, namespace):
    '''
    Takes an extra attribute from the global namespace and reparses it
    to create a separate namespace for any chained commands.
    
    Source: http://stackoverflow.com/a/10579924/1718155
    '''
    namespaces = []
    extra = namespace.extra
    while extra:
        n = parser.parse_args(extra)
        extra = n.extra
        namespaces.append(n)
    return namespaces

arg_parser = argparse.ArgumentParser()
arg_parser.add_argument('-d', '--directory', dest='directory', action='store',
                      default='.', help='The working directory of datasets')
subparsers = arg_parser.add_subparsers(help='The list of potential commands', 
                                       dest='command')
# "new" Parser
parser_new = subparsers.add_parser('new', help = "New Dataset help")
parser_new.add_argument('name', action='store', help='The name of the new dataset')

# "view" Parser
parser_view = subparsers.add_parser('view', help = "View Dataset help")
parser_view.add_argument('name', action='store', help='The name of the dataset to view')

# "edit" Parser
parser_edit = subparsers.add_parser('edit', help = "Editing a dataset help")

arg_parser.add_argument('extra', nargs = "*", help = 'Internal command')

namespace = arg_parser.parse_args()
extra_namespaces = parse_extra(arg_parser, namespace)

import builder
if namespace.command == 'new':
    builder.new(namespace.name, namespace.directory)
elif namespace.command == 'view':
    information = builder.view(namespace.name, namespace.directory)
    print("-- Header --")
    for field, value in information['version'].items():
        print("\t", "{}:".format(field), value)
else:
    raise Exception("Command not implemented");