package corgis.real_estate.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.real_estate.domain.Disabilities;
import corgis.real_estate.domain.History;

/**
 * 
 */
public class Data {
	
    private String status;
    private Disabilities disabilities;
    private String parkingSpaces;
    private String ownedOrLeased;
    private String date;
    private String type;
    private History history;
    
    
    /*
     * @return 
     */
    public String getStatus() {
        return this.status;
    }
    
    
    
    /*
     * @return 
     */
    public Disabilities getDisabilities() {
        return this.disabilities;
    }
    
    
    
    /*
     * @return 
     */
    public String getParkingSpaces() {
        return this.parkingSpaces;
    }
    
    
    
    /*
     * @return 
     */
    public String getOwnedOrLeased() {
        return this.ownedOrLeased;
    }
    
    
    
    /*
     * @return 
     */
    public String getDate() {
        return this.date;
    }
    
    
    
    /*
     * @return 
     */
    public String getType() {
        return this.type;
    }
    
    
    
    /*
     * @return 
     */
    public History getHistory() {
        return this.history;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +status+", "+disabilities+", "+parkingSpaces+", "+ownedOrLeased+", "+date+", "+type+", "+history+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// status
            this.status = (String)json_data.get("status");// disabilities
            this.disabilities = new Disabilities((JSONObject)json_data.get("disabilities"));// parking spaces
            this.parkingSpaces = (String)json_data.get("parking spaces");// owned or leased
            this.ownedOrLeased = (String)json_data.get("owned or leased");// date
            this.date = (String)json_data.get("date");// type
            this.type = (String)json_data.get("type");// history
            this.history = new History((JSONObject)json_data.get("history"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}