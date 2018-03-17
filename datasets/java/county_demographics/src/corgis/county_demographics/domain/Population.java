package corgis.county_demographics.domain;

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
public class Population {
	
    private Integer twozeroonezeroPopulation;
    // April 1, 2010 to July 1, 2014
    private Double populationPercentChange;
    // 2010
    private Double populationPerSquareMile;
    private Integer twozeroonefourPopulation;
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getTwozeroonezeroPopulation() {
        return this.twozeroonezeroPopulation;
    }
    
    
    
    /**
     * April 1, 2010 to July 1, 2014
     * @return Double
     */
    public Double getPopulationPercentChange() {
        return this.populationPercentChange;
    }
    
    
    
    /**
     * 2010
     * @return Double
     */
    public Double getPopulationPerSquareMile() {
        return this.populationPerSquareMile;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getTwozeroonefourPopulation() {
        return this.twozeroonefourPopulation;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Population.
	
	 * @return String
	 */
	public String toString() {
		return "Population[" +twozeroonezeroPopulation+", "+populationPercentChange+", "+populationPerSquareMile+", "+twozeroonefourPopulation+"]";
	}
	
	/**
	 * Internal constructor to create a Population from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Population(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // 2010 Population
            this.twozeroonezeroPopulation = ((Number)json_data.get("2010 Population")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Population; the field twozeroonezeroPopulation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Population; the field twozeroonezeroPopulation had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Population Percent Change
            this.populationPercentChange = ((Number)json_data.get("Population Percent Change")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Population; the field populationPercentChange was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Population; the field populationPercentChange had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Population per Square Mile
            this.populationPerSquareMile = ((Number)json_data.get("Population per Square Mile")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Population; the field populationPerSquareMile was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Population; the field populationPerSquareMile had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // 2014 Population
            this.twozeroonefourPopulation = ((Number)json_data.get("2014 Population")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Population; the field twozeroonefourPopulation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Population; the field twozeroonefourPopulation had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}