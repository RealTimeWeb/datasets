package corgis.billionaires.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.billionaires.domain.How;

/**
 * 
 */
public class Wealth {
	
    private How how;
    // The number of billion of dollars that this billionaire is worth.
    private Double worthInBillions;
    // The type of billionaire that they are.
    private String type;
    
    
    /**
     * 
     * @return How
     */
    public How getHow() {
        return this.how;
    }
    
    
    
    /**
     * The number of billion of dollars that this billionaire is worth.
     * @return Double
     */
    public Double getWorthInBillions() {
        return this.worthInBillions;
    }
    
    
    
    /**
     * The type of billionaire that they are.
     * @return String
     */
    public String getType() {
        return this.type;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Wealth.
	
	 * @return String
	 */
	public String toString() {
		return "Wealth[" +how+", "+worthInBillions+", "+type+"]";
	}
	
	/**
	 * Internal constructor to create a Wealth from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Wealth(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // how
            this.how = new How((JSONObject)json_data.get("how"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Wealth; the field how was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Wealth; the field how had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // worth in billions
            this.worthInBillions = ((Number)json_data.get("worth in billions")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Wealth; the field worthInBillions was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Wealth; the field worthInBillions had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // type
            this.type = (String)json_data.get("type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Wealth; the field type was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Wealth; the field type had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}