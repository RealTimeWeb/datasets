package corgis.real_estate.domain;

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
public class History {
	
    private String status;
    private String type;
    
    
    /*
     * @return 
     */
    public String getStatus() {
        return this.status;
    }
    
    
    
    /*
     * @return 
     */
    public String getType() {
        return this.type;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this History.
	
	 * @return String
	 */
	public String toString() {
		return "History[" +status+", "+type+"]";
	}
	
	/**
	 * Internal constructor to create a History from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public History(JSONObject json_data) {
        try {// status
            this.status = (String)json_data.get("status");// type
            this.type = (String)json_data.get("type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a History; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a History; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}