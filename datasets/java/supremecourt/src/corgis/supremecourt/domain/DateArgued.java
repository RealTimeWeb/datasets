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
	
    private String full;
    private Integer year;
    private Integer day;
    private Integer month;
    
    
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
    public Integer getDay() {
        return this.day;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMonth() {
        return this.month;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this DateArgued.
	
	 * @return String
	 */
	public String toString() {
		return "DateArgued[" +full+", "+year+", "+day+", "+month+"]";
	}
	
	/**
	 * Internal constructor to create a DateArgued from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public DateArgued(JSONObject json_data) {
        try {// full
            this.full = (String)json_data.get("full");// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());// day
            this.day = new Integer(((Long)json_data.get("day")).intValue());// month
            this.month = new Integer(((Long)json_data.get("month")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a DateArgued; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a DateArgued; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}