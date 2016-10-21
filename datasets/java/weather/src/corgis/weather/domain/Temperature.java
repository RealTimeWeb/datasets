package corgis.weather.domain;

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
public class Temperature {
	
    private Double maxTemp;
    private Double avgTemp;
    private Double minTemp;
    
    
    /*
     * @return 
     */
    public Double getMaxTemp() {
        return this.maxTemp;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAvgTemp() {
        return this.avgTemp;
    }
    
    
    
    /*
     * @return 
     */
    public Double getMinTemp() {
        return this.minTemp;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Temperature.
	
	 * @return String
	 */
	public String toString() {
		return "Temperature[" +maxTemp+", "+avgTemp+", "+minTemp+"]";
	}
	
	/**
	 * Internal constructor to create a Temperature from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Temperature(JSONObject json_data) {
        try {// Max Temp
            this.maxTemp = ((Number)json_data.get("Max Temp")).doubleValue();// Avg Temp
            this.avgTemp = ((Number)json_data.get("Avg Temp")).doubleValue();// Min Temp
            this.minTemp = ((Number)json_data.get("Min Temp")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Temperature; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Temperature; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}