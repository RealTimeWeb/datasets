package corgis.weather.domain;

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
	
    // The first day of the week that this report was made.
    private Integer weekOf;
    // A full string representation of the date this report was made.
    private String full;
    // The year that this report was made.
    private Integer year;
    // The month of the year that this report was made.
    private Integer month;
    
    
    /*
     * @return 
     */
    public Integer getWeekOf() {
        return this.weekOf;
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
    public Integer getYear() {
        return this.year;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMonth() {
        return this.month;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Date.
	
	 * @return String
	 */
	public String toString() {
		return "Date[" +weekOf+", "+full+", "+year+", "+month+"]";
	}
	
	/**
	 * Internal constructor to create a Date from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Date(JSONObject json_data) {
        System.out.println(json_data);
        try {// Week of
            this.weekOf = ((Number)json_data.get("Week of")).intValue();// Full
            this.full = (String)json_data.get("Full");// Year
            this.year = ((Number)json_data.get("Year")).intValue();// Month
            this.month = ((Number)json_data.get("Month")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Date; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Date; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}