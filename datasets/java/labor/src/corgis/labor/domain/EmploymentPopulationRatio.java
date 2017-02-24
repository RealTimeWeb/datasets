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
	
    private Double all;
    private Double men;
    private Double women;
    
    
    /*
     * @return 
     */
    public Double getAll() {
        return this.all;
    }
    
    
    
    /*
     * @return 
     */
    public Double getMen() {
        return this.men;
    }
    
    
    
    /*
     * @return 
     */
    public Double getWomen() {
        return this.women;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Employment-PopulationRatio.
	
	 * @return String
	 */
	public String toString() {
		return "Employment-PopulationRatio[" +all+", "+men+", "+women+"]";
	}
	
	/**
	 * Internal constructor to create a Employment-PopulationRatio from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public EmploymentPopulationRatio(JSONObject json_data) {
        try {// All
            this.all = ((Number)json_data.get("All")).doubleValue();// Men
            this.men = ((Number)json_data.get("Men")).doubleValue();// Women
            this.women = ((Number)json_data.get("Women")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment-PopulationRatio; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment-PopulationRatio; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}