package corgis.cars.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.cars.domain.FuelInformation;
import corgis.cars.domain.Identification;
import corgis.cars.domain.Dimensions;
import corgis.cars.domain.EngineInformation;

/**
 * 
 */
public class Car {
	
    private FuelInformation fuelInformation;
    private Identification identification;
    private Dimensions dimensions;
    private EngineInformation engineInformation;
    
    
    /**
     * 
     * @return FuelInformation
     */
    public FuelInformation getFuelInformation() {
        return this.fuelInformation;
    }
    
    
    
    /**
     * 
     * @return Identification
     */
    public Identification getIdentification() {
        return this.identification;
    }
    
    
    
    /**
     * 
     * @return Dimensions
     */
    public Dimensions getDimensions() {
        return this.dimensions;
    }
    
    
    
    /**
     * 
     * @return EngineInformation
     */
    public EngineInformation getEngineInformation() {
        return this.engineInformation;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Car.
	
	 * @return String
	 */
	public String toString() {
		return "Car[" +fuelInformation+", "+identification+", "+dimensions+", "+engineInformation+"]";
	}
	
	/**
	 * Internal constructor to create a Car from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Car(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Fuel Information
            this.fuelInformation = new FuelInformation((JSONObject)json_data.get("Fuel Information"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Car; the field fuelInformation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Car; the field fuelInformation had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Identification
            this.identification = new Identification((JSONObject)json_data.get("Identification"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Car; the field identification was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Car; the field identification had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Dimensions
            this.dimensions = new Dimensions((JSONObject)json_data.get("Dimensions"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Car; the field dimensions was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Car; the field dimensions had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Engine Information
            this.engineInformation = new EngineInformation((JSONObject)json_data.get("Engine Information"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Car; the field engineInformation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Car; the field engineInformation had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}