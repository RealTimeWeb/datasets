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
    // The full representation of the time period for this report. The format is "Year/month".
    private String full;
    private Integer year;
    private String monthName;
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getMonth() {
        return this.month;
    }
    
    
    
    /**
     * The full representation of the time period for this report. The format is "Year/month".
     * @return String
     */
    public String getFull() {
        return this.full;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getMonthName() {
        return this.monthName;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Period.
	
	 * @return String
	 */
	public String toString() {
		return "Period[" +month+", "+full+", "+year+", "+monthName+"]";
	}
	
	/**
	 * Internal constructor to create a Period from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Period(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // month
            this.month = ((Number)json_data.get("month")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Period; the field month was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Period; the field month had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // full
            this.full = (String)json_data.get("full");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Period; the field full was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Period; the field full had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // year
            this.year = ((Number)json_data.get("year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Period; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Period; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // month name
            this.monthName = (String)json_data.get("month name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Period; the field monthName was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Period; the field monthName had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}