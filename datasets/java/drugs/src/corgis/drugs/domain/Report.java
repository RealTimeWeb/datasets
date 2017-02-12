package corgis.drugs.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.drugs.domain.Rates;
import corgis.drugs.domain.Population;
import corgis.drugs.domain.Totals;

/**
 * 
 */
public class Report {
	
    // The state that this report was created for.
    private String state;
    // The year that this report was created for.
    private Integer year;
    private Rates rates;
    private Population population;
    private Totals totals;
    
    
    /*
     * @return 
     */
    public String getState() {
        return this.state;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
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
    public Population getPopulation() {
        return this.population;
    }
    
    
    
    /*
     * @return 
     */
    public Totals getTotals() {
        return this.totals;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Report.
	
	 * @return String
	 */
	public String toString() {
		return "Report[" +state+", "+year+", "+rates+", "+population+", "+totals+"]";
	}
	
	/**
	 * Internal constructor to create a Report from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Report(JSONObject json_data) {
        try {// State
            this.state = (String)json_data.get("State");// Year
            this.year = ((Number)json_data.get("Year")).intValue();// Rates
            this.rates = new Rates((JSONObject)json_data.get("Rates"));// Population
            this.population = new Population((JSONObject)json_data.get("Population"));// Totals
            this.totals = new Totals((JSONObject)json_data.get("Totals"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}