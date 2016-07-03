package corgis.classics.domain;

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
public class Publication {
	
    private String fullDate;
    private String monthName;
    private Integer month;
    private Integer day;
    private Integer year;
    
    
    /*
     * @return 
     */
    public String getFullDate() {
        return this.fullDate;
    }
    
    
    
    /*
     * @return 
     */
    public String getMonthName() {
        return this.monthName;
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
	 * Creates a string based representation of this Publication.
	
	 * @return String
	 */
	public String toString() {
		return "Publication[" +fullDate+", "+monthName+", "+month+", "+day+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Publication from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Publication(JSONObject json_data) {
        try {// Full Date
            this.fullDate = (String)json_data.get("Full Date");// Month Name
            this.monthName = (String)json_data.get("Month Name");// Month
            this.month = new Integer(((Long)json_data.get("Month")).intValue());// Day
            this.day = new Integer(((Long)json_data.get("Day")).intValue());// Year
            this.year = new Integer(((Long)json_data.get("Year")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Publication; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Publication; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}