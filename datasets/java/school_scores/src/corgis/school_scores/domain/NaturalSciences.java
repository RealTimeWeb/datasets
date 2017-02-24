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
public class NaturalSciences {
	
    // The average GPA of all students in this state during this year in the Natural Sciences. Note that this is just the GPA within the subject, not across all academic subjects.
    private Double averageGpa;
    // The average number of years that a student has studied the Natural Sciences when they took the exam.
    private Double averageYears;
    
    
    /*
     * @return 
     */
    public Double getAverageGpa() {
        return this.averageGpa;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAverageYears() {
        return this.averageYears;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this NaturalSciences.
	
	 * @return String
	 */
	public String toString() {
		return "NaturalSciences[" +averageGpa+", "+averageYears+"]";
	}
	
	/**
	 * Internal constructor to create a NaturalSciences from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public NaturalSciences(JSONObject json_data) {
        try {// Average GPA
            this.averageGpa = ((Number)json_data.get("Average GPA")).doubleValue();// Average Years
            this.averageYears = ((Number)json_data.get("Average Years")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalSciences; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalSciences; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}