

var INDEXES = [
    ["(None)", "(None)"],
    
];

var INDEX_VALUES = {
    "(None)": [],
    
}

var PROPERTIES = [
    ["annual.combined.amusement and recreation", "annual.combined.amusement and recreation"] ,
    ["annual.combined.commercial", "annual.combined.commercial"] ,
    ["annual.combined.communication", "annual.combined.communication"] ,
    ["annual.combined.conservation and development", "annual.combined.conservation and development"] ,
    ["annual.combined.educational", "annual.combined.educational"] ,
    ["annual.combined.health care", "annual.combined.health care"] ,
    ["annual.combined.highway and street", "annual.combined.highway and street"] ,
    ["annual.combined.lodging", "annual.combined.lodging"] ,
    ["annual.combined.manufacturing", "annual.combined.manufacturing"] ,
    ["annual.combined.nonresidential", "annual.combined.nonresidential"] ,
    ["annual.combined.office", "annual.combined.office"] ,
    ["annual.combined.power", "annual.combined.power"] ,
    ["annual.combined.public safety", "annual.combined.public safety"] ,
    ["annual.combined.religious", "annual.combined.religious"] ,
    ["annual.combined.residential", "annual.combined.residential"] ,
    ["annual.combined.sewage and waste disposal", "annual.combined.sewage and waste disposal"] ,
    ["annual.combined.total construction", "annual.combined.total construction"] ,
    ["annual.combined.transportation", "annual.combined.transportation"] ,
    ["annual.combined.water supply", "annual.combined.water supply"] ,
    ["annual.private.amusement and recreation", "annual.private.amusement and recreation"] ,
    ["annual.private.commercial", "annual.private.commercial"] ,
    ["annual.private.communication", "annual.private.communication"] ,
    ["annual.private.conservation and development", "annual.private.conservation and development"] ,
    ["annual.private.educational", "annual.private.educational"] ,
    ["annual.private.health care", "annual.private.health care"] ,
    ["annual.private.highway and street", "annual.private.highway and street"] ,
    ["annual.private.lodging", "annual.private.lodging"] ,
    ["annual.private.manufacturing", "annual.private.manufacturing"] ,
    ["annual.private.nonresidential", "annual.private.nonresidential"] ,
    ["annual.private.office", "annual.private.office"] ,
    ["annual.private.power", "annual.private.power"] ,
    ["annual.private.public safety", "annual.private.public safety"] ,
    ["annual.private.religious", "annual.private.religious"] ,
    ["annual.private.residential", "annual.private.residential"] ,
    ["annual.private.sewage and waste disposal", "annual.private.sewage and waste disposal"] ,
    ["annual.private.total construction", "annual.private.total construction"] ,
    ["annual.private.transportation", "annual.private.transportation"] ,
    ["annual.private.water supply", "annual.private.water supply"] ,
    ["annual.public.amusement and recreation", "annual.public.amusement and recreation"] ,
    ["annual.public.commercial", "annual.public.commercial"] ,
    ["annual.public.communication", "annual.public.communication"] ,
    ["annual.public.conservation and development", "annual.public.conservation and development"] ,
    ["annual.public.educational", "annual.public.educational"] ,
    ["annual.public.health care", "annual.public.health care"] ,
    ["annual.public.highway and street", "annual.public.highway and street"] ,
    ["annual.public.lodging", "annual.public.lodging"] ,
    ["annual.public.manufacturing", "annual.public.manufacturing"] ,
    ["annual.public.nonresidential", "annual.public.nonresidential"] ,
    ["annual.public.office", "annual.public.office"] ,
    ["annual.public.power", "annual.public.power"] ,
    ["annual.public.public safety", "annual.public.public safety"] ,
    ["annual.public.religious", "annual.public.religious"] ,
    ["annual.public.residential", "annual.public.residential"] ,
    ["annual.public.sewage and waste disposal", "annual.public.sewage and waste disposal"] ,
    ["annual.public.total construction", "annual.public.total construction"] ,
    ["annual.public.transportation", "annual.public.transportation"] ,
    ["annual.public.water supply", "annual.public.water supply"] ,
    ["current.combined.amusement and recreation", "current.combined.amusement and recreation"] ,
    ["current.combined.commercial", "current.combined.commercial"] ,
    ["current.combined.communication", "current.combined.communication"] ,
    ["current.combined.conservation and development", "current.combined.conservation and development"] ,
    ["current.combined.educational", "current.combined.educational"] ,
    ["current.combined.health care", "current.combined.health care"] ,
    ["current.combined.highway and street", "current.combined.highway and street"] ,
    ["current.combined.lodging", "current.combined.lodging"] ,
    ["current.combined.manufacturing", "current.combined.manufacturing"] ,
    ["current.combined.nonresidential", "current.combined.nonresidential"] ,
    ["current.combined.office", "current.combined.office"] ,
    ["current.combined.power", "current.combined.power"] ,
    ["current.combined.public safety", "current.combined.public safety"] ,
    ["current.combined.religious", "current.combined.religious"] ,
    ["current.combined.residential", "current.combined.residential"] ,
    ["current.combined.sewage and waste disposal", "current.combined.sewage and waste disposal"] ,
    ["current.combined.total construction", "current.combined.total construction"] ,
    ["current.combined.transportation", "current.combined.transportation"] ,
    ["current.combined.water supply", "current.combined.water supply"] ,
    ["current.private.amusement and recreation", "current.private.amusement and recreation"] ,
    ["current.private.commercial", "current.private.commercial"] ,
    ["current.private.communication", "current.private.communication"] ,
    ["current.private.conservation and development", "current.private.conservation and development"] ,
    ["current.private.educational", "current.private.educational"] ,
    ["current.private.health care", "current.private.health care"] ,
    ["current.private.highway and street", "current.private.highway and street"] ,
    ["current.private.lodging", "current.private.lodging"] ,
    ["current.private.manufacturing", "current.private.manufacturing"] ,
    ["current.private.nonresidential", "current.private.nonresidential"] ,
    ["current.private.office", "current.private.office"] ,
    ["current.private.power", "current.private.power"] ,
    ["current.private.public safety", "current.private.public safety"] ,
    ["current.private.religious", "current.private.religious"] ,
    ["current.private.residential", "current.private.residential"] ,
    ["current.private.sewage and waste disposal", "current.private.sewage and waste disposal"] ,
    ["current.private.total construction", "current.private.total construction"] ,
    ["current.private.transportation", "current.private.transportation"] ,
    ["current.private.water supply", "current.private.water supply"] ,
    ["current.public.amusement and recreation", "current.public.amusement and recreation"] ,
    ["current.public.commercial", "current.public.commercial"] ,
    ["current.public.communication", "current.public.communication"] ,
    ["current.public.conservation and development", "current.public.conservation and development"] ,
    ["current.public.educational", "current.public.educational"] ,
    ["current.public.health care", "current.public.health care"] ,
    ["current.public.highway and street", "current.public.highway and street"] ,
    ["current.public.lodging", "current.public.lodging"] ,
    ["current.public.manufacturing", "current.public.manufacturing"] ,
    ["current.public.nonresidential", "current.public.nonresidential"] ,
    ["current.public.office", "current.public.office"] ,
    ["current.public.power", "current.public.power"] ,
    ["current.public.public safety", "current.public.public safety"] ,
    ["current.public.religious", "current.public.religious"] ,
    ["current.public.residential", "current.public.residential"] ,
    ["current.public.sewage and waste disposal", "current.public.sewage and waste disposal"] ,
    ["current.public.total construction", "current.public.total construction"] ,
    ["current.public.transportation", "current.public.transportation"] ,
    ["current.public.water supply", "current.public.water supply"] ,
    ["index", "index"] ,
    ["month", "month"] ,
    ["month name", "month name"] ,
    ["period", "period"] ,
    ["year", "year"] 
]

Blockly.Blocks['construction_spending_get'] = {
  init: function() {
    this.setColour(WEATHER_HUE);
    this.appendDummyInput('MAIN')
        .appendField("construction_spending.get")
        .appendField(new Blockly.FieldDropdown(PROPERTIES), "PROPERTY")
        .appendField("filter")
        .appendField(new Blockly.FieldDropdown(INDEXES, function(option) {
                        this.sourceBlock_.updateShape_(option);
                    }), "INDEX")
    this.updateShape_();
    this.setInputsInline(false);
    this.setOutput(true, "Array");
    this.setTooltip('Returns a list of Construction Spending data.');
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
Blockly.Python['construction_spending_get'] = function(block) {
    Blockly.Python.definitions_['import_construction_spending'] = 'import construction_spending';
    var property = Blockly.Python.quote_(block.getFieldValue('PROPERTY'));
    var index_unquoted = block.getFieldValue('INDEX');
    var index = Blockly.Python.quote_(index_unquoted);
    var index_value = "''";
    if (index_unquoted != '(None)') {
        var iv = block.getFieldValue('INDEX_VALUE') || "";
        index_value = Blockly.Python.quote_(iv);
    }
    var code = 'construction_spending.get('+property+',' +index+','+index_value+')';
    return [code, Blockly.Python.ORDER_ATOMIC];
};

PythonToBlocks.KNOWN_MODULES['construction_spending'] = {
    "get": ["construction_spending_get", 
            "PROPERTY", 
            {"type": "mutation", "name": "@INDEX"},
            {"type": "mutation", "name": "@INDEX_VALUE"}]
};

AbstractInterpreter.MODULES['construction_spending'] = {
    'get': {"type": "List", "empty": false, "component": {"type": 'Num'}}
};