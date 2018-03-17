package corgis.hydropower.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.hydropower.domain.Location;
import corgis.hydropower.domain.Dimensions;
import corgis.hydropower.domain.Identity;

/**
 * 
 */
public class Dam {
	
    private Location location;
    private Dimensions dimensions;
    private Identity identity;
    
    
    /**
     * 
     * @return Location
     */
    public Location getLocation() {
        return this.location;
    }
    
    
    
    /**
     * 
     * @return Dimensions
     */
    public Dimensions getDimensions() {
        return this.dimensions;
    }
    
    
    
    /**
     * 
     * @return Identity
     */
    public Identity getIdentity() {
        return this.identity;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Dam.
	
	 * @return String
	 */
	public String toString() {
		return "Dam[" +location+", "+dimensions+", "+identity+"]";
	}
	
	/**
	 * Internal constructor to create a Dam from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Dam(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Location
            this.location = new Location((JSONObject)json_data.get("Location"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Dam; the field location was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Dam; the field location had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Dimensions
            this.dimensions = new Dimensions((JSONObject)json_data.get("Dimensions"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Dam; the field dimensions was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Dam; the field dimensions had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Identity
            this.identity = new Identity((JSONObject)json_data.get("Identity"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Dam; the field identity was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Dam; the field identity had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}