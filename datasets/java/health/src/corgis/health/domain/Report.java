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
	
    private String loc;
    private Integer number;
    private String disease;
    private Double increase;
    private Integer year;
    private Integer population;
    
    
    /*
     * @return 
     */
    public String getLoc() {
        return this.loc;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNumber() {
        return this.number;
    }
    
    
    
    /*
     * @return 
     */
    public String getDisease() {
        return this.disease;
    }
    
    
    
    /*
     * @return 
     */
    public Double getIncrease() {
        return this.increase;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPopulation() {
        return this.population;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Report.
	
	 * @return String
	 */
	public String toString() {
		return "Report[" +loc+", "+number+", "+disease+", "+increase+", "+year+", "+population+"]";
	}
	
	/**
	 * Internal constructor to create a Report from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Report(JSONObject json_data) {
        try {// loc
            this.loc = (String)json_data.get("loc");// number
            this.number = ((Number)json_data.get("number")).intValue();// disease
            this.disease = (String)json_data.get("disease");// increase
            this.increase = ((Number)json_data.get("increase")).doubleValue();// year
            this.year = ((Number)json_data.get("year")).intValue();// population
            this.population = ((Number)json_data.get("population")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}