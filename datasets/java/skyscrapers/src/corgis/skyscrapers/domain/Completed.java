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
public class Completed {
	
    private Boolean isCompleted;
    private Integer year;
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getIsCompleted() {
        return this.isCompleted;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Completed.
	
	 * @return String
	 */
	public String toString() {
		return "Completed[" +isCompleted+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Completed from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Completed(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // is completed
            this.isCompleted = (Boolean)json_data.get("is completed");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Completed; the field isCompleted was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Completed; the field isCompleted had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // year
            this.year = ((Number)json_data.get("year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Completed; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Completed; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}