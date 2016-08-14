package corgis.skyscrapers.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.skyscrapers.domain.Started;
import corgis.skyscrapers.domain.Completed;

/**
 * 
 */
public class Status {
	
    private String current;
    private Started started;
    private Completed completed;
    
    
    /*
     * @return 
     */
    public String getCurrent() {
        return this.current;
    }
    
    
    
    /*
     * @return 
     */
    public Started getStarted() {
        return this.started;
    }
    
    
    
    /*
     * @return 
     */
    public Completed getCompleted() {
        return this.completed;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Status.
	
	 * @return String
	 */
	public String toString() {
		return "Status[" +current+", "+started+", "+completed+"]";
	}
	
	/**
	 * Internal constructor to create a Status from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Status(JSONObject json_data) {
        try {// current
            this.current = (String)json_data.get("current");// started
            this.started = new Started((JSONObject)json_data.get("started"));// completed
            this.completed = new Completed((JSONObject)json_data.get("completed"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Status; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Status; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}