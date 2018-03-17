package corgis.medal_of_honor.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.medal_of_honor.domain.Date;

/**
 * 
 */
public class Birth {
	
    private Date date;
    private String locationName;
    
    
    /**
     * 
     * @return Date
     */
    public Date getDate() {
        return this.date;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getLocationName() {
        return this.locationName;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Birth.
	
	 * @return String
	 */
	public String toString() {
		return "Birth[" +date+", "+locationName+"]";
	}
	
	/**
	 * Internal constructor to create a Birth from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Birth(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // date
            this.date = new Date((JSONObject)json_data.get("date"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Birth; the field date was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Birth; the field date had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // location name
            this.locationName = (String)json_data.get("location name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Birth; the field locationName was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Birth; the field locationName had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}