package corgis.supremecourt.domain;

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
public class DateArgued {
	
    private Integer month;
    private String full;
    private Integer day;
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
    public String getFull() {
        return this.full;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getDay() {
        return this.day;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this DateArgued.
	
	 * @return String
	 */
	public String toString() {
		return "DateArgued[" +month+", "+full+", "+day+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a DateArgued from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public DateArgued(JSONObject json_data) {
        try {// month
            this.month = new Integer(((Long)json_data.get("month")).intValue());// full
            this.full = (String)json_data.get("full");// day
            this.day = new Integer(((Long)json_data.get("day")).intValue());// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a DateArgued; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a DateArgued; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}