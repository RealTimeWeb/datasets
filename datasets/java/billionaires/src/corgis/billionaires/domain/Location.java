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
	
    private Double gdp;
    private String region;
    private String citizenship;
    private String countryCode;
    
    
    /*
     * @return 
     */
    public Double getGdp() {
        return this.gdp;
    }
    
    
    
    /*
     * @return 
     */
    public String getRegion() {
        return this.region;
    }
    
    
    
    /*
     * @return 
     */
    public String getCitizenship() {
        return this.citizenship;
    }
    
    
    
    /*
     * @return 
     */
    public String getCountryCode() {
        return this.countryCode;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Location.
	
	 * @return String
	 */
	public String toString() {
		return "Location[" +gdp+", "+region+", "+citizenship+", "+countryCode+"]";
	}
	
	/**
	 * Internal constructor to create a Location from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Location(JSONObject json_data) {
        try {// gdp
            this.gdp = ((Number)json_data.get("gdp")).doubleValue();// region
            this.region = (String)json_data.get("region");// citizenship
            this.citizenship = (String)json_data.get("citizenship");// country code
            this.countryCode = (String)json_data.get("country code");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}