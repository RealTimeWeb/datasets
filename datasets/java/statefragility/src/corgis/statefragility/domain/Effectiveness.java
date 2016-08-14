package corgis.statefragility.domain;

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
public class Effectiveness {
	
    private Integer securityEffectiveness;
    private Integer socialEffectiveness;
    private Integer politicalEffectiveness;
    private Integer economicEffectiveness;
    // The sum of the four dimensions of the Effectiveness Score
    private Integer effectivenessScore;
    
    
    /*
     * @return 
     */
    public Integer getSecurityEffectiveness() {
        return this.securityEffectiveness;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSocialEffectiveness() {
        return this.socialEffectiveness;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPoliticalEffectiveness() {
        return this.politicalEffectiveness;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEconomicEffectiveness() {
        return this.economicEffectiveness;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEffectivenessScore() {
        return this.effectivenessScore;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Effectiveness.
	
	 * @return String
	 */
	public String toString() {
		return "Effectiveness[" +securityEffectiveness+", "+socialEffectiveness+", "+politicalEffectiveness+", "+economicEffectiveness+", "+effectivenessScore+"]";
	}
	
	/**
	 * Internal constructor to create a Effectiveness from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Effectiveness(JSONObject json_data) {
        try {// Security Effectiveness
            this.securityEffectiveness = new Integer(((Long)json_data.get("Security Effectiveness")).intValue());// Social Effectiveness
            this.socialEffectiveness = new Integer(((Long)json_data.get("Social Effectiveness")).intValue());// Political Effectiveness
            this.politicalEffectiveness = new Integer(((Long)json_data.get("Political Effectiveness")).intValue());// Economic Effectiveness
            this.economicEffectiveness = new Integer(((Long)json_data.get("Economic Effectiveness")).intValue());// Effectiveness Score
            this.effectivenessScore = new Integer(((Long)json_data.get("Effectiveness Score")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Effectiveness; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Effectiveness; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}