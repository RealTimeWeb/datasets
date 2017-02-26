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
public class JobCreation {
	
    // The number of jobs that were created in the last year.
    private Integer count;
    // The number of jobs at continuing establishments that were created in the last yaer.
    private Integer continuers;
    // The number of jobs that were created in the last year divided by the DHS denominator. The result is the rate at which jobs have been created.
    private Double rate;
    // The number of jobs that were created because a new firm born in the past year, divided by the DHS denominator. The result is the rate at which jobs have been created because of firm births.
    private Double rateBirths;
    // The number of jobs that were created because of firm births in the past year.
    private Integer births;
    
    
    /*
     * @return 
     */
    public Integer getCount() {
        return this.count;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getContinuers() {
        return this.continuers;
    }
    
    
    
    /*
     * @return 
     */
    public Double getRate() {
        return this.rate;
    }
    
    
    
    /*
     * @return 
     */
    public Double getRateBirths() {
        return this.rateBirths;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBirths() {
        return this.births;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this JobCreation.
	
	 * @return String
	 */
	public String toString() {
		return "JobCreation[" +count+", "+continuers+", "+rate+", "+rateBirths+", "+births+"]";
	}
	
	/**
	 * Internal constructor to create a JobCreation from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public JobCreation(JSONObject json_data) {
        try {// Count
            this.count = ((Number)json_data.get("Count")).intValue();// Continuers
            this.continuers = ((Number)json_data.get("Continuers")).intValue();// Rate
            this.rate = ((Number)json_data.get("Rate")).doubleValue();// Rate/Births
            this.rateBirths = ((Number)json_data.get("Rate/Births")).doubleValue();// Births
            this.births = ((Number)json_data.get("Births")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a JobCreation; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a JobCreation; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}