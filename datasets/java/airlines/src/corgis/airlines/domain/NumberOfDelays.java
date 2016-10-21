package corgis.airlines.domain;

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
public class NumberOfDelays {
	
    private Integer lateAircraft;
    private Integer weather;
    private Integer security;
    private Integer nationalAviationSystem;
    private Integer carrier;
    
    
    /*
     * @return 
     */
    public Integer getLateAircraft() {
        return this.lateAircraft;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWeather() {
        return this.weather;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSecurity() {
        return this.security;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNationalAviationSystem() {
        return this.nationalAviationSystem;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCarrier() {
        return this.carrier;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this #OfDelays.
	
	 * @return String
	 */
	public String toString() {
		return "#OfDelays[" +lateAircraft+", "+weather+", "+security+", "+nationalAviationSystem+", "+carrier+"]";
	}
	
	/**
	 * Internal constructor to create a #OfDelays from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public NumberOfDelays(JSONObject json_data) {
        try {// late aircraft
            this.lateAircraft = ((Number)json_data.get("late aircraft")).intValue();// weather
            this.weather = ((Number)json_data.get("weather")).intValue();// security
            this.security = ((Number)json_data.get("security")).intValue();// national aviation system
            this.nationalAviationSystem = ((Number)json_data.get("national aviation system")).intValue();// carrier
            this.carrier = ((Number)json_data.get("carrier")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a #OfDelays; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a #OfDelays; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}