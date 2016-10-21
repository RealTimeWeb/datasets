package corgis.hospitals.domain;

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
public class Location {
	
    private String city;
    private String zipCode;
    private Double longitude;
    private String county;
    private String state;
    private String address;
    private Double latitude;
    
    
    /*
     * @return 
     */
    public String getCity() {
        return this.city;
    }
    
    
    
    /*
     * @return 
     */
    public String getZipCode() {
        return this.zipCode;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLongitude() {
        return this.longitude;
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
    public String getAddress() {
        return this.address;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLatitude() {
        return this.latitude;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Location.
	
	 * @return String
	 */
	public String toString() {
		return "Location[" +city+", "+zipCode+", "+longitude+", "+county+", "+state+", "+address+", "+latitude+"]";
	}
	
	/**
	 * Internal constructor to create a Location from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Location(JSONObject json_data) {
        try {// City
            this.city = (String)json_data.get("City");// ZIP Code
            this.zipCode = (String)json_data.get("ZIP Code");// Longitude
            this.longitude = ((Number)json_data.get("Longitude")).doubleValue();// County
            this.county = (String)json_data.get("County");// State
            this.state = (String)json_data.get("State");// Address
            this.address = (String)json_data.get("Address");// Latitude
            this.latitude = ((Number)json_data.get("Latitude")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}