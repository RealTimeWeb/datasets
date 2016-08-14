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
import corgis.hydropower.domain.Identity;
import corgis.hydropower.domain.Dimensions;

/**
 * 
 */
public class Dam {
	
    private Location location;
    private Identity identity;
    private Dimensions dimensions;
    
    
    /*
     * @return 
     */
    public Location getLocation() {
        return this.location;
    }
    
    
    
    /*
     * @return 
     */
    public Identity getIdentity() {
        return this.identity;
    }
    
    
    
    /*
     * @return 
     */
    public Dimensions getDimensions() {
        return this.dimensions;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Dam.
	
	 * @return String
	 */
	public String toString() {
		return "Dam[" +location+", "+identity+", "+dimensions+"]";
	}
	
	/**
	 * Internal constructor to create a Dam from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Dam(JSONObject json_data) {
        try {// Location
            this.location = new Location((JSONObject)json_data.get("Location"));// Identity
            this.identity = new Identity((JSONObject)json_data.get("Identity"));// Dimensions
            this.dimensions = new Dimensions((JSONObject)json_data.get("Dimensions"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Dam; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Dam; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}