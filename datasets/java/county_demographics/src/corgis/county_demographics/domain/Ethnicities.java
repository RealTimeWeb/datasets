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
public class Ethnicities {
	
    private Double whiteAloneNotHispanicOrLatino;
    private Double twoOrMoreRaces;
    private Double asianAlone;
    private Double nativeHawaiianAndOtherPacificIslanderAlone;
    private Double whiteAlone;
    private Double hispanicOrLatino;
    private Double blackAlone;
    private Double americanIndianAndAlaskaNativeAlone;
    
    
    /*
     * @return 
     */
    public Double getWhiteAloneNotHispanicOrLatino() {
        return this.whiteAloneNotHispanicOrLatino;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTwoOrMoreRaces() {
        return this.twoOrMoreRaces;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAsianAlone() {
        return this.asianAlone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getNativeHawaiianAndOtherPacificIslanderAlone() {
        return this.nativeHawaiianAndOtherPacificIslanderAlone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getWhiteAlone() {
        return this.whiteAlone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getHispanicOrLatino() {
        return this.hispanicOrLatino;
    }
    
    
    
    /*
     * @return 
     */
    public Double getBlackAlone() {
        return this.blackAlone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAmericanIndianAndAlaskaNativeAlone() {
        return this.americanIndianAndAlaskaNativeAlone;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Ethnicities.
	
	 * @return String
	 */
	public String toString() {
		return "Ethnicities[" +whiteAloneNotHispanicOrLatino+", "+twoOrMoreRaces+", "+asianAlone+", "+nativeHawaiianAndOtherPacificIslanderAlone+", "+whiteAlone+", "+hispanicOrLatino+", "+blackAlone+", "+americanIndianAndAlaskaNativeAlone+"]";
	}
	
	/**
	 * Internal constructor to create a Ethnicities from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Ethnicities(JSONObject json_data) {
        try {// White Alone, not Hispanic or Latino
            this.whiteAloneNotHispanicOrLatino = ((Number)json_data.get("White Alone, not Hispanic or Latino")).doubleValue();// Two or More Races
            this.twoOrMoreRaces = ((Number)json_data.get("Two or More Races")).doubleValue();// Asian Alone
            this.asianAlone = ((Number)json_data.get("Asian Alone")).doubleValue();// Native Hawaiian and Other Pacific Islander Alone
            this.nativeHawaiianAndOtherPacificIslanderAlone = ((Number)json_data.get("Native Hawaiian and Other Pacific Islander Alone")).doubleValue();// White Alone
            this.whiteAlone = ((Number)json_data.get("White Alone")).doubleValue();// Hispanic or Latino
            this.hispanicOrLatino = ((Number)json_data.get("Hispanic or Latino")).doubleValue();// Black Alone
            this.blackAlone = ((Number)json_data.get("Black Alone")).doubleValue();// American Indian and Alaska Native Alone
            this.americanIndianAndAlaskaNativeAlone = ((Number)json_data.get("American Indian and Alaska Native Alone")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Ethnicities; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Ethnicities; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}