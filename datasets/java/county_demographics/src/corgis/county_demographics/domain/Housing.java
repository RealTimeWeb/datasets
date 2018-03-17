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
	
    // 2009-2013
    private Integer medianValueOfOwnerOccupiedUnits;
    // 2009-2013
    private Double personsPerHousehold;
    // 2009-2013
    private Double homeownershipRate;
    // 2014
    private Integer housingUnits;
    // percent, 2009-2013
    private Double unitsInMultiUnitStructures;
    // 2009-2013
    private Integer households;
    
    
    /**
     * 2009-2013
     * @return Integer
     */
    public Integer getMedianValueOfOwnerOccupiedUnits() {
        return this.medianValueOfOwnerOccupiedUnits;
    }
    
    
    
    /**
     * 2009-2013
     * @return Double
     */
    public Double getPersonsPerHousehold() {
        return this.personsPerHousehold;
    }
    
    
    
    /**
     * 2009-2013
     * @return Double
     */
    public Double getHomeownershipRate() {
        return this.homeownershipRate;
    }
    
    
    
    /**
     * 2014
     * @return Integer
     */
    public Integer getHousingUnits() {
        return this.housingUnits;
    }
    
    
    
    /**
     * percent, 2009-2013
     * @return Double
     */
    public Double getUnitsInMultiUnitStructures() {
        return this.unitsInMultiUnitStructures;
    }
    
    
    
    /**
     * 2009-2013
     * @return Integer
     */
    public Integer getHouseholds() {
        return this.households;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Housing.
	
	 * @return String
	 */
	public String toString() {
		return "Housing[" +medianValueOfOwnerOccupiedUnits+", "+personsPerHousehold+", "+homeownershipRate+", "+housingUnits+", "+unitsInMultiUnitStructures+", "+households+"]";
	}
	
	/**
	 * Internal constructor to create a Housing from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Housing(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Median Value of Owner-Occupied Units
            this.medianValueOfOwnerOccupiedUnits = ((Number)json_data.get("Median Value of Owner-Occupied Units")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Housing; the field medianValueOfOwnerOccupiedUnits was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Housing; the field medianValueOfOwnerOccupiedUnits had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Persons per Household
            this.personsPerHousehold = ((Number)json_data.get("Persons per Household")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Housing; the field personsPerHousehold was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Housing; the field personsPerHousehold had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Homeownership Rate
            this.homeownershipRate = ((Number)json_data.get("Homeownership Rate")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Housing; the field homeownershipRate was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Housing; the field homeownershipRate had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Housing Units
            this.housingUnits = ((Number)json_data.get("Housing Units")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Housing; the field housingUnits was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Housing; the field housingUnits had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Units in Multi-Unit Structures
            this.unitsInMultiUnitStructures = ((Number)json_data.get("Units in Multi-Unit Structures")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Housing; the field unitsInMultiUnitStructures was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Housing; the field unitsInMultiUnitStructures had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Households
            this.households = ((Number)json_data.get("Households")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Housing; the field households was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Housing; the field households had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}