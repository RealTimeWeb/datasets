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
    private Location location;
    // A unique name for this earthquake.
    private String id;
    private Time time;
    
    
    /**
     * 
     * @return Impact
     */
    public Impact getImpact() {
        return this.impact;
    }
    
    
    
    /**
     * 
     * @return Location
     */
    public Location getLocation() {
        return this.location;
    }
    
    
    
    /**
     * A unique name for this earthquake.
     * @return String
     */
    public String getId() {
        return this.id;
    }
    
    
    
    /**
     * 
     * @return Time
     */
    public Time getTime() {
        return this.time;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Earthquake.
	
	 * @return String
	 */
	public String toString() {
		return "Earthquake[" +impact+", "+location+", "+id+", "+time+"]";
	}
	
	/**
	 * Internal constructor to create a Earthquake from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Earthquake(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // impact
            this.impact = new Impact((JSONObject)json_data.get("impact"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Earthquake; the field impact was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Earthquake; the field impact had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // location
            this.location = new Location((JSONObject)json_data.get("location"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Earthquake; the field location was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Earthquake; the field location had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // id
            this.id = (String)json_data.get("id");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Earthquake; the field id was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Earthquake; the field id had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // time
            this.time = new Time((JSONObject)json_data.get("time"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Earthquake; the field time was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Earthquake; the field time had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}