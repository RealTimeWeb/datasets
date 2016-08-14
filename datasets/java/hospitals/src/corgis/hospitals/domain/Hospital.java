package corgis.hospitals.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.hospitals.domain.Information;
import corgis.hospitals.domain.OutpatientVolume;
import corgis.hospitals.domain.Location;

/**
 * 
 */
public class Hospital {
	
    private Information information;
    // Outpatient data for 2014.
    private OutpatientVolume outpatientVolume;
    private String providerId;
    private Location location;
    
    
    /*
     * @return 
     */
    public Information getInformation() {
        return this.information;
    }
    
    
    
    /*
     * @return 
     */
    public OutpatientVolume getOutpatientVolume() {
        return this.outpatientVolume;
    }
    
    
    
    /*
     * @return 
     */
    public String getProviderId() {
        return this.providerId;
    }
    
    
    
    /*
     * @return 
     */
    public Location getLocation() {
        return this.location;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Hospital.
	
	 * @return String
	 */
	public String toString() {
		return "Hospital[" +information+", "+outpatientVolume+", "+providerId+", "+location+"]";
	}
	
	/**
	 * Internal constructor to create a Hospital from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Hospital(JSONObject json_data) {
        try {// Information
            this.information = new Information((JSONObject)json_data.get("Information"));// Outpatient Volume
            this.outpatientVolume = new OutpatientVolume((JSONObject)json_data.get("Outpatient Volume"));// Provider ID
            this.providerId = (String)json_data.get("Provider ID");// Location
            this.location = new Location((JSONObject)json_data.get("Location"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Hospital; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Hospital; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}