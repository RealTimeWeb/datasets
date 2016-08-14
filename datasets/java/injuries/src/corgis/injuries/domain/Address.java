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
	
    private String city;
    private String state;
    private String street;
    private Integer zip;
    
    
    /*
     * @return 
     */
    public String getCity() {
        return this.city;
    }
    
    
    
    /*
     * @return 
     */
    public String getState() {
        return this.state;
    }
    
    
    
    /*
     * @return 
     */
    public String getStreet() {
        return this.street;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getZip() {
        return this.zip;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Address.
	
	 * @return String
	 */
	public String toString() {
		return "Address[" +city+", "+state+", "+street+", "+zip+"]";
	}
	
	/**
	 * Internal constructor to create a Address from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Address(JSONObject json_data) {
        try {// city
            this.city = (String)json_data.get("city");// state
            this.state = (String)json_data.get("state");// street
            this.street = (String)json_data.get("street");// zip
            this.zip = new Integer(((Long)json_data.get("zip")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Address; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Address; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}