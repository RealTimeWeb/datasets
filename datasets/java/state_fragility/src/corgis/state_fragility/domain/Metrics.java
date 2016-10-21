package corgis.state_fragility.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.state_fragility.domain.Legitimacy;
import corgis.state_fragility.domain.Effectiveness;

/**
 * 
 */
public class Metrics {
	
    private Legitimacy legitimacy;
    private Effectiveness effectiveness;
    // The sum of the Effectiveness Score and the Legitimacy Score
    private Integer stateFragilityIndex;
    
    
    /*
     * @return 
     */
    public Legitimacy getLegitimacy() {
        return this.legitimacy;
    }
    
    
    
    /*
     * @return 
     */
    public Effectiveness getEffectiveness() {
        return this.effectiveness;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getStateFragilityIndex() {
        return this.stateFragilityIndex;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Metrics.
	
	 * @return String
	 */
	public String toString() {
		return "Metrics[" +legitimacy+", "+effectiveness+", "+stateFragilityIndex+"]";
	}
	
	/**
	 * Internal constructor to create a Metrics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Metrics(JSONObject json_data) {
        try {// Legitimacy
            this.legitimacy = new Legitimacy((JSONObject)json_data.get("Legitimacy"));// Effectiveness
            this.effectiveness = new Effectiveness((JSONObject)json_data.get("Effectiveness"));// State Fragility Index
            this.stateFragilityIndex = ((Number)json_data.get("State Fragility Index")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metrics; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metrics; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}