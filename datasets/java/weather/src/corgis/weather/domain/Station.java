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
public class Station {
	
    private String city;
    private String state;
    private String code;
    private String location;
    
    
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
    public String getCode() {
        return this.code;
    }
    
    
    
    /*
     * @return 
     */
    public String getLocation() {
        return this.location;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Station.
	
	 * @return String
	 */
	public String toString() {
		return "Station[" +city+", "+state+", "+code+", "+location+"]";
	}
	
	/**
	 * Internal constructor to create a Station from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Station(JSONObject json_data) {
        try {// City
            this.city = (String)json_data.get("City");// State
            this.state = (String)json_data.get("State");// Code
            this.code = (String)json_data.get("Code");// Location
            this.location = (String)json_data.get("Location");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Station; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Station; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}