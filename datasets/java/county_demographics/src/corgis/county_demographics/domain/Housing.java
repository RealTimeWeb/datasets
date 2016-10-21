package corgis.county_demographics.domain;

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
public class Housing {
	
    // 2014
    private Integer housingUnits;
    // percent, 2009-2013
    private Double unitsInMultiUnitStructures;
    // 2009-2013
    private Integer medianValueOfOwnerOccupiedUnits;
    // 2009-2013
    private Integer households;
    // 2009-2013
    private Double personsPerHousehold;
    // 2009-2013
    private Double homeownershipRate;
    
    
    /*
     * @return 
     */
    public Integer getHousingUnits() {
        return this.housingUnits;
    }
    
    
    
    /*
     * @return 
     */
    public Double getUnitsInMultiUnitStructures() {
        return this.unitsInMultiUnitStructures;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMedianValueOfOwnerOccupiedUnits() {
        return this.medianValueOfOwnerOccupiedUnits;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHouseholds() {
        return this.households;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPersonsPerHousehold() {
        return this.personsPerHousehold;
    }
    
    
    
    /*
     * @return 
     */
    public Double getHomeownershipRate() {
        return this.homeownershipRate;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Housing.
	
	 * @return String
	 */
	public String toString() {
		return "Housing[" +housingUnits+", "+unitsInMultiUnitStructures+", "+medianValueOfOwnerOccupiedUnits+", "+households+", "+personsPerHousehold+", "+homeownershipRate+"]";
	}
	
	/**
	 * Internal constructor to create a Housing from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Housing(JSONObject json_data) {
        try {// Housing Units
            this.housingUnits = ((Number)json_data.get("Housing Units")).intValue();// Units in Multi-Unit Structures
            this.unitsInMultiUnitStructures = ((Number)json_data.get("Units in Multi-Unit Structures")).doubleValue();// Median Value of Owner-Occupied Units
            this.medianValueOfOwnerOccupiedUnits = ((Number)json_data.get("Median Value of Owner-Occupied Units")).intValue();// Households
            this.households = ((Number)json_data.get("Households")).intValue();// Persons per Household
            this.personsPerHousehold = ((Number)json_data.get("Persons per Household")).doubleValue();// Homeownership Rate
            this.homeownershipRate = ((Number)json_data.get("Homeownership Rate")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Housing; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Housing; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}