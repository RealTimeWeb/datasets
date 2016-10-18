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
public class Disposition {
	
    private Integer id;
    private String disposition;
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public String getDisposition() {
        return this.disposition;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Disposition.
	
	 * @return String
	 */
	public String toString() {
		return "Disposition[" +id+", "+disposition+"]";
	}
	
	/**
	 * Internal constructor to create a Disposition from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Disposition(JSONObject json_data) {
        try {// id
            this.id = ((Number)json_data.get("id")).intValue();// disposition
            this.disposition = (String)json_data.get("disposition");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Disposition; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Disposition; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}