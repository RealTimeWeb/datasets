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
	
    // The month of the year when the book was published; 1 corresponds to January, 2 to February, etc. Notice that missing values have been coded as "0".
    private Integer month;
    private String full;
    // The day of the month when the book was published. Notice that missing values have been coded as "0".
    private Integer day;
    // The year when the book was published according to Project Gutenberg. Keep in mind that this may not be the original publication date of the work, just that particular edition of the work. Notice that missing values have been coded as "0".
    private Integer year;
    private String monthName;
    
    
    /**
     * The month of the year when the book was published; 1 corresponds to January, 2 to February, etc. Notice that missing values have been coded as "0".
     * @return Integer
     */
    public Integer getMonth() {
        return this.month;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getFull() {
        return this.full;
    }
    
    
    
    /**
     * The day of the month when the book was published. Notice that missing values have been coded as "0".
     * @return Integer
     */
    public Integer getDay() {
        return this.day;
    }
    
    
    
    /**
     * The year when the book was published according to Project Gutenberg. Keep in mind that this may not be the original publication date of the work, just that particular edition of the work. Notice that missing values have been coded as "0".
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
	 * Creates a string based representation of this Publication.
	
	 * @return String
	 */
	public String toString() {
		return "Publication[" +month+", "+full+", "+day+", "+year+", "+monthName+"]";
	}
	
	/**
	 * Internal constructor to create a Publication from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Publication(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // month
            this.month = ((Number)json_data.get("month")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Publication; the field month was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Publication; the field month had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // full
            this.full = (String)json_data.get("full");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Publication; the field full was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Publication; the field full had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // day
            this.day = ((Number)json_data.get("day")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Publication; the field day was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Publication; the field day had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // year
            this.year = ((Number)json_data.get("year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Publication; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Publication; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // month name
            this.monthName = (String)json_data.get("month name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Publication; the field monthName was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Publication; the field monthName had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}