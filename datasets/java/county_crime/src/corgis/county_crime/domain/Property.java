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
public class Property {
	
    private Integer burglary;
    private Integer larceny;
    private Integer all;
    private Double motor;
    
    
    /*
     * @return 
     */
    public Integer getBurglary() {
        return this.burglary;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLarceny() {
        return this.larceny;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAll() {
        return this.all;
    }
    
    
    
    /*
     * @return 
     */
    public Double getMotor() {
        return this.motor;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Property.
	
	 * @return String
	 */
	public String toString() {
		return "Property[" +burglary+", "+larceny+", "+all+", "+motor+"]";
	}
	
	/**
	 * Internal constructor to create a Property from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Property(JSONObject json_data) {
        try {// Burglary
            this.burglary = new Integer(((Long)json_data.get("Burglary")).intValue());// Larceny
            this.larceny = new Integer(((Long)json_data.get("Larceny")).intValue());// All
            this.all = new Integer(((Long)json_data.get("All")).intValue());// Motor
            this.motor = (Double)json_data.get("Motor");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Property; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Property; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}