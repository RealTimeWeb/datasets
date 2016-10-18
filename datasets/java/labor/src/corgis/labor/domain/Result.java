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

/**
 * 
 */
public class Result {
	
    private Integer year;
    private Data data;
    private Integer month;
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
    /*
     * @return 
     */
    public Data getData() {
        return this.data;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMonth() {
        return this.month;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Result.
	
	 * @return String
	 */
	public String toString() {
		return "Result[" +year+", "+data+", "+month+"]";
	}
	
	/**
	 * Internal constructor to create a Result from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Result(JSONObject json_data) {
        try {// year
            this.year = ((Number)json_data.get("year")).intValue();// data
            this.data = new Data((JSONObject)json_data.get("data"));// month
            this.month = ((Number)json_data.get("month")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Result; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Result; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}