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
import corgis.energy.domain.Transportation;
import corgis.energy.domain.ElectricPower;

/**
 * 
 */
public class Price {
	
    private Industrial industrial;
    private Commercial commercial;
    private Transportation transportation;
    private ElectricPower electricPower;
    
    
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
     * @return Transportation
     */
    public Transportation getTransportation() {
        return this.transportation;
    }
    
    
    
    /**
     * 
     * @return ElectricPower
     */
    public ElectricPower getElectricPower() {
        return this.electricPower;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Price.
	
	 * @return String
	 */
	public String toString() {
		return "Price[" +industrial+", "+commercial+", "+transportation+", "+electricPower+"]";
	}
	
	/**
	 * Internal constructor to create a Price from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Price(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Industrial
            this.industrial = new Industrial((JSONObject)json_data.get("Industrial"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Price; the field industrial was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Price; the field industrial had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Commercial
            this.commercial = new Commercial((JSONObject)json_data.get("Commercial"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Price; the field commercial was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Price; the field commercial had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Transportation
            this.transportation = new Transportation((JSONObject)json_data.get("Transportation"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Price; the field transportation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Price; the field transportation had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Electric Power
            this.electricPower = new ElectricPower((JSONObject)json_data.get("Electric Power"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Price; the field electricPower was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Price; the field electricPower had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}