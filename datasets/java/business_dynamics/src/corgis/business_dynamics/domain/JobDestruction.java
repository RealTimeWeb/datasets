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
	
    // The number of jobs that were destroyed in the last year divided by the DHS denominator. The result is the rate at which jobs have been destroyed.
    private Double rate;
    // The number of jobs that were destroyed because of firm deaths that were destroyed in the last year divided by the DHS denominator. The result is the rate at which jobs have been destroyed because of firm death.
    private Double rateDeaths;
    // The number of jobs that were destroyed because of firm deaths that were destroyed in the last year.
    private Integer deaths;
    // The number of jobs at continuing establishments that were destroyed in the last year.
    private Integer continuers;
    // The number of jobs that were destroyed in the last year.
    private Integer count;
    
    
    /**
     * The number of jobs that were destroyed in the last year divided by the DHS denominator. The result is the rate at which jobs have been destroyed.
     * @return Double
     */
    public Double getRate() {
        return this.rate;
    }
    
    
    
    /**
     * The number of jobs that were destroyed because of firm deaths that were destroyed in the last year divided by the DHS denominator. The result is the rate at which jobs have been destroyed because of firm death.
     * @return Double
     */
    public Double getRateDeaths() {
        return this.rateDeaths;
    }
    
    
    
    /**
     * The number of jobs that were destroyed because of firm deaths that were destroyed in the last year.
     * @return Integer
     */
    public Integer getDeaths() {
        return this.deaths;
    }
    
    
    
    /**
     * The number of jobs at continuing establishments that were destroyed in the last year.
     * @return Integer
     */
    public Integer getContinuers() {
        return this.continuers;
    }
    
    
    
    /**
     * The number of jobs that were destroyed in the last year.
     * @return Integer
     */
    public Integer getCount() {
        return this.count;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this JobDestruction.
	
	 * @return String
	 */
	public String toString() {
		return "JobDestruction[" +rate+", "+rateDeaths+", "+deaths+", "+continuers+", "+count+"]";
	}
	
	/**
	 * Internal constructor to create a JobDestruction from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public JobDestruction(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Rate
            this.rate = ((Number)json_data.get("Rate")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a JobDestruction; the field rate was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a JobDestruction; the field rate had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Rate/Deaths
            this.rateDeaths = ((Number)json_data.get("Rate/Deaths")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a JobDestruction; the field rateDeaths was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a JobDestruction; the field rateDeaths had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Deaths
            this.deaths = ((Number)json_data.get("Deaths")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a JobDestruction; the field deaths was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a JobDestruction; the field deaths had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Continuers
            this.continuers = ((Number)json_data.get("Continuers")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a JobDestruction; the field continuers was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a JobDestruction; the field continuers had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Count
            this.count = ((Number)json_data.get("Count")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a JobDestruction; the field count was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a JobDestruction; the field count had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}