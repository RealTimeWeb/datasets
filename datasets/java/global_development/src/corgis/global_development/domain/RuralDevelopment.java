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
	
    // Annual Percent
    private Double ruralPopulationGrowth;
    // Square kilometers
    private Double surfaceArea;
    // Square kilometers
    private Double landArea;
    // Hectacres per person
    private Double arableLand;
    // Square kilometers
    private Double agriculturalLand;
    // Percent of land area
    private Double arableLandPercent;
    // Percent of land area
    private Double agriculturalLandPercent;
    // Value of rural population
    private Integer ruralPopulation;
    
    
    /**
     * Annual Percent
     * @return Double
     */
    public Double getRuralPopulationGrowth() {
        return this.ruralPopulationGrowth;
    }
    
    
    
    /**
     * Square kilometers
     * @return Double
     */
    public Double getSurfaceArea() {
        return this.surfaceArea;
    }
    
    
    
    /**
     * Square kilometers
     * @return Double
     */
    public Double getLandArea() {
        return this.landArea;
    }
    
    
    
    /**
     * Hectacres per person
     * @return Double
     */
    public Double getArableLand() {
        return this.arableLand;
    }
    
    
    
    /**
     * Square kilometers
     * @return Double
     */
    public Double getAgriculturalLand() {
        return this.agriculturalLand;
    }
    
    
    
    /**
     * Percent of land area
     * @return Double
     */
    public Double getArableLandPercent() {
        return this.arableLandPercent;
    }
    
    
    
    /**
     * Percent of land area
     * @return Double
     */
    public Double getAgriculturalLandPercent() {
        return this.agriculturalLandPercent;
    }
    
    
    
    /**
     * Value of rural population
     * @return Integer
     */
    public Integer getRuralPopulation() {
        return this.ruralPopulation;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this RuralDevelopment.
	
	 * @return String
	 */
	public String toString() {
		return "RuralDevelopment[" +ruralPopulationGrowth+", "+surfaceArea+", "+landArea+", "+arableLand+", "+agriculturalLand+", "+arableLandPercent+", "+agriculturalLandPercent+", "+ruralPopulation+"]";
	}
	
	/**
	 * Internal constructor to create a RuralDevelopment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public RuralDevelopment(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Rural Population Growth
            this.ruralPopulationGrowth = ((Number)json_data.get("Rural Population Growth")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; the field ruralPopulationGrowth was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; the field ruralPopulationGrowth had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Surface Area
            this.surfaceArea = ((Number)json_data.get("Surface Area")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; the field surfaceArea was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; the field surfaceArea had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Land Area
            this.landArea = ((Number)json_data.get("Land Area")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; the field landArea was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; the field landArea had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Arable Land
            this.arableLand = ((Number)json_data.get("Arable Land")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; the field arableLand was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; the field arableLand had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Agricultural Land
            this.agriculturalLand = ((Number)json_data.get("Agricultural Land")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; the field agriculturalLand was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; the field agriculturalLand had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Arable Land Percent
            this.arableLandPercent = ((Number)json_data.get("Arable Land Percent")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; the field arableLandPercent was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; the field arableLandPercent had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Agricultural Land Percent
            this.agriculturalLandPercent = ((Number)json_data.get("Agricultural Land Percent")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; the field agriculturalLandPercent was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; the field agriculturalLandPercent had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Rural Population
            this.ruralPopulation = ((Number)json_data.get("Rural Population")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; the field ruralPopulation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a RuralDevelopment; the field ruralPopulation had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}