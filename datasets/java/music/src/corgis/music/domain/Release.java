package corgis.music.domain;

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
public class Release {
	
    private Integer id;
    private String name;
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Release.
	
	 * @return String
	 */
	public String toString() {
		return "Release[" +id+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a Release from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Release(JSONObject json_data) {
        try {// id
            this.id = new Integer(((Long)json_data.get("id")).intValue());// name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Release; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Release; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}