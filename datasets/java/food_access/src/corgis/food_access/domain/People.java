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
public class People {
	
    private Double twozeroMiles;
    private Double oneTwoMile;
    private Double oneMile;
    private Double onezeroMiles;
    
    
    /**
     * 
     * @return Double
     */
    public Double getTwozeroMiles() {
        return this.twozeroMiles;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getOneTwoMile() {
        return this.oneTwoMile;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getOneMile() {
        return this.oneMile;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getOnezeroMiles() {
        return this.onezeroMiles;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this People.
	
	 * @return String
	 */
	public String toString() {
		return "People[" +twozeroMiles+", "+oneTwoMile+", "+oneMile+", "+onezeroMiles+"]";
	}
	
	/**
	 * Internal constructor to create a People from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public People(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // 20 Miles
            this.twozeroMiles = ((Number)json_data.get("20 Miles")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a People; the field twozeroMiles was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a People; the field twozeroMiles had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // 1/2 Mile
            this.oneTwoMile = ((Number)json_data.get("1/2 Mile")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a People; the field oneTwoMile was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a People; the field oneTwoMile had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // 1 Mile
            this.oneMile = ((Number)json_data.get("1 Mile")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a People; the field oneMile was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a People; the field oneMile had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // 10 Miles
            this.onezeroMiles = ((Number)json_data.get("10 Miles")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a People; the field onezeroMiles was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a People; the field onezeroMiles had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}