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
	
    private String onestHouseholdWeightDescription;
    private Double onestHouseholdWeight;
    private Integer twondHouseholdWeight;
    private String twondHouseholdWeightDescription;
    
    
    /*
     * @return 
     */
    public String getOnestHouseholdWeightDescription() {
        return this.onestHouseholdWeightDescription;
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
    public Integer getTwondHouseholdWeight() {
        return this.twondHouseholdWeight;
    }
    
    
    
    /*
     * @return 
     */
    public String getTwondHouseholdWeightDescription() {
        return this.twondHouseholdWeightDescription;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this HouseholdWeights.
	
	 * @return String
	 */
	public String toString() {
		return "HouseholdWeights[" +onestHouseholdWeightDescription+", "+onestHouseholdWeight+", "+twondHouseholdWeight+", "+twondHouseholdWeightDescription+"]";
	}
	
	/**
	 * Internal constructor to create a HouseholdWeights from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public HouseholdWeights(JSONObject json_data) {
        try {// 1st Household Weight Description
            this.onestHouseholdWeightDescription = (String)json_data.get("1st Household Weight Description");// 1st Household Weight
            this.onestHouseholdWeight = ((Number)json_data.get("1st Household Weight")).doubleValue();// 2nd Household Weight
            this.twondHouseholdWeight = ((Number)json_data.get("2nd Household Weight")).intValue();// 2nd Household Weight Description
            this.twondHouseholdWeightDescription = (String)json_data.get("2nd Household Weight Description");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a HouseholdWeights; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a HouseholdWeights; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}