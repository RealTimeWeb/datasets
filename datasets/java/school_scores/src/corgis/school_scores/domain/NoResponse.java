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
public class NoResponse {
	
    // The average Verbal (Reading, not Writing) score of students in this state during this year who reported this for their high school grade point average.
    private Integer verbal;
    // The number of test-takers in this state during this year who reported this for their high school grade point average.
    private Integer testTakers;
    // The average Math score of students in this state during this year who reported this for their high school grade point average.
    private Integer math;
    
    
    /**
     * The average Verbal (Reading, not Writing) score of students in this state during this year who reported this for their high school grade point average.
     * @return Integer
     */
    public Integer getVerbal() {
        return this.verbal;
    }
    
    
    
    /**
     * The number of test-takers in this state during this year who reported this for their high school grade point average.
     * @return Integer
     */
    public Integer getTestTakers() {
        return this.testTakers;
    }
    
    
    
    /**
     * The average Math score of students in this state during this year who reported this for their high school grade point average.
     * @return Integer
     */
    public Integer getMath() {
        return this.math;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this NoResponse.
	
	 * @return String
	 */
	public String toString() {
		return "NoResponse[" +verbal+", "+testTakers+", "+math+"]";
	}
	
	/**
	 * Internal constructor to create a NoResponse from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public NoResponse(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Verbal
            this.verbal = ((Number)json_data.get("Verbal")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NoResponse; the field verbal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NoResponse; the field verbal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Test-takers
            this.testTakers = ((Number)json_data.get("Test-takers")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NoResponse; the field testTakers was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NoResponse; the field testTakers had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Math
            this.math = ((Number)json_data.get("Math")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NoResponse; the field math was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NoResponse; the field math had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}