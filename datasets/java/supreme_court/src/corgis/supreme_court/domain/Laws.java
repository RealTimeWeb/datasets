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
public class Laws {
	
    private String type;
    private Integer id;
    
    
    /*
     * @return 
     */
    public String getType() {
        return this.type;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Laws.
	
	 * @return String
	 */
	public String toString() {
		return "Laws[" +type+", "+id+"]";
	}
	
	/**
	 * Internal constructor to create a Laws from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Laws(JSONObject json_data) {
        try {// type
            this.type = (String)json_data.get("type");// id
            this.id = new Integer(((Long)json_data.get("id")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Laws; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Laws; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}