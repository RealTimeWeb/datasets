from pprint import pprint
import json
from collections import defaultdict
import re
non_decimal = re.compile(r'[^\d.]+')
import unidecode

def _clean(input):
    return unidecode.unidecode(input)

def remove_decimal(x):
    try:
        return float(non_decimal.sub('', x))
    except ValueError:
        return 0

data = {}
with open("drugbank.tsv") as inp:
    inp.readline()
    for line in inp:
        (drugbank_id, name, type, groups, 
        atc_codes, categories, inchikey, inchi) = line.split("\t")
        data[drugbank_id] = {
            'id': drugbank_id, 
            'name': name, 
            'type': type, 
            'groups': groups.split("|"), 
            "atc codes": atc_codes.split("|"),
            "categories": categories.split("|"),
            "inchikey": inchikey,
            "inchi": inchi.strip(),
            "proteins": []
        }


with open("proteins.tsv") as inp:
    inp.readline()
    for line in inp:
        (drugbank_id, 
        category, uniprot_id, entrez_gene_id, organism, 
        known_action, actions, pubmed_ids) = line.split("\t")
        data[drugbank_id]["proteins"].append({
            "category": category, 
            "uniprot id": uniprot_id, 
            "entrez gene id": entrez_gene_id, 
            "organism": organism, 
            "known action": known_action, 
            "actions": actions.split("|"), 
            "pubmed ids": pubmed_ids.strip().split("|")
        })
print("Begin the XML")
import xml.etree.cElementTree as ET
tree = ET.ElementTree(file='drugbank.xml')
r = tree.getroot()
skipped = 0
data_counts = defaultdict(lambda: 0)
type_inference = {
    'isoelectric point': float,
    'pka': remove_decimal, 
    'isoelectric point': float, 
    'logp': float, 
    'caco2 permeability': float, 
    'logs': str, 
    'water solubility': str, 
    'hydrophobicity': float, 
    'boiling point': remove_decimal, 
    'molecular formula': str, 
    'molecular weight': remove_decimal, 
    'melting point': remove_decimal
}
for c in r:
    name = c.find('{http://www.drugbank.ca}drugbank-id[@primary="true"]').text
    if name not in data:
        skipped += 1
        continue
    data[name]["properties"] = {
        'isoelectric point': 0,
        'pka': 0, 
        'isoelectric point': 0, 
        'logp': 0, 
        'caco2 permeability': 0, 
        'logs': "", 
        'water solubility': "", 
        'hydrophobicity': 0, 
        'boiling point': 0, 
        'molecular formula': "", 
        'molecular weight': 0, 
        'melting point': 0
    }
    for p in c.find("{http://www.drugbank.ca}experimental-properties"):
        kind = _clean(p.find('{http://www.drugbank.ca}kind').text)
        if "water solubility" == kind.lower(): continue
        value = _clean(p.find('{http://www.drugbank.ca}value').text.replace(r"\xb0C", "").replace(r"\u00b0C", "").replace(" Daltons", "").replace(",", ""))
        data[name]["properties"][kind.lower()] = type_inference[kind.lower()](value)
        data_counts[kind.lower()] += 1
print "Skipped", skipped
data = [v for k, v in sorted(data.items()) if "properties" in v]
pprint(data[0])
print "Removed", len(data), len(r)
pprint(data_counts)
json.dump(data, open("drug_bank.json", "w"))