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
	
    // The numeric month that this report was made. January is 1, February is 2, etc.
    private Integer month;
    // The reporting period that this report made in (e.g., "")
    private String period;
    // A number representing the index of this report. The first report is 0, the second report is 1, etc.
    private Integer index;
    // The year that this report was made in.
    private Integer year;
    // The name of the month that this report was made.
    private String monthName;
    
    
    /**
     * The numeric month that this report was made. January is 1, February is 2, etc.
     * @return Integer
     */
    public Integer getMonth() {
        return this.month;
    }
    
    
    
    /**
     * The reporting period that this report made in (e.g., "")
     * @return String
     */
    public String getPeriod() {
        return this.period;
    }
    
    
    
    /**
     * A number representing the index of this report. The first report is 0, the second report is 1, etc.
     * @return Integer
     */
    public Integer getIndex() {
        return this.index;
    }
    
    
    
    /**
     * The year that this report was made in.
     * @return Integer
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
    /**
     * The name of the month that this report was made.
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