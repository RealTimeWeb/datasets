package corgis.classics.domain;

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
public class Author {
	
    private Integer death;
    private String name;
    private Integer birth;
    
    
    /*
     * @return 
     */
    public Integer getDeath() {
        return this.death;
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
    public Integer getBirth() {
        return this.birth;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Author.
	
	 * @return String
	 */
	public String toString() {
		return "Author[" +death+", "+name+", "+birth+"]";
	}
	
	/**
	 * Internal constructor to create a Author from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Author(JSONObject json_data) {
        try {// Death
            this.death = new Integer(((Long)json_data.get("Death")).intValue());// Name
            this.name = (String)json_data.get("Name");// Birth
            this.birth = new Integer(((Long)json_data.get("Birth")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Author; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Author; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}