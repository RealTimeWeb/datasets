package corgis.hospitals.domain;

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
public class Information {
	
    private String type;
    private String phoneNumber;
    private String emergencyServices;
    private String name;
    private String ownership;
    
    
    /*
     * @return 
     */
    public String getType() {
        return this.type;
    }
    
    
    
    /*
     * @return 
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    
    
    /*
     * @return 
     */
    public String getEmergencyServices() {
        return this.emergencyServices;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /*
     * @return 
     */
    public String getOwnership() {
        return this.ownership;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Information.
	
	 * @return String
	 */
	public String toString() {
		return "Information[" +type+", "+phoneNumber+", "+emergencyServices+", "+name+", "+ownership+"]";
	}
	
	/**
	 * Internal constructor to create a Information from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Information(JSONObject json_data) {
        try {// Type
            this.type = (String)json_data.get("Type");// Phone Number
            this.phoneNumber = (String)json_data.get("Phone Number");// Emergency Services
            this.emergencyServices = (String)json_data.get("Emergency Services");// Name
            this.name = (String)json_data.get("Name");// Ownership
            this.ownership = (String)json_data.get("Ownership");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Information; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Information; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}