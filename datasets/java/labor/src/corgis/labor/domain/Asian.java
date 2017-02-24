package corgis.labor.domain;

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
public class Asian {
	
    private Integer counts;
    private Integer unemploymentRate;
    
    
    /*
     * @return 
     */
    public Integer getCounts() {
        return this.counts;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUnemploymentRate() {
        return this.unemploymentRate;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Asian.
	
	 * @return String
	 */
	public String toString() {
		return "Asian[" +counts+", "+unemploymentRate+"]";
	}
	
	/**
	 * Internal constructor to create a Asian from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Asian(JSONObject json_data) {
        try {// Counts
            this.counts = ((Number)json_data.get("Counts")).intValue();// Unemployment Rate
            this.unemploymentRate = ((Number)json_data.get("Unemployment Rate")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Asian; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Asian; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}