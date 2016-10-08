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
public class Area {
	
    private Integer id;
    private String area;
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public String getArea() {
        return this.area;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Area.
	
	 * @return String
	 */
	public String toString() {
		return "Area[" +id+", "+area+"]";
	}
	
	/**
	 * Internal constructor to create a Area from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Area(JSONObject json_data) {
        try {// id
            this.id = ((Number)json_data.get("id")).intValue();// area
            this.area = (String)json_data.get("area");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Area; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Area; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}