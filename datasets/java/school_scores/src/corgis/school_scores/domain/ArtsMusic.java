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
public class ArtsMusic {
	
    // The average number of years that a student has studied Arts/Music when they took the exam.
    private Double averageYears;
    // The average GPA of all students in this state during this year in Arts/Music. Note that this is just the GPA within the subject, not across all academic subjects.
    private Double averageGpa;
    
    
    /**
     * The average number of years that a student has studied Arts/Music when they took the exam.
     * @return Double
     */
    public Double getAverageYears() {
        return this.averageYears;
    }
    
    
    
    /**
     * The average GPA of all students in this state during this year in Arts/Music. Note that this is just the GPA within the subject, not across all academic subjects.
     * @return Double
     */
    public Double getAverageGpa() {
        return this.averageGpa;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Arts/Music.
	
	 * @return String
	 */
	public String toString() {
		return "Arts/Music[" +averageYears+", "+averageGpa+"]";
	}
	
	/**
	 * Internal constructor to create a Arts/Music from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public ArtsMusic(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Average Years
            this.averageYears = ((Number)json_data.get("Average Years")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Arts/Music; the field averageYears was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Arts/Music; the field averageYears had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Average GPA
            this.averageGpa = ((Number)json_data.get("Average GPA")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Arts/Music; the field averageGpa was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Arts/Music; the field averageGpa had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}