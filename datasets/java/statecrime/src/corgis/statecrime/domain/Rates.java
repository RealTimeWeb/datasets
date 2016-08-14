package corgis.statecrime.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.statecrime.domain.Violent;
import corgis.statecrime.domain.Property;

/**
 * 
 */
public class Rates {
	
    private Violent violent;
    private Property property;
    
    
    /*
     * @return 
     */
    public Violent getViolent() {
        return this.violent;
    }
    
    
    
    /*
     * @return 
     */
    public Property getProperty() {
        return this.property;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Rates.
	
	 * @return String
	 */
	public String toString() {
		return "Rates[" +violent+", "+property+"]";
	}
	
	/**
	 * Internal constructor to create a Rates from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Rates(JSONObject json_data) {
        try {// Violent
            this.violent = new Violent((JSONObject)json_data.get("Violent"));// Property
            this.property = new Property((JSONObject)json_data.get("Property"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Rates; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Rates; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}