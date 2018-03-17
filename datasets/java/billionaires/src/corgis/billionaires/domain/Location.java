package corgis.billionaires.domain;

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
	
    // The name of the country that this billionaire has citizenship with.
    private String citizenship;
    // the 3-letter country code of the country where this billionaire has citizenship.
    private String countryCode;
    // The "Gross Domestic Product" of the country where the billionaire has citizenship. This is one of the primary indicators used to gauge the health of a country's economy. It represents the total dollar value of all goods and services produced over a specific time period; you can think of it as the size of the economy.
    private Double gdp;
    // The region of the world where this billionaire lives.
    private String region;
    
    
    /**
     * The name of the country that this billionaire has citizenship with.
     * @return String
     */
    public String getCitizenship() {
        return this.citizenship;
    }
    
    
    
    /**
     * the 3-letter country code of the country where this billionaire has citizenship.
     * @return String
     */
    public String getCountryCode() {
        return this.countryCode;
    }
    
    
    
    /**
     * The "Gross Domestic Product" of the country where the billionaire has citizenship. This is one of the primary indicators used to gauge the health of a country's economy. It represents the total dollar value of all goods and services produced over a specific time period; you can think of it as the size of the economy.
     * @return Double
     */
    public Double getGdp() {
        return this.gdp;
    }
    
    
    
    /**
     * The region of the world where this billionaire lives.
     * @return String
     */
    public String getRegion() {
        return this.region;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Location.
	
	 * @return String
	 */
	public String toString() {
		return "Location[" +citizenship+", "+countryCode+", "+gdp+", "+region+"]";
	}
	
	/**
	 * Internal constructor to create a Location from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Location(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // citizenship
            this.citizenship = (String)json_data.get("citizenship");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field citizenship was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field citizenship had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // country code
            this.countryCode = (String)json_data.get("country code");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field countryCode was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field countryCode had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // gdp
            this.gdp = ((Number)json_data.get("gdp")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field gdp was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field gdp had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // region
            this.region = (String)json_data.get("region");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field region was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field region had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}