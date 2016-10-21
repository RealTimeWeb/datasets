package corgis.immigration.domain;

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
public class Enforcement {
	
    private Integer nonCriminal;
    private Integer criminal;
    private Integer apprehended;
    private Integer inadmissable;
    
    
    /*
     * @return 
     */
    public Integer getNonCriminal() {
        return this.nonCriminal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCriminal() {
        return this.criminal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getApprehended() {
        return this.apprehended;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInadmissable() {
        return this.inadmissable;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Enforcement.
	
	 * @return String
	 */
	public String toString() {
		return "Enforcement[" +nonCriminal+", "+criminal+", "+apprehended+", "+inadmissable+"]";
	}
	
	/**
	 * Internal constructor to create a Enforcement from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Enforcement(JSONObject json_data) {
        try {// Non-criminal
            this.nonCriminal = ((Number)json_data.get("Non-criminal")).intValue();// Criminal
            this.criminal = ((Number)json_data.get("Criminal")).intValue();// Apprehended
            this.apprehended = ((Number)json_data.get("Apprehended")).intValue();// Inadmissable
            this.inadmissable = ((Number)json_data.get("Inadmissable")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Enforcement; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Enforcement; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}