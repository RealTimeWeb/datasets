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
	
    private Double crestLength;
    private Double crestElevaion;
    // In feet, missing values were imputed with a mean value of 132.17
    private Double structuralHeight;
    
    
    /*
     * @return 
     */
    public Double getCrestLength() {
        return this.crestLength;
    }
    
    
    
    /*
     * @return 
     */
    public Double getCrestElevaion() {
        return this.crestElevaion;
    }
    
    
    
    /*
     * @return 
     */
    public Double getStructuralHeight() {
        return this.structuralHeight;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Dimensions.
	
	 * @return String
	 */
	public String toString() {
		return "Dimensions[" +crestLength+", "+crestElevaion+", "+structuralHeight+"]";
	}
	
	/**
	 * Internal constructor to create a Dimensions from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Dimensions(JSONObject json_data) {
        try {// Crest Length
            this.crestLength = (Double)json_data.get("Crest Length");// Crest Elevaion
            this.crestElevaion = (Double)json_data.get("Crest Elevaion");// Structural Height
            this.structuralHeight = (Double)json_data.get("Structural Height");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Dimensions; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Dimensions; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}