package corgis.soccer.domain;

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
	
    private String month;
    private String day;
    private String year;
    
    
    /*
     * @return 
     */
    public String getMonth() {
        return this.month;
    }
    
    
    
    /*
     * @return 
     */
    public String getDay() {
        return this.day;
    }
    
    
    
    /*
     * @return 
     */
    public String getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Date.
	
	 * @return String
	 */
	public String toString() {
		return "Date[" +month+", "+day+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Date from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Date(JSONObject json_data) {
        try {// month
            this.month = (String)json_data.get("month");// day
            this.day = (String)json_data.get("day");// year
            this.year = (String)json_data.get("year");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Date; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Date; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}