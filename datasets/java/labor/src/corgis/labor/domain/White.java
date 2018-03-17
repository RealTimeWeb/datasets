package corgis.labor.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.labor.domain.Counts;
import corgis.labor.domain.EmploymentPopulationRatio;

/**
 * 
 */
public class White {
	
    private Counts counts;
    private EmploymentPopulationRatio employmentPopulationRatio;
    
    
    /**
     * 
     * @return Counts
     */
    public Counts getCounts() {
        return this.counts;
    }
    
    
    
    /**
     * 
     * @return EmploymentPopulationRatio
     */
    public EmploymentPopulationRatio getEmploymentPopulationRatio() {
        return this.employmentPopulationRatio;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this White.
	
	 * @return String
	 */
	public String toString() {
		return "White[" +counts+", "+employmentPopulationRatio+"]";
	}
	
	/**
	 * Internal constructor to create a White from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public White(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Counts
            this.counts = new Counts((JSONObject)json_data.get("Counts"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a White; the field counts was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a White; the field counts had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Employment-Population Ratio
            this.employmentPopulationRatio = new EmploymentPopulationRatio((JSONObject)json_data.get("Employment-Population Ratio"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a White; the field employmentPopulationRatio was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a White; the field employmentPopulationRatio had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}