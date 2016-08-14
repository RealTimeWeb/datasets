package corgis.labor.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.labor.domain.All;

/**
 * 
 */
public class BlackOrAfricanAmerican {
	
    private All all;
    
    
    /*
     * @return 
     */
    public All getAll() {
        return this.all;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this BlackOrAfricanAmerican.
	
	 * @return String
	 */
	public String toString() {
		return "BlackOrAfricanAmerican[" +all+"]";
	}
	
	/**
	 * Internal constructor to create a BlackOrAfricanAmerican from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public BlackOrAfricanAmerican(JSONObject json_data) {
        try {// All
            this.all = new All((JSONObject)json_data.get("All"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a BlackOrAfricanAmerican; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a BlackOrAfricanAmerican; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}