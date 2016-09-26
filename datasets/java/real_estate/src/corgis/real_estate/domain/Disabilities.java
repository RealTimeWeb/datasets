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
    private String abaAccessible;
    
    
    /*
     * @return 
     */
    public String getAnsiUsable() {
        return this.ansiUsable;
    }
    
    
    
    /*
     * @return 
     */
    public String getAbaAccessible() {
        return this.abaAccessible;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Disabilities.
	
	 * @return String
	 */
	public String toString() {
		return "Disabilities[" +ansiUsable+", "+abaAccessible+"]";
	}
	
	/**
	 * Internal constructor to create a Disabilities from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Disabilities(JSONObject json_data) {
        try {// ansi usable
            this.ansiUsable = (String)json_data.get("ansi usable");// aba accessible
            this.abaAccessible = (String)json_data.get("aba accessible");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Disabilities; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Disabilities; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}