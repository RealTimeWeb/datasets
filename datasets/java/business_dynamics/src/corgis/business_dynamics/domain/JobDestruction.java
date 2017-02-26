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
public class JobDestruction {
	
    // The number of jobs at continuing establishments that were destroyed in the last year.
    private Integer continuers;
    // The number of jobs that were destroyed in the last year.
    private Integer count;
    // The number of jobs that were destroyed in the last year divided by the DHS denominator. The result is the rate at which jobs have been destroyed.
    private Double rate;
    // The number of jobs that were destroyed because of firm deaths that were destroyed in the last year divided by the DHS denominator. The result is the rate at which jobs have been destroyed because of firm death.
    private Double rateDeaths;
    // The number of jobs that were destroyed because of firm deaths that were destroyed in the last year.
    private Integer deaths;
    
    
    /*
     * @return 
     */
    public Integer getContinuers() {
        return this.continuers;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCount() {
        return this.count;
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
    public Double getRateDeaths() {
        return this.rateDeaths;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getDeaths() {
        return this.deaths;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this JobDestruction.
	
	 * @return String
	 */
	public String toString() {
		return "JobDestruction[" +continuers+", "+count+", "+rate+", "+rateDeaths+", "+deaths+"]";
	}
	
	/**
	 * Internal constructor to create a JobDestruction from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public JobDestruction(JSONObject json_data) {
        try {// Continuers
            this.continuers = ((Number)json_data.get("Continuers")).intValue();// Count
            this.count = ((Number)json_data.get("Count")).intValue();// Rate
            this.rate = ((Number)json_data.get("Rate")).doubleValue();// Rate/Deaths
            this.rateDeaths = ((Number)json_data.get("Rate/Deaths")).doubleValue();// Deaths
            this.deaths = ((Number)json_data.get("Deaths")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a JobDestruction; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a JobDestruction; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}