package corgis.classics.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.classics.domain.Types;

/**
 * 
 */
public class Formats {
	
    private Integer total;
    private Types types;
    
    
    /*
     * @return 
     */
    public Integer getTotal() {
        return this.total;
    }
    
    
    
    /*
     * @return 
     */
    public Types getTypes() {
        return this.types;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Formats.
	
	 * @return String
	 */
	public String toString() {
		return "Formats[" +total+", "+types+"]";
	}
	
	/**
	 * Internal constructor to create a Formats from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Formats(JSONObject json_data) {
        try {
            this.total = (Integer)json_data.get("total");
            this.types = new Types((JSONObject)json_data.get("types"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Formats; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Formats; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}