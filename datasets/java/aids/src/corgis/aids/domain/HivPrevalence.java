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
	
    // 15-24 Years Old
    private Double youngMen;
    // 15-49 Years Old
    private Double adults;
    // 15-24 Years Old
    private Double youngWomen;
    
    
    /*
     * @return 
     */
    public Double getYoungMen() {
        return this.youngMen;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAdults() {
        return this.adults;
    }
    
    
    
    /*
     * @return 
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
        try {// Young Men
            this.youngMen = (Double)json_data.get("Young Men");// Adults
            this.adults = (Double)json_data.get("Adults");// Young Women
            this.youngWomen = (Double)json_data.get("Young Women");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a HivPrevalence; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a HivPrevalence; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}