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
	
    // The estimated number of doctoral degrees awarded in this for major during this year.
    private Integer doctorates;
    // The estimated number of professional degrees awarded in this for major during this year.
    private Integer professionals;
    // The estimated number of Masters awarded in this for major during this year.
    private Integer masters;
    // The estimated number of bachelor degrees awarded in this for major during this year.
    private Integer bachelors;
    
    
    /*
     * @return 
     */
    public Integer getDoctorates() {
        return this.doctorates;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getProfessionals() {
        return this.professionals;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMasters() {
        return this.masters;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBachelors() {
        return this.bachelors;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Degrees.
	
	 * @return String
	 */
	public String toString() {
		return "Degrees[" +doctorates+", "+professionals+", "+masters+", "+bachelors+"]";
	}
	
	/**
	 * Internal constructor to create a Degrees from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Degrees(JSONObject json_data) {
        try {// Doctorates
            this.doctorates = ((Number)json_data.get("Doctorates")).intValue();// Professionals
            this.professionals = ((Number)json_data.get("Professionals")).intValue();// Masters
            this.masters = ((Number)json_data.get("Masters")).intValue();// Bachelors
            this.bachelors = ((Number)json_data.get("Bachelors")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Degrees; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Degrees; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}