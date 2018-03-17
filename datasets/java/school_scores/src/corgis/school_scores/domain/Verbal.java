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
public class Verbal {
	
    // The number of students in this score range for Verbal (Reading, not Writing) who identified as Male in this state during this year.
    private Integer males;
    // The number of students in this score range for Verbal (Reading, not Writing) in this state during this year.
    private Integer total;
    // The number of students in this score range for Verbal (Reading, not Writing) who identified as Female in this state during this year.
    private Integer females;
    
    
    /**
     * The number of students in this score range for Verbal (Reading, not Writing) who identified as Male in this state during this year.
     * @return Integer
     */
    public Integer getMales() {
        return this.males;
    }
    
    
    
    /**
     * The number of students in this score range for Verbal (Reading, not Writing) in this state during this year.
     * @return Integer
     */
    public Integer getTotal() {
        return this.total;
    }
    
    
    
    /**
     * The number of students in this score range for Verbal (Reading, not Writing) who identified as Female in this state during this year.
     * @return Integer
     */
    public Integer getFemales() {
        return this.females;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Verbal.
	
	 * @return String
	 */
	public String toString() {
		return "Verbal[" +males+", "+total+", "+females+"]";
	}
	
	/**
	 * Internal constructor to create a Verbal from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Verbal(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Males
            this.males = ((Number)json_data.get("Males")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Verbal; the field males was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Verbal; the field males had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Total
            this.total = ((Number)json_data.get("Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Verbal; the field total was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Verbal; the field total had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Females
            this.females = ((Number)json_data.get("Females")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Verbal; the field females was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Verbal; the field females had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}