package corgis.real_estate.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.real_estate.domain.Location;
import corgis.real_estate.domain.Data;

/**
 * 
 */
public class Building {
	
    private Location location;
    private Data data;
    
    
    /**
     * 
     * @return Location
     */
    public Location getLocation() {
        return this.location;
    }
    
    
    
    /**
     * 
     * @return Data
     */
    public Data getData() {
        return this.data;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Building.
	
	 * @return String
	 */
	public String toString() {
		return "Building[" +location+", "+data+"]";
	}
	
	/**
	 * Internal constructor to create a Building from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Building(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // location
            this.location = new Location((JSONObject)json_data.get("location"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Building; the field location was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Building; the field location had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // data
            this.data = new Data((JSONObject)json_data.get("data"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Building; the field data was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Building; the field data had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}