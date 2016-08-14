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
	
    private Integer airportsIntergovernmental;
    private Integer airportsTotalExpenditure;
    
    
    /*
     * @return 
     */
    public Integer getAirportsIntergovernmental() {
        return this.airportsIntergovernmental;
    }
    
    
    
    /*
     * @return 
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
        try {// Airports Intergovernmental
            this.airportsIntergovernmental = new Integer(((Long)json_data.get("Airports Intergovernmental")).intValue());// Airports Total Expenditure
            this.airportsTotalExpenditure = new Integer(((Long)json_data.get("Airports Total Expenditure")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Airports; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Airports; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}