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
	
    // The number of flights that were on time in this month.
    private Integer onTime;
    // The number of flights that were delayed in this month.
    private Integer delayed;
    // The number of flights that were diverted in this month.
    private Integer diverted;
    // The total number of flights in this month.
    private Integer total;
    // The number of flights that were cancelled in this month.
    private Integer cancelled;
    
    
    /**
     * The number of flights that were on time in this month.
     * @return Integer
     */
    public Integer getOnTime() {
        return this.onTime;
    }
    
    
    
    /**
     * The number of flights that were delayed in this month.
     * @return Integer
     */
    public Integer getDelayed() {
        return this.delayed;
    }
    
    
    
    /**
     * The number of flights that were diverted in this month.
     * @return Integer
     */
    public Integer getDiverted() {
        return this.diverted;
    }
    
    
    
    /**
     * The total number of flights in this month.
     * @return Integer
     */
    public Integer getTotal() {
        return this.total;
    }
    
    
    
    /**
     * The number of flights that were cancelled in this month.
     * @return Integer
     */
    public Integer getCancelled() {
        return this.cancelled;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Flights.
	
	 * @return String
	 */
	public String toString() {
		return "Flights[" +onTime+", "+delayed+", "+diverted+", "+total+", "+cancelled+"]";
	}
	
	/**
	 * Internal constructor to create a Flights from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Flights(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // On Time
            this.onTime = ((Number)json_data.get("On Time")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Flights; the field onTime was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Flights; the field onTime had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Delayed
            this.delayed = ((Number)json_data.get("Delayed")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Flights; the field delayed was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Flights; the field delayed had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Diverted
            this.diverted = ((Number)json_data.get("Diverted")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Flights; the field diverted was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Flights; the field diverted had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Total
            this.total = ((Number)json_data.get("Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Flights; the field total was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Flights; the field total had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Cancelled
            this.cancelled = ((Number)json_data.get("Cancelled")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Flights; the field cancelled was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Flights; the field cancelled had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}