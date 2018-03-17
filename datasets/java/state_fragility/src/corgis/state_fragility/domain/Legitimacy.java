package corgis.state_fragility.domain;

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
public class Legitimacy {
	
    // The sum of the four dimensions of the Legitimacy Score
    private Integer legitimacyScore;
    private Integer politicalLegitimacy;
    private Integer economicLegitimacy;
    private Integer socialLegitimacy;
    private Integer securityLegitimacy;
    
    
    /**
     * The sum of the four dimensions of the Legitimacy Score
     * @return Integer
     */
    public Integer getLegitimacyScore() {
        return this.legitimacyScore;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getPoliticalLegitimacy() {
        return this.politicalLegitimacy;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getEconomicLegitimacy() {
        return this.economicLegitimacy;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getSocialLegitimacy() {
        return this.socialLegitimacy;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getSecurityLegitimacy() {
        return this.securityLegitimacy;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Legitimacy.
	
	 * @return String
	 */
	public String toString() {
		return "Legitimacy[" +legitimacyScore+", "+politicalLegitimacy+", "+economicLegitimacy+", "+socialLegitimacy+", "+securityLegitimacy+"]";
	}
	
	/**
	 * Internal constructor to create a Legitimacy from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Legitimacy(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Legitimacy Score
            this.legitimacyScore = ((Number)json_data.get("Legitimacy Score")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Legitimacy; the field legitimacyScore was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Legitimacy; the field legitimacyScore had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Political Legitimacy
            this.politicalLegitimacy = ((Number)json_data.get("Political Legitimacy")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Legitimacy; the field politicalLegitimacy was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Legitimacy; the field politicalLegitimacy had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Economic Legitimacy
            this.economicLegitimacy = ((Number)json_data.get("Economic Legitimacy")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Legitimacy; the field economicLegitimacy was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Legitimacy; the field economicLegitimacy had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Social Legitimacy
            this.socialLegitimacy = ((Number)json_data.get("Social Legitimacy")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Legitimacy; the field socialLegitimacy was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Legitimacy; the field socialLegitimacy had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Security Legitimacy
            this.securityLegitimacy = ((Number)json_data.get("Security Legitimacy")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Legitimacy; the field securityLegitimacy was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Legitimacy; the field securityLegitimacy had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}