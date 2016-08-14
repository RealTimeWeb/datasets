package corgis.slavery.domain;

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
public class Guarantee {
	
    private String notes;
    private String guaranteed;
    
    
    /*
     * @return 
     */
    public String getNotes() {
        return this.notes;
    }
    
    
    
    /*
     * @return 
     */
    public String getGuaranteed() {
        return this.guaranteed;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Guarantee.
	
	 * @return String
	 */
	public String toString() {
		return "Guarantee[" +notes+", "+guaranteed+"]";
	}
	
	/**
	 * Internal constructor to create a Guarantee from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Guarantee(JSONObject json_data) {
        try {// notes
            this.notes = (String)json_data.get("notes");// guaranteed
            this.guaranteed = (String)json_data.get("guaranteed");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Guarantee; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Guarantee; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}