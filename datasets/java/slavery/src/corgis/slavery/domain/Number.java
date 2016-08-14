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
public class Number {
	
    private String prices;
    private String total;
    private String adults;
    private String children;
    
    
    /*
     * @return 
     */
    public String getPrices() {
        return this.prices;
    }
    
    
    
    /*
     * @return 
     */
    public String getTotal() {
        return this.total;
    }
    
    
    
    /*
     * @return 
     */
    public String getAdults() {
        return this.adults;
    }
    
    
    
    /*
     * @return 
     */
    public String getChildren() {
        return this.children;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Number.
	
	 * @return String
	 */
	public String toString() {
		return "Number[" +prices+", "+total+", "+adults+", "+children+"]";
	}
	
	/**
	 * Internal constructor to create a Number from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Number(JSONObject json_data) {
        try {// prices
            this.prices = (String)json_data.get("prices");// total
            this.total = (String)json_data.get("total");// adults
            this.adults = (String)json_data.get("adults");// children
            this.children = (String)json_data.get("children");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Number; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Number; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}