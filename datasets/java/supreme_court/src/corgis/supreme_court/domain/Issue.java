package corgis.supreme_court.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.supreme_court.domain.Area;

/**
 * 
 */
public class Issue {
	
    private String text;
    private Integer id;
    private Area area;
    
    
    /*
     * @return 
     */
    public String getText() {
        return this.text;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public Area getArea() {
        return this.area;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Issue.
	
	 * @return String
	 */
	public String toString() {
		return "Issue[" +text+", "+id+", "+area+"]";
	}
	
	/**
	 * Internal constructor to create a Issue from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Issue(JSONObject json_data) {
        try {// text
            this.text = (String)json_data.get("text");// id
            this.id = new Integer(((Long)json_data.get("id")).intValue());// area
            this.area = new Area((JSONObject)json_data.get("area"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Issue; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Issue; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}