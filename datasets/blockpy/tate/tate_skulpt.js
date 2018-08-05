

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
        var dataset = _IMPORTED_DATASETS["tate"];
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
    
    
    mod.get_artwork = new Sk.builtin.func(function() {
        Sk.builtin.pyCheckArgs("get_artwork", arguments, 0, 0);
        if (!("tate" in _IMPORTED_COMPLETE_DATASETS)) {
            alert("This library has not finished loading yet. Please wait about 10 seconds and try again.")
        } else {
            return _IMPORTED_COMPLETE_DATASETS["tate"];
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
            
                'get_artwork': {
                    "type": "FunctionType", 
                    "name": 'get_artwork',
                    "returns": 
		{"type": "ListType", "subtype": 
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'data'}, {"type": "LiteralStr", "value": 'artist'}, {"type": "LiteralStr", "value": 'dimensions'}, {"type": "LiteralStr", "value": 'metadata'}], "values": [
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'medium'}, {"type": "LiteralStr", "value": 'title'}, {"type": "LiteralStr", "value": 'url'}, {"type": "LiteralStr", "value": 'thumbnail'}], "values": [
					{"type": "StrType"}, 
					{"type": "StrType"}, 
					{"type": "StrType"}, 
					{"type": "StrType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'birth'}, {"type": "LiteralStr", "value": 'name'}, {"type": "LiteralStr", "value": 'gender'}, {"type": "LiteralStr", "value": 'death'}, {"type": "LiteralStr", "value": 'role'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'location'}, {"type": "LiteralStr", "value": 'year'}], "values": [
						{"type": "StrType"}, 
						{"type": "NumType"}]}, 
					{"type": "StrType"}, 
					{"type": "StrType"}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'location'}, {"type": "LiteralStr", "value": 'year'}], "values": [
						{"type": "StrType"}, 
						{"type": "NumType"}]}, 
					{"type": "StrType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'height'}, {"type": "LiteralStr", "value": 'depth'}, {"type": "LiteralStr", "value": 'width'}], "values": [
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'creation decade'}, {"type": "LiteralStr", "value": 'acquisition date'}, {"type": "LiteralStr", "value": 'creation year'}, {"type": "LiteralStr", "value": 'credit'}], "values": [
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "StrType"}]}]}},
                }
            
            }
        });
    });

    return mod;
}