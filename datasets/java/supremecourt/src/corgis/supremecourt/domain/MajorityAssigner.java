package corgis.supremecourt.domain;

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
public class MajorityAssigner {
	
    private Integer id;
    private String long;
    private String name;
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public String getLong() {
        return this.long;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this MajorityAssigner.
	
	 * @return String
	 */
	public String toString() {
		return "MajorityAssigner[" +id+", "+long+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a MajorityAssigner from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public MajorityAssigner(JSONObject json_data) {
        try {// id
            this.id = new Integer(((Long)json_data.get("id")).intValue());// long
            this.long = (String)json_data.get("long");// name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MajorityAssigner; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MajorityAssigner; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}