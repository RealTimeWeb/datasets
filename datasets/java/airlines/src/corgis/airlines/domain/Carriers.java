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
public class Carriers {
	
    // The number of carriers that reported flight information during this time period and at this location.
    private Integer total;
    // The full names of the carriers that reported in.
    private ArrayList<String> names;
    
    
    /*
     * @return 
     */
    public Integer getTotal() {
        return this.total;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<String> getNames() {
        return this.names;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Carriers.
	
	 * @return String
	 */
	public String toString() {
		return "Carriers[" +total+", "+names+"]";
	}
	
	/**
	 * Internal constructor to create a Carriers from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Carriers(JSONObject json_data) {
        try {// Total
            this.total = ((Number)json_data.get("Total")).intValue();// Names
            this.names = new ArrayList<String>();
            Iterator<Object> namesIter = ((List<Object>)json_data.get("Names")).iterator();
            while (namesIter.hasNext()) {
                this.names.add(new String((String)namesIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Carriers; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Carriers; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}