package corgis.soccer.domain;

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
public class Away {
	
    private Integer score;
    private String code;
    private String name;
    private String key;
    
    
    /*
     * @return 
     */
    public Integer getScore() {
        return this.score;
    }
    
    
    
    /*
     * @return 
     */
    public String getCode() {
        return this.code;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /*
     * @return 
     */
    public String getKey() {
        return this.key;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Away.
	
	 * @return String
	 */
	public String toString() {
		return "Away[" +score+", "+code+", "+name+", "+key+"]";
	}
	
	/**
	 * Internal constructor to create a Away from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Away(JSONObject json_data) {
        try {// score
            this.score = new Integer(((Long)json_data.get("score")).intValue());// code
            this.code = (String)json_data.get("code");// name
            this.name = (String)json_data.get("name");// key
            this.key = (String)json_data.get("key");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Away; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Away; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}