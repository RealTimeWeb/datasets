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
	
    private Integer medianHouseoldIncome;
    // 2013 dollars
    private Integer perCapitaIncome;
    private Double personsBelowPovertyLevel;
    
    
    /*
     * @return 
     */
    public Integer getMedianHouseoldIncome() {
        return this.medianHouseoldIncome;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPerCapitaIncome() {
        return this.perCapitaIncome;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPersonsBelowPovertyLevel() {
        return this.personsBelowPovertyLevel;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Income.
	
	 * @return String
	 */
	public String toString() {
		return "Income[" +medianHouseoldIncome+", "+perCapitaIncome+", "+personsBelowPovertyLevel+"]";
	}
	
	/**
	 * Internal constructor to create a Income from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Income(JSONObject json_data) {
        try {// Median Houseold Income
            this.medianHouseoldIncome = new Integer(((Long)json_data.get("Median Houseold Income")).intValue());// Per Capita Income
            this.perCapitaIncome = new Integer(((Long)json_data.get("Per Capita Income")).intValue());// Persons Below Poverty Level
            this.personsBelowPovertyLevel = (Double)json_data.get("Persons Below Poverty Level");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Income; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Income; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}