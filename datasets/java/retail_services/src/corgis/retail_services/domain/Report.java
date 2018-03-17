package corgis.retail_services.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.retail_services.domain.Data;
import corgis.retail_services.domain.Time;

/**
 * 
 */
public class Report {
	
    // Numbers represent millions of dollars
    private Data data;
    private Time time;
    
    
    /**
     * Numbers represent millions of dollars
     * @return Data
     */
    public Data getData() {
        return this.data;
    }
    
    
    
    /**
     * 
     * @return Time
     */
    public Time getTime() {
        return this.time;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Report.
	
	 * @return String
	 */
	public String toString() {
		return "Report[" +data+", "+time+"]";
	}
	
	/**
	 * Internal constructor to create a Report from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Report(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // data
            this.data = new Data((JSONObject)json_data.get("data"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field data was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field data had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // time
            this.time = new Time((JSONObject)json_data.get("time"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field time was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field time had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}