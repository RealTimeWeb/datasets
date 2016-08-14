package corgis.hydropower.domain;

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
	
    // Missing values for the Latitude were imputed with a mean value of 36.278079019861529
    private Double latitude;
    private String county;
    private String state;
    // Missing values for the Longitude were imputed with a mean value of -97.501892792978808
    private Double longitude;
    
    
    /*
     * @return 
     */
    public Double getLatitude() {
        return this.latitude;
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
    public Double getLongitude() {
        return this.longitude;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Location.
	
	 * @return String
	 */
	public String toString() {
		return "Location[" +latitude+", "+county+", "+state+", "+longitude+"]";
	}
	
	/**
	 * Internal constructor to create a Location from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Location(JSONObject json_data) {
        try {// Latitude
            this.latitude = (Double)json_data.get("Latitude");// County
            this.county = (String)json_data.get("County");// State
            this.state = (String)json_data.get("State");// Longitude
            this.longitude = (Double)json_data.get("Longitude");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}