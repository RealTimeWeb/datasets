import json

weather_file = open("weather.json")
weather_data = json.load(weather_file)
weather_file.close()