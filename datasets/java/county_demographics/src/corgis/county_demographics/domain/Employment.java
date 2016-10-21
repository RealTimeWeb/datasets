package corgis.county_demographics.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.county_demographics.domain.Firms;

/**
 * 
 */
public class Employment {
	
    // 2013
    private Integer privateNonFarmEstablishments;
    // 2012-2013
    private Double privateNonFarmEmploymentPercentChange;
    // 2007
    private Firms firms;
    // 2013
    private Integer nonemployerEstablishments;
    // 2013
    private Integer privateNonFarmEmployment;
    
    
    /*
     * @return 
     */
    public Integer getPrivateNonFarmEstablishments() {
        return this.privateNonFarmEstablishments;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPrivateNonFarmEmploymentPercentChange() {
        return this.privateNonFarmEmploymentPercentChange;
    }
    
    
    
    /*
     * @return 
     */
    public Firms getFirms() {
        return this.firms;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNonemployerEstablishments() {
        return this.nonemployerEstablishments;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPrivateNonFarmEmployment() {
        return this.privateNonFarmEmployment;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Employment.
	
	 * @return String
	 */
	public String toString() {
		return "Employment[" +privateNonFarmEstablishments+", "+privateNonFarmEmploymentPercentChange+", "+firms+", "+nonemployerEstablishments+", "+privateNonFarmEmployment+"]";
	}
	
	/**
	 * Internal constructor to create a Employment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Employment(JSONObject json_data) {
        try {// Private Non-farm Establishments
            this.privateNonFarmEstablishments = ((Number)json_data.get("Private Non-farm Establishments")).intValue();// Private Non-farm Employment Percent Change
            this.privateNonFarmEmploymentPercentChange = ((Number)json_data.get("Private Non-farm Employment Percent Change")).doubleValue();// Firms
            this.firms = new Firms((JSONObject)json_data.get("Firms"));// Nonemployer Establishments
            this.nonemployerEstablishments = ((Number)json_data.get("Nonemployer Establishments")).intValue();// Private Non-farm Employment
            this.privateNonFarmEmployment = ((Number)json_data.get("Private Non-farm Employment")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}