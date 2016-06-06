package corgis.classics.domain;

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
	
    private Integer month;
    private String monthName;
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
    public String getMonthName() {
        return this.monthName;
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
	 * Creates a string based representation of this Publication.
	
	 * @return String
	 */
	public String toString() {
		return "Publication[" +month+", "+monthName+", "+full+", "+day+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Publication from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Publication(JSONObject json_data) {
        try {
            this.month = (Integer)json_data.get("month");
            this.monthName = (String)json_data.get("month name");
            this.full = (String)json_data.get("full");
            this.day = (Integer)json_data.get("day");
            this.year = (Integer)json_data.get("year");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Publication; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Publication; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}