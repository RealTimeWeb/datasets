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
	
    // The number of delays and cancellations caused by a previous flight with the same aircraft arriving late, causing the present flight to depart late in this month.
    private Integer lateAircraft;
    // Number of delays or cancellations caused by significant meteorological conditions (actual or forecasted) that, in the judgment of the carrier, delays or prevents the operation of a flight such as tornado, blizzard or hurricane in this month.
    private Integer weather;
    // The number of delays and cancellations attributable to the national aviation system that refer to a broad set of conditions, such as non-extreme weather conditions, airport operations, heavy traffic volume, and air traffic control in this month.
    private Integer nationalAviationSystem;
    // The number of delays and cancellations due to circumstances within the airline's control (e.g. maintenance or crew problems, aircraft cleaning, baggage loading, fueling, etc.) in this month.
    private Integer carrier;
    // Number of delays or cancellations caused by evacuation of a terminal or concourse, re-boarding of aircraft because of security breach, inoperative screening equipment and/or long lines in excess of 29 minutes at screening areas in this month.
    private Integer security;
    
    
    /**
     * The number of delays and cancellations caused by a previous flight with the same aircraft arriving late, causing the present flight to depart late in this month.
     * @return Integer
     */
    public Integer getLateAircraft() {
        return this.lateAircraft;
    }
    
    
    
    /**
     * Number of delays or cancellations caused by significant meteorological conditions (actual or forecasted) that, in the judgment of the carrier, delays or prevents the operation of a flight such as tornado, blizzard or hurricane in this month.
     * @return Integer
     */
    public Integer getWeather() {
        return this.weather;
    }
    
    
    
    /**
     * The number of delays and cancellations attributable to the national aviation system that refer to a broad set of conditions, such as non-extreme weather conditions, airport operations, heavy traffic volume, and air traffic control in this month.
     * @return Integer
     */
    public Integer getNationalAviationSystem() {
        return this.nationalAviationSystem;
    }
    
    
    
    /**
     * The number of delays and cancellations due to circumstances within the airline's control (e.g. maintenance or crew problems, aircraft cleaning, baggage loading, fueling, etc.) in this month.
     * @return Integer
     */
    public Integer getCarrier() {
        return this.carrier;
    }
    
    
    
    /**
     * Number of delays or cancellations caused by evacuation of a terminal or concourse, re-boarding of aircraft because of security breach, inoperative screening equipment and/or long lines in excess of 29 minutes at screening areas in this month.
     * @return Integer
     */
    public Integer getSecurity() {
        return this.security;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this #OfDelays.
	
	 * @return String
	 */
	public String toString() {
		return "#OfDelays[" +lateAircraft+", "+weather+", "+nationalAviationSystem+", "+carrier+", "+security+"]";
	}
	
	/**
	 * Internal constructor to create a #OfDelays from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public NumberOfDelays(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Late Aircraft
            this.lateAircraft = ((Number)json_data.get("Late Aircraft")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a #OfDelays; the field lateAircraft was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a #OfDelays; the field lateAircraft had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Weather
            this.weather = ((Number)json_data.get("Weather")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a #OfDelays; the field weather was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a #OfDelays; the field weather had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // National Aviation System
            this.nationalAviationSystem = ((Number)json_data.get("National Aviation System")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a #OfDelays; the field nationalAviationSystem was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a #OfDelays; the field nationalAviationSystem had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Carrier
            this.carrier = ((Number)json_data.get("Carrier")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a #OfDelays; the field carrier was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a #OfDelays; the field carrier had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Security
            this.security = ((Number)json_data.get("Security")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a #OfDelays; the field security was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a #OfDelays; the field security had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}