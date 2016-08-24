from __future__ import print_function

import argparse
import yaml
import glob

# Builder specific
from compile import Compiler
from auxiliary import to_dict
from build import build_dir
from languages.build_python import build_python
from languages.build_racket import build_racket
from languages.build_csv import build_csv
from languages.build_json import build_json
from languages.build_java import build_java, post_build
from languages.build_sql import build_sql
from languages.build_metrics import build_metrics
from languages.build_visualizer import build_visualizer
from languages.build_blockpy import build_blockpy
from languages.build_index import add_to_index, rebuild_index, reconstruct_index

try:
    from tqdm import tqdm
except ImportError:
    tqdm = list


if __name__ == '__main__':

    with open('blacklist.txt') as blacklist_file:
        blacklist = [item.strip() for item in blacklist_file.readlines()]
    
    parser = argparse.ArgumentParser(description="The main Builder tool")

    parser.add_argument('spec', 
                        help='Location of a spec file (or source directory with -a and -i).')
    parser.add_argument('-l', '--language', 
                        help='The desired output language bindings. If not present, defaults to all known languages.')
    parser.add_argument('-v', '--validate', 
                        help='Only validates the spec, skips compilation.', 
                        action='store_true')
    parser.add_argument('-f', '--fast', 
                        help='Only builds the supporting files, skips database building.', 
                        action='store_true')
    parser.add_argument('-a', '--all',
                        help='Builds all .corgis files in the source directory.',
                        action='store_true')
    parser.add_argument('-p', '--prevent',
                        help='Prevents rebuilding the index.',
                        action='store_true')
    parser.add_argument('-i', '--index',
                        help="Rebuilds the index from the filesystem",
                        action="store_true")
    parser.add_argument('target', help="Build output location.")

    args = parser.parse_args()

    if args.all:
        specs = glob.glob(args.spec+'*.corgis')
        specs = [spec for spec in specs if spec not in blacklist]
    elif args.index:
        specs= []
    else:
        specs = [args.spec]

    if args.index:
        reconstruct_index(args.target, args.spec)
        if not args.prevent:
            rebuild_index(args.target)
        
    for a_spec in tqdm(specs):
        with open(a_spec, 'r') as specification_file:
            specification = yaml.load(specification_file)
            # pprint(specification)
            compiled, warnings, errors = Compiler(a_spec, specification).run()
            # print("*"*10)
            if warnings:
                print("\tWarnings!")
                for warning in warnings:
                    print("\t\t", warning)
            if errors:
                print("\tErrors!")
                for error in errors:
                    print("\t\t", error)
            # print("*"*10)
            language_target = args.language.lower()
            compiled_dict = to_dict(compiled)
            if language_target == "python":
                files, moves = build_python(compiled_dict, args.fast)
            elif language_target == "csv":
                files, moves = build_csv(compiled_dict)
            elif language_target == "json":
                files, moves = build_json(compiled_dict)
            elif language_target == "racket":
                files, moves = build_racket(compiled_dict, args.fast)
            elif language_target == "java":
                files, moves = build_java(compiled_dict, args.fast)
            elif language_target == "sql":
                files, moves = build_sql(compiled_dict, args.fast)
            elif language_target == "metrics":
                files, moves = build_metrics(compiled_dict, args.fast)
            elif language_target == "visualizer":
                files, moves = build_visualizer(compiled_dict, args.fast)
            elif language_target == "blockpy":
                files, moves = build_blockpy(compiled_dict, args.fast)
            else:
                print("Unknown language target!")
                break
            build_data, build_errors = build_dir(files, moves, args.target)
            if build_errors:
                print("\tBuild Errors!")
                for error in build_errors:
                    print("\t\t", error)
            else:
                if language_target == 'java':
                    post_build(compiled_dict, files, moves, args.target)
                add_to_index(args.target, language_target, compiled)
            if not args.prevent:
                rebuild_index(args.target)
