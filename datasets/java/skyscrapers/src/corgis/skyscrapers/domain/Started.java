package corgis.skyscrapers.domain;

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
public class Started {
	
    private Boolean isStarted;
    private Integer year;
    
    
    /*
     * @return 
     */
    public Boolean getIsStarted() {
        return this.isStarted;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Started.
	
	 * @return String
	 */
	public String toString() {
		return "Started[" +isStarted+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Started from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Started(JSONObject json_data) {
        try {// is started
            this.isStarted = (Boolean)json_data.get("is started");// year
            this.year = new Integer(((Double)json_data.get("year")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Started; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Started; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}