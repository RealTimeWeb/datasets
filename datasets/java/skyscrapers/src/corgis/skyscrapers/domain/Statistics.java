package corgis.skyscrapers.domain;

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
public class Statistics {
	
    private Integer floorsAbove;
    private Integer rank;
    private Double height;
    private Integer numberOfPurposes;
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getFloorsAbove() {
        return this.floorsAbove;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getRank() {
        return this.rank;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getHeight() {
        return this.height;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getNumberOfPurposes() {
        return this.numberOfPurposes;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Statistics.
	
	 * @return String
	 */
	public String toString() {
		return "Statistics[" +floorsAbove+", "+rank+", "+height+", "+numberOfPurposes+"]";
	}
	
	/**
	 * Internal constructor to create a Statistics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Statistics(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // floors above
            this.floorsAbove = ((Number)json_data.get("floors above")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field floorsAbove was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field floorsAbove had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // rank
            this.rank = ((Number)json_data.get("rank")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field rank was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field rank had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // height
            this.height = ((Number)json_data.get("height")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field height was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field height had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // number of purposes
            this.numberOfPurposes = ((Number)json_data.get("number of purposes")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field numberOfPurposes was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field numberOfPurposes had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}