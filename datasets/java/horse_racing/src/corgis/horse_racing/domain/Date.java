package corgis.horse_racing.domain;

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
	
    private String full;
    private String year;
    private String day;
    private String month;
    
    
    /*
     * @return 
     */
    public String getFull() {
        return this.full;
    }
    
    
    
    /*
     * @return 
     */
    public String getYear() {
        return this.year;
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
    public String getMonth() {
        return this.month;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Date.
	
	 * @return String
	 */
	public String toString() {
		return "Date[" +full+", "+year+", "+day+", "+month+"]";
	}
	
	/**
	 * Internal constructor to create a Date from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Date(JSONObject json_data) {
        try {// full
            this.full = (String)json_data.get("full");// year
            this.year = (String)json_data.get("year");// day
            this.day = (String)json_data.get("day");// month
            this.month = (String)json_data.get("month");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Date; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Date; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}