

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
        var dataset = _IMPORTED_DATASETS["broadway"];
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
    
    
    mod.get_shows = new Sk.builtin.func(function() {
        Sk.builtin.pyCheckArgs("get_shows", arguments, 0, 0);
        if (!("broadway" in _IMPORTED_COMPLETE_DATASETS)) {
            alert("This library has not finished loading yet. Please wait about 10 seconds and try again.")
        } else {
            return _IMPORTED_COMPLETE_DATASETS["broadway"];
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
            
                'get_shows': {
                    "type": "FunctionType", 
                    "name": 'get_shows',
                    "returns": 
		{"type": "ListType", "subtype": 
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Date'}, {"type": "LiteralStr", "value": 'Show'}, {"type": "LiteralStr", "value": 'Statistics'}], "values": [
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Month'}, {"type": "LiteralStr", "value": 'Full'}, {"type": "LiteralStr", "value": 'Year'}, {"type": "LiteralStr", "value": 'Day'}], "values": [
					{"type": "NumType"}, 
					{"type": "StrType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Type'}, {"type": "LiteralStr", "value": 'Theatre'}, {"type": "LiteralStr", "value": 'Name'}], "values": [
					{"type": "StrType"}, 
					{"type": "StrType"}, 
					{"type": "StrType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Gross Potential'}, {"type": "LiteralStr", "value": 'Capacity'}, {"type": "LiteralStr", "value": 'Gross'}, {"type": "LiteralStr", "value": 'Attendance'}, {"type": "LiteralStr", "value": 'Performances'}], "values": [
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}]}]}},
                }
            
            }
        });
    });

    return mod;
}