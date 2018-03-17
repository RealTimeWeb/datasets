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
public class Location {
	
    private String county;
    private Double longitude;
    private String zipCode;
    private Double latitude;
    private String state;
    private String address;
    private String city;
    
    
    /**
     * 
     * @return String
     */
    public String getCounty() {
        return this.county;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getLongitude() {
        return this.longitude;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getZipCode() {
        return this.zipCode;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getLatitude() {
        return this.latitude;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getState() {
        return this.state;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getAddress() {
        return this.address;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getCity() {
        return this.city;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Location.
	
	 * @return String
	 */
	public String toString() {
		return "Location[" +county+", "+longitude+", "+zipCode+", "+latitude+", "+state+", "+address+", "+city+"]";
	}
	
	/**
	 * Internal constructor to create a Location from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Location(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // County
            this.county = (String)json_data.get("County");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field county was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field county had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Longitude
            this.longitude = ((Number)json_data.get("Longitude")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field longitude was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field longitude had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // ZIP Code
            this.zipCode = (String)json_data.get("ZIP Code");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field zipCode was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field zipCode had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Latitude
            this.latitude = ((Number)json_data.get("Latitude")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field latitude was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field latitude had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // State
            this.state = (String)json_data.get("State");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field state was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field state had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Address
            this.address = (String)json_data.get("Address");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field address was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field address had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // City
            this.city = (String)json_data.get("City");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field city was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field city had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}