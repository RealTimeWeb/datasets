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
all_racket:
	python builder/builder.py -l racket -a specs/ ./datasets
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
test_racket:
	python tests/test_racket.py $(target)
index:
	python builder/builder.py -i specs/ ./datasets
latex_index:
	python datasets/metrics/build_latex_index.py
infer_json:
	python infer_json.py specs/$(target)/$(target).json
print_comments:
	python print_comments.py specs/$(target)/$(target).json
all_visualizer:
	python builder/builder.py -l visualizer specs/airlines.corgis ./datasets
	python builder/builder.py -l visualizer specs/broadway.corgis ./datasets
	python builder/builder.py -l visualizer specs/classics.corgis ./datasets
	python builder/builder.py -l visualizer specs/construction_spending.corgis ./datasets
	python builder/builder.py -l visualizer specs/earthquakes.corgis ./datasets
	python builder/builder.py -l visualizer specs/global_development.corgis ./datasets
	python builder/builder.py -l visualizer specs/immigration.corgis ./datasets
	python builder/builder.py -l visualizer specs/publishers.corgis ./datasets
	python builder/builder.py -l visualizer specs/school_scores.corgis ./datasets
	python builder/builder.py -l visualizer specs/state_crime.corgis ./datasets
	python builder/builder.py -l visualizer specs/state_demographics.corgis ./datasets
	python builder/builder.py -l visualizer specs/tate.corgis ./datasets
	python builder/builder.py -l visualizer specs/weather.corgis ./datasets
all_blockpy:
	python builder/builder.py -l blockpy specs/airlines.corgis ./datasets
	python builder/builder.py -l blockpy specs/broadway.corgis ./datasets
	python builder/builder.py -l blockpy specs/classics.corgis ./datasets
	python builder/builder.py -l blockpy specs/construction_spending.corgis ./datasets
	python builder/builder.py -l blockpy specs/earthquakes.corgis ./datasets
	python builder/builder.py -l blockpy specs/global_development.corgis ./datasets
	python builder/builder.py -l blockpy specs/immigration.corgis ./datasets
	python builder/builder.py -l blockpy specs/publishers.corgis ./datasets
	python builder/builder.py -l blockpy specs/school_scores.corgis ./datasets
	python builder/builder.py -l blockpy specs/state_crime.corgis ./datasets
	python builder/builder.py -l blockpy specs/state_demographics.corgis ./datasets
	python builder/builder.py -l blockpy specs/tate.corgis ./datasets
	python builder/builder.py -l blockpy specs/weather.corgis ./datasets