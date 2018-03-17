package corgis.skyscrapers.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * 
 */
public class Location {
	
    private Integer longitude;
    private Integer countryId;
    private String city;
    private String country;
    private Integer city_Id;
    private Integer latitude;
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getLongitude() {
        return this.longitude;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getCountryId() {
        return this.countryId;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getCity() {
        return this.city;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getCountry() {
        return this.country;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getCity_Id() {
        return this.city_Id;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getLatitude() {
        return this.latitude;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Location.
	
	 * @return String
	 */
	public String toString() {
		return "Location[" +longitude+", "+countryId+", "+city+", "+country+", "+city_Id+", "+latitude+"]";
	}
	
	/**
	 * Internal constructor to create a Location from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Location(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // longitude
            this.longitude = ((Number)json_data.get("longitude")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field longitude was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field longitude had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // country id
            this.countryId = ((Number)json_data.get("country id")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field countryId was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field countryId had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // city
            this.city = (String)json_data.get("city");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field city was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field city had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // country
            this.country = (String)json_data.get("country");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field country was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field country had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // city_id
            this.city_Id = ((Number)json_data.get("city_id")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field city_Id was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field city_Id had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // latitude
            this.latitude = ((Number)json_data.get("latitude")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field latitude was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field latitude had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}