

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
        var dataset = _IMPORTED_DATASETS["classics"];
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
        if (!("classics" in _IMPORTED_COMPLETE_DATASETS)) {
            alert("This library has not finished loading yet. Please wait about 10 seconds and try again.")
        } else {
            return _IMPORTED_COMPLETE_DATASETS["classics"];
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
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'metadata'}, {"type": "LiteralStr", "value": 'bibliography'}, {"type": "LiteralStr", "value": 'metrics'}], "values": [
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'formats'}, {"type": "LiteralStr", "value": 'id'}, {"type": "LiteralStr", "value": 'url'}, {"type": "LiteralStr", "value": 'downloads'}, {"type": "LiteralStr", "value": 'rank'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'types'}, {"type": "LiteralStr", "value": 'total'}], "values": [
						{"type": "ListType", "subtype": 
							{"type": "StrType"}}, 
						{"type": "NumType"}]}, 
					{"type": "NumType"}, 
					{"type": "StrType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'publication'}, {"type": "LiteralStr", "value": 'type'}, {"type": "LiteralStr", "value": 'author'}, {"type": "LiteralStr", "value": 'subjects'}, {"type": "LiteralStr", "value": 'congress classifications'}, {"type": "LiteralStr", "value": 'languages'}, {"type": "LiteralStr", "value": 'title'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'month'}, {"type": "LiteralStr", "value": 'year'}, {"type": "LiteralStr", "value": 'day'}, {"type": "LiteralStr", "value": 'full'}, {"type": "LiteralStr", "value": 'month name'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "StrType"}, 
						{"type": "StrType"}]}, 
					{"type": "StrType"}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'death'}, {"type": "LiteralStr", "value": 'birth'}, {"type": "LiteralStr", "value": 'name'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "StrType"}]}, 
					{"type": "ListType", "subtype": 
						{"type": "StrType"}}, 
					{"type": "ListType", "subtype": 
						{"type": "StrType"}}, 
					{"type": "ListType", "subtype": 
						{"type": "StrType"}}, 
					{"type": "StrType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'statistics'}, {"type": "LiteralStr", "value": 'difficulty'}, {"type": "LiteralStr", "value": 'sentiments'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'syllables'}, {"type": "LiteralStr", "value": 'average letter per word'}, {"type": "LiteralStr", "value": 'words'}, {"type": "LiteralStr", "value": 'average sentence per word'}, {"type": "LiteralStr", "value": 'average sentence length'}, {"type": "LiteralStr", "value": 'characters'}, {"type": "LiteralStr", "value": 'sentences'}, {"type": "LiteralStr", "value": 'polysyllables'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'gunning fog'}, {"type": "LiteralStr", "value": 'linsear write formula'}, {"type": "LiteralStr", "value": 'coleman liau index'}, {"type": "LiteralStr", "value": 'dale chall readability score'}, {"type": "LiteralStr", "value": 'difficult words'}, {"type": "LiteralStr", "value": 'automated readability index'}, {"type": "LiteralStr", "value": 'smog index'}, {"type": "LiteralStr", "value": 'flesch kincaid grade'}, {"type": "LiteralStr", "value": 'flesch reading ease'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'subjectivity'}, {"type": "LiteralStr", "value": 'polarity'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}]}]}]}},
                }
            
            }
        });
    });

    return mod;
}