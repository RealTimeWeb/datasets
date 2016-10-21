package corgis.food_access.domain;

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
public class HousingData {
	
    private Integer totalHousingUnits;
    // Percentage is number of Census Tracts classified as urban divided by total tracts for the county
    private Double urbanHousingPercentage;
    // Group Quarters are dormitories, military bases, assisted living or skilled nursing facilities, and other large institutions.
    private Double residingInGroupQuarters;
    // Percentage is number of Census Tracts classified as rural divided by total tracts for the county
    private Double ruralHousingPercentage;
    
    
    /*
     * @return 
     */
    public Integer getTotalHousingUnits() {
        return this.totalHousingUnits;
    }
    
    
    
    /*
     * @return 
     */
    public Double getUrbanHousingPercentage() {
        return this.urbanHousingPercentage;
    }
    
    
    
    /*
     * @return 
     */
    public Double getResidingInGroupQuarters() {
        return this.residingInGroupQuarters;
    }
    
    
    
    /*
     * @return 
     */
    public Double getRuralHousingPercentage() {
        return this.ruralHousingPercentage;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this HousingData.
	
	 * @return String
	 */
	public String toString() {
		return "HousingData[" +totalHousingUnits+", "+urbanHousingPercentage+", "+residingInGroupQuarters+", "+ruralHousingPercentage+"]";
	}
	
	/**
	 * Internal constructor to create a HousingData from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public HousingData(JSONObject json_data) {
        try {// Total Housing Units
            this.totalHousingUnits = ((Number)json_data.get("Total Housing Units")).intValue();// Urban Housing Percentage
            this.urbanHousingPercentage = ((Number)json_data.get("Urban Housing Percentage")).doubleValue();// Residing in Group Quarters
            this.residingInGroupQuarters = ((Number)json_data.get("Residing in Group Quarters")).doubleValue();// Rural Housing Percentage
            this.ruralHousingPercentage = ((Number)json_data.get("Rural Housing Percentage")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a HousingData; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a HousingData; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}