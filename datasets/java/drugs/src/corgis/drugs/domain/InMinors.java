package corgis.drugs.domain;

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
public class InMinors {
	
    // The percentage of the population of minors (12-20 years old) who have drank alcohol in the past month.
    private Double use;
    // The percentage of the population of minors (12-20 years old) who have binged alcohol in the past month. Binge Alcohol Use is defined as drinking five or more drinks on the same occasion (i.e., at the same time or within a couple of hours of each other) on at least 1 day in the past 30 days.
    private Double abuse;
    
    
    /*
     * @return 
     */
    public Double getUse() {
        return this.use;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAbuse() {
        return this.abuse;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this InMinors.
	
	 * @return String
	 */
	public String toString() {
		return "InMinors[" +use+", "+abuse+"]";
	}
	
	/**
	 * Internal constructor to create a InMinors from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public InMinors(JSONObject json_data) {
        try {// Use
            this.use = ((Number)json_data.get("Use")).doubleValue();// Abuse
            this.abuse = ((Number)json_data.get("Abuse")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a InMinors; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a InMinors; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}