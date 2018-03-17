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
	
    // The exact location of this recording station. Note that the recording station itself might be in a different location than where it sends its data.
    private String location;
    // The unique code representing this station.
    private String code;
    // The city that the reporting station sends its data to. Note that the recording station itself might actually be in a different city.
    private String city;
    // The state that the reporting station sends its data to. Note that the recording station itself might actually be in a different state.
    private String state;
    
    
    /**
     * The exact location of this recording station. Note that the recording station itself might be in a different location than where it sends its data.
     * @return String
     */
    public String getLocation() {
        return this.location;
    }
    
    
    
    /**
     * The unique code representing this station.
     * @return String
     */
    public String getCode() {
        return this.code;
    }
    
    
    
    /**
     * The city that the reporting station sends its data to. Note that the recording station itself might actually be in a different city.
     * @return String
     */
    public String getCity() {
        return this.city;
    }
    
    
    
    /**
     * The state that the reporting station sends its data to. Note that the recording station itself might actually be in a different state.
     * @return String
     */
    public String getState() {
        return this.state;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Station.
	
	 * @return String
	 */
	public String toString() {
		return "Station[" +location+", "+code+", "+city+", "+state+"]";
	}
	
	/**
	 * Internal constructor to create a Station from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Station(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Location
            this.location = (String)json_data.get("Location");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Station; the field location was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Station; the field location had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Code
            this.code = (String)json_data.get("Code");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Station; the field code was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Station; the field code had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // City
            this.city = (String)json_data.get("City");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Station; the field city was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Station; the field city had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // State
            this.state = (String)json_data.get("State");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Station; the field state was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Station; the field state had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}