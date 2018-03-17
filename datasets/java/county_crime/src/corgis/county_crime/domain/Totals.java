package corgis.county_crime.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.county_crime.domain.Violent;
import corgis.county_crime.domain.Property;

/**
 * 
 */
public class Totals {
	
    private Violent violent;
    private Property property;
    
    
    /**
     * 
     * @return Violent
     */
    public Violent getViolent() {
        return this.violent;
    }
    
    
    
    /**
     * 
     * @return Property
     */
    public Property getProperty() {
        return this.property;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Totals.
	
	 * @return String
	 */
	public String toString() {
		return "Totals[" +violent+", "+property+"]";
	}
	
	/**
	 * Internal constructor to create a Totals from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Totals(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Violent
            this.violent = new Violent((JSONObject)json_data.get("Violent"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field violent was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field violent had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Property
            this.property = new Property((JSONObject)json_data.get("Property"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field property was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field property had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}