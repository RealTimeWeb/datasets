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
public class Employment {
	
    private Integer partTime;
    private Integer unemployed;
    private Double unemploymentRate;
    private Integer fullTime;
    private Integer employed;
    private Integer fullTimeYearRound;
    
    
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
    public Integer getFullTimeYearRound() {
        return this.fullTimeYearRound;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Employment.
	
	 * @return String
	 */
	public String toString() {
		return "Employment[" +partTime+", "+unemployed+", "+unemploymentRate+", "+fullTime+", "+employed+", "+fullTimeYearRound+"]";
	}
	
	/**
	 * Internal constructor to create a Employment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Employment(JSONObject json_data) {
        try {// Part Time
            this.partTime = ((Number)json_data.get("Part Time")).intValue();// Unemployed
            this.unemployed = ((Number)json_data.get("Unemployed")).intValue();// Unemployment Rate
            this.unemploymentRate = ((Number)json_data.get("Unemployment Rate")).doubleValue();// Full Time
            this.fullTime = ((Number)json_data.get("Full Time")).intValue();// Employed
            this.employed = ((Number)json_data.get("Employed")).intValue();// Full Time, Year-Round
            this.fullTimeYearRound = ((Number)json_data.get("Full Time, Year-Round")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}