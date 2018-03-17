package corgis.energy.domain;

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
public class Production {
	
    // Coal production in billion BTU. Unfortunately, the other energy sources produced by the United States (including Natural Gas and Petroleum) could not be incorporated.
    private Double coal;
    
    
    /**
     * Coal production in billion BTU. Unfortunately, the other energy sources produced by the United States (including Natural Gas and Petroleum) could not be incorporated.
     * @return Double
     */
    public Double getCoal() {
        return this.coal;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Production.
	
	 * @return String
	 */
	public String toString() {
		return "Production[" +coal+"]";
	}
	
	/**
	 * Internal constructor to create a Production from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Production(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Coal
            this.coal = ((Number)json_data.get("Coal")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Production; the field coal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Production; the field coal had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}