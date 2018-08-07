

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
        var dataset = _IMPORTED_DATASETS["construction_spending"];
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
    
    
    mod.get_spending = new Sk.builtin.func(function() {
        Sk.builtin.pyCheckArgs("get_spending", arguments, 0, 0);
        if (!("construction_spending" in _IMPORTED_COMPLETE_DATASETS)) {
            alert("This library has not finished loading yet. Please wait about 10 seconds and try again.")
        } else {
            return _IMPORTED_COMPLETE_DATASETS["construction_spending"];
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
            
                'get_spending': {
                    "type": "FunctionType", 
                    "name": 'get_spending',
                    "returns": 
		{"type": "ListType", "subtype": 
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'time'}, {"type": "LiteralStr", "value": 'annual'}, {"type": "LiteralStr", "value": 'current'}], "values": [
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'year'}, {"type": "LiteralStr", "value": 'month'}, {"type": "LiteralStr", "value": 'month name'}, {"type": "LiteralStr", "value": 'period'}, {"type": "LiteralStr", "value": 'index'}], "values": [
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "StrType"}, 
					{"type": "StrType"}, 
					{"type": "NumType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'private'}, {"type": "LiteralStr", "value": 'public'}, {"type": "LiteralStr", "value": 'combined'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'office'}, {"type": "LiteralStr", "value": 'water supply'}, {"type": "LiteralStr", "value": 'highway and street'}, {"type": "LiteralStr", "value": 'public safety'}, {"type": "LiteralStr", "value": 'commercial'}, {"type": "LiteralStr", "value": 'lodging'}, {"type": "LiteralStr", "value": 'nonresidential'}, {"type": "LiteralStr", "value": 'total construction'}, {"type": "LiteralStr", "value": 'religious'}, {"type": "LiteralStr", "value": 'educational'}, {"type": "LiteralStr", "value": 'communication'}, {"type": "LiteralStr", "value": 'transportation'}, {"type": "LiteralStr", "value": 'sewage and waste disposal'}, {"type": "LiteralStr", "value": 'health care'}, {"type": "LiteralStr", "value": 'conservation and development'}, {"type": "LiteralStr", "value": 'residential'}, {"type": "LiteralStr", "value": 'power'}, {"type": "LiteralStr", "value": 'amusement and recreation'}, {"type": "LiteralStr", "value": 'manufacturing'}], "values": [
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
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'office'}, {"type": "LiteralStr", "value": 'water supply'}, {"type": "LiteralStr", "value": 'highway and street'}, {"type": "LiteralStr", "value": 'public safety'}, {"type": "LiteralStr", "value": 'commercial'}, {"type": "LiteralStr", "value": 'lodging'}, {"type": "LiteralStr", "value": 'nonresidential'}, {"type": "LiteralStr", "value": 'total construction'}, {"type": "LiteralStr", "value": 'religious'}, {"type": "LiteralStr", "value": 'educational'}, {"type": "LiteralStr", "value": 'communication'}, {"type": "LiteralStr", "value": 'transportation'}, {"type": "LiteralStr", "value": 'sewage and waste disposal'}, {"type": "LiteralStr", "value": 'health care'}, {"type": "LiteralStr", "value": 'conservation and development'}, {"type": "LiteralStr", "value": 'residential'}, {"type": "LiteralStr", "value": 'power'}, {"type": "LiteralStr", "value": 'amusement and recreation'}, {"type": "LiteralStr", "value": 'manufacturing'}], "values": [
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
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'office'}, {"type": "LiteralStr", "value": 'water supply'}, {"type": "LiteralStr", "value": 'highway and street'}, {"type": "LiteralStr", "value": 'public safety'}, {"type": "LiteralStr", "value": 'commercial'}, {"type": "LiteralStr", "value": 'lodging'}, {"type": "LiteralStr", "value": 'nonresidential'}, {"type": "LiteralStr", "value": 'total construction'}, {"type": "LiteralStr", "value": 'religious'}, {"type": "LiteralStr", "value": 'educational'}, {"type": "LiteralStr", "value": 'communication'}, {"type": "LiteralStr", "value": 'transportation'}, {"type": "LiteralStr", "value": 'sewage and waste disposal'}, {"type": "LiteralStr", "value": 'health care'}, {"type": "LiteralStr", "value": 'conservation and development'}, {"type": "LiteralStr", "value": 'residential'}, {"type": "LiteralStr", "value": 'power'}, {"type": "LiteralStr", "value": 'amusement and recreation'}, {"type": "LiteralStr", "value": 'manufacturing'}], "values": [
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
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'private'}, {"type": "LiteralStr", "value": 'public'}, {"type": "LiteralStr", "value": 'combined'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'office'}, {"type": "LiteralStr", "value": 'water supply'}, {"type": "LiteralStr", "value": 'highway and street'}, {"type": "LiteralStr", "value": 'public safety'}, {"type": "LiteralStr", "value": 'commercial'}, {"type": "LiteralStr", "value": 'lodging'}, {"type": "LiteralStr", "value": 'nonresidential'}, {"type": "LiteralStr", "value": 'total construction'}, {"type": "LiteralStr", "value": 'religious'}, {"type": "LiteralStr", "value": 'educational'}, {"type": "LiteralStr", "value": 'communication'}, {"type": "LiteralStr", "value": 'transportation'}, {"type": "LiteralStr", "value": 'sewage and waste disposal'}, {"type": "LiteralStr", "value": 'health care'}, {"type": "LiteralStr", "value": 'conservation and development'}, {"type": "LiteralStr", "value": 'residential'}, {"type": "LiteralStr", "value": 'power'}, {"type": "LiteralStr", "value": 'amusement and recreation'}, {"type": "LiteralStr", "value": 'manufacturing'}], "values": [
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
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'office'}, {"type": "LiteralStr", "value": 'water supply'}, {"type": "LiteralStr", "value": 'highway and street'}, {"type": "LiteralStr", "value": 'public safety'}, {"type": "LiteralStr", "value": 'commercial'}, {"type": "LiteralStr", "value": 'lodging'}, {"type": "LiteralStr", "value": 'nonresidential'}, {"type": "LiteralStr", "value": 'total construction'}, {"type": "LiteralStr", "value": 'religious'}, {"type": "LiteralStr", "value": 'educational'}, {"type": "LiteralStr", "value": 'communication'}, {"type": "LiteralStr", "value": 'transportation'}, {"type": "LiteralStr", "value": 'sewage and waste disposal'}, {"type": "LiteralStr", "value": 'health care'}, {"type": "LiteralStr", "value": 'conservation and development'}, {"type": "LiteralStr", "value": 'residential'}, {"type": "LiteralStr", "value": 'power'}, {"type": "LiteralStr", "value": 'amusement and recreation'}, {"type": "LiteralStr", "value": 'manufacturing'}], "values": [
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
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'office'}, {"type": "LiteralStr", "value": 'water supply'}, {"type": "LiteralStr", "value": 'highway and street'}, {"type": "LiteralStr", "value": 'public safety'}, {"type": "LiteralStr", "value": 'commercial'}, {"type": "LiteralStr", "value": 'lodging'}, {"type": "LiteralStr", "value": 'nonresidential'}, {"type": "LiteralStr", "value": 'total construction'}, {"type": "LiteralStr", "value": 'religious'}, {"type": "LiteralStr", "value": 'educational'}, {"type": "LiteralStr", "value": 'communication'}, {"type": "LiteralStr", "value": 'transportation'}, {"type": "LiteralStr", "value": 'sewage and waste disposal'}, {"type": "LiteralStr", "value": 'health care'}, {"type": "LiteralStr", "value": 'conservation and development'}, {"type": "LiteralStr", "value": 'residential'}, {"type": "LiteralStr", "value": 'power'}, {"type": "LiteralStr", "value": 'amusement and recreation'}, {"type": "LiteralStr", "value": 'manufacturing'}], "values": [
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
						{"type": "NumType"}, 
						{"type": "NumType"}, 
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