package corgis.johnsongrass.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.johnsongrass.domain.Stats;
import corgis.johnsongrass.domain.Genotype;
import corgis.johnsongrass.domain.Site;

/**
 * 
 */
public class Johnsongrass {
	
    private Stats stats;
    private Genotype genotype;
    private Site site;
    
    
    /*
     * @return 
     */
    public Stats getStats() {
        return this.stats;
    }
    
    
    
    /*
     * @return 
     */
    public Genotype getGenotype() {
        return this.genotype;
    }
    
    
    
    /*
     * @return 
     */
    public Site getSite() {
        return this.site;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Johnsongrass.
	
	 * @return String
	 */
	public String toString() {
		return "Johnsongrass[" +stats+", "+genotype+", "+site+"]";
	}
	
	/**
	 * Internal constructor to create a Johnsongrass from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Johnsongrass(JSONObject json_data) {
        try {// stats
            this.stats = new Stats((JSONObject)json_data.get("stats"));// genotype
            this.genotype = new Genotype((JSONObject)json_data.get("genotype"));// site
            this.site = new Site((JSONObject)json_data.get("site"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Johnsongrass; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Johnsongrass; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}