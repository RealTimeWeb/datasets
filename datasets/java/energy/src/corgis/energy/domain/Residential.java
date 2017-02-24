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
    // Kerosene expenditures in the residential sector in million dollars.
    private Integer kerosene;
    // Coal expenditures in the residential sector in million dollars.
    private Integer coal;
    // Wood expenditures in the residential sector in million dollars.
    private Integer wood;
    // Distillate fuel oil expenditures in the residential sector in million dollars.
    private Integer distillateFuelOil;
    // LPG expenditures in the residential sector in million dollars.
    private Integer liquefiedPetroleumGases;
    
    
    /*
     * @return 
     */
    public Integer getNaturalGas() {
        return this.naturalGas;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getKerosene() {
        return this.kerosene;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCoal() {
        return this.coal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWood() {
        return this.wood;
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
    public Integer getLiquefiedPetroleumGases() {
        return this.liquefiedPetroleumGases;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Residential.
	
	 * @return String
	 */
	public String toString() {
		return "Residential[" +naturalGas+", "+kerosene+", "+coal+", "+wood+", "+distillateFuelOil+", "+liquefiedPetroleumGases+"]";
	}
	
	/**
	 * Internal constructor to create a Residential from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Residential(JSONObject json_data) {
        try {// Natural Gas
            this.naturalGas = ((Number)json_data.get("Natural Gas")).intValue();// Kerosene
            this.kerosene = ((Number)json_data.get("Kerosene")).intValue();// Coal
            this.coal = ((Number)json_data.get("Coal")).intValue();// Wood
            this.wood = ((Number)json_data.get("Wood")).intValue();// Distillate Fuel Oil
            this.distillateFuelOil = ((Number)json_data.get("Distillate Fuel Oil")).intValue();// Liquefied Petroleum Gases
            this.liquefiedPetroleumGases = ((Number)json_data.get("Liquefied Petroleum Gases")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Residential; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Residential; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}