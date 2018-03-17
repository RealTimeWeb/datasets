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
public class AdminAction {
	
    private Integer id;
    private String state;
    private String agency;
    
    
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
    public String getAgency() {
        return this.agency;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this AdminAction.
	
	 * @return String
	 */
	public String toString() {
		return "AdminAction[" +id+", "+state+", "+agency+"]";
	}
	
	/**
	 * Internal constructor to create a AdminAction from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public AdminAction(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // id
            this.id = ((Number)json_data.get("id")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a AdminAction; the field id was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a AdminAction; the field id had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // state
            this.state = (String)json_data.get("state");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a AdminAction; the field state was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a AdminAction; the field state had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // agency
            this.agency = (String)json_data.get("agency");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a AdminAction; the field agency was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a AdminAction; the field agency had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}