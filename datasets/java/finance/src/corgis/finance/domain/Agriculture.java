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
public class Agriculture {
	
    // Total amount spent on federal farm credit.
    private Integer federalFarmCreditIntergovernmental;
    // Money paid to other governments for the federal agriculture farm income.
    private Integer federalAgricultureFarmIncomeIntergovernmental;
    // Total amount spent on the federal agriculture farm income.
    private Integer federalAgricultureFarmIncomeTotal;
    // Total amount spent on the support of agriculture.
    private Integer agricultureTotalExpenditure;
    // Money paid to other governments for the support of agriculture.
    private Integer agricultureIntergovernmental;
    // Total amount spent on federal farm credit.
    private Integer federalFarmCreditTotal;
    
    
    /**
     * Total amount spent on federal farm credit.
     * @return Integer
     */
    public Integer getFederalFarmCreditIntergovernmental() {
        return this.federalFarmCreditIntergovernmental;
    }
    
    
    
    /**
     * Money paid to other governments for the federal agriculture farm income.
     * @return Integer
     */
    public Integer getFederalAgricultureFarmIncomeIntergovernmental() {
        return this.federalAgricultureFarmIncomeIntergovernmental;
    }
    
    
    
    /**
     * Total amount spent on the federal agriculture farm income.
     * @return Integer
     */
    public Integer getFederalAgricultureFarmIncomeTotal() {
        return this.federalAgricultureFarmIncomeTotal;
    }
    
    
    
    /**
     * Total amount spent on the support of agriculture.
     * @return Integer
     */
    public Integer getAgricultureTotalExpenditure() {
        return this.agricultureTotalExpenditure;
    }
    
    
    
    /**
     * Money paid to other governments for the support of agriculture.
     * @return Integer
     */
    public Integer getAgricultureIntergovernmental() {
        return this.agricultureIntergovernmental;
    }
    
    
    
    /**
     * Total amount spent on federal farm credit.
     * @return Integer
     */
    public Integer getFederalFarmCreditTotal() {
        return this.federalFarmCreditTotal;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Agriculture.
	
	 * @return String
	 */
	public String toString() {
		return "Agriculture[" +federalFarmCreditIntergovernmental+", "+federalAgricultureFarmIncomeIntergovernmental+", "+federalAgricultureFarmIncomeTotal+", "+agricultureTotalExpenditure+", "+agricultureIntergovernmental+", "+federalFarmCreditTotal+"]";
	}
	
	/**
	 * Internal constructor to create a Agriculture from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Agriculture(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Federal Farm Credit Intergovernmental
            this.federalFarmCreditIntergovernmental = ((Number)json_data.get("Federal Farm Credit Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Agriculture; the field federalFarmCreditIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Agriculture; the field federalFarmCreditIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Federal Agriculture Farm Income Intergovernmental
            this.federalAgricultureFarmIncomeIntergovernmental = ((Number)json_data.get("Federal Agriculture Farm Income Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Agriculture; the field federalAgricultureFarmIncomeIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Agriculture; the field federalAgricultureFarmIncomeIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Federal Agriculture Farm Income Total
            this.federalAgricultureFarmIncomeTotal = ((Number)json_data.get("Federal Agriculture Farm Income Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Agriculture; the field federalAgricultureFarmIncomeTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Agriculture; the field federalAgricultureFarmIncomeTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Agriculture Total Expenditure
            this.agricultureTotalExpenditure = ((Number)json_data.get("Agriculture Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Agriculture; the field agricultureTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Agriculture; the field agricultureTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Agriculture Intergovernmental
            this.agricultureIntergovernmental = ((Number)json_data.get("Agriculture Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Agriculture; the field agricultureIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Agriculture; the field agricultureIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Federal Farm Credit Total
            this.federalFarmCreditTotal = ((Number)json_data.get("Federal Farm Credit Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Agriculture; the field federalFarmCreditTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Agriculture; the field federalFarmCreditTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}