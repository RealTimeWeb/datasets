package corgis.baseball.domain;

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
public class Birth {
	
    private String city;
    private String country;
    private Integer month;
    private String state;
    private Integer year;
    private Integer day;
    
    
    /*
     * @return 
     */
    public String getCity() {
        return this.city;
    }
    
    
    
    /*
     * @return 
     */
    public String getCountry() {
        return this.country;
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
    public String getState() {
        return this.state;
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
    
    
    
	
	/**
	 * Creates a string based representation of this Birth.
	
	 * @return String
	 */
	public String toString() {
		return "Birth[" +city+", "+country+", "+month+", "+state+", "+year+", "+day+"]";
	}
	
	/**
	 * Internal constructor to create a Birth from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Birth(JSONObject json_data) {
        try {// city
            this.city = (String)json_data.get("city");// country
            this.country = (String)json_data.get("country");// month
            this.month = new Integer(((Long)json_data.get("month")).intValue());// state
            this.state = (String)json_data.get("state");// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());// day
            this.day = new Integer(((Long)json_data.get("day")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Birth; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Birth; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}