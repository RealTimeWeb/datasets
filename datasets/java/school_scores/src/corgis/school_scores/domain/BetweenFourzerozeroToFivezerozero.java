package corgis.school_scores.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.school_scores.domain.Verbal;
import corgis.school_scores.domain.Math;

/**
 * 
 */
public class BetweenFourzerozeroToFivezerozero {
	
    private Verbal verbal;
    private Math math;
    
    
    /**
     * 
     * @return Verbal
     */
    public Verbal getVerbal() {
        return this.verbal;
    }
    
    
    
    /**
     * 
     * @return Math
     */
    public Math getMath() {
        return this.math;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Between400To500.
	
	 * @return String
	 */
	public String toString() {
		return "Between400To500[" +verbal+", "+math+"]";
	}
	
	/**
	 * Internal constructor to create a Between400To500 from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public BetweenFourzerozeroToFivezerozero(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Verbal
            this.verbal = new Verbal((JSONObject)json_data.get("Verbal"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Between400To500; the field verbal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Between400To500; the field verbal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Math
            this.math = new Math((JSONObject)json_data.get("Math"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Between400To500; the field math was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Between400To500; the field math had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}