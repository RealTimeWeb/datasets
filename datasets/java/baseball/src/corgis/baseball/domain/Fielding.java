package corgis.baseball.domain;

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
public class Fielding {
	
    private Integer assists;
    private Integer errors;
    private Integer putouts;
    private Integer year;
    
    
    /*
     * @return 
     */
    public Integer getAssists() {
        return this.assists;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getErrors() {
        return this.errors;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPutouts() {
        return this.putouts;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Fielding.
	
	 * @return String
	 */
	public String toString() {
		return "Fielding[" +assists+", "+errors+", "+putouts+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Fielding from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Fielding(JSONObject json_data) {
        try {// assists
            this.assists = new Integer(((Long)json_data.get("assists")).intValue());// errors
            this.errors = new Integer(((Long)json_data.get("errors")).intValue());// putouts
            this.putouts = new Integer(((Long)json_data.get("putouts")).intValue());// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Fielding; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Fielding; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}