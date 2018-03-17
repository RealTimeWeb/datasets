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
    // The highest recorded salary reported for employed people with this degree during this year.
    private Double highest;
    // The median recorded salary reported for employed people with this degree during this year.
    private Double median;
    // The standard deviation (which gives the amount of variance) of salaries reported for employed people with this degree during this year.
    private Double standardDeviation;
    // The number of salaries reported for employed people with this degree during this year.
    private Integer quantity;
    
    
    /**
     * The lowest recorded salary reported for employed people with this degree during this year.
     * @return Double
     */
    public Double getLowest() {
        return this.lowest;
    }
    
    
    
    /**
     * The average (mean) recorded salary reported for employed people with this degree during this year.
     * @return Double
     */
    public Double getMean() {
        return this.mean;
    }
    
    
    
    /**
     * The highest recorded salary reported for employed people with this degree during this year.
     * @return Double
     */
    public Double getHighest() {
        return this.highest;
    }
    
    
    
    /**
     * The median recorded salary reported for employed people with this degree during this year.
     * @return Double
     */
    public Double getMedian() {
        return this.median;
    }
    
    
    
    /**
     * The standard deviation (which gives the amount of variance) of salaries reported for employed people with this degree during this year.
     * @return Double
     */
    public Double getStandardDeviation() {
        return this.standardDeviation;
    }
    
    
    
    /**
     * The number of salaries reported for employed people with this degree during this year.
     * @return Integer
     */
    public Integer getQuantity() {
        return this.quantity;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Salaries.
	
	 * @return String
	 */
	public String toString() {
		return "Salaries[" +lowest+", "+mean+", "+highest+", "+median+", "+standardDeviation+", "+quantity+"]";
	}
	
	/**
	 * Internal constructor to create a Salaries from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Salaries(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Lowest
            this.lowest = ((Number)json_data.get("Lowest")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Salaries; the field lowest was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Salaries; the field lowest had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Mean
            this.mean = ((Number)json_data.get("Mean")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Salaries; the field mean was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Salaries; the field mean had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Highest
            this.highest = ((Number)json_data.get("Highest")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Salaries; the field highest was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Salaries; the field highest had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Median
            this.median = ((Number)json_data.get("Median")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Salaries; the field median was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Salaries; the field median had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Standard Deviation
            this.standardDeviation = ((Number)json_data.get("Standard Deviation")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Salaries; the field standardDeviation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Salaries; the field standardDeviation had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Quantity
            this.quantity = ((Number)json_data.get("Quantity")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Salaries; the field quantity was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Salaries; the field quantity had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}