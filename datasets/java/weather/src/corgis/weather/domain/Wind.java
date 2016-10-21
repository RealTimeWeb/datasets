package corgis.weather.domain;

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
public class Wind {
	
    private Double highGust;
    private Double avgWind;
    private Double highWind;
    
    
    /*
     * @return 
     */
    public Double getHighGust() {
        return this.highGust;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAvgWind() {
        return this.avgWind;
    }
    
    
    
    /*
     * @return 
     */
    public Double getHighWind() {
        return this.highWind;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Wind.
	
	 * @return String
	 */
	public String toString() {
		return "Wind[" +highGust+", "+avgWind+", "+highWind+"]";
	}
	
	/**
	 * Internal constructor to create a Wind from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Wind(JSONObject json_data) {
        try {// High Gust
            this.highGust = ((Number)json_data.get("High Gust")).doubleValue();// Avg Wind
            this.avgWind = ((Number)json_data.get("Avg Wind")).doubleValue();// High Wind
            this.highWind = ((Number)json_data.get("High Wind")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Wind; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Wind; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}