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
public class Death {
	
    private String location;
    // The year that the artist died. If the year is unknown, it was replaced with "0".
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
	 * Creates a string based representation of this Death.
	
	 * @return String
	 */
	public String toString() {
		return "Death[" +location+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Death from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Death(JSONObject json_data) {
        try {// location
            this.location = (String)json_data.get("location");// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Death; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Death; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}