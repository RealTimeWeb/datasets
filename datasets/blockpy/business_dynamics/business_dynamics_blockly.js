

var business_dynamics_INDEXES = [
    ["(None)", "(None)"],
    
    ["State", "State"] ,
    ["Year", "Year"] 
];

var business_dynamics_INDEX_VALUES = {
    "(None)": [],
    
    "State": [
        
        ["Alabama", "Alabama"] ,
        ["Alaska", "Alaska"] ,
        ["Arizona", "Arizona"] ,
        ["Arkansas", "Arkansas"] ,
        ["California", "California"] ,
        ["Colorado", "Colorado"] ,
        ["Connecticut", "Connecticut"] ,
        ["Delaware", "Delaware"] ,
        ["District of Columbia", "District of Columbia"] ,
        ["Florida", "Florida"] ,
        ["Geogia", "Geogia"] ,
        ["Hawaii", "Hawaii"] ,
        ["Idaho", "Idaho"] ,
        ["Illinois", "Illinois"] ,
        ["Indiana", "Indiana"] ,
        ["Iowa", "Iowa"] ,
        ["Kansas", "Kansas"] ,
        ["Kentucky", "Kentucky"] ,
        ["Louisiana", "Louisiana"] ,
        ["Maine", "Maine"] ,
        ["Maryland", "Maryland"] ,
        ["Massachusetts", "Massachusetts"] ,
        ["Michigan", "Michigan"] ,
        ["Minnesota", "Minnesota"] ,
        ["Mississippi", "Mississippi"] ,
        ["Missouri", "Missouri"] ,
        ["Montana", "Montana"] ,
        ["Nebraska", "Nebraska"] ,
        ["Nevada", "Nevada"] ,
        ["New Hampshire", "New Hampshire"] ,
        ["New Jersey", "New Jersey"] ,
        ["New Mexico", "New Mexico"] ,
        ["New York", "New York"] ,
        ["North Carolina", "North Carolina"] ,
        ["North Dakota", "North Dakota"] ,
        ["Ohio", "Ohio"] ,
        ["Oklahoma", "Oklahoma"] ,
        ["Oregon", "Oregon"] ,
        ["Pennsylvania", "Pennsylvania"] ,
        ["Rhode Island", "Rhode Island"] ,
        ["South Carolina", "South Carolina"] ,
        ["South Dakota", "South Dakota"] ,
        ["Tennessee", "Tennessee"] ,
        ["Texas", "Texas"] ,
        ["Utah", "Utah"] ,
        ["Vermont", "Vermont"] ,
        ["Virginia", "Virginia"] ,
        ["Washington", "Washington"] ,
        ["West Virginia", "West Virginia"] ,
        ["Wisconsin", "Wisconsin"] ,
        ["Wyoming", "Wyoming"] 
    ],
    "Year": [
        
        ["1977", "1977"] ,
        ["1978", "1978"] ,
        ["1979", "1979"] ,
        ["1980", "1980"] ,
        ["1981", "1981"] ,
        ["1982", "1982"] ,
        ["1983", "1983"] ,
        ["1984", "1984"] ,
        ["1985", "1985"] ,
        ["1986", "1986"] ,
        ["1987", "1987"] ,
        ["1988", "1988"] ,
        ["1989", "1989"] ,
        ["1990", "1990"] ,
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
        ["2013", "2013"] 
    ]
}

var business_dynamics_PROPERTIES = [
    ["Net Job Creation", "Net Job Creation"] ,
    ["Net Job Creation Rate", "Net Job Creation Rate"] ,
    ["Reallocation Rate", "Reallocation Rate"] ,
    ["Entered", "Entered"] ,
    ["Entered Rate", "Entered Rate"] ,
    ["Exited", "Exited"] ,
    ["Exited Rate", "Exited Rate"] ,
    ["Physical Locations", "Physical Locations"] ,
    ["Firm Exits.Count", "Firm Exits.Count"] ,
    ["Establishment Exit", "Establishment Exit"] ,
    ["Job Destruction", "Job Destruction"] ,
    ["Births", "Births"] ,
    ["Job Creation.Continuers", "Job Creation.Continuers"] ,
    ["Job Creation.Count", "Job Creation.Count"] ,
    ["Job Creation.Rate", "Job Creation.Rate"] ,
    ["Rate/Births", "Rate/Births"] ,
    ["Job Destruction.Continuers", "Job Destruction.Continuers"] ,
    ["Job Destruction.Count", "Job Destruction.Count"] ,
    ["Deaths", "Deaths"] ,
    ["Job Destruction.Rate", "Job Destruction.Rate"] ,
    ["Rate/Deaths", "Rate/Deaths"] ,
    ["DHS Denominator", "DHS Denominator"] ,
    ["Number of Firms", "Number of Firms"] ,
    ["State", "State"] ,
    ["Year", "Year"] 
]

Blockly.Blocks['business_dynamics_get'] = {
  init: function() {
    this.setColour(WEATHER_HUE);
    this.appendDummyInput('MAIN')
        .appendField("business_dynamics.get")
        .appendField(new Blockly.FieldDropdown(business_dynamics_PROPERTIES), "PROPERTY");
    this.appendDummyInput('SECOND')
        .appendField("filter")
        .appendField(new Blockly.FieldDropdown(business_dynamics_INDEXES, function(option) {
                        this.sourceBlock_.updateShape_(option);
                    }), "INDEX")
    this.updateShape_("(None)");
    this.setInputsInline(false);
    this.setOutput(true, "Array");
    this.setTooltip('Returns a list of Business Dynamics data.');
  },
  mutationToDom: function() {
    var container = document.createElement('mutation');
    container.setAttribute('index', this.getFieldValue('INDEX'));
    container.setAttribute('index_value', this.getFieldValue('INDEX_VALUE'));
    container.setAttribute('module', "business_dynamics")
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
        inputGroup.appendField(new Blockly.FieldDropdown(business_dynamics_INDEX_VALUES[index]), 'INDEX_VALUE')
        if (index_value != undefined) {
            this.setFieldValue(index_value, 'INDEX_VALUE');
        } else {
            this.setFieldValue(business_dynamics_INDEX_VALUES[index][0][0], 'INDEX_VALUE');
        }
    }    
  }
};
Blockly.Python['business_dynamics_get'] = function(block) {
    Blockly.Python.definitions_['import_business_dynamics'] = 'import business_dynamics';
    var propertyValue = block.getFieldValue('PROPERTY') || '';
    var property = Blockly.Python.quote_(propertyValue);
    var index_unquoted = block.getFieldValue('INDEX');
    var index = Blockly.Python.quote_(index_unquoted || '');
    var index_value = "''";
    if (index_unquoted != '(None)') {
        var iv = block.getFieldValue('INDEX_VALUE') || "";
        index_value = Blockly.Python.quote_(iv);
    }
    var code = 'business_dynamics.get('+property+',' +index+','+index_value+')';
    return [code, Blockly.Python.ORDER_ATOMIC];
};

PythonToBlocks.KNOWN_MODULES['business_dynamics'] = {
    "get": ["business_dynamics_get", 
            "PROPERTY", 
            {"type": "mutation", "name": "@INDEX"},
            {"type": "mutation", "name": "@INDEX_VALUE"}]
};

BlockPyEditor.CATEGORY_MAP['Data - Business Dynamics'] = '<category name="Data - Business Dynamics" colour="50">'+
                    '<block type="business_dynamics_get"><mutation index="(None)" index_value=""></mutation></block>'+
                '</category>';