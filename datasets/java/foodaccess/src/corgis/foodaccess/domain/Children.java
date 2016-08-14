package corgis.foodaccess.domain;

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
public class Children {
	
    private Double twozeroMiles;
    private Double oneTwoMile;
    private Double oneMile;
    private Double onezeroMiles;
    
    
    /*
     * @return 
     */
    public Double getTwozeroMiles() {
        return this.twozeroMiles;
    }
    
    
    
    /*
     * @return 
     */
    public Double getOneTwoMile() {
        return this.oneTwoMile;
    }
    
    
    
    /*
     * @return 
     */
    public Double getOneMile() {
        return this.oneMile;
    }
    
    
    
    /*
     * @return 
     */
    public Double getOnezeroMiles() {
        return this.onezeroMiles;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Children.
	
	 * @return String
	 */
	public String toString() {
		return "Children[" +twozeroMiles+", "+oneTwoMile+", "+oneMile+", "+onezeroMiles+"]";
	}
	
	/**
	 * Internal constructor to create a Children from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Children(JSONObject json_data) {
        try {// 20 Miles
            this.twozeroMiles = (Double)json_data.get("20 Miles");// 1/2 Mile
            this.oneTwoMile = (Double)json_data.get("1/2 Mile");// 1 Mile
            this.oneMile = (Double)json_data.get("1 Mile");// 10 Miles
            this.onezeroMiles = (Double)json_data.get("10 Miles");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Children; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Children; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}