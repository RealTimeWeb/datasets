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
import corgis.earthquakes.domain.Location;
import corgis.earthquakes.domain.Time;

/**
 * 
 */
public class Earthquake {
	
    private Impact impact;
    // A unique name for this earthquake.
    private String id;
    private Location location;
    private Time time;
    
    
    /*
     * @return 
     */
    public Impact getImpact() {
        return this.impact;
    }
    
    
    
    /*
     * @return 
     */
    public String getId() {
        return this.id;
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
    public Time getTime() {
        return this.time;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Earthquake.
	
	 * @return String
	 */
	public String toString() {
		return "Earthquake[" +impact+", "+id+", "+location+", "+time+"]";
	}
	
	/**
	 * Internal constructor to create a Earthquake from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Earthquake(JSONObject json_data) {
        try {// impact
            this.impact = new Impact((JSONObject)json_data.get("impact"));// id
            this.id = (String)json_data.get("id");// location
            this.location = new Location((JSONObject)json_data.get("location"));// time
            this.time = new Time((JSONObject)json_data.get("time"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Earthquake; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Earthquake; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}