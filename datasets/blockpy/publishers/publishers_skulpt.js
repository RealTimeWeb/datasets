

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
        var dataset = _IMPORTED_DATASETS["publishers"];
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
    
    
    mod.get_books = new Sk.builtin.func(function() {
        Sk.builtin.pyCheckArgs("get_books", arguments, 0, 0);
        if (!("publishers" in _IMPORTED_COMPLETE_DATASETS)) {
            alert("This library has not finished loading yet. Please wait about 10 seconds and try again.")
        } else {
            return _IMPORTED_COMPLETE_DATASETS["publishers"];
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
            
                'get_books': {
                    "type": "FunctionType", 
                    "name": 'get_books',
                    "returns": 
		{"type": "ListType", "subtype": 
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'sold by'}, {"type": "LiteralStr", "value": 'statistics'}, {"type": "LiteralStr", "value": 'genre'}, {"type": "LiteralStr", "value": 'publisher'}, {"type": "LiteralStr", "value": 'daily average'}], "values": [
				{"type": "StrType"}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'sales rank'}, {"type": "LiteralStr", "value": 'average rating'}, {"type": "LiteralStr", "value": 'sale price'}, {"type": "LiteralStr", "value": 'total reviews'}], "values": [
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}]}, 
				{"type": "StrType"}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'type'}, {"type": "LiteralStr", "value": 'name'}], "values": [
					{"type": "StrType"}, 
					{"type": "StrType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'author revenue'}, {"type": "LiteralStr", "value": 'units sold'}, {"type": "LiteralStr", "value": 'gross sales'}, {"type": "LiteralStr", "value": 'publisher revenue'}, {"type": "LiteralStr", "value": 'amazon revenue'}], "values": [
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