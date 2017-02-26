package corgis.business_dynamics.domain;

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
public class Calculated {
	
    // The sum of the Job Creation Rate and the Job Destruction Rate, minus the absolute Net Job Creation Rate.
    private Double reallocationRate;
    // The sum of the Job Creation Rate minus the Job Destruction Rate.
    private Integer netJobCreation;
    // The sum of the Job Creation Rate and the Job Destruction Rate, minus the Net Job Creation Rate.
    private Double netJobCreationRate;
    
    
    /*
     * @return 
     */
    public Double getReallocationRate() {
        return this.reallocationRate;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNetJobCreation() {
        return this.netJobCreation;
    }
    
    
    
    /*
     * @return 
     */
    public Double getNetJobCreationRate() {
        return this.netJobCreationRate;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Calculated.
	
	 * @return String
	 */
	public String toString() {
		return "Calculated[" +reallocationRate+", "+netJobCreation+", "+netJobCreationRate+"]";
	}
	
	/**
	 * Internal constructor to create a Calculated from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Calculated(JSONObject json_data) {
        try {// Reallocation Rate
            this.reallocationRate = ((Number)json_data.get("Reallocation Rate")).doubleValue();// Net Job Creation
            this.netJobCreation = ((Number)json_data.get("Net Job Creation")).intValue();// Net Job Creation Rate
            this.netJobCreationRate = ((Number)json_data.get("Net Job Creation Rate")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Calculated; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Calculated; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}