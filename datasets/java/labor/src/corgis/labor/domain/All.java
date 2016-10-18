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
public class All {
	
    private String units;
    private Double value;
    
    
    /*
     * @return 
     */
    public String getUnits() {
        return this.units;
    }
    
    
    
    /*
     * @return 
     */
    public Double getValue() {
        return this.value;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this All.
	
	 * @return String
	 */
	public String toString() {
		return "All[" +units+", "+value+"]";
	}
	
	/**
	 * Internal constructor to create a All from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public All(JSONObject json_data) {
        try {// units
            this.units = (String)json_data.get("units");// value
            this.value = ((Number)json_data.get("value")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a All; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a All; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}