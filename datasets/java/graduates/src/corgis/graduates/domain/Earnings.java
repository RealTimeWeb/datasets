package corgis.graduates.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.graduates.domain.EarningsBreakdown;

/**
 * 
 */
public class Earnings {
	
    private Integer nonCollegeJobs;
    private Integer collegeJobs;
    private EarningsBreakdown earningsBreakdown;
    private Integer lowWageJobs;
    
    
    /*
     * @return 
     */
    public Integer getNonCollegeJobs() {
        return this.nonCollegeJobs;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCollegeJobs() {
        return this.collegeJobs;
    }
    
    
    
    /*
     * @return 
     */
    public EarningsBreakdown getEarningsBreakdown() {
        return this.earningsBreakdown;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLowWageJobs() {
        return this.lowWageJobs;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Earnings.
	
	 * @return String
	 */
	public String toString() {
		return "Earnings[" +nonCollegeJobs+", "+collegeJobs+", "+earningsBreakdown+", "+lowWageJobs+"]";
	}
	
	/**
	 * Internal constructor to create a Earnings from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Earnings(JSONObject json_data) {
        try {// Non-College Jobs
            this.nonCollegeJobs = ((Number)json_data.get("Non-College Jobs")).intValue();// College Jobs
            this.collegeJobs = ((Number)json_data.get("College Jobs")).intValue();// Earnings Breakdown
            this.earningsBreakdown = new EarningsBreakdown((JSONObject)json_data.get("Earnings Breakdown"));// Low Wage Jobs
            this.lowWageJobs = ((Number)json_data.get("Low Wage Jobs")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Earnings; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Earnings; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}