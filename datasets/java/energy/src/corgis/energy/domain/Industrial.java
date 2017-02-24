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
	
    // Other petroleum products average price in the industrial sector in dollars per million BTU.
    private Integer otherPetroleumProducts;
    // Kerosene price in the industrial sector in dollars per million BTU.
    private Integer kerosene;
    // Natural gas price in the industrial sector (including supplemental gaseous fuels) in dollars per million BTU.
    private Integer naturalGas;
    // Coal price in the industrial sector in dollars per million BTU.
    private Integer coal;
    // Distillate fuel oil price in the industrial sector in dollars per million BTU.
    private Integer distillateFuelOil;
    // LPG price in the industrial sector in dollars per million BTU.
    private Integer liquefiedPetroleumGases;
    
    
    /*
     * @return 
     */
    public Integer getOtherPetroleumProducts() {
        return this.otherPetroleumProducts;
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
    public Integer getNaturalGas() {
        return this.naturalGas;
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
	 * Creates a string based representation of this Industrial.
	
	 * @return String
	 */
	public String toString() {
		return "Industrial[" +otherPetroleumProducts+", "+kerosene+", "+naturalGas+", "+coal+", "+distillateFuelOil+", "+liquefiedPetroleumGases+"]";
	}
	
	/**
	 * Internal constructor to create a Industrial from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Industrial(JSONObject json_data) {
        try {// Other Petroleum Products
            this.otherPetroleumProducts = ((Number)json_data.get("Other Petroleum Products")).intValue();// Kerosene
            this.kerosene = ((Number)json_data.get("Kerosene")).intValue();// Natural Gas
            this.naturalGas = ((Number)json_data.get("Natural Gas")).intValue();// Coal
            this.coal = ((Number)json_data.get("Coal")).intValue();// Distillate Fuel Oil
            this.distillateFuelOil = ((Number)json_data.get("Distillate Fuel Oil")).intValue();// Liquefied Petroleum Gases
            this.liquefiedPetroleumGases = ((Number)json_data.get("Liquefied Petroleum Gases")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Industrial; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Industrial; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}