package corgis.graduates.domain;

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
public class Degrees {
	
    // The estimated number of professional degrees awarded in this for major during this year.
    private Integer professionals;
    // The estimated number of doctoral degrees awarded in this for major during this year.
    private Integer doctorates;
    // The estimated number of Masters awarded in this for major during this year.
    private Integer masters;
    // The estimated number of bachelor degrees awarded in this for major during this year.
    private Integer bachelors;
    
    
    /**
     * The estimated number of professional degrees awarded in this for major during this year.
     * @return Integer
     */
    public Integer getProfessionals() {
        return this.professionals;
    }
    
    
    
    /**
     * The estimated number of doctoral degrees awarded in this for major during this year.
     * @return Integer
     */
    public Integer getDoctorates() {
        return this.doctorates;
    }
    
    
    
    /**
     * The estimated number of Masters awarded in this for major during this year.
     * @return Integer
     */
    public Integer getMasters() {
        return this.masters;
    }
    
    
    
    /**
     * The estimated number of bachelor degrees awarded in this for major during this year.
     * @return Integer
     */
    public Integer getBachelors() {
        return this.bachelors;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Degrees.
	
	 * @return String
	 */
	public String toString() {
		return "Degrees[" +professionals+", "+doctorates+", "+masters+", "+bachelors+"]";
	}
	
	/**
	 * Internal constructor to create a Degrees from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Degrees(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Professionals
            this.professionals = ((Number)json_data.get("Professionals")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Degrees; the field professionals was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Degrees; the field professionals had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Doctorates
            this.doctorates = ((Number)json_data.get("Doctorates")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Degrees; the field doctorates was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Degrees; the field doctorates had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Masters
            this.masters = ((Number)json_data.get("Masters")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Degrees; the field masters was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Degrees; the field masters had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Bachelors
            this.bachelors = ((Number)json_data.get("Bachelors")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Degrees; the field bachelors was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Degrees; the field bachelors had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}