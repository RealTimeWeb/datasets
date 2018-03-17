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
	
    // Crude, per 100 People
    private Double deathRate;
    // Total, Births per woman
    private Double fertilityRate;
    // Years
    private Double lifeExpectancyAtBirthFemale;
    // Crude, per 1000 People
    private Double birthRate;
    private Double totalPopulation;
    // Years
    private Double lifeExpectancyAtBirthMale;
    // Annual Percent
    private Double populationGrowth;
    // Years
    private Double lifeExpectancyAtBirthTotal;
    
    
    /**
     * Crude, per 100 People
     * @return Double
     */
    public Double getDeathRate() {
        return this.deathRate;
    }
    
    
    
    /**
     * Total, Births per woman
     * @return Double
     */
    public Double getFertilityRate() {
        return this.fertilityRate;
    }
    
    
    
    /**
     * Years
     * @return Double
     */
    public Double getLifeExpectancyAtBirthFemale() {
        return this.lifeExpectancyAtBirthFemale;
    }
    
    
    
    /**
     * Crude, per 1000 People
     * @return Double
     */
    public Double getBirthRate() {
        return this.birthRate;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getTotalPopulation() {
        return this.totalPopulation;
    }
    
    
    
    /**
     * Years
     * @return Double
     */
    public Double getLifeExpectancyAtBirthMale() {
        return this.lifeExpectancyAtBirthMale;
    }
    
    
    
    /**
     * Annual Percent
     * @return Double
     */
    public Double getPopulationGrowth() {
        return this.populationGrowth;
    }
    
    
    
    /**
     * Years
     * @return Double
     */
    public Double getLifeExpectancyAtBirthTotal() {
        return this.lifeExpectancyAtBirthTotal;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Health.
	
	 * @return String
	 */
	public String toString() {
		return "Health[" +deathRate+", "+fertilityRate+", "+lifeExpectancyAtBirthFemale+", "+birthRate+", "+totalPopulation+", "+lifeExpectancyAtBirthMale+", "+populationGrowth+", "+lifeExpectancyAtBirthTotal+"]";
	}
	
	/**
	 * Internal constructor to create a Health from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Health(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Death Rate
            this.deathRate = ((Number)json_data.get("Death Rate")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Health; the field deathRate was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Health; the field deathRate had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Fertility Rate
            this.fertilityRate = ((Number)json_data.get("Fertility Rate")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Health; the field fertilityRate was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Health; the field fertilityRate had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Life Expectancy at Birth, Female
            this.lifeExpectancyAtBirthFemale = ((Number)json_data.get("Life Expectancy at Birth, Female")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Health; the field lifeExpectancyAtBirthFemale was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Health; the field lifeExpectancyAtBirthFemale had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Birth Rate
            this.birthRate = ((Number)json_data.get("Birth Rate")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Health; the field birthRate was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Health; the field birthRate had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Total Population
            this.totalPopulation = ((Number)json_data.get("Total Population")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Health; the field totalPopulation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Health; the field totalPopulation had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Life Expectancy at Birth, Male
            this.lifeExpectancyAtBirthMale = ((Number)json_data.get("Life Expectancy at Birth, Male")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Health; the field lifeExpectancyAtBirthMale was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Health; the field lifeExpectancyAtBirthMale had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Population Growth
            this.populationGrowth = ((Number)json_data.get("Population Growth")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Health; the field populationGrowth was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Health; the field populationGrowth had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Life Expectancy at Birth, Total
            this.lifeExpectancyAtBirthTotal = ((Number)json_data.get("Life Expectancy at Birth, Total")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Health; the field lifeExpectancyAtBirthTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Health; the field lifeExpectancyAtBirthTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}