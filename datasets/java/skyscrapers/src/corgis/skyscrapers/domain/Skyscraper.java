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
import corgis.skyscrapers.domain.Purposes;
import corgis.skyscrapers.domain.Statistics;
import corgis.skyscrapers.domain.Location;

/**
 * 
 */
public class Skyscraper {
	
    private Status status;
    private Purposes purposes;
    private Integer id;
    private Statistics statistics;
    private String name;
    private Location location;
    private String material;
    
    
    /**
     * 
     * @return Status
     */
    public Status getStatus() {
        return this.status;
    }
    
    
    
    /**
     * 
     * @return Purposes
     */
    public Purposes getPurposes() {
        return this.purposes;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getId() {
        return this.id;
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
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /**
     * 
     * @return Location
     */
    public Location getLocation() {
        return this.location;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getMaterial() {
        return this.material;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Skyscraper.
	
	 * @return String
	 */
	public String toString() {
		return "Skyscraper[" +status+", "+purposes+", "+id+", "+statistics+", "+name+", "+location+", "+material+"]";
	}
	
	/**
	 * Internal constructor to create a Skyscraper from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Skyscraper(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // status
            this.status = new Status((JSONObject)json_data.get("status"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Skyscraper; the field status was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Skyscraper; the field status had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // purposes
            this.purposes = new Purposes((JSONObject)json_data.get("purposes"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Skyscraper; the field purposes was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Skyscraper; the field purposes had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // id
            this.id = ((Number)json_data.get("id")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Skyscraper; the field id was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Skyscraper; the field id had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // statistics
            this.statistics = new Statistics((JSONObject)json_data.get("statistics"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Skyscraper; the field statistics was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Skyscraper; the field statistics had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Skyscraper; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Skyscraper; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // location
            this.location = new Location((JSONObject)json_data.get("location"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Skyscraper; the field location was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Skyscraper; the field location had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // material
            this.material = (String)json_data.get("material");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Skyscraper; the field material was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Skyscraper; the field material had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}