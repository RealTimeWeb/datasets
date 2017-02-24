package corgis.real_estate.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.real_estate.domain.Address;

/**
 * 
 */
public class Location {
	
    private String regionId;
    private Address address;
    private String id;
    private String congressionalDistrict;
    
    
    /*
     * @return 
     */
    public String getRegionId() {
        return this.regionId;
    }
    
    
    
    /*
     * @return 
     */
    public Address getAddress() {
        return this.address;
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
    public String getCongressionalDistrict() {
        return this.congressionalDistrict;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Location.
	
	 * @return String
	 */
	public String toString() {
		return "Location[" +regionId+", "+address+", "+id+", "+congressionalDistrict+"]";
	}
	
	/**
	 * Internal constructor to create a Location from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Location(JSONObject json_data) {
        try {// region id
            this.regionId = (String)json_data.get("region id");// address
            this.address = new Address((JSONObject)json_data.get("address"));// id
            this.id = (String)json_data.get("id");// congressional district
            this.congressionalDistrict = (String)json_data.get("congressional district");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}