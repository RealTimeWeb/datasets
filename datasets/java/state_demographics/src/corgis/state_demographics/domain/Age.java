package corgis.state_demographics.domain;

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
public class Age {
	
    private Double percentUnderOneeightYears;
    private Double percentSixfiveAndOlder;
    private Double percentUnderFiveYears;
    
    
    /*
     * @return 
     */
    public Double getPercentUnderOneeightYears() {
        return this.percentUnderOneeightYears;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPercentSixfiveAndOlder() {
        return this.percentSixfiveAndOlder;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPercentUnderFiveYears() {
        return this.percentUnderFiveYears;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Age.
	
	 * @return String
	 */
	public String toString() {
		return "Age[" +percentUnderOneeightYears+", "+percentSixfiveAndOlder+", "+percentUnderFiveYears+"]";
	}
	
	/**
	 * Internal constructor to create a Age from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Age(JSONObject json_data) {
        try {// Percent Under 18 Years
            this.percentUnderOneeightYears = ((Number)json_data.get("Percent Under 18 Years")).doubleValue();// Percent 65 and Older
            this.percentSixfiveAndOlder = ((Number)json_data.get("Percent 65 and Older")).doubleValue();// Percent Under 5 Years
            this.percentUnderFiveYears = ((Number)json_data.get("Percent Under 5 Years")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Age; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Age; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}