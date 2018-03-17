package corgis.school_scores.domain;

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
public class State {
	
    // The two-letter abbreviation of the state for thsi report.
    private String code;
    // The full name of the state for this report.
    private String name;
    
    
    /**
     * The two-letter abbreviation of the state for thsi report.
     * @return String
     */
    public String getCode() {
        return this.code;
    }
    
    
    
    /**
     * The full name of the state for this report.
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this State.
	
	 * @return String
	 */
	public String toString() {
		return "State[" +code+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a State from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public State(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Code
            this.code = (String)json_data.get("Code");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a State; the field code was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a State; the field code had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Name
            this.name = (String)json_data.get("Name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a State; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a State; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}