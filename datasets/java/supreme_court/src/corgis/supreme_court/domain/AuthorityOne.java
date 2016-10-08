package corgis.supreme_court.domain;

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
public class AuthorityOne {
	
    private Integer id;
    private String authority;
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public String getAuthority() {
        return this.authority;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Authority1.
	
	 * @return String
	 */
	public String toString() {
		return "Authority1[" +id+", "+authority+"]";
	}
	
	/**
	 * Internal constructor to create a Authority1 from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public AuthorityOne(JSONObject json_data) {
        try {// id
            this.id = ((Number)json_data.get("id")).intValue();// authority
            this.authority = (String)json_data.get("authority");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Authority1; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Authority1; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}