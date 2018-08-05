

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
        var dataset = _IMPORTED_DATASETS["billionaires"];
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
    
    
    mod.get_billionaires = new Sk.builtin.func(function() {
        Sk.builtin.pyCheckArgs("get_billionaires", arguments, 0, 0);
        if (!("billionaires" in _IMPORTED_COMPLETE_DATASETS)) {
            alert("This library has not finished loading yet. Please wait about 10 seconds and try again.")
        } else {
            return _IMPORTED_COMPLETE_DATASETS["billionaires"];
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
            
                'get_billionaires': {
                    "type": "FunctionType", 
                    "name": 'get_billionaires',
                    "returns": 
		{"type": "ListType", "subtype": 
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'demographics'}, {"type": "LiteralStr", "value": 'name'}, {"type": "LiteralStr", "value": 'location'}, {"type": "LiteralStr", "value": 'rank'}, {"type": "LiteralStr", "value": 'wealth'}, {"type": "LiteralStr", "value": 'company'}, {"type": "LiteralStr", "value": 'year'}], "values": [
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'age'}, {"type": "LiteralStr", "value": 'gender'}], "values": [
					{"type": "NumType"}, 
					{"type": "StrType"}]}, 
				{"type": "StrType"}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'gdp'}, {"type": "LiteralStr", "value": 'citizenship'}, {"type": "LiteralStr", "value": 'country code'}, {"type": "LiteralStr", "value": 'region'}], "values": [
					{"type": "NumType"}, 
					{"type": "StrType"}, 
					{"type": "StrType"}, 
					{"type": "StrType"}]}, 
				{"type": "NumType"}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'worth in billions'}, {"type": "LiteralStr", "value": 'type'}, {"type": "LiteralStr", "value": 'how'}], "values": [
					{"type": "NumType"}, 
					{"type": "StrType"}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'was political'}, {"type": "LiteralStr", "value": 'from emerging'}, {"type": "LiteralStr", "value": 'category'}, {"type": "LiteralStr", "value": 'inherited'}, {"type": "LiteralStr", "value": 'was founder'}, {"type": "LiteralStr", "value": 'industry'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "StrType"}, 
						{"type": "StrType"}, 
						{"type": "NumType"}, 
						{"type": "StrType"}]}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'founded'}, {"type": "LiteralStr", "value": 'sector'}, {"type": "LiteralStr", "value": 'relationship'}, {"type": "LiteralStr", "value": 'type'}, {"type": "LiteralStr", "value": 'name'}], "values": [
					{"type": "NumType"}, 
					{"type": "StrType"}, 
					{"type": "StrType"}, 
					{"type": "StrType"}, 
					{"type": "StrType"}]}, 
				{"type": "NumType"}]}},
                }
            
            }
        });
    });

    return mod;
}