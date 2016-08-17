

var airlines_INDEXES = [
    ["(None)", "(None)"],
    
    ["airport.code", "airport.code"] ,
    ["carrier.code", "carrier.code"] ,
    ["label", "label"] 
];

var airlines_INDEX_VALUES = {
    "(None)": [],
    
    "airport.code": [
        
        ["ATL", "ATL"] ,
        ["BOS", "BOS"] ,
        ["BWI", "BWI"] ,
        ["CLT", "CLT"] ,
        ["DCA", "DCA"] ,
        ["DEN", "DEN"] ,
        ["DFW", "DFW"] ,
        ["DTW", "DTW"] ,
        ["EWR", "EWR"] ,
        ["FLL", "FLL"] ,
        ["IAD", "IAD"] ,
        ["IAH", "IAH"] ,
        ["JFK", "JFK"] ,
        ["LAS", "LAS"] ,
        ["LAX", "LAX"] ,
        ["LGA", "LGA"] ,
        ["MCO", "MCO"] ,
        ["MDW", "MDW"] ,
        ["MIA", "MIA"] ,
        ["MSP", "MSP"] ,
        ["ORD", "ORD"] ,
        ["PDX", "PDX"] ,
        ["PHL", "PHL"] ,
        ["PHX", "PHX"] ,
        ["SAN", "SAN"] ,
        ["SEA", "SEA"] ,
        ["SFO", "SFO"] ,
        ["SLC", "SLC"] ,
        ["TPA", "TPA"] 
    ],
    "carrier.code": [
        
        ["9E", "9E"] ,
        ["AA", "AA"] ,
        ["AQ", "AQ"] ,
        ["AS", "AS"] ,
        ["B6", "B6"] ,
        ["CO", "CO"] ,
        ["DH", "DH"] ,
        ["DL", "DL"] ,
        ["EV", "EV"] ,
        ["F9", "F9"] ,
        ["FL", "FL"] ,
        ["HA", "HA"] ,
        ["HP", "HP"] ,
        ["MQ", "MQ"] ,
        ["NK", "NK"] ,
        ["NW", "NW"] ,
        ["OH", "OH"] ,
        ["OO", "OO"] ,
        ["RU", "RU"] ,
        ["TZ", "TZ"] ,
        ["UA", "UA"] ,
        ["US", "US"] ,
        ["VX", "VX"] ,
        ["WN", "WN"] ,
        ["XE", "XE"] ,
        ["YV", "YV"] 
    ],
    "label": [
        
        ["2003/10", "2003/10"] ,
        ["2003/11", "2003/11"] ,
        ["2003/12", "2003/12"] ,
        ["2003/6", "2003/6"] ,
        ["2003/7", "2003/7"] ,
        ["2003/8", "2003/8"] ,
        ["2003/9", "2003/9"] ,
        ["2004/1", "2004/1"] ,
        ["2004/10", "2004/10"] ,
        ["2004/11", "2004/11"] ,
        ["2004/12", "2004/12"] ,
        ["2004/2", "2004/2"] ,
        ["2004/3", "2004/3"] ,
        ["2004/4", "2004/4"] ,
        ["2004/5", "2004/5"] ,
        ["2004/6", "2004/6"] ,
        ["2004/7", "2004/7"] ,
        ["2004/8", "2004/8"] ,
        ["2004/9", "2004/9"] ,
        ["2005/1", "2005/1"] ,
        ["2005/10", "2005/10"] ,
        ["2005/11", "2005/11"] ,
        ["2005/12", "2005/12"] ,
        ["2005/2", "2005/2"] ,
        ["2005/3", "2005/3"] ,
        ["2005/4", "2005/4"] ,
        ["2005/5", "2005/5"] ,
        ["2005/6", "2005/6"] ,
        ["2005/7", "2005/7"] ,
        ["2005/8", "2005/8"] ,
        ["2005/9", "2005/9"] ,
        ["2006/1", "2006/1"] ,
        ["2006/10", "2006/10"] ,
        ["2006/11", "2006/11"] ,
        ["2006/12", "2006/12"] ,
        ["2006/2", "2006/2"] ,
        ["2006/3", "2006/3"] ,
        ["2006/4", "2006/4"] ,
        ["2006/5", "2006/5"] ,
        ["2006/6", "2006/6"] ,
        ["2006/7", "2006/7"] ,
        ["2006/8", "2006/8"] ,
        ["2006/9", "2006/9"] ,
        ["2007/1", "2007/1"] ,
        ["2007/10", "2007/10"] ,
        ["2007/11", "2007/11"] ,
        ["2007/12", "2007/12"] ,
        ["2007/2", "2007/2"] ,
        ["2007/3", "2007/3"] ,
        ["2007/4", "2007/4"] ,
        ["2007/5", "2007/5"] ,
        ["2007/6", "2007/6"] ,
        ["2007/7", "2007/7"] ,
        ["2007/8", "2007/8"] ,
        ["2007/9", "2007/9"] ,
        ["2008/1", "2008/1"] ,
        ["2008/10", "2008/10"] ,
        ["2008/11", "2008/11"] ,
        ["2008/12", "2008/12"] ,
        ["2008/2", "2008/2"] ,
        ["2008/3", "2008/3"] ,
        ["2008/4", "2008/4"] ,
        ["2008/5", "2008/5"] ,
        ["2008/6", "2008/6"] ,
        ["2008/7", "2008/7"] ,
        ["2008/8", "2008/8"] ,
        ["2008/9", "2008/9"] ,
        ["2009/1", "2009/1"] ,
        ["2009/10", "2009/10"] ,
        ["2009/11", "2009/11"] ,
        ["2009/12", "2009/12"] ,
        ["2009/2", "2009/2"] ,
        ["2009/3", "2009/3"] ,
        ["2009/4", "2009/4"] ,
        ["2009/5", "2009/5"] ,
        ["2009/6", "2009/6"] ,
        ["2009/7", "2009/7"] ,
        ["2009/8", "2009/8"] ,
        ["2009/9", "2009/9"] ,
        ["2010/1", "2010/1"] ,
        ["2010/10", "2010/10"] ,
        ["2010/11", "2010/11"] ,
        ["2010/12", "2010/12"] ,
        ["2010/2", "2010/2"] ,
        ["2010/3", "2010/3"] ,
        ["2010/4", "2010/4"] ,
        ["2010/5", "2010/5"] ,
        ["2010/6", "2010/6"] ,
        ["2010/7", "2010/7"] ,
        ["2010/8", "2010/8"] ,
        ["2010/9", "2010/9"] ,
        ["2011/1", "2011/1"] ,
        ["2011/10", "2011/10"] ,
        ["2011/11", "2011/11"] ,
        ["2011/12", "2011/12"] ,
        ["2011/2", "2011/2"] ,
        ["2011/3", "2011/3"] ,
        ["2011/4", "2011/4"] ,
        ["2011/5", "2011/5"] ,
        ["2011/6", "2011/6"] ,
        ["2011/7", "2011/7"] ,
        ["2011/8", "2011/8"] ,
        ["2011/9", "2011/9"] ,
        ["2012/1", "2012/1"] ,
        ["2012/10", "2012/10"] ,
        ["2012/11", "2012/11"] ,
        ["2012/12", "2012/12"] ,
        ["2012/2", "2012/2"] ,
        ["2012/3", "2012/3"] ,
        ["2012/4", "2012/4"] ,
        ["2012/5", "2012/5"] ,
        ["2012/6", "2012/6"] ,
        ["2012/7", "2012/7"] ,
        ["2012/8", "2012/8"] ,
        ["2012/9", "2012/9"] ,
        ["2013/1", "2013/1"] ,
        ["2013/10", "2013/10"] ,
        ["2013/11", "2013/11"] ,
        ["2013/12", "2013/12"] ,
        ["2013/2", "2013/2"] ,
        ["2013/3", "2013/3"] ,
        ["2013/4", "2013/4"] ,
        ["2013/5", "2013/5"] ,
        ["2013/6", "2013/6"] ,
        ["2013/7", "2013/7"] ,
        ["2013/8", "2013/8"] ,
        ["2013/9", "2013/9"] ,
        ["2014/1", "2014/1"] ,
        ["2014/10", "2014/10"] ,
        ["2014/11", "2014/11"] ,
        ["2014/12", "2014/12"] ,
        ["2014/2", "2014/2"] ,
        ["2014/3", "2014/3"] ,
        ["2014/4", "2014/4"] ,
        ["2014/5", "2014/5"] ,
        ["2014/6", "2014/6"] ,
        ["2014/7", "2014/7"] ,
        ["2014/8", "2014/8"] ,
        ["2014/9", "2014/9"] ,
        ["2015/1", "2015/1"] ,
        ["2015/10", "2015/10"] ,
        ["2015/11", "2015/11"] ,
        ["2015/12", "2015/12"] ,
        ["2015/2", "2015/2"] ,
        ["2015/3", "2015/3"] ,
        ["2015/4", "2015/4"] ,
        ["2015/5", "2015/5"] ,
        ["2015/6", "2015/6"] ,
        ["2015/7", "2015/7"] ,
        ["2015/8", "2015/8"] ,
        ["2015/9", "2015/9"] ,
        ["2016/1", "2016/1"] 
    ]
}

var airlines_PROPERTIES = [
    ["airport.code", "airport.code"] ,
    ["airport.name", "airport.name"] ,
    ["carrier.code", "carrier.code"] ,
    ["carrier.name", "carrier.name"] ,
    ["# of delays.carrier", "# of delays.carrier"] ,
    ["# of delays.late aircraft", "# of delays.late aircraft"] ,
    ["# of delays.national aviation system", "# of delays.national aviation system"] ,
    ["# of delays.security", "# of delays.security"] ,
    ["# of delays.weather", "# of delays.weather"] ,
    ["cancelled", "cancelled"] ,
    ["delayed", "delayed"] ,
    ["diverted", "diverted"] ,
    ["on time", "on time"] ,
    ["flights.total", "flights.total"] ,
    ["minutes delayed.carrier", "minutes delayed.carrier"] ,
    ["minutes delayed.late aircraft", "minutes delayed.late aircraft"] ,
    ["minutes delayed.national aviation system", "minutes delayed.national aviation system"] ,
    ["minutes delayed.security", "minutes delayed.security"] ,
    ["minutes delayed.total", "minutes delayed.total"] ,
    ["minutes delayed.weather", "minutes delayed.weather"] ,
    ["label", "label"] ,
    ["month", "month"] ,
    ["year", "year"] 
]

Blockly.Blocks['airlines_get'] = {
  init: function() {
    this.setColour(WEATHER_HUE);
    this.appendDummyInput('MAIN')
        .appendField("airlines.get")
        .appendField(new Blockly.FieldDropdown(airlines_PROPERTIES), "PROPERTY")
        .appendField("filter")
        .appendField(new Blockly.FieldDropdown(airlines_INDEXES, function(option) {
                        this.sourceBlock_.updateShape_(option);
                    }), "INDEX")
    this.updateShape_();
    this.setInputsInline(false);
    this.setOutput(true, "Array");
    this.setTooltip('Returns a list of Airlines data.');
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
        inputGroup.appendField(new Blockly.FieldDropdown(airlines_INDEX_VALUES[index]), 'INDEX_VALUE')
        if (index_value != undefined) {
            this.setFieldValue(index_value, 'INDEX_VALUE');
        } else {
            this.setFieldValue(airlines_INDEX_VALUES[index][0][0], 'INDEX_VALUE');
        }
    }    
  }
};
Blockly.Python['airlines_get'] = function(block) {
    Blockly.Python.definitions_['import_airlines'] = 'import airlines';
    var property = Blockly.Python.quote_(block.getFieldValue('PROPERTY'));
    var index_unquoted = block.getFieldValue('INDEX');
    var index = Blockly.Python.quote_(index_unquoted);
    var index_value = "''";
    if (index_unquoted != '(None)') {
        var iv = block.getFieldValue('INDEX_VALUE') || "";
        index_value = Blockly.Python.quote_(iv);
    }
    var code = 'airlines.get('+property+',' +index+','+index_value+')';
    return [code, Blockly.Python.ORDER_ATOMIC];
};

PythonToBlocks.KNOWN_MODULES['airlines'] = {
    "get": ["airlines_get", 
            "PROPERTY", 
            {"type": "mutation", "name": "@INDEX"},
            {"type": "mutation", "name": "@INDEX_VALUE"}]
};

AbstractInterpreter.MODULES['airlines'] = {
    'get': {"type": "List", "empty": false, "component": {"type": 'Num'}}
};

BlockPyEditor.CATEGORY_MAP['Data - Airlines'] = '<category name="Data - Airlines" colour="50">'+
                    '<block type="airlines_get"><mutation index="(None)" index_value=""></mutation></block>'+
                '</category>';