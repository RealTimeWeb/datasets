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
	
    // The type, or size, of the publisher (e.g, "indie", "small", "big five", etc.)
    private String type;
    // The name of the publisher.
    private String name;
    
    
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
    
    
    
	
	/**
	 * Creates a string based representation of this Publisher.
	
	 * @return String
	 */
	public String toString() {
		return "Publisher[" +type+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a Publisher from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Publisher(JSONObject json_data) {
        try {// type
            this.type = (String)json_data.get("type");// name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Publisher; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Publisher; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}