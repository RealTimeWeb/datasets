

var aids_INDEXES = [
    ["(None)", "(None)"],
    
    ["Country", "Country"] ,
    ["Year", "Year"] 
];

var aids_INDEX_VALUES = {
    "(None)": [],
    
    "Country": [
        
        ["Afghanistan", "Afghanistan"] ,
        ["Algeria", "Algeria"] ,
        ["Angola", "Angola"] ,
        ["Argentina", "Argentina"] ,
        ["Australia", "Australia"] ,
        ["Azerbaijan", "Azerbaijan"] ,
        ["Bahamas", "Bahamas"] ,
        ["Bangladesh", "Bangladesh"] ,
        ["Belarus", "Belarus"] ,
        ["Belize", "Belize"] ,
        ["Benin", "Benin"] ,
        ["Bolivia (Plurinational State of)", "Bolivia (Plurinational State of)"] ,
        ["Botswana", "Botswana"] ,
        ["Brazil", "Brazil"] ,
        ["Burkina Faso", "Burkina Faso"] ,
        ["Burundi", "Burundi"] ,
        ["C?te d'Ivoire", "C?te d'Ivoire"] ,
        ["Cameroon", "Cameroon"] ,
        ["Cape Verde", "Cape Verde"] ,
        ["Central African Republic", "Central African Republic"] ,
        ["Chad", "Chad"] ,
        ["Colombia", "Colombia"] ,
        ["Costa Rica", "Costa Rica"] ,
        ["Cuba", "Cuba"] ,
        ["Democratic Republic of the Congo", "Democratic Republic of the Congo"] ,
        ["Djibouti", "Djibouti"] ,
        ["Dominican Republic", "Dominican Republic"] ,
        ["Ecuador", "Ecuador"] ,
        ["Egypt", "Egypt"] ,
        ["El Salvador", "El Salvador"] ,
        ["Equatorial Guinea", "Equatorial Guinea"] ,
        ["Eritrea", "Eritrea"] ,
        ["Gabon", "Gabon"] ,
        ["Gambia", "Gambia"] ,
        ["Georgia", "Georgia"] ,
        ["Ghana", "Ghana"] ,
        ["Greece", "Greece"] ,
        ["Guatemala", "Guatemala"] ,
        ["Guinea", "Guinea"] ,
        ["Guyana", "Guyana"] ,
        ["Haiti", "Haiti"] ,
        ["Honduras", "Honduras"] ,
        ["Indonesia", "Indonesia"] ,
        ["Iran (Islamic Republic of)", "Iran (Islamic Republic of)"] ,
        ["Italy", "Italy"] ,
        ["Jamaica", "Jamaica"] ,
        ["Kazakhstan", "Kazakhstan"] ,
        ["Kenya", "Kenya"] ,
        ["Kyrgyzstan", "Kyrgyzstan"] ,
        ["Latvia", "Latvia"] ,
        ["Lesotho", "Lesotho"] ,
        ["Liberia", "Liberia"] ,
        ["Madagascar", "Madagascar"] ,
        ["Malawi", "Malawi"] ,
        ["Malaysia", "Malaysia"] ,
        ["Mali", "Mali"] ,
        ["Mauritania", "Mauritania"] ,
        ["Mexico", "Mexico"] ,
        ["Mongolia", "Mongolia"] ,
        ["Morocco", "Morocco"] ,
        ["Mozambique", "Mozambique"] ,
        ["Myanmar", "Myanmar"] ,
        ["Namibia", "Namibia"] ,
        ["Nepal", "Nepal"] ,
        ["Nicaragua", "Nicaragua"] ,
        ["Niger", "Niger"] ,
        ["Nigeria", "Nigeria"] ,
        ["Pakistan", "Pakistan"] ,
        ["Panama", "Panama"] ,
        ["Papua New Guinea", "Papua New Guinea"] ,
        ["Paraguay", "Paraguay"] ,
        ["Peru", "Peru"] ,
        ["Philippines", "Philippines"] ,
        ["Republic of Moldova", "Republic of Moldova"] ,
        ["Rwanda", "Rwanda"] ,
        ["Senegal", "Senegal"] ,
        ["Sierra Leone", "Sierra Leone"] ,
        ["Somalia", "Somalia"] ,
        ["South Africa", "South Africa"] ,
        ["South Sudan", "South Sudan"] ,
        ["Spain", "Spain"] ,
        ["Sri Lanka", "Sri Lanka"] ,
        ["Sudan", "Sudan"] ,
        ["Suriname", "Suriname"] ,
        ["Swaziland", "Swaziland"] ,
        ["Tajikistan", "Tajikistan"] ,
        ["Thailand", "Thailand"] ,
        ["Togo", "Togo"] ,
        ["Trinidad and Tobago", "Trinidad and Tobago"] ,
        ["Uganda", "Uganda"] ,
        ["Ukraine", "Ukraine"] ,
        ["United Republic of Tanzania", "United Republic of Tanzania"] ,
        ["Uruguay", "Uruguay"] ,
        ["Uzbekistan", "Uzbekistan"] ,
        ["Venezuela (Bolivarian Republic of)", "Venezuela (Bolivarian Republic of)"] ,
        ["Viet Nam", "Viet Nam"] ,
        ["Yemen", "Yemen"] ,
        ["Zambia", "Zambia"] ,
        ["Zimbabwe", "Zimbabwe"] 
    ],
    "Year": [
        
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
        ["2013", "2013"] ,
        ["2014", "2014"] ,
        ["2015", "2015"] 
    ]
}

var aids_PROPERTIES = [
    ["Country", "Country"] ,
    ["AIDS-Related Deaths.Adults", "AIDS-Related Deaths.Adults"] ,
    ["AIDS Orphans", "AIDS Orphans"] ,
    ["AIDS-Related Deaths.All Ages", "AIDS-Related Deaths.All Ages"] ,
    ["AIDS-Related Deaths.Children", "AIDS-Related Deaths.Children"] ,
    ["AIDS-Related Deaths.Female Adults", "AIDS-Related Deaths.Female Adults"] ,
    ["AIDS-Related Deaths.Male Adults", "AIDS-Related Deaths.Male Adults"] ,
    ["HIV Prevalence.Adults", "HIV Prevalence.Adults"] ,
    ["Young Men", "Young Men"] ,
    ["Young Women", "Young Women"] ,
    ["New HIV Infections.Adults", "New HIV Infections.Adults"] ,
    ["New HIV Infections.All Ages", "New HIV Infections.All Ages"] ,
    ["New HIV Infections.Children", "New HIV Infections.Children"] ,
    ["New HIV Infections.Female Adults", "New HIV Infections.Female Adults"] ,
    ["Incidence Rate Among Adults", "Incidence Rate Among Adults"] ,
    ["New HIV Infections.Male Adults", "New HIV Infections.Male Adults"] ,
    ["People Living with HIV.Adults", "People Living with HIV.Adults"] ,
    ["People Living with HIV.Children", "People Living with HIV.Children"] ,
    ["People Living with HIV.Female Adults", "People Living with HIV.Female Adults"] ,
    ["People Living with HIV.Male Adults", "People Living with HIV.Male Adults"] ,
    ["Total", "Total"] ,
    ["Year", "Year"] 
]

Blockly.Blocks['aids_get'] = {
  init: function() {
    this.setColour(WEATHER_HUE);
    this.appendDummyInput('MAIN')
        .appendField("aids.get")
        .appendField(new Blockly.FieldDropdown(aids_PROPERTIES), "PROPERTY");
    this.appendDummyInput('SECOND')
        .appendField("filter")
        .appendField(new Blockly.FieldDropdown(aids_INDEXES, function(option) {
                        this.sourceBlock_.updateShape_(option);
                    }), "INDEX")
    this.updateShape_("(None)");
    this.setInputsInline(false);
    this.setOutput(true, "Array");
    this.setTooltip('Returns a list of Aids data.');
  },
  mutationToDom: function() {
    var container = document.createElement('mutation');
    container.setAttribute('index', this.getFieldValue('INDEX'));
    container.setAttribute('index_value', this.getFieldValue('INDEX_VALUE'));
    container.setAttribute('module', "aids")
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
        inputGroup.appendField(new Blockly.FieldDropdown(aids_INDEX_VALUES[index]), 'INDEX_VALUE')
        if (index_value != undefined) {
            this.setFieldValue(index_value, 'INDEX_VALUE');
        } else {
            this.setFieldValue(aids_INDEX_VALUES[index][0][0], 'INDEX_VALUE');
        }
    }    
  }
};
Blockly.Python['aids_get'] = function(block) {
    Blockly.Python.definitions_['import_aids'] = 'import aids';
    var propertyValue = block.getFieldValue('PROPERTY') || '';
    var property = Blockly.Python.quote_(propertyValue);
    var index_unquoted = block.getFieldValue('INDEX');
    var index = Blockly.Python.quote_(index_unquoted || '');
    var index_value = "''";
    if (index_unquoted != '(None)') {
        var iv = block.getFieldValue('INDEX_VALUE') || "";
        index_value = Blockly.Python.quote_(iv);
    }
    var code = 'aids.get('+property+',' +index+','+index_value+')';
    return [code, Blockly.Python.ORDER_ATOMIC];
};

PythonToBlocks.KNOWN_MODULES['aids'] = {
    "get": ["aids_get", 
            "PROPERTY", 
            {"type": "mutation", "name": "@INDEX"},
            {"type": "mutation", "name": "@INDEX_VALUE"}]
};

AbstractInterpreter.MODULES['aids'] = {
    'get': {"type": "List", "empty": false, "subtype": {"type": 'Num'}}
};

BlockPyEditor.CATEGORY_MAP['Data - Aids'] = '<category name="Data - Aids" colour="50">'+
                    '<block type="aids_get"><mutation index="(None)" index_value=""></mutation></block>'+
                '</category>';