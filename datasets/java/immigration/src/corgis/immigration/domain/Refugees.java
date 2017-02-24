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
	
    // Refugee status is a form of protection that may be granted to people who meet the definition of refugee and who are of special humanitarian concern to the United States. Refugees are generally people outside of their country who are unable or unwilling to return home because they fear serious harm. This is the number that have arrived from the associated country in this year seeking refugee status and asylum.
    private Integer arrived;
    // Asylum status is a form of protection available to people who: (1) Meet the definition of refugee, (2) Are already in the United States, and (3) Are seeking admission at a port of entry. This is the number of people who have been granted aslyum in the USA from the associated country in this year.
    private Integer defensiveAsylum;
    // Refugee status is a form of protection that may be granted to people who meet the definition of refugee and who are of special humanitarian concern to the United States. Refugees are generally people outside of their country who are unable or unwilling to return home because they fear serious harm. This is the number that were granted refugee status from the associated country in this year.
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