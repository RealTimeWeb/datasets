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
public class Effectiveness {
	
    // The sum of the four dimensions of the Effectiveness Score
    private Integer effectivenessScore;
    private Integer economicEffectiveness;
    private Integer politicalEffectiveness;
    private Integer securityEffectiveness;
    private Integer socialEffectiveness;
    
    
    /**
     * The sum of the four dimensions of the Effectiveness Score
     * @return Integer
     */
    public Integer getEffectivenessScore() {
        return this.effectivenessScore;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getEconomicEffectiveness() {
        return this.economicEffectiveness;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getPoliticalEffectiveness() {
        return this.politicalEffectiveness;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getSecurityEffectiveness() {
        return this.securityEffectiveness;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getSocialEffectiveness() {
        return this.socialEffectiveness;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Effectiveness.
	
	 * @return String
	 */
	public String toString() {
		return "Effectiveness[" +effectivenessScore+", "+economicEffectiveness+", "+politicalEffectiveness+", "+securityEffectiveness+", "+socialEffectiveness+"]";
	}
	
	/**
	 * Internal constructor to create a Effectiveness from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Effectiveness(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Effectiveness Score
            this.effectivenessScore = ((Number)json_data.get("Effectiveness Score")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Effectiveness; the field effectivenessScore was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Effectiveness; the field effectivenessScore had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Economic Effectiveness
            this.economicEffectiveness = ((Number)json_data.get("Economic Effectiveness")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Effectiveness; the field economicEffectiveness was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Effectiveness; the field economicEffectiveness had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Political Effectiveness
            this.politicalEffectiveness = ((Number)json_data.get("Political Effectiveness")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Effectiveness; the field politicalEffectiveness was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Effectiveness; the field politicalEffectiveness had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Security Effectiveness
            this.securityEffectiveness = ((Number)json_data.get("Security Effectiveness")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Effectiveness; the field securityEffectiveness was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Effectiveness; the field securityEffectiveness had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Social Effectiveness
            this.socialEffectiveness = ((Number)json_data.get("Social Effectiveness")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Effectiveness; the field socialEffectiveness was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Effectiveness; the field socialEffectiveness had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}