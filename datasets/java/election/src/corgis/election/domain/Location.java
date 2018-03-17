package corgis.election.domain;

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
public class Location {
	
    private String county;
    private String stateAbbreviation;
    private String state;
    
    
    /**
     * 
     * @return String
     */
    public String getCounty() {
        return this.county;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getStateAbbreviation() {
        return this.stateAbbreviation;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getState() {
        return this.state;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Location.
	
	 * @return String
	 */
	public String toString() {
		return "Location[" +county+", "+stateAbbreviation+", "+state+"]";
	}
	
	/**
	 * Internal constructor to create a Location from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Location(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // County
            this.county = (String)json_data.get("County");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field county was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field county had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // State Abbreviation
            this.stateAbbreviation = (String)json_data.get("State Abbreviation");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field stateAbbreviation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field stateAbbreviation had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // State
            this.state = (String)json_data.get("State");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field state was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field state had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}