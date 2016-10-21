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
	
    private Double worthInBillions;
    private How how;
    private String type;
    
    
    /*
     * @return 
     */
    public Double getWorthInBillions() {
        return this.worthInBillions;
    }
    
    
    
    /*
     * @return 
     */
    public How getHow() {
        return this.how;
    }
    
    
    
    /*
     * @return 
     */
    public String getType() {
        return this.type;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Wealth.
	
	 * @return String
	 */
	public String toString() {
		return "Wealth[" +worthInBillions+", "+how+", "+type+"]";
	}
	
	/**
	 * Internal constructor to create a Wealth from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Wealth(JSONObject json_data) {
        try {// worth in billions
            this.worthInBillions = ((Number)json_data.get("worth in billions")).doubleValue();// how
            this.how = new How((JSONObject)json_data.get("how"));// type
            this.type = (String)json_data.get("type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Wealth; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Wealth; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}