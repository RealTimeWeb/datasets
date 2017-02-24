package corgis.graduates.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.graduates.domain.Degrees;

/**
 * 
 */
public class Education {
	
    // The name of the major for these graduated students.
    private String major;
    private Degrees degrees;
    
    
    /*
     * @return 
     */
    public String getMajor() {
        return this.major;
    }
    
    
    
    /*
     * @return 
     */
    public Degrees getDegrees() {
        return this.degrees;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Education.
	
	 * @return String
	 */
	public String toString() {
		return "Education[" +major+", "+degrees+"]";
	}
	
	/**
	 * Internal constructor to create a Education from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Education(JSONObject json_data) {
        try {// Major
            this.major = (String)json_data.get("Major");// Degrees
            this.degrees = new Degrees((JSONObject)json_data.get("Degrees"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}