from build_python import build_python
from build_java import build_java
from build_racket import build_racket
from compile import compile_spec
from build import build_dir
from auxiliary import clean_json, to_dict
from validate import validate_spec
import json
import sys

def build_all(file_data, output=None):
    input = clean_json(json.loads(file_data.decode('ascii', 'ignore')))
    validation_warnings, validation_errors = validate_spec(input)
    build_data = ""
    build_errors = []
    if not validation_errors:
        new_package = compile_spec(input)
        files = {}
        files.update(build_python(to_dict(new_package)))
        files.update(build_java(to_dict(new_package)))
        files.update(build_racket(to_dict(new_package)))
        if output is None:
            build_data, build_errors = build_zip(files)
        else:
            build_data, build_errors = build_dir(files, output)
    return validation_warnings, validation_errors, build_data, build_errors

if __name__ == "__main__":
    with open(sys.argv[1], "rb") as file:
        file_data = file.read()
    warnings, validation_errors, build_data, build_errors = build_all(file_data, sys.argv[2])
    if warnings:
        print "Compile Warnings: ", "-"*10
        for warning in warnings:
            print "\t",warning
    if validation_errors:
        print "Compile Errors: ", "-"*10
        for error in validation_errors:
            print "\t",error
    else:
        print "Compilation successful!"
    if build_errors:
        print "Build Errors: ", "-"*10
        for error in build_errors:
            print "\t",error
    else:
        print "Build successful!"
