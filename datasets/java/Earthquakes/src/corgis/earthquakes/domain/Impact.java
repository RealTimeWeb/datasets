package corgis.earthquakes.domain;

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
public class Impact {
	
    private Double magnitude;
    private Integer significance;
    private Double gap;
    
    
    /*
     * @return 
     */
    public Double getMagnitude() {
        return this.magnitude;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSignificance() {
        return this.significance;
    }
    
    
    
    /*
     * @return 
     */
    public Double getGap() {
        return this.gap;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Impact.
	
	 * @return String
	 */
	public String toString() {
		return "Impact[" +magnitude+", "+significance+", "+gap+"]";
	}
	
	/**
	 * Internal constructor to create a Impact from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Impact(JSONObject json_data) {
        try {// magnitude
            this.magnitude = (Double)json_data.get("magnitude");// significance
            this.significance = new Integer(((Long)json_data.get("significance")).intValue());// gap
            this.gap = (Double)json_data.get("gap");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Impact; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Impact; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}