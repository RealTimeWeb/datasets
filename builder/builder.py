import argparse
import yaml
from pprint import pprint

# Builder specific
from compile import Compiler
from auxiliary import to_dict
from build import build_dir


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description="The main Builder tool")

    parser.add_argument('spec', help='Location of a spec file.')
    parser.add_argument('-l', '--language', help='The desired output language bindings. If not present, defaults to all known languages.')
    parser.add_argument('-v', '--validate', help='Only validates the spec, skips compilation.', action='store_true')
    parser.add_argument('target', help="Build output location.")

    args = parser.parse_args()
    
    with open(args.spec, 'r') as specification_file:
        specification = yaml.load(specification_file)
        pprint(specification)
        compiled, warnings, errors = Compiler(args.spec, specification).run()
        print("*"*10)
        for warning in warnings:
            print "Warning!", warning
        for error in errors:
            print "Error!", error
        print("*"*10)
        if args.language.lower() == "python":
            from languages.build_python import build_python
            files, moves = build_python(to_dict(compiled))
            build_data, build_errors = build_dir(files, moves, args.target)