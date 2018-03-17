package corgis.hospitals.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.hospitals.domain.Location;
import corgis.hospitals.domain.OutpatientVolume;
import corgis.hospitals.domain.Information;

/**
 * 
 */
public class Hospital {
	
    private Location location;
    // Outpatient data for 2014.
    private OutpatientVolume outpatientVolume;
    private String providerId;
    private Information information;
    
    
    /**
     * 
     * @return Location
     */
    public Location getLocation() {
        return this.location;
    }
    
    
    
    /**
     * Outpatient data for 2014.
     * @return OutpatientVolume
     */
    public OutpatientVolume getOutpatientVolume() {
        return this.outpatientVolume;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getProviderId() {
        return this.providerId;
    }
    
    
    
    /**
     * 
     * @return Information
     */
    public Information getInformation() {
        return this.information;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Hospital.
	
	 * @return String
	 */
	public String toString() {
		return "Hospital[" +location+", "+outpatientVolume+", "+providerId+", "+information+"]";
	}
	
	/**
	 * Internal constructor to create a Hospital from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Hospital(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Location
            this.location = new Location((JSONObject)json_data.get("Location"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Hospital; the field location was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Hospital; the field location had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Outpatient Volume
            this.outpatientVolume = new OutpatientVolume((JSONObject)json_data.get("Outpatient Volume"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Hospital; the field outpatientVolume was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Hospital; the field outpatientVolume had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Provider ID
            this.providerId = (String)json_data.get("Provider ID");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Hospital; the field providerId was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Hospital; the field providerId had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Information
            this.information = new Information((JSONObject)json_data.get("Information"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Hospital; the field information was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Hospital; the field information had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}