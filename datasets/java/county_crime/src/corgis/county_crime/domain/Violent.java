package corgis.county_crime.domain;

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
public class Violent {
	
    private Double all;
    private Double murder;
    private Double rape;
    private Double robbery;
    private Double assault;
    
    
    /*
     * @return 
     */
    public Double getAll() {
        return this.all;
    }
    
    
    
    /*
     * @return 
     */
    public Double getMurder() {
        return this.murder;
    }
    
    
    
    /*
     * @return 
     */
    public Double getRape() {
        return this.rape;
    }
    
    
    
    /*
     * @return 
     */
    public Double getRobbery() {
        return this.robbery;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAssault() {
        return this.assault;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Violent.
	
	 * @return String
	 */
	public String toString() {
		return "Violent[" +all+", "+murder+", "+rape+", "+robbery+", "+assault+"]";
	}
	
	/**
	 * Internal constructor to create a Violent from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Violent(JSONObject json_data) {
        try {// All
            this.all = ((Number)json_data.get("All")).doubleValue();// Murder
            this.murder = ((Number)json_data.get("Murder")).doubleValue();// Rape
            this.rape = ((Number)json_data.get("Rape")).doubleValue();// Robbery
            this.robbery = ((Number)json_data.get("Robbery")).doubleValue();// Assault
            this.assault = ((Number)json_data.get("Assault")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Violent; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Violent; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}