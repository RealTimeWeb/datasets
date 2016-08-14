package corgis.globaldevelopment.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.globaldevelopment.domain.AgriculureAndRuralDevelopment;
import corgis.globaldevelopment.domain.Infrastructure;
import corgis.globaldevelopment.domain.Health;
import corgis.globaldevelopment.domain.UrbanDevelopment;

/**
 * 
 */
public class Data {
	
    private AgriculureAndRuralDevelopment agriculureAndRuralDevelopment;
    private Infrastructure infrastructure;
    private Health health;
    private UrbanDevelopment urbanDevelopment;
    
    
    /*
     * @return 
     */
    public AgriculureAndRuralDevelopment getAgriculureAndRuralDevelopment() {
        return this.agriculureAndRuralDevelopment;
    }
    
    
    
    /*
     * @return 
     */
    public Infrastructure getInfrastructure() {
        return this.infrastructure;
    }
    
    
    
    /*
     * @return 
     */
    public Health getHealth() {
        return this.health;
    }
    
    
    
    /*
     * @return 
     */
    public UrbanDevelopment getUrbanDevelopment() {
        return this.urbanDevelopment;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +agriculureAndRuralDevelopment+", "+infrastructure+", "+health+", "+urbanDevelopment+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// Agriculure and Rural Development
            this.agriculureAndRuralDevelopment = new AgriculureAndRuralDevelopment((JSONObject)json_data.get("Agriculure and Rural Development"));// Infrastructure
            this.infrastructure = new Infrastructure((JSONObject)json_data.get("Infrastructure"));// Health
            this.health = new Health((JSONObject)json_data.get("Health"));// Urban Development
            this.urbanDevelopment = new UrbanDevelopment((JSONObject)json_data.get("Urban Development"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}