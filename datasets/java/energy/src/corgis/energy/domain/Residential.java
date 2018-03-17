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
public class Residential {
	
    // Natural gas expenditures in the residential sector (including supplemental gaseous fuels) in million dollars.
    private Integer naturalGas;
    // Distillate fuel oil expenditures in the residential sector in million dollars.
    private Integer distillateFuelOil;
    // Wood expenditures in the residential sector in million dollars.
    private Integer wood;
    // Coal expenditures in the residential sector in million dollars.
    private Integer coal;
    // Kerosene expenditures in the residential sector in million dollars.
    private Integer kerosene;
    // LPG expenditures in the residential sector in million dollars.
    private Integer liquefiedPetroleumGases;
    
    
    /**
     * Natural gas expenditures in the residential sector (including supplemental gaseous fuels) in million dollars.
     * @return Integer
     */
    public Integer getNaturalGas() {
        return this.naturalGas;
    }
    
    
    
    /**
     * Distillate fuel oil expenditures in the residential sector in million dollars.
     * @return Integer
     */
    public Integer getDistillateFuelOil() {
        return this.distillateFuelOil;
    }
    
    
    
    /**
     * Wood expenditures in the residential sector in million dollars.
     * @return Integer
     */
    public Integer getWood() {
        return this.wood;
    }
    
    
    
    /**
     * Coal expenditures in the residential sector in million dollars.
     * @return Integer
     */
    public Integer getCoal() {
        return this.coal;
    }
    
    
    
    /**
     * Kerosene expenditures in the residential sector in million dollars.
     * @return Integer
     */
    public Integer getKerosene() {
        return this.kerosene;
    }
    
    
    
    /**
     * LPG expenditures in the residential sector in million dollars.
     * @return Integer
     */
    public Integer getLiquefiedPetroleumGases() {
        return this.liquefiedPetroleumGases;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Residential.
	
	 * @return String
	 */
	public String toString() {
		return "Residential[" +naturalGas+", "+distillateFuelOil+", "+wood+", "+coal+", "+kerosene+", "+liquefiedPetroleumGases+"]";
	}
	
	/**
	 * Internal constructor to create a Residential from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Residential(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Natural Gas
            this.naturalGas = ((Number)json_data.get("Natural Gas")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Residential; the field naturalGas was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Residential; the field naturalGas had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Distillate Fuel Oil
            this.distillateFuelOil = ((Number)json_data.get("Distillate Fuel Oil")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Residential; the field distillateFuelOil was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Residential; the field distillateFuelOil had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Wood
            this.wood = ((Number)json_data.get("Wood")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Residential; the field wood was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Residential; the field wood had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Coal
            this.coal = ((Number)json_data.get("Coal")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Residential; the field coal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Residential; the field coal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Kerosene
            this.kerosene = ((Number)json_data.get("Kerosene")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Residential; the field kerosene was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Residential; the field kerosene had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Liquefied Petroleum Gases
            this.liquefiedPetroleumGases = ((Number)json_data.get("Liquefied Petroleum Gases")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Residential; the field liquefiedPetroleumGases was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Residential; the field liquefiedPetroleumGases had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}