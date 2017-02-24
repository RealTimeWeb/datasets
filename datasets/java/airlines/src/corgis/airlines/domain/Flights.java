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
public class Flights {
	
    // The number of flights that were cancelled in this month.
    private Integer cancelled;
    // The number of flights that were on time in this month.
    private Integer onTime;
    // The total number of flights in this month.
    private Integer total;
    // The number of flights that were delayed in this month.
    private Integer delayed;
    // The number of flights that were diverted in this month.
    private Integer diverted;
    
    
    /*
     * @return 
     */
    public Integer getCancelled() {
        return this.cancelled;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getOnTime() {
        return this.onTime;
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
    public Integer getDelayed() {
        return this.delayed;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getDiverted() {
        return this.diverted;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Flights.
	
	 * @return String
	 */
	public String toString() {
		return "Flights[" +cancelled+", "+onTime+", "+total+", "+delayed+", "+diverted+"]";
	}
	
	/**
	 * Internal constructor to create a Flights from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Flights(JSONObject json_data) {
        try {// Cancelled
            this.cancelled = ((Number)json_data.get("Cancelled")).intValue();// On Time
            this.onTime = ((Number)json_data.get("On Time")).intValue();// Total
            this.total = ((Number)json_data.get("Total")).intValue();// Delayed
            this.delayed = ((Number)json_data.get("Delayed")).intValue();// Diverted
            this.diverted = ((Number)json_data.get("Diverted")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Flights; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Flights; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}