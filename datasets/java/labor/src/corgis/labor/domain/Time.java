package corgis.labor.domain;

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
public class Time {
	
    private String monthName;
    private Integer month;
    private Integer year;
    
    
    /**
     * 
     * @return String
     */
    public String getMonthName() {
        return this.monthName;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getMonth() {
        return this.month;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Time.
	
	 * @return String
	 */
	public String toString() {
		return "Time[" +monthName+", "+month+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Time from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Time(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Month Name
            this.monthName = (String)json_data.get("Month Name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; the field monthName was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; the field monthName had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Month
            this.month = ((Number)json_data.get("Month")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; the field month was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; the field month had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Year
            this.year = ((Number)json_data.get("Year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}