package corgis.airlines.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.airlines.domain.Flights;
import corgis.airlines.domain.NumberOfDelays;
import corgis.airlines.domain.MinutesDelayed;
import corgis.airlines.domain.Carriers;

/**
 * 
 */
public class Statistics {
	
    private Flights flights;
    private NumberOfDelays numberOfDelays;
    private MinutesDelayed minutesDelayed;
    private Carriers carriers;
    
    
    /*
     * @return 
     */
    public Flights getFlights() {
        return this.flights;
    }
    
    
    
    /*
     * @return 
     */
    public NumberOfDelays getNumberOfDelays() {
        return this.numberOfDelays;
    }
    
    
    
    /*
     * @return 
     */
    public MinutesDelayed getMinutesDelayed() {
        return this.minutesDelayed;
    }
    
    
    
    /*
     * @return 
     */
    public Carriers getCarriers() {
        return this.carriers;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Statistics.
	
	 * @return String
	 */
	public String toString() {
		return "Statistics[" +flights+", "+numberOfDelays+", "+minutesDelayed+", "+carriers+"]";
	}
	
	/**
	 * Internal constructor to create a Statistics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Statistics(JSONObject json_data) {
        try {// Flights
            this.flights = new Flights((JSONObject)json_data.get("Flights"));// # of Delays
            this.numberOfDelays = new NumberOfDelays((JSONObject)json_data.get("# of Delays"));// Minutes Delayed
            this.minutesDelayed = new MinutesDelayed((JSONObject)json_data.get("Minutes Delayed"));// Carriers
            this.carriers = new Carriers((JSONObject)json_data.get("Carriers"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}