package corgis.supreme_court.domain;

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
public class DateReargued {
	
    private Integer month;
    private String full;
    private Integer day;
    private Integer year;
    
    
    /*
     * @return 
     */
    public Integer getMonth() {
        return this.month;
    }
    
    
    
    /*
     * @return 
     */
    public String getFull() {
        return this.full;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getDay() {
        return this.day;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this DateReargued.
	
	 * @return String
	 */
	public String toString() {
		return "DateReargued[" +month+", "+full+", "+day+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a DateReargued from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public DateReargued(JSONObject json_data) {
        try {// month
            this.month = ((Number)json_data.get("month")).intValue();// full
            this.full = (String)json_data.get("full");// day
            this.day = ((Number)json_data.get("day")).intValue();// year
            this.year = ((Number)json_data.get("year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a DateReargued; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a DateReargued; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}