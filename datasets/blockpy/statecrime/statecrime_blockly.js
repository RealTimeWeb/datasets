

var INDEXES = [
    ["(None)", "(None)"],
    
];

var INDEX_VALUES = {
    "(None)": [],
    
}

var PROPERTIES = [
    ["Rates.Property.All", "Rates.Property.All"] ,
    ["Rates.Property.Burglary", "Rates.Property.Burglary"] ,
    ["Rates.Property.Larceny", "Rates.Property.Larceny"] ,
    ["Rates.Property.Motor", "Rates.Property.Motor"] ,
    ["Rates.Violent.All", "Rates.Violent.All"] ,
    ["Rates.Violent.Assault", "Rates.Violent.Assault"] ,
    ["Rates.Violent.Murder", "Rates.Violent.Murder"] ,
    ["Rates.Violent.Rape", "Rates.Violent.Rape"] ,
    ["Rates.Violent.Robbery", "Rates.Violent.Robbery"] ,
    ["Totals.Property.All", "Totals.Property.All"] ,
    ["Totals.Property.Burglary", "Totals.Property.Burglary"] ,
    ["Totals.Property.Larceny", "Totals.Property.Larceny"] ,
    ["Totals.Property.Motor", "Totals.Property.Motor"] ,
    ["Totals.Violent.All", "Totals.Violent.All"] ,
    ["Totals.Violent.Assault", "Totals.Violent.Assault"] ,
    ["Totals.Violent.Murder", "Totals.Violent.Murder"] ,
    ["Totals.Violent.Rape", "Totals.Violent.Rape"] ,
    ["Totals.Violent.Robbery", "Totals.Violent.Robbery"] ,
    ["Population", "Population"] ,
    ["State", "State"] ,
    ["Year", "Year"] 
]

Blockly.Blocks['state_crime_get'] = {
  init: function() {
    this.setColour(WEATHER_HUE);
    this.appendDummyInput('MAIN')
        .appendField("state_crime.get")
        .appendField(new Blockly.FieldDropdown(PROPERTIES), "PROPERTY")
        .appendField("filter")
        .appendField(new Blockly.FieldDropdown(INDEXES, function(option) {
                        this.sourceBlock_.updateShape_(option);
                    }), "INDEX")
    this.updateShape_();
    this.setInputsInline(false);
    this.setOutput(true, "Array");
    this.setTooltip('Returns a list of State Crime data.');
  },
  mutationToDom: function() {
    var container = document.createElement('mutation');
    container.setAttribute('index', this.getFieldValue('INDEX'));
    container.setAttribute('index_value', this.getFieldValue('INDEX_VALUE'));
    return container;
  },
  domToMutation: function(xmlElement) {
    var index = xmlElement.getAttribute('index');
    var index_value = xmlElement.getAttribute('index_value');
    this.updateShape_(index, index_value);
  },
  updateShape_: function(index, index_value) {
    var inputGroup = this.getInput('MAIN')
    var fieldExists = this.getField('INDEX_VALUE');
    if (fieldExists) {
        inputGroup.removeField('INDEX_VALUE');
    }
    this.setFieldValue(index, 'INDEX');
    if (index != undefined && index != '(None)') {
        inputGroup.appendField(new Blockly.FieldDropdown(INDEX_VALUES[index]), 'INDEX_VALUE')
        if (index_value != undefined) {
            this.setFieldValue(index_value, 'INDEX_VALUE');
        } else {
            console.log(INDEX_VALUES[index])
            this.setFieldValue(INDEX_VALUES[index][0][0], 'INDEX_VALUE');
        }
    }    
  }
};
Blockly.Python['state_crime_get'] = function(block) {
    Blockly.Python.definitions_['import_state_crime'] = 'import state_crime';
    var property = Blockly.Python.quote_(block.getFieldValue('PROPERTY'));
    var index_unquoted = block.getFieldValue('INDEX');
    var index = Blockly.Python.quote_(index_unquoted);
    var index_value = "''";
    if (index_unquoted != '(None)') {
        var iv = block.getFieldValue('INDEX_VALUE') || "";
        index_value = Blockly.Python.quote_(iv);
    }
    var code = 'state_crime.get('+property+',' +index+','+index_value+')';
    return [code, Blockly.Python.ORDER_ATOMIC];
};

PythonToBlocks.KNOWN_MODULES['state_crime'] = {
    "get": ["state_crime_get", 
            "PROPERTY", 
            {"type": "mutation", "name": "@INDEX"},
            {"type": "mutation", "name": "@INDEX_VALUE"}]
};

AbstractInterpreter.MODULES['state_crime'] = {
    'get': {"type": "List", "empty": false, "component": {"type": 'Num'}}
};