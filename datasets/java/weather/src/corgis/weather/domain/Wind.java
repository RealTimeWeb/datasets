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
public class Wind {
	
    // The average windspeed for that week, in Miles per Hour.
    private Double speed;
    // The average wind direction for that week, in degrees.
    private Integer direction;
    
    
    /**
     * The average windspeed for that week, in Miles per Hour.
     * @return Double
     */
    public Double getSpeed() {
        return this.speed;
    }
    
    
    
    /**
     * The average wind direction for that week, in degrees.
     * @return Integer
     */
    public Integer getDirection() {
        return this.direction;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Wind.
	
	 * @return String
	 */
	public String toString() {
		return "Wind[" +speed+", "+direction+"]";
	}
	
	/**
	 * Internal constructor to create a Wind from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Wind(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Speed
            this.speed = ((Number)json_data.get("Speed")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Wind; the field speed was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Wind; the field speed had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Direction
            this.direction = ((Number)json_data.get("Direction")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Wind; the field direction was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Wind; the field direction had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}