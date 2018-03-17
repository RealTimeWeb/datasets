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
	
    // Unknown value
    private Integer name;
    // The ID of the release (album) on the service 7digital.com
    private Integer id;
    
    
    /*
     * @return 
     */
    public Integer getName() {
        return this.name;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Release.
	
	 * @return String
	 */
	public String toString() {
		return "Release[" +name+", "+id+"]";
	}
	
	/**
	 * Internal constructor to create a Release from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Release(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // name
            this.name = ((Number)json_data.get("name")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Release; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Release; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // id
            this.id = ((Number)json_data.get("id")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Release; the field id was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Release; the field id had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}