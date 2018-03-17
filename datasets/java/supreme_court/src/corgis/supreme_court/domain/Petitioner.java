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
	
    private String entity;
    private Integer id;
    private String state;
    
    
    /**
     * 
     * @return String
     */
    public String getEntity() {
        return this.entity;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getState() {
        return this.state;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Petitioner.
	
	 * @return String
	 */
	public String toString() {
		return "Petitioner[" +entity+", "+id+", "+state+"]";
	}
	
	/**
	 * Internal constructor to create a Petitioner from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Petitioner(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // entity
            this.entity = (String)json_data.get("entity");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Petitioner; the field entity was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Petitioner; the field entity had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // id
            this.id = ((Number)json_data.get("id")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Petitioner; the field id was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Petitioner; the field id had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // state
            this.state = (String)json_data.get("state");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Petitioner; the field state was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Petitioner; the field state had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}