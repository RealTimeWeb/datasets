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
	
    private Integer cancelled;
    private Integer onTime;
    private Integer total;
    private Integer delayed;
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
        try {// cancelled
            this.cancelled = new Integer(((Long)json_data.get("cancelled")).intValue());// on time
            this.onTime = new Integer(((Long)json_data.get("on time")).intValue());// total
            this.total = new Integer(((Long)json_data.get("total")).intValue());// delayed
            this.delayed = new Integer(((Long)json_data.get("delayed")).intValue());// diverted
            this.diverted = new Integer(((Long)json_data.get("diverted")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Flights; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Flights; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}