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
    private Integer second;
    private Integer month;
    // A number that represents the time that this earthquake occurred. Epoch's are the number of seconds since a particular date (January 1st, 1970), and are a convenient way to store date/times.
    private Long epoch;
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
    public Integer getSecond() {
        return this.second;
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
    public Long getEpoch() {
        return this.epoch;
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
		return "Time[" +full+", "+hour+", "+second+", "+month+", "+epoch+", "+year+", "+day+", "+minute+"]";
	}
	
	/**
	 * Internal constructor to create a Time from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Time(JSONObject json_data) {
        try {// full
            this.full = (String)json_data.get("full");// hour
            this.hour = ((Number)json_data.get("hour")).intValue();// second
            this.second = ((Number)json_data.get("second")).intValue();// month
            this.month = ((Number)json_data.get("month")).intValue();// epoch
            this.epoch = ((Number)json_data.get("epoch")).longValue();// year
            this.year = ((Number)json_data.get("year")).intValue();// day
            this.day = ((Number)json_data.get("day")).intValue();// minute
            this.minute = ((Number)json_data.get("minute")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Time; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Time; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}