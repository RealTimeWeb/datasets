package corgis.johnsongrass.domain;

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
public class Weather {
	
    private Integer precipitation;
    private Double temperature;
    
    
    /*
     * @return 
     */
    public Integer getPrecipitation() {
        return this.precipitation;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTemperature() {
        return this.temperature;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Weather.
	
	 * @return String
	 */
	public String toString() {
		return "Weather[" +precipitation+", "+temperature+"]";
	}
	
	/**
	 * Internal constructor to create a Weather from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Weather(JSONObject json_data) {
        try {// precipitation
            this.precipitation = new Integer(((Long)json_data.get("precipitation")).intValue());// temperature
            this.temperature = (Double)json_data.get("temperature");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Weather; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Weather; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}