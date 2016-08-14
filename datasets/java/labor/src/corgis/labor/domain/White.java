package corgis.labor.domain;

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
public class White {
	
    private Integer all;
    
    
    /*
     * @return 
     */
    public Integer getAll() {
        return this.all;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this White.
	
	 * @return String
	 */
	public String toString() {
		return "White[" +all+"]";
	}
	
	/**
	 * Internal constructor to create a White from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public White(JSONObject json_data) {
        try {// All
            this.all = new Integer(((Long)json_data.get("All")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a White; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a White; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}