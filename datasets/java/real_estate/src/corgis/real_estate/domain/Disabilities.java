package corgis.real_estate.domain;

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
public class Disabilities {
	
    private String ansiUsable;
    private String adaAccessible;
    
    
    /**
     * 
     * @return String
     */
    public String getAnsiUsable() {
        return this.ansiUsable;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getAdaAccessible() {
        return this.adaAccessible;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Disabilities.
	
	 * @return String
	 */
	public String toString() {
		return "Disabilities[" +ansiUsable+", "+adaAccessible+"]";
	}
	
	/**
	 * Internal constructor to create a Disabilities from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Disabilities(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // ansi usable
            this.ansiUsable = (String)json_data.get("ansi usable");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Disabilities; the field ansiUsable was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Disabilities; the field ansiUsable had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // ADA Accessible
            this.adaAccessible = (String)json_data.get("ADA Accessible");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Disabilities; the field adaAccessible was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Disabilities; the field adaAccessible had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}