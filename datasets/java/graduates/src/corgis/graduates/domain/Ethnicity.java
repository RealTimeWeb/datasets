package corgis.graduates.domain;

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
public class Ethnicity {
	
    // The estimated number of people identifying as White that were awarded degrees in this major during this year.
    private Integer whites;
    // The estimated number of people identifying as Asian that were awarded degrees in this major during this year.
    private Integer asians;
    // The estimated number of people identifying as a minority (e.g., Black, African American, Native American) that were awarded degrees in this major during this year.
    private Integer minorities;
    
    
    /*
     * @return 
     */
    public Integer getWhites() {
        return this.whites;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAsians() {
        return this.asians;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMinorities() {
        return this.minorities;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Ethnicity.
	
	 * @return String
	 */
	public String toString() {
		return "Ethnicity[" +whites+", "+asians+", "+minorities+"]";
	}
	
	/**
	 * Internal constructor to create a Ethnicity from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Ethnicity(JSONObject json_data) {
        try {// Whites
            this.whites = ((Number)json_data.get("Whites")).intValue();// Asians
            this.asians = ((Number)json_data.get("Asians")).intValue();// Minorities
            this.minorities = ((Number)json_data.get("Minorities")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Ethnicity; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Ethnicity; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}