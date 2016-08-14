package corgis.johnsongrass.domain;

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
public class Genotype {
	
    private Integer geneticCluster;
    private Integer id;
    
    
    /*
     * @return 
     */
    public Integer getGeneticCluster() {
        return this.geneticCluster;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Genotype.
	
	 * @return String
	 */
	public String toString() {
		return "Genotype[" +geneticCluster+", "+id+"]";
	}
	
	/**
	 * Internal constructor to create a Genotype from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Genotype(JSONObject json_data) {
        try {// genetic cluster
            this.geneticCluster = new Integer(((Long)json_data.get("genetic cluster")).intValue());// id
            this.id = new Integer(((Long)json_data.get("id")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Genotype; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Genotype; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}