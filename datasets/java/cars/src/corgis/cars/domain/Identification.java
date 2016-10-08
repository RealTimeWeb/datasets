package corgis.cars.domain;

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
public class Identification {
	
    private String make;
    private String modelYear;
    private String id;
    private String classification;
    private Integer year;
    
    
    /*
     * @return 
     */
    public String getMake() {
        return this.make;
    }
    
    
    
    /*
     * @return 
     */
    public String getModelYear() {
        return this.modelYear;
    }
    
    
    
    /*
     * @return 
     */
    public String getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public String getClassification() {
        return this.classification;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Identification.
	
	 * @return String
	 */
	public String toString() {
		return "Identification[" +make+", "+modelYear+", "+id+", "+classification+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Identification from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Identification(JSONObject json_data) {
        try {// Make
            this.make = (String)json_data.get("Make");// Model Year
            this.modelYear = (String)json_data.get("Model Year");// ID
            this.id = (String)json_data.get("ID");// Classification
            this.classification = (String)json_data.get("Classification");// Year
            this.year = ((Number)json_data.get("Year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Identification; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Identification; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}