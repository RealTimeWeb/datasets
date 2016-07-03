package corgis.supremecourt.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.supremecourt.domain.Disposition;

/**
 * 
 */
public class Case {
	
    private Boolean unusual;
    private Disposition disposition;
    
    
    /*
     * @return 
     */
    public Boolean getUnusual() {
        return this.unusual;
    }
    
    
    
    /*
     * @return 
     */
    public Disposition getDisposition() {
        return this.disposition;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Case.
	
	 * @return String
	 */
	public String toString() {
		return "Case[" +unusual+", "+disposition+"]";
	}
	
	/**
	 * Internal constructor to create a Case from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Case(JSONObject json_data) {
        try {// unusual
            this.unusual = (Boolean)json_data.get("unusual");// disposition
            this.disposition = new Disposition((JSONObject)json_data.get("disposition"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Case; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Case; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}