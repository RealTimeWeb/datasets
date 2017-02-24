package corgis.hydropower.domain;

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
	
    // In feet, missing values were imputed with a mean value of 132.17
    private Double structuralHeight;
    private Double crestLength;
    // In feet, missing values were imputed with a mean value of 4141.10
    private Double crestElevation;
    
    
    /*
     * @return 
     */
    public Double getStructuralHeight() {
        return this.structuralHeight;
    }
    
    
    
    /*
     * @return 
     */
    public Double getCrestLength() {
        return this.crestLength;
    }
    
    
    
    /*
     * @return 
     */
    public Double getCrestElevation() {
        return this.crestElevation;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Dimensions.
	
	 * @return String
	 */
	public String toString() {
		return "Dimensions[" +structuralHeight+", "+crestLength+", "+crestElevation+"]";
	}
	
	/**
	 * Internal constructor to create a Dimensions from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Dimensions(JSONObject json_data) {
        try {// Structural Height
            this.structuralHeight = ((Number)json_data.get("Structural Height")).doubleValue();// Crest Length
            this.crestLength = ((Number)json_data.get("Crest Length")).doubleValue();// Crest Elevation
            this.crestElevation = ((Number)json_data.get("Crest Elevation")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Dimensions; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Dimensions; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}