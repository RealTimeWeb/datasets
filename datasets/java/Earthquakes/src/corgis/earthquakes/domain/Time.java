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
	
    private String full;
    private Integer hour;
    private Long epoch;
    private Integer month;
    private Integer second;
    private Integer year;
    private Integer day;
    private Integer minute;
    
    
    /*
     * @return 
     */
    public String getFull() {
        return this.full;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHour() {
        return this.hour;
    }
    
    
    
    /*
     * @return 
     */
    public Long getEpoch() {
        return this.epoch;
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
    public Integer getSecond() {
        return this.second;
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
    public Integer getMinute() {
        return this.minute;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Time.
	
	 * @return String
	 */
	public String toString() {
		return "Time[" +full+", "+hour+", "+epoch+", "+month+", "+second+", "+year+", "+day+", "+minute+"]";
	}
	
	/**
	 * Internal constructor to create a Time from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Time(JSONObject json_data) {
        try {// full
            this.full = (String)json_data.get("full");// hour
            this.hour = new Integer(((Long)json_data.get("hour")).intValue());// epoch
            this.epoch = (Long)json_data.get("epoch");// month
            this.month = new Integer(((Long)json_data.get("month")).intValue());// second
            this.second = new Integer(((Long)json_data.get("second")).intValue());// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());// day
            this.day = new Integer(((Long)json_data.get("day")).intValue());// minute
            this.minute = new Integer(((Long)json_data.get("minute")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}