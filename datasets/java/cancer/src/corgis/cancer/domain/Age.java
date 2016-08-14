package corgis.cancer.domain;

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
public class Age {
	
    private Double ageAdjustedRate;
    private Double ageAdjustedCiLower;
    private Double ageAdjustedCiUpper;
    
    
    /*
     * @return 
     */
    public Double getAgeAdjustedRate() {
        return this.ageAdjustedRate;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAgeAdjustedCiLower() {
        return this.ageAdjustedCiLower;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAgeAdjustedCiUpper() {
        return this.ageAdjustedCiUpper;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Age.
	
	 * @return String
	 */
	public String toString() {
		return "Age[" +ageAdjustedRate+", "+ageAdjustedCiLower+", "+ageAdjustedCiUpper+"]";
	}
	
	/**
	 * Internal constructor to create a Age from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Age(JSONObject json_data) {
        try {// Age Adjusted Rate
            this.ageAdjustedRate = (Double)json_data.get("Age Adjusted Rate");// Age Adjusted CI Lower
            this.ageAdjustedCiLower = (Double)json_data.get("Age Adjusted CI Lower");// Age Adjusted CI Upper
            this.ageAdjustedCiUpper = (Double)json_data.get("Age Adjusted CI Upper");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Age; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Age; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}