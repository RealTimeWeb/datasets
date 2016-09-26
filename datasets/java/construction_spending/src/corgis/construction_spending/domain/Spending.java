package corgis.construction_spending.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.construction_spending.domain.Current;
import corgis.construction_spending.domain.Annual;
import corgis.construction_spending.domain.Time;

/**
 * 
 */
public class Spending {
	
    private Current current;
    private Annual annual;
    private Time time;
    
    
    /*
     * @return 
     */
    public Current getCurrent() {
        return this.current;
    }
    
    
    
    /*
     * @return 
     */
    public Annual getAnnual() {
        return this.annual;
    }
    
    
    
    /*
     * @return 
     */
    public Time getTime() {
        return this.time;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Spending.
	
	 * @return String
	 */
	public String toString() {
		return "Spending[" +current+", "+annual+", "+time+"]";
	}
	
	/**
	 * Internal constructor to create a Spending from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Spending(JSONObject json_data) {
        try {// current
            this.current = new Current((JSONObject)json_data.get("current"));// annual
            this.annual = new Annual((JSONObject)json_data.get("annual"));// time
            this.time = new Time((JSONObject)json_data.get("time"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Spending; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Spending; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}