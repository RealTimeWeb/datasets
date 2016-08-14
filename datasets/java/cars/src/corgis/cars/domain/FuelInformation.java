package corgis.cars.domain;

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
public class FuelInformation {
	
    private Integer highwayMpg;
    private Integer cityMph;
    private String fuelType;
    
    
    /*
     * @return 
     */
    public Integer getHighwayMpg() {
        return this.highwayMpg;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCityMph() {
        return this.cityMph;
    }
    
    
    
    /*
     * @return 
     */
    public String getFuelType() {
        return this.fuelType;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this FuelInformation.
	
	 * @return String
	 */
	public String toString() {
		return "FuelInformation[" +highwayMpg+", "+cityMph+", "+fuelType+"]";
	}
	
	/**
	 * Internal constructor to create a FuelInformation from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public FuelInformation(JSONObject json_data) {
        try {// Highway mpg
            this.highwayMpg = new Integer(((Long)json_data.get("Highway mpg")).intValue());// City mph
            this.cityMph = new Integer(((Long)json_data.get("City mph")).intValue());// Fuel Type
            this.fuelType = (String)json_data.get("Fuel Type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FuelInformation; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FuelInformation; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}