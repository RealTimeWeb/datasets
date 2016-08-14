package corgis.scripts.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.scripts.domain.Data;

/**
 * 
 */
public class Script {
	
    private Data data;
    private String name;
    
    
    /*
     * @return 
     */
    public Data getData() {
        return this.data;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Script.
	
	 * @return String
	 */
	public String toString() {
		return "Script[" +data+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a Script from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Script(JSONObject json_data) {
        try {// data
            this.data = new Data((JSONObject)json_data.get("data"));// name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Script; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Script; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}