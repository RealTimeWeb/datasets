package corgis.finance.domain;

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
public class Airports {
	
    // Money paid to other governments for the support of airports.
    private Integer airportsIntergovernmental;
    // Total amount spent on support for airports.
    private Integer airportsTotalExpenditure;
    
    
    /**
     * Money paid to other governments for the support of airports.
     * @return Integer
     */
    public Integer getAirportsIntergovernmental() {
        return this.airportsIntergovernmental;
    }
    
    
    
    /**
     * Total amount spent on support for airports.
     * @return Integer
     */
    public Integer getAirportsTotalExpenditure() {
        return this.airportsTotalExpenditure;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Airports.
	
	 * @return String
	 */
	public String toString() {
		return "Airports[" +airportsIntergovernmental+", "+airportsTotalExpenditure+"]";
	}
	
	/**
	 * Internal constructor to create a Airports from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Airports(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Airports Intergovernmental
            this.airportsIntergovernmental = ((Number)json_data.get("Airports Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Airports; the field airportsIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Airports; the field airportsIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Airports Total Expenditure
            this.airportsTotalExpenditure = ((Number)json_data.get("Airports Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Airports; the field airportsTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Airports; the field airportsTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}