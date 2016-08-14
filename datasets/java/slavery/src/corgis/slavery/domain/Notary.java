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
public class Notary {
	
    private String lastName;
    private String firstName;
    
    
    /*
     * @return 
     */
    public String getLastName() {
        return this.lastName;
    }
    
    
    
    /*
     * @return 
     */
    public String getFirstName() {
        return this.firstName;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Notary.
	
	 * @return String
	 */
	public String toString() {
		return "Notary[" +lastName+", "+firstName+"]";
	}
	
	/**
	 * Internal constructor to create a Notary from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Notary(JSONObject json_data) {
        try {// last name
            this.lastName = (String)json_data.get("last name");// first name
            this.firstName = (String)json_data.get("first name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Notary; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Notary; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}