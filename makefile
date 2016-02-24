build:
	python builder/builder.py -l python specs/$(target).corgis ./datasets
all:
	python builder/builder.py -l python -a specs/ ./datasets
all_fast:
	python builder/builder.py -l python --all --fast specs/ ./datasets
test:
	python test.py
index:
	python datasets/python/build_index.py