package corgis.broadway.domain;

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
	
    // The number of performances that occurred this week.
    private Integer performances;
    // The percentage of the theatre that was filled during that week.
    private Integer capacity;
    // The total number of people who attended performances over the week.
    private Integer attendance;
    // The Gross Potential is the maximum amount an engagement can possibly earn based on calculations involving ticket prices, seating capacity, and the number of performances. This number is expressed here as a percentage of what could have been achieved (Gross Gross / Gross Potential). In case the GP could not be calculated, it was replaced with 0%.
    private Integer grossPotential;
    // The "Gross Gross" of this performance, or how much it made in total across the entire week. Measured in dollars.
    private Integer gross;
    
    
    /**
     * The number of performances that occurred this week.
     * @return Integer
     */
    public Integer getPerformances() {
        return this.performances;
    }
    
    
    
    /**
     * The percentage of the theatre that was filled during that week.
     * @return Integer
     */
    public Integer getCapacity() {
        return this.capacity;
    }
    
    
    
    /**
     * The total number of people who attended performances over the week.
     * @return Integer
     */
    public Integer getAttendance() {
        return this.attendance;
    }
    
    
    
    /**
     * The Gross Potential is the maximum amount an engagement can possibly earn based on calculations involving ticket prices, seating capacity, and the number of performances. This number is expressed here as a percentage of what could have been achieved (Gross Gross / Gross Potential). In case the GP could not be calculated, it was replaced with 0%.
     * @return Integer
     */
    public Integer getGrossPotential() {
        return this.grossPotential;
    }
    
    
    
    /**
     * The "Gross Gross" of this performance, or how much it made in total across the entire week. Measured in dollars.
     * @return Integer
     */
    public Integer getGross() {
        return this.gross;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Statistics.
	
	 * @return String
	 */
	public String toString() {
		return "Statistics[" +performances+", "+capacity+", "+attendance+", "+grossPotential+", "+gross+"]";
	}
	
	/**
	 * Internal constructor to create a Statistics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Statistics(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Performances
            this.performances = ((Number)json_data.get("Performances")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field performances was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field performances had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Capacity
            this.capacity = ((Number)json_data.get("Capacity")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field capacity was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field capacity had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Attendance
            this.attendance = ((Number)json_data.get("Attendance")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field attendance was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field attendance had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Gross Potential
            this.grossPotential = ((Number)json_data.get("Gross Potential")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field grossPotential was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field grossPotential had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Gross
            this.gross = ((Number)json_data.get("Gross")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field gross was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field gross had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}