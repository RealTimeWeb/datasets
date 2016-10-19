import earthquakes
import matplotlib.pyplot as plt 

# Get the data, put it in a property
list_of_earthquake = earthquakes.get_earthquakes()



# Calculate the three averages
china_total = 0
china_count = 0
peru_total = 0
peru_count = 0
california_total = 0
california_count = 0
for earthquake in list_of_earthquake:
    if earthquake['location']['name'] == "China":
        china_total = china_total + earthquake['impact']['magnitude']
        china_count = china_count + 1
    elif earthquake['location']['name'] == "Peru":
        peru_total = peru_total + earthquake['impact']['magnitude']
        peru_count = peru_count + 1
    elif earthquake['location']['name'] == "California":
        california_total = california_total + earthquake['impact']['magnitude']
        california_count = california_count + 1
china_average = china_total / china_count
peru_average = peru_total / peru_count
california_average = california_total / california_count

# Combine averages into a list
average_magnitudes = [china_average, peru_average, california_average]
# Create our labels
average_magnitude_labels = ["China", "Peru", "California"]
# Create the x-coordinates of the bar
average_magnitude_xcoords = range(len(average_magnitude_labels))

# Create the bar graph
plt.bar(average_magnitude_xcoords, average_magnitudes, tick_label= average_magnitude_labels, align='center')
# Labelling
plt.title("Average Magnitude across Countries")
plt.xlabel("Countries")
plt.ylabel("Magnitude")
# Show the bar graph
plt.show()
