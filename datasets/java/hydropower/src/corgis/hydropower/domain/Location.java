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
	
    private String county;
    // Missing values for the Longitude were imputed with a mean value of -97.501892792978808
    private Double longitude;
    // Missing values for the Latitude were imputed with a mean value of 36.278079019861529
    private Double latitude;
    private String state;
    
    
    /**
     * 
     * @return String
     */
    public String getCounty() {
        return this.county;
    }
    
    
    
    /**
     * Missing values for the Longitude were imputed with a mean value of -97.501892792978808
     * @return Double
     */
    public Double getLongitude() {
        return this.longitude;
    }
    
    
    
    /**
     * Missing values for the Latitude were imputed with a mean value of 36.278079019861529
     * @return Double
     */
    public Double getLatitude() {
        return this.latitude;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getState() {
        return this.state;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Location.
	
	 * @return String
	 */
	public String toString() {
		return "Location[" +county+", "+longitude+", "+latitude+", "+state+"]";
	}
	
	/**
	 * Internal constructor to create a Location from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Location(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // County
            this.county = (String)json_data.get("County");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field county was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field county had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Longitude
            this.longitude = ((Number)json_data.get("Longitude")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field longitude was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field longitude had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Latitude
            this.latitude = ((Number)json_data.get("Latitude")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field latitude was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field latitude had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // State
            this.state = (String)json_data.get("State");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field state was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field state had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}