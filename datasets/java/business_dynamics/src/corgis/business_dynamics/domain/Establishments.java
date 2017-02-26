package corgis.business_dynamics.domain;

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
public class Establishments {
	
    // The number of establishments that exited during this time divided by the number of establishments. Exiting occurs when an establishment has positive employment in the previous year and zero this year.
    private Double exitedRate;
    // The number of establishments that entered during this time divided by the number of establishments. Entering occurs when an establishment did not exist in the previous year.
    private Double enteredRate;
    // The number of establishments that entered during this time. Entering occurs when an establishment did not exist in the previous year.
    private Integer entered;
    // The number of establishments that exited during this time. Exiting occurs when an establishment has positive employment in the previous year and zero this year.
    private Integer exited;
    // The number of establishments in this region during this time.
    private Integer physicalLocations;
    
    
    /*
     * @return 
     */
    public Double getExitedRate() {
        return this.exitedRate;
    }
    
    
    
    /*
     * @return 
     */
    public Double getEnteredRate() {
        return this.enteredRate;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEntered() {
        return this.entered;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getExited() {
        return this.exited;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPhysicalLocations() {
        return this.physicalLocations;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Establishments.
	
	 * @return String
	 */
	public String toString() {
		return "Establishments[" +exitedRate+", "+enteredRate+", "+entered+", "+exited+", "+physicalLocations+"]";
	}
	
	/**
	 * Internal constructor to create a Establishments from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Establishments(JSONObject json_data) {
        try {// Exited Rate
            this.exitedRate = ((Number)json_data.get("Exited Rate")).doubleValue();// Entered Rate
            this.enteredRate = ((Number)json_data.get("Entered Rate")).doubleValue();// Entered
            this.entered = ((Number)json_data.get("Entered")).intValue();// Exited
            this.exited = ((Number)json_data.get("Exited")).intValue();// Physical Locations
            this.physicalLocations = ((Number)json_data.get("Physical Locations")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Establishments; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Establishments; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}