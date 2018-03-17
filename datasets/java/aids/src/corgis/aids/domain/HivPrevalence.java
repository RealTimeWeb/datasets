package corgis.aids.domain;

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
public class HivPrevalence {
	
    // The percentage of the population of Young Men (15-24 years old) suffering from AIDS in this year.
    private Double youngMen;
    // The percentage of the population of Young Men (15-49 years old) suffering from AIDS in this year.
    private Double adults;
    // The percentage of the population of Young Women (15-24 years old) suffering from AIDS in this year.
    private Double youngWomen;
    
    
    /**
     * The percentage of the population of Young Men (15-24 years old) suffering from AIDS in this year.
     * @return Double
     */
    public Double getYoungMen() {
        return this.youngMen;
    }
    
    
    
    /**
     * The percentage of the population of Young Men (15-49 years old) suffering from AIDS in this year.
     * @return Double
     */
    public Double getAdults() {
        return this.adults;
    }
    
    
    
    /**
     * The percentage of the population of Young Women (15-24 years old) suffering from AIDS in this year.
     * @return Double
     */
    public Double getYoungWomen() {
        return this.youngWomen;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this HivPrevalence.
	
	 * @return String
	 */
	public String toString() {
		return "HivPrevalence[" +youngMen+", "+adults+", "+youngWomen+"]";
	}
	
	/**
	 * Internal constructor to create a HivPrevalence from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public HivPrevalence(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Young Men
            this.youngMen = ((Number)json_data.get("Young Men")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a HivPrevalence; the field youngMen was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a HivPrevalence; the field youngMen had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Adults
            this.adults = ((Number)json_data.get("Adults")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a HivPrevalence; the field adults was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a HivPrevalence; the field adults had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Young Women
            this.youngWomen = ((Number)json_data.get("Young Women")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a HivPrevalence; the field youngWomen was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a HivPrevalence; the field youngWomen had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}