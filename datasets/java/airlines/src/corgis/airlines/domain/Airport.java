package corgis.airlines.domain;

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
public class Airport {
	
    // The 3 letter code for this airport, assigned by IATA. For more information, consult this <a href='https://en.wikipedia.org/wiki/List_of_airports_by_IATA_code'>List of Airport Codes</a>.
    private String code;
    // The full name of this airport.
    private String name;
    
    
    /**
     * The 3 letter code for this airport, assigned by IATA. For more information, consult this <a href='https://en.wikipedia.org/wiki/List_of_airports_by_IATA_code'>List of Airport Codes</a>.
     * @return String
     */
    public String getCode() {
        return this.code;
    }
    
    
    
    /**
     * The full name of this airport.
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Airport.
	
	 * @return String
	 */
	public String toString() {
		return "Airport[" +code+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a Airport from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Airport(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Code
            this.code = (String)json_data.get("Code");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Airport; the field code was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Airport; the field code had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Name
            this.name = (String)json_data.get("Name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Airport; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Airport; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}