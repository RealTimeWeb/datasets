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
	
    // Inches
    private Double precipitation;
    // Degrees Farenheit
    private Temperature temperature;
    private Wind wind;
    
    
    /*
     * @return 
     */
    public Double getPrecipitation() {
        return this.precipitation;
    }
    
    
    
    /*
     * @return 
     */
    public Temperature getTemperature() {
        return this.temperature;
    }
    
    
    
    /*
     * @return 
     */
    public Wind getWind() {
        return this.wind;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +precipitation+", "+temperature+", "+wind+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// Precipitation
            this.precipitation = (Double)json_data.get("Precipitation");// Temperature
            this.temperature = new Temperature((JSONObject)json_data.get("Temperature"));// Wind
            this.wind = new Wind((JSONObject)json_data.get("Wind"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}