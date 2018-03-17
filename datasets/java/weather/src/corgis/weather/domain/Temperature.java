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
	
    // The lowest recorded temperature on this week, in degrees Farenheit.
    private Integer minTemp;
    // The highest recorded temperature on this week, in degrees Farenheit.
    private Integer maxTemp;
    // The average recorded temperature on this week, in degrees Farenheit.
    private Integer avgTemp;
    
    
    /**
     * The lowest recorded temperature on this week, in degrees Farenheit.
     * @return Integer
     */
    public Integer getMinTemp() {
        return this.minTemp;
    }
    
    
    
    /**
     * The highest recorded temperature on this week, in degrees Farenheit.
     * @return Integer
     */
    public Integer getMaxTemp() {
        return this.maxTemp;
    }
    
    
    
    /**
     * The average recorded temperature on this week, in degrees Farenheit.
     * @return Integer
     */
    public Integer getAvgTemp() {
        return this.avgTemp;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Temperature.
	
	 * @return String
	 */
	public String toString() {
		return "Temperature[" +minTemp+", "+maxTemp+", "+avgTemp+"]";
	}
	
	/**
	 * Internal constructor to create a Temperature from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Temperature(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Min Temp
            this.minTemp = ((Number)json_data.get("Min Temp")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Temperature; the field minTemp was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Temperature; the field minTemp had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Max Temp
            this.maxTemp = ((Number)json_data.get("Max Temp")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Temperature; the field maxTemp was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Temperature; the field maxTemp had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Avg Temp
            this.avgTemp = ((Number)json_data.get("Avg Temp")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Temperature; the field avgTemp was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Temperature; the field avgTemp had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}