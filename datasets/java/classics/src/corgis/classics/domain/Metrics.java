package corgis.classics.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.classics.domain.Sentiments;
import corgis.classics.domain.Statistics;
import corgis.classics.domain.Difficulty;

/**
 * 
 */
public class Metrics {
	
    private Sentiments sentiments;
    private Statistics statistics;
    private Difficulty difficulty;
    
    
    /**
     * 
     * @return Sentiments
     */
    public Sentiments getSentiments() {
        return this.sentiments;
    }
    
    
    
    /**
     * 
     * @return Statistics
     */
    public Statistics getStatistics() {
        return this.statistics;
    }
    
    
    
    /**
     * 
     * @return Difficulty
     */
    public Difficulty getDifficulty() {
        return this.difficulty;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Metrics.
	
	 * @return String
	 */
	public String toString() {
		return "Metrics[" +sentiments+", "+statistics+", "+difficulty+"]";
	}
	
	/**
	 * Internal constructor to create a Metrics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Metrics(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // sentiments
            this.sentiments = new Sentiments((JSONObject)json_data.get("sentiments"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metrics; the field sentiments was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metrics; the field sentiments had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // statistics
            this.statistics = new Statistics((JSONObject)json_data.get("statistics"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metrics; the field statistics was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metrics; the field statistics had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // difficulty
            this.difficulty = new Difficulty((JSONObject)json_data.get("difficulty"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metrics; the field difficulty was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metrics; the field difficulty had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}