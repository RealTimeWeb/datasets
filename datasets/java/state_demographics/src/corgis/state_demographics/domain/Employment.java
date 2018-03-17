package corgis.state_demographics.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.state_demographics.domain.Firms;

/**
 * 
 */
public class Employment {
	
    private Firms firms;
    // 2012-2013
    private Double privateNonFarmEmploymentPercentChange;
    // 2013
    private Integer privateNonFarmEstablishments;
    // 2013
    private Integer privateNonFarmEmployment;
    // 2013
    private Integer nonemployerEstablishments;
    
    
    /**
     * 
     * @return Firms
     */
    public Firms getFirms() {
        return this.firms;
    }
    
    
    
    /**
     * 2012-2013
     * @return Double
     */
    public Double getPrivateNonFarmEmploymentPercentChange() {
        return this.privateNonFarmEmploymentPercentChange;
    }
    
    
    
    /**
     * 2013
     * @return Integer
     */
    public Integer getPrivateNonFarmEstablishments() {
        return this.privateNonFarmEstablishments;
    }
    
    
    
    /**
     * 2013
     * @return Integer
     */
    public Integer getPrivateNonFarmEmployment() {
        return this.privateNonFarmEmployment;
    }
    
    
    
    /**
     * 2013
     * @return Integer
     */
    public Integer getNonemployerEstablishments() {
        return this.nonemployerEstablishments;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Employment.
	
	 * @return String
	 */
	public String toString() {
		return "Employment[" +firms+", "+privateNonFarmEmploymentPercentChange+", "+privateNonFarmEstablishments+", "+privateNonFarmEmployment+", "+nonemployerEstablishments+"]";
	}
	
	/**
	 * Internal constructor to create a Employment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Employment(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Firms
            this.firms = new Firms((JSONObject)json_data.get("Firms"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; the field firms was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; the field firms had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Private Non-farm Employment Percent Change
            this.privateNonFarmEmploymentPercentChange = ((Number)json_data.get("Private Non-farm Employment Percent Change")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; the field privateNonFarmEmploymentPercentChange was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; the field privateNonFarmEmploymentPercentChange had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Private Non-farm Establishments
            this.privateNonFarmEstablishments = ((Number)json_data.get("Private Non-farm Establishments")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; the field privateNonFarmEstablishments was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; the field privateNonFarmEstablishments had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Private Non-farm Employment
            this.privateNonFarmEmployment = ((Number)json_data.get("Private Non-farm Employment")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; the field privateNonFarmEmployment was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; the field privateNonFarmEmployment had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Nonemployer Establishments
            this.nonemployerEstablishments = ((Number)json_data.get("Nonemployer Establishments")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; the field nonemployerEstablishments was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; the field nonemployerEstablishments had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}