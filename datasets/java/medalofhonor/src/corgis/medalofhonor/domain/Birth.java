package corgis.medalofhonor.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.medalofhonor.domain.Date;

/**
 * 
 */
public class Birth {
	
    private Date date;
    private String location;
    
    
    /*
     * @return 
     */
    public Date getDate() {
        return this.date;
    }
    
    
    
    /*
     * @return 
     */
    public String getLocation() {
        return this.location;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Birth.
	
	 * @return String
	 */
	public String toString() {
		return "Birth[" +date+", "+location+"]";
	}
	
	/**
	 * Internal constructor to create a Birth from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Birth(JSONObject json_data) {
        try {// date
            this.date = new Date((JSONObject)json_data.get("date"));// location
            this.location = (String)json_data.get("location");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Birth; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Birth; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}