java:
	python builder/builder.py -l java specs/$(target).corgis ./datasets
metrics:
	python builder/builder.py -l metrics specs/$(target).corgis ./datasets
sql:
	python builder/builder.py -l sql specs/$(target).corgis ./datasets
json:
	python builder/builder.py -l json specs/$(target).corgis ./datasets
csv:
	python builder/builder.py -l csv specs/$(target).corgis ./datasets
racket:
	python builder/builder.py -l racket specs/$(target).corgis ./datasets
visualizer:
	python builder/builder.py -l visualizer specs/$(target).corgis ./datasets
blockpy:
	python builder/builder.py -l blockpy specs/$(target).corgis ./datasets
python:
	python builder/builder.py -l python specs/$(target).corgis ./datasets
all:
	python builder/builder.py -l python -a specs/ ./datasets
all_java:
	python builder/builder.py -l java -a specs/ ./datasets
all_csv:
	python builder/builder.py -l csv -a specs/ ./datasets
all_json:
	python builder/builder.py -l json -a specs/ ./datasets
all_metrics:
	python builder/builder.py -l metrics -a specs/ ./datasets
all_fast:
	python builder/builder.py -l python --all --fast specs/ ./datasets
test:
	python test.py $(target)
test_java:
	python tests/java.py $(target)
python_test:
	python builder/builder.py -l python specs/$(target).corgis ./datasets
	python test.py $(target)
index:
	python builder/builder.py -i specs/ ./datasets
latex_index:
	python datasets/metrics/build_latex_index.py
infer_json:
	python infer_json.py specs/$(target)/$(target).json