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
	
    // The miles-per-gallon this car gets on average in cities.
    private Integer cityMpg;
    // The miles-per-gallon this car gets on average on highways.
    private Integer highwayMpg;
    // Whether this car takes "Gasoline", "Diesel fuel", "Electricity", "Compressed natural gas", or "E85" (a term that refers to high-level ethanol-gasoline blends containing 51%-83% ethanol). If it is unknown, it is left blank.
    private String fuelType;
    
    
    /**
     * The miles-per-gallon this car gets on average in cities.
     * @return Integer
     */
    public Integer getCityMpg() {
        return this.cityMpg;
    }
    
    
    
    /**
     * The miles-per-gallon this car gets on average on highways.
     * @return Integer
     */
    public Integer getHighwayMpg() {
        return this.highwayMpg;
    }
    
    
    
    /**
     * Whether this car takes "Gasoline", "Diesel fuel", "Electricity", "Compressed natural gas", or "E85" (a term that refers to high-level ethanol-gasoline blends containing 51%-83% ethanol). If it is unknown, it is left blank.
     * @return String
     */
    public String getFuelType() {
        return this.fuelType;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this FuelInformation.
	
	 * @return String
	 */
	public String toString() {
		return "FuelInformation[" +cityMpg+", "+highwayMpg+", "+fuelType+"]";
	}
	
	/**
	 * Internal constructor to create a FuelInformation from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public FuelInformation(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // City mpg
            this.cityMpg = ((Number)json_data.get("City mpg")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FuelInformation; the field cityMpg was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FuelInformation; the field cityMpg had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Highway mpg
            this.highwayMpg = ((Number)json_data.get("Highway mpg")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FuelInformation; the field highwayMpg was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FuelInformation; the field highwayMpg had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Fuel Type
            this.fuelType = (String)json_data.get("Fuel Type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FuelInformation; the field fuelType was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FuelInformation; the field fuelType had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}