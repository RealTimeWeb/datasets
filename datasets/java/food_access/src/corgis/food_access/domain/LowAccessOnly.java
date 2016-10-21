package corgis.food_access.domain;

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
public class LowAccessOnly {
	
    private Double oneTwoAndOnezeroMiles;
    private Double oneAndTwozeroMiles;
    
    
    /*
     * @return 
     */
    public Double getOneTwoAndOnezeroMiles() {
        return this.oneTwoAndOnezeroMiles;
    }
    
    
    
    /*
     * @return 
     */
    public Double getOneAndTwozeroMiles() {
        return this.oneAndTwozeroMiles;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this LowAccessOnly.
	
	 * @return String
	 */
	public String toString() {
		return "LowAccessOnly[" +oneTwoAndOnezeroMiles+", "+oneAndTwozeroMiles+"]";
	}
	
	/**
	 * Internal constructor to create a LowAccessOnly from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public LowAccessOnly(JSONObject json_data) {
        try {// 1/2 and 10 Miles
            this.oneTwoAndOnezeroMiles = ((Number)json_data.get("1/2 and 10 Miles")).doubleValue();// 1 and 20 Miles
            this.oneAndTwozeroMiles = ((Number)json_data.get("1 and 20 Miles")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a LowAccessOnly; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a LowAccessOnly; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}