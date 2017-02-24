package corgis.energy.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.energy.domain.Consumption;
import corgis.energy.domain.Price;
import corgis.energy.domain.Production;
import corgis.energy.domain.Expenditure;

/**
 * 
 */
public class Report {
	
    private Consumption consumption;
    private Price price;
    // The state that this report was made for.
    private String state;
    private Production production;
    private Expenditure expenditure;
    // The year that this report was made.
    private Integer year;
    
    
    /*
     * @return 
     */
    public Consumption getConsumption() {
        return this.consumption;
    }
    
    
    
    /*
     * @return 
     */
    public Price getPrice() {
        return this.price;
    }
    
    
    
    /*
     * @return 
     */
    public String getState() {
        return this.state;
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
    public Expenditure getExpenditure() {
        return this.expenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Report.
	
	 * @return String
	 */
	public String toString() {
		return "Report[" +consumption+", "+price+", "+state+", "+production+", "+expenditure+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Report from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Report(JSONObject json_data) {
        try {// Consumption
            this.consumption = new Consumption((JSONObject)json_data.get("Consumption"));// Price
            this.price = new Price((JSONObject)json_data.get("Price"));// State
            this.state = (String)json_data.get("State");// Production
            this.production = new Production((JSONObject)json_data.get("Production"));// Expenditure
            this.expenditure = new Expenditure((JSONObject)json_data.get("Expenditure"));// Year
            this.year = ((Number)json_data.get("Year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}