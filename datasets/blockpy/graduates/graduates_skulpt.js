

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
        var dataset = _IMPORTED_DATASETS["graduates"];
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
    
    
    mod.get_majors = new Sk.builtin.func(function() {
        Sk.builtin.pyCheckArgs("get_majors", arguments, 0, 0);
        if (!("graduates" in _IMPORTED_COMPLETE_DATASETS)) {
            alert("This library has not finished loading yet. Please wait about 10 seconds and try again.")
        } else {
            return _IMPORTED_COMPLETE_DATASETS["graduates"];
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
            
                'get_majors': {
                    "type": "FunctionType", 
                    "name": 'get_majors',
                    "returns": 
		{"type": "ListType", "subtype": 
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Year'}, {"type": "LiteralStr", "value": 'Salaries'}, {"type": "LiteralStr", "value": 'Employment'}, {"type": "LiteralStr", "value": 'Demographics'}, {"type": "LiteralStr", "value": 'Education'}], "values": [
				{"type": "NumType"}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Mean'}, {"type": "LiteralStr", "value": 'Lowest'}, {"type": "LiteralStr", "value": 'Median'}, {"type": "LiteralStr", "value": 'Quantity'}, {"type": "LiteralStr", "value": 'Standard Deviation'}, {"type": "LiteralStr", "value": 'Highest'}], "values": [
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Work Activity'}, {"type": "LiteralStr", "value": 'Reason Working Outside Field'}, {"type": "LiteralStr", "value": 'Employer Type'}, {"type": "LiteralStr", "value": 'Status'}, {"type": "LiteralStr", "value": 'Reason for Not Working'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Development'}, {"type": "LiteralStr", "value": 'Applied Research'}, {"type": "LiteralStr", "value": 'Basic Research'}, {"type": "LiteralStr", "value": 'Accounting/Finance/Contracts'}, {"type": "LiteralStr", "value": 'Professional Service'}, {"type": "LiteralStr", "value": 'Qualitity/Productivity Management'}, {"type": "LiteralStr", "value": 'Managing/Supervising People/Projects'}, {"type": "LiteralStr", "value": 'Teaching'}, {"type": "LiteralStr", "value": 'Design'}, {"type": "LiteralStr", "value": 'Computer Applications'}, {"type": "LiteralStr", "value": 'Human Resources'}, {"type": "LiteralStr", "value": 'Other'}, {"type": "LiteralStr", "value": 'Productions/Operations/Maintenance'}, {"type": "LiteralStr", "value": 'Sales, Purchasing, Marketing'}], "values": [
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
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Job Location'}, {"type": "LiteralStr", "value": 'Pay/Promotion'}, {"type": "LiteralStr", "value": 'Career Change'}, {"type": "LiteralStr", "value": 'Family-related'}, {"type": "LiteralStr", "value": 'No Job Available'}, {"type": "LiteralStr", "value": 'Working Conditions'}, {"type": "LiteralStr", "value": 'Other'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Educational Institution'}, {"type": "LiteralStr", "value": 'Business/Industry'}, {"type": "LiteralStr", "value": 'Government'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Unemployed'}, {"type": "LiteralStr", "value": 'Employed'}, {"type": "LiteralStr", "value": 'Not in Labor Force'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Layoff'}, {"type": "LiteralStr", "value": 'No Job Available'}, {"type": "LiteralStr", "value": 'Student'}, {"type": "LiteralStr", "value": 'No need/want'}, {"type": "LiteralStr", "value": 'Family'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Total'}, {"type": "LiteralStr", "value": 'Gender'}, {"type": "LiteralStr", "value": 'Ethnicity'}], "values": [
					{"type": "NumType"}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Males'}, {"type": "LiteralStr", "value": 'Females'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Whites'}, {"type": "LiteralStr", "value": 'Asians'}, {"type": "LiteralStr", "value": 'Minorities'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Major'}, {"type": "LiteralStr", "value": 'Degrees'}], "values": [
					{"type": "StrType"}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Masters'}, {"type": "LiteralStr", "value": 'Professionals'}, {"type": "LiteralStr", "value": 'Doctorates'}, {"type": "LiteralStr", "value": 'Bachelors'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}]}},
                }
            
            }
        });
    });

    return mod;
}