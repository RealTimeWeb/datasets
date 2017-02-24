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
public class Math {
	
    // The number of students in this score range for Math who identified as Male in this state during this year.
    private Integer males;
    // The number of students in this score range for Math who identified as Female in this state during this year.
    private Integer females;
    // The number of students in this score range for Math in this state during this year.
    private Integer total;
    
    
    /*
     * @return 
     */
    public Integer getMales() {
        return this.males;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFemales() {
        return this.females;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTotal() {
        return this.total;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Math.
	
	 * @return String
	 */
	public String toString() {
		return "Math[" +males+", "+females+", "+total+"]";
	}
	
	/**
	 * Internal constructor to create a Math from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Math(JSONObject json_data) {
        try {// Males
            this.males = ((Number)json_data.get("Males")).intValue();// Females
            this.females = ((Number)json_data.get("Females")).intValue();// Total
            this.total = ((Number)json_data.get("Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Math; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Math; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}