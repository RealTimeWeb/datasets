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
	
    // A number representing the expected cancer rate, adjusted for the age of the participants. An age-adjusted rate is a weighted average of the age-specific rates, where the weights are the proportions of persons in the corresponding age groups of a standard population. The potential confounding effect of age is reduced when comparing age-adjusted rates computed using the same standard population.
    private Double ageAdjustedRate;
    // A number representing the expected lower bound for the cancer rate. It is unlikely that the actual rate is lower than this number. CI means "Confidence Interval".
    private Double ageAdjustedCiLower;
    // A number representing the expected upper bound for the cancer rate, adjusted for the age of the participants. It is unlikely that the actual rate is higher than this number. CI means "Confidence Interval".
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
            this.ageAdjustedRate = ((Number)json_data.get("Age Adjusted Rate")).doubleValue();// Age Adjusted CI Lower
            this.ageAdjustedCiLower = ((Number)json_data.get("Age Adjusted CI Lower")).doubleValue();// Age Adjusted CI Upper
            this.ageAdjustedCiUpper = ((Number)json_data.get("Age Adjusted CI Upper")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Age; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Age; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}