package corgis.global_development.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.global_development.domain.Health;
import corgis.global_development.domain.RuralDevelopment;
import corgis.global_development.domain.Infrastructure;
import corgis.global_development.domain.UrbanDevelopment;

/**
 * 
 */
public class Data {
	
    private Health health;
    private RuralDevelopment ruralDevelopment;
    private Infrastructure infrastructure;
    private UrbanDevelopment urbanDevelopment;
    
    
    /**
     * 
     * @return Health
     */
    public Health getHealth() {
        return this.health;
    }
    
    
    
    /**
     * 
     * @return RuralDevelopment
     */
    public RuralDevelopment getRuralDevelopment() {
        return this.ruralDevelopment;
    }
    
    
    
    /**
     * 
     * @return Infrastructure
     */
    public Infrastructure getInfrastructure() {
        return this.infrastructure;
    }
    
    
    
    /**
     * 
     * @return UrbanDevelopment
     */
    public UrbanDevelopment getUrbanDevelopment() {
        return this.urbanDevelopment;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +health+", "+ruralDevelopment+", "+infrastructure+", "+urbanDevelopment+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Health
            this.health = new Health((JSONObject)json_data.get("Health"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field health was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field health had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Rural Development
            this.ruralDevelopment = new RuralDevelopment((JSONObject)json_data.get("Rural Development"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field ruralDevelopment was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field ruralDevelopment had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Infrastructure
            this.infrastructure = new Infrastructure((JSONObject)json_data.get("Infrastructure"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field infrastructure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field infrastructure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Urban Development
            this.urbanDevelopment = new UrbanDevelopment((JSONObject)json_data.get("Urban Development"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field urbanDevelopment was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field urbanDevelopment had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}