

var weather_INDEXES = [
    ["(None)", "(None)"],
    
    ["Full", "Full"] ,
    ["Location", "Location"] 
];

var weather_INDEX_VALUES = {
    "(None)": [],
    
    "Full": [
        
        ["04-10-2016", "04-10-2016"] ,
        ["04-11-2016", "04-11-2016"] ,
        ["04-12-2016", "04-12-2016"] ,
        ["04-13-2016", "04-13-2016"] ,
        ["04-14-2016", "04-14-2016"] ,
        ["04-15-2016", "04-15-2016"] ,
        ["04-16-2016", "04-16-2016"] ,
        ["04-17-2016", "04-17-2016"] ,
        ["04-18-2016", "04-18-2016"] ,
        ["04-19-2016", "04-19-2016"] ,
        ["04-20-2016", "04-20-2016"] ,
        ["04-21-2016", "04-21-2016"] ,
        ["04-22-2016", "04-22-2016"] ,
        ["04-23-2016", "04-23-2016"] ,
        ["04-24-2016", "04-24-2016"] ,
        ["04-25-2016", "04-25-2016"] ,
        ["04-26-2016", "04-26-2016"] ,
        ["04-27-2016", "04-27-2016"] ,
        ["04-28-2016", "04-28-2016"] ,
        ["04-29-2016", "04-29-2016"] ,
        ["04-30-2016", "04-30-2016"] ,
        ["05-01-2016", "05-01-2016"] ,
        ["05-02-2016", "05-02-2016"] ,
        ["05-03-2016", "05-03-2016"] ,
        ["05-04-2016", "05-04-2016"] ,
        ["05-05-2016", "05-05-2016"] ,
        ["05-06-2016", "05-06-2016"] ,
        ["05-07-2016", "05-07-2016"] ,
        ["05-08-2016", "05-08-2016"] ,
        ["05-09-2016", "05-09-2016"] ,
        ["05-10-2016", "05-10-2016"] ,
        ["05-11-2016", "05-11-2016"] ,
        ["05-12-2016", "05-12-2016"] ,
        ["05-13-2016", "05-13-2016"] ,
        ["05-14-2016", "05-14-2016"] ,
        ["05-15-2016", "05-15-2016"] ,
        ["05-16-2016", "05-16-2016"] ,
        ["05-17-2016", "05-17-2016"] ,
        ["05-18-2016", "05-18-2016"] ,
        ["05-19-2016", "05-19-2016"] ,
        ["05-20-2016", "05-20-2016"] ,
        ["05-21-2016", "05-21-2016"] ,
        ["05-22-2016", "05-22-2016"] ,
        ["05-23-2016", "05-23-2016"] ,
        ["05-24-2016", "05-24-2016"] ,
        ["05-25-2016", "05-25-2016"] ,
        ["05-26-2016", "05-26-2016"] ,
        ["05-27-2016", "05-27-2016"] ,
        ["05-28-2016", "05-28-2016"] ,
        ["05-29-2016", "05-29-2016"] ,
        ["05-30-2016", "05-30-2016"] ,
        ["05-31-2016", "05-31-2016"] ,
        ["06-01-2016", "06-01-2016"] ,
        ["06-02-2016", "06-02-2016"] ,
        ["06-03-2016", "06-03-2016"] ,
        ["06-04-2016", "06-04-2016"] ,
        ["06-05-2016", "06-05-2016"] ,
        ["06-06-2016", "06-06-2016"] ,
        ["06-07-2016", "06-07-2016"] ,
        ["06-08-2016", "06-08-2016"] ,
        ["06-09-2016", "06-09-2016"] 
    ],
    "Location": [
        
        ["Aberdeen, SD", "Aberdeen, SD"] ,
        ["Albany, NY", "Albany, NY"] ,
        ["Albuquerque, NM", "Albuquerque, NM"] ,
        ["Amarillo, TX", "Amarillo, TX"] ,
        ["Anchorage, AK", "Anchorage, AK"] ,
        ["Austin/San Antonio, TX", "Austin/San Antonio, TX"] ,
        ["Baltimore/Washington, VA", "Baltimore/Washington, VA"] ,
        ["Billings, MT", "Billings, MT"] ,
        ["Binghamton, NY", "Binghamton, NY"] ,
        ["Birmingham, AL", "Birmingham, AL"] ,
        ["Bismarck, ND", "Bismarck, ND"] ,
        ["Blacksburg, VA", "Blacksburg, VA"] ,
        ["Boise, ID", "Boise, ID"] ,
        ["Boston, MD", "Boston, MD"] ,
        ["Brownsville, TX", "Brownsville, TX"] ,
        ["Buffalo, NY", "Buffalo, NY"] ,
        ["Burlington, VT", "Burlington, VT"] ,
        ["Caribou, ME", "Caribou, ME"] ,
        ["Charleston, SC", "Charleston, SC"] ,
        ["Charleston, WV", "Charleston, WV"] ,
        ["Cheyenne, WY", "Cheyenne, WY"] ,
        ["Chicago, IL", "Chicago, IL"] ,
        ["Cleveland, OH", "Cleveland, OH"] ,
        ["Columbia, SC", "Columbia, SC"] ,
        ["Corpus Christi, TX", "Corpus Christi, TX"] ,
        ["Davenport/Quad Cities, IA", "Davenport/Quad Cities, IA"] ,
        ["Denver/Boulder, CO", "Denver/Boulder, CO"] ,
        ["Des Moines, IA", "Des Moines, IA"] ,
        ["Detroit/Pontiac, MI", "Detroit/Pontiac, MI"] ,
        ["Dodge City, KS", "Dodge City, KS"] ,
        ["El Paso, TX", "El Paso, TX"] ,
        ["Elko, NV", "Elko, NV"] ,
        ["Eureka, CA", "Eureka, CA"] ,
        ["Fairbanks, AK", "Fairbanks, AK"] ,
        ["Flagstaff, AZ", "Flagstaff, AZ"] ,
        ["Fort Worth/Dallas, TX", "Fort Worth/Dallas, TX"] ,
        ["Gaylord, MI", "Gaylord, MI"] ,
        ["Glasgow, MT", "Glasgow, MT"] ,
        ["Goodland, KS", "Goodland, KS"] ,
        ["Grand Forks, ND", "Grand Forks, ND"] ,
        ["Grand Junction, CO", "Grand Junction, CO"] ,
        ["Grand Rapids, MI", "Grand Rapids, MI"] ,
        ["Gray/Portland, ME", "Gray/Portland, ME"] ,
        ["Great Falls, MT", "Great Falls, MT"] ,
        ["Green Bay, WI", "Green Bay, WI"] ,
        ["Greenville-Spartanburg, SC", "Greenville-Spartanburg, SC"] ,
        ["Hastings, NE", "Hastings, NE"] ,
        ["Houston/Galveston, TX", "Houston/Galveston, TX"] ,
        ["Huntsville, AL", "Huntsville, AL"] ,
        ["Indianapolis, IN", "Indianapolis, IN"] ,
        ["Jackson, KY", "Jackson, KY"] ,
        ["Jackson, MS", "Jackson, MS"] ,
        ["Jacksonville, FL", "Jacksonville, FL"] ,
        ["Juneau, AK", "Juneau, AK"] ,
        ["Kansas City/Pleasant Hill, MO", "Kansas City/Pleasant Hill, MO"] ,
        ["Key West, FL", "Key West, FL"] ,
        ["La Crosse, WI", "La Crosse, WI"] ,
        ["Lake Charles, LA", "Lake Charles, LA"] ,
        ["Las Vegas, NV", "Las Vegas, NV"] ,
        ["Lincoln, IL", "Lincoln, IL"] ,
        ["Los Angeles/Oxnard, CA", "Los Angeles/Oxnard, CA"] ,
        ["Louisville, KY", "Louisville, KY"] ,
        ["Lubbock, TX", "Lubbock, TX"] ,
        ["Marquette, MI", "Marquette, MI"] ,
        ["Medford, OR", "Medford, OR"] ,
        ["Melbourne, FL", "Melbourne, FL"] ,
        ["Memphis, TN", "Memphis, TN"] ,
        ["Miami, FL", "Miami, FL"] ,
        ["Midland/Odessa, TX", "Midland/Odessa, TX"] ,
        ["Milwaukee/Sullivan, WI", "Milwaukee/Sullivan, WI"] ,
        ["Minneapolis/Twin Cities, MN", "Minneapolis/Twin Cities, MN"] ,
        ["Missoula, MT", "Missoula, MT"] ,
        ["Mobile/Pensacola, AL", "Mobile/Pensacola, AL"] ,
        ["Morristown/Knoxville, TN", "Morristown/Knoxville, TN"] ,
        ["Mount Holly/Philadelphia, NJ", "Mount Holly/Philadelphia, NJ"] ,
        ["Nashville, TN", "Nashville, TN"] ,
        ["New Orleans/Baton Rouge, LA", "New Orleans/Baton Rouge, LA"] ,
        ["New York/Upton, NY", "New York/Upton, NY"] ,
        ["Newport/Morehead City, NC", "Newport/Morehead City, NC"] ,
        ["Norman/Oklahoma City, OK", "Norman/Oklahoma City, OK"] ,
        ["North Little Rock, AR", "North Little Rock, AR"] ,
        ["North Platte, NE", "North Platte, NE"] ,
        ["Northern Indiana, IN", "Northern Indiana, IN"] ,
        ["Omaha/Valley, NE", "Omaha/Valley, NE"] ,
        ["Paducah, KY", "Paducah, KY"] ,
        ["Peachtree City/Atlanta, GA", "Peachtree City/Atlanta, GA"] ,
        ["Pendleton, OR", "Pendleton, OR"] ,
        ["Phoenix, AZ", "Phoenix, AZ"] ,
        ["Pittsburgh, PA", "Pittsburgh, PA"] ,
        ["Pocatello, ID", "Pocatello, ID"] ,
        ["Portland, OR", "Portland, OR"] ,
        ["Pueblo, CO", "Pueblo, CO"] ,
        ["Raleigh, NC", "Raleigh, NC"] ,
        ["Rapid City, SD", "Rapid City, SD"] ,
        ["Reno, NV", "Reno, NV"] ,
        ["Riverton, WY", "Riverton, WY"] ,
        ["Sacramento, CA", "Sacramento, CA"] ,
        ["Salt Lake City, UT", "Salt Lake City, UT"] ,
        ["San Angelo, TX", "San Angelo, TX"] ,
        ["San Diego, CA", "San Diego, CA"] ,
        ["San Francisco Bay Area/Monterey, CA", "San Francisco Bay Area/Monterey, CA"] ,
        ["San Joaquin Valley/Hanford, CA", "San Joaquin Valley/Hanford, CA"] ,
        ["San Juan, PR", "San Juan, PR"] ,
        ["Seattle, WA", "Seattle, WA"] ,
        ["Shreveport, LA", "Shreveport, LA"] ,
        ["Sioux Falls, SD", "Sioux Falls, SD"] ,
        ["Spokane, WA", "Spokane, WA"] ,
        ["Springfield, MO", "Springfield, MO"] ,
        ["St. Louis, MO", "St. Louis, MO"] ,
        ["State College, PA", "State College, PA"] ,
        ["Tallahassee, FL", "Tallahassee, FL"] ,
        ["Tampa, FL", "Tampa, FL"] ,
        ["Topeka, KS", "Topeka, KS"] ,
        ["Tucson, AZ", "Tucson, AZ"] ,
        ["Tulsa, OK", "Tulsa, OK"] ,
        ["Wakefield, VA", "Wakefield, VA"] ,
        ["Wichita, KS", "Wichita, KS"] ,
        ["Wilmington, NC", "Wilmington, NC"] ,
        ["Wilmington, OH", "Wilmington, OH"] 
    ]
}

var weather_PROPERTIES = [
    ["Avg Temp", "Avg Temp"] ,
    ["Max Temp", "Max Temp"] ,
    ["Min Temp", "Min Temp"] ,
    ["Avg Wind", "Avg Wind"] ,
    ["High Gust", "High Gust"] ,
    ["High Wind", "High Wind"] ,
    ["Precipitation", "Precipitation"] ,
    ["Day", "Day"] ,
    ["Full", "Full"] ,
    ["Month", "Month"] ,
    ["Year", "Year"] ,
    ["City", "City"] ,
    ["Code", "Code"] ,
    ["Location", "Location"] ,
    ["State", "State"] 
]

Blockly.Blocks['weather_get'] = {
  init: function() {
    this.setColour(WEATHER_HUE);
    this.appendDummyInput('MAIN')
        .appendField("weather.get")
        .appendField(new Blockly.FieldDropdown(weather_PROPERTIES), "PROPERTY");
    this.appendDummyInput('SECOND')
        .appendField("filter")
        .appendField(new Blockly.FieldDropdown(weather_INDEXES, function(option) {
                        this.sourceBlock_.updateShape_(option);
                    }), "INDEX")
    this.updateShape_("(None)");
    this.setInputsInline(false);
    this.setOutput(true, "Array");
    this.setTooltip('Returns a list of Weather data.');
  },
  mutationToDom: function() {
    var container = document.createElement('mutation');
    container.setAttribute('index', this.getFieldValue('INDEX'));
    container.setAttribute('index_value', this.getFieldValue('INDEX_VALUE'));
    container.setAttribute('module', "weather")
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
        inputGroup.appendField(new Blockly.FieldDropdown(weather_INDEX_VALUES[index]), 'INDEX_VALUE')
        if (index_value != undefined) {
            this.setFieldValue(index_value, 'INDEX_VALUE');
        } else {
            this.setFieldValue(weather_INDEX_VALUES[index][0][0], 'INDEX_VALUE');
        }
    }    
  }
};
Blockly.Python['weather_get'] = function(block) {
    Blockly.Python.definitions_['import_weather'] = 'import weather';
    var propertyValue = block.getFieldValue('PROPERTY') || '';
    var property = Blockly.Python.quote_(propertyValue);
    var index_unquoted = block.getFieldValue('INDEX');
    var index = Blockly.Python.quote_(index_unquoted || '');
    var index_value = "''";
    if (index_unquoted != '(None)') {
        var iv = block.getFieldValue('INDEX_VALUE') || "";
        index_value = Blockly.Python.quote_(iv);
    }
    var code = 'weather.get('+property+',' +index+','+index_value+')';
    return [code, Blockly.Python.ORDER_ATOMIC];
};

PythonToBlocks.KNOWN_MODULES['weather'] = {
    "get": ["weather_get", 
            "PROPERTY", 
            {"type": "mutation", "name": "@INDEX"},
            {"type": "mutation", "name": "@INDEX_VALUE"}]
};

AbstractInterpreter.MODULES['weather'] = {
    'get': {"type": "List", "empty": false, "subtype": {"type": 'Num'}}
};

BlockPyEditor.CATEGORY_MAP['Data - Weather'] = '<category name="Data - Weather" colour="50">'+
                    '<block type="weather_get"><mutation index="(None)" index_value=""></mutation></block>'+
                '</category>';