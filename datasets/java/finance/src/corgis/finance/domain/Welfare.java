package corgis.finance.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * 
 */
public class Welfare {
	
    // Total amount spent on welfare institutions.
    private Integer welfareInstitutionTotalExpenditure;
    // Total amount spent on welfare vendor payments.
    private Integer welfareVendorPaymentsTotal;
    // Total amount spent on welfare (not elsewhere classified).
    private Integer welfareNecTotalExpenditure;
    // Money paid to other governments for welfare not elsewhere classified.
    private Integer welfareNecIntergovernmental;
    
    
    /*
     * @return 
     */
    public Integer getWelfareInstitutionTotalExpenditure() {
        return this.welfareInstitutionTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWelfareVendorPaymentsTotal() {
        return this.welfareVendorPaymentsTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWelfareNecTotalExpenditure() {
        return this.welfareNecTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWelfareNecIntergovernmental() {
        return this.welfareNecIntergovernmental;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Welfare.
	
	 * @return String
	 */
	public String toString() {
		return "Welfare[" +welfareInstitutionTotalExpenditure+", "+welfareVendorPaymentsTotal+", "+welfareNecTotalExpenditure+", "+welfareNecIntergovernmental+"]";
	}
	
	/**
	 * Internal constructor to create a Welfare from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Welfare(JSONObject json_data) {
        try {// Welfare Institution Total Expenditure
            this.welfareInstitutionTotalExpenditure = ((Number)json_data.get("Welfare Institution Total Expenditure")).intValue();// Welfare Vendor Payments Total
            this.welfareVendorPaymentsTotal = ((Number)json_data.get("Welfare Vendor Payments Total")).intValue();// Welfare NEC Total Expenditure
            this.welfareNecTotalExpenditure = ((Number)json_data.get("Welfare NEC Total Expenditure")).intValue();// Welfare NEC Intergovernmental
            this.welfareNecIntergovernmental = ((Number)json_data.get("Welfare NEC Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Welfare; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Welfare; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}