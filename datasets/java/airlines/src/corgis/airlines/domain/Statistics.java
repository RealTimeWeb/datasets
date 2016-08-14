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

/**
 * 
 */
public class Statistics {
	
    private Flights flights;
    private NumberOfDelays numberOfDelays;
    private MinutesDelayed minutesDelayed;
    
    
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
    
    
    
	
	/**
	 * Creates a string based representation of this Statistics.
	
	 * @return String
	 */
	public String toString() {
		return "Statistics[" +flights+", "+numberOfDelays+", "+minutesDelayed+"]";
	}
	
	/**
	 * Internal constructor to create a Statistics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Statistics(JSONObject json_data) {
        try {// flights
            this.flights = new Flights((JSONObject)json_data.get("flights"));// # of delays
            this.numberOfDelays = new NumberOfDelays((JSONObject)json_data.get("# of delays"));// minutes delayed
            this.minutesDelayed = new MinutesDelayed((JSONObject)json_data.get("minutes delayed"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}