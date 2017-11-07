
import earthquakes
import matplotlib.pyplot as plt

list_of_quakes = earthquakes.get_earthquakes()
depths = []
magnitudes = []
for quake in list_of_quakes:
    depths.append(quake["location"]["depth"])
    magnitudes.append(quake["impact"]["magnitude"])
    
# How do I add a legend?
plt.plot(depths, label="Depths")
plt.plot(magnitudes, label="Magnitudes")
plt.legend()
plt.show()
