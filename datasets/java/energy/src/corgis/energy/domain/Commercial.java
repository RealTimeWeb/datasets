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
public class Commercial {
	
    // Kerosene price in the commercial sector in dollars per million BTU.
    private Integer kerosene;
    // Natural gas price in the commercial sector (including supplemental gaseous fuels) in dollars per million BTU.
    private Integer naturalGas;
    // Distillate fuel oil price in the commercial sector in dollars per million BTU.
    private Integer distillateFuelOil;
    // LPG price in the commercial sector in dollars per million BTU.
    private Integer liquefiedPetroleumGases;
    // Coal price in the commercial sector in dollars per million BTU.
    private Integer coal;
    
    
    /**
     * Kerosene price in the commercial sector in dollars per million BTU.
     * @return Integer
     */
    public Integer getKerosene() {
        return this.kerosene;
    }
    
    
    
    /**
     * Natural gas price in the commercial sector (including supplemental gaseous fuels) in dollars per million BTU.
     * @return Integer
     */
    public Integer getNaturalGas() {
        return this.naturalGas;
    }
    
    
    
    /**
     * Distillate fuel oil price in the commercial sector in dollars per million BTU.
     * @return Integer
     */
    public Integer getDistillateFuelOil() {
        return this.distillateFuelOil;
    }
    
    
    
    /**
     * LPG price in the commercial sector in dollars per million BTU.
     * @return Integer
     */
    public Integer getLiquefiedPetroleumGases() {
        return this.liquefiedPetroleumGases;
    }
    
    
    
    /**
     * Coal price in the commercial sector in dollars per million BTU.
     * @return Integer
     */
    public Integer getCoal() {
        return this.coal;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Commercial.
	
	 * @return String
	 */
	public String toString() {
		return "Commercial[" +kerosene+", "+naturalGas+", "+distillateFuelOil+", "+liquefiedPetroleumGases+", "+coal+"]";
	}
	
	/**
	 * Internal constructor to create a Commercial from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Commercial(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Kerosene
            this.kerosene = ((Number)json_data.get("Kerosene")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Commercial; the field kerosene was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Commercial; the field kerosene had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Natural Gas
            this.naturalGas = ((Number)json_data.get("Natural Gas")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Commercial; the field naturalGas was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Commercial; the field naturalGas had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Distillate Fuel Oil
            this.distillateFuelOil = ((Number)json_data.get("Distillate Fuel Oil")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Commercial; the field distillateFuelOil was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Commercial; the field distillateFuelOil had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Liquefied Petroleum Gases
            this.liquefiedPetroleumGases = ((Number)json_data.get("Liquefied Petroleum Gases")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Commercial; the field liquefiedPetroleumGases was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Commercial; the field liquefiedPetroleumGases had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Coal
            this.coal = ((Number)json_data.get("Coal")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Commercial; the field coal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Commercial; the field coal had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}