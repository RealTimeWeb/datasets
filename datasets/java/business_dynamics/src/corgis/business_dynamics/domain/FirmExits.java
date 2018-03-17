package corgis.business_dynamics.domain;

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
public class FirmExits {
	
    // The number of jobs destroyed as a result of firm deaths.
    private Integer jobDestruction;
    // The number of establishments exited because of firm deaths.
    private Integer establishmentExit;
    // The number of firms that exited this year.
    private Integer count;
    
    
    /**
     * The number of jobs destroyed as a result of firm deaths.
     * @return Integer
     */
    public Integer getJobDestruction() {
        return this.jobDestruction;
    }
    
    
    
    /**
     * The number of establishments exited because of firm deaths.
     * @return Integer
     */
    public Integer getEstablishmentExit() {
        return this.establishmentExit;
    }
    
    
    
    /**
     * The number of firms that exited this year.
     * @return Integer
     */
    public Integer getCount() {
        return this.count;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this FirmExits.
	
	 * @return String
	 */
	public String toString() {
		return "FirmExits[" +jobDestruction+", "+establishmentExit+", "+count+"]";
	}
	
	/**
	 * Internal constructor to create a FirmExits from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public FirmExits(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Job Destruction
            this.jobDestruction = ((Number)json_data.get("Job Destruction")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FirmExits; the field jobDestruction was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FirmExits; the field jobDestruction had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Establishment Exit
            this.establishmentExit = ((Number)json_data.get("Establishment Exit")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FirmExits; the field establishmentExit was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FirmExits; the field establishmentExit had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Count
            this.count = ((Number)json_data.get("Count")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FirmExits; the field count was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FirmExits; the field count had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}