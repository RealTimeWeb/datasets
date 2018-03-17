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
    private String ownership;
    private String name;
    private String phoneNumber;
    private String emergencyServices;
    
    
    /**
     * 
     * @return String
     */
    public String getType() {
        return this.type;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getOwnership() {
        return this.ownership;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getEmergencyServices() {
        return this.emergencyServices;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Information.
	
	 * @return String
	 */
	public String toString() {
		return "Information[" +type+", "+ownership+", "+name+", "+phoneNumber+", "+emergencyServices+"]";
	}
	
	/**
	 * Internal constructor to create a Information from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Information(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Type
            this.type = (String)json_data.get("Type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Information; the field type was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Information; the field type had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Ownership
            this.ownership = (String)json_data.get("Ownership");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Information; the field ownership was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Information; the field ownership had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Name
            this.name = (String)json_data.get("Name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Information; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Information; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Phone Number
            this.phoneNumber = (String)json_data.get("Phone Number");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Information; the field phoneNumber was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Information; the field phoneNumber had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Emergency Services
            this.emergencyServices = (String)json_data.get("Emergency Services");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Information; the field emergencyServices was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Information; the field emergencyServices had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}