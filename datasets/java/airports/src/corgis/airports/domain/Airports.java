package corgis.airports.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.airports.domain.Facility;

/**
 * 
 */
public class Airports {
	
    private ArrayList<Runways> runways;
    private ArrayList<Schedules> schedules;
    private String sitenumber;
    private Facility facility;
    
    
    /*
     * @return 
     */
    public ArrayList<Runways> getRunways() {
        return this.runways;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<Schedules> getSchedules() {
        return this.schedules;
    }
    
    
    
    /*
     * @return 
     */
    public String getSitenumber() {
        return this.sitenumber;
    }
    
    
    
    /*
     * @return 
     */
    public Facility getFacility() {
        return this.facility;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Airports.
	
	 * @return String
	 */
	public String toString() {
		return "Airports[" +runways+", "+schedules+", "+sitenumber+", "+facility+"]";
	}
	
	/**
	 * Internal constructor to create a Airports from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Airports(JSONObject json_data) {
        try {// Runways
            this.runways = new ArrayList<Runways>();
            Iterator<Object> runwaysIter = ((List<Object>)json_data.get("Runways")).iterator();
            while (runwaysIter.hasNext()) {
                this.runways.add(new Runways((JSONObject)runwaysIter.next()));
            }// Schedules
            this.schedules = new ArrayList<Schedules>();
            Iterator<Object> schedulesIter = ((List<Object>)json_data.get("Schedules")).iterator();
            while (schedulesIter.hasNext()) {
                this.schedules.add(new Schedules((JSONObject)schedulesIter.next()));
            }// SiteNumber
            this.sitenumber = (String)json_data.get("SiteNumber");// Facility
            this.facility = new Facility((JSONObject)json_data.get("Facility"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Airports; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Airports; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}