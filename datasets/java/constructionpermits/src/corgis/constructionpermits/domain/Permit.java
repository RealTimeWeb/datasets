package corgis.constructionpermits.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.constructionpermits.domain.Period;

/**
 * 
 */
public class Permit {
	
    private Period period;
    private ArrayList<Locations> locations;
    
    
    /*
     * @return 
     */
    public Period getPeriod() {
        return this.period;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<Locations> getLocations() {
        return this.locations;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Permit.
	
	 * @return String
	 */
	public String toString() {
		return "Permit[" +period+", "+locations+"]";
	}
	
	/**
	 * Internal constructor to create a Permit from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Permit(JSONObject json_data) {
        try {// period
            this.period = new Period((JSONObject)json_data.get("period"));// locations
            this.locations = new ArrayList<Locations>();
            Iterator<Object> locationsIter = ((List<Object>)json_data.get("locations")).iterator();
            while (locationsIter.hasNext()) {
                this.locations.add(new Locations((JSONObject)locationsIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Permit; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Permit; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}