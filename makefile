java:
	python builder/builder.py -l java specs/$(target).corgis ./datasets
metrics:
	python builder/builder.py -l metrics specs/$(target).corgis ./datasets
sql:
	python builder/builder.py -l sql specs/$(target).corgis ./datasets
racket:
	python builder/builder.py -l racket specs/$(target).corgis ./datasets
visualizer:
	python builder/builder.py -l visualizer specs/$(target).corgis ./datasets
python:
	python builder/builder.py -l python specs/$(target).corgis ./datasets
all:
	python builder/builder.py -l python -a specs/ ./datasets
all_metrics:
	python builder/builder.py -l metrics -a specs/ ./datasets
all_fast:
	python builder/builder.py -l python --all --fast specs/ ./datasets
test:
	python test.py $(target)
python_test:
	python builder/builder.py -l python specs/$(target).corgis ./datasets
	python test.py $(target)
index:
	python datasets/python/build_index.py
latex_index:
	python datasets/metrics/build_latex_index.py