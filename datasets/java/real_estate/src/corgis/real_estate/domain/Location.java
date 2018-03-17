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
    private String congressionalDistrict;
    private String id;
    private Address address;
    
    
    /**
     * 
     * @return String
     */
    public String getRegionId() {
        return this.regionId;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getCongressionalDistrict() {
        return this.congressionalDistrict;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getId() {
        return this.id;
    }
    
    
    
    /**
     * 
     * @return Address
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
        //System.out.println(json_data);
        
        try {
            // region id
            this.regionId = (String)json_data.get("region id");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field regionId was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field regionId had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // congressional district
            this.congressionalDistrict = (String)json_data.get("congressional district");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field congressionalDistrict was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field congressionalDistrict had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // id
            this.id = (String)json_data.get("id");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field id was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field id had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // address
            this.address = new Address((JSONObject)json_data.get("address"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field address was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field address had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}