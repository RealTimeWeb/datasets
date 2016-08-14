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
public class MinutesDelayed {
	
    private Integer lateAircraft;
    private Integer weather;
    private Integer carrier;
    private Integer security;
    private Integer total;
    private Integer nationalAviationSystem;
    
    
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
    public Integer getCarrier() {
        return this.carrier;
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
    public Integer getTotal() {
        return this.total;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNationalAviationSystem() {
        return this.nationalAviationSystem;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this MinutesDelayed.
	
	 * @return String
	 */
	public String toString() {
		return "MinutesDelayed[" +lateAircraft+", "+weather+", "+carrier+", "+security+", "+total+", "+nationalAviationSystem+"]";
	}
	
	/**
	 * Internal constructor to create a MinutesDelayed from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public MinutesDelayed(JSONObject json_data) {
        try {// late aircraft
            this.lateAircraft = new Integer(((Long)json_data.get("late aircraft")).intValue());// weather
            this.weather = new Integer(((Long)json_data.get("weather")).intValue());// carrier
            this.carrier = new Integer(((Long)json_data.get("carrier")).intValue());// security
            this.security = new Integer(((Long)json_data.get("security")).intValue());// total
            this.total = new Integer(((Long)json_data.get("total")).intValue());// national aviation system
            this.nationalAviationSystem = new Integer(((Long)json_data.get("national aviation system")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MinutesDelayed; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MinutesDelayed; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}