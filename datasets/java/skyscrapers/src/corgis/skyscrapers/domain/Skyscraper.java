package corgis.skyscrapers.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.skyscrapers.domain.Status;
import corgis.skyscrapers.domain.Statistics;
import corgis.skyscrapers.domain.Purposes;
import corgis.skyscrapers.domain.Location;

/**
 * 
 */
public class Skyscraper {
	
    private Status status;
    private Statistics statistics;
    private String name;
    private String material;
    private Purposes purposes;
    private Location location;
    private Integer id;
    
    
    /*
     * @return 
     */
    public Status getStatus() {
        return this.status;
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
    public String getName() {
        return this.name;
    }
    
    
    
    /*
     * @return 
     */
    public String getMaterial() {
        return this.material;
    }
    
    
    
    /*
     * @return 
     */
    public Purposes getPurposes() {
        return this.purposes;
    }
    
    
    
    /*
     * @return 
     */
    public Location getLocation() {
        return this.location;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Skyscraper.
	
	 * @return String
	 */
	public String toString() {
		return "Skyscraper[" +status+", "+statistics+", "+name+", "+material+", "+purposes+", "+location+", "+id+"]";
	}
	
	/**
	 * Internal constructor to create a Skyscraper from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Skyscraper(JSONObject json_data) {
        try {// status
            this.status = new Status((JSONObject)json_data.get("status"));// statistics
            this.statistics = new Statistics((JSONObject)json_data.get("statistics"));// name
            this.name = (String)json_data.get("name");// material
            this.material = (String)json_data.get("material");// purposes
            this.purposes = new Purposes((JSONObject)json_data.get("purposes"));// location
            this.location = new Location((JSONObject)json_data.get("location"));// id
            this.id = new Integer(((Long)json_data.get("id")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Skyscraper; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Skyscraper; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}