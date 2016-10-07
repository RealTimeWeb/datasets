package corgis.horse_racing.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.horse_racing.domain.Date;
import corgis.horse_racing.domain.Races;

/**
 * 
 */
public class Race {
	
    private Date date;
    private Races races;
    
    
    /*
     * @return 
     */
    public Date getDate() {
        return this.date;
    }
    
    
    
    /*
     * @return 
     */
    public Races getRaces() {
        return this.races;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Race.
	
	 * @return String
	 */
	public String toString() {
		return "Race[" +date+", "+races+"]";
	}
	
	/**
	 * Internal constructor to create a Race from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Race(JSONObject json_data) {
        try {// date
            this.date = new Date((JSONObject)json_data.get("date"));// races
            this.races = new Races((JSONObject)json_data.get("races"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Race; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Race; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}