package corgis.slavery.domain;

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
public class Seller {
	
    private String origin;
    private String countyOfOrigin;
    private String fullName;
    private String stateOfOrigin;
    
    
    /*
     * @return 
     */
    public String getOrigin() {
        return this.origin;
    }
    
    
    
    /*
     * @return 
     */
    public String getCountyOfOrigin() {
        return this.countyOfOrigin;
    }
    
    
    
    /*
     * @return 
     */
    public String getFullName() {
        return this.fullName;
    }
    
    
    
    /*
     * @return 
     */
    public String getStateOfOrigin() {
        return this.stateOfOrigin;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Seller.
	
	 * @return String
	 */
	public String toString() {
		return "Seller[" +origin+", "+countyOfOrigin+", "+fullName+", "+stateOfOrigin+"]";
	}
	
	/**
	 * Internal constructor to create a Seller from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Seller(JSONObject json_data) {
        try {// Origin
            this.origin = (String)json_data.get("Origin");// County of Origin
            this.countyOfOrigin = (String)json_data.get("County of Origin");// Full Name
            this.fullName = (String)json_data.get("Full Name");// State of Origin
            this.stateOfOrigin = (String)json_data.get("State of Origin");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Seller; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Seller; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}