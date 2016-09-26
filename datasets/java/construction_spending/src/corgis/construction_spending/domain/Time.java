package corgis.construction_spending.domain;

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
	
    // The name of the month that this report was made.
    private String monthName;
    // The numeric month that this report was made. January is 1, February is 2, etc.
    private Integer month;
    // A number representing the index of this report. The first report is 0, the second report is 1, etc.
    private Integer index;
    // The reporting period that this report made in (e.g., "")
    private String period;
    // The year that this report was made in.
    private Integer year;
    
    
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
    public Integer getIndex() {
        return this.index;
    }
    
    
    
    /*
     * @return 
     */
    public String getPeriod() {
        return this.period;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Time.
	
	 * @return String
	 */
	public String toString() {
		return "Time[" +monthName+", "+month+", "+index+", "+period+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Time from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Time(JSONObject json_data) {
        try {// month name
            this.monthName = (String)json_data.get("month name");// month
            this.month = new Integer(((Long)json_data.get("month")).intValue());// index
            this.index = new Integer(((Long)json_data.get("index")).intValue());// period
            this.period = (String)json_data.get("period");// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}