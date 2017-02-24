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
    private Integer length;
    // Unknown values are stored as 0. Unfortunately, many cars do not report this data.
    private Integer height;
    
    
    /*
     * @return 
     */
    public Integer getWidth() {
        return this.width;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLength() {
        return this.length;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHeight() {
        return this.height;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Dimensions.
	
	 * @return String
	 */
	public String toString() {
		return "Dimensions[" +width+", "+length+", "+height+"]";
	}
	
	/**
	 * Internal constructor to create a Dimensions from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Dimensions(JSONObject json_data) {
        try {// Width
            this.width = ((Number)json_data.get("Width")).intValue();// Length
            this.length = ((Number)json_data.get("Length")).intValue();// Height
            this.height = ((Number)json_data.get("Height")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Dimensions; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Dimensions; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}