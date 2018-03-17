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
	
    // A unique ID for this food item.
    private Integer nutrientDataBankNumber;
    private Data data;
    // The general category of food that this item belongs to.
    private String category;
    // A full description of this food item, including its category and some sub categories.
    private String description;
    
    
    /**
     * A unique ID for this food item.
     * @return Integer
     */
    public Integer getNutrientDataBankNumber() {
        return this.nutrientDataBankNumber;
    }
    
    
    
    /**
     * 
     * @return Data
     */
    public Data getData() {
        return this.data;
    }
    
    
    
    /**
     * The general category of food that this item belongs to.
     * @return String
     */
    public String getCategory() {
        return this.category;
    }
    
    
    
    /**
     * A full description of this food item, including its category and some sub categories.
     * @return String
     */
    public String getDescription() {
        return this.description;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Report.
	
	 * @return String
	 */
	public String toString() {
		return "Report[" +nutrientDataBankNumber+", "+data+", "+category+", "+description+"]";
	}
	
	/**
	 * Internal constructor to create a Report from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Report(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Nutrient Data Bank Number
            this.nutrientDataBankNumber = ((Number)json_data.get("Nutrient Data Bank Number")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field nutrientDataBankNumber was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field nutrientDataBankNumber had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Data
            this.data = new Data((JSONObject)json_data.get("Data"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field data was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field data had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Category
            this.category = (String)json_data.get("Category");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field category was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field category had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Description
            this.description = (String)json_data.get("Description");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field description was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field description had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}