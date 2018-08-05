

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
        var dataset = _IMPORTED_DATASETS["energy"];
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
        if (!("energy" in _IMPORTED_COMPLETE_DATASETS)) {
            alert("This library has not finished loading yet. Please wait about 10 seconds and try again.")
        } else {
            return _IMPORTED_COMPLETE_DATASETS["energy"];
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
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'State'}, {"type": "LiteralStr", "value": 'Consumption'}, {"type": "LiteralStr", "value": 'Production'}, {"type": "LiteralStr", "value": 'Expenditure'}, {"type": "LiteralStr", "value": 'Price'}, {"type": "LiteralStr", "value": 'Year'}], "values": [
				{"type": "StrType"}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Refinery'}, {"type": "LiteralStr", "value": 'Commercial'}, {"type": "LiteralStr", "value": 'Transportation'}, {"type": "LiteralStr", "value": 'Industrial'}, {"type": "LiteralStr", "value": 'Residential'}, {"type": "LiteralStr", "value": 'Electric Power'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Coal'}, {"type": "LiteralStr", "value": 'Liquefied Petroleum Gases'}, {"type": "LiteralStr", "value": 'Natural Gas'}, {"type": "LiteralStr", "value": 'Distillate Fuel Oil'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Geothermal'}, {"type": "LiteralStr", "value": 'Wind'}, {"type": "LiteralStr", "value": 'Coal'}, {"type": "LiteralStr", "value": 'Distillate Fuel Oil'}, {"type": "LiteralStr", "value": 'Natural Gas'}, {"type": "LiteralStr", "value": 'Hydropower'}, {"type": "LiteralStr", "value": 'Solar'}, {"type": "LiteralStr", "value": 'Wood'}, {"type": "LiteralStr", "value": 'Kerosene'}, {"type": "LiteralStr", "value": 'Liquefied Petroleum Gases'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Coal'}, {"type": "LiteralStr", "value": 'Liquefied Petroleum Gases'}, {"type": "LiteralStr", "value": 'Natural Gas'}, {"type": "LiteralStr", "value": 'Distillate Fuel Oil'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Geothermal'}, {"type": "LiteralStr", "value": 'Wind'}, {"type": "LiteralStr", "value": 'Coal'}, {"type": "LiteralStr", "value": 'Distillate Fuel Oil'}, {"type": "LiteralStr", "value": 'Natural Gas'}, {"type": "LiteralStr", "value": 'Hydropower'}, {"type": "LiteralStr", "value": 'Solar'}, {"type": "LiteralStr", "value": 'Other Petroleum Products'}, {"type": "LiteralStr", "value": 'Wood'}, {"type": "LiteralStr", "value": 'Kerosene'}, {"type": "LiteralStr", "value": 'Liquefied Petroleum Gases'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Geothermal'}, {"type": "LiteralStr", "value": 'Coal'}, {"type": "LiteralStr", "value": 'Distillate Fuel Oil'}, {"type": "LiteralStr", "value": 'Natural Gas'}, {"type": "LiteralStr", "value": 'Liquefied Petroleum Gases'}, {"type": "LiteralStr", "value": 'Kerosene'}, {"type": "LiteralStr", "value": 'Wood'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Coal'}, {"type": "LiteralStr", "value": 'Natural Gas'}, {"type": "LiteralStr", "value": 'Distillate Fuel Oil'}, {"type": "LiteralStr", "value": 'Wood'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Coal'}], "values": [
					{"type": "NumType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Residential'}, {"type": "LiteralStr", "value": 'Commercial'}, {"type": "LiteralStr", "value": 'Transportation'}, {"type": "LiteralStr", "value": 'Electric Power'}, {"type": "LiteralStr", "value": 'Industrial'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Coal'}, {"type": "LiteralStr", "value": 'Distillate Fuel Oil'}, {"type": "LiteralStr", "value": 'Natural Gas'}, {"type": "LiteralStr", "value": 'Liquefied Petroleum Gases'}, {"type": "LiteralStr", "value": 'Kerosene'}, {"type": "LiteralStr", "value": 'Wood'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Natural Gas'}, {"type": "LiteralStr", "value": 'Coal'}, {"type": "LiteralStr", "value": 'Liquefied Petroleum Gases'}, {"type": "LiteralStr", "value": 'Kerosene'}, {"type": "LiteralStr", "value": 'Distillate Fuel Oil'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Coal'}, {"type": "LiteralStr", "value": 'Liquefied Petroleum Gases'}, {"type": "LiteralStr", "value": 'Natural Gas'}, {"type": "LiteralStr", "value": 'Distillate Fuel Oil'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Coal'}, {"type": "LiteralStr", "value": 'Natural Gas'}, {"type": "LiteralStr", "value": 'Distillate Fuel Oil'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Coal'}, {"type": "LiteralStr", "value": 'Distillate Fuel Oil'}, {"type": "LiteralStr", "value": 'Natural Gas'}, {"type": "LiteralStr", "value": 'Other Petroleum Products'}, {"type": "LiteralStr", "value": 'Kerosene'}, {"type": "LiteralStr", "value": 'Liquefied Petroleum Gases'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Commercial'}, {"type": "LiteralStr", "value": 'Transportation'}, {"type": "LiteralStr", "value": 'Electric Power'}, {"type": "LiteralStr", "value": 'Industrial'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Natural Gas'}, {"type": "LiteralStr", "value": 'Coal'}, {"type": "LiteralStr", "value": 'Liquefied Petroleum Gases'}, {"type": "LiteralStr", "value": 'Kerosene'}, {"type": "LiteralStr", "value": 'Distillate Fuel Oil'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Coal'}, {"type": "LiteralStr", "value": 'Liquefied Petroleum Gases'}, {"type": "LiteralStr", "value": 'Natural Gas'}, {"type": "LiteralStr", "value": 'Distillate Fuel Oil'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Coal'}, {"type": "LiteralStr", "value": 'Natural Gas'}, {"type": "LiteralStr", "value": 'Distillate Fuel Oil'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Coal'}, {"type": "LiteralStr", "value": 'Distillate Fuel Oil'}, {"type": "LiteralStr", "value": 'Natural Gas'}, {"type": "LiteralStr", "value": 'Other Petroleum Products'}, {"type": "LiteralStr", "value": 'Kerosene'}, {"type": "LiteralStr", "value": 'Liquefied Petroleum Gases'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}, 
				{"type": "NumType"}]}},
                }
            
            }
        });
    });

    return mod;
}