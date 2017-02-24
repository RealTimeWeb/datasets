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
import corgis.energy.domain.Transportation;
import corgis.energy.domain.Residential;
import corgis.energy.domain.Commercial;
import corgis.energy.domain.Refinery;
import corgis.energy.domain.ElectricPower;

/**
 * 
 */
public class Consumption {
	
    private Industrial industrial;
    private Transportation transportation;
    private Residential residential;
    private Commercial commercial;
    private Refinery refinery;
    private ElectricPower electricPower;
    
    
    /*
     * @return 
     */
    public Industrial getIndustrial() {
        return this.industrial;
    }
    
    
    
    /*
     * @return 
     */
    public Transportation getTransportation() {
        return this.transportation;
    }
    
    
    
    /*
     * @return 
     */
    public Residential getResidential() {
        return this.residential;
    }
    
    
    
    /*
     * @return 
     */
    public Commercial getCommercial() {
        return this.commercial;
    }
    
    
    
    /*
     * @return 
     */
    public Refinery getRefinery() {
        return this.refinery;
    }
    
    
    
    /*
     * @return 
     */
    public ElectricPower getElectricPower() {
        return this.electricPower;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Consumption.
	
	 * @return String
	 */
	public String toString() {
		return "Consumption[" +industrial+", "+transportation+", "+residential+", "+commercial+", "+refinery+", "+electricPower+"]";
	}
	
	/**
	 * Internal constructor to create a Consumption from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Consumption(JSONObject json_data) {
        try {// Industrial
            this.industrial = new Industrial((JSONObject)json_data.get("Industrial"));// Transportation
            this.transportation = new Transportation((JSONObject)json_data.get("Transportation"));// Residential
            this.residential = new Residential((JSONObject)json_data.get("Residential"));// Commercial
            this.commercial = new Commercial((JSONObject)json_data.get("Commercial"));// Refinery
            this.refinery = new Refinery((JSONObject)json_data.get("Refinery"));// Electric Power
            this.electricPower = new ElectricPower((JSONObject)json_data.get("Electric Power"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Consumption; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Consumption; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}