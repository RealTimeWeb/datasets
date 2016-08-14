{% set library_name = metadata.name | snake_case %}

var INDEXES = [
    ["(None)", "(None)"],
    {% for index in indexes.keys() %}
    [{{ index | tojson }}, {{ index | tojson }}] {{ ',' if not loop.last -}}
    {% endfor %}
];

var INDEX_VALUES = {
    "(None)": [],
    {% for index, values in indexes.items() %}
    {{ index | tojson }}: [
        {% for value in values['data']|unique|sort %}
        [{{ value | tojson }}, {{ value | tojson }}] {{ ',' if not loop.last -}}
        {% endfor %}
    ]{{ ',' if not loop.last -}}
    {% endfor %}
}

var PROPERTIES = [
{%- for key_name in key_names %}
    [{{ key_name | tojson }}, {{ key_name | tojson }}] {{ ',' if not loop.last -}}
{% endfor %}
]

Blockly.Blocks['{{ library_name }}_get'] = {
  init: function() {
    this.setColour(WEATHER_HUE);
    this.appendDummyInput('MAIN')
        .appendField("{{ library_name }}.get")
        .appendField(new Blockly.FieldDropdown(PROPERTIES), "PROPERTY")
        .appendField("filter")
        .appendField(new Blockly.FieldDropdown(INDEXES, function(option) {
                        this.sourceBlock_.updateShape_(option);
                    }), "INDEX")
    this.updateShape_();
    this.setInputsInline(false);
    this.setOutput(true, "Array");
    this.setTooltip('Returns a list of {{ metadata.name }} data.');
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
        inputGroup.appendField(new Blockly.FieldDropdown(INDEX_VALUES[index]), 'INDEX_VALUE')
        if (index_value != undefined) {
            this.setFieldValue(index_value, 'INDEX_VALUE');
        } else {
            console.log(INDEX_VALUES[index])
            this.setFieldValue(INDEX_VALUES[index][0][0], 'INDEX_VALUE');
        }
    }    
  }
};
Blockly.Python['{{ library_name }}_get'] = function(block) {
    Blockly.Python.definitions_['import_{{ library_name }}'] = 'import {{ library_name }}';
    var property = Blockly.Python.quote_(block.getFieldValue('PROPERTY'));
    var index_unquoted = block.getFieldValue('INDEX');
    var index = Blockly.Python.quote_(index_unquoted);
    var index_value = "''";
    if (index_unquoted != '(None)') {
        var iv = block.getFieldValue('INDEX_VALUE') || "";
        index_value = Blockly.Python.quote_(iv);
    }
    var code = '{{ library_name }}.get('+property+',' +index+','+index_value+')';
    return [code, Blockly.Python.ORDER_ATOMIC];
};

PythonToBlocks.KNOWN_MODULES['{{ library_name }}'] = {
    "get": ["{{ library_name }}_get", 
            "PROPERTY", 
            {"type": "mutation", "name": "@INDEX"},
            {"type": "mutation", "name": "@INDEX_VALUE"}]
};

AbstractInterpreter.MODULES['{{ library_name }}'] = {
    'get': {"type": "List", "empty": false, "component": {"type": 'Num'}}
};

BlockPyEditor.CATEGORY_MAP['Data - {{ metadata.name }}'] = '<category name="Data - {{ metadata.name }}" colour="50">'+
                    '<block type="{{ library_name }}_get"><mutation index="(None)" index_value=""></mutation></block>'+
                '</category>';