package corgis.immigration.domain;

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
public class Enforcement {
	
    // The number of aliens who were removed from the US without a prior criminal conviction (but were present in the USA illegaly).
    private Integer nonCriminal;
    // The number of aliens who were ineligible to receive a visa and ineligible to be admitted to the United States.
    private Integer inadmissable;
    // The number of aliens who were removed from the US for having prior criminal convictions (e.g., immigration-related offenses, dangerous drug crimes, criminal traffic offenses, and assault).
    private Integer criminal;
    // The number of aliens who entered without inspection between ports of entry and are apprehended by U.S. Border Patrol (USBP).
    private Integer apprehended;
    
    
    /**
     * The number of aliens who were removed from the US without a prior criminal conviction (but were present in the USA illegaly).
     * @return Integer
     */
    public Integer getNonCriminal() {
        return this.nonCriminal;
    }
    
    
    
    /**
     * The number of aliens who were ineligible to receive a visa and ineligible to be admitted to the United States.
     * @return Integer
     */
    public Integer getInadmissable() {
        return this.inadmissable;
    }
    
    
    
    /**
     * The number of aliens who were removed from the US for having prior criminal convictions (e.g., immigration-related offenses, dangerous drug crimes, criminal traffic offenses, and assault).
     * @return Integer
     */
    public Integer getCriminal() {
        return this.criminal;
    }
    
    
    
    /**
     * The number of aliens who entered without inspection between ports of entry and are apprehended by U.S. Border Patrol (USBP).
     * @return Integer
     */
    public Integer getApprehended() {
        return this.apprehended;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Enforcement.
	
	 * @return String
	 */
	public String toString() {
		return "Enforcement[" +nonCriminal+", "+inadmissable+", "+criminal+", "+apprehended+"]";
	}
	
	/**
	 * Internal constructor to create a Enforcement from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Enforcement(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Non-criminal
            this.nonCriminal = ((Number)json_data.get("Non-criminal")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Enforcement; the field nonCriminal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Enforcement; the field nonCriminal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Inadmissable
            this.inadmissable = ((Number)json_data.get("Inadmissable")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Enforcement; the field inadmissable was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Enforcement; the field inadmissable had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Criminal
            this.criminal = ((Number)json_data.get("Criminal")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Enforcement; the field criminal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Enforcement; the field criminal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Apprehended
            this.apprehended = ((Number)json_data.get("Apprehended")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Enforcement; the field apprehended was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Enforcement; the field apprehended had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}