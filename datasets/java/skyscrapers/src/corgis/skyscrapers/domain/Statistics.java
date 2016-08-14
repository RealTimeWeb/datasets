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
	
    private Integer numberOfPurposes;
    private Integer floorsAbove;
    private Integer rank;
    private Double height;
    
    
    /*
     * @return 
     */
    public Integer getNumberOfPurposes() {
        return this.numberOfPurposes;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFloorsAbove() {
        return this.floorsAbove;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getRank() {
        return this.rank;
    }
    
    
    
    /*
     * @return 
     */
    public Double getHeight() {
        return this.height;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Statistics.
	
	 * @return String
	 */
	public String toString() {
		return "Statistics[" +numberOfPurposes+", "+floorsAbove+", "+rank+", "+height+"]";
	}
	
	/**
	 * Internal constructor to create a Statistics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Statistics(JSONObject json_data) {
        try {// number of purposes
            this.numberOfPurposes = new Integer(((Long)json_data.get("number of purposes")).intValue());// floors above
            this.floorsAbove = new Integer(((Long)json_data.get("floors above")).intValue());// rank
            this.rank = new Integer(((Long)json_data.get("rank")).intValue());// height
            this.height = (Double)json_data.get("height");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}