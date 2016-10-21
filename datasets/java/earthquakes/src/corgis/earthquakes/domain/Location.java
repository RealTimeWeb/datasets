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
	
    // The rough distance that this earthquake occurred away from the reporting station, measured in degrees between. 1 degree is approximately 111.2 kilometers. In general, the smaller this number, the more reliable is the calculated depth of the earthquake. In general, this number is between 0.4-7.1.
    private Double distance;
    private String full;
    // A best guess for the name of the state (or country, in some cases) that this earthquake was reported in.
    private String name;
    // Decimal degrees longitude (east and west on the globe). Negative values for western latitudes. Ranges from -180 to 180.
    private Double longitude;
    // Depth of the event in kilometers.
    private Double depth;
    // Decimal degrees latitude (up and down on the globe). Negative values for southern latitudes. Ranges from -90 to 90.
    private Double latitude;
    
    
    /*
     * @return 
     */
    public Double getDistance() {
        return this.distance;
    }
    
    
    
    /*
     * @return 
     */
    public String getFull() {
        return this.full;
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
    public Double getLongitude() {
        return this.longitude;
    }
    
    
    
    /*
     * @return 
     */
    public Double getDepth() {
        return this.depth;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLatitude() {
        return this.latitude;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Location.
	
	 * @return String
	 */
	public String toString() {
		return "Location[" +distance+", "+full+", "+name+", "+longitude+", "+depth+", "+latitude+"]";
	}
	
	/**
	 * Internal constructor to create a Location from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Location(JSONObject json_data) {
        try {// distance
            this.distance = ((Number)json_data.get("distance")).doubleValue();// full
            this.full = (String)json_data.get("full");// name
            this.name = (String)json_data.get("name");// longitude
            this.longitude = ((Number)json_data.get("longitude")).doubleValue();// depth
            this.depth = ((Number)json_data.get("depth")).doubleValue();// latitude
            this.latitude = ((Number)json_data.get("latitude")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Location; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Location; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}