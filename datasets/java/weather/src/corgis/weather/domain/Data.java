package corgis.weather.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.weather.domain.Temperature;
import corgis.weather.domain.Wind;

/**
 * 
 */
public class Data {
	
    private Temperature temperature;
    // The average amount of rain, in inches.
    private Double precipitation;
    private Wind wind;
    
    
    /**
     * 
     * @return Temperature
     */
    public Temperature getTemperature() {
        return this.temperature;
    }
    
    
    
    /**
     * The average amount of rain, in inches.
     * @return Double
     */
    public Double getPrecipitation() {
        return this.precipitation;
    }
    
    
    
    /**
     * 
     * @return Wind
     */
    public Wind getWind() {
        return this.wind;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +temperature+", "+precipitation+", "+wind+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Temperature
            this.temperature = new Temperature((JSONObject)json_data.get("Temperature"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field temperature was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field temperature had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Precipitation
            this.precipitation = ((Number)json_data.get("Precipitation")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field precipitation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field precipitation had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Wind
            this.wind = new Wind((JSONObject)json_data.get("Wind"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field wind was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field wind had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}