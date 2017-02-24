package corgis.global_development.domain;

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
public class UrbanDevelopment {
	
    // Percent of total population
    private Double urbanPopulationPercent;
    // People per square kilometer of land area
    private Double populationDensity;
    private Double urbanPopulationPercentGrowth;
    
    
    /*
     * @return 
     */
    public Double getUrbanPopulationPercent() {
        return this.urbanPopulationPercent;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPopulationDensity() {
        return this.populationDensity;
    }
    
    
    
    /*
     * @return 
     */
    public Double getUrbanPopulationPercentGrowth() {
        return this.urbanPopulationPercentGrowth;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this UrbanDevelopment.
	
	 * @return String
	 */
	public String toString() {
		return "UrbanDevelopment[" +urbanPopulationPercent+", "+populationDensity+", "+urbanPopulationPercentGrowth+"]";
	}
	
	/**
	 * Internal constructor to create a UrbanDevelopment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public UrbanDevelopment(JSONObject json_data) {
        try {// Urban Population Percent
            this.urbanPopulationPercent = ((Number)json_data.get("Urban Population Percent")).doubleValue();// Population Density
            this.populationDensity = ((Number)json_data.get("Population Density")).doubleValue();// Urban Population Percent Growth
            this.urbanPopulationPercentGrowth = ((Number)json_data.get("Urban Population Percent Growth")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a UrbanDevelopment; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a UrbanDevelopment; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}