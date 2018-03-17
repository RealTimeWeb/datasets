package corgis.publishers.domain;

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
public class Publisher {
	
    // The name of the publisher.
    private String name;
    // The type, or size, of the publisher (e.g, "indie", "small", "big five", etc.)
    private String type;
    
    
    /**
     * The name of the publisher.
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /**
     * The type, or size, of the publisher (e.g, "indie", "small", "big five", etc.)
     * @return String
     */
    public String getType() {
        return this.type;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Publisher.
	
	 * @return String
	 */
	public String toString() {
		return "Publisher[" +name+", "+type+"]";
	}
	
	/**
	 * Internal constructor to create a Publisher from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Publisher(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Publisher; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Publisher; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // type
            this.type = (String)json_data.get("type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Publisher; the field type was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Publisher; the field type had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}