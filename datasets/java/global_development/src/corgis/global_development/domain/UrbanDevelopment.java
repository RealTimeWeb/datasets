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
	
    // Percent of total
    private Double urbanPopulation;
    // People per square kilometer of land area
    private Double populationDensity;
    // Annual percent
    private Double urbanPopulationGrowth;
    
    
    /*
     * @return 
     */
    public Double getUrbanPopulation() {
        return this.urbanPopulation;
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
    public Double getUrbanPopulationGrowth() {
        return this.urbanPopulationGrowth;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this UrbanDevelopment.
	
	 * @return String
	 */
	public String toString() {
		return "UrbanDevelopment[" +urbanPopulation+", "+populationDensity+", "+urbanPopulationGrowth+"]";
	}
	
	/**
	 * Internal constructor to create a UrbanDevelopment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public UrbanDevelopment(JSONObject json_data) {
        try {// Urban Population
            this.urbanPopulation = ((Number)json_data.get("Urban Population")).doubleValue();// Population Density
            this.populationDensity = ((Number)json_data.get("Population Density")).doubleValue();// Urban Population Growth
            this.urbanPopulationGrowth = ((Number)json_data.get("Urban Population Growth")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a UrbanDevelopment; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a UrbanDevelopment; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}