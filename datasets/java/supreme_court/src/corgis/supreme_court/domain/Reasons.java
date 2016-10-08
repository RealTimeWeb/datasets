package corgis.supreme_court.domain;

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
public class Reasons {
	
    private String reason;
    private Integer id;
    
    
    /*
     * @return 
     */
    public String getReason() {
        return this.reason;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Reasons.
	
	 * @return String
	 */
	public String toString() {
		return "Reasons[" +reason+", "+id+"]";
	}
	
	/**
	 * Internal constructor to create a Reasons from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Reasons(JSONObject json_data) {
        try {// reason
            this.reason = (String)json_data.get("reason");// id
            this.id = ((Number)json_data.get("id")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Reasons; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Reasons; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}