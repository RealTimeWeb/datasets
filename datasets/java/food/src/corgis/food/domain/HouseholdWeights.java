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
public class HouseholdWeights {
	
    // Another estimate of the household measure of the food item. Weights are given for edible material without refuse. This can be used to calculate the nutrient value of the food.
    private Integer twondHouseholdWeight;
    // A string representing the units of measurements in the second household weight.
    private String twondHouseholdWeightDescription;
    // An estimate of the household measure of the food item. Weights are given for edible material without refuse. This can be used to calculate the nutrient value of the food.
    private Double onestHouseholdWeight;
    // A string representing the units of measurements in the first household weight.
    private String onestHouseholdWeightDescription;
    
    
    /*
     * @return 
     */
    public Integer getTwondHouseholdWeight() {
        return this.twondHouseholdWeight;
    }
    
    
    
    /*
     * @return 
     */
    public String getTwondHouseholdWeightDescription() {
        return this.twondHouseholdWeightDescription;
    }
    
    
    
    /*
     * @return 
     */
    public Double getOnestHouseholdWeight() {
        return this.onestHouseholdWeight;
    }
    
    
    
    /*
     * @return 
     */
    public String getOnestHouseholdWeightDescription() {
        return this.onestHouseholdWeightDescription;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this HouseholdWeights.
	
	 * @return String
	 */
	public String toString() {
		return "HouseholdWeights[" +twondHouseholdWeight+", "+twondHouseholdWeightDescription+", "+onestHouseholdWeight+", "+onestHouseholdWeightDescription+"]";
	}
	
	/**
	 * Internal constructor to create a HouseholdWeights from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public HouseholdWeights(JSONObject json_data) {
        try {// 2nd Household Weight
            this.twondHouseholdWeight = ((Number)json_data.get("2nd Household Weight")).intValue();// 2nd Household Weight Description
            this.twondHouseholdWeightDescription = (String)json_data.get("2nd Household Weight Description");// 1st Household Weight
            this.onestHouseholdWeight = ((Number)json_data.get("1st Household Weight")).doubleValue();// 1st Household Weight Description
            this.onestHouseholdWeightDescription = (String)json_data.get("1st Household Weight Description");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a HouseholdWeights; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a HouseholdWeights; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}