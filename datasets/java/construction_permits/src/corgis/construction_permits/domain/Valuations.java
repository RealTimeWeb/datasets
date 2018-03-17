package corgis.construction_permits.domain;

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
public class Valuations {
	
    private Integer twoUnits;
    private Integer oneUnit;
    private Integer threeFourUnits;
    private Integer fiveplusUnits;
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getTwoUnits() {
        return this.twoUnits;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getOneUnit() {
        return this.oneUnit;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getThreeFourUnits() {
        return this.threeFourUnits;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getFiveplusUnits() {
        return this.fiveplusUnits;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Valuations.
	
	 * @return String
	 */
	public String toString() {
		return "Valuations[" +twoUnits+", "+oneUnit+", "+threeFourUnits+", "+fiveplusUnits+"]";
	}
	
	/**
	 * Internal constructor to create a Valuations from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Valuations(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // 2 units
            this.twoUnits = ((Number)json_data.get("2 units")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Valuations; the field twoUnits was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Valuations; the field twoUnits had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // 1 unit
            this.oneUnit = ((Number)json_data.get("1 unit")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Valuations; the field oneUnit was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Valuations; the field oneUnit had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // 3-4 units
            this.threeFourUnits = ((Number)json_data.get("3-4 units")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Valuations; the field threeFourUnits was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Valuations; the field threeFourUnits had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // 5+ units
            this.fiveplusUnits = ((Number)json_data.get("5+ units")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Valuations; the field fiveplusUnits was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Valuations; the field fiveplusUnits had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}