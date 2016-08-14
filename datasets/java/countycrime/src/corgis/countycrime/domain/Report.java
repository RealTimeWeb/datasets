package corgis.countycrime.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.countycrime.domain.Data;

/**
 * 
 */
public class Report {
	
    private String department;
    private String state;
    private Data data;
    private Integer year;
    
    
    /*
     * @return 
     */
    public String getDepartment() {
        return this.department;
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
    public Data getData() {
        return this.data;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Report.
	
	 * @return String
	 */
	public String toString() {
		return "Report[" +department+", "+state+", "+data+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Report from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Report(JSONObject json_data) {
        try {// Department
            this.department = (String)json_data.get("Department");// State
            this.state = (String)json_data.get("State");// Data
            this.data = new Data((JSONObject)json_data.get("Data"));// Year
            this.year = new Integer(((Long)json_data.get("Year")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}