package corgis.state_demographics.domain;

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
	
    private Double americanIndianAndAlaskaNativeAlone;
    private Double whiteAlone;
    private Double hispanicOrLatino;
    private Double asianAlone;
    private Double twoOrMoreRaces;
    private Double blackAlone;
    private Double whiteAloneNotHispanicOrLatino;
    private Double nativeHawaiianAndOtherPacificIslanderAlone;
    
    
    /**
     * 
     * @return Double
     */
    public Double getAmericanIndianAndAlaskaNativeAlone() {
        return this.americanIndianAndAlaskaNativeAlone;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getWhiteAlone() {
        return this.whiteAlone;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getHispanicOrLatino() {
        return this.hispanicOrLatino;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getAsianAlone() {
        return this.asianAlone;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getTwoOrMoreRaces() {
        return this.twoOrMoreRaces;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getBlackAlone() {
        return this.blackAlone;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getWhiteAloneNotHispanicOrLatino() {
        return this.whiteAloneNotHispanicOrLatino;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getNativeHawaiianAndOtherPacificIslanderAlone() {
        return this.nativeHawaiianAndOtherPacificIslanderAlone;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Ethnicities.
	
	 * @return String
	 */
	public String toString() {
		return "Ethnicities[" +americanIndianAndAlaskaNativeAlone+", "+whiteAlone+", "+hispanicOrLatino+", "+asianAlone+", "+twoOrMoreRaces+", "+blackAlone+", "+whiteAloneNotHispanicOrLatino+", "+nativeHawaiianAndOtherPacificIslanderAlone+"]";
	}
	
	/**
	 * Internal constructor to create a Ethnicities from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Ethnicities(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // American Indian and Alaska Native Alone
            this.americanIndianAndAlaskaNativeAlone = ((Number)json_data.get("American Indian and Alaska Native Alone")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Ethnicities; the field americanIndianAndAlaskaNativeAlone was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Ethnicities; the field americanIndianAndAlaskaNativeAlone had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // White Alone
            this.whiteAlone = ((Number)json_data.get("White Alone")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Ethnicities; the field whiteAlone was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Ethnicities; the field whiteAlone had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Hispanic or Latino
            this.hispanicOrLatino = ((Number)json_data.get("Hispanic or Latino")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Ethnicities; the field hispanicOrLatino was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Ethnicities; the field hispanicOrLatino had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Asian Alone
            this.asianAlone = ((Number)json_data.get("Asian Alone")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Ethnicities; the field asianAlone was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Ethnicities; the field asianAlone had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Two or More Races
            this.twoOrMoreRaces = ((Number)json_data.get("Two or More Races")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Ethnicities; the field twoOrMoreRaces was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Ethnicities; the field twoOrMoreRaces had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Black Alone
            this.blackAlone = ((Number)json_data.get("Black Alone")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Ethnicities; the field blackAlone was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Ethnicities; the field blackAlone had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // White Alone, not Hispanic or Latino
            this.whiteAloneNotHispanicOrLatino = ((Number)json_data.get("White Alone, not Hispanic or Latino")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Ethnicities; the field whiteAloneNotHispanicOrLatino was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Ethnicities; the field whiteAloneNotHispanicOrLatino had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Native Hawaiian and Other Pacific Islander Alone
            this.nativeHawaiianAndOtherPacificIslanderAlone = ((Number)json_data.get("Native Hawaiian and Other Pacific Islander Alone")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Ethnicities; the field nativeHawaiianAndOtherPacificIslanderAlone was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Ethnicities; the field nativeHawaiianAndOtherPacificIslanderAlone had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}