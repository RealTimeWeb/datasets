import argparse
import yaml
from pprint import pprint

# Builder specific
from validate import validate_spec


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description="The main Builder tool")

    parser.add_argument('spec', help='Location of a spec file.')
    parser.add_argument('-l', '--language', help='The desired output language bindings. If not present, defaults to all known languages.')
    parser.add_argument('-v', '--validate', help='Only validates the spec, skips compilation.', action='store_true')

    args = parser.parse_args()
    
    with open(args.spec, 'r') as specification_file:
        specification = yaml.load(specification_file)
        pprint(specification)
        warnings, errors = validate_spec(specification)
        for warning in warnings:
            print "Warning!", warning
        for error in errors:
            print "Error!", error