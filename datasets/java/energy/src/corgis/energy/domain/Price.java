package corgis.energy.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.energy.domain.Commercial;
import corgis.energy.domain.Industrial;
import corgis.energy.domain.Transportation;
import corgis.energy.domain.ElectricPower;

/**
 * 
 */
public class Price {
	
    private Commercial commercial;
    private Industrial industrial;
    private Transportation transportation;
    private ElectricPower electricPower;
    
    
    /*
     * @return 
     */
    public Commercial getCommercial() {
        return this.commercial;
    }
    
    
    
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
    public ElectricPower getElectricPower() {
        return this.electricPower;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Price.
	
	 * @return String
	 */
	public String toString() {
		return "Price[" +commercial+", "+industrial+", "+transportation+", "+electricPower+"]";
	}
	
	/**
	 * Internal constructor to create a Price from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Price(JSONObject json_data) {
        try {// Commercial
            this.commercial = new Commercial((JSONObject)json_data.get("Commercial"));// Industrial
            this.industrial = new Industrial((JSONObject)json_data.get("Industrial"));// Transportation
            this.transportation = new Transportation((JSONObject)json_data.get("Transportation"));// Electric Power
            this.electricPower = new ElectricPower((JSONObject)json_data.get("Electric Power"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Price; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Price; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}