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
	
    private Integer year;
    private Boolean isStarted;
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getIsStarted() {
        return this.isStarted;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Started.
	
	 * @return String
	 */
	public String toString() {
		return "Started[" +year+", "+isStarted+"]";
	}
	
	/**
	 * Internal constructor to create a Started from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Started(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // year
            this.year = ((Number)json_data.get("year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Started; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Started; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // is started
            this.isStarted = (Boolean)json_data.get("is started");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Started; the field isStarted was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Started; the field isStarted had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}