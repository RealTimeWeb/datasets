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
public class AdminAction {
	
    private String state;
    private String agency;
    private Integer id;
    
    
    /*
     * @return 
     */
    public String getState() {
        return this.state;
    }
    
    
    
    /*
     * @return 
     */
    public String getAgency() {
        return this.agency;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this AdminAction.
	
	 * @return String
	 */
	public String toString() {
		return "AdminAction[" +state+", "+agency+", "+id+"]";
	}
	
	/**
	 * Internal constructor to create a AdminAction from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public AdminAction(JSONObject json_data) {
        try {// state
            this.state = (String)json_data.get("state");// agency
            this.agency = (String)json_data.get("agency");// id
            this.id = new Integer(((Long)json_data.get("id")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a AdminAction; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a AdminAction; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}