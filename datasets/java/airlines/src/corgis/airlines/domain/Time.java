package corgis.airlines.domain;

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
    // The "year/month" reported as a string, to make it easier to sort by time periods.
    private String label;
    // The reported month as a number. 0 is January, 1 is February, etc.
    private Integer month;
    // The reported year as a 4-digit number.
    private Integer year;
    
    
    /**
     * 
     * @return String
     */
    public String getMonthName() {
        return this.monthName;
    }
    
    
    
    /**
     * The "year/month" reported as a string, to make it easier to sort by time periods.
     * @return String
     */
    public String getLabel() {
        return this.label;
    }
    
    
    
    /**
     * The reported month as a number. 0 is January, 1 is February, etc.
     * @return Integer
     */
    public Integer getMonth() {
        return this.month;
    }
    
    
    
    /**
     * The reported year as a 4-digit number.
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
		return "Time[" +monthName+", "+label+", "+month+", "+year+"]";
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
            // Label
            this.label = (String)json_data.get("Label");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; the field label was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; the field label had the wrong structure.");
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