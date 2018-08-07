

var finance_INDEXES = [
    ["(None)", "(None)"],
    
    ["State", "State"] ,
    ["Year", "Year"] 
];

var finance_INDEX_VALUES = {
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
        ["United States", "United States"] ,
        ["Utah", "Utah"] ,
        ["Vermont", "Vermont"] ,
        ["Virginia", "Virginia"] ,
        ["Washington", "Washington"] ,
        ["West Virginia", "West Virginia"] ,
        ["Wisconsin", "Wisconsin"] ,
        ["Wyoming", "Wyoming"] 
    ],
    "Year": [
        
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

var finance_PROPERTIES = [
    ["Correction Institutions Total", "Correction Institutions Total"] ,
    ["Correction Intergovernmental", "Correction Intergovernmental"] ,
    ["Correction NEC Intergovernmental", "Correction NEC Intergovernmental"] ,
    ["Correction NEC Total", "Correction NEC Total"] ,
    ["Correction Total", "Correction Total"] ,
    ["Edcation Assistance and Subsidies", "Edcation Assistance and Subsidies"] ,
    ["Education Construction", "Education Construction"] ,
    ["Education Equipment", "Education Equipment"] ,
    ["Education Equipment and Land", "Education Equipment and Land"] ,
    ["Education Intergovernmental", "Education Intergovernmental"] ,
    ["Education Other Current Operation", "Education Other Current Operation"] ,
    ["Education Total", "Education Total"] ,
    ["Education-NEC Expenditure Total", "Education-NEC Expenditure Total"] ,
    ["Education-NEC Intergovernmental", "Education-NEC Intergovernmental"] ,
    ["Elementary Secondary Intergovernmental", "Elementary Secondary Intergovernmental"] ,
    ["Elementary Secondary Total Expenditure", "Elementary Secondary Total Expenditure"] ,
    ["Higher Education-Auxilliary Total Expenditure", "Higher Education-Auxilliary Total Expenditure"] ,
    ["Higher Education-NEC Intergovernmental", "Higher Education-NEC Intergovernmental"] ,
    ["Higher Education-NEC Total Expenditure", "Higher Education-NEC Total Expenditure"] ,
    ["Employee Retirement Total Cash and Securities", "Employee Retirement Total Cash and Securities"] ,
    ["Employee Retirement Total Expenditure", "Employee Retirement Total Expenditure"] ,
    ["Employment Security Administration Expenditure Total", "Employment Security Administration Expenditure Total"] ,
    ["Employment Security Administration Intergovernmental", "Employment Security Administration Intergovernmental"] ,
    ["Unemployment Comp Total Cash and Securities", "Unemployment Comp Total Cash and Securities"] ,
    ["Unemployment Comp Total Expenditure", "Unemployment Comp Total Expenditure"] ,
    ["Assistance and Subsidies", "Assistance and Subsidies"] ,
    ["Beginning Long Term Debt Total Outstanding", "Beginning Long Term Debt Total Outstanding"] ,
    ["Bond Fund Total", "Bond Fund Total"] ,
    ["Borrowing Total", "Borrowing Total"] ,
    ["Cash and Deposits Total", "Cash and Deposits Total"] ,
    ["Cash and Securities Total", "Cash and Securities Total"] ,
    ["Cash Assistance Intergovernmental", "Cash Assistance Intergovernmental"] ,
    ["Cash Assistance Total Expenditure", "Cash Assistance Total Expenditure"] ,
    ["Categorical Assistance Intergovernmental", "Categorical Assistance Intergovernmental"] ,
    ["Categorical Assistance Total Expenditure", "Categorical Assistance Total Expenditure"] ,
    ["Federal Agency Securities Total", "Federal Agency Securities Total"] ,
    ["Securities Total", "Securities Total"] ,
    ["Sinking Fund Total", "Sinking Fund Total"] ,
    ["Hospital-Other Intergovernmental", "Hospital-Other Intergovernmental"] ,
    ["Hospital-Other Total Expenditure", "Hospital-Other Total Expenditure"] ,
    ["Hospitals Total Construction", "Hospitals Total Construction"] ,
    ["Hospitals Total Current", "Hospitals Total Current"] ,
    ["Hospitals Total Equipment and land", "Hospitals Total Equipment and land"] ,
    ["Hospitals Total Expenditure", "Hospitals Total Expenditure"] ,
    ["Hospitals Total Intergovernmental", "Hospitals Total Intergovernmental"] ,
    ["Own Hospitals Total Expenditure", "Own Hospitals Total Expenditure"] ,
    ["Health Intergovernmental", "Health Intergovernmental"] ,
    ["Health Total Expenditure", "Health Total Expenditure"] ,
    ["Insurance Trust", "Insurance Trust"] ,
    ["Insurance Trust Cash and Deposits", "Insurance Trust Cash and Deposits"] ,
    ["Insurance Trust Cash and Securities", "Insurance Trust Cash and Securities"] ,
    ["Insurance Trust Federal Agency Securities", "Insurance Trust Federal Agency Securities"] ,
    ["Insurance Trust Federal Securities", "Insurance Trust Federal Securities"] ,
    ["Insurance Trust Other Securities", "Insurance Trust Other Securities"] ,
    ["Insurance Trust Securities Total", "Insurance Trust Securities Total"] ,
    ["Insurance Trust State and Local Securities Total", "Insurance Trust State and Local Securities Total"] ,
    ["Insurance Trust Total Expenditure", "Insurance Trust Total Expenditure"] ,
    ["Intergovernmental Expenditure", "Intergovernmental Expenditure"] ,
    ["Intergovernmental to Combined and Unallocable", "Intergovernmental to Combined and Unallocable"] ,
    ["Intergovernmental to Counties", "Intergovernmental to Counties"] ,
    ["Intergovernmental to Federal", "Intergovernmental to Federal"] ,
    ["Intergovernmental to Local", "Intergovernmental to Local"] ,
    ["Intergovernmental to Municipalities", "Intergovernmental to Municipalities"] ,
    ["Intergovernmental to School Districts", "Intergovernmental to School Districts"] ,
    ["Intergovernmental to Special Districts", "Intergovernmental to Special Districts"] ,
    ["Intergovernmental to State", "Intergovernmental to State"] ,
    ["Intergovernmental to Townships", "Intergovernmental to Townships"] ,
    ["Agriculture Intergovernmental", "Agriculture Intergovernmental"] ,
    ["Agriculture Total Expenditure", "Agriculture Total Expenditure"] ,
    ["Federal Agriculture Farm Income Intergovernmental", "Federal Agriculture Farm Income Intergovernmental"] ,
    ["Federal Agriculture Farm Income Total", "Federal Agriculture Farm Income Total"] ,
    ["Federal Farm Credit Intergovernmental", "Federal Farm Credit Intergovernmental"] ,
    ["Federal Farm Credit Total", "Federal Farm Credit Total"] ,
    ["Fish and Game Intergovernmental", "Fish and Game Intergovernmental"] ,
    ["Fish and Game Total Expenditure", "Fish and Game Total Expenditure"] ,
    ["Forestry Intergovernmental", "Forestry Intergovernmental"] ,
    ["Forestry Total Expenditure", "Forestry Total Expenditure"] ,
    ["Parks Intergovernmental", "Parks Intergovernmental"] ,
    ["Parks Total Expenditure", "Parks Total Expenditure"] ,
    ["Natural Resources Construction", "Natural Resources Construction"] ,
    ["Natural Resources Direct", "Natural Resources Direct"] ,
    ["Natural Resources Equipment and Land", "Natural Resources Equipment and Land"] ,
    ["Natural Resources Intergovernmental", "Natural Resources Intergovernmental"] ,
    ["Natural Resources NEC Total Expenditure", "Natural Resources NEC Total Expenditure"] ,
    ["Natural Resources Total", "Natural Resources Total"] ,
    ["Public Welfare Assistance and Subsidies", "Public Welfare Assistance and Subsidies"] ,
    ["Public Welfare Construction", "Public Welfare Construction"] ,
    ["Public Welfare Direct Expenditure", "Public Welfare Direct Expenditure"] ,
    ["Public Welfare Equipment and Land", "Public Welfare Equipment and Land"] ,
    ["Public Welfare Intergovernmental", "Public Welfare Intergovernmental"] ,
    ["Public Welfare Other Current Operation", "Public Welfare Other Current Operation"] ,
    ["Public Welfare Total Expenditure", "Public Welfare Total Expenditure"] ,
    ["Airports Intergovernmental", "Airports Intergovernmental"] ,
    ["Airports Total Expenditure", "Airports Total Expenditure"] ,
    ["Highways Construction Total", "Highways Construction Total"] ,
    ["Highways Direct", "Highways Direct"] ,
    ["Highways Intergovernmental", "Highways Intergovernmental"] ,
    ["Highways Land and Equipment", "Highways Land and Equipment"] ,
    ["Highways Total Expenditure", "Highways Total Expenditure"] ,
    ["Regular Highways Intergovernmental", "Regular Highways Intergovernmental"] ,
    ["Regular Highways Total Expenditure", "Regular Highways Total Expenditure"] ,
    ["Toll Highways Total Expenditure", "Toll Highways Total Expenditure"] ,
    ["Parking Intergovernmental", "Parking Intergovernmental"] ,
    ["Parking Total", "Parking Total"] ,
    ["Water Transport Intergovernmental", "Water Transport Intergovernmental"] ,
    ["Water Transport Total Expenditure", "Water Transport Total Expenditure"] ,
    ["Transit Subsidy Intergovernmental", "Transit Subsidy Intergovernmental"] ,
    ["Transit Subsidy Total Expenditure", "Transit Subsidy Total Expenditure"] ,
    ["Electric Utility Total Expenditure", "Electric Utility Total Expenditure"] ,
    ["Gas Utility Total Expenditure", "Gas Utility Total Expenditure"] ,
    ["Transit Utility Total Expenditure", "Transit Utility Total Expenditure"] ,
    ["Utilities Construction", "Utilities Construction"] ,
    ["Utilities Current Operation", "Utilities Current Operation"] ,
    ["Utilities Equipment and Land", "Utilities Equipment and Land"] ,
    ["Utilities Interest Total", "Utilities Interest Total"] ,
    ["Utilities Total Expenditure", "Utilities Total Expenditure"] ,
    ["Water Utility Total Expenditure", "Water Utility Total Expenditure"] ,
    ["Sewerage Intergovernmental", "Sewerage Intergovernmental"] ,
    ["Sewerage Total Expenditure", "Sewerage Total Expenditure"] ,
    ["Solid Waste Management Intergovernmental", "Solid Waste Management Intergovernmental"] ,
    ["Solid Waste Management Total Expenditure", "Solid Waste Management Total Expenditure"] ,
    ["Welfare Institution Total Expenditure", "Welfare Institution Total Expenditure"] ,
    ["Welfare NEC Intergovernmental", "Welfare NEC Intergovernmental"] ,
    ["Welfare NEC Total Expenditure", "Welfare NEC Total Expenditure"] ,
    ["Welfare Vendor Payments Total", "Welfare Vendor Payments Total"] ,
    ["State", "State"] ,
    ["Capital outlay", "Capital outlay"] ,
    ["Charges", "Charges"] ,
    ["Construction", "Construction"] ,
    ["Employee retirement revenue", "Employee retirement revenue"] ,
    ["Equipment and land", "Equipment and land"] ,
    ["Expenditure", "Expenditure"] ,
    ["Federal intergovernmental", "Federal intergovernmental"] ,
    ["General expenditure", "General expenditure"] ,
    ["General revenue", "General revenue"] ,
    ["Insurance trust  revenue", "Insurance trust  revenue"] ,
    ["Intergovernmental", "Intergovernmental"] ,
    ["License tax", "License tax"] ,
    ["Local intergovernmental", "Local intergovernmental"] ,
    ["Miscellaneous", "Miscellaneous"] ,
    ["Miscellaneous commercial activity", "Miscellaneous commercial activity"] ,
    ["Other insurance trust revenue", "Other insurance trust revenue"] ,
    ["Revenue", "Revenue"] ,
    ["Sales tax", "Sales tax"] ,
    ["Selective sales tax", "Selective sales tax"] ,
    ["State intergovernmental", "State intergovernmental"] ,
    ["Tax", "Tax"] ,
    ["Unemployment comp revenue", "Unemployment comp revenue"] ,
    ["Utility revenue", "Utility revenue"] ,
    ["Worker's comp revenue", "Worker's comp revenue"] ,
    ["Year", "Year"] 
]

Blockly.Blocks['finance_get'] = {
  init: function() {
    this.setColour(WEATHER_HUE);
    this.appendDummyInput('MAIN')
        .appendField("finance.get")
        .appendField(new Blockly.FieldDropdown(finance_PROPERTIES), "PROPERTY");
    this.appendDummyInput('SECOND')
        .appendField("filter")
        .appendField(new Blockly.FieldDropdown(finance_INDEXES, function(option) {
                        this.sourceBlock_.updateShape_(option);
                    }), "INDEX")
    this.updateShape_("(None)");
    this.setInputsInline(false);
    this.setOutput(true, "Array");
    this.setTooltip('Returns a list of Finance data.');
  },
  mutationToDom: function() {
    var container = document.createElement('mutation');
    container.setAttribute('index', this.getFieldValue('INDEX'));
    container.setAttribute('index_value', this.getFieldValue('INDEX_VALUE'));
    container.setAttribute('module', "finance")
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
        inputGroup.appendField(new Blockly.FieldDropdown(finance_INDEX_VALUES[index]), 'INDEX_VALUE')
        if (index_value != undefined) {
            this.setFieldValue(index_value, 'INDEX_VALUE');
        } else {
            this.setFieldValue(finance_INDEX_VALUES[index][0][0], 'INDEX_VALUE');
        }
    }    
  }
};
Blockly.Python['finance_get'] = function(block) {
    Blockly.Python.definitions_['import_finance'] = 'import finance';
    var propertyValue = block.getFieldValue('PROPERTY') || '';
    var property = Blockly.Python.quote_(propertyValue);
    var index_unquoted = block.getFieldValue('INDEX');
    var index = Blockly.Python.quote_(index_unquoted || '');
    var index_value = "''";
    if (index_unquoted != '(None)') {
        var iv = block.getFieldValue('INDEX_VALUE') || "";
        index_value = Blockly.Python.quote_(iv);
    }
    var code = 'finance.get('+property+',' +index+','+index_value+')';
    return [code, Blockly.Python.ORDER_ATOMIC];
};

PythonToBlocks.KNOWN_MODULES['finance'] = {
    "get": ["finance_get", 
            "PROPERTY", 
            {"type": "mutation", "name": "@INDEX"},
            {"type": "mutation", "name": "@INDEX_VALUE"}]
};

BlockPyEditor.CATEGORY_MAP['Data - Finance'] = '<category name="Data - Finance" colour="50">'+
                    '<block type="finance_get"><mutation index="(None)" index_value=""></mutation></block>'+
                '</category>';