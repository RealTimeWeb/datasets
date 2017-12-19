package corgis.broadway.domain;

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
public class Show {
	
    // Whether it is a "Musical", "Play", or "Special".
    private String type;
    // The name of the production.
    private String name;
    // The name of the theatre.
    private String theatre;
    
    
    /*
     * @return 
     */
    public String getType() {
        return this.type;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /*
     * @return 
     */
    public String getTheatre() {
        return this.theatre;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Show.
	
	 * @return String
	 */
	public String toString() {
		return "Show[" +type+", "+name+", "+theatre+"]";
	}
	
	/**
	 * Internal constructor to create a Show from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Show(JSONObject json_data) {
        System.out.println(json_data);
        try {// Type
            this.type = (String)json_data.get("Type");// Name
            this.name = (String)json_data.get("Name");// Theatre
            this.theatre = (String)json_data.get("Theatre");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Show; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Show; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}