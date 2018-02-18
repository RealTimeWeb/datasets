

var finance_INDEXES = [
    ["(None)", "(None)"],
    
    ["Year", "Year"] ,
    ["State", "State"] 
];

var finance_INDEX_VALUES = {
    "(None)": [],
    
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
    ],
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

Tifa.MODULES['finance'] = {
    'name': "Module",
    'fields': {
        'get': Tifa.defineSupplier({"name": "List", "empty": false, "subtype": Tifa._NUM_TYPE()}),
        
        'get_finances': Tifa.defineSupplier(
		Tifa._LIST_OF_TYPE(
			Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Year'}, {"type": "Str", "value": 'State'}, {"type": "Str", "value": 'Totals'}, {"type": "Str", "value": 'Details'}], [
				Tifa._NUM_TYPE(), 
				Tifa._STR_TYPE(), 
				Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Charges'}, {"type": "Str", "value": 'Tax'}, {"type": "Str", "value": 'Expenditure'}, {"type": "Str", "value": 'State intergovernmental'}, {"type": "Str", "value": 'Equipment and land'}, {"type": "Str", "value": 'General expenditure'}, {"type": "Str", "value": 'General revenue'}, {"type": "Str", "value": 'Capital outlay'}, {"type": "Str", "value": 'Employee retirement revenue'}, {"type": "Str", "value": 'Revenue'}, {"type": "Str", "value": 'Local intergovernmental'}, {"type": "Str", "value": 'Utility revenue'}, {"type": "Str", "value": 'Unemployment comp revenue'}, {"type": "Str", "value": 'Miscellaneous'}, {"type": "Str", "value": 'Intergovernmental'}, {"type": "Str", "value": 'Sales tax'}, {"type": "Str", "value": 'Construction'}, {"type": "Str", "value": 'Insurance trust  revenue'}, {"type": "Str", "value": 'Miscellaneous commercial activity'}, {"type": "Str", "value": 'Selective sales tax'}, {"type": "Str", "value": "Worker's comp revenue"}, {"type": "Str", "value": 'Other insurance trust revenue'}, {"type": "Str", "value": 'License tax'}, {"type": "Str", "value": 'Federal intergovernmental'}], [
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE()]), 
				Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Education'}, {"type": "Str", "value": 'Intergovernmental'}, {"type": "Str", "value": 'Health'}, {"type": "Str", "value": 'Utilities'}, {"type": "Str", "value": 'Transportation'}, {"type": "Str", "value": 'Correction'}, {"type": "Str", "value": 'Employment'}, {"type": "Str", "value": 'Public Welfare'}, {"type": "Str", "value": 'Waste'}, {"type": "Str", "value": 'Welfare'}, {"type": "Str", "value": 'Insurance Trust'}, {"type": "Str", "value": 'Natural Resources'}, {"type": "Str", "value": 'Financial Aid'}], [
					Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Education-NEC Intergovernmental'}, {"type": "Str", "value": 'Higher Education-NEC Intergovernmental'}, {"type": "Str", "value": 'Elementary Secondary Total Expenditure'}, {"type": "Str", "value": 'Education Intergovernmental'}, {"type": "Str", "value": 'Education Construction'}, {"type": "Str", "value": 'Education Equipment'}, {"type": "Str", "value": 'Elementary Secondary Intergovernmental'}, {"type": "Str", "value": 'Education Total'}, {"type": "Str", "value": 'Education Equipment and Land'}, {"type": "Str", "value": 'Higher Education-Auxilliary Total Expenditure'}, {"type": "Str", "value": 'Education-NEC Expenditure Total'}, {"type": "Str", "value": 'Education Other Current Operation'}, {"type": "Str", "value": 'Edcation Assistance and Subsidies'}, {"type": "Str", "value": 'Higher Education-NEC Total Expenditure'}], [
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE()]), 
					Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Intergovernmental to Local'}, {"type": "Str", "value": 'Intergovernmental to Municipalities'}, {"type": "Str", "value": 'Intergovernmental to Townships'}, {"type": "Str", "value": 'Intergovernmental to Combined and Unallocable'}, {"type": "Str", "value": 'Intergovernmental to School Districts'}, {"type": "Str", "value": 'Intergovernmental Expenditure'}, {"type": "Str", "value": 'Intergovernmental to Federal'}, {"type": "Str", "value": 'Intergovernmental to State'}, {"type": "Str", "value": 'Intergovernmental to Counties'}, {"type": "Str", "value": 'Intergovernmental to Special Districts'}], [
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE()]), 
					Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Hospitals'}, {"type": "Str", "value": 'Health Total Expenditure'}, {"type": "Str", "value": 'Health Intergovernmental'}], [
						Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Hospitals Total Construction'}, {"type": "Str", "value": 'Hospitals Total Current'}, {"type": "Str", "value": 'Hospitals Total Intergovernmental'}, {"type": "Str", "value": 'Own Hospitals Total Expenditure'}, {"type": "Str", "value": 'Hospital-Other Intergovernmental'}, {"type": "Str", "value": 'Hospital-Other Total Expenditure'}, {"type": "Str", "value": 'Hospitals Total Expenditure'}, {"type": "Str", "value": 'Hospitals Total Equipment and land'}], [
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE()]), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE()]), 
					Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Utilities Current Operation'}, {"type": "Str", "value": 'Electric Utility Total Expenditure'}, {"type": "Str", "value": 'Utilities Construction'}, {"type": "Str", "value": 'Utilities Equipment and Land'}, {"type": "Str", "value": 'Utilities Interest Total'}, {"type": "Str", "value": 'Gas Utility Total Expenditure'}, {"type": "Str", "value": 'Transit Utility Total Expenditure'}, {"type": "Str", "value": 'Utilities Total Expenditure'}, {"type": "Str", "value": 'Water Utility Total Expenditure'}], [
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE()]), 
					Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Parking'}, {"type": "Str", "value": 'Transit Subsidy Intergovernmental'}, {"type": "Str", "value": 'Transit Subsidy Total Expenditure'}, {"type": "Str", "value": 'Highways'}, {"type": "Str", "value": 'Airports'}, {"type": "Str", "value": 'Water Transport'}], [
						Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Parking Total'}, {"type": "Str", "value": 'Parking Intergovernmental'}], [
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE()]), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Regular Highways Intergovernmental'}, {"type": "Str", "value": 'Regular Highways Total Expenditure'}, {"type": "Str", "value": 'Highways Total Expenditure'}, {"type": "Str", "value": 'Toll Highways Total Expenditure'}, {"type": "Str", "value": 'Highways Land and Equipment'}, {"type": "Str", "value": 'Highways Direct'}, {"type": "Str", "value": 'Highways Intergovernmental'}, {"type": "Str", "value": 'Highways Construction Total'}], [
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE()]), 
						Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Airports Intergovernmental'}, {"type": "Str", "value": 'Airports Total Expenditure'}], [
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE()]), 
						Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Water Transport Total Expenditure'}, {"type": "Str", "value": 'Water Transport Intergovernmental'}], [
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE()])]), 
					Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Correction NEC Total'}, {"type": "Str", "value": 'Correction Total'}, {"type": "Str", "value": 'Correction NEC Intergovernmental'}, {"type": "Str", "value": 'Correction Institutions Total'}, {"type": "Str", "value": 'Correction Intergovernmental'}], [
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE()]), 
					Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Employment Security Administration Expenditure Total'}, {"type": "Str", "value": 'Employment Security Administration Intergovernmental'}, {"type": "Str", "value": 'Unemployment Comp Total Cash and Securities'}, {"type": "Str", "value": 'Employee Retirement Total Expenditure'}, {"type": "Str", "value": 'Unemployment Comp Total Expenditure'}, {"type": "Str", "value": 'Employee Retirement Total Cash and Securities'}], [
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE()]), 
					Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Public Welfare Total Expenditure'}, {"type": "Str", "value": 'Public Welfare Construction'}, {"type": "Str", "value": 'Public Welfare Assistance and Subsidies'}, {"type": "Str", "value": 'Public Welfare Equipment and Land'}, {"type": "Str", "value": 'Public Welfare Other Current Operation'}, {"type": "Str", "value": 'Public Welfare Direct Expenditure'}, {"type": "Str", "value": 'Public Welfare Intergovernmental'}], [
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE()]), 
					Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Solid Waste Management Intergovernmental'}, {"type": "Str", "value": 'Sewerage Intergovernmental'}, {"type": "Str", "value": 'Sewerage Total Expenditure'}, {"type": "Str", "value": 'Solid Waste Management Total Expenditure'}], [
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE()]), 
					Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Welfare NEC Total Expenditure'}, {"type": "Str", "value": 'Welfare Institution Total Expenditure'}, {"type": "Str", "value": 'Welfare NEC Intergovernmental'}, {"type": "Str", "value": 'Welfare Vendor Payments Total'}], [
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE()]), 
					Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Insurance Trust Securities Total'}, {"type": "Str", "value": 'Insurance Trust Total Expenditure'}, {"type": "Str", "value": 'Insurance Trust State and Local Securities Total'}, {"type": "Str", "value": 'Insurance Trust Cash and Securities'}, {"type": "Str", "value": 'Insurance Trust Federal Agency Securities'}, {"type": "Str", "value": 'Insurance Trust Federal Securities'}, {"type": "Str", "value": 'Insurance Trust'}, {"type": "Str", "value": 'Insurance Trust Cash and Deposits'}, {"type": "Str", "value": 'Insurance Trust Other Securities'}], [
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE()]), 
					Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Fish and Game'}, {"type": "Str", "value": 'Forestry'}, {"type": "Str", "value": 'Natural Resources Equipment and Land'}, {"type": "Str", "value": 'Agriculture'}, {"type": "Str", "value": 'Natural Resources Total'}, {"type": "Str", "value": 'Natural Resources Construction'}, {"type": "Str", "value": 'Natural Resources Direct'}, {"type": "Str", "value": 'Parks'}, {"type": "Str", "value": 'Natural Resources NEC Total Expenditure'}, {"type": "Str", "value": 'Natural Resources Intergovernmental'}], [
						Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Fish and Game Total Expenditure'}, {"type": "Str", "value": 'Fish and Game Intergovernmental'}], [
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE()]), 
						Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Forestry Total Expenditure'}, {"type": "Str", "value": 'Forestry Intergovernmental'}], [
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE()]), 
						Tifa._NUM_TYPE(), 
						Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Federal Agriculture Farm Income Total'}, {"type": "Str", "value": 'Federal Farm Credit Total'}, {"type": "Str", "value": 'Federal Farm Credit Intergovernmental'}, {"type": "Str", "value": 'Agriculture Total Expenditure'}, {"type": "Str", "value": 'Federal Agriculture Farm Income Intergovernmental'}, {"type": "Str", "value": 'Agriculture Intergovernmental'}], [
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE()]), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Parks Total Expenditure'}, {"type": "Str", "value": 'Parks Intergovernmental'}], [
							Tifa._NUM_TYPE(), 
							Tifa._NUM_TYPE()]), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE()]), 
					Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Cash Assistance Intergovernmental'}, {"type": "Str", "value": 'Assistance and Subsidies'}, {"type": "Str", "value": 'Cash Assistance Total Expenditure'}, {"type": "Str", "value": 'Securities Total'}, {"type": "Str", "value": 'Beginning Long Term Debt Total Outstanding'}, {"type": "Str", "value": 'Categorical Assistance Total Expenditure'}, {"type": "Str", "value": 'Cash and Deposits Total'}, {"type": "Str", "value": 'Federal Agency Securities Total'}, {"type": "Str", "value": 'Bond Fund Total'}, {"type": "Str", "value": 'Cash and Securities Total'}, {"type": "Str", "value": 'Sinking Fund Total'}, {"type": "Str", "value": 'Categorical Assistance Intergovernmental'}, {"type": "Str", "value": 'Borrowing Total'}], [
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE()])])]))),
        
    }
};

BlockPyEditor.CATEGORY_MAP['Data - Finance'] = '<category name="Data - Finance" colour="50">'+
                    '<block type="finance_get"><mutation index="(None)" index_value=""></mutation></block>'+
                '</category>';