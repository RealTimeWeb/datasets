package corgis.supremecourt.domain;

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
public class Citation {
	
    private String sct;
    private String led;
    private String lexis;
    private String us;
    
    
    /*
     * @return 
     */
    public String getSct() {
        return this.sct;
    }
    
    
    
    /*
     * @return 
     */
    public String getLed() {
        return this.led;
    }
    
    
    
    /*
     * @return 
     */
    public String getLexis() {
        return this.lexis;
    }
    
    
    
    /*
     * @return 
     */
    public String getUs() {
        return this.us;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Citation.
	
	 * @return String
	 */
	public String toString() {
		return "Citation[" +sct+", "+led+", "+lexis+", "+us+"]";
	}
	
	/**
	 * Internal constructor to create a Citation from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Citation(JSONObject json_data) {
        try {// sct
            this.sct = (String)json_data.get("sct");// led
            this.led = (String)json_data.get("led");// lexis
            this.lexis = (String)json_data.get("lexis");// us
            this.us = (String)json_data.get("us");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Citation; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Citation; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}