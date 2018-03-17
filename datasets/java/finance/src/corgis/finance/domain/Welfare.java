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
	
    // Total amount spent on welfare (not elsewhere classified).
    private Integer welfareNecTotalExpenditure;
    // Total amount spent on welfare institutions.
    private Integer welfareInstitutionTotalExpenditure;
    // Total amount spent on welfare vendor payments.
    private Integer welfareVendorPaymentsTotal;
    // Money paid to other governments for welfare not elsewhere classified.
    private Integer welfareNecIntergovernmental;
    
    
    /**
     * Total amount spent on welfare (not elsewhere classified).
     * @return Integer
     */
    public Integer getWelfareNecTotalExpenditure() {
        return this.welfareNecTotalExpenditure;
    }
    
    
    
    /**
     * Total amount spent on welfare institutions.
     * @return Integer
     */
    public Integer getWelfareInstitutionTotalExpenditure() {
        return this.welfareInstitutionTotalExpenditure;
    }
    
    
    
    /**
     * Total amount spent on welfare vendor payments.
     * @return Integer
     */
    public Integer getWelfareVendorPaymentsTotal() {
        return this.welfareVendorPaymentsTotal;
    }
    
    
    
    /**
     * Money paid to other governments for welfare not elsewhere classified.
     * @return Integer
     */
    public Integer getWelfareNecIntergovernmental() {
        return this.welfareNecIntergovernmental;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Welfare.
	
	 * @return String
	 */
	public String toString() {
		return "Welfare[" +welfareNecTotalExpenditure+", "+welfareInstitutionTotalExpenditure+", "+welfareVendorPaymentsTotal+", "+welfareNecIntergovernmental+"]";
	}
	
	/**
	 * Internal constructor to create a Welfare from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Welfare(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Welfare NEC Total Expenditure
            this.welfareNecTotalExpenditure = ((Number)json_data.get("Welfare NEC Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Welfare; the field welfareNecTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Welfare; the field welfareNecTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Welfare Institution Total Expenditure
            this.welfareInstitutionTotalExpenditure = ((Number)json_data.get("Welfare Institution Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Welfare; the field welfareInstitutionTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Welfare; the field welfareInstitutionTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Welfare Vendor Payments Total
            this.welfareVendorPaymentsTotal = ((Number)json_data.get("Welfare Vendor Payments Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Welfare; the field welfareVendorPaymentsTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Welfare; the field welfareVendorPaymentsTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Welfare NEC Intergovernmental
            this.welfareNecIntergovernmental = ((Number)json_data.get("Welfare NEC Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Welfare; the field welfareNecIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Welfare; the field welfareNecIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}