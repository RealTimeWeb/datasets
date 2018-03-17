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
public class BetweenSevenzerozeroToEightzerozero {
	
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
	 * Creates a string based representation of this Between700To800.
	
	 * @return String
	 */
	public String toString() {
		return "Between700To800[" +verbal+", "+math+"]";
	}
	
	/**
	 * Internal constructor to create a Between700To800 from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public BetweenSevenzerozeroToEightzerozero(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Verbal
            this.verbal = new Verbal((JSONObject)json_data.get("Verbal"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Between700To800; the field verbal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Between700To800; the field verbal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Math
            this.math = new Math((JSONObject)json_data.get("Math"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Between700To800; the field math was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Between700To800; the field math had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}