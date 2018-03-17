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
public class Industrial {
	
    // Natural gas price in the industrial sector (including supplemental gaseous fuels) in dollars per million BTU.
    private Integer naturalGas;
    // Distillate fuel oil price in the industrial sector in dollars per million BTU.
    private Integer distillateFuelOil;
    // Other petroleum products average price in the industrial sector in dollars per million BTU.
    private Integer otherPetroleumProducts;
    // Coal price in the industrial sector in dollars per million BTU.
    private Integer coal;
    // Kerosene price in the industrial sector in dollars per million BTU.
    private Integer kerosene;
    // LPG price in the industrial sector in dollars per million BTU.
    private Integer liquefiedPetroleumGases;
    
    
    /**
     * Natural gas price in the industrial sector (including supplemental gaseous fuels) in dollars per million BTU.
     * @return Integer
     */
    public Integer getNaturalGas() {
        return this.naturalGas;
    }
    
    
    
    /**
     * Distillate fuel oil price in the industrial sector in dollars per million BTU.
     * @return Integer
     */
    public Integer getDistillateFuelOil() {
        return this.distillateFuelOil;
    }
    
    
    
    /**
     * Other petroleum products average price in the industrial sector in dollars per million BTU.
     * @return Integer
     */
    public Integer getOtherPetroleumProducts() {
        return this.otherPetroleumProducts;
    }
    
    
    
    /**
     * Coal price in the industrial sector in dollars per million BTU.
     * @return Integer
     */
    public Integer getCoal() {
        return this.coal;
    }
    
    
    
    /**
     * Kerosene price in the industrial sector in dollars per million BTU.
     * @return Integer
     */
    public Integer getKerosene() {
        return this.kerosene;
    }
    
    
    
    /**
     * LPG price in the industrial sector in dollars per million BTU.
     * @return Integer
     */
    public Integer getLiquefiedPetroleumGases() {
        return this.liquefiedPetroleumGases;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Industrial.
	
	 * @return String
	 */
	public String toString() {
		return "Industrial[" +naturalGas+", "+distillateFuelOil+", "+otherPetroleumProducts+", "+coal+", "+kerosene+", "+liquefiedPetroleumGases+"]";
	}
	
	/**
	 * Internal constructor to create a Industrial from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Industrial(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Natural Gas
            this.naturalGas = ((Number)json_data.get("Natural Gas")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Industrial; the field naturalGas was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Industrial; the field naturalGas had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Distillate Fuel Oil
            this.distillateFuelOil = ((Number)json_data.get("Distillate Fuel Oil")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Industrial; the field distillateFuelOil was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Industrial; the field distillateFuelOil had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Other Petroleum Products
            this.otherPetroleumProducts = ((Number)json_data.get("Other Petroleum Products")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Industrial; the field otherPetroleumProducts was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Industrial; the field otherPetroleumProducts had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Coal
            this.coal = ((Number)json_data.get("Coal")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Industrial; the field coal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Industrial; the field coal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Kerosene
            this.kerosene = ((Number)json_data.get("Kerosene")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Industrial; the field kerosene was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Industrial; the field kerosene had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Liquefied Petroleum Gases
            this.liquefiedPetroleumGases = ((Number)json_data.get("Liquefied Petroleum Gases")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Industrial; the field liquefiedPetroleumGases was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Industrial; the field liquefiedPetroleumGases had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}