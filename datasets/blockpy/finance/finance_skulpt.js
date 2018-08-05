

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
        var dataset = _IMPORTED_DATASETS["finance"];
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
    
    
    mod.get_finances = new Sk.builtin.func(function() {
        Sk.builtin.pyCheckArgs("get_finances", arguments, 0, 0);
        if (!("finance" in _IMPORTED_COMPLETE_DATASETS)) {
            alert("This library has not finished loading yet. Please wait about 10 seconds and try again.")
        } else {
            return _IMPORTED_COMPLETE_DATASETS["finance"];
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
            
                'get_finances': {
                    "type": "FunctionType", 
                    "name": 'get_finances',
                    "returns": 
		{"type": "ListType", "subtype": 
			{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'State'}, {"type": "LiteralStr", "value": 'Totals'}, {"type": "LiteralStr", "value": 'Details'}, {"type": "LiteralStr", "value": 'Year'}], "values": [
				{"type": "StrType"}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Expenditure'}, {"type": "LiteralStr", "value": 'Equipment and land'}, {"type": "LiteralStr", "value": 'General expenditure'}, {"type": "LiteralStr", "value": 'Revenue'}, {"type": "LiteralStr", "value": 'Tax'}, {"type": "LiteralStr", "value": 'Local intergovernmental'}, {"type": "LiteralStr", "value": 'Miscellaneous'}, {"type": "LiteralStr", "value": 'Selective sales tax'}, {"type": "LiteralStr", "value": 'Construction'}, {"type": "LiteralStr", "value": 'Federal intergovernmental'}, {"type": "LiteralStr", "value": 'Charges'}, {"type": "LiteralStr", "value": 'Intergovernmental'}, {"type": "LiteralStr", "value": 'Employee retirement revenue'}, {"type": "LiteralStr", "value": 'Insurance trust  revenue'}, {"type": "LiteralStr", "value": 'Utility revenue'}, {"type": "LiteralStr", "value": 'Miscellaneous commercial activity'}, {"type": "LiteralStr", "value": 'License tax'}, {"type": "LiteralStr", "value": 'Sales tax'}, {"type": "LiteralStr", "value": 'Capital outlay'}, {"type": "LiteralStr", "value": 'Unemployment comp revenue'}, {"type": "LiteralStr", "value": 'General revenue'}, {"type": "LiteralStr", "value": "Worker's comp revenue"}, {"type": "LiteralStr", "value": 'State intergovernmental'}, {"type": "LiteralStr", "value": 'Other insurance trust revenue'}], "values": [
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
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}, 
					{"type": "NumType"}]}, 
				{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Financial Aid'}, {"type": "LiteralStr", "value": 'Transportation'}, {"type": "LiteralStr", "value": 'Education'}, {"type": "LiteralStr", "value": 'Natural Resources'}, {"type": "LiteralStr", "value": 'Health'}, {"type": "LiteralStr", "value": 'Utilities'}, {"type": "LiteralStr", "value": 'Employment'}, {"type": "LiteralStr", "value": 'Welfare'}, {"type": "LiteralStr", "value": 'Correction'}, {"type": "LiteralStr", "value": 'Waste'}, {"type": "LiteralStr", "value": 'Intergovernmental'}, {"type": "LiteralStr", "value": 'Insurance Trust'}, {"type": "LiteralStr", "value": 'Public Welfare'}], "values": [
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Federal Agency Securities Total'}, {"type": "LiteralStr", "value": 'Categorical Assistance Intergovernmental'}, {"type": "LiteralStr", "value": 'Assistance and Subsidies'}, {"type": "LiteralStr", "value": 'Cash Assistance Total Expenditure'}, {"type": "LiteralStr", "value": 'Cash Assistance Intergovernmental'}, {"type": "LiteralStr", "value": 'Borrowing Total'}, {"type": "LiteralStr", "value": 'Bond Fund Total'}, {"type": "LiteralStr", "value": 'Beginning Long Term Debt Total Outstanding'}, {"type": "LiteralStr", "value": 'Categorical Assistance Total Expenditure'}, {"type": "LiteralStr", "value": 'Cash and Securities Total'}, {"type": "LiteralStr", "value": 'Securities Total'}, {"type": "LiteralStr", "value": 'Cash and Deposits Total'}, {"type": "LiteralStr", "value": 'Sinking Fund Total'}], "values": [
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
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Water Transport'}, {"type": "LiteralStr", "value": 'Transit Subsidy Intergovernmental'}, {"type": "LiteralStr", "value": 'Highways'}, {"type": "LiteralStr", "value": 'Airports'}, {"type": "LiteralStr", "value": 'Transit Subsidy Total Expenditure'}, {"type": "LiteralStr", "value": 'Parking'}], "values": [
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Water Transport Total Expenditure'}, {"type": "LiteralStr", "value": 'Water Transport Intergovernmental'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "NumType"}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Highways Intergovernmental'}, {"type": "LiteralStr", "value": 'Highways Land and Equipment'}, {"type": "LiteralStr", "value": 'Regular Highways Total Expenditure'}, {"type": "LiteralStr", "value": 'Highways Total Expenditure'}, {"type": "LiteralStr", "value": 'Highways Direct'}, {"type": "LiteralStr", "value": 'Regular Highways Intergovernmental'}, {"type": "LiteralStr", "value": 'Highways Construction Total'}, {"type": "LiteralStr", "value": 'Toll Highways Total Expenditure'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Airports Total Expenditure'}, {"type": "LiteralStr", "value": 'Airports Intergovernmental'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "NumType"}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Parking Total'}, {"type": "LiteralStr", "value": 'Parking Intergovernmental'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Higher Education-NEC Total Expenditure'}, {"type": "LiteralStr", "value": 'Education Total'}, {"type": "LiteralStr", "value": 'Education-NEC Expenditure Total'}, {"type": "LiteralStr", "value": 'Higher Education-Auxilliary Total Expenditure'}, {"type": "LiteralStr", "value": 'Education-NEC Intergovernmental'}, {"type": "LiteralStr", "value": 'Education Equipment and Land'}, {"type": "LiteralStr", "value": 'Education Construction'}, {"type": "LiteralStr", "value": 'Education Other Current Operation'}, {"type": "LiteralStr", "value": 'Education Intergovernmental'}, {"type": "LiteralStr", "value": 'Edcation Assistance and Subsidies'}, {"type": "LiteralStr", "value": 'Elementary Secondary Intergovernmental'}, {"type": "LiteralStr", "value": 'Elementary Secondary Total Expenditure'}, {"type": "LiteralStr", "value": 'Education Equipment'}, {"type": "LiteralStr", "value": 'Higher Education-NEC Intergovernmental'}], "values": [
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
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Natural Resources Equipment and Land'}, {"type": "LiteralStr", "value": 'Fish and Game'}, {"type": "LiteralStr", "value": 'Forestry'}, {"type": "LiteralStr", "value": 'Parks'}, {"type": "LiteralStr", "value": 'Natural Resources Intergovernmental'}, {"type": "LiteralStr", "value": 'Natural Resources NEC Total Expenditure'}, {"type": "LiteralStr", "value": 'Natural Resources Construction'}, {"type": "LiteralStr", "value": 'Natural Resources Total'}, {"type": "LiteralStr", "value": 'Natural Resources Direct'}, {"type": "LiteralStr", "value": 'Agriculture'}], "values": [
						{"type": "NumType"}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Fish and Game Intergovernmental'}, {"type": "LiteralStr", "value": 'Fish and Game Total Expenditure'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Forestry Intergovernmental'}, {"type": "LiteralStr", "value": 'Forestry Total Expenditure'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Parks Total Expenditure'}, {"type": "LiteralStr", "value": 'Parks Intergovernmental'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}]}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Federal Farm Credit Intergovernmental'}, {"type": "LiteralStr", "value": 'Agriculture Total Expenditure'}, {"type": "LiteralStr", "value": 'Federal Agriculture Farm Income Total'}, {"type": "LiteralStr", "value": 'Federal Agriculture Farm Income Intergovernmental'}, {"type": "LiteralStr", "value": 'Federal Farm Credit Total'}, {"type": "LiteralStr", "value": 'Agriculture Intergovernmental'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Health Intergovernmental'}, {"type": "LiteralStr", "value": 'Health Total Expenditure'}, {"type": "LiteralStr", "value": 'Hospitals'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Hospitals Total Current'}, {"type": "LiteralStr", "value": 'Hospitals Total Intergovernmental'}, {"type": "LiteralStr", "value": 'Hospital-Other Intergovernmental'}, {"type": "LiteralStr", "value": 'Hospital-Other Total Expenditure'}, {"type": "LiteralStr", "value": 'Hospitals Total Equipment and land'}, {"type": "LiteralStr", "value": 'Hospitals Total Expenditure'}, {"type": "LiteralStr", "value": 'Own Hospitals Total Expenditure'}, {"type": "LiteralStr", "value": 'Hospitals Total Construction'}], "values": [
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}, 
							{"type": "NumType"}]}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Utilities Interest Total'}, {"type": "LiteralStr", "value": 'Gas Utility Total Expenditure'}, {"type": "LiteralStr", "value": 'Transit Utility Total Expenditure'}, {"type": "LiteralStr", "value": 'Utilities Total Expenditure'}, {"type": "LiteralStr", "value": 'Utilities Construction'}, {"type": "LiteralStr", "value": 'Utilities Equipment and Land'}, {"type": "LiteralStr", "value": 'Utilities Current Operation'}, {"type": "LiteralStr", "value": 'Electric Utility Total Expenditure'}, {"type": "LiteralStr", "value": 'Water Utility Total Expenditure'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Unemployment Comp Total Cash and Securities'}, {"type": "LiteralStr", "value": 'Employment Security Administration Intergovernmental'}, {"type": "LiteralStr", "value": 'Employment Security Administration Expenditure Total'}, {"type": "LiteralStr", "value": 'Employee Retirement Total Cash and Securities'}, {"type": "LiteralStr", "value": 'Unemployment Comp Total Expenditure'}, {"type": "LiteralStr", "value": 'Employee Retirement Total Expenditure'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Welfare Vendor Payments Total'}, {"type": "LiteralStr", "value": 'Welfare Institution Total Expenditure'}, {"type": "LiteralStr", "value": 'Welfare NEC Intergovernmental'}, {"type": "LiteralStr", "value": 'Welfare NEC Total Expenditure'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Correction Institutions Total'}, {"type": "LiteralStr", "value": 'Correction Intergovernmental'}, {"type": "LiteralStr", "value": 'Correction NEC Total'}, {"type": "LiteralStr", "value": 'Correction Total'}, {"type": "LiteralStr", "value": 'Correction NEC Intergovernmental'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Sewerage Intergovernmental'}, {"type": "LiteralStr", "value": 'Solid Waste Management Total Expenditure'}, {"type": "LiteralStr", "value": 'Solid Waste Management Intergovernmental'}, {"type": "LiteralStr", "value": 'Sewerage Total Expenditure'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Intergovernmental to Townships'}, {"type": "LiteralStr", "value": 'Intergovernmental to State'}, {"type": "LiteralStr", "value": 'Intergovernmental to Local'}, {"type": "LiteralStr", "value": 'Intergovernmental to Federal'}, {"type": "LiteralStr", "value": 'Intergovernmental to School Districts'}, {"type": "LiteralStr", "value": 'Intergovernmental to Special Districts'}, {"type": "LiteralStr", "value": 'Intergovernmental to Combined and Unallocable'}, {"type": "LiteralStr", "value": 'Intergovernmental Expenditure'}, {"type": "LiteralStr", "value": 'Intergovernmental to Municipalities'}, {"type": "LiteralStr", "value": 'Intergovernmental to Counties'}], "values": [
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
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Insurance Trust Total Expenditure'}, {"type": "LiteralStr", "value": 'Insurance Trust Other Securities'}, {"type": "LiteralStr", "value": 'Insurance Trust Federal Agency Securities'}, {"type": "LiteralStr", "value": 'Insurance Trust Cash and Securities'}, {"type": "LiteralStr", "value": 'Insurance Trust State and Local Securities Total'}, {"type": "LiteralStr", "value": 'Insurance Trust Securities Total'}, {"type": "LiteralStr", "value": 'Insurance Trust'}, {"type": "LiteralStr", "value": 'Insurance Trust Cash and Deposits'}, {"type": "LiteralStr", "value": 'Insurance Trust Federal Securities'}], "values": [
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}, 
						{"type": "NumType"}]}, 
					{"type": "DictType", "literals": [{"type": "LiteralStr", "value": 'Public Welfare Assistance and Subsidies'}, {"type": "LiteralStr", "value": 'Public Welfare Total Expenditure'}, {"type": "LiteralStr", "value": 'Public Welfare Equipment and Land'}, {"type": "LiteralStr", "value": 'Public Welfare Construction'}, {"type": "LiteralStr", "value": 'Public Welfare Other Current Operation'}, {"type": "LiteralStr", "value": 'Public Welfare Intergovernmental'}, {"type": "LiteralStr", "value": 'Public Welfare Direct Expenditure'}], "values": [
						{"type": "NumType"}, 
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