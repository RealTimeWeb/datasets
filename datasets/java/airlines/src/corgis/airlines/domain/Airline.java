package corgis.airlines.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.airlines.domain.Airport;
import corgis.airlines.domain.Statistics;
import corgis.airlines.domain.Time;
import corgis.airlines.domain.Carrier;

/**
 * 
 */
public class Airline {
	
    private Airport airport;
    private Statistics statistics;
    private Time time;
    private Carrier carrier;
    
    
    /*
     * @return 
     */
    public Airport getAirport() {
        return this.airport;
    }
    
    
    
    /*
     * @return 
     */
    public Statistics getStatistics() {
        return this.statistics;
    }
    
    
    
    /*
     * @return 
     */
    public Time getTime() {
        return this.time;
    }
    
    
    
    /*
     * @return 
     */
    public Carrier getCarrier() {
        return this.carrier;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Airline.
	
	 * @return String
	 */
	public String toString() {
		return "Airline[" +airport+", "+statistics+", "+time+", "+carrier+"]";
	}
	
	/**
	 * Internal constructor to create a Airline from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Airline(JSONObject json_data) {
        try {// airport
            this.airport = new Airport((JSONObject)json_data.get("airport"));// statistics
            this.statistics = new Statistics((JSONObject)json_data.get("statistics"));// time
            this.time = new Time((JSONObject)json_data.get("time"));// carrier
            this.carrier = new Carrier((JSONObject)json_data.get("carrier"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Airline; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Airline; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}