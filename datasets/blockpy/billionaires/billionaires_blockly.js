

var billionaires_INDEXES = [
    ["(None)", "(None)"],
    
    ["citizenship", "citizenship"] ,
    ["year", "year"] 
];

var billionaires_INDEX_VALUES = {
    "(None)": [],
    
    "citizenship": [
        
        ["Algeria", "Algeria"] ,
        ["Angola", "Angola"] ,
        ["Argentina", "Argentina"] ,
        ["Australia", "Australia"] ,
        ["Austria", "Austria"] ,
        ["Bahrain", "Bahrain"] ,
        ["Belgium", "Belgium"] ,
        ["Bermuda", "Bermuda"] ,
        ["Brazil", "Brazil"] ,
        ["Canada", "Canada"] ,
        ["Chile", "Chile"] ,
        ["China", "China"] ,
        ["Colombia", "Colombia"] ,
        ["Cyprus", "Cyprus"] ,
        ["Czech Republic", "Czech Republic"] ,
        ["Denmark", "Denmark"] ,
        ["Ecuador", "Ecuador"] ,
        ["Egypt", "Egypt"] ,
        ["Finland", "Finland"] ,
        ["France", "France"] ,
        ["Georgia", "Georgia"] ,
        ["Germany", "Germany"] ,
        ["Greece", "Greece"] ,
        ["Guernsey", "Guernsey"] ,
        ["Hong Kong", "Hong Kong"] ,
        ["India", "India"] ,
        ["Indonesia", "Indonesia"] ,
        ["Ireland", "Ireland"] ,
        ["Israel", "Israel"] ,
        ["Italy", "Italy"] ,
        ["Japan", "Japan"] ,
        ["Kazakhstan", "Kazakhstan"] ,
        ["Kuwait", "Kuwait"] ,
        ["Lebanon", "Lebanon"] ,
        ["Liechtenstein", "Liechtenstein"] ,
        ["Lithuania", "Lithuania"] ,
        ["Macau", "Macau"] ,
        ["Malaysia", "Malaysia"] ,
        ["Mexico", "Mexico"] ,
        ["Monaco", "Monaco"] ,
        ["Morocco", "Morocco"] ,
        ["Nepal", "Nepal"] ,
        ["Netherlands", "Netherlands"] ,
        ["New Zealand", "New Zealand"] ,
        ["Nigeria", "Nigeria"] ,
        ["Norway", "Norway"] ,
        ["Oman", "Oman"] ,
        ["Peru", "Peru"] ,
        ["Philippines", "Philippines"] ,
        ["Poland", "Poland"] ,
        ["Portugal", "Portugal"] ,
        ["Romania", "Romania"] ,
        ["Russia", "Russia"] ,
        ["Saudi Arabia", "Saudi Arabia"] ,
        ["Singapore", "Singapore"] ,
        ["South Africa", "South Africa"] ,
        ["South Korea", "South Korea"] ,
        ["Spain", "Spain"] ,
        ["St. Kitts and Nevis", "St. Kitts and Nevis"] ,
        ["Swaziland", "Swaziland"] ,
        ["Sweden", "Sweden"] ,
        ["Switzerland", "Switzerland"] ,
        ["Taiwan", "Taiwan"] ,
        ["Tanzania", "Tanzania"] ,
        ["Thailand", "Thailand"] ,
        ["Turkey", "Turkey"] ,
        ["Uganda", "Uganda"] ,
        ["Ukraine", "Ukraine"] ,
        ["United Arab Emirates", "United Arab Emirates"] ,
        ["United Kingdom", "United Kingdom"] ,
        ["United States", "United States"] ,
        ["Venezuela", "Venezuela"] ,
        ["Vietnam", "Vietnam"] 
    ],
    "year": [
        
        ["1996", "1996"] ,
        ["2001", "2001"] ,
        ["2014", "2014"] 
    ]
}

var billionaires_PROPERTIES = [
    ["founded", "founded"] ,
    ["company.name", "company.name"] ,
    ["relationship", "relationship"] ,
    ["sector", "sector"] ,
    ["company.type", "company.type"] ,
    ["age", "age"] ,
    ["gender", "gender"] ,
    ["citizenship", "citizenship"] ,
    ["country code", "country code"] ,
    ["gdp", "gdp"] ,
    ["region", "region"] ,
    ["name", "name"] ,
    ["rank", "rank"] ,
    ["category", "category"] ,
    ["from emerging", "from emerging"] ,
    ["industry", "industry"] ,
    ["inherited", "inherited"] ,
    ["was founder", "was founder"] ,
    ["was political", "was political"] ,
    ["wealth.type", "wealth.type"] ,
    ["worth in billions", "worth in billions"] ,
    ["year", "year"] 
]

Blockly.Blocks['billionaires_get'] = {
  init: function() {
    this.setColour(WEATHER_HUE);
    this.appendDummyInput('MAIN')
        .appendField("billionaires.get")
        .appendField(new Blockly.FieldDropdown(billionaires_PROPERTIES), "PROPERTY");
    this.appendDummyInput('SECOND')
        .appendField("filter")
        .appendField(new Blockly.FieldDropdown(billionaires_INDEXES, function(option) {
                        this.sourceBlock_.updateShape_(option);
                    }), "INDEX")
    this.updateShape_("(None)");
    this.setInputsInline(false);
    this.setOutput(true, "Array");
    this.setTooltip('Returns a list of Billionaires data.');
  },
  mutationToDom: function() {
    var container = document.createElement('mutation');
    container.setAttribute('index', this.getFieldValue('INDEX'));
    container.setAttribute('index_value', this.getFieldValue('INDEX_VALUE'));
    container.setAttribute('module', "billionaires")
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
        inputGroup.appendField(new Blockly.FieldDropdown(billionaires_INDEX_VALUES[index]), 'INDEX_VALUE')
        if (index_value != undefined) {
            this.setFieldValue(index_value, 'INDEX_VALUE');
        } else {
            this.setFieldValue(billionaires_INDEX_VALUES[index][0][0], 'INDEX_VALUE');
        }
    }    
  }
};
Blockly.Python['billionaires_get'] = function(block) {
    Blockly.Python.definitions_['import_billionaires'] = 'import billionaires';
    var propertyValue = block.getFieldValue('PROPERTY') || '';
    var property = Blockly.Python.quote_(propertyValue);
    var index_unquoted = block.getFieldValue('INDEX');
    var index = Blockly.Python.quote_(index_unquoted || '');
    var index_value = "''";
    if (index_unquoted != '(None)') {
        var iv = block.getFieldValue('INDEX_VALUE') || "";
        index_value = Blockly.Python.quote_(iv);
    }
    var code = 'billionaires.get('+property+',' +index+','+index_value+')';
    return [code, Blockly.Python.ORDER_ATOMIC];
};

PythonToBlocks.KNOWN_MODULES['billionaires'] = {
    "get": ["billionaires_get", 
            "PROPERTY", 
            {"type": "mutation", "name": "@INDEX"},
            {"type": "mutation", "name": "@INDEX_VALUE"}]
};

BlockPyEditor.CATEGORY_MAP['Data - Billionaires'] = '<category name="Data - Billionaires" colour="50">'+
                    '<block type="billionaires_get"><mutation index="(None)" index_value=""></mutation></block>'+
                '</category>';