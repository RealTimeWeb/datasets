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
public class Parks {
	
    // Money paid to other governments for the provision and support of recreational and cultural-scientific facilities and activities including golf courses, play fields, playgrounds, public beaches, swimming pools, tennis courts, parks, auditoriums, stadiums, auto camps, recreation piers, marinas, botanical gardens, galleries, museums, and zoos. Also includes building and operation of convention centers and exhibition halls. Public libraries are included under Libraries.
    private Integer parksIntergovernmental;
    // Total amount spent on provision and support of recreational and cultural-scientific facilities and activities including golf courses, play fields, playgrounds, public beaches, swimming pools, tennis courts, parks, auditoriums, stadiums, auto camps, recreation piers, marinas, botanical gardens, galleries, museums, and zoos. Also includes building and operation of convention centers and exhibition halls. Public libraries are included under Libraries.
    private Integer parksTotalExpenditure;
    
    
    /**
     * Money paid to other governments for the provision and support of recreational and cultural-scientific facilities and activities including golf courses, play fields, playgrounds, public beaches, swimming pools, tennis courts, parks, auditoriums, stadiums, auto camps, recreation piers, marinas, botanical gardens, galleries, museums, and zoos. Also includes building and operation of convention centers and exhibition halls. Public libraries are included under Libraries.
     * @return Integer
     */
    public Integer getParksIntergovernmental() {
        return this.parksIntergovernmental;
    }
    
    
    
    /**
     * Total amount spent on provision and support of recreational and cultural-scientific facilities and activities including golf courses, play fields, playgrounds, public beaches, swimming pools, tennis courts, parks, auditoriums, stadiums, auto camps, recreation piers, marinas, botanical gardens, galleries, museums, and zoos. Also includes building and operation of convention centers and exhibition halls. Public libraries are included under Libraries.
     * @return Integer
     */
    public Integer getParksTotalExpenditure() {
        return this.parksTotalExpenditure;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Parks.
	
	 * @return String
	 */
	public String toString() {
		return "Parks[" +parksIntergovernmental+", "+parksTotalExpenditure+"]";
	}
	
	/**
	 * Internal constructor to create a Parks from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Parks(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Parks Intergovernmental
            this.parksIntergovernmental = ((Number)json_data.get("Parks Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Parks; the field parksIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Parks; the field parksIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Parks Total Expenditure
            this.parksTotalExpenditure = ((Number)json_data.get("Parks Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Parks; the field parksTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Parks; the field parksTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}