package corgis.global_development.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.global_development.domain.Infrastructure;
import corgis.global_development.domain.Health;
import corgis.global_development.domain.UrbanDevelopment;
import corgis.global_development.domain.RuralDevelopment;

/**
 * 
 */
public class Data {
	
    private Infrastructure infrastructure;
    private Health health;
    private UrbanDevelopment urbanDevelopment;
    private RuralDevelopment ruralDevelopment;
    
    
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
    
    
    
    /*
     * @return 
     */
    public RuralDevelopment getRuralDevelopment() {
        return this.ruralDevelopment;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +infrastructure+", "+health+", "+urbanDevelopment+", "+ruralDevelopment+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// Infrastructure
            this.infrastructure = new Infrastructure((JSONObject)json_data.get("Infrastructure"));// Health
            this.health = new Health((JSONObject)json_data.get("Health"));// Urban Development
            this.urbanDevelopment = new UrbanDevelopment((JSONObject)json_data.get("Urban Development"));// Rural Development
            this.ruralDevelopment = new RuralDevelopment((JSONObject)json_data.get("Rural Development"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}