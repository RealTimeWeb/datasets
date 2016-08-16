

var broadway_INDEXES = [
    ["(None)", "(None)"],
    
    ["theatre", "theatre"] 
];

var broadway_INDEX_VALUES = {
    "(None)": [],
    
    "theatre": [
        
        ["46th Street", "46th Street"] ,
        ["Al Hirschfeld", "Al Hirschfeld"] ,
        ["Ambassador", "Ambassador"] ,
        ["American Airlines", "American Airlines"] ,
        ["August Wilson", "August Wilson"] ,
        ["Barrymore", "Barrymore"] ,
        ["Belasco", "Belasco"] ,
        ["Biltmore", "Biltmore"] ,
        ["Biltmore (ne)", "Biltmore (ne)"] ,
        ["Booth", "Booth"] ,
        ["Broadhurst", "Broadhurst"] ,
        ["Broadway", "Broadway"] ,
        ["Brooks Atkinson", "Brooks Atkinson"] ,
        ["Cadillac Winter Garden", "Cadillac Winter Garden"] ,
        ["Circle In The Square", "Circle In The Square"] ,
        ["Cort", "Cort"] ,
        ["Criterion", "Criterion"] ,
        ["Edison", "Edison"] ,
        ["Ethel Barrymore", "Ethel Barrymore"] ,
        ["Eugene O'neill", "Eugene O'neill"] ,
        ["Ford Center", "Ford Center"] ,
        ["Ford Center (livent)", "Ford Center (livent)"] ,
        ["Ford Center (tcn)", "Ford Center (tcn)"] ,
        ["Foxwoods", "Foxwoods"] ,
        ["Friedman", "Friedman"] ,
        ["Gershwin", "Gershwin"] ,
        ["Golden", "Golden"] ,
        ["Helen Hayes", "Helen Hayes"] ,
        ["Hellinger", "Hellinger"] ,
        ["Henry Miller", "Henry Miller"] ,
        ["Hilton Theatre", "Hilton Theatre"] ,
        ["Imperial", "Imperial"] ,
        ["Jacobs", "Jacobs"] ,
        ["John Golden", "John Golden"] ,
        ["Kit Kat Klub", "Kit Kat Klub"] ,
        ["Latin Quarter", "Latin Quarter"] ,
        ["Lawrence", "Lawrence"] ,
        ["Longacre", "Longacre"] ,
        ["Lunt-fontanne", "Lunt-fontanne"] ,
        ["Lunt-Fontanne", "Lunt-Fontanne"] ,
        ["Lyceum", "Lyceum"] ,
        ["Lyric", "Lyric"] ,
        ["Majestic", "Majestic"] ,
        ["Marquis", "Marquis"] ,
        ["Martin Beck", "Martin Beck"] ,
        ["Minskoff", "Minskoff"] ,
        ["Music Box", "Music Box"] ,
        ["Nederlander", "Nederlander"] ,
        ["Neil Simon", "Neil Simon"] ,
        ["New Amsterdam", "New Amsterdam"] ,
        ["Palace", "Palace"] ,
        ["Plymouth", "Plymouth"] ,
        ["Richard Rodgers", "Richard Rodgers"] ,
        ["Ritz", "Ritz"] ,
        ["Royale", "Royale"] ,
        ["Schoenfeld", "Schoenfeld"] ,
        ["Shubert", "Shubert"] ,
        ["St. James", "St. James"] ,
        ["Stephen Sondheim", "Stephen Sondheim"] ,
        ["Studio 54", "Studio 54"] ,
        ["Studio 54 ('98)", "Studio 54 ('98)"] ,
        ["Virginia", "Virginia"] ,
        ["Vivian Beaumont", "Vivian Beaumont"] ,
        ["Walter Kerr", "Walter Kerr"] ,
        ["Winter Garden", "Winter Garden"] 
    ]
}

var broadway_PROPERTIES = [
    ["attendance", "attendance"] ,
    ["capacity", "capacity"] ,
    ["date", "date"] ,
    ["day", "day"] ,
    ["gross", "gross"] ,
    ["month", "month"] ,
    ["performances", "performances"] ,
    ["previews", "previews"] ,
    ["show", "show"] ,
    ["theatre", "theatre"] ,
    ["year", "year"] 
]

Blockly.Blocks['broadway_get'] = {
  init: function() {
    this.setColour(WEATHER_HUE);
    this.appendDummyInput('MAIN')
        .appendField("broadway.get")
        .appendField(new Blockly.FieldDropdown(broadway_PROPERTIES), "PROPERTY")
        .appendField("filter")
        .appendField(new Blockly.FieldDropdown(broadway_INDEXES, function(option) {
                        this.sourceBlock_.updateShape_(option);
                    }), "INDEX")
    this.updateShape_();
    this.setInputsInline(false);
    this.setOutput(true, "Array");
    this.setTooltip('Returns a list of Broadway data.');
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
        inputGroup.appendField(new Blockly.FieldDropdown(broadway_INDEX_VALUES[index]), 'INDEX_VALUE')
        if (index_value != undefined) {
            this.setFieldValue(index_value, 'INDEX_VALUE');
        } else {
            this.setFieldValue(broadway_INDEX_VALUES[index][0][0], 'INDEX_VALUE');
        }
    }    
  }
};
Blockly.Python['broadway_get'] = function(block) {
    Blockly.Python.definitions_['import_broadway'] = 'import broadway';
    var property = Blockly.Python.quote_(block.getFieldValue('PROPERTY'));
    var index_unquoted = block.getFieldValue('INDEX');
    var index = Blockly.Python.quote_(index_unquoted);
    var index_value = "''";
    if (index_unquoted != '(None)') {
        var iv = block.getFieldValue('INDEX_VALUE') || "";
        index_value = Blockly.Python.quote_(iv);
    }
    var code = 'broadway.get('+property+',' +index+','+index_value+')';
    return [code, Blockly.Python.ORDER_ATOMIC];
};

PythonToBlocks.KNOWN_MODULES['broadway'] = {
    "get": ["broadway_get", 
            "PROPERTY", 
            {"type": "mutation", "name": "@INDEX"},
            {"type": "mutation", "name": "@INDEX_VALUE"}]
};

AbstractInterpreter.MODULES['broadway'] = {
    'get': {"type": "List", "empty": false, "component": {"type": 'Num'}}
};

BlockPyEditor.CATEGORY_MAP['Data - Broadway'] = '<category name="Data - Broadway" colour="50">'+
                    '<block type="broadway_get"><mutation index="(None)" index_value=""></mutation></block>'+
                '</category>';