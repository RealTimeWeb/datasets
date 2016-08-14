package corgis.realestate.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.realestate.domain.Address;

/**
 * 
 */
public class Location {
	
    private String regionId;
    private String congressionalDistrict;
    private String id;
    private Address address;
    
    
    /*
     * @return 
     */
    public String getRegionId() {
        return this.regionId;
    }
    
    
    
    /*
     * @return 
     */
    public String getCongressionalDistrict() {
        return this.congressionalDistrict;
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
    public Address getAddress() {
        return this.address;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Location.
	
	 * @return String
	 */
	public String toString() {
		return "Location[" +regionId+", "+congressionalDistrict+", "+id+", "+address+"]";
	}
	
	/**
	 * Internal constructor to create a Location from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Location(JSONObject json_data) {
        try {// region id
            this.regionId = (String)json_data.get("region id");// congressional district
            this.congressionalDistrict = (String)json_data.get("congressional district");// id
            this.id = (String)json_data.get("id");// address
            this.address = new Address((JSONObject)json_data.get("address"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}