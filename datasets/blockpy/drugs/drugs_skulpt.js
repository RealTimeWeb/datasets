

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
        var dataset = _IMPORTED_DATASETS["drugs"];
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
        if (!("drugs" in _IMPORTED_COMPLETE_DATASETS)) {
            alert("This library has not finished loading yet. Please wait about 10 seconds and try again.")
        } else {
            return _IMPORTED_COMPLETE_DATASETS["drugs"];
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
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Year'}, {"type": "LiteralStr", "value": 'Totals'}, {"type": "LiteralStr", "value": 'Population'}, {"type": "LiteralStr", "value": 'State'}, {"type": "LiteralStr", "value": 'Rates'}], "values": [
				{"type": "NumType"}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Illicit Drugs'}, {"type": "LiteralStr", "value": 'Alcohol'}, {"type": "LiteralStr", "value": 'Marijuana'}, {"type": "LiteralStr", "value": 'Tobacco'}, {"type": "LiteralStr", "value": 'Pain Relievers Abuse Past Year'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Used Past Month'}, {"type": "LiteralStr", "value": 'Abuse Past Year'}, {"type": "LiteralStr", "value": 'All Except Marijuana Used Past Month'}, {"type": "LiteralStr", "value": 'Dependence Past Year'}, {"type": "LiteralStr", "value": 'Cocaine Used Past Year'}, {"type": "LiteralStr", "value": 'Need Treatment Past Year'}], "values": [
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Binge Past Month'}, {"type": "LiteralStr", "value": 'Use Past Month'}, {"type": "LiteralStr", "value": 'Abuse Past Year'}, {"type": "LiteralStr", "value": 'Dependence Past Year'}, {"type": "LiteralStr", "value": 'Perceptions of Risk'}, {"type": "LiteralStr", "value": 'In Minors'}, {"type": "LiteralStr", "value": 'Need Treatment Past Year'}], "values": [
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Abuse'}, {"type": "LiteralStr", "value": 'Use'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Perceptions of Risk'}, {"type": "LiteralStr", "value": 'Used Past Year'}, {"type": "LiteralStr", "value": 'Used Past Month'}, {"type": "LiteralStr", "value": 'New Users'}], "values": [
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Use Past Month'}, {"type": "LiteralStr", "value": 'Perceptions of Risk'}, {"type": "LiteralStr", "value": 'Cigarette Past Month'}], "values": [
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '18-25'}, {"type": "LiteralStr", "value": '12-17'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-20'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}]}, 
				{"type": "StrType"}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Illicit Drugs'}, {"type": "LiteralStr", "value": 'Alcohol'}, {"type": "LiteralStr", "value": 'Marijuana'}, {"type": "LiteralStr", "value": 'Tobacco'}, {"type": "LiteralStr", "value": 'Pain Relievers Abuse Past Year'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Used Past Month'}, {"type": "LiteralStr", "value": 'Abuse Past Year'}, {"type": "LiteralStr", "value": 'All Except Marijuana Used Past Month'}, {"type": "LiteralStr", "value": 'Dependence Past Year'}, {"type": "LiteralStr", "value": 'Cocaine Used Past Year'}, {"type": "LiteralStr", "value": 'Need Treatment Past Year'}], "values": [
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Binge Past Month'}, {"type": "LiteralStr", "value": 'Use Past Month'}, {"type": "LiteralStr", "value": 'Abuse Past Year'}, {"type": "LiteralStr", "value": 'Dependence Past Year'}, {"type": "LiteralStr", "value": 'Perceptions of Risk'}, {"type": "LiteralStr", "value": 'In Minors'}, {"type": "LiteralStr", "value": 'Need Treatment Past Year'}], "values": [
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Abuse'}, {"type": "LiteralStr", "value": 'Use'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Used Past Year'}, {"type": "LiteralStr", "value": 'Used Past Month'}, {"type": "LiteralStr", "value": 'New Users'}, {"type": "LiteralStr", "value": 'Perceptions of Risk'}], "values": [
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Use Past Month'}, {"type": "LiteralStr", "value": 'Perceptions of Risk'}, {"type": "LiteralStr", "value": 'Cigarette Past Month'}], "values": [
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": '26+'}, {"type": "LiteralStr", "value": '12-17'}, {"type": "LiteralStr", "value": '18-25'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}]}},
                }
            
            }
        });
    });

    return mod;
}