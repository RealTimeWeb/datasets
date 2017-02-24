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
public class Male {
	
    // The number of test-takers in this state during this year who identified as Male.
    private Integer testTakers;
    // The average Math score of students in this state during this year who identified as Male.
    private Integer math;
    // The average Verbal (Reading, not Writing) score of students in this state during this year who identified as Male.
    private Integer verbal;
    
    
    /*
     * @return 
     */
    public Integer getTestTakers() {
        return this.testTakers;
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
    public Integer getVerbal() {
        return this.verbal;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Male.
	
	 * @return String
	 */
	public String toString() {
		return "Male[" +testTakers+", "+math+", "+verbal+"]";
	}
	
	/**
	 * Internal constructor to create a Male from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Male(JSONObject json_data) {
        try {// Test-takers
            this.testTakers = ((Number)json_data.get("Test-takers")).intValue();// Math
            this.math = ((Number)json_data.get("Math")).intValue();// Verbal
            this.verbal = ((Number)json_data.get("Verbal")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Male; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Male; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}