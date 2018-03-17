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
	
    // Natural gas consumed as refinery fuel (including supplemental gaseous fuels) in billion BTU.
    private Integer naturalGas;
    // Distillate fuel oil consumed as refinery fuel in billion BTU.
    private Integer distillateFuelOil;
    // LPG consumed as refinery fuel in billion BTU.
    private Integer liquefiedPetroleumGases;
    // Coal consumed as refinery fuel in billion BTU.
    private Integer coal;
    
    
    /**
     * Natural gas consumed as refinery fuel (including supplemental gaseous fuels) in billion BTU.
     * @return Integer
     */
    public Integer getNaturalGas() {
        return this.naturalGas;
    }
    
    
    
    /**
     * Distillate fuel oil consumed as refinery fuel in billion BTU.
     * @return Integer
     */
    public Integer getDistillateFuelOil() {
        return this.distillateFuelOil;
    }
    
    
    
    /**
     * LPG consumed as refinery fuel in billion BTU.
     * @return Integer
     */
    public Integer getLiquefiedPetroleumGases() {
        return this.liquefiedPetroleumGases;
    }
    
    
    
    /**
     * Coal consumed as refinery fuel in billion BTU.
     * @return Integer
     */
    public Integer getCoal() {
        return this.coal;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Refinery.
	
	 * @return String
	 */
	public String toString() {
		return "Refinery[" +naturalGas+", "+distillateFuelOil+", "+liquefiedPetroleumGases+", "+coal+"]";
	}
	
	/**
	 * Internal constructor to create a Refinery from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Refinery(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Natural Gas
            this.naturalGas = ((Number)json_data.get("Natural Gas")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Refinery; the field naturalGas was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Refinery; the field naturalGas had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Distillate Fuel Oil
            this.distillateFuelOil = ((Number)json_data.get("Distillate Fuel Oil")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Refinery; the field distillateFuelOil was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Refinery; the field distillateFuelOil had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Liquefied Petroleum Gases
            this.liquefiedPetroleumGases = ((Number)json_data.get("Liquefied Petroleum Gases")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Refinery; the field liquefiedPetroleumGases was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Refinery; the field liquefiedPetroleumGases had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Coal
            this.coal = ((Number)json_data.get("Coal")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Refinery; the field coal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Refinery; the field coal had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}