package corgis.state_fragility.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.state_fragility.domain.Metrics;

/**
 * 
 */
public class Score {
	
    private Metrics metrics;
    private String country;
    private Integer year;
    
    
    /*
     * @return 
     */
    public Metrics getMetrics() {
        return this.metrics;
    }
    
    
    
    /*
     * @return 
     */
    public String getCountry() {
        return this.country;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Score.
	
	 * @return String
	 */
	public String toString() {
		return "Score[" +metrics+", "+country+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Score from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Score(JSONObject json_data) {
        try {// Metrics
            this.metrics = new Metrics((JSONObject)json_data.get("Metrics"));// Country
            this.country = (String)json_data.get("Country");// Year
            this.year = ((Number)json_data.get("Year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Score; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Score; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}