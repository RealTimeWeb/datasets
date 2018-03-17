package corgis.earthquakes.domain;

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
	
    // Decimal degrees longitude (east and west on the globe). Negative values for western latitudes. Ranges from -180 to 180.
    private Double longitude;
    // Depth of the event in kilometers.
    private Double depth;
    // A best guess for the name of the state (or country, in some cases) that this earthquake was reported in.
    private String name;
    // The rough distance that this earthquake occurred away from the reporting station, measured in degrees between. 1 degree is approximately 111.2 kilometers. In general, the smaller this number, the more reliable is the calculated depth of the earthquake. In general, this number is between 0.4-7.1.
    private Double distance;
    // Decimal degrees latitude (up and down on the globe). Negative values for southern latitudes. Ranges from -90 to 90.
    private Double latitude;
    private String full;
    
    
    /**
     * Decimal degrees longitude (east and west on the globe). Negative values for western latitudes. Ranges from -180 to 180.
     * @return Double
     */
    public Double getLongitude() {
        return this.longitude;
    }
    
    
    
    /**
     * Depth of the event in kilometers.
     * @return Double
     */
    public Double getDepth() {
        return this.depth;
    }
    
    
    
    /**
     * A best guess for the name of the state (or country, in some cases) that this earthquake was reported in.
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /**
     * The rough distance that this earthquake occurred away from the reporting station, measured in degrees between. 1 degree is approximately 111.2 kilometers. In general, the smaller this number, the more reliable is the calculated depth of the earthquake. In general, this number is between 0.4-7.1.
     * @return Double
     */
    public Double getDistance() {
        return this.distance;
    }
    
    
    
    /**
     * Decimal degrees latitude (up and down on the globe). Negative values for southern latitudes. Ranges from -90 to 90.
     * @return Double
     */
    public Double getLatitude() {
        return this.latitude;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getFull() {
        return this.full;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Location.
	
	 * @return String
	 */
	public String toString() {
		return "Location[" +longitude+", "+depth+", "+name+", "+distance+", "+latitude+", "+full+"]";
	}
	
	/**
	 * Internal constructor to create a Location from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Location(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // longitude
            this.longitude = ((Number)json_data.get("longitude")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field longitude was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field longitude had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // depth
            this.depth = ((Number)json_data.get("depth")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field depth was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field depth had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // distance
            this.distance = ((Number)json_data.get("distance")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field distance was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field distance had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // latitude
            this.latitude = ((Number)json_data.get("latitude")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field latitude was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field latitude had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // full
            this.full = (String)json_data.get("full");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; the field full was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; the field full had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}