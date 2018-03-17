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
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getCounts() {
        return this.counts;
    }
    
    
    
    /**
     * 
     * @return Integer
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
        //System.out.println(json_data);
        
        try {
            // Counts
            this.counts = ((Number)json_data.get("Counts")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Asian; the field counts was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Asian; the field counts had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Unemployment Rate
            this.unemploymentRate = ((Number)json_data.get("Unemployment Rate")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Asian; the field unemploymentRate was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Asian; the field unemploymentRate had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}