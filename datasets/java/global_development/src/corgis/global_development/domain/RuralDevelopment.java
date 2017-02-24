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
public class RuralDevelopment {
	
    // Percent of land area
    private Double arableLandPercent;
    // Hectacres per person
    private Double arableLand;
    // Value of rural population
    private Integer ruralPopulation;
    // Percent of land area
    private Double agriculturalLandPercent;
    // Annual Percent
    private Double ruralPopulationGrowth;
    // Square kilometers
    private Double surfaceArea;
    // Square kilometers
    private Double agriculturalLand;
    // Square kilometers
    private Double landArea;
    
    
    /*
     * @return 
     */
    public Double getArableLandPercent() {
        return this.arableLandPercent;
    }
    
    
    
    /*
     * @return 
     */
    public Double getArableLand() {
        return this.arableLand;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getRuralPopulation() {
        return this.ruralPopulation;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAgriculturalLandPercent() {
        return this.agriculturalLandPercent;
    }
    
    
    
    /*
     * @return 
     */
    public Double getRuralPopulationGrowth() {
        return this.ruralPopulationGrowth;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSurfaceArea() {
        return this.surfaceArea;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAgriculturalLand() {
        return this.agriculturalLand;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLandArea() {
        return this.landArea;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this RuralDevelopment.
	
	 * @return String
	 */
	public String toString() {
		return "RuralDevelopment[" +arableLandPercent+", "+arableLand+", "+ruralPopulation+", "+agriculturalLandPercent+", "+ruralPopulationGrowth+", "+surfaceArea+", "+agriculturalLand+", "+landArea+"]";
	}
	
	/**
	 * Internal constructor to create a RuralDevelopment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public RuralDevelopment(JSONObject json_data) {
        try {// Arable Land Percent
            this.arableLandPercent = ((Number)json_data.get("Arable Land Percent")).doubleValue();// Arable Land
            this.arableLand = ((Number)json_data.get("Arable Land")).doubleValue();// Rural Population
            this.ruralPopulation = ((Number)json_data.get("Rural Population")).intValue();// Agricultural Land Percent
            this.agriculturalLandPercent = ((Number)json_data.get("Agricultural Land Percent")).doubleValue();// Rural Population Growth
            this.ruralPopulationGrowth = ((Number)json_data.get("Rural Population Growth")).doubleValue();// Surface Area
            this.surfaceArea = ((Number)json_data.get("Surface Area")).doubleValue();// Agricultural Land
            this.agriculturalLand = ((Number)json_data.get("Agricultural Land")).doubleValue();// Land Area
            this.landArea = ((Number)json_data.get("Land Area")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}