package corgis.county_crime.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.county_crime.domain.Rates;
import corgis.county_crime.domain.Totals;

/**
 * 
 */
public class Data {
	
    // The number of people living in this state at the time the report was created.
    private Integer population;
    private Rates rates;
    private Totals totals;
    
    
    /*
     * @return 
     */
    public Integer getPopulation() {
        return this.population;
    }
    
    
    
    /*
     * @return 
     */
    public Rates getRates() {
        return this.rates;
    }
    
    
    
    /*
     * @return 
     */
    public Totals getTotals() {
        return this.totals;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +population+", "+rates+", "+totals+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// Population
            this.population = ((Number)json_data.get("Population")).intValue();// Rates
            this.rates = new Rates((JSONObject)json_data.get("Rates"));// Totals
            this.totals = new Totals((JSONObject)json_data.get("Totals"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}