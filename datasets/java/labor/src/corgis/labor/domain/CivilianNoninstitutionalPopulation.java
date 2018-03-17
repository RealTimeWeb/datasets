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
public class CivilianNoninstitutionalPopulation {
	
    private Double blackOrAfricanAmerican;
    private Double white;
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
     * @return Double
     */
    public Double getWhite() {
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
	 * Creates a string based representation of this CivilianNoninstitutionalPopulation.
	
	 * @return String
	 */
	public String toString() {
		return "CivilianNoninstitutionalPopulation[" +blackOrAfricanAmerican+", "+white+", "+asian+"]";
	}
	
	/**
	 * Internal constructor to create a CivilianNoninstitutionalPopulation from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public CivilianNoninstitutionalPopulation(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Black or African American
            this.blackOrAfricanAmerican = ((Number)json_data.get("Black or African American")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CivilianNoninstitutionalPopulation; the field blackOrAfricanAmerican was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CivilianNoninstitutionalPopulation; the field blackOrAfricanAmerican had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // White
            this.white = ((Number)json_data.get("White")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CivilianNoninstitutionalPopulation; the field white was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CivilianNoninstitutionalPopulation; the field white had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Asian
            this.asian = ((Number)json_data.get("Asian")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CivilianNoninstitutionalPopulation; the field asian was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CivilianNoninstitutionalPopulation; the field asian had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}