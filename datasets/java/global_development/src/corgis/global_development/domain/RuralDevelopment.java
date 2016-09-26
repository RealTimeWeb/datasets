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
	
    // Square kilometers
    private Double surfaceArea;
    // Hectacres per person
    private Double arableLand;
    // Percent of total population
    private Double ruralPopulation;
    // Percent of land area
    private Double agriculturalLandPercent;
    // Annual Percent
    private Double ruralPopulationGrowth;
    // Percent of land area
    private Double arableLandPercent;
    // Square kilometers
    private Double agriculturalLand;
    // Square kilometers
    private Double landArea;
    
    
    /*
     * @return 
     */
    public Double getSurfaceArea() {
        return this.surfaceArea;
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
    public Double getRuralPopulation() {
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
    public Double getArableLandPercent() {
        return this.arableLandPercent;
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
		return "RuralDevelopment[" +surfaceArea+", "+arableLand+", "+ruralPopulation+", "+agriculturalLandPercent+", "+ruralPopulationGrowth+", "+arableLandPercent+", "+agriculturalLand+", "+landArea+"]";
	}
	
	/**
	 * Internal constructor to create a RuralDevelopment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public RuralDevelopment(JSONObject json_data) {
        try {// Surface Area
            this.surfaceArea = (Double)json_data.get("Surface Area");// Arable Land
            this.arableLand = (Double)json_data.get("Arable Land");// Rural Population
            this.ruralPopulation = (Double)json_data.get("Rural Population");// Agricultural Land Percent
            this.agriculturalLandPercent = (Double)json_data.get("Agricultural Land Percent");// Rural Population Growth
            this.ruralPopulationGrowth = (Double)json_data.get("Rural Population Growth");// Arable Land Percent
            this.arableLandPercent = (Double)json_data.get("Arable Land Percent");// Agricultural Land
            this.agriculturalLand = (Double)json_data.get("Agricultural Land");// Land Area
            this.landArea = (Double)json_data.get("Land Area");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}