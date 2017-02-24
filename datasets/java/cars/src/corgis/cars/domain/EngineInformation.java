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
	
    // The full name of this type of transmission, based on its Classification and number of forward gears.
    private String transmission;
    // How many cylinders are in this engine. Most cars are either a 6-cylinder or an 8-cylinder.
    private String engineType;
    private EngineStatistics engineStatistics;
    // Whether this is a hybrid engine or not - that is, if it uses both an internal combustion engine and an electric motor.
    private Boolean hybrid;
    // The number of forward gears. If no information is available, it is coded as 0.
    private Integer numberOfForwardGears;
    // A string representing whether this is "Rear-wheel drive", "Front-wheel drive", or "All-wheel drive".
    private String driveline;
    
    
    /*
     * @return 
     */
    public String getTransmission() {
        return this.transmission;
    }
    
    
    
    /*
     * @return 
     */
    public String getEngineType() {
        return this.engineType;
    }
    
    
    
    /*
     * @return 
     */
    public EngineStatistics getEngineStatistics() {
        return this.engineStatistics;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getHybrid() {
        return this.hybrid;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNumberOfForwardGears() {
        return this.numberOfForwardGears;
    }
    
    
    
    /*
     * @return 
     */
    public String getDriveline() {
        return this.driveline;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this EngineInformation.
	
	 * @return String
	 */
	public String toString() {
		return "EngineInformation[" +transmission+", "+engineType+", "+engineStatistics+", "+hybrid+", "+numberOfForwardGears+", "+driveline+"]";
	}
	
	/**
	 * Internal constructor to create a EngineInformation from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public EngineInformation(JSONObject json_data) {
        try {// Transmission
            this.transmission = (String)json_data.get("Transmission");// Engine Type
            this.engineType = (String)json_data.get("Engine Type");// Engine Statistics
            this.engineStatistics = new EngineStatistics((JSONObject)json_data.get("Engine Statistics"));// Hybrid
            this.hybrid = (Boolean)json_data.get("Hybrid");// Number of Forward Gears
            this.numberOfForwardGears = ((Number)json_data.get("Number of Forward Gears")).intValue();// Driveline
            this.driveline = (String)json_data.get("Driveline");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a EngineInformation; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a EngineInformation; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}