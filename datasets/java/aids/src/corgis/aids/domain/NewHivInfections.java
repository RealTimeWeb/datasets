package corgis.aids.domain;

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
public class NewHivInfections {
	
    // The number of reported cases of AIDS in female adults (15+ years old).
    private Double femaleAdults;
    // The total number of reported cases of AIDS in this year.
    private Integer allAges;
    // The number of reported cases of AIDS in male adults (15+ years old).
    private Integer maleAdults;
    // The number of reported cases of AIDS in all adults (15+ years old).
    private Integer adults;
    // The number of reported cases of AIDS in adults (15-49 years old).
    private Double incidenceRateAmongAdults;
    // The number of reported cases of AIDS in children (0-14 years old).
    private Integer children;
    
    
    /**
     * The number of reported cases of AIDS in female adults (15+ years old).
     * @return Double
     */
    public Double getFemaleAdults() {
        return this.femaleAdults;
    }
    
    
    
    /**
     * The total number of reported cases of AIDS in this year.
     * @return Integer
     */
    public Integer getAllAges() {
        return this.allAges;
    }
    
    
    
    /**
     * The number of reported cases of AIDS in male adults (15+ years old).
     * @return Integer
     */
    public Integer getMaleAdults() {
        return this.maleAdults;
    }
    
    
    
    /**
     * The number of reported cases of AIDS in all adults (15+ years old).
     * @return Integer
     */
    public Integer getAdults() {
        return this.adults;
    }
    
    
    
    /**
     * The number of reported cases of AIDS in adults (15-49 years old).
     * @return Double
     */
    public Double getIncidenceRateAmongAdults() {
        return this.incidenceRateAmongAdults;
    }
    
    
    
    /**
     * The number of reported cases of AIDS in children (0-14 years old).
     * @return Integer
     */
    public Integer getChildren() {
        return this.children;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this NewHivInfections.
	
	 * @return String
	 */
	public String toString() {
		return "NewHivInfections[" +femaleAdults+", "+allAges+", "+maleAdults+", "+adults+", "+incidenceRateAmongAdults+", "+children+"]";
	}
	
	/**
	 * Internal constructor to create a NewHivInfections from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public NewHivInfections(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Female Adults
            this.femaleAdults = ((Number)json_data.get("Female Adults")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NewHivInfections; the field femaleAdults was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NewHivInfections; the field femaleAdults had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // All Ages
            this.allAges = ((Number)json_data.get("All Ages")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NewHivInfections; the field allAges was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NewHivInfections; the field allAges had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Male Adults
            this.maleAdults = ((Number)json_data.get("Male Adults")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NewHivInfections; the field maleAdults was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NewHivInfections; the field maleAdults had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Adults
            this.adults = ((Number)json_data.get("Adults")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NewHivInfections; the field adults was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NewHivInfections; the field adults had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Incidence Rate Among Adults
            this.incidenceRateAmongAdults = ((Number)json_data.get("Incidence Rate Among Adults")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NewHivInfections; the field incidenceRateAmongAdults was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NewHivInfections; the field incidenceRateAmongAdults had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Children
            this.children = ((Number)json_data.get("Children")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NewHivInfections; the field children was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NewHivInfections; the field children had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}