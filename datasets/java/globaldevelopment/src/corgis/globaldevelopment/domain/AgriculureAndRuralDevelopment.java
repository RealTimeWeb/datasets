package corgis.globaldevelopment.domain;

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
public class AgriculureAndRuralDevelopment {
	
    private Double arableLandPercent;
    private Double arableLand;
    private Double ruralPopulation;
    private Double agriculturalLandPercent;
    private Double ruralPopulationGrowth;
    private Double surfaceArea;
    private Double agriculturalLand;
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
	 * Creates a string based representation of this AgriculureAndRuralDevelopment.
	
	 * @return String
	 */
	public String toString() {
		return "AgriculureAndRuralDevelopment[" +arableLandPercent+", "+arableLand+", "+ruralPopulation+", "+agriculturalLandPercent+", "+ruralPopulationGrowth+", "+surfaceArea+", "+agriculturalLand+", "+landArea+"]";
	}
	
	/**
	 * Internal constructor to create a AgriculureAndRuralDevelopment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public AgriculureAndRuralDevelopment(JSONObject json_data) {
        try {// Arable Land Percent
            this.arableLandPercent = (Double)json_data.get("Arable Land Percent");// Arable Land
            this.arableLand = (Double)json_data.get("Arable Land");// Rural Population
            this.ruralPopulation = (Double)json_data.get("Rural Population");// Agricultural Land Percent
            this.agriculturalLandPercent = (Double)json_data.get("Agricultural Land Percent");// Rural Population Growth
            this.ruralPopulationGrowth = (Double)json_data.get("Rural Population Growth");// Surface Area
            this.surfaceArea = (Double)json_data.get("Surface Area");// Agricultural Land
            this.agriculturalLand = (Double)json_data.get("Agricultural Land");// Land Area
            this.landArea = (Double)json_data.get("Land Area");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a AgriculureAndRuralDevelopment; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a AgriculureAndRuralDevelopment; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}