package corgis.broadway.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.broadway.domain.Date;
import corgis.broadway.domain.Show;
import corgis.broadway.domain.Statistics;

/**
 * 
 */
public class Production {
	
    private Date date;
    private Show show;
    private Statistics statistics;
    
    
    /**
     * 
     * @return Date
     */
    public Date getDate() {
        return this.date;
    }
    
    
    
    /**
     * 
     * @return Show
     */
    public Show getShow() {
        return this.show;
    }
    
    
    
    /**
     * 
     * @return Statistics
     */
    public Statistics getStatistics() {
        return this.statistics;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Production.
	
	 * @return String
	 */
	public String toString() {
		return "Production[" +date+", "+show+", "+statistics+"]";
	}
	
	/**
	 * Internal constructor to create a Production from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Production(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Date
            this.date = new Date((JSONObject)json_data.get("Date"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Production; the field date was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Production; the field date had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Show
            this.show = new Show((JSONObject)json_data.get("Show"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Production; the field show was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Production; the field show had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Statistics
            this.statistics = new Statistics((JSONObject)json_data.get("Statistics"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Production; the field statistics was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Production; the field statistics had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}