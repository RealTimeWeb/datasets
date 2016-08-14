package corgis.airlines.domain;

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
public class Airport {
	
    private String code;
    private String name;
    
    
    /*
     * @return 
     */
    public String getCode() {
        return this.code;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Airport.
	
	 * @return String
	 */
	public String toString() {
		return "Airport[" +code+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a Airport from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Airport(JSONObject json_data) {
        try {// code
            this.code = (String)json_data.get("code");// name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Airport; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Airport; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}