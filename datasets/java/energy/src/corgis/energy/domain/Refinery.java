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
public class Refinery {
	
    // Coal consumed as refinery fuel in billion BTU.
    private Integer coal;
    // Distillate fuel oil consumed as refinery fuel in billion BTU.
    private Integer distillateFuelOil;
    // Natural gas consumed as refinery fuel (including supplemental gaseous fuels) in billion BTU.
    private Integer naturalGas;
    // LPG consumed as refinery fuel in billion BTU.
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
	 * Creates a string based representation of this Refinery.
	
	 * @return String
	 */
	public String toString() {
		return "Refinery[" +coal+", "+distillateFuelOil+", "+naturalGas+", "+liquefiedPetroleumGases+"]";
	}
	
	/**
	 * Internal constructor to create a Refinery from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Refinery(JSONObject json_data) {
        try {// Coal
            this.coal = ((Number)json_data.get("Coal")).intValue();// Distillate Fuel Oil
            this.distillateFuelOil = ((Number)json_data.get("Distillate Fuel Oil")).intValue();// Natural Gas
            this.naturalGas = ((Number)json_data.get("Natural Gas")).intValue();// Liquefied Petroleum Gases
            this.liquefiedPetroleumGases = ((Number)json_data.get("Liquefied Petroleum Gases")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Refinery; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Refinery; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}