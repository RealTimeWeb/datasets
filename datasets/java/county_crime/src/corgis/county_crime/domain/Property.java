package corgis.county_crime.domain;

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
public class Property {
	
    // Rates are the number of reported offenses per 100,000 population. This property reflects the number of burglaries, or entry into a building illegally with intent to commit a crime, especially theft.
    private Double burglary;
    // Rates are the number of reported offenses per 100,000 population. This property reflects the number of burglaries, or theft of personal property.
    private Double larceny;
    // Rates are the number of reported offenses per 100,000 population. This property reflects the number of crimes where a motor vehicle was stolen.
    private Double motor;
    // Rates are the number of reported offenses per 100,000 population. This property reflects all of the Property-related crimes, including burglaries, larcenies, and motor crimes.
    private Double all;
    
    
    /**
     * Rates are the number of reported offenses per 100,000 population. This property reflects the number of burglaries, or entry into a building illegally with intent to commit a crime, especially theft.
     * @return Double
     */
    public Double getBurglary() {
        return this.burglary;
    }
    
    
    
    /**
     * Rates are the number of reported offenses per 100,000 population. This property reflects the number of burglaries, or theft of personal property.
     * @return Double
     */
    public Double getLarceny() {
        return this.larceny;
    }
    
    
    
    /**
     * Rates are the number of reported offenses per 100,000 population. This property reflects the number of crimes where a motor vehicle was stolen.
     * @return Double
     */
    public Double getMotor() {
        return this.motor;
    }
    
    
    
    /**
     * Rates are the number of reported offenses per 100,000 population. This property reflects all of the Property-related crimes, including burglaries, larcenies, and motor crimes.
     * @return Double
     */
    public Double getAll() {
        return this.all;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Property.
	
	 * @return String
	 */
	public String toString() {
		return "Property[" +burglary+", "+larceny+", "+motor+", "+all+"]";
	}
	
	/**
	 * Internal constructor to create a Property from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Property(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Burglary
            this.burglary = ((Number)json_data.get("Burglary")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Property; the field burglary was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Property; the field burglary had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Larceny
            this.larceny = ((Number)json_data.get("Larceny")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Property; the field larceny was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Property; the field larceny had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Motor
            this.motor = ((Number)json_data.get("Motor")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Property; the field motor was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Property; the field motor had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // All
            this.all = ((Number)json_data.get("All")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Property; the field all was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Property; the field all had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}