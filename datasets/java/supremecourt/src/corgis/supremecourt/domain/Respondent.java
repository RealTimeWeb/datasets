package corgis.supremecourt.domain;

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
public class Respondent {
	
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
	 * Creates a string based representation of this Respondent.
	
	 * @return String
	 */
	public String toString() {
		return "Respondent[" +state+", "+id+", "+entity+"]";
	}
	
	/**
	 * Internal constructor to create a Respondent from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Respondent(JSONObject json_data) {
        try {// state
            this.state = (String)json_data.get("state");// id
            this.id = new Integer(((Long)json_data.get("id")).intValue());// entity
            this.entity = (String)json_data.get("entity");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Respondent; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Respondent; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}