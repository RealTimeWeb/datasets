package corgis.energy.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.energy.domain.Industrial;
import corgis.energy.domain.Commercial;
import corgis.energy.domain.ElectricPower;
import corgis.energy.domain.Residential;
import corgis.energy.domain.Refinery;
import corgis.energy.domain.Transportation;

/**
 * 
 */
public class Consumption {
	
    private Industrial industrial;
    private Commercial commercial;
    private ElectricPower electricPower;
    private Residential residential;
    private Refinery refinery;
    private Transportation transportation;
    
    
    /**
     * 
     * @return Industrial
     */
    public Industrial getIndustrial() {
        return this.industrial;
    }
    
    
    
    /**
     * 
     * @return Commercial
     */
    public Commercial getCommercial() {
        return this.commercial;
    }
    
    
    
    /**
     * 
     * @return ElectricPower
     */
    public ElectricPower getElectricPower() {
        return this.electricPower;
    }
    
    
    
    /**
     * 
     * @return Residential
     */
    public Residential getResidential() {
        return this.residential;
    }
    
    
    
    /**
     * 
     * @return Refinery
     */
    public Refinery getRefinery() {
        return this.refinery;
    }
    
    
    
    /**
     * 
     * @return Transportation
     */
    public Transportation getTransportation() {
        return this.transportation;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Consumption.
	
	 * @return String
	 */
	public String toString() {
		return "Consumption[" +industrial+", "+commercial+", "+electricPower+", "+residential+", "+refinery+", "+transportation+"]";
	}
	
	/**
	 * Internal constructor to create a Consumption from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Consumption(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Industrial
            this.industrial = new Industrial((JSONObject)json_data.get("Industrial"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Consumption; the field industrial was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Consumption; the field industrial had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Commercial
            this.commercial = new Commercial((JSONObject)json_data.get("Commercial"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Consumption; the field commercial was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Consumption; the field commercial had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Electric Power
            this.electricPower = new ElectricPower((JSONObject)json_data.get("Electric Power"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Consumption; the field electricPower was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Consumption; the field electricPower had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Residential
            this.residential = new Residential((JSONObject)json_data.get("Residential"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Consumption; the field residential was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Consumption; the field residential had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Refinery
            this.refinery = new Refinery((JSONObject)json_data.get("Refinery"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Consumption; the field refinery was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Consumption; the field refinery had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Transportation
            this.transportation = new Transportation((JSONObject)json_data.get("Transportation"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Consumption; the field transportation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Consumption; the field transportation had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}