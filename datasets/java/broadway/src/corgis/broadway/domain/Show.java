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
    
    
    /**
     * Whether it is a "Musical", "Play", or "Special".
     * @return String
     */
    public String getType() {
        return this.type;
    }
    
    
    
    /**
     * The name of the production.
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /**
     * The name of the theatre.
     * @return String
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
        //System.out.println(json_data);
        
        try {
            // Type
            this.type = (String)json_data.get("Type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Show; the field type was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Show; the field type had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Name
            this.name = (String)json_data.get("Name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Show; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Show; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Theatre
            this.theatre = (String)json_data.get("Theatre");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Show; the field theatre was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Show; the field theatre had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}