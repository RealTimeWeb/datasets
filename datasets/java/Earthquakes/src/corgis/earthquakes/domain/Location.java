package corgis.earthquakes.domain;

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
	
    private Double distance;
    private String full;
    private Double depth;
    private Double longitude;
    private String state;
    private Double latitude;
    
    
    /*
     * @return 
     */
    public Double getDistance() {
        return this.distance;
    }
    
    
    
    /*
     * @return 
     */
    public String getFull() {
        return this.full;
    }
    
    
    
    /*
     * @return 
     */
    public Double getDepth() {
        return this.depth;
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
    public String getState() {
        return this.state;
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
		return "Location[" +distance+", "+full+", "+depth+", "+longitude+", "+state+", "+latitude+"]";
	}
	
	/**
	 * Internal constructor to create a Location from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Location(JSONObject json_data) {
        try {// distance
            this.distance = (Double)json_data.get("distance");// full
            this.full = (String)json_data.get("full");// depth
            this.depth = (Double)json_data.get("depth");// longitude
            this.longitude = (Double)json_data.get("longitude");// state
            this.state = (String)json_data.get("state");// latitude
            this.latitude = (Double)json_data.get("latitude");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}