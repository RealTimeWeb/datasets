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
public class Batting {
	
    private Integer runs;
    private Integer hits;
    private Integer atBats;
    private Integer year;
    
    
    /*
     * @return 
     */
    public Integer getRuns() {
        return this.runs;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHits() {
        return this.hits;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAtBats() {
        return this.atBats;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Batting.
	
	 * @return String
	 */
	public String toString() {
		return "Batting[" +runs+", "+hits+", "+atBats+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Batting from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Batting(JSONObject json_data) {
        try {// runs
            this.runs = new Integer(((Long)json_data.get("runs")).intValue());// hits
            this.hits = new Integer(((Long)json_data.get("hits")).intValue());// at bats
            this.atBats = new Integer(((Long)json_data.get("at bats")).intValue());// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Batting; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Batting; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}