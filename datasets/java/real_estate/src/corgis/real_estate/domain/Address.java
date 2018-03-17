package corgis.real_estate.domain;

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
	
    private String county;
    private String zip;
    private String lineOne;
    private String city;
    private String state;
    private String lineTwo;
    
    
    /**
     * 
     * @return String
     */
    public String getCounty() {
        return this.county;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getZip() {
        return this.zip;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getLineOne() {
        return this.lineOne;
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
    public String getLineTwo() {
        return this.lineTwo;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Address.
	
	 * @return String
	 */
	public String toString() {
		return "Address[" +county+", "+zip+", "+lineOne+", "+city+", "+state+", "+lineTwo+"]";
	}
	
	/**
	 * Internal constructor to create a Address from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Address(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // county
            this.county = (String)json_data.get("county");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Address; the field county was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Address; the field county had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // zip
            this.zip = (String)json_data.get("zip");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Address; the field zip was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Address; the field zip had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // line 1
            this.lineOne = (String)json_data.get("line 1");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Address; the field lineOne was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Address; the field lineOne had the wrong structure.");
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
            // line 2
            this.lineTwo = (String)json_data.get("line 2");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Address; the field lineTwo was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Address; the field lineTwo had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}