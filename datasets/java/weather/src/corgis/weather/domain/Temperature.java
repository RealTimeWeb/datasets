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
	
    // The average recorded temperature on this week, in degrees Farenheit.
    private Integer average;
    // The lowest recorded temperature on this week, in degrees Farenheit.
    private Integer minimum;
    // The highest recorded temperature on this week, in degrees Farenheit.
    private Integer maximum;
    
    
    /*
     * @return 
     */
    public Integer getAverage() {
        return this.average;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMinimum() {
        return this.minimum;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMaximum() {
        return this.maximum;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Temperature.
	
	 * @return String
	 */
	public String toString() {
		return "Temperature[" +average+", "+minimum+", "+maximum+"]";
	}
	
	/**
	 * Internal constructor to create a Temperature from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Temperature(JSONObject json_data) {
        System.out.println(json_data);
        try {// Average
            this.average = ((Number)json_data.get("Average")).intValue();// Minimum
            this.minimum = ((Number)json_data.get("Minimum")).intValue();// Maximum
            this.maximum = ((Number)json_data.get("Maximum")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Temperature; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Temperature; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}