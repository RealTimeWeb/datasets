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
	
    private Double white;
    private Double blackOrAfricanAmerican;
    private Integer asian;
    
    
    /*
     * @return 
     */
    public Double getWhite() {
        return this.white;
    }
    
    
    
    /*
     * @return 
     */
    public Double getBlackOrAfricanAmerican() {
        return this.blackOrAfricanAmerican;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAsian() {
        return this.asian;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this CivilianNoninstitutionalPopulation.
	
	 * @return String
	 */
	public String toString() {
		return "CivilianNoninstitutionalPopulation[" +white+", "+blackOrAfricanAmerican+", "+asian+"]";
	}
	
	/**
	 * Internal constructor to create a CivilianNoninstitutionalPopulation from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public CivilianNoninstitutionalPopulation(JSONObject json_data) {
        try {// White
            this.white = ((Number)json_data.get("White")).doubleValue();// Black or African American
            this.blackOrAfricanAmerican = ((Number)json_data.get("Black or African American")).doubleValue();// Asian
            this.asian = ((Number)json_data.get("Asian")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CivilianNoninstitutionalPopulation; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CivilianNoninstitutionalPopulation; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}