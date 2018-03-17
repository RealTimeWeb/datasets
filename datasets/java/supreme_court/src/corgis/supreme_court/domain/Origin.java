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
public class Origin {
	
    private Integer id;
    private String state;
    private String name;
    
    
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
     * 
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Origin.
	
	 * @return String
	 */
	public String toString() {
		return "Origin[" +id+", "+state+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a Origin from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Origin(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // id
            this.id = ((Number)json_data.get("id")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Origin; the field id was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Origin; the field id had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // state
            this.state = (String)json_data.get("state");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Origin; the field state was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Origin; the field state had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Origin; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Origin; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}