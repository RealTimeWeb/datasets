

var broadway_INDEXES = [
    ["(None)", "(None)"],
    
    ["Type", "Type"] ,
    ["Theatre", "Theatre"] ,
    ["Year", "Year"] 
];

var broadway_INDEX_VALUES = {
    "(None)": [],
    
    "Type": [
        
        ["Musical", "Musical"] ,
        ["Play", "Play"] ,
        ["Special", "Special"] 
    ],
    "Theatre": [
        
        ["Al Hirschfeld", "Al Hirschfeld"] ,
        ["Ambassador", "Ambassador"] ,
        ["American Airlines", "American Airlines"] ,
        ["August Wilson", "August Wilson"] ,
        ["Belasco", "Belasco"] ,
        ["Biltmore", "Biltmore"] ,
        ["Booth", "Booth"] ,
        ["Broadhurst", "Broadhurst"] ,
        ["Broadway", "Broadway"] ,
        ["Brooks Atkinson", "Brooks Atkinson"] ,
        ["Cadillac Winter Garden", "Cadillac Winter Garden"] ,
        ["Circle In The Square", "Circle In The Square"] ,
        ["Cort", "Cort"] ,
        ["Criterion", "Criterion"] ,
        ["Ethel Barrymore", "Ethel Barrymore"] ,
        ["Eugene O'Neill", "Eugene O'Neill"] ,
        ["Ford Center", "Ford Center"] ,
        ["Ford Center (Livent)", "Ford Center (Livent)"] ,
        ["Ford Center (Tcn)", "Ford Center (Tcn)"] ,
        ["Foxwoods", "Foxwoods"] ,
        ["Friedman", "Friedman"] ,
        ["Gershwin", "Gershwin"] ,
        ["Golden", "Golden"] ,
        ["Helen Hayes", "Helen Hayes"] ,
        ["Henry Miller", "Henry Miller"] ,
        ["Henry Miller (Rndabt)", "Henry Miller (Rndabt)"] ,
        ["Hilton Theatre", "Hilton Theatre"] ,
        ["Imperial", "Imperial"] ,
        ["Jacobs", "Jacobs"] ,
        ["Kit Kat Klub", "Kit Kat Klub"] ,
        ["Longacre", "Longacre"] ,
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
    ],
    "Year": [
        
        ["1991", "1991"] ,
        ["1992", "1992"] ,
        ["1993", "1993"] ,
        ["1994", "1994"] ,
        ["1995", "1995"] ,
        ["1996", "1996"] ,
        ["1997", "1997"] ,
        ["1998", "1998"] ,
        ["1999", "1999"] ,
        ["2000", "2000"] ,
        ["2001", "2001"] ,
        ["2002", "2002"] ,
        ["2003", "2003"] ,
        ["2004", "2004"] ,
        ["2005", "2005"] ,
        ["2006", "2006"] ,
        ["2007", "2007"] ,
        ["2008", "2008"] ,
        ["2009", "2009"] ,
        ["2010", "2010"] ,
        ["2011", "2011"] ,
        ["2012", "2012"] ,
        ["2013", "2013"] ,
        ["2014", "2014"] ,
        ["2015", "2015"] ,
        ["2016", "2016"] 
    ]
}

var broadway_PROPERTIES = [
    ["Day", "Day"] ,
    ["Full", "Full"] ,
    ["Month", "Month"] ,
    ["Year", "Year"] ,
    ["Name", "Name"] ,
    ["Theatre", "Theatre"] ,
    ["Type", "Type"] ,
    ["Attendance", "Attendance"] ,
    ["Capacity", "Capacity"] ,
    ["Gross", "Gross"] ,
    ["Gross Potential", "Gross Potential"] ,
    ["Performances", "Performances"] 
]

Blockly.Blocks['broadway_get'] = {
  init: function() {
    this.setColour(WEATHER_HUE);
    this.appendDummyInput('MAIN')
        .appendField("broadway.get")
        .appendField(new Blockly.FieldDropdown(broadway_PROPERTIES), "PROPERTY");
    this.appendDummyInput('SECOND')
        .appendField("filter")
        .appendField(new Blockly.FieldDropdown(broadway_INDEXES, function(option) {
                        this.sourceBlock_.updateShape_(option);
                    }), "INDEX")
    this.updateShape_("(None)");
    this.setInputsInline(false);
    this.setOutput(true, "Array");
    this.setTooltip('Returns a list of Broadway data.');
  },
  mutationToDom: function() {
    var container = document.createElement('mutation');
    container.setAttribute('index', this.getFieldValue('INDEX'));
    container.setAttribute('index_value', this.getFieldValue('INDEX_VALUE'));
    container.setAttribute('module', "broadway")
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
    var propertyValue = block.getFieldValue('PROPERTY') || '';
    var property = Blockly.Python.quote_(propertyValue);
    var index_unquoted = block.getFieldValue('INDEX');
    var index = Blockly.Python.quote_(index_unquoted || '');
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

BlockPyEditor.CATEGORY_MAP['Data - Broadway'] = '<category name="Data - Broadway" colour="50">'+
                    '<block type="broadway_get"><mutation index="(None)" index_value=""></mutation></block>'+
                '</category>';