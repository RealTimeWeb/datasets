package corgis.food.domain;

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
public class Fat {
	
    private Double saturatedFat;
    private Double monosaturatedFat;
    private Double totalLipid;
    private Double polysaturatedFat;
    
    
    /*
     * @return 
     */
    public Double getSaturatedFat() {
        return this.saturatedFat;
    }
    
    
    
    /*
     * @return 
     */
    public Double getMonosaturatedFat() {
        return this.monosaturatedFat;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTotalLipid() {
        return this.totalLipid;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPolysaturatedFat() {
        return this.polysaturatedFat;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Fat.
	
	 * @return String
	 */
	public String toString() {
		return "Fat[" +saturatedFat+", "+monosaturatedFat+", "+totalLipid+", "+polysaturatedFat+"]";
	}
	
	/**
	 * Internal constructor to create a Fat from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Fat(JSONObject json_data) {
        try {// Saturated Fat
            this.saturatedFat = (Double)json_data.get("Saturated Fat");// Monosaturated Fat
            this.monosaturatedFat = (Double)json_data.get("Monosaturated Fat");// Total Lipid
            this.totalLipid = (Double)json_data.get("Total Lipid");// Polysaturated Fat
            this.polysaturatedFat = (Double)json_data.get("Polysaturated Fat");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Fat; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Fat; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}