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
            this.whiteAloneNotHispanicOrLatino = (Double)json_data.get("White Alone, not Hispanic or Latino");// Two or More Races
            this.twoOrMoreRaces = (Double)json_data.get("Two or More Races");// Asian Alone
            this.asianAlone = (Double)json_data.get("Asian Alone");// Native Hawaiian and Other Pacific Islander Alone
            this.nativeHawaiianAndOtherPacificIslanderAlone = (Double)json_data.get("Native Hawaiian and Other Pacific Islander Alone");// White Alone
            this.whiteAlone = (Double)json_data.get("White Alone");// Hispanic or Latino
            this.hispanicOrLatino = (Double)json_data.get("Hispanic or Latino");// Black Alone
            this.blackAlone = (Double)json_data.get("Black Alone");// American Indian and Alaska Native Alone
            this.americanIndianAndAlaskaNativeAlone = (Double)json_data.get("American Indian and Alaska Native Alone");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Ethnicities; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Ethnicities; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}