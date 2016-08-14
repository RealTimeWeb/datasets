package corgis.cars.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.cars.domain.EngineInformation;
import corgis.cars.domain.Identification;
import corgis.cars.domain.Dimensions;
import corgis.cars.domain.FuelInformation;

/**
 * 
 */
public class Car {
	
    private EngineInformation engineInformation;
    private Identification identification;
    private Dimensions dimensions;
    private FuelInformation fuelInformation;
    
    
    /*
     * @return 
     */
    public EngineInformation getEngineInformation() {
        return this.engineInformation;
    }
    
    
    
    /*
     * @return 
     */
    public Identification getIdentification() {
        return this.identification;
    }
    
    
    
    /*
     * @return 
     */
    public Dimensions getDimensions() {
        return this.dimensions;
    }
    
    
    
    /*
     * @return 
     */
    public FuelInformation getFuelInformation() {
        return this.fuelInformation;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Car.
	
	 * @return String
	 */
	public String toString() {
		return "Car[" +engineInformation+", "+identification+", "+dimensions+", "+fuelInformation+"]";
	}
	
	/**
	 * Internal constructor to create a Car from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Car(JSONObject json_data) {
        try {// Engine Information
            this.engineInformation = new EngineInformation((JSONObject)json_data.get("Engine Information"));// Identification
            this.identification = new Identification((JSONObject)json_data.get("Identification"));// Dimensions
            this.dimensions = new Dimensions((JSONObject)json_data.get("Dimensions"));// Fuel Information
            this.fuelInformation = new FuelInformation((JSONObject)json_data.get("Fuel Information"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Car; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Car; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}