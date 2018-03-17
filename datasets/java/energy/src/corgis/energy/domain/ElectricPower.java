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
public class ElectricPower {
	
    // Natural gas expenditures in the electric power sector (including supplemental gaseous fuels) in million dollars.
    private Integer naturalGas;
    // Distillate fuel oil expenditures in the electric power sector in million dollars.
    private Integer distillateFuelOil;
    // Coal expenditures in the electric power sector in million dollars.
    private Integer coal;
    
    
    /**
     * Natural gas expenditures in the electric power sector (including supplemental gaseous fuels) in million dollars.
     * @return Integer
     */
    public Integer getNaturalGas() {
        return this.naturalGas;
    }
    
    
    
    /**
     * Distillate fuel oil expenditures in the electric power sector in million dollars.
     * @return Integer
     */
    public Integer getDistillateFuelOil() {
        return this.distillateFuelOil;
    }
    
    
    
    /**
     * Coal expenditures in the electric power sector in million dollars.
     * @return Integer
     */
    public Integer getCoal() {
        return this.coal;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this ElectricPower.
	
	 * @return String
	 */
	public String toString() {
		return "ElectricPower[" +naturalGas+", "+distillateFuelOil+", "+coal+"]";
	}
	
	/**
	 * Internal constructor to create a ElectricPower from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public ElectricPower(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Natural Gas
            this.naturalGas = ((Number)json_data.get("Natural Gas")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ElectricPower; the field naturalGas was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ElectricPower; the field naturalGas had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Distillate Fuel Oil
            this.distillateFuelOil = ((Number)json_data.get("Distillate Fuel Oil")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ElectricPower; the field distillateFuelOil was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ElectricPower; the field distillateFuelOil had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Coal
            this.coal = ((Number)json_data.get("Coal")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ElectricPower; the field coal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ElectricPower; the field coal had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}