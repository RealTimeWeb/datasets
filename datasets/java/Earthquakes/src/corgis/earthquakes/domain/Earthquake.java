package corgis.earthquakes.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.earthquakes.domain.Impact;
import corgis.earthquakes.domain.Time;
import corgis.earthquakes.domain.Location;

/**
 * 
 */
public class Earthquake {
	
    private Impact impact;
    private Time time;
    private Location location;
    private String id;
    
    
    /*
     * @return 
     */
    public Impact getImpact() {
        return this.impact;
    }
    
    
    
    /*
     * @return 
     */
    public Time getTime() {
        return this.time;
    }
    
    
    
    /*
     * @return 
     */
    public Location getLocation() {
        return this.location;
    }
    
    
    
    /*
     * @return 
     */
    public String getId() {
        return this.id;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Earthquake.
	
	 * @return String
	 */
	public String toString() {
		return "Earthquake[" +impact+", "+time+", "+location+", "+id+"]";
	}
	
	/**
	 * Internal constructor to create a Earthquake from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Earthquake(JSONObject json_data) {
        try {// impact
            this.impact = new Impact((JSONObject)json_data.get("impact"));// time
            this.time = new Time((JSONObject)json_data.get("time"));// location
            this.location = new Location((JSONObject)json_data.get("location"));// id
            this.id = (String)json_data.get("id");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Earthquake; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Earthquake; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}