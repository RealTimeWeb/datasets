package corgis.state_crime.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.state_crime.domain.Totals;
import corgis.state_crime.domain.Rates;

/**
 * 
 */
public class Data {
	
    private Totals totals;
    // The number of people living in this state at the time the report was created.
    private Integer population;
    private Rates rates;
    
    
    /**
     * 
     * @return Totals
     */
    public Totals getTotals() {
        return this.totals;
    }
    
    
    
    /**
     * The number of people living in this state at the time the report was created.
     * @return Integer
     */
    public Integer getPopulation() {
        return this.population;
    }
    
    
    
    /**
     * 
     * @return Rates
     */
    public Rates getRates() {
        return this.rates;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +totals+", "+population+", "+rates+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Totals
            this.totals = new Totals((JSONObject)json_data.get("Totals"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field totals was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field totals had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Population
            this.population = ((Number)json_data.get("Population")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field population was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field population had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Rates
            this.rates = new Rates((JSONObject)json_data.get("Rates"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field rates was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field rates had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}