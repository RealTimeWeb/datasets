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
public class Buyer {
	
    private String origin;
    private String stateOfOrigin;
    private String countyOfOrigin;
    private String fullName;
    
    
    /**
     * 
     * @return String
     */
    public String getOrigin() {
        return this.origin;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getStateOfOrigin() {
        return this.stateOfOrigin;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getCountyOfOrigin() {
        return this.countyOfOrigin;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getFullName() {
        return this.fullName;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Buyer.
	
	 * @return String
	 */
	public String toString() {
		return "Buyer[" +origin+", "+stateOfOrigin+", "+countyOfOrigin+", "+fullName+"]";
	}
	
	/**
	 * Internal constructor to create a Buyer from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Buyer(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Origin
            this.origin = (String)json_data.get("Origin");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Buyer; the field origin was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Buyer; the field origin had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // State of Origin
            this.stateOfOrigin = (String)json_data.get("State of Origin");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Buyer; the field stateOfOrigin was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Buyer; the field stateOfOrigin had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // County of Origin
            this.countyOfOrigin = (String)json_data.get("County of Origin");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Buyer; the field countyOfOrigin was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Buyer; the field countyOfOrigin had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Full Name
            this.fullName = (String)json_data.get("Full Name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Buyer; the field fullName was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Buyer; the field fullName had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}