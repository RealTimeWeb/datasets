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
	
    // A full string representation of the date this report was made.
    private String full;
    // The first day of the week that this report was made.
    private Integer weekOf;
    // The month of the year that this report was made.
    private Integer month;
    // The year that this report was made.
    private Integer year;
    
    
    /**
     * A full string representation of the date this report was made.
     * @return String
     */
    public String getFull() {
        return this.full;
    }
    
    
    
    /**
     * The first day of the week that this report was made.
     * @return Integer
     */
    public Integer getWeekOf() {
        return this.weekOf;
    }
    
    
    
    /**
     * The month of the year that this report was made.
     * @return Integer
     */
    public Integer getMonth() {
        return this.month;
    }
    
    
    
    /**
     * The year that this report was made.
     * @return Integer
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Date.
	
	 * @return String
	 */
	public String toString() {
		return "Date[" +full+", "+weekOf+", "+month+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Date from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Date(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Full
            this.full = (String)json_data.get("Full");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Date; the field full was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Date; the field full had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Week of
            this.weekOf = ((Number)json_data.get("Week of")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Date; the field weekOf was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Date; the field weekOf had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Month
            this.month = ((Number)json_data.get("Month")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Date; the field month was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Date; the field month had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Year
            this.year = ((Number)json_data.get("Year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Date; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Date; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}