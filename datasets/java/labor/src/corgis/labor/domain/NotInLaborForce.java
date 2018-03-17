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
public class NotInLaborForce {
	
    private Double blackOrAfricanAmerican;
    private Integer white;
    private Integer asian;
    
    
    /**
     * 
     * @return Double
     */
    public Double getBlackOrAfricanAmerican() {
        return this.blackOrAfricanAmerican;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getWhite() {
        return this.white;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getAsian() {
        return this.asian;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this NotInLaborForce.
	
	 * @return String
	 */
	public String toString() {
		return "NotInLaborForce[" +blackOrAfricanAmerican+", "+white+", "+asian+"]";
	}
	
	/**
	 * Internal constructor to create a NotInLaborForce from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public NotInLaborForce(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Black or African American
            this.blackOrAfricanAmerican = ((Number)json_data.get("Black or African American")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NotInLaborForce; the field blackOrAfricanAmerican was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NotInLaborForce; the field blackOrAfricanAmerican had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // White
            this.white = ((Number)json_data.get("White")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NotInLaborForce; the field white was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NotInLaborForce; the field white had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Asian
            this.asian = ((Number)json_data.get("Asian")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NotInLaborForce; the field asian was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NotInLaborForce; the field asian had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}