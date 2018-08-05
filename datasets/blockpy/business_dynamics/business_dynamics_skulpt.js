

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
        var dataset = _IMPORTED_DATASETS["business_dynamics"];
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
    
    
    mod.get_businesses = new Sk.builtin.func(function() {
        Sk.builtin.pyCheckArgs("get_businesses", arguments, 0, 0);
        if (!("business_dynamics" in _IMPORTED_COMPLETE_DATASETS)) {
            alert("This library has not finished loading yet. Please wait about 10 seconds and try again.")
        } else {
            return _IMPORTED_COMPLETE_DATASETS["business_dynamics"];
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
            
                'get_businesses': {
                    "type": "FunctionType", 
                    "name": 'get_businesses',
                    "returns": 
		{"type": "ListType", "subtype": 
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Data'}, {"type": "LiteralStr", "value": 'State'}, {"type": "LiteralStr", "value": 'Year'}], "values": [
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Firm Exits'}, {"type": "LiteralStr", "value": 'Job Destruction'}, {"type": "LiteralStr", "value": 'Job Creation'}, {"type": "LiteralStr", "value": 'Calculated'}, {"type": "LiteralStr", "value": 'Establishments'}, {"type": "LiteralStr", "value": 'Number of Firms'}, {"type": "LiteralStr", "value": 'DHS Denominator'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Establishment Exit'}, {"type": "LiteralStr", "value": 'Count'}, {"type": "LiteralStr", "value": 'Job Destruction'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Continuers'}, {"type": "LiteralStr", "value": 'Rate'}, {"type": "LiteralStr", "value": 'Count'}, {"type": "LiteralStr", "value": 'Deaths'}, {"type": "LiteralStr", "value": 'Rate/Deaths'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Births'}, {"type": "LiteralStr", "value": 'Count'}, {"type": "LiteralStr", "value": 'Rate/Births'}, {"type": "LiteralStr", "value": 'Continuers'}, {"type": "LiteralStr", "value": 'Rate'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Net Job Creation Rate'}, {"type": "LiteralStr", "value": 'Reallocation Rate'}, {"type": "LiteralStr", "value": 'Net Job Creation'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Exited'}, {"type": "LiteralStr", "value": 'Physical Locations'}, {"type": "LiteralStr", "value": 'Exited Rate'}, {"type": "LiteralStr", "value": 'Entered'}, {"type": "LiteralStr", "value": 'Entered Rate'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "NumType"}, 
					{"type": "NumType"}]}, 
				{"type": "StrType"}, 
				{"type": "NumType"}]}},
                }
            
            }
        });
    });

    return mod;
}