

var earthquakes_INDEXES = [
    ["(None)", "(None)"],
    
    ["state", "state"] 
];

var earthquakes_INDEX_VALUES = {
    "(None)": [],
    
    "state": [
        
        [" Afghanistan", " Afghanistan"] ,
        [" Alaska", " Alaska"] ,
        [" Albania", " Albania"] ,
        [" Algeria", " Algeria"] ,
        [" Anguilla", " Anguilla"] ,
        [" Argentina", " Argentina"] ,
        [" Arizona", " Arizona"] ,
        [" Arkansas", " Arkansas"] ,
        [" Azerbaijan", " Azerbaijan"] ,
        [" British Virgin Islands", " British Virgin Islands"] ,
        [" Bulgaria", " Bulgaria"] ,
        [" Burma", " Burma"] ,
        [" CA", " CA"] ,
        [" California", " California"] ,
        [" Canada", " Canada"] ,
        [" Chile", " Chile"] ,
        [" China", " China"] ,
        [" Colombia", " Colombia"] ,
        [" Connecticut", " Connecticut"] ,
        [" Costa Rica", " Costa Rica"] ,
        [" Cyprus", " Cyprus"] ,
        [" Dominican Republic", " Dominican Republic"] ,
        [" Ecuador", " Ecuador"] ,
        [" El Salvador", " El Salvador"] ,
        [" French Polynesia region", " French Polynesia region"] ,
        [" Georgia", " Georgia"] ,
        [" Greece", " Greece"] ,
        [" Greenland", " Greenland"] ,
        [" Guadeloupe", " Guadeloupe"] ,
        [" Guatemala", " Guatemala"] ,
        [" Hawaii", " Hawaii"] ,
        [" Honduras", " Honduras"] ,
        [" Idaho", " Idaho"] ,
        [" India", " India"] ,
        [" Indonesia", " Indonesia"] ,
        [" Iran", " Iran"] ,
        [" Italy", " Italy"] ,
        [" Kansas", " Kansas"] ,
        [" Kazakhstan", " Kazakhstan"] ,
        [" Kentucky", " Kentucky"] ,
        [" Kyrgyzstan", " Kyrgyzstan"] ,
        [" Macedonia", " Macedonia"] ,
        [" Maine", " Maine"] ,
        [" Massachusetts", " Massachusetts"] ,
        [" Mexico", " Mexico"] ,
        [" Missouri", " Missouri"] ,
        [" Montana", " Montana"] ,
        [" MX", " MX"] ,
        [" Nepal", " Nepal"] ,
        [" Nevada", " Nevada"] ,
        [" New Hampshire", " New Hampshire"] ,
        [" New Jersey", " New Jersey"] ,
        [" New Mexico", " New Mexico"] ,
        [" New York", " New York"] ,
        [" Nicaragua", " Nicaragua"] ,
        [" NV", " NV"] ,
        [" Oklahoma", " Oklahoma"] ,
        [" Oregon", " Oregon"] ,
        [" Pennsylvania", " Pennsylvania"] ,
        [" Peru", " Peru"] ,
        [" Puerto Rico", " Puerto Rico"] ,
        [" Saint Eustatius and Saba ", " Saint Eustatius and Saba "] ,
        [" Serbia", " Serbia"] ,
        [" South Carolina", " South Carolina"] ,
        [" Tajikistan", " Tajikistan"] ,
        [" Tennessee", " Tennessee"] ,
        [" Texas", " Texas"] ,
        [" Tonga", " Tonga"] ,
        [" Turkey", " Turkey"] ,
        [" U.S. Virgin Islands", " U.S. Virgin Islands"] ,
        [" Utah", " Utah"] ,
        [" Uzbekistan", " Uzbekistan"] ,
        [" Venezuela", " Venezuela"] ,
        [" Wallis and Futuna", " Wallis and Futuna"] ,
        [" Washington", " Washington"] ,
        [" Wyoming", " Wyoming"] ,
        [" Yemen", " Yemen"] ,
        ["Chagos Archipelago region", "Chagos Archipelago region"] ,
        ["Off the coast of Oregon", "Off the coast of Oregon"] ,
        ["Owen Fracture Zone region", "Owen Fracture Zone region"] ,
        ["South of Panama", "South of Panama"] 
    ]
}

var earthquakes_PROPERTIES = [
    ["id", "id"] ,
    ["gap", "gap"] ,
    ["magnitude", "magnitude"] ,
    ["significance", "significance"] ,
    ["depth", "depth"] ,
    ["distance", "distance"] ,
    ["location.full", "location.full"] ,
    ["latitude", "latitude"] ,
    ["longitude", "longitude"] ,
    ["state", "state"] ,
    ["day", "day"] ,
    ["time.full", "time.full"] ,
    ["hour", "hour"] ,
    ["minute", "minute"] ,
    ["month", "month"] ,
    ["second", "second"] ,
    ["year", "year"] 
]

Blockly.Blocks['earthquakes_get'] = {
  init: function() {
    this.setColour(WEATHER_HUE);
    this.appendDummyInput('MAIN')
        .appendField("earthquakes.get")
        .appendField(new Blockly.FieldDropdown(earthquakes_PROPERTIES), "PROPERTY")
        .appendField("filter")
        .appendField(new Blockly.FieldDropdown(earthquakes_INDEXES, function(option) {
                        this.sourceBlock_.updateShape_(option);
                    }), "INDEX")
    this.updateShape_();
    this.setInputsInline(false);
    this.setOutput(true, "Array");
    this.setTooltip('Returns a list of Earthquakes data.');
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
        inputGroup.appendField(new Blockly.FieldDropdown(earthquakes_INDEX_VALUES[index]), 'INDEX_VALUE')
        if (index_value != undefined) {
            this.setFieldValue(index_value, 'INDEX_VALUE');
        } else {
            this.setFieldValue(earthquakes_INDEX_VALUES[index][0][0], 'INDEX_VALUE');
        }
    }    
  }
};
Blockly.Python['earthquakes_get'] = function(block) {
    Blockly.Python.definitions_['import_earthquakes'] = 'import earthquakes';
    var property = Blockly.Python.quote_(block.getFieldValue('PROPERTY'));
    var index_unquoted = block.getFieldValue('INDEX');
    var index = Blockly.Python.quote_(index_unquoted);
    var index_value = "''";
    if (index_unquoted != '(None)') {
        var iv = block.getFieldValue('INDEX_VALUE') || "";
        index_value = Blockly.Python.quote_(iv);
    }
    var code = 'earthquakes.get('+property+',' +index+','+index_value+')';
    return [code, Blockly.Python.ORDER_ATOMIC];
};

PythonToBlocks.KNOWN_MODULES['earthquakes'] = {
    "get": ["earthquakes_get", 
            "PROPERTY", 
            {"type": "mutation", "name": "@INDEX"},
            {"type": "mutation", "name": "@INDEX_VALUE"}]
};

AbstractInterpreter.MODULES['earthquakes'] = {
    'get': {"type": "List", "empty": false, "component": {"type": 'Num'}}
};

BlockPyEditor.CATEGORY_MAP['Data - Earthquakes'] = '<category name="Data - Earthquakes" colour="50">'+
                    '<block type="earthquakes_get"><mutation index="(None)" index_value=""></mutation></block>'+
                '</category>';