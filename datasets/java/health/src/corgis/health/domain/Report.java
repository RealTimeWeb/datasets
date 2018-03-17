package corgis.health.domain;

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
public class Report {
	
    private Integer population;
    private Integer number;
    private String loc;
    private Double increase;
    private String disease;
    private Integer year;
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getPopulation() {
        return this.population;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getNumber() {
        return this.number;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getLoc() {
        return this.loc;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getIncrease() {
        return this.increase;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getDisease() {
        return this.disease;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Report.
	
	 * @return String
	 */
	public String toString() {
		return "Report[" +population+", "+number+", "+loc+", "+increase+", "+disease+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Report from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Report(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // population
            this.population = ((Number)json_data.get("population")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field population was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field population had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // number
            this.number = ((Number)json_data.get("number")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field number was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field number had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // loc
            this.loc = (String)json_data.get("loc");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field loc was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field loc had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // increase
            this.increase = ((Number)json_data.get("increase")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field increase was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field increase had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // disease
            this.disease = (String)json_data.get("disease");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field disease was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field disease had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // year
            this.year = ((Number)json_data.get("year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}