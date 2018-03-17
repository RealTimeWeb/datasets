package corgis.earthquakes.domain;

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
	
    private Integer minute;
    private Integer hour;
    // A number that represents the time that this earthquake occurred. Epoch's are the number of seconds since a particular date (January 1st, 1970), and are a convenient way to store date/times.
    private Integer epoch;
    private String full;
    private Integer month;
    private Integer second;
    private Integer day;
    private Integer year;
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getMinute() {
        return this.minute;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getHour() {
        return this.hour;
    }
    
    
    
    /**
     * A number that represents the time that this earthquake occurred. Epoch's are the number of seconds since a particular date (January 1st, 1970), and are a convenient way to store date/times.
     * @return Integer
     */
    public Integer getEpoch() {
        return this.epoch;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getFull() {
        return this.full;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getMonth() {
        return this.month;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getSecond() {
        return this.second;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getDay() {
        return this.day;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Time.
	
	 * @return String
	 */
	public String toString() {
		return "Time[" +minute+", "+hour+", "+epoch+", "+full+", "+month+", "+second+", "+day+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Time from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Time(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // minute
            this.minute = ((Number)json_data.get("minute")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; the field minute was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; the field minute had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // hour
            this.hour = ((Number)json_data.get("hour")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; the field hour was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; the field hour had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // epoch
            this.epoch = ((Number)json_data.get("epoch")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; the field epoch was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; the field epoch had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // full
            this.full = (String)json_data.get("full");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; the field full was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; the field full had the wrong structure.");
    		e.printStackTrace();
        }
        
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
            // second
            this.second = ((Number)json_data.get("second")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; the field second was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; the field second had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // day
            this.day = ((Number)json_data.get("day")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; the field day was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; the field day had the wrong structure.");
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
        
	}	
}