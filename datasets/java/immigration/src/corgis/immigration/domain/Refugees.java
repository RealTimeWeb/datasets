package corgis.immigration.domain;

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
public class Refugees {
	
    private Integer arrived;
    private Integer defensiveAsylum;
    private Integer affirmative;
    
    
    /*
     * @return 
     */
    public Integer getArrived() {
        return this.arrived;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getDefensiveAsylum() {
        return this.defensiveAsylum;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAffirmative() {
        return this.affirmative;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Refugees.
	
	 * @return String
	 */
	public String toString() {
		return "Refugees[" +arrived+", "+defensiveAsylum+", "+affirmative+"]";
	}
	
	/**
	 * Internal constructor to create a Refugees from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Refugees(JSONObject json_data) {
        try {// Arrived
            this.arrived = ((Number)json_data.get("Arrived")).intValue();// Defensive Asylum
            this.defensiveAsylum = ((Number)json_data.get("Defensive Asylum")).intValue();// Affirmative
            this.affirmative = ((Number)json_data.get("Affirmative")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Refugees; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Refugees; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}