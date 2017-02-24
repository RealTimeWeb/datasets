package corgis.school_scores.domain;

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
public class BetweenTwozeroFourzerok {
	
    // The average Verbal (Reading, not Writing) score of students in this state during this year who reported that their family income was in this bracket.
    private Integer verbal;
    // The average Math score of students in this state during this year who reported that their family income was in this bracket.
    private Integer math;
    // The number of test-takers in this state during this year who reported that their family income was in this bracket.
    private Integer testTakers;
    
    
    /*
     * @return 
     */
    public Integer getVerbal() {
        return this.verbal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMath() {
        return this.math;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTestTakers() {
        return this.testTakers;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Between20-40K.
	
	 * @return String
	 */
	public String toString() {
		return "Between20-40K[" +verbal+", "+math+", "+testTakers+"]";
	}
	
	/**
	 * Internal constructor to create a Between20-40K from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public BetweenTwozeroFourzerok(JSONObject json_data) {
        try {// Verbal
            this.verbal = ((Number)json_data.get("Verbal")).intValue();// Math
            this.math = ((Number)json_data.get("Math")).intValue();// Test-takers
            this.testTakers = ((Number)json_data.get("Test-takers")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Between20-40K; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Between20-40K; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}