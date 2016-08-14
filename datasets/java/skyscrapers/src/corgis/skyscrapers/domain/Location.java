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
	
    private String city;
    private Integer city_Id;
    private String country;
    private Integer countryId;
    private Integer longitude;
    private Integer latitude;
    
    
    /*
     * @return 
     */
    public String getCity() {
        return this.city;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCity_Id() {
        return this.city_Id;
    }
    
    
    
    /*
     * @return 
     */
    public String getCountry() {
        return this.country;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCountryId() {
        return this.countryId;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongitude() {
        return this.longitude;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLatitude() {
        return this.latitude;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Location.
	
	 * @return String
	 */
	public String toString() {
		return "Location[" +city+", "+city_Id+", "+country+", "+countryId+", "+longitude+", "+latitude+"]";
	}
	
	/**
	 * Internal constructor to create a Location from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Location(JSONObject json_data) {
        try {// city
            this.city = (String)json_data.get("city");// city_id
            this.city_Id = new Integer(((Long)json_data.get("city_id")).intValue());// country
            this.country = (String)json_data.get("country");// country id
            this.countryId = new Integer(((Long)json_data.get("country id")).intValue());// longitude
            this.longitude = new Integer(((Long)json_data.get("longitude")).intValue());// latitude
            this.latitude = new Integer(((Long)json_data.get("latitude")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}