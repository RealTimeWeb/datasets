package corgis.businesses.domain;

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
public class Votes {
	
    private Integer funny;
    private Integer useful;
    private Integer cool;
    
    
    /*
     * @return 
     */
    public Integer getFunny() {
        return this.funny;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUseful() {
        return this.useful;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCool() {
        return this.cool;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Votes.
	
	 * @return String
	 */
	public String toString() {
		return "Votes[" +funny+", "+useful+", "+cool+"]";
	}
	
	/**
	 * Internal constructor to create a Votes from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Votes(JSONObject json_data) {
        try {// funny
            this.funny = new Integer(((Long)json_data.get("funny")).intValue());// useful
            this.useful = new Integer(((Long)json_data.get("useful")).intValue());// cool
            this.cool = new Integer(((Long)json_data.get("cool")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Votes; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Votes; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}