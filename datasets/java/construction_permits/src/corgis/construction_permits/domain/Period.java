package corgis.construction_permits.domain;

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
public class Period {
	
    private Integer month;
    private String monthName;
    // The full representation of the time period for this report. The format is "Year/month".
    private String full;
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
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Period.
	
	 * @return String
	 */
	public String toString() {
		return "Period[" +month+", "+monthName+", "+full+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Period from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Period(JSONObject json_data) {
        try {// month
            this.month = ((Number)json_data.get("month")).intValue();// month name
            this.monthName = (String)json_data.get("month name");// full
            this.full = (String)json_data.get("full");// year
            this.year = ((Number)json_data.get("year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Period; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Period; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}