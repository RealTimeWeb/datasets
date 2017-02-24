package corgis.school_scores.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.school_scores.domain.Math;
import corgis.school_scores.domain.Verbal;

/**
 * 
 */
public class BetweenSevenzerozeroToEightzerozero {
	
    private Math math;
    private Verbal verbal;
    
    
    /*
     * @return 
     */
    public Math getMath() {
        return this.math;
    }
    
    
    
    /*
     * @return 
     */
    public Verbal getVerbal() {
        return this.verbal;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Between700To800.
	
	 * @return String
	 */
	public String toString() {
		return "Between700To800[" +math+", "+verbal+"]";
	}
	
	/**
	 * Internal constructor to create a Between700To800 from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public BetweenSevenzerozeroToEightzerozero(JSONObject json_data) {
        try {// Math
            this.math = new Math((JSONObject)json_data.get("Math"));// Verbal
            this.verbal = new Verbal((JSONObject)json_data.get("Verbal"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Between700To800; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Between700To800; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}