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
public class Petitioner {
	
    private String state;
    private Integer id;
    private String entity;
    
    
    /*
     * @return 
     */
    public String getState() {
        return this.state;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public String getEntity() {
        return this.entity;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Petitioner.
	
	 * @return String
	 */
	public String toString() {
		return "Petitioner[" +state+", "+id+", "+entity+"]";
	}
	
	/**
	 * Internal constructor to create a Petitioner from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Petitioner(JSONObject json_data) {
        try {// state
            this.state = (String)json_data.get("state");// id
            this.id = ((Number)json_data.get("id")).intValue();// entity
            this.entity = (String)json_data.get("entity");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Petitioner; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Petitioner; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}