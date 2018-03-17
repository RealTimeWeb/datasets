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
public class Case_ {
	
    private String disposition;
    private Boolean unusual;
    
    
    /**
     * 
     * @return String
     */
    public String getDisposition() {
        return this.disposition;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getUnusual() {
        return this.unusual;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Case.
	
	 * @return String
	 */
	public String toString() {
		return "Case[" +disposition+", "+unusual+"]";
	}
	
	/**
	 * Internal constructor to create a Case from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Case_(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // disposition
            this.disposition = (String)json_data.get("disposition");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Case; the field disposition was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Case; the field disposition had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // unusual
            this.unusual = (Boolean)json_data.get("unusual");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Case; the field unusual was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Case; the field unusual had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}