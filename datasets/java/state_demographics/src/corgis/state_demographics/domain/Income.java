package corgis.state_demographics.domain;

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
public class Income {
	
    // 2013 dollars
    private Integer perCapitaIncome;
    private Integer medianHouseoldIncome;
    private Double personsBelowPovertyLevel;
    
    
    /**
     * 2013 dollars
     * @return Integer
     */
    public Integer getPerCapitaIncome() {
        return this.perCapitaIncome;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getMedianHouseoldIncome() {
        return this.medianHouseoldIncome;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getPersonsBelowPovertyLevel() {
        return this.personsBelowPovertyLevel;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Income.
	
	 * @return String
	 */
	public String toString() {
		return "Income[" +perCapitaIncome+", "+medianHouseoldIncome+", "+personsBelowPovertyLevel+"]";
	}
	
	/**
	 * Internal constructor to create a Income from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Income(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Per Capita Income
            this.perCapitaIncome = ((Number)json_data.get("Per Capita Income")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Income; the field perCapitaIncome was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Income; the field perCapitaIncome had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Median Houseold Income
            this.medianHouseoldIncome = ((Number)json_data.get("Median Houseold Income")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Income; the field medianHouseoldIncome was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Income; the field medianHouseoldIncome had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Persons Below Poverty Level
            this.personsBelowPovertyLevel = ((Number)json_data.get("Persons Below Poverty Level")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Income; the field personsBelowPovertyLevel was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Income; the field personsBelowPovertyLevel had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}