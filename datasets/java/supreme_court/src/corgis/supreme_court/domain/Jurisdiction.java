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
public class Jurisdiction {
	
    private Integer id;
    private String manner;
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public String getManner() {
        return this.manner;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Jurisdiction.
	
	 * @return String
	 */
	public String toString() {
		return "Jurisdiction[" +id+", "+manner+"]";
	}
	
	/**
	 * Internal constructor to create a Jurisdiction from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Jurisdiction(JSONObject json_data) {
        try {// id
            this.id = ((Number)json_data.get("id")).intValue();// manner
            this.manner = (String)json_data.get("manner");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Jurisdiction; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Jurisdiction; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}