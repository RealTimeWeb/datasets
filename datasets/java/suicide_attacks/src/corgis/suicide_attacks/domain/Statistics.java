package corgis.suicide_attacks.domain;

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
	
    private Integer numberWounded;
    private Integer numberKilled;
    
    
    /*
     * @return 
     */
    public Integer getNumberWounded() {
        return this.numberWounded;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNumberKilled() {
        return this.numberKilled;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Statistics.
	
	 * @return String
	 */
	public String toString() {
		return "Statistics[" +numberWounded+", "+numberKilled+"]";
	}
	
	/**
	 * Internal constructor to create a Statistics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Statistics(JSONObject json_data) {
        try {// # wounded
            this.numberWounded = ((Number)json_data.get("# wounded")).intValue();// # killed
            this.numberKilled = ((Number)json_data.get("# killed")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}