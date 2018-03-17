package corgis.cars.domain;

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
public class Dimensions {
	
    // Unknown values are stored as 0. Unfortunately, many cars do not report this data.
    private Integer width;
    // Unknown values are stored as 0. Unfortunately, many cars do not report this data.
    private Integer height;
    // Unknown values are stored as 0. Unfortunately, many cars do not report this data.
    private Integer length;
    
    
    /**
     * Unknown values are stored as 0. Unfortunately, many cars do not report this data.
     * @return Integer
     */
    public Integer getWidth() {
        return this.width;
    }
    
    
    
    /**
     * Unknown values are stored as 0. Unfortunately, many cars do not report this data.
     * @return Integer
     */
    public Integer getHeight() {
        return this.height;
    }
    
    
    
    /**
     * Unknown values are stored as 0. Unfortunately, many cars do not report this data.
     * @return Integer
     */
    public Integer getLength() {
        return this.length;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Dimensions.
	
	 * @return String
	 */
	public String toString() {
		return "Dimensions[" +width+", "+height+", "+length+"]";
	}
	
	/**
	 * Internal constructor to create a Dimensions from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Dimensions(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Width
            this.width = ((Number)json_data.get("Width")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Dimensions; the field width was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Dimensions; the field width had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Height
            this.height = ((Number)json_data.get("Height")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Dimensions; the field height was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Dimensions; the field height had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Length
            this.length = ((Number)json_data.get("Length")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Dimensions; the field length was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Dimensions; the field length had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}