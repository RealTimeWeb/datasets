package corgis.realestate.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.realestate.domain.Data;
import corgis.realestate.domain.Location;

/**
 * 
 */
public class Building {
	
    private Data data;
    private Location location;
    
    
    /*
     * @return 
     */
    public Data getData() {
        return this.data;
    }
    
    
    
    /*
     * @return 
     */
    public Location getLocation() {
        return this.location;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Building.
	
	 * @return String
	 */
	public String toString() {
		return "Building[" +data+", "+location+"]";
	}
	
	/**
	 * Internal constructor to create a Building from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Building(JSONObject json_data) {
        try {// data
            this.data = new Data((JSONObject)json_data.get("data"));// location
            this.location = new Location((JSONObject)json_data.get("location"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Building; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Building; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}