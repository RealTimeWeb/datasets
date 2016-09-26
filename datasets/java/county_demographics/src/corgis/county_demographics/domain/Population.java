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
	
    private Integer twozeroonefourPopulation;
    private Integer twozeroonezeroPopulation;
    // 2010
    private Double populationPerSquareMile;
    // April 1, 2010 to July 1, 2014
    private Double populationPercentChange;
    
    
    /*
     * @return 
     */
    public Integer getTwozeroonefourPopulation() {
        return this.twozeroonefourPopulation;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTwozeroonezeroPopulation() {
        return this.twozeroonezeroPopulation;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPopulationPerSquareMile() {
        return this.populationPerSquareMile;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPopulationPercentChange() {
        return this.populationPercentChange;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Population.
	
	 * @return String
	 */
	public String toString() {
		return "Population[" +twozeroonefourPopulation+", "+twozeroonezeroPopulation+", "+populationPerSquareMile+", "+populationPercentChange+"]";
	}
	
	/**
	 * Internal constructor to create a Population from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Population(JSONObject json_data) {
        try {// 2014 Population
            this.twozeroonefourPopulation = new Integer(((Long)json_data.get("2014 Population")).intValue());// 2010 Population
            this.twozeroonezeroPopulation = new Integer(((Long)json_data.get("2010 Population")).intValue());// Population per Square Mile
            this.populationPerSquareMile = (Double)json_data.get("Population per Square Mile");// Population Percent Change
            this.populationPercentChange = (Double)json_data.get("Population Percent Change");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Population; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Population; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}