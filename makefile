java:
	python builder/builder.py -l java specs/$(target).corgis ./datasets
sql:
	python builder/builder.py -l sql specs/$(target).corgis ./datasets
racket:
	python builder/builder.py -l racket specs/$(target).corgis ./datasets
python:
	C:/Users/acbart/anaconda3/python.exe builder/builder.py -l python specs/$(target).corgis ./datasets
all:
	python builder/builder.py -l python -a specs/ ./datasets
all_fast:
	python builder/builder.py -l python --all --fast specs/ ./datasets
test:
	python test.py
index:
	python datasets/python/build_index.py