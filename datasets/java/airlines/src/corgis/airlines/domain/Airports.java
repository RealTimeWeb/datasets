package corgis.airlines.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.airlines.domain.Time;
import corgis.airlines.domain.Statistics;
import corgis.airlines.domain.Airport;

/**
 * 
 */
public class Airports {
	
    private Time time;
    private Statistics statistics;
    private Airport airport;
    
    
    /**
     * 
     * @return Time
     */
    public Time getTime() {
        return this.time;
    }
    
    
    
    /**
     * 
     * @return Statistics
     */
    public Statistics getStatistics() {
        return this.statistics;
    }
    
    
    
    /**
     * 
     * @return Airport
     */
    public Airport getAirport() {
        return this.airport;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Airports.
	
	 * @return String
	 */
	public String toString() {
		return "Airports[" +time+", "+statistics+", "+airport+"]";
	}
	
	/**
	 * Internal constructor to create a Airports from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Airports(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Time
            this.time = new Time((JSONObject)json_data.get("Time"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Airports; the field time was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Airports; the field time had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Statistics
            this.statistics = new Statistics((JSONObject)json_data.get("Statistics"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Airports; the field statistics was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Airports; the field statistics had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Airport
            this.airport = new Airport((JSONObject)json_data.get("Airport"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Airports; the field airport was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Airports; the field airport had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}