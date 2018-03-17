package corgis.medal_of_honor.domain;

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
public class Metadata {
	
    private String link;
    
    
    /**
     * 
     * @return String
     */
    public String getLink() {
        return this.link;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Metadata.
	
	 * @return String
	 */
	public String toString() {
		return "Metadata[" +link+"]";
	}
	
	/**
	 * Internal constructor to create a Metadata from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Metadata(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // link
            this.link = (String)json_data.get("link");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; the field link was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; the field link had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}