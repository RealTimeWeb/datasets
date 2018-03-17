package corgis.injuries.domain;

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
public class Business {
	
    private String name;
    private String secondName;
    
    
    /**
     * 
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getSecondName() {
        return this.secondName;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Business.
	
	 * @return String
	 */
	public String toString() {
		return "Business[" +name+", "+secondName+"]";
	}
	
	/**
	 * Internal constructor to create a Business from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Business(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Business; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Business; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // second name
            this.secondName = (String)json_data.get("second name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Business; the field secondName was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Business; the field secondName had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}