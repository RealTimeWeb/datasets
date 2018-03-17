package corgis.county_demographics.domain;

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
    private Double percentUnderFiveYears;
    private Double percentSixfiveAndOlder;
    
    
    /**
     * 
     * @return Double
     */
    public Double getPercentUnderOneeightYears() {
        return this.percentUnderOneeightYears;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getPercentUnderFiveYears() {
        return this.percentUnderFiveYears;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getPercentSixfiveAndOlder() {
        return this.percentSixfiveAndOlder;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Age.
	
	 * @return String
	 */
	public String toString() {
		return "Age[" +percentUnderOneeightYears+", "+percentUnderFiveYears+", "+percentSixfiveAndOlder+"]";
	}
	
	/**
	 * Internal constructor to create a Age from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Age(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Percent Under 18 Years
            this.percentUnderOneeightYears = ((Number)json_data.get("Percent Under 18 Years")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Age; the field percentUnderOneeightYears was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Age; the field percentUnderOneeightYears had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Percent Under 5 Years
            this.percentUnderFiveYears = ((Number)json_data.get("Percent Under 5 Years")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Age; the field percentUnderFiveYears was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Age; the field percentUnderFiveYears had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Percent 65 and Older
            this.percentSixfiveAndOlder = ((Number)json_data.get("Percent 65 and Older")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Age; the field percentSixfiveAndOlder was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Age; the field percentSixfiveAndOlder had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}