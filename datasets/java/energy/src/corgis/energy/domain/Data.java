package corgis.energy.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.energy.domain.Imports;
import corgis.energy.domain.Exports;
import corgis.energy.domain.Production;
import corgis.energy.domain.Consumption;

/**
 * 
 */
public class Data {
	
    private Imports imports;
    private Exports exports;
    private Production production;
    private Consumption consumption;
    
    
    /*
     * @return 
     */
    public Imports getImports() {
        return this.imports;
    }
    
    
    
    /*
     * @return 
     */
    public Exports getExports() {
        return this.exports;
    }
    
    
    
    /*
     * @return 
     */
    public Production getProduction() {
        return this.production;
    }
    
    
    
    /*
     * @return 
     */
    public Consumption getConsumption() {
        return this.consumption;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +imports+", "+exports+", "+production+", "+consumption+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// imports
            this.imports = new Imports((JSONObject)json_data.get("imports"));// exports
            this.exports = new Exports((JSONObject)json_data.get("exports"));// production
            this.production = new Production((JSONObject)json_data.get("production"));// consumption
            this.consumption = new Consumption((JSONObject)json_data.get("consumption"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}