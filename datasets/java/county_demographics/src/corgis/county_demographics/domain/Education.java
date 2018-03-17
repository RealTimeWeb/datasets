package corgis.county_demographics.domain;

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
public class Education {
	
    private Double highSchoolOrHigher;
    private Double bachelorsDegreeOrHigher;
    
    
    /**
     * 
     * @return Double
     */
    public Double getHighSchoolOrHigher() {
        return this.highSchoolOrHigher;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getBachelorsDegreeOrHigher() {
        return this.bachelorsDegreeOrHigher;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Education.
	
	 * @return String
	 */
	public String toString() {
		return "Education[" +highSchoolOrHigher+", "+bachelorsDegreeOrHigher+"]";
	}
	
	/**
	 * Internal constructor to create a Education from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Education(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // High School or Higher
            this.highSchoolOrHigher = ((Number)json_data.get("High School or Higher")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; the field highSchoolOrHigher was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; the field highSchoolOrHigher had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Bachelor's Degree or Higher
            this.bachelorsDegreeOrHigher = ((Number)json_data.get("Bachelor's Degree or Higher")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; the field bachelorsDegreeOrHigher was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; the field bachelorsDegreeOrHigher had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}