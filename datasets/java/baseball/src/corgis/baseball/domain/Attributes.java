package corgis.baseball.domain;

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
public class Attributes {
	
    private String bats;
    private String throws;
    private Integer weight;
    private Integer height;
    
    
    /*
     * @return 
     */
    public String getBats() {
        return this.bats;
    }
    
    
    
    /*
     * @return 
     */
    public String getThrows() {
        return this.throws;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWeight() {
        return this.weight;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHeight() {
        return this.height;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Attributes.
	
	 * @return String
	 */
	public String toString() {
		return "Attributes[" +bats+", "+throws+", "+weight+", "+height+"]";
	}
	
	/**
	 * Internal constructor to create a Attributes from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Attributes(JSONObject json_data) {
        try {// bats
            this.bats = (String)json_data.get("bats");// throws
            this.throws = (String)json_data.get("throws");// weight
            this.weight = new Integer(((Long)json_data.get("weight")).intValue());// height
            this.height = new Integer(((Long)json_data.get("height")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Attributes; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Attributes; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}