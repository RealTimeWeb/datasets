package corgis.retail_services.domain;

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
	
    private Integer month;
    private String period;
    private Integer index;
    private Integer year;
    private String monthName;
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getMonth() {
        return this.month;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getPeriod() {
        return this.period;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getIndex() {
        return this.index;
    }
    
    
    
    /**
     * 
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
	 * Creates a string based representation of this Time.
	
	 * @return String
	 */
	public String toString() {
		return "Time[" +month+", "+period+", "+index+", "+year+", "+monthName+"]";
	}
	
	/**
	 * Internal constructor to create a Time from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Time(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // month
            this.month = ((Number)json_data.get("month")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; the field month was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; the field month had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // period
            this.period = (String)json_data.get("period");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; the field period was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; the field period had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // index
            this.index = ((Number)json_data.get("index")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; the field index was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; the field index had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // year
            this.year = ((Number)json_data.get("year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // month name
            this.monthName = (String)json_data.get("month name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; the field monthName was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; the field monthName had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}