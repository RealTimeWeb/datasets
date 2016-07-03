package corgis.classics.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.classics.domain.Difficulty;
import corgis.classics.domain.Statistics;
import corgis.classics.domain.Sentiments;

/**
 * 
 */
public class Statistics {
	
    private Difficulty difficulty;
    private Statistics statistics;
    private Sentiments sentiments;
    
    
    /*
     * @return 
     */
    public Difficulty getDifficulty() {
        return this.difficulty;
    }
    
    
    
    /*
     * @return 
     */
    public Statistics getStatistics() {
        return this.statistics;
    }
    
    
    
    /*
     * @return 
     */
    public Sentiments getSentiments() {
        return this.sentiments;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Statistics.
	
	 * @return String
	 */
	public String toString() {
		return "Statistics[" +difficulty+", "+statistics+", "+sentiments+"]";
	}
	
	/**
	 * Internal constructor to create a Statistics from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Statistics(JSONObject json_data) {
        try {// Difficulty
        	System.out.println("STATS:"+json_data);
            this.difficulty = new Difficulty((JSONObject)json_data.get("Difficulty"));// Statistics
            this.statistics = new Statistics((JSONObject)json_data.get("Statistics"));// Sentiments
            this.sentiments = new Sentiments((JSONObject)json_data.get("Sentiments"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}