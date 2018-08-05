

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
        var dataset = _IMPORTED_DATASETS["airlines"];
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
    
    
    mod.get_reports = new Sk.builtin.func(function() {
        Sk.builtin.pyCheckArgs("get_reports", arguments, 0, 0);
        if (!("airlines" in _IMPORTED_COMPLETE_DATASETS)) {
            alert("This library has not finished loading yet. Please wait about 10 seconds and try again.")
        } else {
            return _IMPORTED_COMPLETE_DATASETS["airlines"];
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
            
                'get_reports': {
                    "type": "FunctionType", 
                    "name": 'get_reports',
                    "returns": 
		{"type": "ListType", "subtype": 
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Statistics'}, {"type": "LiteralStr", "value": 'Time'}, {"type": "LiteralStr", "value": 'Airport'}], "values": [
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Flights'}, {"type": "LiteralStr", "value": '# of Delays'}, {"type": "LiteralStr", "value": 'Carriers'}, {"type": "LiteralStr", "value": 'Minutes Delayed'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Total'}, {"type": "LiteralStr", "value": 'On Time'}, {"type": "LiteralStr", "value": 'Diverted'}, {"type": "LiteralStr", "value": 'Cancelled'}, {"type": "LiteralStr", "value": 'Delayed'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Security'}, {"type": "LiteralStr", "value": 'National Aviation System'}, {"type": "LiteralStr", "value": 'Carrier'}, {"type": "LiteralStr", "value": 'Weather'}, {"type": "LiteralStr", "value": 'Late Aircraft'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Total'}, {"type": "LiteralStr", "value": 'Names'}], "values": [
						{"type": "NumType"}, 
						{"type": "ListType", "subtype": 
							{"type": "StrType"}}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Weather'}, {"type": "LiteralStr", "value": 'Security'}, {"type": "LiteralStr", "value": 'National Aviation System'}, {"type": "LiteralStr", "value": 'Carrier'}, {"type": "LiteralStr", "value": 'Late Aircraft'}, {"type": "LiteralStr", "value": 'Total'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Month'}, {"type": "LiteralStr", "value": 'Month Name'}, {"type": "LiteralStr", "value": 'Year'}, {"type": "LiteralStr", "value": 'Label'}], "values": [
					{"type": "NumType"}, 
					{"type": "StrType"}, 
					{"type": "NumType"}, 
					{"type": "StrType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Code'}, {"type": "LiteralStr", "value": 'Name'}], "values": [
					{"type": "StrType"}, 
					{"type": "StrType"}]}]}},
                }
            
            }
        });
    });

    return mod;
}