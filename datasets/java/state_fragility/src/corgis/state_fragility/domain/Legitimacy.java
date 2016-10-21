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
    private Integer securityLegitimacy;
    private Integer economicLegitimacy;
    private Integer socialLegitimacy;
    
    
    /*
     * @return 
     */
    public Integer getLegitimacyScore() {
        return this.legitimacyScore;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPoliticalLegitimacy() {
        return this.politicalLegitimacy;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSecurityLegitimacy() {
        return this.securityLegitimacy;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEconomicLegitimacy() {
        return this.economicLegitimacy;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSocialLegitimacy() {
        return this.socialLegitimacy;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Legitimacy.
	
	 * @return String
	 */
	public String toString() {
		return "Legitimacy[" +legitimacyScore+", "+politicalLegitimacy+", "+securityLegitimacy+", "+economicLegitimacy+", "+socialLegitimacy+"]";
	}
	
	/**
	 * Internal constructor to create a Legitimacy from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Legitimacy(JSONObject json_data) {
        try {// Legitimacy Score
            this.legitimacyScore = ((Number)json_data.get("Legitimacy Score")).intValue();// Political Legitimacy
            this.politicalLegitimacy = ((Number)json_data.get("Political Legitimacy")).intValue();// Security Legitimacy
            this.securityLegitimacy = ((Number)json_data.get("Security Legitimacy")).intValue();// Economic Legitimacy
            this.economicLegitimacy = ((Number)json_data.get("Economic Legitimacy")).intValue();// Social Legitimacy
            this.socialLegitimacy = ((Number)json_data.get("Social Legitimacy")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Legitimacy; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Legitimacy; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}