package corgis.labor.domain;

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
public class EmploymentPopulationRatio {
	
    private Double women;
    private Double men;
    private Double all;
    
    
    /**
     * 
     * @return Double
     */
    public Double getWomen() {
        return this.women;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getMen() {
        return this.men;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getAll() {
        return this.all;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Employment-PopulationRatio.
	
	 * @return String
	 */
	public String toString() {
		return "Employment-PopulationRatio[" +women+", "+men+", "+all+"]";
	}
	
	/**
	 * Internal constructor to create a Employment-PopulationRatio from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public EmploymentPopulationRatio(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Women
            this.women = ((Number)json_data.get("Women")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment-PopulationRatio; the field women was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment-PopulationRatio; the field women had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Men
            this.men = ((Number)json_data.get("Men")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment-PopulationRatio; the field men was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment-PopulationRatio; the field men had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // All
            this.all = ((Number)json_data.get("All")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment-PopulationRatio; the field all was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment-PopulationRatio; the field all had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}