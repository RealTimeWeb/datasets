package corgis.labor.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.labor.domain.Data;
import corgis.labor.domain.Time;

/**
 * 
 */
public class Result {
	
    // If the data is not a rate, then it is presented as the number in thousands
    private Data data;
    private Time time;
    
    
    /*
     * @return 
     */
    public Data getData() {
        return this.data;
    }
    
    
    
    /*
     * @return 
     */
    public Time getTime() {
        return this.time;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Result.
	
	 * @return String
	 */
	public String toString() {
		return "Result[" +data+", "+time+"]";
	}
	
	/**
	 * Internal constructor to create a Result from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Result(JSONObject json_data) {
        try {// Data
            this.data = new Data((JSONObject)json_data.get("Data"));// Time
            this.time = new Time((JSONObject)json_data.get("Time"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Result; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Result; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}