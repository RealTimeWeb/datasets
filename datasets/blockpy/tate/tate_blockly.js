

var tate_INDEXES = [
    ["(None)", "(None)"],
    
    ["gender", "gender"] ,
    ["creation decade", "creation decade"] 
];

var tate_INDEX_VALUES = {
    "(None)": [],
    
    "gender": [
        
        ["", ""] ,
        ["Female", "Female"] ,
        ["Male", "Male"] 
    ],
    "creation decade": [
        
        ["0", "0"] ,
        ["1540", "1540"] ,
        ["1560", "1560"] ,
        ["1570", "1570"] ,
        ["1590", "1590"] ,
        ["1600", "1600"] ,
        ["1610", "1610"] ,
        ["1620", "1620"] ,
        ["1630", "1630"] ,
        ["1640", "1640"] ,
        ["1650", "1650"] ,
        ["1660", "1660"] ,
        ["1670", "1670"] ,
        ["1680", "1680"] ,
        ["1690", "1690"] ,
        ["1700", "1700"] ,
        ["1710", "1710"] ,
        ["1720", "1720"] ,
        ["1730", "1730"] ,
        ["1740", "1740"] ,
        ["1750", "1750"] ,
        ["1760", "1760"] ,
        ["1770", "1770"] ,
        ["1780", "1780"] ,
        ["1790", "1790"] ,
        ["1800", "1800"] ,
        ["1810", "1810"] ,
        ["1820", "1820"] ,
        ["1830", "1830"] ,
        ["1840", "1840"] ,
        ["1850", "1850"] ,
        ["1860", "1860"] ,
        ["1870", "1870"] ,
        ["1880", "1880"] ,
        ["1890", "1890"] ,
        ["1900", "1900"] ,
        ["1910", "1910"] ,
        ["1920", "1920"] ,
        ["1930", "1930"] ,
        ["1940", "1940"] ,
        ["1950", "1950"] ,
        ["1960", "1960"] ,
        ["1970", "1970"] ,
        ["1980", "1980"] ,
        ["1990", "1990"] ,
        ["2000", "2000"] ,
        ["2010", "2010"] 
    ]
}

var tate_PROPERTIES = [
    ["birth.location", "birth.location"] ,
    ["birth.year", "birth.year"] ,
    ["death.location", "death.location"] ,
    ["death.year", "death.year"] ,
    ["gender", "gender"] ,
    ["name", "name"] ,
    ["role", "role"] ,
    ["medium", "medium"] ,
    ["thumbnail", "thumbnail"] ,
    ["title", "title"] ,
    ["url", "url"] ,
    ["depth", "depth"] ,
    ["height", "height"] ,
    ["width", "width"] ,
    ["acquisition date", "acquisition date"] ,
    ["creation decade", "creation decade"] ,
    ["creation year", "creation year"] ,
    ["credit", "credit"] 
]

Blockly.Blocks['tate_get'] = {
  init: function() {
    this.setColour(WEATHER_HUE);
    this.appendDummyInput('MAIN')
        .appendField("tate.get")
        .appendField(new Blockly.FieldDropdown(tate_PROPERTIES), "PROPERTY")
        .appendField("filter")
        .appendField(new Blockly.FieldDropdown(tate_INDEXES, function(option) {
                        this.sourceBlock_.updateShape_(option);
                    }), "INDEX")
    this.updateShape_();
    this.setInputsInline(false);
    this.setOutput(true, "Array");
    this.setTooltip('Returns a list of Tate data.');
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
        inputGroup.appendField(new Blockly.FieldDropdown(tate_INDEX_VALUES[index]), 'INDEX_VALUE')
        if (index_value != undefined) {
            this.setFieldValue(index_value, 'INDEX_VALUE');
        } else {
            this.setFieldValue(tate_INDEX_VALUES[index][0][0], 'INDEX_VALUE');
        }
    }    
  }
};
Blockly.Python['tate_get'] = function(block) {
    Blockly.Python.definitions_['import_tate'] = 'import tate';
    var property = Blockly.Python.quote_(block.getFieldValue('PROPERTY'));
    var index_unquoted = block.getFieldValue('INDEX');
    var index = Blockly.Python.quote_(index_unquoted);
    var index_value = "''";
    if (index_unquoted != '(None)') {
        var iv = block.getFieldValue('INDEX_VALUE') || "";
        index_value = Blockly.Python.quote_(iv);
    }
    var code = 'tate.get('+property+',' +index+','+index_value+')';
    return [code, Blockly.Python.ORDER_ATOMIC];
};

PythonToBlocks.KNOWN_MODULES['tate'] = {
    "get": ["tate_get", 
            "PROPERTY", 
            {"type": "mutation", "name": "@INDEX"},
            {"type": "mutation", "name": "@INDEX_VALUE"}]
};

AbstractInterpreter.MODULES['tate'] = {
    'get': {"type": "List", "empty": false, "subtype": {"type": 'Num'}}
};

BlockPyEditor.CATEGORY_MAP['Data - Tate'] = '<category name="Data - Tate" colour="50">'+
                    '<block type="tate_get"><mutation index="(None)" index_value=""></mutation></block>'+
                '</category>';