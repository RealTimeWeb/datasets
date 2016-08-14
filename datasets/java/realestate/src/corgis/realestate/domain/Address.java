package corgis.realestate.domain;

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
    private String zip;
    private String county;
    private String state;
    private String lineOne;
    private String lineTwo;
    
    
    /*
     * @return 
     */
    public String getCity() {
        return this.city;
    }
    
    
    
    /*
     * @return 
     */
    public String getZip() {
        return this.zip;
    }
    
    
    
    /*
     * @return 
     */
    public String getCounty() {
        return this.county;
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
    public String getLineOne() {
        return this.lineOne;
    }
    
    
    
    /*
     * @return 
     */
    public String getLineTwo() {
        return this.lineTwo;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Address.
	
	 * @return String
	 */
	public String toString() {
		return "Address[" +city+", "+zip+", "+county+", "+state+", "+lineOne+", "+lineTwo+"]";
	}
	
	/**
	 * Internal constructor to create a Address from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Address(JSONObject json_data) {
        try {// city
            this.city = (String)json_data.get("city");// zip
            this.zip = (String)json_data.get("zip");// county
            this.county = (String)json_data.get("county");// state
            this.state = (String)json_data.get("state");// line 1
            this.lineOne = (String)json_data.get("line 1");// line 2
            this.lineTwo = (String)json_data.get("line 2");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Address; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Address; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}