package corgis.food.domain;

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
public class MajorMinerals {
	
    private Double copper;
    private Double iron;
    private Integer sodium;
    private Integer potassium;
    private Integer calcium;
    private Integer magnesium;
    private Double zinc;
    private Integer phosphorus;
    
    
    /*
     * @return 
     */
    public Double getCopper() {
        return this.copper;
    }
    
    
    
    /*
     * @return 
     */
    public Double getIron() {
        return this.iron;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSodium() {
        return this.sodium;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPotassium() {
        return this.potassium;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCalcium() {
        return this.calcium;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMagnesium() {
        return this.magnesium;
    }
    
    
    
    /*
     * @return 
     */
    public Double getZinc() {
        return this.zinc;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPhosphorus() {
        return this.phosphorus;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this MajorMinerals.
	
	 * @return String
	 */
	public String toString() {
		return "MajorMinerals[" +copper+", "+iron+", "+sodium+", "+potassium+", "+calcium+", "+magnesium+", "+zinc+", "+phosphorus+"]";
	}
	
	/**
	 * Internal constructor to create a MajorMinerals from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public MajorMinerals(JSONObject json_data) {
        try {// Copper
            this.copper = ((Number)json_data.get("Copper")).doubleValue();// Iron
            this.iron = ((Number)json_data.get("Iron")).doubleValue();// Sodium
            this.sodium = ((Number)json_data.get("Sodium")).intValue();// Potassium
            this.potassium = ((Number)json_data.get("Potassium")).intValue();// Calcium
            this.calcium = ((Number)json_data.get("Calcium")).intValue();// Magnesium
            this.magnesium = ((Number)json_data.get("Magnesium")).intValue();// Zinc
            this.zinc = ((Number)json_data.get("Zinc")).doubleValue();// Phosphorus
            this.phosphorus = ((Number)json_data.get("Phosphorus")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}