package corgis.classics.domain;

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
public class Publication {
	
    private String monthName;
    private String full;
    // The year when the book was published according to Project Gutenberg. Keep in mind that this may not be the original publication date of the work, just that particular edition of the work. Notice that missing values have been coded as "0".
    private Integer year;
    // The day of the month when the book was published. Notice that missing values have been coded as "0".
    private Integer day;
    // The month of the year when the book was published; 1 corresponds to January, 2 to February, etc. Notice that missing values have been coded as "0".
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
	 * Creates a string based representation of this Publication.
	
	 * @return String
	 */
	public String toString() {
		return "Publication[" +monthName+", "+full+", "+year+", "+day+", "+month+"]";
	}
	
	/**
	 * Internal constructor to create a Publication from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Publication(JSONObject json_data) {
        try {// month name
            this.monthName = (String)json_data.get("month name");// full
            this.full = (String)json_data.get("full");// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());// day
            this.day = new Integer(((Long)json_data.get("day")).intValue());// month
            this.month = new Integer(((Long)json_data.get("month")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Publication; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Publication; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}