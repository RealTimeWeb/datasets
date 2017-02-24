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
    // The reported year as a 4-digit number.
    private Integer year;
    // The "year/month" reported as a string, to make it easier to sort by time periods.
    private String label;
    // The reported month as a number. 0 is January, 1 is February, etc.
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
    public Integer getYear() {
        return this.year;
    }
    
    
    
    /*
     * @return 
     */
    public String getLabel() {
        return this.label;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMonth() {
        return this.month;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Time.
	
	 * @return String
	 */
	public String toString() {
		return "Time[" +monthName+", "+year+", "+label+", "+month+"]";
	}
	
	/**
	 * Internal constructor to create a Time from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Time(JSONObject json_data) {
        try {// Month Name
            this.monthName = (String)json_data.get("Month Name");// Year
            this.year = ((Number)json_data.get("Year")).intValue();// Label
            this.label = (String)json_data.get("Label");// Month
            this.month = ((Number)json_data.get("Month")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}