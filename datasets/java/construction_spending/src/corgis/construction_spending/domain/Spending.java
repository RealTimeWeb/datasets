package corgis.construction_spending.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.construction_spending.domain.Annual;
import corgis.construction_spending.domain.Current;
import corgis.construction_spending.domain.Time;

/**
 * 
 */
public class Spending {
	
    private Annual annual;
    private Current current;
    private Time time;
    
    
    /**
     * 
     * @return Annual
     */
    public Annual getAnnual() {
        return this.annual;
    }
    
    
    
    /**
     * 
     * @return Current
     */
    public Current getCurrent() {
        return this.current;
    }
    
    
    
    /**
     * 
     * @return Time
     */
    public Time getTime() {
        return this.time;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Spending.
	
	 * @return String
	 */
	public String toString() {
		return "Spending[" +annual+", "+current+", "+time+"]";
	}
	
	/**
	 * Internal constructor to create a Spending from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Spending(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // annual
            this.annual = new Annual((JSONObject)json_data.get("annual"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Spending; the field annual was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Spending; the field annual had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // current
            this.current = new Current((JSONObject)json_data.get("current"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Spending; the field current was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Spending; the field current had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // time
            this.time = new Time((JSONObject)json_data.get("time"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Spending; the field time was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Spending; the field time had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}