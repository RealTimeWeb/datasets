

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
        var dataset = _IMPORTED_DATASETS["school_scores"];
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
    
    
    mod.get_all = new Sk.builtin.func(function() {
        Sk.builtin.pyCheckArgs("get_all", arguments, 0, 0);
        if (!("school_scores" in _IMPORTED_COMPLETE_DATASETS)) {
            alert("This library has not finished loading yet. Please wait about 10 seconds and try again.")
        } else {
            return _IMPORTED_COMPLETE_DATASETS["school_scores"];
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
            
                'get_all': {
                    "type": "FunctionType", 
                    "name": 'get_all',
                    "returns": 
		{"type": "ListType", "subtype": 
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Year'}, {"type": "LiteralStr", "value": 'Score Ranges'}, {"type": "LiteralStr", "value": 'Academic Subjects'}, {"type": "LiteralStr", "value": 'GPA'}, {"type": "LiteralStr", "value": 'Gender'}, {"type": "LiteralStr", "value": 'Family Income'}, {"type": "LiteralStr", "value": 'Total'}, {"type": "LiteralStr", "value": 'State'}], "values": [
				{"type": "NumType"}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Between 500 to 600'}, {"type": "LiteralStr", "value": 'Between 300 to 400'}, {"type": "LiteralStr", "value": 'Between 200 to 300'}, {"type": "LiteralStr", "value": 'Between 400 to 500'}, {"type": "LiteralStr", "value": 'Between 600 to 700'}, {"type": "LiteralStr", "value": 'Between 700 to 800'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Males'}, {"type": "LiteralStr", "value": 'Total'}, {"type": "LiteralStr", "value": 'Females'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Males'}, {"type": "LiteralStr", "value": 'Total'}, {"type": "LiteralStr", "value": 'Females'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Males'}, {"type": "LiteralStr", "value": 'Total'}, {"type": "LiteralStr", "value": 'Females'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Males'}, {"type": "LiteralStr", "value": 'Total'}, {"type": "LiteralStr", "value": 'Females'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Males'}, {"type": "LiteralStr", "value": 'Total'}, {"type": "LiteralStr", "value": 'Females'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Males'}, {"type": "LiteralStr", "value": 'Total'}, {"type": "LiteralStr", "value": 'Females'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Males'}, {"type": "LiteralStr", "value": 'Total'}, {"type": "LiteralStr", "value": 'Females'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Males'}, {"type": "LiteralStr", "value": 'Total'}, {"type": "LiteralStr", "value": 'Females'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Males'}, {"type": "LiteralStr", "value": 'Total'}, {"type": "LiteralStr", "value": 'Females'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Males'}, {"type": "LiteralStr", "value": 'Total'}, {"type": "LiteralStr", "value": 'Females'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Males'}, {"type": "LiteralStr", "value": 'Total'}, {"type": "LiteralStr", "value": 'Females'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Males'}, {"type": "LiteralStr", "value": 'Total'}, {"type": "LiteralStr", "value": 'Females'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Social Sciences/History'}, {"type": "LiteralStr", "value": 'English'}, {"type": "LiteralStr", "value": 'Mathematics'}, {"type": "LiteralStr", "value": 'Natural Sciences'}, {"type": "LiteralStr", "value": 'Foreign Languages'}, {"type": "LiteralStr", "value": 'Arts/Music'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Average GPA'}, {"type": "LiteralStr", "value": 'Average Years'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Average GPA'}, {"type": "LiteralStr", "value": 'Average Years'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Average GPA'}, {"type": "LiteralStr", "value": 'Average Years'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Average GPA'}, {"type": "LiteralStr", "value": 'Average Years'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Average GPA'}, {"type": "LiteralStr", "value": 'Average Years'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Average GPA'}, {"type": "LiteralStr", "value": 'Average Years'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'A minus'}, {"type": "LiteralStr", "value": 'A'}, {"type": "LiteralStr", "value": 'A plus'}, {"type": "LiteralStr", "value": 'B'}, {"type": "LiteralStr", "value": 'C'}, {"type": "LiteralStr", "value": 'No response'}, {"type": "LiteralStr", "value": 'D or lower'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Test-takers'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Test-takers'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Test-takers'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Test-takers'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Test-takers'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Test-takers'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Test-takers'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Male'}, {"type": "LiteralStr", "value": 'Female'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Test-takers'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Test-takers'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Between 40-60k'}, {"type": "LiteralStr", "value": 'Between 80-100k'}, {"type": "LiteralStr", "value": 'More than 100k'}, {"type": "LiteralStr", "value": 'Between 60-80k'}, {"type": "LiteralStr", "value": 'Less than 20k'}, {"type": "LiteralStr", "value": 'Between 20-40k'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Test-takers'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Test-takers'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Test-takers'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Test-takers'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Test-takers'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Test-takers'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Verbal'}, {"type": "LiteralStr", "value": 'Test-takers'}, {"type": "LiteralStr", "value": 'Math'}], "values": [
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Name'}, {"type": "LiteralStr", "value": 'Code'}], "values": [
					{"type": "StrType"}, 
					{"type": "StrType"}]}]}},
                }
            
            }
        });
    });

    return mod;
}