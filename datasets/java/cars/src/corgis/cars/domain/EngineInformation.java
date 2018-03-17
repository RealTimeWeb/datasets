package corgis.cars.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.cars.domain.EngineStatistics;

/**
 * 
 */
public class EngineInformation {
	
    // How many cylinders are in this engine. Most cars are either a 6-cylinder or an 8-cylinder.
    private String engineType;
    // The full name of this type of transmission, based on its Classification and number of forward gears.
    private String transmission;
    // A string representing whether this is "Rear-wheel drive", "Front-wheel drive", or "All-wheel drive".
    private String driveline;
    // The number of forward gears. If no information is available, it is coded as 0.
    private Integer numberOfForwardGears;
    private EngineStatistics engineStatistics;
    // Whether this is a hybrid engine or not - that is, if it uses both an internal combustion engine and an electric motor.
    private Boolean hybrid;
    
    
    /**
     * How many cylinders are in this engine. Most cars are either a 6-cylinder or an 8-cylinder.
     * @return String
     */
    public String getEngineType() {
        return this.engineType;
    }
    
    
    
    /**
     * The full name of this type of transmission, based on its Classification and number of forward gears.
     * @return String
     */
    public String getTransmission() {
        return this.transmission;
    }
    
    
    
    /**
     * A string representing whether this is "Rear-wheel drive", "Front-wheel drive", or "All-wheel drive".
     * @return String
     */
    public String getDriveline() {
        return this.driveline;
    }
    
    
    
    /**
     * The number of forward gears. If no information is available, it is coded as 0.
     * @return Integer
     */
    public Integer getNumberOfForwardGears() {
        return this.numberOfForwardGears;
    }
    
    
    
    /**
     * 
     * @return EngineStatistics
     */
    public EngineStatistics getEngineStatistics() {
        return this.engineStatistics;
    }
    
    
    
    /**
     * Whether this is a hybrid engine or not - that is, if it uses both an internal combustion engine and an electric motor.
     * @return Boolean
     */
    public Boolean getHybrid() {
        return this.hybrid;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this EngineInformation.
	
	 * @return String
	 */
	public String toString() {
		return "EngineInformation[" +engineType+", "+transmission+", "+driveline+", "+numberOfForwardGears+", "+engineStatistics+", "+hybrid+"]";
	}
	
	/**
	 * Internal constructor to create a EngineInformation from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public EngineInformation(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Engine Type
            this.engineType = (String)json_data.get("Engine Type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a EngineInformation; the field engineType was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a EngineInformation; the field engineType had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Transmission
            this.transmission = (String)json_data.get("Transmission");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a EngineInformation; the field transmission was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a EngineInformation; the field transmission had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Driveline
            this.driveline = (String)json_data.get("Driveline");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a EngineInformation; the field driveline was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a EngineInformation; the field driveline had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Number of Forward Gears
            this.numberOfForwardGears = ((Number)json_data.get("Number of Forward Gears")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a EngineInformation; the field numberOfForwardGears was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a EngineInformation; the field numberOfForwardGears had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Engine Statistics
            this.engineStatistics = new EngineStatistics((JSONObject)json_data.get("Engine Statistics"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a EngineInformation; the field engineStatistics was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a EngineInformation; the field engineStatistics had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Hybrid
            this.hybrid = (Boolean)json_data.get("Hybrid");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a EngineInformation; the field hybrid was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a EngineInformation; the field hybrid had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}