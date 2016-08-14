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
public class Stats {
	
    private Integer biomass;
    private Integer height;
    
    
    /*
     * @return 
     */
    public Integer getBiomass() {
        return this.biomass;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHeight() {
        return this.height;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Stats.
	
	 * @return String
	 */
	public String toString() {
		return "Stats[" +biomass+", "+height+"]";
	}
	
	/**
	 * Internal constructor to create a Stats from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Stats(JSONObject json_data) {
        try {// biomass
            this.biomass = new Integer(((Long)json_data.get("biomass")).intValue());// height
            this.height = new Integer(((Long)json_data.get("height")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Stats; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Stats; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}