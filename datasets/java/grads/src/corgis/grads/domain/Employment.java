package corgis.grads.domain;

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
public class Employment {
	
    private Integer partTime;
    private Integer unemployed;
    private Double unemploymentRate;
    private Integer fullTime;
    private Integer employed;
    private Integer fullTime,YearRound;
    
    
    /*
     * @return 
     */
    public Integer getPartTime() {
        return this.partTime;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUnemployed() {
        return this.unemployed;
    }
    
    
    
    /*
     * @return 
     */
    public Double getUnemploymentRate() {
        return this.unemploymentRate;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFullTime() {
        return this.fullTime;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEmployed() {
        return this.employed;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFullTime,YearRound() {
        return this.fullTime,YearRound;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Employment.
	
	 * @return String
	 */
	public String toString() {
		return "Employment[" +partTime+", "+unemployed+", "+unemploymentRate+", "+fullTime+", "+employed+", "+fullTime,YearRound+"]";
	}
	
	/**
	 * Internal constructor to create a Employment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Employment(JSONObject json_data) {
        try {// Part Time
            this.partTime = new Integer(((Long)json_data.get("Part Time")).intValue());// Unemployed
            this.unemployed = new Integer(((Long)json_data.get("Unemployed")).intValue());// Unemployment Rate
            this.unemploymentRate = (Double)json_data.get("Unemployment Rate");// Full Time
            this.fullTime = new Integer(((Long)json_data.get("Full Time")).intValue());// Employed
            this.employed = new Integer(((Long)json_data.get("Employed")).intValue());// Full Time, Year-Round
            this.fullTime,YearRound = new Integer(((Long)json_data.get("Full Time, Year-Round")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}