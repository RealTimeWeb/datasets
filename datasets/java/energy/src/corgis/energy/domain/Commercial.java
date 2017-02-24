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
	
    // Natural gas consumed by (delivered to) the commercial sector (including supplemental gaseous fuels) in billion BTU.
    private Double naturalGas;
    // Kerosene consumed by the commercial sector in billion BTU.
    private Double kerosene;
    // Hydropower consumed by the commercial sector in billion BTU.
    private Double hydropower;
    // Coal consumed by the commercial sector in billion BTU.
    private Double coal;
    // Geothermal energy consumed by the commercial sector in billion BTU.
    private Double geothermal;
    // Wood consumed by the commercial sector in billion BTU.
    private Double wood;
    // Photovoltaic and solar thermal energy consumed by the commercial sector (except portion included in SOHCB) in billion BTU.
    private Double solar;
    // Distillate fuel oil consumed by the commercial sector in billion BTU.
    private Double distillateFuelOil;
    // Wind energy consumed by the commercial sector in billion BTU.
    private Double wind;
    // LPG consumed by the commercial sector in billion BTU.
    private Double liquefiedPetroleumGases;
    
    
    /*
     * @return 
     */
    public Double getNaturalGas() {
        return this.naturalGas;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKerosene() {
        return this.kerosene;
    }
    
    
    
    /*
     * @return 
     */
    public Double getHydropower() {
        return this.hydropower;
    }
    
    
    
    /*
     * @return 
     */
    public Double getCoal() {
        return this.coal;
    }
    
    
    
    /*
     * @return 
     */
    public Double getGeothermal() {
        return this.geothermal;
    }
    
    
    
    /*
     * @return 
     */
    public Double getWood() {
        return this.wood;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSolar() {
        return this.solar;
    }
    
    
    
    /*
     * @return 
     */
    public Double getDistillateFuelOil() {
        return this.distillateFuelOil;
    }
    
    
    
    /*
     * @return 
     */
    public Double getWind() {
        return this.wind;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLiquefiedPetroleumGases() {
        return this.liquefiedPetroleumGases;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Commercial.
	
	 * @return String
	 */
	public String toString() {
		return "Commercial[" +naturalGas+", "+kerosene+", "+hydropower+", "+coal+", "+geothermal+", "+wood+", "+solar+", "+distillateFuelOil+", "+wind+", "+liquefiedPetroleumGases+"]";
	}
	
	/**
	 * Internal constructor to create a Commercial from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Commercial(JSONObject json_data) {
        try {// Natural Gas
            this.naturalGas = ((Number)json_data.get("Natural Gas")).doubleValue();// Kerosene
            this.kerosene = ((Number)json_data.get("Kerosene")).doubleValue();// Hydropower
            this.hydropower = ((Number)json_data.get("Hydropower")).doubleValue();// Coal
            this.coal = ((Number)json_data.get("Coal")).doubleValue();// Geothermal
            this.geothermal = ((Number)json_data.get("Geothermal")).doubleValue();// Wood
            this.wood = ((Number)json_data.get("Wood")).doubleValue();// Solar
            this.solar = ((Number)json_data.get("Solar")).doubleValue();// Distillate Fuel Oil
            this.distillateFuelOil = ((Number)json_data.get("Distillate Fuel Oil")).doubleValue();// Wind
            this.wind = ((Number)json_data.get("Wind")).doubleValue();// Liquefied Petroleum Gases
            this.liquefiedPetroleumGases = ((Number)json_data.get("Liquefied Petroleum Gases")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Commercial; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Commercial; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}