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
public class Salaries {
	
    // The lowest recorded salary reported for employed people with this degree during this year.
    private Double lowest;
    // The average (mean) recorded salary reported for employed people with this degree during this year.
    private Double mean;
    // The median recorded salary reported for employed people with this degree during this year.
    private Double median;
    // The standard deviation (which gives the amount of variance) of salaries reported for employed people with this degree during this year.
    private Double standardDeviation;
    // The highest recorded salary reported for employed people with this degree during this year.
    private Double highest;
    // The number of salaries reported for employed people with this degree during this year.
    private Integer quantity;
    
    
    /*
     * @return 
     */
    public Double getLowest() {
        return this.lowest;
    }
    
    
    
    /*
     * @return 
     */
    public Double getMean() {
        return this.mean;
    }
    
    
    
    /*
     * @return 
     */
    public Double getMedian() {
        return this.median;
    }
    
    
    
    /*
     * @return 
     */
    public Double getStandardDeviation() {
        return this.standardDeviation;
    }
    
    
    
    /*
     * @return 
     */
    public Double getHighest() {
        return this.highest;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getQuantity() {
        return this.quantity;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Salaries.
	
	 * @return String
	 */
	public String toString() {
		return "Salaries[" +lowest+", "+mean+", "+median+", "+standardDeviation+", "+highest+", "+quantity+"]";
	}
	
	/**
	 * Internal constructor to create a Salaries from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Salaries(JSONObject json_data) {
        try {// Lowest
            this.lowest = ((Number)json_data.get("Lowest")).doubleValue();// Mean
            this.mean = ((Number)json_data.get("Mean")).doubleValue();// Median
            this.median = ((Number)json_data.get("Median")).doubleValue();// Standard Deviation
            this.standardDeviation = ((Number)json_data.get("Standard Deviation")).doubleValue();// Highest
            this.highest = ((Number)json_data.get("Highest")).doubleValue();// Quantity
            this.quantity = ((Number)json_data.get("Quantity")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Salaries; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Salaries; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}