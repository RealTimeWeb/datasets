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
public class Transportation {
	
    // Coal price in the transportation sector in dollars per million BTU.
    private Integer coal;
    // Distillate fuel oil price in the transportation sector in dollars per million BTU.
    private Integer distillateFuelOil;
    // Natural gas price in the transportation sector in dollars per million BTU.
    private Integer naturalGas;
    // LPG price in the transportation sector in dollars per million BTU.
    private Integer liquefiedPetroleumGases;
    
    
    /*
     * @return 
     */
    public Integer getCoal() {
        return this.coal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getDistillateFuelOil() {
        return this.distillateFuelOil;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNaturalGas() {
        return this.naturalGas;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLiquefiedPetroleumGases() {
        return this.liquefiedPetroleumGases;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Transportation.
	
	 * @return String
	 */
	public String toString() {
		return "Transportation[" +coal+", "+distillateFuelOil+", "+naturalGas+", "+liquefiedPetroleumGases+"]";
	}
	
	/**
	 * Internal constructor to create a Transportation from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Transportation(JSONObject json_data) {
        try {// Coal
            this.coal = ((Number)json_data.get("Coal")).intValue();// Distillate Fuel Oil
            this.distillateFuelOil = ((Number)json_data.get("Distillate Fuel Oil")).intValue();// Natural Gas
            this.naturalGas = ((Number)json_data.get("Natural Gas")).intValue();// Liquefied Petroleum Gases
            this.liquefiedPetroleumGases = ((Number)json_data.get("Liquefied Petroleum Gases")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Transportation; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Transportation; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}