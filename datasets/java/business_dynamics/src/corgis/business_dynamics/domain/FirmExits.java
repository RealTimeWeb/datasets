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
	
    // The number of firms that exited this year.
    private Integer count;
    // The number of establishments exited because of firm deaths.
    private Integer establishmentExit;
    // The number of jobs destroyed as a result of firm deaths.
    private Integer jobDestruction;
    
    
    /*
     * @return 
     */
    public Integer getCount() {
        return this.count;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEstablishmentExit() {
        return this.establishmentExit;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getJobDestruction() {
        return this.jobDestruction;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this FirmExits.
	
	 * @return String
	 */
	public String toString() {
		return "FirmExits[" +count+", "+establishmentExit+", "+jobDestruction+"]";
	}
	
	/**
	 * Internal constructor to create a FirmExits from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public FirmExits(JSONObject json_data) {
        try {// Count
            this.count = ((Number)json_data.get("Count")).intValue();// Establishment Exit
            this.establishmentExit = ((Number)json_data.get("Establishment Exit")).intValue();// Job Destruction
            this.jobDestruction = ((Number)json_data.get("Job Destruction")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FirmExits; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FirmExits; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}