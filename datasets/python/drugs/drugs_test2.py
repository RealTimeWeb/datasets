import drugs
import matplotlib
import matplotlib.pyplot as plt
 
list_of_report = drugs.get_reports()
 
illicit_drug_use = []
illicit_drug_abuse = []
 
for report in list_of_report:
    if report["State"] == "Virginia":
        illicit_drug_abuse.append(report["Rates"]["Illicit Drugs"]["Abuse Past Month"])
        illicit_drug_use.append(report["Rates"]["Illicit Drugs"]["Used Past Month"])
plt.gca().xaxis.set_major_formatter(matplotlib.ticker.FormatStrFormatter('%d'))
 
plt.plot(illicit_drug_use, label = "Illicit Drug Use Over Past Month")
plt.plot(illicit_drug_abuse, label = "Illicit Drug Abuse Over Past Month")
plt.xlabel("Time")
plt.ylabel("Drug Use vs. Drug Abuse in 2002")
plt.legend
plt.show()