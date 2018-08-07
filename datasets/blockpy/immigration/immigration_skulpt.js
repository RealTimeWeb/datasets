

var $builtinmodule = function(name)
{
    var mod = {};
    
    mod.get = new Sk.builtin.func(function(property, index, index_value) {
        Sk.builtin.pyCheckArgs("get", arguments, 3, 3);
        Sk.builtin.pyCheckType("property", "string", Sk.builtin.checkString(property));
        Sk.builtin.pyCheckType("index", "string", Sk.builtin.checkString(index));
        Sk.builtin.pyCheckType("index_value", "string", Sk.builtin.checkString(index_value));
        property = property.v;
        index = index.v;
        index_value = index_value.v;
        var dataset = _IMPORTED_DATASETS["immigration"];
        var data = [];
        if (index != '(None)') {
            for (var i = 0; i < dataset[property].data.length; i += 1) {
                if (dataset[index].data[i] == index_value) {
                    data.push(dataset[property].data[i]);
                }
            }
        } else {
            data = dataset[property].data;
        }
        return Sk.ffi.remapToPy(data);
    });
    
    
    mod.get_records = new Sk.builtin.func(function() {
        Sk.builtin.pyCheckArgs("get_records", arguments, 0, 0);
        if (!("immigration" in _IMPORTED_COMPLETE_DATASETS)) {
            alert("This library has not finished loading yet. Please wait about 10 seconds and try again.")
        } else {
            return _IMPORTED_COMPLETE_DATASETS["immigration"];
        }
    });
    
    
    mod._tifa_definitions = new Sk.builtin.func(function() {
        return Sk.ffi.remapToPy({"type": "ModuleType",
            "fields": {
                'get': {
                    "type": "FunctionType",
                    "name": 'get',
                    "returns": {
                        "type": "ListType", 
                        "empty": false, 
                        "subtype": {"type": "NumType"}
                    }
                },
            
                'get_records': {
                    "type": "FunctionType", 
                    "name": 'get_records',
                    "returns": 
		{"type": "ListType", "subtype": 
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Country'}, {"type": "LiteralStr", "value": 'Year'}, {"type": "LiteralStr", "value": 'Data'}], "values": [
				{"type": "StrType"}, 
				{"type": "NumType"}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Refugees'}, {"type": "LiteralStr", "value": 'Enforcement'}, {"type": "LiteralStr", "value": 'Legal permanant residences'}, {"type": "LiteralStr", "value": 'Nonimmigrant Admissions'}, {"type": "LiteralStr", "value": 'Naturalizations (Birth)'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Affirmative'}, {"type": "LiteralStr", "value": 'Arrived'}, {"type": "LiteralStr", "value": 'Defensive Asylum'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Apprehended'}, {"type": "LiteralStr", "value": 'Inadmissable'}, {"type": "LiteralStr", "value": 'Criminal'}, {"type": "LiteralStr", "value": 'Non-criminal'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Last Residence'}, {"type": "LiteralStr", "value": 'Birth'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Last Residence'}, {"type": "LiteralStr", "value": 'Birth'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "NumType"}]}]}},
                }
            
            }
        });
    });

    return mod;
}