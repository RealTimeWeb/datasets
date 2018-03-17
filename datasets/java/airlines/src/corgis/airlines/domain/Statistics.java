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
import corgis.airlines.domain.Carriers;
import corgis.airlines.domain.MinutesDelayed;

/**
 * 
 */
public class Statistics {
	
    private Flights flights;
    private NumberOfDelays numberOfDelays;
    private Carriers carriers;
    private MinutesDelayed minutesDelayed;
    
    
    /**
     * 
     * @return Flights
     */
    public Flights getFlights() {
        return this.flights;
    }
    
    
    
    /**
     * 
     * @return NumberOfDelays
     */
    public NumberOfDelays getNumberOfDelays() {
        return this.numberOfDelays;
    }
    
    
    
    /**
     * 
     * @return Carriers
     */
    public Carriers getCarriers() {
        return this.carriers;
    }
    
    
    
    /**
     * 
     * @return MinutesDelayed
     */
    public MinutesDelayed getMinutesDelayed() {
        return this.minutesDelayed;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Statistics.
	
	 * @return String
	 */
	public String toString() {
		return "Statistics[" +flights+", "+numberOfDelays+", "+carriers+", "+minutesDelayed+"]";
	}
	
	/**
	 * Internal constructor to create a Statistics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Statistics(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Flights
            this.flights = new Flights((JSONObject)json_data.get("Flights"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field flights was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field flights had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // # of Delays
            this.numberOfDelays = new NumberOfDelays((JSONObject)json_data.get("# of Delays"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field numberOfDelays was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field numberOfDelays had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Carriers
            this.carriers = new Carriers((JSONObject)json_data.get("Carriers"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field carriers was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field carriers had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Minutes Delayed
            this.minutesDelayed = new MinutesDelayed((JSONObject)json_data.get("Minutes Delayed"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field minutesDelayed was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field minutesDelayed had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}