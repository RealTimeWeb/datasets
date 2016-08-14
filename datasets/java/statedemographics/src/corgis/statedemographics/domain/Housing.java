package corgis.statedemographics.domain;

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
    private Integer households;
    private Integer medianValeOfOwnerOccupiedUnits;
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
    public Integer getHouseholds() {
        return this.households;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMedianValeOfOwnerOccupiedUnits() {
        return this.medianValeOfOwnerOccupiedUnits;
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
		return "Housing[" +housingUnits+", "+unitsInMultiUnitStructures+", "+households+", "+medianValeOfOwnerOccupiedUnits+", "+personsPerHousehold+", "+homeownershipRate+"]";
	}
	
	/**
	 * Internal constructor to create a Housing from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Housing(JSONObject json_data) {
        try {// Housing Units
            this.housingUnits = new Integer(((Long)json_data.get("Housing Units")).intValue());// Units in Multi-Unit Structures
            this.unitsInMultiUnitStructures = (Double)json_data.get("Units in Multi-Unit Structures");// Households
            this.households = new Integer(((Long)json_data.get("Households")).intValue());// Median Vale of Owner-Occupied Units
            this.medianValeOfOwnerOccupiedUnits = new Integer(((Long)json_data.get("Median Vale of Owner-Occupied Units")).intValue());// Persons per Household
            this.personsPerHousehold = (Double)json_data.get("Persons per Household");// Homeownership Rate
            this.homeownershipRate = (Double)json_data.get("Homeownership Rate");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Housing; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Housing; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}