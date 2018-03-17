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
	
    // The number of jobs that were created in the last year divided by the DHS denominator. The result is the rate at which jobs have been created.
    private Double rate;
    // The number of jobs that were created because a new firm born in the past year, divided by the DHS denominator. The result is the rate at which jobs have been created because of firm births.
    private Double rateBirths;
    // The number of jobs at continuing establishments that were created in the last yaer.
    private Integer continuers;
    // The number of jobs that were created because of firm births in the past year.
    private Integer births;
    // The number of jobs that were created in the last year.
    private Integer count;
    
    
    /**
     * The number of jobs that were created in the last year divided by the DHS denominator. The result is the rate at which jobs have been created.
     * @return Double
     */
    public Double getRate() {
        return this.rate;
    }
    
    
    
    /**
     * The number of jobs that were created because a new firm born in the past year, divided by the DHS denominator. The result is the rate at which jobs have been created because of firm births.
     * @return Double
     */
    public Double getRateBirths() {
        return this.rateBirths;
    }
    
    
    
    /**
     * The number of jobs at continuing establishments that were created in the last yaer.
     * @return Integer
     */
    public Integer getContinuers() {
        return this.continuers;
    }
    
    
    
    /**
     * The number of jobs that were created because of firm births in the past year.
     * @return Integer
     */
    public Integer getBirths() {
        return this.births;
    }
    
    
    
    /**
     * The number of jobs that were created in the last year.
     * @return Integer
     */
    public Integer getCount() {
        return this.count;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this JobCreation.
	
	 * @return String
	 */
	public String toString() {
		return "JobCreation[" +rate+", "+rateBirths+", "+continuers+", "+births+", "+count+"]";
	}
	
	/**
	 * Internal constructor to create a JobCreation from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public JobCreation(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Rate
            this.rate = ((Number)json_data.get("Rate")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a JobCreation; the field rate was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a JobCreation; the field rate had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Rate/Births
            this.rateBirths = ((Number)json_data.get("Rate/Births")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a JobCreation; the field rateBirths was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a JobCreation; the field rateBirths had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Continuers
            this.continuers = ((Number)json_data.get("Continuers")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a JobCreation; the field continuers was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a JobCreation; the field continuers had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Births
            this.births = ((Number)json_data.get("Births")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a JobCreation; the field births was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a JobCreation; the field births had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Count
            this.count = ((Number)json_data.get("Count")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a JobCreation; the field count was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a JobCreation; the field count had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}