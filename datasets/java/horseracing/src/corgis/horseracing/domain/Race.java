package corgis.horseracing.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.horseracing.domain.Data;

/**
 * 
 */
public class Race {
	
    private Data data;
    private String year;
    
    
    /*
     * @return 
     */
    public Data getData() {
        return this.data;
    }
    
    
    
    /*
     * @return 
     */
    public String getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Race.
	
	 * @return String
	 */
	public String toString() {
		return "Race[" +data+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Race from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Race(JSONObject json_data) {
        try {// data
            this.data = new Data((JSONObject)json_data.get("data"));// year
            this.year = (String)json_data.get("year");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Race; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Race; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}