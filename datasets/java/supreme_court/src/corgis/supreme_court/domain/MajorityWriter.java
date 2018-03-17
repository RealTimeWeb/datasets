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
public class MajorityWriter {
	
    private String longName;
    private String name;
    private Integer id;
    
    
    /**
     * 
     * @return String
     */
    public String getLongName() {
        return this.longName;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this MajorityWriter.
	
	 * @return String
	 */
	public String toString() {
		return "MajorityWriter[" +longName+", "+name+", "+id+"]";
	}
	
	/**
	 * Internal constructor to create a MajorityWriter from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public MajorityWriter(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // long name
            this.longName = (String)json_data.get("long name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MajorityWriter; the field longName was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MajorityWriter; the field longName had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MajorityWriter; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MajorityWriter; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // id
            this.id = ((Number)json_data.get("id")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MajorityWriter; the field id was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MajorityWriter; the field id had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}