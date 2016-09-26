package corgis.construction_permits.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.construction_permits.domain.NumberOfPermits;
import corgis.construction_permits.domain.Valuations;

/**
 * 
 */
public class Locations {
	
    private NumberOfPermits numberOfPermits;
    private String name;
    private Valuations valuations;
    private String level;
    
    
    /*
     * @return 
     */
    public NumberOfPermits getNumberOfPermits() {
        return this.numberOfPermits;
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
    public Valuations getValuations() {
        return this.valuations;
    }
    
    
    
    /*
     * @return 
     */
    public String getLevel() {
        return this.level;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Locations.
	
	 * @return String
	 */
	public String toString() {
		return "Locations[" +numberOfPermits+", "+name+", "+valuations+", "+level+"]";
	}
	
	/**
	 * Internal constructor to create a Locations from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Locations(JSONObject json_data) {
        try {// # of permits
            this.numberOfPermits = new NumberOfPermits((JSONObject)json_data.get("# of permits"));// name
            this.name = (String)json_data.get("name");// valuations
            this.valuations = new Valuations((JSONObject)json_data.get("valuations"));// level
            this.level = (String)json_data.get("level");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Locations; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Locations; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}