package corgis.food.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.food.domain.Data;

/**
 * 
 */
public class Report {
	
    // The general category of food that this item belongs to.
    private String category;
    private Data data;
    // A full description of this food item, including its category and some sub categories.
    private String description;
    // A unique ID for this food item.
    private Integer nutrientDataBankNumber;
    
    
    /*
     * @return 
     */
    public String getCategory() {
        return this.category;
    }
    
    
    
    /*
     * @return 
     */
    public Data getData() {
        return this.data;
    }
    
    
    
    /*
     * @return 
     */
    public String getDescription() {
        return this.description;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNutrientDataBankNumber() {
        return this.nutrientDataBankNumber;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Report.
	
	 * @return String
	 */
	public String toString() {
		return "Report[" +category+", "+data+", "+description+", "+nutrientDataBankNumber+"]";
	}
	
	/**
	 * Internal constructor to create a Report from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Report(JSONObject json_data) {
        try {// Category
            this.category = (String)json_data.get("Category");// Data
            this.data = new Data((JSONObject)json_data.get("Data"));// Description
            this.description = (String)json_data.get("Description");// Nutrient Data Bank Number
            this.nutrientDataBankNumber = ((Number)json_data.get("Nutrient Data Bank Number")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}