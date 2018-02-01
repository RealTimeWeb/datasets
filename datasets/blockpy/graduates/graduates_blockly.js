

var graduates_INDEXES = [
    ["(None)", "(None)"],
    
    ["Major", "Major"] ,
    ["Year", "Year"] 
];

var graduates_INDEX_VALUES = {
    "(None)": [],
    
    "Major": [
        
        ["Agricultural Economics", "Agricultural Economics"] ,
        ["Animal Sciences", "Animal Sciences"] ,
        ["Anthropology and Archeology", "Anthropology and Archeology"] ,
        ["Area and Ethnic Studies", "Area and Ethnic Studies"] ,
        ["Atmospheric Sciences and Meteorology", "Atmospheric Sciences and Meteorology"] ,
        ["Biochemistry and Biophysics", "Biochemistry and Biophysics"] ,
        ["Biological Sciences", "Biological Sciences"] ,
        ["Botany", "Botany"] ,
        ["Chemical Engineering", "Chemical Engineering"] ,
        ["Chemistry", "Chemistry"] ,
        ["Civil Engineering", "Civil Engineering"] ,
        ["Computer Science and Math", "Computer Science and Math"] ,
        ["Criminology", "Criminology"] ,
        ["Earth Sciences", "Earth Sciences"] ,
        ["Economics", "Economics"] ,
        ["Electrical Engineering", "Electrical Engineering"] ,
        ["Environmental Science Studies", "Environmental Science Studies"] ,
        ["Food Sciences and Technology", "Food Sciences and Technology"] ,
        ["Forestry Services", "Forestry Services"] ,
        ["Genetics, Animal and Plant", "Genetics, Animal and Plant"] ,
        ["Geography", "Geography"] ,
        ["Geology", "Geology"] ,
        ["History of Science", "History of Science"] ,
        ["Information Services and Systems", "Information Services and Systems"] ,
        ["International Relations", "International Relations"] ,
        ["Linguistics", "Linguistics"] ,
        ["Management & Administration", "Management & Administration"] ,
        ["Mechanical Engineering", "Mechanical Engineering"] ,
        ["Nutritional Science", "Nutritional Science"] ,
        ["Oceanography", "Oceanography"] ,
        ["Operations Research", "Operations Research"] ,
        ["OTHER Agricultural Sciences", "OTHER Agricultural Sciences"] ,
        ["Other Engineering", "Other Engineering"] ,
        ["OTHER Geological Sciences", "OTHER Geological Sciences"] ,
        ["OTHER Physical and Related Sciences", "OTHER Physical and Related Sciences"] ,
        ["Pharmacology, Human and Animal", "Pharmacology, Human and Animal"] ,
        ["Philosophy of Science", "Philosophy of Science"] ,
        ["Physics and Astronomy", "Physics and Astronomy"] ,
        ["Physiology, Human and Animal", "Physiology, Human and Animal"] ,
        ["Plant Sciences", "Plant Sciences"] ,
        ["Political and related sciences", "Political and related sciences"] ,
        ["Political Science and Government", "Political Science and Government"] ,
        ["Psychology", "Psychology"] ,
        ["Public Policy Studies", "Public Policy Studies"] ,
        ["Sociology", "Sociology"] ,
        ["Statistics", "Statistics"] ,
        ["Zoology, General", "Zoology, General"] 
    ],
    "Year": [
        
        ["1993", "1993"] ,
        ["1995", "1995"] ,
        ["1997", "1997"] ,
        ["1999", "1999"] ,
        ["2001", "2001"] ,
        ["2003", "2003"] ,
        ["2006", "2006"] ,
        ["2008", "2008"] ,
        ["2010", "2010"] ,
        ["2013", "2013"] ,
        ["2015", "2015"] 
    ]
}

var graduates_PROPERTIES = [
    ["Asians", "Asians"] ,
    ["Minorities", "Minorities"] ,
    ["Whites", "Whites"] ,
    ["Females", "Females"] ,
    ["Males", "Males"] ,
    ["Total", "Total"] ,
    ["Bachelors", "Bachelors"] ,
    ["Doctorates", "Doctorates"] ,
    ["Masters", "Masters"] ,
    ["Professionals", "Professionals"] ,
    ["Major", "Major"] ,
    ["Business/Industry", "Business/Industry"] ,
    ["Educational Institution", "Educational Institution"] ,
    ["Government", "Government"] ,
    ["Family", "Family"] ,
    ["Layoff", "Layoff"] ,
    ["Reason for Not Working.No Job Available", "Reason for Not Working.No Job Available"] ,
    ["No need/want", "No need/want"] ,
    ["Student", "Student"] ,
    ["Career Change", "Career Change"] ,
    ["Family-related", "Family-related"] ,
    ["Job Location", "Job Location"] ,
    ["Reason Working Outside Field.No Job Available", "Reason Working Outside Field.No Job Available"] ,
    ["Reason Working Outside Field.Other", "Reason Working Outside Field.Other"] ,
    ["Pay/Promotion", "Pay/Promotion"] ,
    ["Working Conditions", "Working Conditions"] ,
    ["Employed", "Employed"] ,
    ["Not in Labor Force", "Not in Labor Force"] ,
    ["Unemployed", "Unemployed"] ,
    ["Accounting/Finance/Contracts", "Accounting/Finance/Contracts"] ,
    ["Applied Research", "Applied Research"] ,
    ["Basic Research", "Basic Research"] ,
    ["Computer Applications", "Computer Applications"] ,
    ["Design", "Design"] ,
    ["Development", "Development"] ,
    ["Human Resources", "Human Resources"] ,
    ["Managing/Supervising People/Projects", "Managing/Supervising People/Projects"] ,
    ["Work Activity.Other", "Work Activity.Other"] ,
    ["Productions/Operations/Maintenance", "Productions/Operations/Maintenance"] ,
    ["Professional Service", "Professional Service"] ,
    ["Qualitity/Productivity Management", "Qualitity/Productivity Management"] ,
    ["Sales, Purchasing, Marketing", "Sales, Purchasing, Marketing"] ,
    ["Teaching", "Teaching"] ,
    ["Highest", "Highest"] ,
    ["Lowest", "Lowest"] ,
    ["Mean", "Mean"] ,
    ["Median", "Median"] ,
    ["Quantity", "Quantity"] ,
    ["Standard Deviation", "Standard Deviation"] ,
    ["Year", "Year"] 
]

Blockly.Blocks['graduates_get'] = {
  init: function() {
    this.setColour(WEATHER_HUE);
    this.appendDummyInput('MAIN')
        .appendField("graduates.get")
        .appendField(new Blockly.FieldDropdown(graduates_PROPERTIES), "PROPERTY");
    this.appendDummyInput('SECOND')
        .appendField("filter")
        .appendField(new Blockly.FieldDropdown(graduates_INDEXES, function(option) {
                        this.sourceBlock_.updateShape_(option);
                    }), "INDEX")
    this.updateShape_("(None)");
    this.setInputsInline(false);
    this.setOutput(true, "Array");
    this.setTooltip('Returns a list of Graduates data.');
  },
  mutationToDom: function() {
    var container = document.createElement('mutation');
    container.setAttribute('index', this.getFieldValue('INDEX'));
    container.setAttribute('index_value', this.getFieldValue('INDEX_VALUE'));
    container.setAttribute('module', "graduates")
    return container;
  },
  domToMutation: function(xmlElement) {
    var index = xmlElement.getAttribute('index');
    var index_value = xmlElement.getAttribute('index_value');
    this.updateShape_(index, index_value);
  },
  updateShape_: function(index, index_value) {
    var inputGroup = this.getInput('SECOND')
    var fieldExists = this.getField('INDEX_VALUE');
    if (fieldExists) {
        inputGroup.removeField('INDEX_VALUE');
    }
    this.setFieldValue(index, 'INDEX');
    if (index != undefined && index != '(None)') {
        inputGroup.appendField(new Blockly.FieldDropdown(graduates_INDEX_VALUES[index]), 'INDEX_VALUE')
        if (index_value != undefined) {
            this.setFieldValue(index_value, 'INDEX_VALUE');
        } else {
            this.setFieldValue(graduates_INDEX_VALUES[index][0][0], 'INDEX_VALUE');
        }
    }    
  }
};
Blockly.Python['graduates_get'] = function(block) {
    Blockly.Python.definitions_['import_graduates'] = 'import graduates';
    var propertyValue = block.getFieldValue('PROPERTY') || '';
    var property = Blockly.Python.quote_(propertyValue);
    var index_unquoted = block.getFieldValue('INDEX');
    var index = Blockly.Python.quote_(index_unquoted || '');
    var index_value = "''";
    if (index_unquoted != '(None)') {
        var iv = block.getFieldValue('INDEX_VALUE') || "";
        index_value = Blockly.Python.quote_(iv);
    }
    var code = 'graduates.get('+property+',' +index+','+index_value+')';
    return [code, Blockly.Python.ORDER_ATOMIC];
};

PythonToBlocks.KNOWN_MODULES['graduates'] = {
    "get": ["graduates_get", 
            "PROPERTY", 
            {"type": "mutation", "name": "@INDEX"},
            {"type": "mutation", "name": "@INDEX_VALUE"}]
};

Tifa.MODULES['graduates'] = {
    'name': "Module",
    'fields': {
        'get': Tifa.defineSupplier({"name": "List", "empty": false, "subtype": Tifa._NUM_TYPE()}),
        
        'get_majors': Tifa.defineSupplier({
            "name": "List", "empty": false, "subtype": {
                "name": "Dict",
                "empty": false,
                "keys": Tifa._UNKNOWN_TYPE(),
                "values": Tifa._UNKNOWN_TYPE()
            }
        })
        
    }
};

BlockPyEditor.CATEGORY_MAP['Data - Graduates'] = '<category name="Data - Graduates" colour="50">'+
                    '<block type="graduates_get"><mutation index="(None)" index_value=""></mutation></block>'+
                '</category>';