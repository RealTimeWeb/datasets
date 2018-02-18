

var state_demographics_INDEXES = [
    ["(None)", "(None)"],
    
    ["State", "State"] 
];

var state_demographics_INDEX_VALUES = {
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
        ["District Of Columbia", "District Of Columbia"] ,
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

var state_demographics_PROPERTIES = [
    ["Percent 65 and Older", "Percent 65 and Older"] ,
    ["Percent Under 18 Years", "Percent Under 18 Years"] ,
    ["Percent Under 5 Years", "Percent Under 5 Years"] ,
    ["Bachelor's Degree or Higher", "Bachelor's Degree or Higher"] ,
    ["High School or Higher", "High School or Higher"] ,
    ["American Indian-Owned", "American Indian-Owned"] ,
    ["Asian-Owned", "Asian-Owned"] ,
    ["Black-Owned", "Black-Owned"] ,
    ["Hispanic-Owned", "Hispanic-Owned"] ,
    ["Native Hawaiian and Other Pacific Islander-Owned", "Native Hawaiian and Other Pacific Islander-Owned"] ,
    ["Total", "Total"] ,
    ["Women-Owned", "Women-Owned"] ,
    ["Nonemployer Establishments", "Nonemployer Establishments"] ,
    ["Private Non-farm Employment", "Private Non-farm Employment"] ,
    ["Private Non-farm Employment Percent Change", "Private Non-farm Employment Percent Change"] ,
    ["Private Non-farm Establishments", "Private Non-farm Establishments"] ,
    ["American Indian and Alaska Native Alone", "American Indian and Alaska Native Alone"] ,
    ["Asian Alone", "Asian Alone"] ,
    ["Black Alone", "Black Alone"] ,
    ["Hispanic or Latino", "Hispanic or Latino"] ,
    ["Native Hawaiian and Other Pacific Islander Alone", "Native Hawaiian and Other Pacific Islander Alone"] ,
    ["Two or More Races", "Two or More Races"] ,
    ["White Alone", "White Alone"] ,
    ["White Alone, not Hispanic or Latino", "White Alone, not Hispanic or Latino"] ,
    ["Homeownership Rate", "Homeownership Rate"] ,
    ["Households", "Households"] ,
    ["Housing Units", "Housing Units"] ,
    ["Median Value of Owner-Occupied Units", "Median Value of Owner-Occupied Units"] ,
    ["Persons per Household", "Persons per Household"] ,
    ["Units in Multi-Unit Structures", "Units in Multi-Unit Structures"] ,
    ["Median Houseold Income", "Median Houseold Income"] ,
    ["Per Capita Income", "Per Capita Income"] ,
    ["Persons Below Poverty Level", "Persons Below Poverty Level"] ,
    ["Building Permits", "Building Permits"] ,
    ["Foreign Born", "Foreign Born"] ,
    ["Land Area", "Land Area"] ,
    ["Language Other than English at Home", "Language Other than English at Home"] ,
    ["Living in Same House +1 Years", "Living in Same House +1 Years"] ,
    ["Manufacturers Shipments", "Manufacturers Shipments"] ,
    ["Mean Travel Time to Work", "Mean Travel Time to Work"] ,
    ["Percent Female", "Percent Female"] ,
    ["Veterans", "Veterans"] ,
    ["2010 Population", "2010 Population"] ,
    ["2014 Population", "2014 Population"] ,
    ["Population per Square Mile", "Population per Square Mile"] ,
    ["Population Percent Change", "Population Percent Change"] ,
    ["Accommodation and Food Services Sales", "Accommodation and Food Services Sales"] ,
    ["Merchant Wholesaler Sales", "Merchant Wholesaler Sales"] ,
    ["Retail Sales", "Retail Sales"] ,
    ["Retail Sales per Capita", "Retail Sales per Capita"] ,
    ["State", "State"] 
]

Blockly.Blocks['state_demographics_get'] = {
  init: function() {
    this.setColour(WEATHER_HUE);
    this.appendDummyInput('MAIN')
        .appendField("state_demographics.get")
        .appendField(new Blockly.FieldDropdown(state_demographics_PROPERTIES), "PROPERTY");
    this.appendDummyInput('SECOND')
        .appendField("filter")
        .appendField(new Blockly.FieldDropdown(state_demographics_INDEXES, function(option) {
                        this.sourceBlock_.updateShape_(option);
                    }), "INDEX")
    this.updateShape_("(None)");
    this.setInputsInline(false);
    this.setOutput(true, "Array");
    this.setTooltip('Returns a list of State Demographics data.');
  },
  mutationToDom: function() {
    var container = document.createElement('mutation');
    container.setAttribute('index', this.getFieldValue('INDEX'));
    container.setAttribute('index_value', this.getFieldValue('INDEX_VALUE'));
    container.setAttribute('module', "state_demographics")
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
        inputGroup.appendField(new Blockly.FieldDropdown(state_demographics_INDEX_VALUES[index]), 'INDEX_VALUE')
        if (index_value != undefined) {
            this.setFieldValue(index_value, 'INDEX_VALUE');
        } else {
            this.setFieldValue(state_demographics_INDEX_VALUES[index][0][0], 'INDEX_VALUE');
        }
    }    
  }
};
Blockly.Python['state_demographics_get'] = function(block) {
    Blockly.Python.definitions_['import_state_demographics'] = 'import state_demographics';
    var propertyValue = block.getFieldValue('PROPERTY') || '';
    var property = Blockly.Python.quote_(propertyValue);
    var index_unquoted = block.getFieldValue('INDEX');
    var index = Blockly.Python.quote_(index_unquoted || '');
    var index_value = "''";
    if (index_unquoted != '(None)') {
        var iv = block.getFieldValue('INDEX_VALUE') || "";
        index_value = Blockly.Python.quote_(iv);
    }
    var code = 'state_demographics.get('+property+',' +index+','+index_value+')';
    return [code, Blockly.Python.ORDER_ATOMIC];
};

PythonToBlocks.KNOWN_MODULES['state_demographics'] = {
    "get": ["state_demographics_get", 
            "PROPERTY", 
            {"type": "mutation", "name": "@INDEX"},
            {"type": "mutation", "name": "@INDEX_VALUE"}]
};

Tifa.MODULES['state_demographics'] = {
    'name': "Module",
    'fields': {
        'get': Tifa.defineSupplier({"name": "List", "empty": false, "subtype": Tifa._NUM_TYPE()}),
        
        'get_all_states': Tifa.defineSupplier(
		Tifa._LIST_OF_TYPE(
			Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Housing'}, {"type": "Str", "value": 'Employment'}, {"type": "Str", "value": 'Education'}, {"type": "Str", "value": 'Ethnicities'}, {"type": "Str", "value": 'Miscellaneous'}, {"type": "Str", "value": 'Population'}, {"type": "Str", "value": 'Income'}, {"type": "Str", "value": 'Sales'}, {"type": "Str", "value": 'Age'}, {"type": "Str", "value": 'State'}], [
				Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Homeownership Rate'}, {"type": "Str", "value": 'Median Value of Owner-Occupied Units'}, {"type": "Str", "value": 'Units in Multi-Unit Structures'}, {"type": "Str", "value": 'Persons per Household'}, {"type": "Str", "value": 'Households'}, {"type": "Str", "value": 'Housing Units'}], [
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE()]), 
				Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Private Non-farm Establishments'}, {"type": "Str", "value": 'Private Non-farm Employment'}, {"type": "Str", "value": 'Private Non-farm Employment Percent Change'}, {"type": "Str", "value": 'Nonemployer Establishments'}, {"type": "Str", "value": 'Firms'}], [
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Hispanic-Owned'}, {"type": "Str", "value": 'Women-Owned'}, {"type": "Str", "value": 'Black-Owned'}, {"type": "Str", "value": 'Total'}, {"type": "Str", "value": 'American Indian-Owned'}, {"type": "Str", "value": 'Native Hawaiian and Other Pacific Islander-Owned'}, {"type": "Str", "value": 'Asian-Owned'}], [
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE(), 
						Tifa._NUM_TYPE()])]), 
				Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": "Bachelor's Degree or Higher"}, {"type": "Str", "value": 'High School or Higher'}], [
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE()]), 
				Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'White Alone, not Hispanic or Latino'}, {"type": "Str", "value": 'Black Alone'}, {"type": "Str", "value": 'Asian Alone'}, {"type": "Str", "value": 'Hispanic or Latino'}, {"type": "Str", "value": 'Two or More Races'}, {"type": "Str", "value": 'White Alone'}, {"type": "Str", "value": 'American Indian and Alaska Native Alone'}, {"type": "Str", "value": 'Native Hawaiian and Other Pacific Islander Alone'}], [
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE()]), 
				Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Percent Female'}, {"type": "Str", "value": 'Foreign Born'}, {"type": "Str", "value": 'Language Other than English at Home'}, {"type": "Str", "value": 'Manufacturers Shipments'}, {"type": "Str", "value": 'Land Area'}, {"type": "Str", "value": 'Veterans'}, {"type": "Str", "value": 'Mean Travel Time to Work'}, {"type": "Str", "value": 'Building Permits'}, {"type": "Str", "value": 'Living in Same House +1 Years'}], [
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE()]), 
				Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Population per Square Mile'}, {"type": "Str", "value": '2010 Population'}, {"type": "Str", "value": '2014 Population'}, {"type": "Str", "value": 'Population Percent Change'}], [
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE()]), 
				Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Median Houseold Income'}, {"type": "Str", "value": 'Persons Below Poverty Level'}, {"type": "Str", "value": 'Per Capita Income'}], [
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE()]), 
				Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Retail Sales'}, {"type": "Str", "value": 'Accommodation and Food Services Sales'}, {"type": "Str", "value": 'Retail Sales per Capita'}, {"type": "Str", "value": 'Merchant Wholesaler Sales'}], [
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE()]), 
				Tifa._DICT_LITERAL_TYPE([{"type": "Str", "value": 'Percent Under 18 Years'}, {"type": "Str", "value": 'Percent Under 5 Years'}, {"type": "Str", "value": 'Percent 65 and Older'}], [
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE(), 
					Tifa._NUM_TYPE()]), 
				Tifa._STR_TYPE()]))),
        
    }
};

BlockPyEditor.CATEGORY_MAP['Data - State Demographics'] = '<category name="Data - State Demographics" colour="50">'+
                    '<block type="state_demographics_get"><mutation index="(None)" index_value=""></mutation></block>'+
                '</category>';