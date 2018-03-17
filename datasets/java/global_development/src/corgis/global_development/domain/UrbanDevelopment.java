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
	
    private Double urbanPopulationPercentGrowth;
    // Percent of total population
    private Double urbanPopulationPercent;
    // People per square kilometer of land area
    private Double populationDensity;
    
    
    /**
     * 
     * @return Double
     */
    public Double getUrbanPopulationPercentGrowth() {
        return this.urbanPopulationPercentGrowth;
    }
    
    
    
    /**
     * Percent of total population
     * @return Double
     */
    public Double getUrbanPopulationPercent() {
        return this.urbanPopulationPercent;
    }
    
    
    
    /**
     * People per square kilometer of land area
     * @return Double
     */
    public Double getPopulationDensity() {
        return this.populationDensity;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this UrbanDevelopment.
	
	 * @return String
	 */
	public String toString() {
		return "UrbanDevelopment[" +urbanPopulationPercentGrowth+", "+urbanPopulationPercent+", "+populationDensity+"]";
	}
	
	/**
	 * Internal constructor to create a UrbanDevelopment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public UrbanDevelopment(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Urban Population Percent Growth
            this.urbanPopulationPercentGrowth = ((Number)json_data.get("Urban Population Percent Growth")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a UrbanDevelopment; the field urbanPopulationPercentGrowth was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a UrbanDevelopment; the field urbanPopulationPercentGrowth had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Urban Population Percent
            this.urbanPopulationPercent = ((Number)json_data.get("Urban Population Percent")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a UrbanDevelopment; the field urbanPopulationPercent was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a UrbanDevelopment; the field urbanPopulationPercent had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Population Density
            this.populationDensity = ((Number)json_data.get("Population Density")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a UrbanDevelopment; the field populationDensity was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a UrbanDevelopment; the field populationDensity had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}