package corgis.tate.domain;

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
	
    private String location;
    // The year that the artist was born. If the year is unknown, it was replaced with "0".
    private Integer year;
    
    
    /*
     * @return 
     */
    public String getLocation() {
        return this.location;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Birth.
	
	 * @return String
	 */
	public String toString() {
		return "Birth[" +location+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Birth from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Birth(JSONObject json_data) {
        try {// location
            this.location = (String)json_data.get("location");// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Birth; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Birth; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}