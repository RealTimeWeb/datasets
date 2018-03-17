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
public class Citation {
	
    private String lexis;
    private String us;
    private String led;
    private String sct;
    
    
    /**
     * 
     * @return String
     */
    public String getLexis() {
        return this.lexis;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getUs() {
        return this.us;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getLed() {
        return this.led;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getSct() {
        return this.sct;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Citation.
	
	 * @return String
	 */
	public String toString() {
		return "Citation[" +lexis+", "+us+", "+led+", "+sct+"]";
	}
	
	/**
	 * Internal constructor to create a Citation from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Citation(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // lexis
            this.lexis = (String)json_data.get("lexis");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Citation; the field lexis was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Citation; the field lexis had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // us
            this.us = (String)json_data.get("us");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Citation; the field us was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Citation; the field us had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // led
            this.led = (String)json_data.get("led");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Citation; the field led was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Citation; the field led had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // sct
            this.sct = (String)json_data.get("sct");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Citation; the field sct was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Citation; the field sct had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}