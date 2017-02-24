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
public class Date {
	
    // The full date representation that this performance's week ended on in "Month/Day/Year" format.
    private String full;
    // The day of the month that this performance's week ended on.
    private Integer day;
    // The numeric month that this performance's week ended in (1 = January, 2 = February, etc.).
    private Integer month;
    // The year that this week of performances occurred in.
    private Integer year;
    
    
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
    public Integer getMonth() {
        return this.month;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Date.
	
	 * @return String
	 */
	public String toString() {
		return "Date[" +full+", "+day+", "+month+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Date from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Date(JSONObject json_data) {
        try {// Full
            this.full = (String)json_data.get("Full");// Day
            this.day = ((Number)json_data.get("Day")).intValue();// Month
            this.month = ((Number)json_data.get("Month")).intValue();// Year
            this.year = ((Number)json_data.get("Year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Date; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Date; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}