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
	
    // Money paid to other governments for the support of agriculture.
    private Integer agricultureIntergovernmental;
    // Total amount spent on the support of agriculture.
    private Integer agricultureTotalExpenditure;
    // Money paid to other governments for the federal agriculture farm income.
    private Integer federalAgricultureFarmIncomeIntergovernmental;
    // Total amount spent on the federal agriculture farm income.
    private Integer federalAgricultureFarmIncomeTotal;
    // Total amount spent on federal farm credit.
    private Integer federalFarmCreditTotal;
    // Total amount spent on federal farm credit.
    private Integer federalFarmCreditIntergovernmental;
    
    
    /*
     * @return 
     */
    public Integer getAgricultureIntergovernmental() {
        return this.agricultureIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAgricultureTotalExpenditure() {
        return this.agricultureTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalAgricultureFarmIncomeIntergovernmental() {
        return this.federalAgricultureFarmIncomeIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalAgricultureFarmIncomeTotal() {
        return this.federalAgricultureFarmIncomeTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalFarmCreditTotal() {
        return this.federalFarmCreditTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalFarmCreditIntergovernmental() {
        return this.federalFarmCreditIntergovernmental;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Agriculture.
	
	 * @return String
	 */
	public String toString() {
		return "Agriculture[" +agricultureIntergovernmental+", "+agricultureTotalExpenditure+", "+federalAgricultureFarmIncomeIntergovernmental+", "+federalAgricultureFarmIncomeTotal+", "+federalFarmCreditTotal+", "+federalFarmCreditIntergovernmental+"]";
	}
	
	/**
	 * Internal constructor to create a Agriculture from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Agriculture(JSONObject json_data) {
        try {// Agriculture Intergovernmental
            this.agricultureIntergovernmental = ((Number)json_data.get("Agriculture Intergovernmental")).intValue();// Agriculture Total Expenditure
            this.agricultureTotalExpenditure = ((Number)json_data.get("Agriculture Total Expenditure")).intValue();// Federal Agriculture Farm Income Intergovernmental
            this.federalAgricultureFarmIncomeIntergovernmental = ((Number)json_data.get("Federal Agriculture Farm Income Intergovernmental")).intValue();// Federal Agriculture Farm Income Total
            this.federalAgricultureFarmIncomeTotal = ((Number)json_data.get("Federal Agriculture Farm Income Total")).intValue();// Federal Farm Credit Total
            this.federalFarmCreditTotal = ((Number)json_data.get("Federal Farm Credit Total")).intValue();// Federal Farm Credit Intergovernmental
            this.federalFarmCreditIntergovernmental = ((Number)json_data.get("Federal Farm Credit Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Agriculture; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Agriculture; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}