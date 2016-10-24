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
public class Health {
	
    // Years
    private Double lifeExpectancyAtBirthTotal;
    private Double totalPopulation;
    // Years
    private Double lifeExpectancyAtBirthMale;
    // Annual Percent
    private Double populationGrowth;
    // Years
    private Double lifeExpectancyAtBirthFemale;
    // Crude, per 1000 People
    private Double birthRate;
    // Crude, per 100 People
    private Double deathRate;
    // Total, Births per woman
    private Double fertilityRate;
    
    
    /*
     * @return 
     */
    public Double getLifeExpectancyAtBirthTotal() {
        return this.lifeExpectancyAtBirthTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTotalPopulation() {
        return this.totalPopulation;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLifeExpectancyAtBirthMale() {
        return this.lifeExpectancyAtBirthMale;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPopulationGrowth() {
        return this.populationGrowth;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLifeExpectancyAtBirthFemale() {
        return this.lifeExpectancyAtBirthFemale;
    }
    
    
    
    /*
     * @return 
     */
    public Double getBirthRate() {
        return this.birthRate;
    }
    
    
    
    /*
     * @return 
     */
    public Double getDeathRate() {
        return this.deathRate;
    }
    
    
    
    /*
     * @return 
     */
    public Double getFertilityRate() {
        return this.fertilityRate;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Health.
	
	 * @return String
	 */
	public String toString() {
		return "Health[" +lifeExpectancyAtBirthTotal+", "+totalPopulation+", "+lifeExpectancyAtBirthMale+", "+populationGrowth+", "+lifeExpectancyAtBirthFemale+", "+birthRate+", "+deathRate+", "+fertilityRate+"]";
	}
	
	/**
	 * Internal constructor to create a Health from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Health(JSONObject json_data) {
        try {// Life Expectancy at Birth, Total
            this.lifeExpectancyAtBirthTotal = ((Number)json_data.get("Life Expectancy at Birth, Total")).doubleValue();// Total Population
            this.totalPopulation = ((Number)json_data.get("Total Population")).doubleValue();// Life Expectancy at Birth, Male
            this.lifeExpectancyAtBirthMale = ((Number)json_data.get("Life Expectancy at Birth, Male")).doubleValue();// Population Growth
            this.populationGrowth = ((Number)json_data.get("Population Growth")).doubleValue();// Life Expectancy at Birth, Female
            this.lifeExpectancyAtBirthFemale = ((Number)json_data.get("Life Expectancy at Birth, Female")).doubleValue();// Birth Rate
            this.birthRate = ((Number)json_data.get("Birth Rate")).doubleValue();// Death Rate
            this.deathRate = ((Number)json_data.get("Death Rate")).doubleValue();// Fertility Rate
            this.fertilityRate = ((Number)json_data.get("Fertility Rate")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Health; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Health; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}