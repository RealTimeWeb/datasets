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
	
    // The average wind direction for that week, in degrees.
    private Integer direction;
    // The average windspeed for that week, in Miles per Hour.
    private Double speed;
    
    
    /*
     * @return 
     */
    public Integer getDirection() {
        return this.direction;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSpeed() {
        return this.speed;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Wind.
	
	 * @return String
	 */
	public String toString() {
		return "Wind[" +direction+", "+speed+"]";
	}
	
	/**
	 * Internal constructor to create a Wind from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Wind(JSONObject json_data) {
        System.out.println(json_data);
        try {// Direction
            this.direction = ((Number)json_data.get("Direction")).intValue();// Speed
            this.speed = ((Number)json_data.get("Speed")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Wind; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Wind; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}