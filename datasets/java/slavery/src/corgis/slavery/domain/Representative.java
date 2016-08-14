package corgis.slavery.domain;

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
public class Representative {
	
    private String name;
    private String relationshipToBuyer;
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /*
     * @return 
     */
    public String getRelationshipToBuyer() {
        return this.relationshipToBuyer;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Representative.
	
	 * @return String
	 */
	public String toString() {
		return "Representative[" +name+", "+relationshipToBuyer+"]";
	}
	
	/**
	 * Internal constructor to create a Representative from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Representative(JSONObject json_data) {
        try {// name
            this.name = (String)json_data.get("name");// relationship to buyer
            this.relationshipToBuyer = (String)json_data.get("relationship to buyer");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Representative; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Representative; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}