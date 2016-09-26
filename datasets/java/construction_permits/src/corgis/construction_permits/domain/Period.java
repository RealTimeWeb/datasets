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
	
    private String monthName;
    private String full;
    private Integer year;
    private Integer month;
    
    
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
    
    
    
    /*
     * @return 
     */
    public Integer getMonth() {
        return this.month;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Period.
	
	 * @return String
	 */
	public String toString() {
		return "Period[" +monthName+", "+full+", "+year+", "+month+"]";
	}
	
	/**
	 * Internal constructor to create a Period from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Period(JSONObject json_data) {
        try {// month name
            this.monthName = (String)json_data.get("month name");// full
            this.full = (String)json_data.get("full");// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());// month
            this.month = new Integer(((Long)json_data.get("month")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Period; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Period; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}