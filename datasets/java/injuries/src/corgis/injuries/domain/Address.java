package corgis.injuries.domain;

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
public class Address {
	
    private Integer zip;
    private String city;
    private String state;
    private String street;
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getZip() {
        return this.zip;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getCity() {
        return this.city;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getState() {
        return this.state;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getStreet() {
        return this.street;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Address.
	
	 * @return String
	 */
	public String toString() {
		return "Address[" +zip+", "+city+", "+state+", "+street+"]";
	}
	
	/**
	 * Internal constructor to create a Address from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Address(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // zip
            this.zip = ((Number)json_data.get("zip")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Address; the field zip was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Address; the field zip had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // city
            this.city = (String)json_data.get("city");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Address; the field city was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Address; the field city had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // state
            this.state = (String)json_data.get("state");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Address; the field state was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Address; the field state had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // street
            this.street = (String)json_data.get("street");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Address; the field street was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Address; the field street had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}