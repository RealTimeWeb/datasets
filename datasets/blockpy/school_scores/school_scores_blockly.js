

var school_scores_INDEXES = [
    ["(None)", "(None)"],
    
    ["Name", "Name"] ,
    ["Year", "Year"] 
];

var school_scores_INDEX_VALUES = {
    "(None)": [],
    
    "Name": [
        
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
        ["Puerto Rico", "Puerto Rico"] ,
        ["Rhode Island", "Rhode Island"] ,
        ["South Carolina", "South Carolina"] ,
        ["South Dakota", "South Dakota"] ,
        ["Tennessee", "Tennessee"] ,
        ["Texas", "Texas"] ,
        ["Utah", "Utah"] ,
        ["Vermont", "Vermont"] ,
        ["Virgin Islands", "Virgin Islands"] ,
        ["Virginia", "Virginia"] ,
        ["Washington", "Washington"] ,
        ["West Virginia", "West Virginia"] ,
        ["Wisconsin", "Wisconsin"] ,
        ["Wyoming", "Wyoming"] 
    ],
    "Year": [
        
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

var school_scores_PROPERTIES = [
    ["Arts/Music.Average GPA", "Arts/Music.Average GPA"] ,
    ["Arts/Music.Average Years", "Arts/Music.Average Years"] ,
    ["English.Average GPA", "English.Average GPA"] ,
    ["English.Average Years", "English.Average Years"] ,
    ["Foreign Languages.Average GPA", "Foreign Languages.Average GPA"] ,
    ["Foreign Languages.Average Years", "Foreign Languages.Average Years"] ,
    ["Mathematics.Average GPA", "Mathematics.Average GPA"] ,
    ["Mathematics.Average Years", "Mathematics.Average Years"] ,
    ["Natural Sciences.Average GPA", "Natural Sciences.Average GPA"] ,
    ["Natural Sciences.Average Years", "Natural Sciences.Average Years"] ,
    ["Social Sciences/History.Average GPA", "Social Sciences/History.Average GPA"] ,
    ["Social Sciences/History.Average Years", "Social Sciences/History.Average Years"] ,
    ["Between 20-40k.Math", "Between 20-40k.Math"] ,
    ["Between 20-40k.Test-takers", "Between 20-40k.Test-takers"] ,
    ["Between 20-40k.Verbal", "Between 20-40k.Verbal"] ,
    ["Between 40-60k.Math", "Between 40-60k.Math"] ,
    ["Between 40-60k.Test-takers", "Between 40-60k.Test-takers"] ,
    ["Between 40-60k.Verbal", "Between 40-60k.Verbal"] ,
    ["Between 60-80k.Math", "Between 60-80k.Math"] ,
    ["Between 60-80k.Test-takers", "Between 60-80k.Test-takers"] ,
    ["Between 60-80k.Verbal", "Between 60-80k.Verbal"] ,
    ["Between 80-100k.Math", "Between 80-100k.Math"] ,
    ["Between 80-100k.Test-takers", "Between 80-100k.Test-takers"] ,
    ["Between 80-100k.Verbal", "Between 80-100k.Verbal"] ,
    ["Less than 20k.Math", "Less than 20k.Math"] ,
    ["Less than 20k.Test-takers", "Less than 20k.Test-takers"] ,
    ["Less than 20k.Verbal", "Less than 20k.Verbal"] ,
    ["More than 100k.Math", "More than 100k.Math"] ,
    ["More than 100k.Test-takers", "More than 100k.Test-takers"] ,
    ["More than 100k.Verbal", "More than 100k.Verbal"] ,
    ["Female.Math", "Female.Math"] ,
    ["Female.Test-takers", "Female.Test-takers"] ,
    ["Female.Verbal", "Female.Verbal"] ,
    ["Male.Math", "Male.Math"] ,
    ["Male.Test-takers", "Male.Test-takers"] ,
    ["Male.Verbal", "Male.Verbal"] ,
    ["A minus.Math", "A minus.Math"] ,
    ["A minus.Test-takers", "A minus.Test-takers"] ,
    ["A minus.Verbal", "A minus.Verbal"] ,
    ["A plus.Math", "A plus.Math"] ,
    ["A plus.Test-takers", "A plus.Test-takers"] ,
    ["A plus.Verbal", "A plus.Verbal"] ,
    ["A.Math", "A.Math"] ,
    ["A.Test-takers", "A.Test-takers"] ,
    ["A.Verbal", "A.Verbal"] ,
    ["B.Math", "B.Math"] ,
    ["B.Test-takers", "B.Test-takers"] ,
    ["B.Verbal", "B.Verbal"] ,
    ["C.Math", "C.Math"] ,
    ["C.Test-takers", "C.Test-takers"] ,
    ["C.Verbal", "C.Verbal"] ,
    ["D or lower.Math", "D or lower.Math"] ,
    ["D or lower.Test-takers", "D or lower.Test-takers"] ,
    ["D or lower.Verbal", "D or lower.Verbal"] ,
    ["No response.Math", "No response.Math"] ,
    ["No response.Test-takers", "No response.Test-takers"] ,
    ["No response.Verbal", "No response.Verbal"] ,
    ["Between 200 to 300.Math.Females", "Between 200 to 300.Math.Females"] ,
    ["Between 200 to 300.Math.Males", "Between 200 to 300.Math.Males"] ,
    ["Between 200 to 300.Math.Total", "Between 200 to 300.Math.Total"] ,
    ["Between 200 to 300.Verbal.Females", "Between 200 to 300.Verbal.Females"] ,
    ["Between 200 to 300.Verbal.Males", "Between 200 to 300.Verbal.Males"] ,
    ["Between 200 to 300.Verbal.Total", "Between 200 to 300.Verbal.Total"] ,
    ["Between 300 to 400.Math.Females", "Between 300 to 400.Math.Females"] ,
    ["Between 300 to 400.Math.Males", "Between 300 to 400.Math.Males"] ,
    ["Between 300 to 400.Math.Total", "Between 300 to 400.Math.Total"] ,
    ["Between 300 to 400.Verbal.Females", "Between 300 to 400.Verbal.Females"] ,
    ["Between 300 to 400.Verbal.Males", "Between 300 to 400.Verbal.Males"] ,
    ["Between 300 to 400.Verbal.Total", "Between 300 to 400.Verbal.Total"] ,
    ["Between 400 to 500.Math.Females", "Between 400 to 500.Math.Females"] ,
    ["Between 400 to 500.Math.Males", "Between 400 to 500.Math.Males"] ,
    ["Between 400 to 500.Math.Total", "Between 400 to 500.Math.Total"] ,
    ["Between 400 to 500.Verbal.Females", "Between 400 to 500.Verbal.Females"] ,
    ["Between 400 to 500.Verbal.Males", "Between 400 to 500.Verbal.Males"] ,
    ["Between 400 to 500.Verbal.Total", "Between 400 to 500.Verbal.Total"] ,
    ["Between 500 to 600.Math.Females", "Between 500 to 600.Math.Females"] ,
    ["Between 500 to 600.Math.Males", "Between 500 to 600.Math.Males"] ,
    ["Between 500 to 600.Math.Total", "Between 500 to 600.Math.Total"] ,
    ["Between 500 to 600.Verbal.Females", "Between 500 to 600.Verbal.Females"] ,
    ["Between 500 to 600.Verbal.Males", "Between 500 to 600.Verbal.Males"] ,
    ["Between 500 to 600.Verbal.Total", "Between 500 to 600.Verbal.Total"] ,
    ["Between 600 to 700.Math.Females", "Between 600 to 700.Math.Females"] ,
    ["Between 600 to 700.Math.Males", "Between 600 to 700.Math.Males"] ,
    ["Between 600 to 700.Math.Total", "Between 600 to 700.Math.Total"] ,
    ["Between 600 to 700.Verbal.Females", "Between 600 to 700.Verbal.Females"] ,
    ["Between 600 to 700.Verbal.Males", "Between 600 to 700.Verbal.Males"] ,
    ["Between 600 to 700.Verbal.Total", "Between 600 to 700.Verbal.Total"] ,
    ["Between 700 to 800.Math.Females", "Between 700 to 800.Math.Females"] ,
    ["Between 700 to 800.Math.Males", "Between 700 to 800.Math.Males"] ,
    ["Between 700 to 800.Math.Total", "Between 700 to 800.Math.Total"] ,
    ["Between 700 to 800.Verbal.Females", "Between 700 to 800.Verbal.Females"] ,
    ["Between 700 to 800.Verbal.Males", "Between 700 to 800.Verbal.Males"] ,
    ["Between 700 to 800.Verbal.Total", "Between 700 to 800.Verbal.Total"] ,
    ["Code", "Code"] ,
    ["Name", "Name"] ,
    ["Math", "Math"] ,
    ["Test-takers", "Test-takers"] ,
    ["Verbal", "Verbal"] ,
    ["Year", "Year"] 
]

Blockly.Blocks['school_scores_get'] = {
  init: function() {
    this.setColour(WEATHER_HUE);
    this.appendDummyInput('MAIN')
        .appendField("school_scores.get")
        .appendField(new Blockly.FieldDropdown(school_scores_PROPERTIES), "PROPERTY");
    this.appendDummyInput('SECOND')
        .appendField("filter")
        .appendField(new Blockly.FieldDropdown(school_scores_INDEXES, function(option) {
                        this.sourceBlock_.updateShape_(option);
                    }), "INDEX")
    this.updateShape_("(None)");
    this.setInputsInline(false);
    this.setOutput(true, "Array");
    this.setTooltip('Returns a list of School Scores data.');
  },
  mutationToDom: function() {
    var container = document.createElement('mutation');
    container.setAttribute('index', this.getFieldValue('INDEX'));
    container.setAttribute('index_value', this.getFieldValue('INDEX_VALUE'));
    container.setAttribute('module', "school_scores")
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
        inputGroup.appendField(new Blockly.FieldDropdown(school_scores_INDEX_VALUES[index]), 'INDEX_VALUE')
        if (index_value != undefined) {
            this.setFieldValue(index_value, 'INDEX_VALUE');
        } else {
            this.setFieldValue(school_scores_INDEX_VALUES[index][0][0], 'INDEX_VALUE');
        }
    }    
  }
};
Blockly.Python['school_scores_get'] = function(block) {
    Blockly.Python.definitions_['import_school_scores'] = 'import school_scores';
    var propertyValue = block.getFieldValue('PROPERTY') || '';
    var property = Blockly.Python.quote_(propertyValue);
    var index_unquoted = block.getFieldValue('INDEX');
    var index = Blockly.Python.quote_(index_unquoted || '');
    var index_value = "''";
    if (index_unquoted != '(None)') {
        var iv = block.getFieldValue('INDEX_VALUE') || "";
        index_value = Blockly.Python.quote_(iv);
    }
    var code = 'school_scores.get('+property+',' +index+','+index_value+')';
    return [code, Blockly.Python.ORDER_ATOMIC];
};

PythonToBlocks.KNOWN_MODULES['school_scores'] = {
    "get": ["school_scores_get", 
            "PROPERTY", 
            {"type": "mutation", "name": "@INDEX"},
            {"type": "mutation", "name": "@INDEX_VALUE"}]
};

BlockPyEditor.CATEGORY_MAP['Data - School Scores'] = '<category name="Data - School Scores" colour="50">'+
                    '<block type="school_scores_get"><mutation index="(None)" index_value=""></mutation></block>'+
                '</category>';