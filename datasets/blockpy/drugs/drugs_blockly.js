

var drugs_INDEXES = [
    ["(None)", "(None)"],
    
    ["State", "State"] ,
    ["Year", "Year"] 
];

var drugs_INDEX_VALUES = {
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
        ["Georgia", "Georgia"] ,
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
        ["2014", "2014"] 
    ]
}

var drugs_PROPERTIES = [
    ["12-17", "12-17"] ,
    ["12-20", "12-20"] ,
    ["18-25", "18-25"] ,
    ["26+", "26+"] ,
    ["Rates.Alcohol.Abuse Past Year.12-17", "Rates.Alcohol.Abuse Past Year.12-17"] ,
    ["Rates.Alcohol.Abuse Past Year.18-25", "Rates.Alcohol.Abuse Past Year.18-25"] ,
    ["Rates.Alcohol.Abuse Past Year.26+", "Rates.Alcohol.Abuse Past Year.26+"] ,
    ["Rates.Alcohol.Binge Past Month.12-17", "Rates.Alcohol.Binge Past Month.12-17"] ,
    ["Rates.Alcohol.Binge Past Month.18-25", "Rates.Alcohol.Binge Past Month.18-25"] ,
    ["Rates.Alcohol.Binge Past Month.26+", "Rates.Alcohol.Binge Past Month.26+"] ,
    ["Rates.Alcohol.Dependence Past Year.12-17", "Rates.Alcohol.Dependence Past Year.12-17"] ,
    ["Rates.Alcohol.Dependence Past Year.18-25", "Rates.Alcohol.Dependence Past Year.18-25"] ,
    ["Rates.Alcohol.Dependence Past Year.26+", "Rates.Alcohol.Dependence Past Year.26+"] ,
    ["Rates.Alcohol.In Minors.Abuse", "Rates.Alcohol.In Minors.Abuse"] ,
    ["Rates.Alcohol.In Minors.Use", "Rates.Alcohol.In Minors.Use"] ,
    ["Rates.Alcohol.Need Treatment Past Year.12-17", "Rates.Alcohol.Need Treatment Past Year.12-17"] ,
    ["Rates.Alcohol.Need Treatment Past Year.18-25", "Rates.Alcohol.Need Treatment Past Year.18-25"] ,
    ["Rates.Alcohol.Need Treatment Past Year.26+", "Rates.Alcohol.Need Treatment Past Year.26+"] ,
    ["Rates.Alcohol.Perceptions of Risk.12-17", "Rates.Alcohol.Perceptions of Risk.12-17"] ,
    ["Rates.Alcohol.Perceptions of Risk.18-25", "Rates.Alcohol.Perceptions of Risk.18-25"] ,
    ["Rates.Alcohol.Perceptions of Risk.26+", "Rates.Alcohol.Perceptions of Risk.26+"] ,
    ["Rates.Alcohol.Use Past Month.12-17", "Rates.Alcohol.Use Past Month.12-17"] ,
    ["Rates.Alcohol.Use Past Month.18-25", "Rates.Alcohol.Use Past Month.18-25"] ,
    ["Rates.Alcohol.Use Past Month.26+", "Rates.Alcohol.Use Past Month.26+"] ,
    ["Rates.Illicit Drugs.Abuse Past Year.12-17", "Rates.Illicit Drugs.Abuse Past Year.12-17"] ,
    ["Rates.Illicit Drugs.Abuse Past Year.18-25", "Rates.Illicit Drugs.Abuse Past Year.18-25"] ,
    ["Rates.Illicit Drugs.Abuse Past Year.26+", "Rates.Illicit Drugs.Abuse Past Year.26+"] ,
    ["Rates.Illicit Drugs.All Except Marijuana Used Past Month.12-17", "Rates.Illicit Drugs.All Except Marijuana Used Past Month.12-17"] ,
    ["Rates.Illicit Drugs.All Except Marijuana Used Past Month.18-25", "Rates.Illicit Drugs.All Except Marijuana Used Past Month.18-25"] ,
    ["Rates.Illicit Drugs.All Except Marijuana Used Past Month.26+", "Rates.Illicit Drugs.All Except Marijuana Used Past Month.26+"] ,
    ["Rates.Illicit Drugs.Cocaine Used Past Year.12-17", "Rates.Illicit Drugs.Cocaine Used Past Year.12-17"] ,
    ["Rates.Illicit Drugs.Cocaine Used Past Year.18-25", "Rates.Illicit Drugs.Cocaine Used Past Year.18-25"] ,
    ["Rates.Illicit Drugs.Cocaine Used Past Year.26+", "Rates.Illicit Drugs.Cocaine Used Past Year.26+"] ,
    ["Rates.Illicit Drugs.Dependence Past Year.12-17", "Rates.Illicit Drugs.Dependence Past Year.12-17"] ,
    ["Rates.Illicit Drugs.Dependence Past Year.18-25", "Rates.Illicit Drugs.Dependence Past Year.18-25"] ,
    ["Rates.Illicit Drugs.Dependence Past Year.26+", "Rates.Illicit Drugs.Dependence Past Year.26+"] ,
    ["Rates.Illicit Drugs.Need Treatment Past Year.12-17", "Rates.Illicit Drugs.Need Treatment Past Year.12-17"] ,
    ["Rates.Illicit Drugs.Need Treatment Past Year.18-25", "Rates.Illicit Drugs.Need Treatment Past Year.18-25"] ,
    ["Rates.Illicit Drugs.Need Treatment Past Year.26+", "Rates.Illicit Drugs.Need Treatment Past Year.26+"] ,
    ["Rates.Illicit Drugs.Used Past Month.12-17", "Rates.Illicit Drugs.Used Past Month.12-17"] ,
    ["Rates.Illicit Drugs.Used Past Month.18-25", "Rates.Illicit Drugs.Used Past Month.18-25"] ,
    ["Rates.Illicit Drugs.Used Past Month.26+", "Rates.Illicit Drugs.Used Past Month.26+"] ,
    ["Rates.Marijuana.New Users.12-17", "Rates.Marijuana.New Users.12-17"] ,
    ["Rates.Marijuana.New Users.18-25", "Rates.Marijuana.New Users.18-25"] ,
    ["Rates.Marijuana.New Users.26+", "Rates.Marijuana.New Users.26+"] ,
    ["Rates.Marijuana.Perceptions of Risk.12-17", "Rates.Marijuana.Perceptions of Risk.12-17"] ,
    ["Rates.Marijuana.Perceptions of Risk.18-25", "Rates.Marijuana.Perceptions of Risk.18-25"] ,
    ["Rates.Marijuana.Perceptions of Risk.26+", "Rates.Marijuana.Perceptions of Risk.26+"] ,
    ["Rates.Marijuana.Used Past Month.12-17", "Rates.Marijuana.Used Past Month.12-17"] ,
    ["Rates.Marijuana.Used Past Month.18-25", "Rates.Marijuana.Used Past Month.18-25"] ,
    ["Rates.Marijuana.Used Past Month.26+", "Rates.Marijuana.Used Past Month.26+"] ,
    ["Rates.Marijuana.Used Past Year.12-17", "Rates.Marijuana.Used Past Year.12-17"] ,
    ["Rates.Marijuana.Used Past Year.18-25", "Rates.Marijuana.Used Past Year.18-25"] ,
    ["Rates.Marijuana.Used Past Year.26+", "Rates.Marijuana.Used Past Year.26+"] ,
    ["Rates.Pain Relievers Abuse Past Year.12-17", "Rates.Pain Relievers Abuse Past Year.12-17"] ,
    ["Rates.Pain Relievers Abuse Past Year.18-25", "Rates.Pain Relievers Abuse Past Year.18-25"] ,
    ["Rates.Pain Relievers Abuse Past Year.26+", "Rates.Pain Relievers Abuse Past Year.26+"] ,
    ["Rates.Tobacco.Cigarette Past Month.12-17", "Rates.Tobacco.Cigarette Past Month.12-17"] ,
    ["Rates.Tobacco.Cigarette Past Month.18-25", "Rates.Tobacco.Cigarette Past Month.18-25"] ,
    ["Rates.Tobacco.Cigarette Past Month.26+", "Rates.Tobacco.Cigarette Past Month.26+"] ,
    ["Rates.Tobacco.Perceptions of Risk.12-17", "Rates.Tobacco.Perceptions of Risk.12-17"] ,
    ["Rates.Tobacco.Perceptions of Risk.18-25", "Rates.Tobacco.Perceptions of Risk.18-25"] ,
    ["Rates.Tobacco.Perceptions of Risk.26+", "Rates.Tobacco.Perceptions of Risk.26+"] ,
    ["Rates.Tobacco.Use Past Month.12-17", "Rates.Tobacco.Use Past Month.12-17"] ,
    ["Rates.Tobacco.Use Past Month.18-25", "Rates.Tobacco.Use Past Month.18-25"] ,
    ["Rates.Tobacco.Use Past Month.26+", "Rates.Tobacco.Use Past Month.26+"] ,
    ["State", "State"] ,
    ["Totals.Alcohol.Abuse Past Year.12-17", "Totals.Alcohol.Abuse Past Year.12-17"] ,
    ["Totals.Alcohol.Abuse Past Year.18-25", "Totals.Alcohol.Abuse Past Year.18-25"] ,
    ["Totals.Alcohol.Abuse Past Year.26+", "Totals.Alcohol.Abuse Past Year.26+"] ,
    ["Totals.Alcohol.Binge Past Month.12-17", "Totals.Alcohol.Binge Past Month.12-17"] ,
    ["Totals.Alcohol.Binge Past Month.18-25", "Totals.Alcohol.Binge Past Month.18-25"] ,
    ["Totals.Alcohol.Binge Past Month.26+", "Totals.Alcohol.Binge Past Month.26+"] ,
    ["Totals.Alcohol.Dependence Past Year.12-17", "Totals.Alcohol.Dependence Past Year.12-17"] ,
    ["Totals.Alcohol.Dependence Past Year.18-25", "Totals.Alcohol.Dependence Past Year.18-25"] ,
    ["Totals.Alcohol.Dependence Past Year.26+", "Totals.Alcohol.Dependence Past Year.26+"] ,
    ["Totals.Alcohol.In Minors.Abuse", "Totals.Alcohol.In Minors.Abuse"] ,
    ["Totals.Alcohol.In Minors.Use", "Totals.Alcohol.In Minors.Use"] ,
    ["Totals.Alcohol.Need Treatment Past Year.12-17", "Totals.Alcohol.Need Treatment Past Year.12-17"] ,
    ["Totals.Alcohol.Need Treatment Past Year.18-25", "Totals.Alcohol.Need Treatment Past Year.18-25"] ,
    ["Totals.Alcohol.Need Treatment Past Year.26+", "Totals.Alcohol.Need Treatment Past Year.26+"] ,
    ["Totals.Alcohol.Perceptions of Risk.12-17", "Totals.Alcohol.Perceptions of Risk.12-17"] ,
    ["Totals.Alcohol.Perceptions of Risk.18-25", "Totals.Alcohol.Perceptions of Risk.18-25"] ,
    ["Totals.Alcohol.Perceptions of Risk.26+", "Totals.Alcohol.Perceptions of Risk.26+"] ,
    ["Totals.Alcohol.Use Past Month.12-17", "Totals.Alcohol.Use Past Month.12-17"] ,
    ["Totals.Alcohol.Use Past Month.18-25", "Totals.Alcohol.Use Past Month.18-25"] ,
    ["Totals.Alcohol.Use Past Month.26+", "Totals.Alcohol.Use Past Month.26+"] ,
    ["Totals.Illicit Drugs.Abuse Past Year.12-17", "Totals.Illicit Drugs.Abuse Past Year.12-17"] ,
    ["Totals.Illicit Drugs.Abuse Past Year.18-25", "Totals.Illicit Drugs.Abuse Past Year.18-25"] ,
    ["Totals.Illicit Drugs.Abuse Past Year.26+", "Totals.Illicit Drugs.Abuse Past Year.26+"] ,
    ["Totals.Illicit Drugs.All Except Marijuana Used Past Month.12-17", "Totals.Illicit Drugs.All Except Marijuana Used Past Month.12-17"] ,
    ["Totals.Illicit Drugs.All Except Marijuana Used Past Month.18-25", "Totals.Illicit Drugs.All Except Marijuana Used Past Month.18-25"] ,
    ["Totals.Illicit Drugs.All Except Marijuana Used Past Month.26+", "Totals.Illicit Drugs.All Except Marijuana Used Past Month.26+"] ,
    ["Totals.Illicit Drugs.Cocaine Used Past Year.12-17", "Totals.Illicit Drugs.Cocaine Used Past Year.12-17"] ,
    ["Totals.Illicit Drugs.Cocaine Used Past Year.18-25", "Totals.Illicit Drugs.Cocaine Used Past Year.18-25"] ,
    ["Totals.Illicit Drugs.Cocaine Used Past Year.26+", "Totals.Illicit Drugs.Cocaine Used Past Year.26+"] ,
    ["Totals.Illicit Drugs.Dependence Past Year.12-17", "Totals.Illicit Drugs.Dependence Past Year.12-17"] ,
    ["Totals.Illicit Drugs.Dependence Past Year.18-25", "Totals.Illicit Drugs.Dependence Past Year.18-25"] ,
    ["Totals.Illicit Drugs.Dependence Past Year.26+", "Totals.Illicit Drugs.Dependence Past Year.26+"] ,
    ["Totals.Illicit Drugs.Need Treatment Past Year.12-17", "Totals.Illicit Drugs.Need Treatment Past Year.12-17"] ,
    ["Totals.Illicit Drugs.Need Treatment Past Year.18-25", "Totals.Illicit Drugs.Need Treatment Past Year.18-25"] ,
    ["Totals.Illicit Drugs.Need Treatment Past Year.26+", "Totals.Illicit Drugs.Need Treatment Past Year.26+"] ,
    ["Totals.Illicit Drugs.Used Past Month.12-17", "Totals.Illicit Drugs.Used Past Month.12-17"] ,
    ["Totals.Illicit Drugs.Used Past Month.18-25", "Totals.Illicit Drugs.Used Past Month.18-25"] ,
    ["Totals.Illicit Drugs.Used Past Month.26+", "Totals.Illicit Drugs.Used Past Month.26+"] ,
    ["Totals.Marijuana.New Users.12-17", "Totals.Marijuana.New Users.12-17"] ,
    ["Totals.Marijuana.New Users.18-25", "Totals.Marijuana.New Users.18-25"] ,
    ["Totals.Marijuana.New Users.26+", "Totals.Marijuana.New Users.26+"] ,
    ["Totals.Marijuana.Perceptions of Risk.12-17", "Totals.Marijuana.Perceptions of Risk.12-17"] ,
    ["Totals.Marijuana.Perceptions of Risk.18-25", "Totals.Marijuana.Perceptions of Risk.18-25"] ,
    ["Totals.Marijuana.Perceptions of Risk.26+", "Totals.Marijuana.Perceptions of Risk.26+"] ,
    ["Totals.Marijuana.Used Past Month.12-17", "Totals.Marijuana.Used Past Month.12-17"] ,
    ["Totals.Marijuana.Used Past Month.18-25", "Totals.Marijuana.Used Past Month.18-25"] ,
    ["Totals.Marijuana.Used Past Month.26+", "Totals.Marijuana.Used Past Month.26+"] ,
    ["Totals.Marijuana.Used Past Year.12-17", "Totals.Marijuana.Used Past Year.12-17"] ,
    ["Totals.Marijuana.Used Past Year.18-25", "Totals.Marijuana.Used Past Year.18-25"] ,
    ["Totals.Marijuana.Used Past Year.26+", "Totals.Marijuana.Used Past Year.26+"] ,
    ["Totals.Pain Relievers Abuse Past Year.12-17", "Totals.Pain Relievers Abuse Past Year.12-17"] ,
    ["Totals.Pain Relievers Abuse Past Year.18-25", "Totals.Pain Relievers Abuse Past Year.18-25"] ,
    ["Totals.Pain Relievers Abuse Past Year.26+", "Totals.Pain Relievers Abuse Past Year.26+"] ,
    ["Totals.Tobacco.Cigarette Past Month.12-17", "Totals.Tobacco.Cigarette Past Month.12-17"] ,
    ["Totals.Tobacco.Cigarette Past Month.18-25", "Totals.Tobacco.Cigarette Past Month.18-25"] ,
    ["Totals.Tobacco.Cigarette Past Month.26+", "Totals.Tobacco.Cigarette Past Month.26+"] ,
    ["Totals.Tobacco.Perceptions of Risk.12-17", "Totals.Tobacco.Perceptions of Risk.12-17"] ,
    ["Totals.Tobacco.Perceptions of Risk.18-25", "Totals.Tobacco.Perceptions of Risk.18-25"] ,
    ["Totals.Tobacco.Perceptions of Risk.26+", "Totals.Tobacco.Perceptions of Risk.26+"] ,
    ["Totals.Tobacco.Use Past Month.12-17", "Totals.Tobacco.Use Past Month.12-17"] ,
    ["Totals.Tobacco.Use Past Month.18-25", "Totals.Tobacco.Use Past Month.18-25"] ,
    ["Totals.Tobacco.Use Past Month.26+", "Totals.Tobacco.Use Past Month.26+"] ,
    ["Year", "Year"] 
]

Blockly.Blocks['drugs_get'] = {
  init: function() {
    this.setColour(WEATHER_HUE);
    this.appendDummyInput('MAIN')
        .appendField("drugs.get")
        .appendField(new Blockly.FieldDropdown(drugs_PROPERTIES), "PROPERTY");
    this.appendDummyInput('SECOND')
        .appendField("filter")
        .appendField(new Blockly.FieldDropdown(drugs_INDEXES, function(option) {
                        this.sourceBlock_.updateShape_(option);
                    }), "INDEX")
    this.updateShape_("(None)");
    this.setInputsInline(false);
    this.setOutput(true, "Array");
    this.setTooltip('Returns a list of Drugs data.');
  },
  mutationToDom: function() {
    var container = document.createElement('mutation');
    container.setAttribute('index', this.getFieldValue('INDEX'));
    container.setAttribute('index_value', this.getFieldValue('INDEX_VALUE'));
    container.setAttribute('module', "drugs")
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
        inputGroup.appendField(new Blockly.FieldDropdown(drugs_INDEX_VALUES[index]), 'INDEX_VALUE')
        if (index_value != undefined) {
            this.setFieldValue(index_value, 'INDEX_VALUE');
        } else {
            this.setFieldValue(drugs_INDEX_VALUES[index][0][0], 'INDEX_VALUE');
        }
    }    
  }
};
Blockly.Python['drugs_get'] = function(block) {
    Blockly.Python.definitions_['import_drugs'] = 'import drugs';
    var propertyValue = block.getFieldValue('PROPERTY') || '';
    var property = Blockly.Python.quote_(propertyValue);
    var index_unquoted = block.getFieldValue('INDEX');
    var index = Blockly.Python.quote_(index_unquoted || '');
    var index_value = "''";
    if (index_unquoted != '(None)') {
        var iv = block.getFieldValue('INDEX_VALUE') || "";
        index_value = Blockly.Python.quote_(iv);
    }
    var code = 'drugs.get('+property+',' +index+','+index_value+')';
    return [code, Blockly.Python.ORDER_ATOMIC];
};

PythonToBlocks.KNOWN_MODULES['drugs'] = {
    "get": ["drugs_get", 
            "PROPERTY", 
            {"type": "mutation", "name": "@INDEX"},
            {"type": "mutation", "name": "@INDEX_VALUE"}]
};

Tifa.MODULES['drugs'] = {
    'name': "Module",
    'fields': {
        'get': Tifa.defineSupplier({"name": "List", "empty": false, "subtype": Tifa._NUM_TYPE()}),
        
        'get_reports': Tifa.defineSupplier({
            "name": "List", "empty": false, "subtype": {
                "name": "Dict",
                "empty": false,
                "keys": Tifa._UNKNOWN_TYPE(),
                "values": Tifa._UNKNOWN_TYPE()
            }
        })
        
    }
};

BlockPyEditor.CATEGORY_MAP['Data - Drugs'] = '<category name="Data - Drugs" colour="50">'+
                    '<block type="drugs_get"><mutation index="(None)" index_value=""></mutation></block>'+
                '</category>';